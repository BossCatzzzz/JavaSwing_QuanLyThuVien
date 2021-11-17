package UI;

import BLL.MY_HANDLE;
import Bookcovers.BookCover_Handle;
import DAL.MY_HANDLE_CONNECTION;
import DTO.Sach;
import DTO.TheLoai;
import img.IMG;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class fQLSACH extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fMain1 MAIN;
    private boolean PANNELSACHENABLE = true;
    private int CHONSACH = -1;
    private int CHONTHELOAI = -1;
    private fdThemSach fthem;

    public fQLSACH(fMain1 f, MY_HANDLE xl) throws SQLException {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = xl;
        MAIN = f;
        LoadPanelSach();

    }

    public void search() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        for (Sach item : HANDLE.SACHLIST) {
            if (item.SearchOnAll(tbTImkiemSach.getText().trim())) {
                model.addRow(item.ToListString());
            }
        }
    }

    private void LockPnTTSach(boolean b) {//============= khóa / mở các textbox
//        tbTenSach.setEditable(!b);
//        cbbTheLoai.setEnabled(!b);
//        tbSoluong.setEditable(!b);
//        tbTomTat.setEditable(!b);
//        tbTacGia.setEditable(!b);
    }

    public void LoadPanelSach() {
        MAIN.LoadSach();
        LayBangSach();
        LayBangTheLoai();
        Combobox_load();

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
        CHONTHELOAI = -1;
    }

    private void LayBangTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableTheLoai.getModel();
        model.setRowCount(0);
        for (TheLoai theLoai : HANDLE.THELOAILIST) {
            model.addRow(theLoai.ToListString());
        }
        model.addRow(new String[]{"", "Tất cả thể loại"});
    }

    private void Combobox_load() {

//        for (Map.Entry<String, String> entry : HANDLE.MAPTHELOAI.entrySet()) {
//            cbbTheLoai.addItem(entry.getValue());
//        }
    }

    private void LayBangSach() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);

        for (Sach object : HANDLE.SACHLIST) {
            model.addRow(object.ToListString());
        }
    }

    private void ChonDongSach() {
        CHONSACH = tableDSS.getSelectedRow();
        if (CHONSACH < 0) {
            return;
        }
        lbMaSach.setText(tableDSS.getValueAt(CHONSACH, 0).toString());

        //lbTenSach.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        lbTenSach.setText(HANDLE.BreakLineTitle(tableDSS.getValueAt(CHONSACH, 1).toString()));

        lbSoLuong.setText(tableDSS.getValueAt(CHONSACH, 2).toString());
        taTomTat.setText(tableDSS.getValueAt(CHONSACH, 4).toString());
        //lbTomTat.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbTacGia.setText(tableDSS.getValueAt(CHONSACH, 5).toString());
        lbTheLoai.setText(HANDLE.MAPTHELOAI.get(tableDSS.getValueAt(CHONSACH, 3).toString().toUpperCase()));
        //jTextPane1.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        //jTextArea1.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        BookCover_Handle fl = new BookCover_Handle();

        String imgname = (lbMaSach.getText() + ".jpg");
        URL link = fl.getClass().getResource(imgname);
        BufferedImage myPicture;
        if (link == null) {
            link = fl.getClass().getResource("noimg.jpg");
        }
        try {
            myPicture = ImageIO.read(link);
            Image dimg = myPicture.getScaledInstance(lbAnhBia.getWidth(), lbAnhBia.getHeight(), Image.SCALE_SMOOTH);
            lbAnhBia.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi lay anh bia:\n" + ex);
        }

    }

    private void ChonDongTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        CHONTHELOAI = tableTheLoai.getSelectedRow();
        if (CHONTHELOAI > HANDLE.THELOAILIST.size()) {
            return;
        }
        if (CHONTHELOAI == tableTheLoai.getRowCount() - 1 || CHONTHELOAI == -1)//tuc la chon dong tat ca the loai
        {
            for (Sach sach : HANDLE.SACHLIST) {
                model.addRow(sach.ToListString());
            }
        } else {
            for (Sach sach : HANDLE.SACHLIST) {
                if (sach.getMaTheLoai().toUpperCase().equals(tableTheLoai.getValueAt(CHONTHELOAI, 0).toString().toUpperCase())) {
                    model.addRow(sach.ToListString());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpnSach = new javax.swing.JPanel();
        pnTTSach = new javax.swing.JPanel();
        lbMaSach = new javax.swing.JLabel();
        lbTomTat = new javax.swing.JLabel();
        lbTacGia = new javax.swing.JLabel();
        lbTenSach = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbAnhBia = new javax.swing.JLabel();
        lbTextSoLuong = new javax.swing.JLabel();
        lbTextTheLoai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTomTat = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();
        tbTImkiemSach = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTheLoai = new javax.swing.JTable();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();

        tabpnSach.setBackground(new java.awt.Color(211, 212, 195));
        tabpnSach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabpnSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnTTSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaSach.setText("Mã sách");
        pnTTSach.add(lbMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        lbTomTat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTomTat.setText("Tóm tắt :");
        pnTTSach.add(lbTomTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        lbTacGia.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbTacGia.setText("Tác giả");
        pnTTSach.add(lbTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        lbTenSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSach.setText("Tên sách");
        lbTenSach.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbTenSach.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnTTSach.add(lbTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 50));

        lbTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTheLoai.setText("Thể loại");
        pnTTSach.add(lbTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSoLuong.setText("0");
        pnTTSach.add(lbSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        lbAnhBia.setText("Ảnh bìa");
        pnTTSach.add(lbAnhBia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 230));

        lbTextSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTextSoLuong.setText("Số lượng còn lại :");
        pnTTSach.add(lbTextSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        lbTextTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTextTheLoai.setText("Thể loại :");
        pnTTSach.add(lbTextTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        taTomTat.setEditable(false);
        taTomTat.setBackground(new java.awt.Color(167, 174, 130));
        taTomTat.setColumns(20);
        taTomTat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        taTomTat.setLineWrap(true);
        taTomTat.setRows(5);
        taTomTat.setWrapStyleWord(true);
        taTomTat.setAutoscrolls(false);
        taTomTat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        taTomTat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taTomTat.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(taTomTat);

        pnTTSach.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 220, 70));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableDSS.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
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
        tableDSS.setFillsViewportHeight(true);
        tableDSS.setRowHeight(40);
        tableDSS.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tableDSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDSSMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDSS);
        if (tableDSS.getColumnModel().getColumnCount() > 0) {
            tableDSS.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableDSS.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableDSS.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableDSS.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

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
        tbTImkiemSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTImkiemSach.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
        tableTheLoai.setFillsViewportHeight(true);
        tableTheLoai.setRowHeight(40);
        tableTheLoai.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tableTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableTheLoaiMouseReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tableTheLoai);
        if (tableTheLoai.getColumnModel().getColumnCount() > 0) {
            tableTheLoai.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableTheLoai.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        btThem.setText("Them");
        btThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btThem.setMinimumSize(new java.awt.Dimension(72, 72));
        btThem.setName("add"); // NOI18N
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

        javax.swing.GroupLayout tabpnSachLayout = new javax.swing.GroupLayout(tabpnSach);
        tabpnSach.setLayout(tabpnSachLayout);
        tabpnSachLayout.setHorizontalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbTImkiemSach)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE))
                        .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabpnSachLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabpnSachLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(tabpnSachLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        tabpnSachLayout.setVerticalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(tbTImkiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1))
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabpnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

                String[] query = {"select * from CTPHIEUMUON where MaSach=?", lbMaSach.getText()};
                try {
                    ResultSet rs = db.RunQuery_Get(query);
                    rs.next();
                    if (rs.getRow() > 0)//tuc la con trong ct phieu muon
                    {   //thì
                        JOptionPane.showMessageDialog(this, "Loi khi xoa sach:\nSach con trong phieu muon.\nKhong the xoa!!");
                        return;
                    }
                    query[0] = "delete from SACH where MaSach=?";
                    query[1] = lbMaSach.getText();
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
            Sach edit = new Sach();
            edit.setMaSach(lbMaSach.getText());
            edit.setTenSach(tableDSS.getValueAt(CHONSACH, 1).toString());
            edit.setTacgia(lbTacGia.getText());
            edit.setSoLuong(lbSoLuong.getText());
            edit.setTomTat(taTomTat.getText());
            edit.setMaTheLoai(HANDLE.getKey(HANDLE.MAPTHELOAI, lbTheLoai.getText()));

            if (fthem != null) {
                fthem = null;
            }
            try {
                fthem = new fdThemSach(MAIN, true, this, edit, HANDLE);
            } catch (SQLException ex) {
                Logger.getLogger(fQLSACH.class.getName()).log(Level.SEVERE, null, ex);
            }
            fthem.show();
        } else {
            JOptionPane.showMessageDialog(this, "Hay chon mot Sach");
        }

    }//GEN-LAST:event_btSuaActionPerformed


    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        if (fthem != null) {
            fthem = null;
        }
        try {
            fthem = new fdThemSach(MAIN, true, this, HANDLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi tao form them sach:\n" + ex.getMessage());
        }
        fthem.show();
    }//GEN-LAST:event_btThemActionPerformed

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

    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbAnhBia;
    private javax.swing.JLabel lbMaSach;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTacGia;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JLabel lbTextSoLuong;
    private javax.swing.JLabel lbTextTheLoai;
    private javax.swing.JLabel lbTheLoai;
    private javax.swing.JLabel lbTomTat;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JTextArea taTomTat;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTable tableTheLoai;
    private javax.swing.JPanel tabpnSach;
    private javax.swing.JTextField tbTImkiemSach;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>      
