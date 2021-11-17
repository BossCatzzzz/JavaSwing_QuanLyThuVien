/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.Sach;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gic
 */
public class fdThemSach extends javax.swing.JDialog {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fQLSACH PARENT;
    private fMain1 MAIN;
    private Sach EDIT;

    public fdThemSach(JFrame main, boolean modal, fQLSACH parent,MY_HANDLE handle) throws SQLException {
        super(main, modal);
        initComponents();

        db = new MY_HANDLE_CONNECTION();
        HANDLE = handle;
        MAIN = (fMain1) main;
        PARENT = parent;
        Combobox_load();

        btThem.setText("Thêm");
        tbMaSach.setVisible(false);
        lbMasach.setVisible(false);
    }

    public fdThemSach(JFrame main, boolean modal, fQLSACH parent, Sach s,MY_HANDLE handle) throws SQLException {
        super(main, modal);
        initComponents();

        db = new MY_HANDLE_CONNECTION();
        HANDLE = handle;
        MAIN = (fMain1) main;
        PARENT = parent;
        EDIT = s;
        Combobox_load();

        btThem.setText("Lưu lại");
        tbMaSach.setText(s.getMaSach());
        tbTenSach.setText(s.getTenSach());
        tbSoluong.setText(s.getSoLuong() + "");
        tbTacGia.setText(s.getTacgia());
        jTextPane1.setText(s.getTomTat());
        cbbTheLoai.setSelectedItem(HANDLE.MAPTHELOAI.get(s.getMaTheLoai()));
    }

    private void Combobox_load() {

        for (Map.Entry<String, String> entry : HANDLE.MAPTHELOAI.entrySet()) {
            cbbTheLoai.addItem(entry.getValue());
        }
    }

    private fdThemSach(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTTSach = new javax.swing.JPanel();
        lbMasach = new javax.swing.JLabel();
        tbMaSach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tbTacGia = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbTenSach = new javax.swing.JTextField();
        cbbTheLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbSoluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        btHuybo = new javax.swing.JButton();
        btThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbMasach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbMasach.setText("Ma sach");

        tbMaSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaSach.setEnabled(false);
        tbMaSach.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Tom tat");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Tac gia");

        tbTacGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Ten sach");

        tbTenSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTenSach.setName("ten"); // NOI18N

        cbbTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("The loai");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("So luong");

        tbSoluong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbSoluong.setName("sl"); // NOI18N

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout pnTTSachLayout = new javax.swing.GroupLayout(pnTTSach);
        pnTTSach.setLayout(pnTTSachLayout);
        pnTTSachLayout.setHorizontalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnTTSachLayout.createSequentialGroup()
                            .addComponent(lbMasach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(42, 42, 42)
                            .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33))
        );
        pnTTSachLayout.setVerticalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTSachLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMasach)
                    .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26))
        );

        btHuybo.setText("Hủy bỏ");
        btHuybo.setMaximumSize(new java.awt.Dimension(72, 72));
        btHuybo.setMinimumSize(new java.awt.Dimension(72, 72));
        btHuybo.setName(""); // NOI18N
        btHuybo.setPreferredSize(new java.awt.Dimension(72, 72));
        btHuybo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHuyboActionPerformed(evt);
            }
        });

        btThem.setText("Thêm");
        btThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btThem.setMinimumSize(new java.awt.Dimension(72, 72));
        btThem.setName("add"); // NOI18N
        btThem.setPreferredSize(new java.awt.Dimension(72, 72));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnTTSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(381, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 138, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        if (!HANDLE.KiemTraNhap(pnTTSach)) {
            JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
            return;
        }
        if (Integer.parseInt(tbSoluong.getText()) < 1) {
            JOptionPane.showMessageDialog(this, "Chu Y!!\nSo luong phai lon hon 0");
            return;
        }
        if (btThem.getText().equals("Thêm")) {
            String[] query = {"insert into SACH(TenSach,SoLuong,MaTheLoai,TomTat,TacGia) values(?,?,?,?,?)", "", "", "", "", ""};
            query[1] = tbTenSach.getText();
            query[2] = tbSoluong.getText();
            query[3] = HANDLE.getKey(HANDLE.MAPTHELOAI, cbbTheLoai.getSelectedItem().toString());
            query[4] = jTextPane1.getText();
            query[5] = tbTacGia.getText();
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Them sach thanh cong!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi them sach:\n" + ex.getMessage());
            }
        } else {
            String[] query = {"update SACH set TenSach=?,SoLuong=?,MaTheLoai=?,TomTat=?,TacGia=? where MaSach=? ", "", "", "", "", "", ""};
            query[1] = tbTenSach.getText();
            query[2] = tbSoluong.getText();
            query[3] = HANDLE.getKey(HANDLE.MAPTHELOAI, cbbTheLoai.getSelectedItem().toString());
            query[4] = jTextPane1.getText();
            query[5] = tbTacGia.getText();
            query[6] = tbMaSach.getText();
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Luu thay doi sach thanh cong!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi sua thong tin sach:\n" + ex.getMessage());
            }
        }
        PARENT.LoadPanelSach();
        this.dispose();
    }//GEN-LAST:event_btThemActionPerformed

    private void btHuyboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyboActionPerformed
        this.dispose();
    }//GEN-LAST:event_btHuyboActionPerformed

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
            java.util.logging.Logger.getLogger(fdThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fdThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fdThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fdThemSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fdThemSach dialog = new fdThemSach(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuybo;
    private javax.swing.JButton btThem;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lbMasach;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JTextField tbMaSach;
    private javax.swing.JTextField tbSoluong;
    private javax.swing.JTextField tbTacGia;
    private javax.swing.JTextField tbTenSach;
    // End of variables declaration//GEN-END:variables
}
