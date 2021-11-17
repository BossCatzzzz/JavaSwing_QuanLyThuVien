/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gic
 */
public class fdThemDG extends javax.swing.JDialog {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fQLDOCGIA PARENT;
    private fMain1 MAIN;
    private DocGia EDIT;

    /**
     * này để tạo form thêm
     * @param main
     * @param modal
     * @param parent
     * @throws SQLException 
     */
    public fdThemDG(JFrame main, boolean modal,fQLDOCGIA parent) throws SQLException {
        super(main, modal);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = new MY_HANDLE();

        btThemDG.setText("Thêm");
        tbMaDG.setVisible(false);
        lbMaDG.setVisible(false);
        MAIN = (fMain1) main;
        PARENT = parent;
    }

    /**
     * constructor này để tạo form sửa
     * @param main
     * @param parent
     * @param modal
     * @param dg
     * @throws SQLException
     */
    public fdThemDG(JFrame main, boolean modal, fQLDOCGIA parent, DocGia dg) throws SQLException {
        super(main, modal);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = new MY_HANDLE();
        MAIN = (fMain1) main;
        EDIT = dg;
        PARENT = parent;
        btThemDG.setText("Lưu lại");
        tbTenDG.setText(dg.getTen());
        tbSDTDG.setText(dg.getSdt());
        tbDiaChi.setText(dg.getDiachi());
        tbCMTDG.setText(dg.getCmnd());
        tbMaDG.setText(dg.getMa());
        if(dg.Gioitinh().equals("1"))
            rdbtNam.setSelected(true);
        else
            rdbtNu.setSelected(true);
    }

    private fdThemDG(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnTTDG = new javax.swing.JPanel();
        lbMaDG = new javax.swing.JLabel();
        tbMaDG = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tbCMTDG = new javax.swing.JTextField();
        tbDiaChi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tbTenDG = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tbSDTDG = new javax.swing.JTextField();
        rdbtNam = new javax.swing.JRadioButton();
        rdbtNu = new javax.swing.JRadioButton();
        btThemDG = new javax.swing.JButton();
        btHuyBo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnTTDG.setBackground(new java.awt.Color(167, 174, 130));
        pnTTDG.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTDG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbMaDG.setText("Mã độc giả");
        pnTTDG.add(lbMaDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 55, -1, -1));

        tbMaDG.setEditable(false);
        tbMaDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaDG.setEnabled(false);
        pnTTDG.add(tbMaDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 52, 226, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Số CMT/ CCCD");
        pnTTDG.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 251, -1, -1));

        tbCMTDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbCMTDG.setName("cmt"); // NOI18N
        pnTTDG.add(tbCMTDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 248, 226, -1));

        tbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbDiaChi.setName("diachi"); // NOI18N
        pnTTDG.add(tbDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 150, 370, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Tên độc giả");
        pnTTDG.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 104, -1, -1));

        tbTenDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTenDG.setName("ten"); // NOI18N
        pnTTDG.add(tbTenDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 101, 226, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Địa chỉ");
        pnTTDG.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 153, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Sđt");
        pnTTDG.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 202, -1, -1));

        tbSDTDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbSDTDG.setName("sdt"); // NOI18N
        pnTTDG.add(tbSDTDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 199, 226, -1));

        buttonGroup1.add(rdbtNam);
        rdbtNam.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtNam.setSelected(true);
        rdbtNam.setText("Nam");
        pnTTDG.add(rdbtNam, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 102, -1, -1));

        buttonGroup1.add(rdbtNu);
        rdbtNu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtNu.setText("Nữ");
        pnTTDG.add(rdbtNu, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 102, -1, -1));

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

        btHuyBo.setText("Hủy bỏ");
        btHuyBo.setMaximumSize(new java.awt.Dimension(72, 72));
        btHuyBo.setMinimumSize(new java.awt.Dimension(72, 72));
        btHuyBo.setName(""); // NOI18N
        btHuyBo.setPreferredSize(new java.awt.Dimension(72, 72));
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
                .addGap(132, 132, 132)
                .addComponent(btThemDG, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addGap(74, 74, 74)
                .addComponent(btHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTTDG, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHuyBo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(106, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemDGActionPerformed
        if (!HANDLE.KiemTraNhap(pnTTDG)) {
            JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
            return;
        }

        if (btThemDG.getText().equals("Thêm")) {
            String[] query = {"insert into DOCGIA(TenDocGia,DiaChi,Sdt,CMND,GioiTinh) values(?,?,?,?,?)", "", "", "", "", ""};
            query[1] = tbTenDG.getText();
            query[2] = tbDiaChi.getText();
            query[3] = tbSDTDG.getText();
            query[4] = tbCMTDG.getText();
            query[5] = rdbtNam.isSelected() ? "1" : "0";
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Them Doc gia thanh cong!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi them Doc gia:\n" + ex.getMessage());
            }
        } 
        // xuong day tuc la chuc nang sua ========================================================================
        else {
            String[] query = {"update DOCGIA set TenDocGia=?,DiaChi=?,Sdt=?,CMND=?,GioiTinh=? where MaDocGia=? ", "", "", "", "", "",""};
            query[1] = tbTenDG.getText();
            query[2] = tbDiaChi.getText();
            query[3] = tbSDTDG.getText();
            query[4] = tbCMTDG.getText();
            query[5]=(rdbtNam.isSelected())?"1":"0";
            query[6] = EDIT.getMa();

            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Luu thay doi Doc gia thanh cong!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi sua Doc gia:\n" + ex.getMessage());
            }
        }
        PARENT.LoadPannelDocGia();
        this.dispose();
    }//GEN-LAST:event_btThemDGActionPerformed

    private void btHuyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyBoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btHuyBoActionPerformed

    
// <editor-fold defaultstate="collapsed" desc="Generated Code"> 
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
            java.util.logging.Logger.getLogger(fdThemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fdThemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fdThemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fdThemDG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                fdThemDG dialog = null;
                dialog = new fdThemDG(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btHuyBo;
    private javax.swing.JButton btThemDG;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel lbMaDG;
    private javax.swing.JPanel pnTTDG;
    private javax.swing.JRadioButton rdbtNam;
    private javax.swing.JRadioButton rdbtNu;
    private javax.swing.JTextField tbCMTDG;
    private javax.swing.JTextField tbDiaChi;
    private javax.swing.JTextField tbMaDG;
    private javax.swing.JTextField tbSDTDG;
    private javax.swing.JTextField tbTenDG;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>
