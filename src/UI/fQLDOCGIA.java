package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

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
    }

    private void LoadPannelDocGia() {
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
        tbMaDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 0).toString());
        tbTenDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 1).toString());
        tbDiaChi.setText(tableDSDG.getValueAt(CHONDOCGIA, 2).toString());
        tbSDTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 3).toString());
        tbCMTDG.setText(tableDSDG.getValueAt(CHONDOCGIA, 4).toString());
    }

    private void LayBangDG() {
        DefaultTableModel model = (DefaultTableModel) tableDSDG.getModel();
        model.setRowCount(0);
        for (DocGia docGia : HANDLE.DOCGIALIST) {
            model.addRow(docGia.ToListString());
        }
    }

    private void LockPnTTDG(boolean b) {
        tbTenDG.setEditable(!b);
        tbDiaChi.setEditable(!b);
        tbCMTDG.setEditable(!b);
        tbSDTDG.setEditable(!b);
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
        tbTImkiemPhieuMuon = new javax.swing.JTextField();

        tabpnDocGia.setBackground(new java.awt.Color(211, 212, 195));

        tableDSDG.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
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
                .addContainerGap(29, Short.MAX_VALUE))
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

        javax.swing.GroupLayout tabpnDocGiaLayout = new javax.swing.GroupLayout(tabpnDocGia);
        tabpnDocGia.setLayout(tabpnDocGiaLayout);
        tabpnDocGiaLayout.setHorizontalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnDocGiaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tbTImkiemPhieuMuon)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tabpnDocGiaLayout.setVerticalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

// <editor-fold defaultstate="collapsed" desc="Generated Code - Do not modify"> 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSuaDG;
    private javax.swing.JButton btThemDG;
    private javax.swing.JButton btXoaDG;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel pnTTDG;
    private javax.swing.JTable tableDSDG;
    private javax.swing.JPanel tabpnDocGia;
    private javax.swing.JTextField tbCMTDG;
    private javax.swing.JTextField tbDiaChi;
    private javax.swing.JTextField tbMaDG;
    private javax.swing.JTextField tbSDTDG;
    private javax.swing.JTextField tbTImkiemPhieuMuon;
    private javax.swing.JTextField tbTenDG;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>     
