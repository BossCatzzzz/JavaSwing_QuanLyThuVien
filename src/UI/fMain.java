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
import java.awt.Color;
import java.awt.Dialog;
import java.beans.DesignMode;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class fMain extends javax.swing.JFrame {

    /**
     * Creates new form fMain
     */
    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fDangNhap f;
    private fThemPhieuMuon fThemPM;
    private boolean PANNELSACHENABLE = true;
    public Map<Integer, String> MAPTHELOAI = new HashMap<Integer, String>();

    public fMain() throws SQLException {
        initComponents();
        
        this.setLocationRelativeTo(null);
        TabbedPaneMain.setEnabled(false);
        pnTTQTV.setVisible(false);
        db = new MY_HANDLE_CONNECTION();
        HANDLE = new MY_HANDLE();
        Combobox_load();
        LoadPanelSach();
        LoadAfterCreatePM();
        LoadPannelDocGia();
        EnablePnTTSach(false);

        tbTImkiemSach.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                search();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                search();
            }
        });
        //this.getContentPane().setBackground(Color.BLACK);
        //this.setBackground(Color.yellow);
        //TabbedPaneMain.setTitleAt(0, "<html><h1 style=\\\"color:red\">Quản lý sách </h1></html>");
    }

    public void search() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        for (Sach item : HANDLE.SACHLIST) {
            if (item.SearchOnAll(tbTImkiemSach.getText())) {
                model.addRow(item.ToListString());
            }
        }
    }

// <editor-fold defaultstate="collapsed" desc="Load tất cả mọi thứ"> 
    private void LoadPanelSach() {
        LayBangSach("Select * from Sach");
        LayBangTheLoai("Select * from TheLoai");


        
        tbMaSach.setEnabled(false);
        LockPnTTSach(true);

        tableDSS.setEnabled(true);
        tableTheLoai.setEnabled(true);
        PANNELSACHENABLE = true;

        btXoa.setText("Xoa");
        btThem.setVisible(true);
        btSua.setVisible(true);
        btSua.setText("Sua");
        btThem.setText("Them");
        HANDLE.ClearTextBox(pnTTSach);
        CHONSACH = -1;
    }

    private void LoadPannelDocGia() {
        LayBangDG("select * from DOCGIA");
        LockPnTTDG(true);

        tableDSDG.setEnabled(true);
        btXoaDG.setText("Xoa");

        btThemDG.setVisible(true);
        btSuaDG.setVisible(true);
        //btTimKiemSach.setEnabled(true);
        btSuaDG.setText("Sua");
        btThemDG.setText("Them");
        HANDLE.ClearTextBox(pnTTDG);
        CHONDOCGIA = -1;
    }

    public void LoadAfterCreatePM() {
        LayBangPhieuMuon("select SoPhieuMuon,NgayMuon,NgayHenTra,NgayTraThucTe,TenDocGia,SoLuongMuon from PHIEUMUON,DOCGIA where DOCGIA.MaDocGia=PHIEUMUON.MaDocGia");
        btTraSach.setVisible(false);
        LayBangSach("Select * from Sach");
//        tbMaSach.setEnabled(false);
//        KhoáNhập(true);
//
//        tableDSS.setEnabled(true);
//        btXoa.setText("Xoa");
//        btThem.setVisible(true);
//        btSua.setVisible(true);
//        btTimKiem.setEnabled(true);
//        btSua.setText("Sua");
//        btThem.setText("Them");
//        xửlý.XoáTextBox(new JTextField[]{tbMaSach, tbSoluong, tbTImkiem, tbTacGia, tbTenSach, tbTomTat});
        CHONPHIEUMUON = -1;
    }

    private void LoadPanelQTV() {
        lbHoTenQTV.setText(HANDLE.ten);
        lbEmainQTV.setText(HANDLE.mail);
        pnTTQTV.setVisible(true);
    }

    /**
     *
     * @param b : nếu true thì khóa các textbox và ngược lại
     */
    private void LockPnTTSach(boolean b) {
        tbTenSach.setEditable(!b);
        cbbTheLoai.setEnabled(!b);
        tbSoluong.setEditable(!b);
        tbTomTat.setEditable(!b);
        tbTacGia.setEditable(!b);
    }

    private void EnablePnTTSach(boolean b) {
        btThem.setEnabled(b);
        btXoa.setEnabled(b);
        btSua.setEnabled(b);
        tbTenSach.setEnabled(b);
        tbSoluong.setEnabled(b);
        tbTomTat.setEnabled(b);
        tbTacGia.setEnabled(b);
    }

    private void LockPnTTDG(boolean b) {
        tbTenDG.setEditable(!b);
        tbDiaChi.setEditable(!b);
        tbCMTDG.setEditable(!b);
        tbSDTDG.setEditable(!b);
    }

    public void LoginOK() {
        if (HANDLE.ten != null) {
            TabbedPaneMain.setEnabled(true);
            btDangNhap_DangXuat.setText("Đăng xuất");
            LoadPanelQTV();
            EnablePnTTSach(true);
        }
    }
    // </editor-fold>

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btDangNhap_DangXuat = new javax.swing.JButton();
        TabbedPaneMain = new javax.swing.JTabbedPane();
        tabpnSach = new javax.swing.JPanel();
        pnTTSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbMaSach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbTomTat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tbTacGia = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tbTenSach = new javax.swing.JTextField();
        cbbTheLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbSoluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();
        tbTImkiemSach = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTheLoai = new javax.swing.JTable();
        tabpnDocGia = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDSDG = new javax.swing.JTable();
        pnTTDG = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tbMaDG = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tbCMTDG = new javax.swing.JTextField();
        tbDiaChi = new javax.swing.JTextField();
        btThemDG = new javax.swing.JButton();
        btSuaDG = new javax.swing.JButton();
        btXoaDG = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tbTenDG = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tbSDTDG = new javax.swing.JTextField();
        tabpnPhieuMuon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePhieuMuon = new javax.swing.JTable();
        pnThongTinPhieuMuon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCTPM = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tbSo_PM = new javax.swing.JTextField();
        tbTenDG_PM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tbNgayMuon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tbNgayHen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbNgayTra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tbTImkiemPhieuMuon = new javax.swing.JTextField();
        btTimKiemPhieuMuon = new javax.swing.JButton();
        btThemPhieuMuon = new javax.swing.JButton();
        btTraSach = new javax.swing.JButton();
        tabpnQuanTriVien = new javax.swing.JPanel();
        pnTTQTV = new javax.swing.JPanel();
        lbHoTenQTV = new javax.swing.JLabel();
        lbEmainQTV = new javax.swing.JLabel();
        btDoiMatKhau = new javax.swing.JButton();
        pnMenu = new javax.swing.JPanel();
        pnQLSach = new javax.swing.JPanel();
        pnselectedQLSach = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        pnQLSach1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pnQLSach2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        pnDesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btDangNhap_DangXuat.setText("Đăng nhập");
        btDangNhap_DangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhap_DangXuatActionPerformed(evt);
            }
        });
        getContentPane().add(btDangNhap_DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 127, 40));

        TabbedPaneMain.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        TabbedPaneMain.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        TabbedPaneMain.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        tabpnSach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabpnSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tabpnSach.setOpaque(false);
        tabpnSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnTTSach.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Ma sach");

        tbMaSach.setEnabled(false);
        tbMaSach.setFocusable(false);

        jLabel5.setText("Tom tat");

        jLabel6.setText("Tac gia");

        btThem.setText("Them");
        btThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btThem.setMinimumSize(new java.awt.Dimension(72, 72));
        btThem.setName(""); // NOI18N
        btThem.setPreferredSize(new java.awt.Dimension(72, 72));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setText("Sua");
        btSua.setMaximumSize(new java.awt.Dimension(72, 72));
        btSua.setMinimumSize(new java.awt.Dimension(72, 72));
        btSua.setName(""); // NOI18N
        btSua.setPreferredSize(new java.awt.Dimension(72, 72));
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setText("Xoa");
        btXoa.setMaximumSize(new java.awt.Dimension(72, 72));
        btXoa.setMinimumSize(new java.awt.Dimension(72, 72));
        btXoa.setName(""); // NOI18N
        btXoa.setPreferredSize(new java.awt.Dimension(72, 72));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ten sach");

        tbTenSach.setName("ten"); // NOI18N

        jLabel3.setText("The loai");

        jLabel4.setText("So luong");

        tbSoluong.setName("sl"); // NOI18N

        javax.swing.GroupLayout pnTTSachLayout = new javax.swing.GroupLayout(pnTTSach);
        pnTTSach.setLayout(pnTTSachLayout);
        pnTTSachLayout.setHorizontalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnTTSachLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(42, 42, 42)
                            .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTomTat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        pnTTSachLayout.setVerticalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTSachLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tbTomTat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(225, Short.MAX_VALUE))
        );

        tabpnSach.add(pnTTSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, 501));

        tableDSS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên sách", "Còn lại", "Thể loại", "Tóm tắt", "Tác giả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDSSMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDSS);
        if (tableDSS.getColumnModel().getColumnCount() > 0) {
            tableDSS.getColumnModel().getColumn(0).setResizable(false);
            tableDSS.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableDSS.getColumnModel().getColumn(1).setResizable(false);
            tableDSS.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableDSS.getColumnModel().getColumn(2).setResizable(false);
            tableDSS.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableDSS.getColumnModel().getColumn(3).setResizable(false);
            tableDSS.getColumnModel().getColumn(4).setResizable(false);
            tableDSS.getColumnModel().getColumn(4).setPreferredWidth(200);
            tableDSS.getColumnModel().getColumn(5).setResizable(false);
        }

        tabpnSach.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 179, 501));
        tabpnSach.add(tbTImkiemSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 179, -1));

        tableTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableTheLoaiMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableTheLoai);
        if (tableTheLoai.getColumnModel().getColumnCount() > 0) {
            tableTheLoai.getColumnModel().getColumn(0).setResizable(false);
            tableTheLoai.getColumnModel().getColumn(1).setResizable(false);
            tableTheLoai.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        tabpnSach.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 21, 397, 208));

        TabbedPaneMain.addTab("<html><p class=\"left\" style=\"color:red; text-align:left;\">Quản lý sách</p></html>\n", new javax.swing.ImageIcon(getClass().getResource("/img/bookmng.png")), tabpnSach); // NOI18N

        tableDSDG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Địa chỉ", "Số ĐT", "CMND"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSDGMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableDSDG);
        if (tableDSDG.getColumnModel().getColumnCount() > 0) {
            tableDSDG.getColumnModel().getColumn(0).setResizable(false);
            tableDSDG.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableDSDG.getColumnModel().getColumn(1).setResizable(false);
            tableDSDG.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableDSDG.getColumnModel().getColumn(2).setResizable(false);
            tableDSDG.getColumnModel().getColumn(2).setPreferredWidth(200);
            tableDSDG.getColumnModel().getColumn(3).setResizable(false);
            tableDSDG.getColumnModel().getColumn(4).setResizable(false);
        }

        pnTTDG.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Mã độc giả");

        tbMaDG.setEditable(false);

        jLabel13.setText("Số CMT/ CCCD");

        tbCMTDG.setName("cmt"); // NOI18N

        tbDiaChi.setName("diachi"); // NOI18N

        btThemDG.setText("Them");
        btThemDG.setMaximumSize(new java.awt.Dimension(72, 72));
        btThemDG.setMinimumSize(new java.awt.Dimension(72, 72));
        btThemDG.setName(""); // NOI18N
        btThemDG.setPreferredSize(new java.awt.Dimension(72, 72));
        btThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemDGActionPerformed(evt);
            }
        });

        btSuaDG.setText("Sua");
        btSuaDG.setMaximumSize(new java.awt.Dimension(72, 72));
        btSuaDG.setMinimumSize(new java.awt.Dimension(72, 72));
        btSuaDG.setName(""); // NOI18N
        btSuaDG.setPreferredSize(new java.awt.Dimension(72, 72));
        btSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaDGActionPerformed(evt);
            }
        });

        btXoaDG.setText("Xoa");
        btXoaDG.setMaximumSize(new java.awt.Dimension(72, 72));
        btXoaDG.setMinimumSize(new java.awt.Dimension(72, 72));
        btXoaDG.setName(""); // NOI18N
        btXoaDG.setPreferredSize(new java.awt.Dimension(72, 72));
        btXoaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaDGActionPerformed(evt);
            }
        });

        jLabel15.setText("Tên độc giả");

        tbTenDG.setName("ten"); // NOI18N

        jLabel16.setText("Địa chỉ");

        jLabel17.setText("Sđt");

        tbSDTDG.setName("sdt"); // NOI18N

        javax.swing.GroupLayout pnTTDGLayout = new javax.swing.GroupLayout(pnTTDG);
        pnTTDG.setLayout(pnTTDGLayout);
        pnTTDGLayout.setHorizontalGroup(
            pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTDGLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnTTDGLayout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(42, 42, 42)
                            .addComponent(tbMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTDGLayout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbCMTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btXoaDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThemDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSuaDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        pnTTDGLayout.setVerticalGroup(
            pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTDGLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTDGLayout.createSequentialGroup()
                        .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tbMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tbTenDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnTTDGLayout.createSequentialGroup()
                        .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tbDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(tbSDTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(tbCMTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(pnTTDGLayout.createSequentialGroup()
                        .addComponent(btSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabpnDocGiaLayout = new javax.swing.GroupLayout(tabpnDocGia);
        tabpnDocGia.setLayout(tabpnDocGiaLayout);
        tabpnDocGiaLayout.setHorizontalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabpnDocGiaLayout.setVerticalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnTTDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap(392, Short.MAX_VALUE))
        );

        TabbedPaneMain.addTab("Độc giả", new javax.swing.ImageIcon(getClass().getResource("/img/memmng.png")), tabpnDocGia); // NOI18N

        tablePhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "So phieu", "Ten Doc gia", "Ngay muon", "Ngay hen tra", "Ngay tra", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePhieuMuon);
        if (tablePhieuMuon.getColumnModel().getColumnCount() > 0) {
            tablePhieuMuon.getColumnModel().getColumn(0).setResizable(false);
            tablePhieuMuon.getColumnModel().getColumn(1).setResizable(false);
            tablePhieuMuon.getColumnModel().getColumn(2).setResizable(false);
            tablePhieuMuon.getColumnModel().getColumn(3).setResizable(false);
            tablePhieuMuon.getColumnModel().getColumn(4).setResizable(false);
            tablePhieuMuon.getColumnModel().getColumn(5).setResizable(false);
        }

        pnThongTinPhieuMuon.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin phiếu mượn"));

        tableCTPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Danh sách sách mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCTPM.setAutoscrolls(false);
        jScrollPane3.setViewportView(tableCTPM);
        if (tableCTPM.getColumnModel().getColumnCount() > 0) {
            tableCTPM.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel7.setText("So phieu:");

        tbSo_PM.setEditable(false);

        tbTenDG_PM.setEditable(false);

        jLabel8.setText("Ten Doc gia:");

        tbNgayMuon.setEditable(false);

        jLabel9.setText("Ngay muon:");

        tbNgayHen.setEditable(false);

        jLabel10.setText("Ngay hen tra:");

        tbNgayTra.setEditable(false);

        jLabel11.setText("Ngay tra:");

        javax.swing.GroupLayout pnThongTinPhieuMuonLayout = new javax.swing.GroupLayout(pnThongTinPhieuMuon);
        pnThongTinPhieuMuon.setLayout(pnThongTinPhieuMuonLayout);
        pnThongTinPhieuMuonLayout.setHorizontalGroup(
            pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                        .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNgayHen, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbTenDG_PM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbSo_PM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        pnThongTinPhieuMuonLayout.setVerticalGroup(
            pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbSo_PM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tbTenDG_PM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tbNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tbNgayHen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tbNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btTimKiemPhieuMuon.setText("Search");
        btTimKiemPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimKiemPhieuMuonActionPerformed(evt);
            }
        });

        btThemPhieuMuon.setText("Thêm");
        btThemPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemPhieuMuonActionPerformed(evt);
            }
        });

        btTraSach.setText("Trả sách");
        btTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTraSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabpnPhieuMuonLayout = new javax.swing.GroupLayout(tabpnPhieuMuon);
        tabpnPhieuMuon.setLayout(tabpnPhieuMuonLayout);
        tabpnPhieuMuonLayout.setHorizontalGroup(
            tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btTimKiemPhieuMuon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btThemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(pnThongTinPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(btTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(174, 174, 174))))
        );
        tabpnPhieuMuonLayout.setVerticalGroup(
            tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btTimKiemPhieuMuon))
                    .addComponent(btThemPhieuMuon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(pnThongTinPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(226, Short.MAX_VALUE))
        );

        TabbedPaneMain.addTab("Quản lý mượn/ trả", new javax.swing.ImageIcon(getClass().getResource("/img/contractmng.png")), tabpnPhieuMuon); // NOI18N

        pnTTQTV.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin quản trị viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14))); // NOI18N

        lbHoTenQTV.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbHoTenQTV.setText("HoTen");

        lbEmainQTV.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lbEmainQTV.setText("Email");

        btDoiMatKhau.setText("Doi mat khau");
        btDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnTTQTVLayout = new javax.swing.GroupLayout(pnTTQTV);
        pnTTQTV.setLayout(pnTTQTVLayout);
        pnTTQTVLayout.setHorizontalGroup(
            pnTTQTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTQTVLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(pnTTQTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbEmainQTV, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoTenQTV, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTQTVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDoiMatKhau)
                .addContainerGap())
        );
        pnTTQTVLayout.setVerticalGroup(
            pnTTQTVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTQTVLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lbHoTenQTV)
                .addGap(18, 18, 18)
                .addComponent(lbEmainQTV)
                .addGap(18, 18, 18)
                .addComponent(btDoiMatKhau)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tabpnQuanTriVienLayout = new javax.swing.GroupLayout(tabpnQuanTriVien);
        tabpnQuanTriVien.setLayout(tabpnQuanTriVienLayout);
        tabpnQuanTriVienLayout.setHorizontalGroup(
            tabpnQuanTriVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnQuanTriVienLayout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(pnTTQTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabpnQuanTriVienLayout.setVerticalGroup(
            tabpnQuanTriVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnQuanTriVienLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(pnTTQTV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(460, Short.MAX_VALUE))
        );

        TabbedPaneMain.addTab("Quản trị viên", new javax.swing.ImageIcon(getClass().getResource("/img/adminmng.png")), tabpnQuanTriVien); // NOI18N

        getContentPane().add(TabbedPaneMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 950, 850));

        pnMenu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnQLSach.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout pnselectedQLSachLayout = new javax.swing.GroupLayout(pnselectedQLSach);
        pnselectedQLSach.setLayout(pnselectedQLSachLayout);
        pnselectedQLSachLayout.setHorizontalGroup(
            pnselectedQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );
        pnselectedQLSachLayout.setVerticalGroup(
            pnselectedQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel14.setBackground(new java.awt.Color(102, 102, 255));
        jLabel14.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bookmng.png"))); // NOI18N
        jLabel14.setText("SÁCH");

        javax.swing.GroupLayout pnQLSachLayout = new javax.swing.GroupLayout(pnQLSach);
        pnQLSach.setLayout(pnQLSachLayout);
        pnQLSachLayout.setHorizontalGroup(
            pnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLSachLayout.createSequentialGroup()
                .addComponent(pnselectedQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQLSachLayout.setVerticalGroup(
            pnQLSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addComponent(pnselectedQLSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnQLSach1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnQLSach1.setPreferredSize(new java.awt.Dimension(187, 88));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bookmng.png"))); // NOI18N
        jButton1.setText("SÁCH");

        javax.swing.GroupLayout pnQLSach1Layout = new javax.swing.GroupLayout(pnQLSach1);
        pnQLSach1.setLayout(pnQLSach1Layout);
        pnQLSach1Layout.setHorizontalGroup(
            pnQLSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLSach1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQLSach1Layout.setVerticalGroup(
            pnQLSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE)
        );

        pnQLSach2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnQLSach2.setPreferredSize(new java.awt.Dimension(187, 88));

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bookmng.png"))); // NOI18N
        jToggleButton1.setText("SÁCH");

        javax.swing.GroupLayout pnQLSach2Layout = new javax.swing.GroupLayout(pnQLSach2);
        pnQLSach2.setLayout(pnQLSach2Layout);
        pnQLSach2Layout.setHorizontalGroup(
            pnQLSach2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLSach2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToggleButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnQLSach2Layout.setVerticalGroup(
            pnQLSach2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnQLSach2Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jToggleButton2.setSelected(true);
        jToggleButton2.setText("jToggleButton2");

        jToggleButton3.setText("jToggleButton3");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnMenuLayout = new javax.swing.GroupLayout(pnMenu);
        pnMenu.setLayout(pnMenuLayout);
        pnMenuLayout.setHorizontalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnQLSach2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnQLSach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnQLSach1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnMenuLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jToggleButton3)
                            .addComponent(jToggleButton2))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnMenuLayout.setVerticalGroup(
            pnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnQLSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnQLSach1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnQLSach2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jToggleButton2)
                .addGap(33, 33, 33)
                .addComponent(jToggleButton3)
                .addContainerGap(328, Short.MAX_VALUE))
        );

        getContentPane().add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 220, 750));

        javax.swing.GroupLayout pnDesktopLayout = new javax.swing.GroupLayout(pnDesktop);
        pnDesktop.setLayout(pnDesktopLayout);
        pnDesktopLayout.setHorizontalGroup(
            pnDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        pnDesktopLayout.setVerticalGroup(
            pnDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        getContentPane().add(pnDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 220, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDangNhap_DangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhap_DangXuatActionPerformed
        if (btDangNhap_DangXuat.getText().equals("Đăng nhập")) {
            if (f == null) {
                try {
                    f = new fDangNhap(this, HANDLE);
                } catch (SQLException ex) {
                }
                f.show();
                f.setLocationRelativeTo(null);

            } else {
                f.show();
            }
        } else {
            HANDLE.ten = null;
            HANDLE.tendn = null;
            HANDLE.mail = null;
            if (fDMK != null) {
                fDMK.dispose();
            }
            if (fThemPM != null) {
                fThemPM.dispose();
            }
            LoadPanelQTV();
            LoadPanelSach();
            LoadPannelDocGia();
            LoadAfterCreatePM();
            TabbedPaneMain.setEnabled(false);
            TabbedPaneMain.setSelectedIndex(0);

            btDangNhap_DangXuat.setText("Đăng nhập");

            EnablePnTTSach(false);
        }
    }//GEN-LAST:event_btDangNhap_DangXuatActionPerformed

    private void btDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDoiMatKhauActionPerformed
        if (fDMK == null) {
            try {
                fDMK = new fDoiMatKhau(HANDLE);
            } catch (SQLException ex) {
                Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fDMK.show();
        fDMK.setLocationRelativeTo(null);

    }//GEN-LAST:event_btDoiMatKhauActionPerformed

    private void btTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTraSachActionPerformed
        // khi click nut nay thi cap nhat ngay hiên tai vao ngay tra, ++++++++++++++++++++++++++++++++++++++++++++++++++
        //dong thoi lay ra tat ca ctpm cua phieu nay, moi ctpm kiem tra ma sach va tang sl sach do len 1+++++++++++++++++++++++++++++
        int click_fixed = JOptionPane.showConfirmDialog(null, "Xac nhan da tra", "Chú ý", YES_NO_OPTION);
        if (click_fixed == 0) {

            String[] query = {"update PHIEUMUON set NgayTraThucTe=? where SoPhieuMuon=? ", "", ""};
            query[1] = java.time.LocalDate.now().toString();
            query[2] = tbSo_PM.getText();
            String query_next = "select MaSach from CTPHIEUMUON where SoPhieuMuon=" + tbSo_PM.getText();

            try {
                ResultSet rs = db.RunQuery(query_next);
                while (rs.next()) {
                    int masachcancapnhat = Integer.parseInt(rs.getString(1));
                    String[] query_next_next = {"update SACH set SoLuong=(SoLuong+1) where MaSach=?", "" + masachcancapnhat};
                    db.RunQuery(query_next_next);
                }
                db.RunQuery(query);
                LoadAfterCreatePM();
                HANDLE.ClearTextBox(pnThongTinPhieuMuon);
                JOptionPane.showMessageDialog(this, "Da cap nhat!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi cap nhat phieu muon:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btTraSachActionPerformed

    private void btThemPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemPhieuMuonActionPerformed
        if (fThemPM == null) {
            try {
                fThemPM = new fThemPhieuMuon(HANDLE, this);
            } catch (SQLException ex) {
                Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fThemPM.setLocationRelativeTo(null);
        fThemPM.show();
        fThemPM.requestFocus();
    }//GEN-LAST:event_btThemPhieuMuonActionPerformed

    private void btTimKiemPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimKiemPhieuMuonActionPerformed
        // cái này chua viet ============================================================================**************************************************
    }//GEN-LAST:event_btTimKiemPhieuMuonActionPerformed

    ///==================================================================================================================================
    private void tablePhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuMuonMouseClicked
        ChonDongPhieuMuon();
    }//GEN-LAST:event_tablePhieuMuonMouseClicked

    private void btXoaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaDGActionPerformed
        if (btXoaDG.getText().equals("Huy bo")) {
            LoadPannelDocGia();
            return;
        } else if (btXoaDG.getText().equals("Xoa")) {
            if (CHONDOCGIA == -1) {
                JOptionPane.showMessageDialog(this, "Chua chon DG nao!!");
                return;
            }

            if (JOptionPane.showConfirmDialog(null, "Xac nhan xoa", "Chú ý", YES_NO_OPTION) == 0) {

                String[] query = {"select * from PHIEUMUON where MaDocGia=?", tbMaDG.getText()};
                try {
                    ResultSet rs = db.RunQuery_Get(query);
                    rs.next();
                    if (rs.getRow() > 0) {
                        JOptionPane.showMessageDialog(this, "Loi khi xoa DG:\nDG con trong phieu muon.\nKhong the xoa!!");
                        return;
                    }
                    query[0] = "delete from DOCGIA where MaDocGia=?";
                    query[1] = tbMaDG.getText();
                    db.RunQuery(query);
                    JOptionPane.showMessageDialog(this, "Da xoa DG!!\n");
                    LoadPannelDocGia();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi xoa DG:\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btXoaDGActionPerformed

    private void btSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaDGActionPerformed
        if (CHONDOCGIA != -1) {
            if (btSuaDG.getText().equals("Sua")) {//dag la nut sua
                pnTTDG.requestFocus();
                tableDSDG.setEnabled(false);
                btXoaDG.setText("Huy bo");
                btThemDG.setVisible(false);
                //btTimKiemSach.setEnabled(false);
                btSuaDG.setText("Luu lai");
                LockPnTTDG(false);
            } else if (btSuaDG.getText().equals("Luu lai"))//neu la nut luu lai, thi chay query
            {
                if (!HANDLE.KiemTraNhap(pnTTDG)) {
                    JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                    return;
                }
                String[] query = {"update DOCGIA set TenDocGia=?,DiaChi=?,Sdt=?,CMND=? where MaDocGia=? ", "", "", "", "", ""};
                query[1] = tbTenDG.getText();
                query[2] = tbDiaChi.getText();
                query[3] = tbSDTDG.getText();
                query[4] = tbCMTDG.getText();
                query[5] = tbMaDG.getText();

                try {
                    db.RunQuery(query);
                    tableDSDG.setEnabled(true);
                    btXoaDG.setText("Xoa");
                    btThemDG.setVisible(true);
                    btSuaDG.setText("Sua");
                    LockPnTTDG(true);
                    JOptionPane.showMessageDialog(this, "Luu thay doi Doc gia thanh cong!!\n");
                    LoadPannelDocGia();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi sua thong Doc gia:\n" + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hay chon mot Doc gia!!");
        }
    }//GEN-LAST:event_btSuaDGActionPerformed

    private void btThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemDGActionPerformed
        if (btThemDG.getText().equals("Them")) {
            LockPnTTDG(false);
            tableDSDG.setEnabled(false);
            btSuaDG.setVisible(false);

            HANDLE.ClearTextBox(pnTTDG);
            btThemDG.setText("Xac nhan");
            btXoaDG.setText("Huy bo");
        } else if (btThemDG.getText().equals("Xac nhan")) {
            if (!HANDLE.KiemTraNhap(pnTTDG)) {
                JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                return;
            }
            String[] query = {"insert into DOCGIA values(?,?,?,?)", "", "", "", ""};
            query[1] = tbTenDG.getText();
            query[2] = tbDiaChi.getText();
            query[3] = tbSDTDG.getText();
            query[4] = tbCMTDG.getText();
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Them Doc gia thanh cong!!\n");
                LoadPannelDocGia();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi them Doc gia:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btThemDGActionPerformed

    private void tableDSDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSDGMouseClicked
        ChonDongDocGia();
    }//GEN-LAST:event_tableDSDGMouseClicked

    private void tableTheLoaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTheLoaiMouseReleased
        if (PANNELSACHENABLE) {
            ChonDongTheLoai();
        }
    }//GEN-LAST:event_tableTheLoaiMouseReleased

    private void tableDSSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSSMouseReleased
        if (PANNELSACHENABLE) {
            ChonDongSach();
        }
    }//GEN-LAST:event_tableDSSMouseReleased

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if (btXoa.getText().equals("Huy bo")) {
            LoadPanelSach();
            return;
        } else if (btXoa.getText().equals("Xoa")) {
            if (CHONSACH == -1) {
                JOptionPane.showMessageDialog(this, "Chua chon sach!!");
                return;
            }

            if (JOptionPane.showConfirmDialog(null, "Xac nhan xoa", "Chú ý", YES_NO_OPTION) == 0) {

                String[] query = {"select * from CTPHIEUMUON where MaSach=?", tbMaSach.getText()};
                try {
                    ResultSet rs = db.RunQuery_Get(query);
                    rs.next();
                    if (rs.getRow() > 0)//tuc la con trong ct phieu muon
                    {   //thì
                        JOptionPane.showMessageDialog(this, "Loi khi xoa sach:\nSach con trong phieu muon.\nKhong the xoa!!");
                        return;
                    }
                    query[0] = "delete from SACH where MaSach=?";
                    query[1] = tbMaSach.getText();
                    db.RunQuery(query);
                    JOptionPane.showMessageDialog(this, "Da xoa sach!!\n");
                    LoadPanelSach();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi xoa sach:\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        if (CHONSACH != -1) {
            if (btSua.getText().equals("Sua")) {//dag la nut sua
                pnTTSach.requestFocus();
                tableDSS.setEnabled(false);
                tableTheLoai.setEnabled(false);
                PANNELSACHENABLE = false;
                btXoa.setText("Huy bo");
                btThem.setVisible(false);
                btSua.setText("Luu lai");
                LockPnTTSach(false);
            } else if (btSua.getText().equals("Luu lai"))//neu la nut luu lai, thi chay query
            {
                if (!HANDLE.KiemTraNhap(pnTTSach)) {
                    JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                    return;
                }
                String[] query = {"update SACH set TenSach=?,SoLuong=?,MaTheLoai=?,TomTat=?,TacGia=? where MaSach=? ", "", "", "", "", "", ""};
                query[1] = tbTenSach.getText();
                query[2] = tbSoluong.getText();
                query[3] = HANDLE.getKey(MAPTHELOAI, cbbTheLoai.getSelectedItem().toString()).toString();
                query[4] = tbTomTat.getText();
                query[5] = tbTacGia.getText();
                query[6] = tbMaSach.getText();
                try {
                    db.RunQuery(query);
                    tableDSS.setEnabled(true);
                    tableTheLoai.setEnabled(true);
                    PANNELSACHENABLE = true;
                    btXoa.setText("Xoa");
                    btThem.setVisible(true);
                    btSua.setText("Sua");
                    LockPnTTSach(true);
                    JOptionPane.showMessageDialog(this, "Luu thay doi sach thanh cong!!\n");
                    LoadPanelSach();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi sua thong tin sach:\n" + ex.getMessage());
                }

            }
        } else {
            JOptionPane.showMessageDialog(this, "Chua chon sach");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed

        if (btThem.getText().equals("Them")) {
            LockPnTTSach(false);
            tableDSS.setEnabled(false);
            tableTheLoai.setEnabled(false);
            PANNELSACHENABLE = false;
            btSua.setVisible(false);

            HANDLE.ClearTextBox(pnTTSach);
            btThem.setText("Xac nhan");
            btXoa.setText("Huy bo");
        } else if (btThem.getText().equals("Xac nhan")) {
            if (!HANDLE.KiemTraNhap(pnTTSach)) {
                JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                return;
            }
            if (Integer.parseInt(tbSoluong.getText()) < 1) {
                JOptionPane.showMessageDialog(this, "Chu Y!!\nSo luong phai lon hon 0");
                return;
            }
            String[] query = {"insert into SACH values(?,?,?,?,?)", "", "", "", "", ""};
            query[1] = tbTenSach.getText();
            query[2] = tbSoluong.getText();
            query[3] = HANDLE.getKey(MAPTHELOAI, cbbTheLoai.getSelectedItem().toString()).toString();
            query[4] = tbTomTat.getText();
            query[5] = tbTacGia.getText();
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Them sach thanh cong!!\n");
                LoadPanelSach();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi them sach:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        jToggleButton2.setSelected(false);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    fDoiMatKhau fDMK;    
    private void LayBangDG(String query) {
        DefaultTableModel model = (DefaultTableModel) tableDSDG.getModel();
        model.setRowCount(0);
        
        HANDLE.DOCGIALIST.clear();
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {
                DocGia DG=new DocGia(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5))   ;
                model.addRow(DG.ToListString());
                HANDLE.DOCGIALIST.add(DG);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu DG:\n" + ex.getMessage());
        }
    }

    private void LayBangSach(String query) {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        HANDLE.SACHLIST.clear();
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {
                Sach s=new Sach(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));

                model.addRow(s.ToListString());
                HANDLE.SACHLIST.add(s);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu Sach:\n" + ex.getMessage());
        }
    }

    private void Combobox_load() {
        try {
            ResultSet rs = db.RunQuery("select MaTheLoai,TenTheLoai from THELOAI");
            while (rs.next()) {
                MAPTHELOAI.put(Integer.parseInt(rs.getString(1)), rs.getString(2));
                cbbTheLoai.addItem(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu ra combobox:" + e.getMessage());
        }
    }

    private void LayBangTheLoai(String query) {
        DefaultTableModel model = (DefaultTableModel) tableTheLoai.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {
                model.addRow(new String[]{rs.getString(1), rs.getString(2)});
            }
            model.addRow(new String[]{"", "Tất cả thể loại"});
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu the loai:\n" + e.getMessage());
        }

    }

    private void LayBangPhieuMuon(String query) {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {

                model.addRow(new Object[]{rs.getString(1), rs.getString(5), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6)});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu:\n" + ex.getMessage());
        }
    }

    private void LayBangChiTietPhieuMuon(String query) {
        String[] tenCot = {"Danh sách sách mượn"};
        DefaultTableModel model = new DefaultTableModel(tenCot, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tensach;
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {
                tensach = rs.getString(1);
                model.addRow(new Object[]{tensach});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu:\n" + ex.getMessage());
        }
        tableCTPM.setModel(model);
    }

    private int CHONSACH = -1;

    private void ChonDongSach() {
        //System.out.println("da chon: "+CHỌNSÁCH);
        CHONSACH = tableDSS.getSelectedRow();
        tbMaSach.setText(tableDSS.getValueAt(CHONSACH, 0).toString());
        tbTenSach.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        tbSoluong.setText(tableDSS.getValueAt(CHONSACH, 2).toString());
        tbTomTat.setText(tableDSS.getValueAt(CHONSACH, 4).toString());
        tbTacGia.setText(tableDSS.getValueAt(CHONSACH, 5).toString());
        cbbTheLoai.setSelectedItem(MAPTHELOAI.get(Integer.parseInt(tableDSS.getValueAt(CHONSACH, 3).toString())));
    }

    private int CHONTHELOAI = -1;

    private void ChonDongTheLoai() {

        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        CHONTHELOAI = tableTheLoai.getSelectedRow();
        //System.out.println(""+tableTheLoai.getRowCount()+" dong chon:"+CHONTHELOAI);
        if (CHONTHELOAI == tableTheLoai.getRowCount() - 1)//tuc la chon dong tat ca the loai
        {
            for (Sach sach : HANDLE.SACHLIST) {

                model.addRow(sach.ToListString());

            }
        } else {

            for (Sach sach : HANDLE.SACHLIST) {
                if (sach.getMaTheLoai().equals(tableTheLoai.getValueAt(CHONTHELOAI, 0))) {
                    model.addRow(sach.ToListString());
                }
            }
        }

    }

    private int CHONDOCGIA = -1;

    private void ChonDongDocGia() {
        CHONDOCGIA = tableDSDG.getSelectedRow();
        tbMaDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 0).toString());
        tbTenDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 1).toString());
        tbDiaChi.setText(tableDSDG.getValueAt(CHONDOCGIA, 2).toString());
        tbSDTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 3).toString());
        tbCMTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 4).toString());
    }

    private int CHONPHIEUMUON = -1;

    private void ChonDongPhieuMuon() {
        CHONPHIEUMUON = tablePhieuMuon.getSelectedRow();
        int sophieumuon = Integer.parseInt(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 0).toString());
        tbSo_PM.setText("" + sophieumuon);
        tbTenDG_PM.setText(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 1).toString());
        tbNgayMuon.setText(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 2).toString());
        tbNgayHen.setText(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 3).toString());
        String ngaytra;
        if (tablePhieuMuon.getValueAt(CHONPHIEUMUON, 4) == null) {
            ngaytra = "chưa trả";
            btTraSach.setVisible(true);
        } else {
            ngaytra = tablePhieuMuon.getValueAt(CHONPHIEUMUON, 4).toString();
            btTraSach.setVisible(false);
        }

        tbNgayTra.setText(ngaytra);

        /**
         * ***************************************
         */
        LayBangChiTietPhieuMuon("select TenSach from CTPHIEUMUON,SACH where SACH.MaSach=CTPHIEUMUON.MaSach and SoPhieuMuon=" + sophieumuon);

    }

    // <editor-fold defaultstate="collapsed" desc="Click vào đây là project ko chạy được !!!"> 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fMain().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(fMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane TabbedPaneMain;
    private javax.swing.JButton btDangNhap_DangXuat;
    private javax.swing.JButton btDoiMatKhau;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btSuaDG;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThemDG;
    private javax.swing.JButton btThemPhieuMuon;
    private javax.swing.JButton btTimKiemPhieuMuon;
    private javax.swing.JButton btTraSach;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaDG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JLabel lbEmainQTV;
    private javax.swing.JLabel lbHoTenQTV;
    private javax.swing.JDesktopPane pnDesktop;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnQLSach;
    private javax.swing.JPanel pnQLSach1;
    private javax.swing.JPanel pnQLSach2;
    private javax.swing.JPanel pnTTDG;
    private javax.swing.JPanel pnTTQTV;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JPanel pnThongTinPhieuMuon;
    private javax.swing.JPanel pnselectedQLSach;
    private javax.swing.JTable tableCTPM;
    private javax.swing.JTable tableDSDG;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTable tablePhieuMuon;
    private javax.swing.JTable tableTheLoai;
    private javax.swing.JPanel tabpnDocGia;
    private javax.swing.JPanel tabpnPhieuMuon;
    private javax.swing.JPanel tabpnQuanTriVien;
    private javax.swing.JPanel tabpnSach;
    private javax.swing.JTextField tbCMTDG;
    private javax.swing.JTextField tbDiaChi;
    private javax.swing.JTextField tbMaDG;
    private javax.swing.JTextField tbMaSach;
    private javax.swing.JTextField tbNgayHen;
    private javax.swing.JTextField tbNgayMuon;
    private javax.swing.JTextField tbNgayTra;
    private javax.swing.JTextField tbSDTDG;
    private javax.swing.JTextField tbSo_PM;
    private javax.swing.JTextField tbSoluong;
    private javax.swing.JTextField tbTImkiemPhieuMuon;
    private javax.swing.JTextField tbTImkiemSach;
    private javax.swing.JTextField tbTacGia;
    private javax.swing.JTextField tbTenDG;
    private javax.swing.JTextField tbTenDG_PM;
    private javax.swing.JTextField tbTenSach;
    private javax.swing.JTextField tbTomTat;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
