/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.sql.*;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import DTO.Sach;
import DTO.TTPhieuMuon;
import DTO.TheLoai;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Magic 28-9-2021 Viết cho đồ án JAVA
 */
public class MY_HANDLE {

    private MY_HANDLE_CONNECTION db;
    public List<DocGia> DOCGIALIST;
    public List<Sach> SACHLIST;
    public List<TTPhieuMuon> PHIEUMUONLIST;
    public List<TheLoai> THELOAILIST;
    public Map<Integer, String> MAPTHELOAI = new HashMap<Integer, String>();
    public String MD5Hash(String input) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        byte[] result = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String ten, mail, tendn;
    private String mk;

    public MY_HANDLE() {
        DOCGIALIST = new ArrayList<DocGia>();
        SACHLIST = new ArrayList<Sach>();
        PHIEUMUONLIST=new ArrayList<TTPhieuMuon>();
        THELOAILIST= new ArrayList<TheLoai>();
    }

    public boolean CheckPass(String pass) {
        if (mk.equals(MD5Hash(pass))) {
            return true;
        }
        return false;
    }

    public boolean DoiMatKhau(String pass) throws SQLException {
        db = new MY_HANDLE_CONNECTION();
        String[] query = {"UPDATE TAIKHOAN SET MatKhau=? WHERE TenDangNhap=?", "", ""};
        query[1] = MD5Hash(pass);
        query[2] = tendn;

        if (db.RunQuery(query)) {
            return true;
        }
        return false;
    }

    public boolean KiemTraDangNhap(String username, String pass) throws Exception {
        db = new MY_HANDLE_CONNECTION();

        ResultSet rs = db.RunQuery("exec login " + username);
        rs.next();

        if (rs.getRow() > 0) {
            if (rs.getString(2).equals(MD5Hash(pass))) {
                mk = rs.getString(2);
                ten = rs.getString(3);
                mail = rs.getString(4);
                tendn = rs.getString(1);
                rs.close();
                db.Close();
                return true;
            }

        }
        rs.close();
        db.Close();
        return false;
    }

    public boolean KiemTraNhap(JTextField[] tb) {
        for (int i = 0; i < tb.length; i++) {
            if (!KiemTraNhap(tb[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean KiemTraNhap(JComponent tb) {
        for (int i = 0; i < tb.getComponentCount(); i++) {
            if (tb.getComponent(i).getClass().equals(JTextField.class) && tb.getComponent(i).getName() != null) {
                JTextField tx = (JTextField) tb.getComponent(i);
                if (!KiemTraNhap(tx)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean KiemTraNhap(JTextField tb) {

        if (tb.getText().trim().isEmpty() || tb.getText().trim().isBlank()) {
            tb.requestFocus();
            return false;
        }
        return true;
    }

    /**
     * hàm này để lấy ra mã thể loại từ tên thể loại
     *
     * @author Magic
     */
    public Integer getKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return -1;
    }

//    public void ClearTextBox(JTextField[] tb) {
//        for (int i = 0; i < tb.length; i++) {
//            tb[i].setText("");
//        }
//        
//    }
    public void ClearTextBox(JComponent pn) {
        for (int i = 0; i < pn.getComponentCount(); i++) {
            if (pn.getComponent(i).getClass().equals(JTextField.class)) {
                JTextField tx = (JTextField) pn.getComponent(i);
                tx.setText("");
            }
        }
    }
}