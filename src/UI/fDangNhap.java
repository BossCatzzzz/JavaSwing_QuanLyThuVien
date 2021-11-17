/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.TaiKhoan;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Magic
 */
public class fDangNhap extends javax.swing.JFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE handle;
  //  private fMain f;

    public fDangNhap() throws SQLException {
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        handle = new MY_HANDLE();
    }

    /**
     * form đăng nhập này được khởi tạo từ form main,có tham số truyền vào
     *
     * @param par: đây là form main
     * @param xl:class xử lý: class này chứa các hàm xử lý
     * @throws SQLException
     */
    public fDangNhap(JFrame par, MY_HANDLE xl) throws SQLException {
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        handle = xl;
    //    f = (fMain) par;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tbTenDangNhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbMatKhau = new javax.swing.JPasswordField();
        btDangNhap = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Tên đăng nhập ");

        jLabel2.setText("Mật khẩu ");

        btDangNhap.setText("Đăng nhập");
        btDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhapActionPerformed(evt);
            }
        });

        btThoat.setText("Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDangNhap)
                .addGap(45, 45, 45)
                .addComponent(btThoat)
                .addGap(74, 74, 74))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tbTenDangNhap)
                    .addComponent(tbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDangNhap)
                    .addComponent(btThoat))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhapActionPerformed
        try {
            if (handle.KiemTraDangNhap(tbTenDangNhap.getText(), tbMatKhau.getText().toString())) {
                JOptionPane.showMessageDialog(this, "Dang nhap thanh cong");
                tbMatKhau.setText("");
                tbTenDangNhap.setText("");
   //             f.LoginOK();
                db.Close();
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "Sai ten tai khoan hoac mat khau");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Loi khi dang nhap\n "+ex);
        }
    }//GEN-LAST:event_btDangNhapActionPerformed

//    public void after() {
//        if (f == null) {
//            try {
//                f = new fMain();
//            } catch (SQLException ex) {
//                Logger.getLogger(fThemPM_OK.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            f.setLocationRelativeTo(null);
//            f.show();
//
//        } else {
//            f.setLocationRelativeTo(null);
//            f.requestFocus();
//
//        }
//        tbMatKhau.setText("");
//        tbTenDangNhap.setText("");
//        this.dispose();
//    }

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed

        //after();
        tbMatKhau.setText("");
        tbTenDangNhap.setText("");
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btThoatActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

//        JOptionPane.showMessageDialog(this, "Close!!!!");
//        if (f == null) {
//            try {
//                f = new fMain();
//            } catch (SQLException ex) {
//                Logger.getLogger(fThemPM_OK.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            f.setLocationRelativeTo(null);
//            f.show();
//        } else {
//            f.setLocationRelativeTo(null);
//            f.show();
//            f.requestFocus();
//        }
//        return;
    }//GEN-LAST:event_formWindowClosed

//             if (f== null) {
//             try {
//                 f=new fThemPhieuMuon();
//             } catch (SQLException ex) {
//                 Logger.getLogger(fThemPM_OK.class.getName()).log(Level.SEVERE, null, ex);
//             }
//            f.setLocationRelativeTo(null);
//            f.show();
//        } else {
//            f.setLocationRelativeTo(null);
//            f.show();
//            f.requestFocus();
//        }
//         this.dispose();
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
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new fDangNhap().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(fDangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangNhap;
    private javax.swing.JButton btThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField tbMatKhau;
    private javax.swing.JTextField tbTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
