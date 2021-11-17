/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import DTO.Sach;
import DTO.TTPhieuMuon;
import DTO.TheLoai;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;

/**
 *
 * @author Magic
 */
public class fMain1 extends javax.swing.JFrame {

    /**
     * Creates new form fMain
     */
    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fDangNhap f;
    private fDoiMatKhau fDMK;
    private List<Color> colors;
    private JInternalFrame fhere;
    private Color panedaefau;
    private Color paneclick;

    public fMain1() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);

        db = new MY_HANDLE_CONNECTION();
        HANDLE = new MY_HANDLE();

        LoadAllData();

        //Combobox_load();
//        LoadPanelSach();
//        LoadAfterCreatePM();
//        LoadPannelDocGia();
//        EnablePnTTSach(false);
        fhere = new fQLSACH(this, HANDLE);
        pnDesktop.add(fhere).setVisible(true);
        colors = new ArrayList<Color>();
        colors.add(new Color(60, 83, 60));
        colors.add(new Color(101, 123, 97));
        colors.add(new Color(141, 161, 132));

        panedaefau = new Color(77, 100, 141);
        paneclick = new Color(146, 136, 126);
        this.getContentPane().setBackground(new Color(30, 31, 38));//[30,31,38]210,225,230

        //LoadAllData();
    }

// <editor-fold defaultstate="collapsed" desc="Load tất cả mọi thứ"> 
    private void LoadAllData() {
        LoadSach();
        LoadDocGia();
        LoadPhieuMuon();
        LoadTheLoai();
    }
//    private void LoadPanelSach() {
//        LayBangSach("Select * from Sach");
//        LayBangTheLoai("Select * from TheLoai");
//
//
//        
//        tbMaSach.setEnabled(false);
//        LockPnTTSach(true);
//
//        tableDSS.setEnabled(true);
//        tableTheLoai.setEnabled(true);
//        PANNELSACHENABLE = true;
//
//        btXoa.setText("Xoa");
//        btThem.setVisible(true);
//        btSua.setVisible(true);
//        btSua.setText("Sua");
//        btThem.setText("Them");
//        HANDLE.ClearTextBox(pnTTSach);
//        CHONSACH = -1;
//    }
//
//    private void LoadPannelDocGia() {
//        LayBangDG("select * from DOCGIA");
//        LockPnTTDG(true);
//
//        tableDSDG.setEnabled(true);
//        btXoaDG.setText("Xoa");
//
//        btThemDG.setVisible(true);
//        btSuaDG.setVisible(true);
//        //btTimKiemSach.setEnabled(true);
//        btSuaDG.setText("Sua");
//        btThemDG.setText("Them");
//        HANDLE.ClearTextBox(pnTTDG);
//        CHONDOCGIA = -1;
//    }
//
//    public void LoadAfterCreatePM() {
//        LayBangPhieuMuon("select SoPhieuMuon,NgayMuon,NgayHenTra,NgayTraThucTe,TenDocGia,SoLuongMuon from PHIEUMUON,DOCGIA where DOCGIA.MaDocGia=PHIEUMUON.MaDocGia");
//        btTraSach.setVisible(false);
//        LayBangSach("Select * from Sach");
////        tbMaSach.setEnabled(false);
////        KhoáNhập(true);
////
////        tableDSS.setEnabled(true);
////        btXoa.setText("Xoa");
////        btThem.setVisible(true);
////        btSua.setVisible(true);
////        btTimKiem.setEnabled(true);
////        btSua.setText("Sua");
////        btThem.setText("Them");
////        xửlý.XoáTextBox(new JTextField[]{tbMaSach, tbSoluong, tbTImkiem, tbTacGia, tbTenSach, tbTomTat});
//        CHONPHIEUMUON = -1;
//    }
//
//    private void LoadPanelQTV() {
//        lbHoTenQTV.setText(HANDLE.ten);
//        lbEmainQTV.setText(HANDLE.mail);
//        pnTTQTV.setVisible(true);
//    }
//
//    /**
//     *
//     * @param b : nếu true thì khóa các textbox và ngược lại
//     */
//    private void LockPnTTSach(boolean b) {
//        tbTenSach.setEditable(!b);
//        cbbTheLoai.setEnabled(!b);
//        tbSoluong.setEditable(!b);
//        tbTomTat.setEditable(!b);
//        tbTacGia.setEditable(!b);
//    }
//
//    private void EnablePnTTSach(boolean b) {
//        btThem.setEnabled(b);
//        btXoa.setEnabled(b);
//        btSua.setEnabled(b);
//        tbTenSach.setEnabled(b);
//        tbSoluong.setEnabled(b);
//        tbTomTat.setEnabled(b);
//        tbTacGia.setEnabled(b);
//    }
//
//    private void LockPnTTDG(boolean b) {
//        tbTenDG.setEditable(!b);
//        tbDiaChi.setEditable(!b);
//        tbCMTDG.setEditable(!b);
//        tbSDTDG.setEditable(!b);
//    }
//
//    public void LoginOK() {
//        if (HANDLE.ten != null) {
//            TabbedPaneMain.setEnabled(true);
//            btDangNhap_DangXuat.setText("Đăng xuất");
//            LoadPanelQTV();
//            EnablePnTTSach(true);
//        }
//    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMenu = new javax.swing.JPanel();
        pnQLSach = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnQLDocGia = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        pnQLMuonTra = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        pnDesktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btDangNhap_DangXuat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(170, 201, 221));
        setUndecorated(true);
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        pnMenu.setBackground(new java.awt.Color(30, 45, 33));
        pnMenu.setBorder(new javax.swing.border.MatteBorder(null));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnQLSach.setBackground(new java.awt.Color(60, 83, 60));
        pnQLSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnQLSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQLSachMouseClicked(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bookmng.png"))); // NOI18N
        jLabel14.setText("  SÁCH");

        javax.swing.GroupLayout pnQLSachLayout = new javax.swing.GroupLayout(pnQLSach);
        pnQLSach.setLayout(pnQLSachLayout);
        pnQLSachLayout.setHorizontalGroup(
            pnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnQLSachLayout.setVerticalGroup(
            pnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
        );

        pnMenu.add(pnQLSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 250, -1));

        pnQLDocGia.setBackground(new java.awt.Color(101, 123, 97));
        pnQLDocGia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnQLDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQLDocGiaMouseClicked(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 204, 204));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/memmng.png"))); // NOI18N
        jLabel16.setText("  ĐỘC GIẢ");

        javax.swing.GroupLayout pnQLDocGiaLayout = new javax.swing.GroupLayout(pnQLDocGia);
        pnQLDocGia.setLayout(pnQLDocGiaLayout);
        pnQLDocGiaLayout.setHorizontalGroup(
            pnQLDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLDocGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnQLDocGiaLayout.setVerticalGroup(
            pnQLDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
        );

        pnMenu.add(pnQLDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 250, -1));

        pnQLMuonTra.setBackground(new java.awt.Color(141, 161, 132));
        pnQLMuonTra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnQLMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnQLMuonTraMouseClicked(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contractmng.png"))); // NOI18N
        jLabel17.setText("  MƯỢN/ TRẢ");

        javax.swing.GroupLayout pnQLMuonTraLayout = new javax.swing.GroupLayout(pnQLMuonTra);
        pnQLMuonTra.setLayout(pnQLMuonTraLayout);
        pnQLMuonTraLayout.setHorizontalGroup(
            pnQLMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnQLMuonTraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnQLMuonTraLayout.setVerticalGroup(
            pnQLMuonTraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, Short.MAX_VALUE)
        );

        pnMenu.add(pnQLMuonTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, -1));

        pnDesktop.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout pnDesktopLayout = new javax.swing.GroupLayout(pnDesktop);
        pnDesktop.setLayout(pnDesktopLayout);
        pnDesktopLayout.setHorizontalGroup(
            pnDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnDesktopLayout.setVerticalGroup(
            pnDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(30, 31, 38));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("  X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btDangNhap_DangXuat.setText("Đăng nhập");
        btDangNhap_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhap_DangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btDangNhap_DangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 995, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDangNhap_DangXuat))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(pnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnDesktop)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnDesktop))
                    .addComponent(pnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDangNhap_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhap_DangXuatActionPerformed
//        if (btDangNhap_DangXuat.getText().equals("Đăng nhập")) {
//            if (f == null) {
//                try {
//                    f = new fDangNhap(this, HANDLE);
//                } catch (SQLException ex) {
//                }
//                f.show();
//                f.setLocationRelativeTo(null);
//
//            } else {
//                f.show();
//            }
//        } else {
//            HANDLE.ten = null;
//            HANDLE.tendn = null;
//            HANDLE.mail = null;
//            if (fDMK != null) {
//                fDMK.dispose();
//            }
//            if (fThemPM != null) {
//                fThemPM.dispose();
//            }
//            LoadPanelQTV();
//            LoadPanelSach();
//            LoadPannelDocGia();
//            LoadAfterCreatePM();
//            //TabbedPaneMain.setEnabled(false);
//            //TabbedPaneMain.setSelectedIndex(0);
//
//            btDangNhap_DangXuat.setText("Đăng nhập");
//
//            EnablePnTTSach(false);
//        }
    }//GEN-LAST:event_btDangNhap_DangXuatActionPerformed

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        JOptionPane.showMessageDialog(rootPane, "resizeeeeeeeeeeeeeee par");

    }//GEN-LAST:event_formAncestorResized

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        fhere.setSize(pnDesktop.getWidth(), pnDesktop.getHeight());
    }//GEN-LAST:event_formComponentResized

    void OnlyOne(JPanel it) {
        for (int i = 0; i < pnMenu.getComponentCount(); i++) {
            JPanel pn = (JPanel) pnMenu.getComponent(i);
            pn.setBackground(colors.get(i));
        }
        it.setBackground(paneclick);
    }
    private void pnQLSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLSachMouseClicked
        OnlyOne(pnQLSach);

        try {
            fhere = new fQLSACH(this, HANDLE);
            fhere.setSize(pnDesktop.getWidth(), pnDesktop.getHeight());
        } catch (SQLException ex) {

        }

        pnDesktop.removeAll();
        pnDesktop.add(fhere).setVisible(true);

    }//GEN-LAST:event_pnQLSachMouseClicked

    private void pnQLDocGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLDocGiaMouseClicked
        OnlyOne(pnQLDocGia);

        try {
            fhere = new fQLDOCGIA(this, HANDLE);
            fhere.setSize(pnDesktop.getWidth(), pnDesktop.getHeight());
        } catch (SQLException ex) {

        }

        pnDesktop.removeAll();
        pnDesktop.add(fhere).setVisible(true);
    }//GEN-LAST:event_pnQLDocGiaMouseClicked

    private void pnQLMuonTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnQLMuonTraMouseClicked
        OnlyOne(pnQLMuonTra);

        try {
            fhere = new fQLMUONTRA(this, HANDLE);
            fhere.setSize(pnDesktop.getWidth(), pnDesktop.getHeight());
        } catch (SQLException ex) {

        }

        pnDesktop.removeAll();
        pnDesktop.add(fhere).setVisible(true);
    }//GEN-LAST:event_pnQLMuonTraMouseClicked

    private int x, y;
    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int xx = evt.getXOnScreen();
        int yy = evt.getYOnScreen();
        this.setLocation(xx - x - 255, yy - y);
    }//GEN-LAST:event_jPanel1MouseDragged


    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.

            if (this.getExtendedState() == 6) {
                //JOptionPane.showMessageDialog(rootPane, "full");
                this.setExtendedState(JFrame.NORMAL);
            } else {
                this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //JOptionPane.showMessageDialog(rootPane, ""+this.getExtendedState());
        if (JOptionPane.showConfirmDialog(null, "Ban co muon thoat", "Chú ý", YES_NO_OPTION) == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    public void LoadDocGia() {
        HANDLE.DOCGIALIST.clear();
        System.out.println("UI.fMain1.LoadDocGia()");
        try {
            ResultSet rs = db.RunQuery("select * from DOCGIA");
            while (rs.next()) {
                DocGia DG = new DocGia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                HANDLE.DOCGIALIST.add(DG);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu DG:\n" + ex.getMessage());
        }
    }

    public void LoadSach() {
        HANDLE.SACHLIST.clear();
        HANDLE.MAPTHELOAI.clear();
        try {
            ResultSet rs = db.RunQuery("select * from SACH");
            while (rs.next()) {
                Sach s = new Sach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
                HANDLE.SACHLIST.add(s);
            }
            ResultSet rstl = db.RunQuery("select MaTheLoai,TenTheLoai from THELOAI");
            while (rstl.next()) {
                HANDLE.MAPTHELOAI.put(rstl.getString(1), rstl.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu Sach:\n" + ex.getMessage());
        }
    }

    private void LoadTheLoai() {
        HANDLE.THELOAILIST.clear();
        try {
            ResultSet rs = db.RunQuery("Select * from TheLoai");
            while (rs.next()) {
                TheLoai tl = new TheLoai(rs.getString(1), rs.getString(2));
                HANDLE.THELOAILIST.add(tl);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay the loai:\n" + e.getMessage());
        }
    }

    public void LoadPhieuMuon() {
        HANDLE.PHIEUMUONLIST.clear();
        try {
            ResultSet rs = db.RunQuery("select SoPhieuMuon,NgayMuon,NgayHenTra,NgayTraThucTe,TenDocGia,SoLuongMuon,PHIEUMUON.MaDocGia from PHIEUMUON,DOCGIA where DOCGIA.MaDocGia=PHIEUMUON.MaDocGia");
            while (rs.next()) {
                TTPhieuMuon tt = new TTPhieuMuon(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                HANDLE.PHIEUMUONLIST.add(tt);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu phieu muon:\n" + ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Click vào đây là project ko chạy được !!!"> 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
 /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMain1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fMain1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fMain1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangNhap_DangXuat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JDesktopPane pnDesktop;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnQLDocGia;
    private javax.swing.JPanel pnQLMuonTra;
    private javax.swing.JPanel pnQLSach;
    // End of variables declaration//GEN-END:variables
} //</editor-fold>
