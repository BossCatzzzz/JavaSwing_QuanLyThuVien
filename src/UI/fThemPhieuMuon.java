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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class fThemPhieuMuon extends javax.swing.JFrame {

    private final MY_HANDLE_CONNECTION db;
    private fQLMUONTRA FATHER;
    private MY_HANDLE HANDLE;

//    public fThemPhieuMuon() throws SQLException {
//        initComponents();
//        db = new MY_HANDLE_CONNECTION();
//        LayBangSach();
//        //modelroot =  (DefaultTableModel)tableDSS.getModel();
//    }
    public fThemPhieuMuon(MY_HANDLE xuly, JFrame main) throws SQLException {
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        //f = (fMain) main;
        HANDLE = xuly;
        tbNgayMuonN.setText(java.time.LocalDate.now().toString());
        //tbNgayHenTra_FM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))
        LayBangSach();
        //modelroot =  (DefaultTableModel)tableDSS.getModel();
    }

    public fThemPhieuMuon(fQLMUONTRA f, MY_HANDLE xuly) throws SQLException {
        initComponents();

        db = new MY_HANDLE_CONNECTION();
        FATHER = f;
        HANDLE = xuly;
        tbNgayMuonN.setText(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("d/M/yy")));
        LayBangSach();
        btXacNhan.setEnabled(false);
        btThem.setEnabled(false);
    }

    private void LayBangSach() {
        DefaultTableModel modelroot = (DefaultTableModel) tableDSS.getModel();
        modelroot.setRowCount(0);
        for (Sach item : HANDLE.SACHLIST) {
            if (item.getSoLuong() > 0) {
                modelroot.addRow(new Object[]{item.getMaSach(), item.getTenSach(), item.getSoLuong()});
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tbMaDG = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbHoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbNgayHenTra_FM = new javax.swing.JFormattedTextField();
        btXacNhan = new javax.swing.JToggleButton();
        tbNgayMuonN = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSChon = new javax.swing.JTable();
        btThem = new javax.swing.JButton();
        btHuyBo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        tableDSS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma sach", "Ten sach", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDSS);
        if (tableDSS.getColumnModel().getColumnCount() > 0) {
            tableDSS.getColumnModel().getColumn(0).setResizable(false);
            tableDSS.getColumnModel().getColumn(0).setPreferredWidth(80);
            tableDSS.getColumnModel().getColumn(1).setResizable(false);
            tableDSS.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableDSS.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(tbMaDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 20, 113, -1));

        btTim.setText("Tìm");
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });
        jPanel1.add(btTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 20, -1, -1));

        jLabel1.setText("Họ tên");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 63, -1, -1));

        jLabel2.setText("Mã độc giả");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        tbHoten.setEditable(false);
        jPanel1.add(tbHoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 60, 203, -1));

        jLabel3.setText("Ngay muon");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 103, -1, -1));

        jLabel4.setText("Hen tra");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 143, -1, -1));

        tbNgayHenTra_FM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));
        jPanel1.add(tbNgayHenTra_FM, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 140, 203, -1));

        btXacNhan.setText("<html><center><b>Xac<br>nhan<b></html>");
        btXacNhan.setActionCommand("<html><b><center>Xac<br><center>nhan<b></html>");
        btXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btXacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 74, 62));

        tbNgayMuonN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        // Code adding the component to the parent container - not shown here
        tbNgayMuonN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));
        jPanel1.add(tbNgayMuonN, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 100, 204, -1));

        tableDSChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ma sach", "Sach da chon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSChon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDSChonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDSChon);
        if (tableDSChon.getColumnModel().getColumnCount() > 0) {
            tableDSChon.getColumnModel().getColumn(0).setResizable(false);
            tableDSChon.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btHuyBo.setText("Hủy bỏ");
        btHuyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyBoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btThem)
                        .addGap(54, 54, 54)
                        .addComponent(btHuyBo)
                        .addGap(110, 110, 110))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tableDSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSSMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.

            int selectedrow = tableDSS.getSelectedRow();
            DefaultTableModel modelroot = (DefaultTableModel) tableDSS.getModel();

            if (Integer.parseInt(modelroot.getValueAt(selectedrow, 2).toString()) == 0) {
                JOptionPane.showMessageDialog(rootPane, "So luong sach khong du!!");
                return;
            }

            DefaultTableModel model = (DefaultTableModel) tableDSChon.getModel();
            //System.out.println("UI.fThemPhieuMuon.tableDSSMouseClicked()\n" + modelroot.getValueAt(selectedrow, 2));
            model.addRow(new Object[]{tableDSS.getValueAt(selectedrow, 0), tableDSS.getValueAt(selectedrow, 1)});
            modelroot.setValueAt(Integer.parseInt(modelroot.getValueAt(selectedrow, 2).toString()) - 1, selectedrow, 2);

            //System.out.println("UI.fThemPhieuMuon.tableDSSMouseClicked()\n" + modelroot.getValueAt(selectedrow, 2));
        }
    }//GEN-LAST:event_tableDSSMouseClicked

    /**
     * Ham tim kiem DG tu ma DG
     *
     * @param evt
     */
    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        if (HANDLE.KiemTraNhap(tbMaDG)) {
            for (DocGia item : HANDLE.DOCGIALIST) {
                if (item.getMa().equals(tbMaDG.getText())) {
                    tbHoten.setText(item.getTen());
                    btXacNhan.setEnabled(true);
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Khong co Doc gia voi ma la " + tbMaDG.getText());
            tbHoten.setText("");
            tbMaDG.setText("");
            btXacNhan.setEnabled(false);
        }
    }//GEN-LAST:event_btTimActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed

        ResultSet rs = null;
        if (JOptionPane.showConfirmDialog(null, "Xac nhan them", "Chú ý", YES_NO_OPTION) == 0) {

            String[] query = {"insert into PHIEUMUON(NgayMuon,NgayHenTra,MaDocGia,SoLuongMuon) output inserted.SoPhieuMuon values(?,?,?,?)", "", "", "", ""};
            query[1] = tbNgayMuonN.getText();
            query[2] = tbNgayHenTra_FM.getText();
            query[3] = tbMaDG.getText();
            query[4] = "" + tableDSChon.getRowCount();

            try {
                rs = db.RunQuery_Get(query);
                rs.next();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi tao phieu muon:\n" + ex.getMessage());
                return;
            }

            String[] query_next = {"exec ThemCTPM ?,?", "", ""};
            for (int i = 0; i < tableDSChon.getRowCount(); i++) {
                query_next[1] = tableDSChon.getValueAt(i, 0).toString();// lay ma sach vao ctpm
                try {
                    query_next[2] = rs.getString(1); // lay so phieu muon vao ctpm
                    db.RunQuery(query_next);

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi tao moi CTPHIEUMUON:\n" + ex.getMessage());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "OKE!!\n");
            FATHER.LoadAfterCreatePM();
            this.dispose();
        }


    }//GEN-LAST:event_btThemActionPerformed

    private void btHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBoActionPerformed
        LayBangSach();
        DefaultTableModel model = (DefaultTableModel) tableDSChon.getModel();
        model.setRowCount(0);

        this.dispose();
    }//GEN-LAST:event_btHuyBoActionPerformed

    private void tableDSChonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSChonMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            //handle double click event.

            int selectedrow = tableDSChon.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) tableDSChon.getModel();

            DefaultTableModel modelroot = (DefaultTableModel) tableDSS.getModel();
            for (int i = 0; i < modelroot.getRowCount(); i++) {// tim neu co thi tang gia tri cua so luong len 
                if (modelroot.getValueAt(i, 0).toString().equals(model.getValueAt(selectedrow, 0))) {
                    modelroot.setValueAt(Integer.parseInt(modelroot.getValueAt(i, 2).toString()) + 1, i, 2);
                    model.removeRow(selectedrow);
                    return;
                }
            }
        }
    }//GEN-LAST:event_tableDSChonMouseClicked

    private boolean XACNHAN = false;
    private void btXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXacNhanActionPerformed

        if (!HANDLE.KiemTraNhap(new JTextField[]{tbNgayHenTra_FM, tbHoten, tbMaDG, tbNgayMuonN})) {
            JOptionPane.showMessageDialog(this, "Chua nhap day du thong tin!!");
            btXacNhan.setSelected(false);
            return;
        } else {
            if (btXacNhan.isSelected()) {
                btXacNhan.setText("<html><center><b>Huy<br>bo<b></html>");
                XACNHAN = true;

                tbMaDG.setEnabled(false);
                tbHoten.setEnabled(false);
                tbNgayMuonN.setEnabled(false);
                tbNgayHenTra_FM.setEnabled(false);

                btThem.setEnabled(true);

                btTim.setVisible(false);
            } else {
                btXacNhan.setText("<html><center><b>Xac<br>nhan<b></html>");
                XACNHAN = false;

                tbMaDG.setEnabled(true);
                tbHoten.setEnabled(true);
                tbNgayMuonN.setEnabled(true);
                tbNgayHenTra_FM.setEnabled(true);

                btThem.setEnabled(false);

                btTim.setVisible(true);
            }
        }
    }//GEN-LAST:event_btXacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(fThemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fThemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fThemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fThemPhieuMuon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                try {
//                    new fThemPhieuMuon().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(fThemPhieuMuon.class.getName()).log(Level.SEVERE, null, ex);
//                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuyBo;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btTim;
    private javax.swing.JToggleButton btXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableDSChon;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTextField tbHoten;
    private javax.swing.JTextField tbMaDG;
    private javax.swing.JFormattedTextField tbNgayHenTra_FM;
    private javax.swing.JFormattedTextField tbNgayMuonN;
    // End of variables declaration//GEN-END:variables
}
