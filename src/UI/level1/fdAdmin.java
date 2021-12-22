/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI.level1;

import BLL.MY_HANDLE;
import UI.level2.fdDoiMatKhau;
import img.IMG;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Gic
 */
public class fdAdmin extends javax.swing.JDialog {
    private final MY_HANDLE HANDLE;
    /**
     * Creates new form fdAdmin
     */
    public fdAdmin(java.awt.Frame parent, boolean modal,MY_HANDLE hd) {
        super(parent, modal);
        initComponents();
        HANDLE=hd;
        
        IMG img = new IMG();
        URL link = img.getClass().getResource("admin_1.png");
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(link);
            Image dimg = myPicture.getScaledInstance(lbCover.getWidth(), lbCover.getHeight(), Image.SCALE_SMOOTH);
            lbCover.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi lay anh bia:\n" + ex);
        }
        
        lbTenDangNhap.setText(HANDLE.tendn);
        lbHoTenQTV.setText(HANDLE.ten);
        lbEmailQTV.setText(HANDLE.mail);
//                lbTenDangNhap.setText("Muasaobang");
//        lbHoTenQTV.setText("ly quoc tao");
//        lbEmailQTV.setText("muasaobanglqt@gmail.com");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lbCover = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbTenDangNhap = new javax.swing.JLabel();
        lbHoTenQTV = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbEmailQTV = new javax.swing.JLabel();
        btDoiMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(211, 212, 195));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel3.setBackground(new java.awt.Color(167, 174, 130));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin quản trị viên", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbCover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/admin_1.png"))); // NOI18N
        jPanel3.add(lbCover, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 219, 220));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tên đăng nhập");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        lbTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        lbTenDangNhap.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTenDangNhap.setText("Ten dang nhap");
        jPanel3.add(lbTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, -1, -1));

        lbHoTenQTV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbHoTenQTV.setForeground(new java.awt.Color(255, 255, 255));
        lbHoTenQTV.setText("Ho ten");
        jPanel3.add(lbHoTenQTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Họ tên");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Email");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, -1, -1));

        lbEmailQTV.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbEmailQTV.setForeground(new java.awt.Color(255, 255, 255));
        lbEmailQTV.setText("Email");
        jPanel3.add(lbEmailQTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        btDoiMatKhau.setForeground(new java.awt.Color(0, 51, 51));
        btDoiMatKhau.setText("Đổi mật khẩu");
        btDoiMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btDoiMatKhauMousePressed(evt);
            }
        });
        jPanel3.add(btDoiMatKhau, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 470, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btDoiMatKhauMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDoiMatKhauMousePressed
       fdDoiMatKhau fdmk=new fdDoiMatKhau(null,true,HANDLE);
       fdmk.setLocationRelativeTo(null);
       fdmk.show();
    }//GEN-LAST:event_btDoiMatKhauMousePressed

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
            java.util.logging.Logger.getLogger(fdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fdAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fdAdmin dialog = new fdAdmin(new javax.swing.JFrame(), true,new MY_HANDLE());
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
    private javax.swing.JButton btDoiMatKhau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbCover;
    private javax.swing.JLabel lbEmailQTV;
    private javax.swing.JLabel lbHoTenQTV;
    private javax.swing.JLabel lbTenDangNhap;
    // End of variables declaration//GEN-END:variables
}
