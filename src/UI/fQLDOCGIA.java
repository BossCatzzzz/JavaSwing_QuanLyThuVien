package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import img.IMG;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import testPK.img.flag;

public class fQLDOCGIA extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private final fMain1 MAIN;
    private int CHONDOCGIA;

    public fQLDOCGIA(fMain1 f, MY_HANDLE xl) throws SQLException {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = xl;
        MAIN = f;
        LoadPannelDocGia();
        tableDSDG.removeColumn(tableDSDG.getColumnModel().getColumn(5));
    }

    public void LoadPannelDocGia() {
        MAIN.LoadDocGia();
        LayBangDG();

        LockPnTTDG(true);

        tableDSDG.setEnabled(true);
        btXoaDG.setText("Xoa");

        btThemDG.setVisible(true);
        btSuaDG.setVisible(true);
        btSuaDG.setText("Sua");
        btThemDG.setText("Them");
        HANDLE.ClearTextBox(pnTTDG);
        CHONDOCGIA = -1;
    }

    private void ChonDongDocGia() {
        CHONDOCGIA = tableDSDG.getSelectedRow();
        if (CHONDOCGIA < 0 || CHONDOCGIA >= HANDLE.DOCGIALIST.size()) {
            return;
        }
//        tbMaDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 0).toString());
//        tbTenDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 1).toString());
//        tbDiaChi.setText(tableDSDG.getValueAt(CHONDOCGIA, 2).toString());
//        tbSDTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 3).toString());
//        tbCMTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 4).toString());
//        if(tableDSDG.getModel().getValueAt(CHONDOCGIA, 5).toString().equals("Nam"))
//        {
//            rdbtNam.setSelected(true);
//        }
//        else rdbtNu.setSelected(true);

        ///////////////////////////////////////////////////////////////////
        IMG fl = new IMG();

        String imgname = (tableDSDG.getModel().getValueAt(CHONDOCGIA, 5).toString().equals("1")) ? "male" : "female";
        imgname += ".png";

        System.out.println("Test:\t" + imgname);

        URL link = fl.getClass().getResource(imgname);

        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(link);
            Image dimg = myPicture.getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH);
            lbHinhAnh.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi lay hinh:\n" + ex);
        }

        lbMaDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 0).toString());
        lbTenDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 1).toString());
        lbCMNDDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 4).toString());
        lbSDT.setText(tableDSDG.getValueAt(CHONDOCGIA, 3).toString());
        lbDiaChi.setText(tableDSDG.getValueAt(CHONDOCGIA, 2).toString());

    }

    private void LayBangDG() {
        DefaultTableModel model = (DefaultTableModel) tableDSDG.getModel();
        model.setRowCount(0);
        for (DocGia docGia : HANDLE.DOCGIALIST) {
            model.addRow(docGia.ToListString());
        }
    }

    private void LockPnTTDG(boolean b) {
//        tbTenDG.setEditable(!b);
//        tbDiaChi.setEditable(!b);
//        tbCMTDG.setEditable(!b);
//        tbSDTDG.setEditable(!b);
    }

    public void search() {
        DefaultTableModel model = (DefaultTableModel) tableDSDG.getModel();
        model.setRowCount(0);
        for (DocGia item : HANDLE.DOCGIALIST) {
            if (item.SearchOnAll(tbTImkiemPhieuMuon.getText().trim())) {
                model.addRow(item.ToListString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        tabpnDocGia = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableDSDG = new javax.swing.JTable();
        pnTTDG = new javax.swing.JPanel();
        lbHinhAnh = new javax.swing.JLabel();
        lbMaDG = new javax.swing.JLabel();
        lbTenDG = new javax.swing.JLabel();
        lbCMNDDG = new javax.swing.JLabel();
        lbDiaChi = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        tbTImkiemPhieuMuon = new javax.swing.JTextField();
        btThemDG = new javax.swing.JButton();
        btSuaDG = new javax.swing.JButton();
        btXoaDG = new javax.swing.JButton();

        tabpnDocGia.setBackground(new java.awt.Color(211, 212, 195));

        tableDSDG.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tableDSDG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Địa chỉ", "Số ĐT", "CMND", "Gioi tính"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSDG.setFillsViewportHeight(true);
        tableDSDG.setRowHeight(40);
        tableDSDG.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tableDSDG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSDGMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableDSDG);

        pnTTDG.setBackground(new java.awt.Color(167, 174, 130));
        pnTTDG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbHinhAnh.setText("Gioi tinh");

        lbMaDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMaDG.setText("Ma Doc gia");

        lbTenDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTenDG.setText("Ho Ten");

        lbCMNDDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCMNDDG.setText("CMND");

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaChi.setText("Dia chi");

        lbSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSDT.setText("SDT");

        javax.swing.GroupLayout pnTTDGLayout = new javax.swing.GroupLayout(pnTTDG);
        pnTTDG.setLayout(pnTTDGLayout);
        pnTTDGLayout.setHorizontalGroup(
            pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTDGLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMaDG)
                    .addComponent(lbTenDG)
                    .addComponent(lbCMNDDG)
                    .addComponent(lbDiaChi)
                    .addComponent(lbSDT))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        pnTTDGLayout.setVerticalGroup(
            pnTTDGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTDGLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(pnTTDGLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lbMaDG)
                .addGap(18, 18, 18)
                .addComponent(lbTenDG)
                .addGap(18, 18, 18)
                .addComponent(lbCMNDDG)
                .addGap(18, 18, 18)
                .addComponent(lbDiaChi)
                .addGap(18, 18, 18)
                .addComponent(lbSDT)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbTImkiemPhieuMuon.getDocument().addDocumentListener(new DocumentListener() {
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
        tbTImkiemPhieuMuon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTImkiemPhieuMuon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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

        javax.swing.GroupLayout tabpnDocGiaLayout = new javax.swing.GroupLayout(tabpnDocGia);
        tabpnDocGia.setLayout(tabpnDocGiaLayout);
        tabpnDocGiaLayout.setHorizontalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnDocGiaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbTImkiemPhieuMuon)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(btSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        tabpnDocGiaLayout.setVerticalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabpnDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tabpnDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableDSDGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSDGMouseClicked
        ChonDongDocGia();
    }//GEN-LAST:event_tableDSDGMouseClicked

    fdThemDG fthem;
    private void btThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemDGActionPerformed
        if (fthem != null) {
            fthem = null;
        }
        try {
            fthem = new fdThemDG(MAIN, true, this);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi tao form them doc gia:\n" + ex.getMessage());
        }
        fthem.show();
//        if (btThemDG.getText().equals("Them")) {
//            LockPnTTDG(false);
//            tableDSDG.setEnabled(false);
//            btSuaDG.setVisible(false);
//
//            HANDLE.ClearTextBox(pnTTDG);
//            btThemDG.setText("Xac nhan");
//            btXoaDG.setText("Huy bo");
//        } else if (btThemDG.getText().equals("Xac nhan")) {
//            if (!HANDLE.KiemTraNhap(pnTTDG)) {
//                JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
//                return;
//            }
//            String[] query = {"insert into DOCGIA values(?,?,?,?)", "", "", "", ""};
//            query[1] = tbTenDG.getText();
//            query[2] = tbDiaChi.getText();
//            query[3] = tbSDTDG.getText();
//            query[4] = tbCMTDG.getText();
//            try {
//                db.RunQuery(query);
//                JOptionPane.showMessageDialog(this, "Them Doc gia thanh cong!!\n");
//                LoadPannelDocGia();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(this, "Loi khi them Doc gia:\n" + ex.getMessage());
//            }
//        }
    }//GEN-LAST:event_btThemDGActionPerformed

    private void btSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaDGActionPerformed
        if (CHONDOCGIA != -1) {
//            if (btSuaDG.getText().equals("Sua")) {//dag la nut sua
//                pnTTDG.requestFocus();
//                tableDSDG.setEnabled(false);
//                btXoaDG.setText("Huy bo");
//                btThemDG.setVisible(false);
//                //btTimKiemSach.setEnabled(false);
//                btSuaDG.setText("Luu lai");
//                LockPnTTDG(false);
//            } else if (btSuaDG.getText().equals("Luu lai"))//neu la nut luu lai, thi chay query
//            {
//                if (!HANDLE.KiemTraNhap(pnTTDG)) {
//                    JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
//                    return;
//                }
//                String[] query = {"update DOCGIA set TenDocGia=?,DiaChi=?,Sdt=?,CMND=? where MaDocGia=? ", "", "", "", "", ""};
//                query[1] = tbTenDG.getText();
//                query[2] = tbDiaChi.getText();
//                query[3] = tbSDTDG.getText();
//                query[4] = tbCMTDG.getText();
//                query[5] = tbMaDG.getText();
//
//                try {
//                    db.RunQuery(query);
//                    tableDSDG.setEnabled(true);
//                    btXoaDG.setText("Xoa");
//                    btThemDG.setVisible(true);
//                    btSuaDG.setText("Sua");
//                    LockPnTTDG(true);
//                    JOptionPane.showMessageDialog(this, "Luu thay doi Doc gia thanh cong!!\n");
//                    LoadPannelDocGia();
//                } catch (SQLException ex) {
//                    JOptionPane.showMessageDialog(this, "Loi khi sua thong Doc gia:\n" + ex.getMessage());
//                }
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Hay chon mot Doc gia!!");
//        }
            DocGia edit = new DocGia();
            edit.setMa(lbMaDG.getText());
            edit.setTen(lbTenDG.getText());
            edit.setDiachi(lbDiaChi.getText());
            edit.setCmnd(lbCMNDDG.getText());
            edit.setSdt(lbSDT.getText());
            edit.setGioitinh(tableDSDG.getModel().getValueAt(CHONDOCGIA, 5).toString());
            
            if (fthem != null) {
                fthem = null;
            }
            try {
                fthem = new fdThemDG(MAIN, true, this, edit);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi tao form sua doc gia:\n" + ex.getMessage());
            }
            fthem.show();
        } else
            JOptionPane.showMessageDialog(this, "Hay chon mot Doc gia");
    }//GEN-LAST:event_btSuaDGActionPerformed

    private void btXoaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaDGActionPerformed
//        if (btXoaDG.getText().equals("Huy bo")) {
//            LoadPannelDocGia();
//            return;
//        } else if (btXoaDG.getText().equals("Xoa")) {
        if (CHONDOCGIA == -1) {
            JOptionPane.showMessageDialog(this, "Chua chon DG nao!!");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Xac nhan xoa", "Chú ý", YES_NO_OPTION) == 0) {

            String[] query = {"select * from PHIEUMUON where MaDocGia=?", lbMaDG.getText()};
            try {
                ResultSet rs = db.RunQuery_Get(query);
                rs.next();
                if (rs.getRow() > 0) {
                    JOptionPane.showMessageDialog(this, "Loi khi xoa DG:\nDG con trong phieu muon.\nKhong the xoa!!");
                    return;
                }
                query[0] = "delete from DOCGIA where MaDocGia=?";
                query[1] = lbMaDG.getText();
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Da xoa DG!!\n");
                LoadPannelDocGia();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi xoa DG:\n" + ex.getMessage());
            }
        }
//        }
    }//GEN-LAST:event_btXoaDGActionPerformed

// <editor-fold defaultstate="collapsed" desc="Generated Code - Do not modify"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSuaDG;
    private javax.swing.JButton btThemDG;
    private javax.swing.JButton btXoaDG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbCMNDDG;
    private javax.swing.JLabel lbDiaChi;
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JLabel lbMaDG;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTenDG;
    private javax.swing.JPanel pnTTDG;
    private javax.swing.JTable tableDSDG;
    private javax.swing.JPanel tabpnDocGia;
    private javax.swing.JTextField tbTImkiemPhieuMuon;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>     
