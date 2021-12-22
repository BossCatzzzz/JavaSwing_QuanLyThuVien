/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI.level2;

import UI.level1.fQLSACH;
import BLL.MY_HANDLE;
import Bookcovers.BookCover_Handle;
import DAL.MY_HANDLE_CONNECTION;
import DTO.Sach;
import UI.fMain1;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import static java.nio.file.StandardCopyOption.*;
import java.sql.ResultSet;

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

    public fdThemSach(JFrame main, boolean modal, fQLSACH parent, MY_HANDLE handle) throws SQLException {
        super(main, modal);
        initComponents();
        lbTitle.setText("<html><b>Thêm sách</b></html>");
        this.getContentPane().setBackground(new Color(211, 212, 195));
        db = new MY_HANDLE_CONNECTION();
        HANDLE = handle;
        MAIN = (fMain1) main;
        PARENT = parent;
        Combobox_load();

        btThem.setText("Thêm");
        tbMaSach.setVisible(false);
        lbMasach.setVisible(false);

    }

    public fdThemSach(JFrame main, boolean modal, fQLSACH parent, Sach s, MY_HANDLE handle) throws SQLException {
        super(main, modal);
        initComponents();
        lbTitle.setText("<html><b>Sửa sách</b></html>");
        this.getContentPane().setBackground(new Color(211, 212, 195));
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
        cbbTheLoai.setSelectedItem(HANDLE.MAPTHELOAI.get(s.getTenTheLoai()));
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
        btChonFile = new javax.swing.JButton();
        lbAnhChon = new javax.swing.JLabel();
        btHuybo = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(211, 212, 195));

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnTTSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMasach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbMasach.setText("<html><b>Mã sách</b></html>");
        pnTTSach.add(lbMasach, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 33, 89, -1));

        tbMaSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaSach.setEnabled(false);
        tbMaSach.setFocusable(false);
        pnTTSach.add(tbMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 226, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("<html><b>Tóm tắt</b></html>");
        pnTTSach.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 89, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("<html><b>Tác giả</b></html> ");
        pnTTSach.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 89, -1));

        tbTacGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnTTSach.add(tbTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 226, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("<html><b>Tên sách</b><a style=\"color:red;\"> *</a></html>");
        pnTTSach.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 82, 89, -1));

        tbTenSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTenSach.setName("ten"); // NOI18N
        pnTTSach.add(tbTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 79, 226, -1));

        cbbTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnTTSach.add(cbbTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 226, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("<html><b>Thể loại</b><a style=\"color:red; \"> *</a></html>");
        pnTTSach.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 89, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("<html><b>Số lượng</b><a style=\"color:red;\"> *</a></html>");
        pnTTSach.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        tbSoluong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbSoluong.setName("sl"); // NOI18N
        pnTTSach.add(tbSoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 226, -1));

        jScrollPane1.setViewportView(jTextPane1);

        pnTTSach.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 226, 70));

        btChonFile.setText("Chọn ảnh");
        btChonFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChonFileActionPerformed(evt);
            }
        });
        pnTTSach.add(btChonFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 269, -1, -1));

        lbAnhChon.setText("<html><p style=padding-left:50px;\"\">Ảnh bìa</p></html>");
        lbAnhChon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.add(lbAnhChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 31, 178, 226));

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

        lbTitle.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lbTitle.setText("<html><b>Thêm sách</b></html>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(158, Short.MAX_VALUE)
                .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
            .addComponent(pnTTSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btHuybo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        if (!HANDLE.KiemTraNhap(pnTTSach)) {
            JOptionPane.showMessageDialog(this, "Chưa điền đầy đủ thông tin");
            return;
        }

        try {
            if (Integer.parseInt(tbSoluong.getText()) < 0) {
                JOptionPane.showMessageDialog(this, "CHÚ Ý!!\nSố lượng phải lớn hơn hoặc bằng 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số");
            tbSoluong.setText("");
            return;
        }

        if (btThem.getText().equals("Thêm")) {
            String[] query = {"insert into SACH(TenSach,SoLuong,MaTheLoai,TomTat,TacGia) output inserted.MaSach values(?,?,?,?,?)", "", "", "", "", ""};
            query[1] = tbTenSach.getText();
            query[2] = tbSoluong.getText();
            query[3] = HANDLE.getKey(HANDLE.MAPTHELOAI, cbbTheLoai.getSelectedItem().toString());
            query[4] = jTextPane1.getText();
            query[5] = tbTacGia.getText();
            ResultSet rs = null;
            try {
                rs = db.RunQuery_Get(query);
                rs.next();

                if (fANHBIA != null) {
                    Path sour = Paths.get(fANHBIA.getAbsolutePath());

                    String extension = "";
                    int i = fANHBIA.getName().lastIndexOf('.');
                    if (i > 0) {
                        extension = fANHBIA.getName().substring(i + 1);
                    }

                    Path des = Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + rs.getString(1) + "." + extension);

                    try {
                        Files.copy(sour, des, REPLACE_EXISTING);
                        //lbAnhChon.setIcon(new ImageIcon(f.getAbsolutePath()));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi khi lưu ảnh:\n" + ex.getMessage());
                    }
                }

                JOptionPane.showMessageDialog(this, "Đã thêm sách!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm sách:\n" + ex.getMessage());
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

                if (fANHBIA != null) {//tuc la co chon anh khac
                    
                    try {
                        Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + tbMaSach.getText() + ".jpg"));
                        Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + tbMaSach.getText() + ".png"));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Loi khi xoa anh bia!!\n" + ex.getMessage());
                    }
                    
                    Path sour = Paths.get(fANHBIA.getAbsolutePath());

                    String extension = "";
                    int i = fANHBIA.getName().lastIndexOf('.');
                    if (i > 0) {
                        extension = fANHBIA.getName().substring(i + 1);
                    }

                    Path des = Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + tbMaSach.getText() + "." + extension);

                    try {
                        Files.copy(sour, des, REPLACE_EXISTING);
                        //lbAnhChon.setIcon(new ImageIcon(f.getAbsolutePath()));
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi khi lưu ảnh:\n" + ex.getMessage());
                    }
                }

                JOptionPane.showMessageDialog(this, "Đã lưu thay đổi!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi sửa thông tin sách:\n" + ex.getMessage());
            }
        }

        PARENT.LoadPanelSach();
        this.dispose();
    }//GEN-LAST:event_btThemActionPerformed

    private void btHuyboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHuyboActionPerformed
        this.dispose();
    }//GEN-LAST:event_btHuyboActionPerformed

    File fANHBIA;
    private void btChonFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChonFileActionPerformed
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Hình ảnh", "jpg", "png");
        fc.setFileFilter(filter);
        fc.setMultiSelectionEnabled(false);
        BookCover_Handle flag = new BookCover_Handle();
        if (fc.showDialog(this, "Chọn file") == JFileChooser.APPROVE_OPTION) {
            fANHBIA = fc.getSelectedFile();
            BufferedImage myPicture;
            try {
                myPicture = ImageIO.read(fANHBIA);
                lbAnhChon.setIcon(new ImageIcon(myPicture.getScaledInstance(lbAnhChon.getWidth(), lbAnhChon.getHeight(), Image.SCALE_SMOOTH)));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi hiển thị ảnh:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btChonFileActionPerformed

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
    private javax.swing.JButton btChonFile;
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
    private javax.swing.JLabel lbAnhChon;
    private javax.swing.JLabel lbMasach;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JTextField tbMaSach;
    private javax.swing.JTextField tbSoluong;
    private javax.swing.JTextField tbTacGia;
    private javax.swing.JTextField tbTenSach;
    // End of variables declaration//GEN-END:variables
}
