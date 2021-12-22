/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI.level2;

import UI.level1.fQLSACH;
import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.TheLoai;
import UI.fMain1;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Gic
 */
public class fdThemTheLoai extends javax.swing.JDialog {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fQLSACH PARENT;
    private fMain1 MAIN;

    public fdThemTheLoai(JFrame main, boolean modal, fQLSACH parent, MY_HANDLE handle) throws SQLException {  //contructer them
        super(main, modal);
        initComponents();
        ltTitlle.setText("<html><b>Thêm thể loại</b></html>");

        tbMaTheLoai.setVisible(false);
        jLabel3.setVisible(false);

        this.getContentPane().setBackground(new Color(211, 212, 195));
        db = new MY_HANDLE_CONNECTION();
        HANDLE = handle;
        MAIN = (fMain1) main;
        PARENT = parent;

        btThem.setText("Thêm");
        tbMaTheLoai.setEnabled(false);

    }

    public fdThemTheLoai(JFrame main, boolean modal, fQLSACH parent, TheLoai tl, MY_HANDLE handle) throws SQLException {// sua
        super(main, modal);
        initComponents();
        ltTitlle.setText("<html><b>Sửa thể loại</b></html>");
        this.getContentPane().setBackground(new Color(211, 212, 195));
        db = new MY_HANDLE_CONNECTION();
        HANDLE = handle;
        MAIN = (fMain1) main;
        PARENT = parent;

        btThem.setText("Lưu lại");
        tbTenTheLoai.setText(tl.getTentl());
        tbMaTheLoai.setText(tl.getMatl());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTTSach = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tbTenTheLoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbMaTheLoai = new javax.swing.JTextField();
        btHuybo = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        ltTitlle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(211, 212, 195));

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnTTSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("<html><b>Tên thể loại</b><a style=\"color:red;\"> *</a></html>");
        pnTTSach.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, -1));

        tbTenTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTenTheLoai.setName("ten"); // NOI18N
        pnTTSach.add(tbTenTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 226, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mã thể loại");
        pnTTSach.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, -1));

        tbMaTheLoai.setEditable(false);
        tbMaTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaTheLoai.setEnabled(false);
        tbMaTheLoai.setName("ten"); // NOI18N
        pnTTSach.add(tbMaTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 226, -1));

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

        ltTitlle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        ltTitlle.setText("<html><b>Thêm thể loại</b></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(ltTitlle, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ltTitlle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        if (!HANDLE.KiemTraNhap(tbTenTheLoai)) {
            JOptionPane.showMessageDialog(this, "Nhập tên thể loại muốn thêm");
            return;
        }
        if (btThem.getText().equals("Thêm")) {

//            if(Neu trung thi){
//                JOptionPane.showMessageDialog(this, "Ten the loai da ton tai");
//                return;
//            }
            String[] query = {"insert into THELOAI(TenTheLoai) output inserted.MaTheLoai values(?)", ""};
            query[1] = tbTenTheLoai.getText();

            try {
                ResultSet rs = db.RunQuery_Get(query);
                rs.next();

                JOptionPane.showMessageDialog(this, "Thêm thể loại mới thành công!!\nMã thể loại: " + rs.getString(1) + "\nTên thể loại:" + tbTenTheLoai.getText());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm thể loại:\n" + ex.getMessage());
            }

            PARENT.LoadPanelSach();
        } else {//rot do day la ham sua ten the loai

            String[] query = {"update TheLoai set TenTheLoai=? where MaTheLoai=? ", "", ""};
            query[1] = tbTenTheLoai.getText();
            query[2] = tbMaTheLoai.getText();

            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Đã lưu thay đổi!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi sửa thể loại:\n" + ex.getMessage());
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
            java.util.logging.Logger.getLogger(fdThemTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fdThemTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fdThemTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fdThemTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                fdThemTheLoai dialog = new fdThemTheLoai(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btHuybo;
    private javax.swing.JButton btThem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel ltTitlle;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JTextField tbMaTheLoai;
    private javax.swing.JTextField tbTenTheLoai;
    // End of variables declaration//GEN-END:variables
}
