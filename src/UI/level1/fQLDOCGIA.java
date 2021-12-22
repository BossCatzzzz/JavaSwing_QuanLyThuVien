package UI.level1;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.DocGia;
import UI.fMain1;
import UI.level2.fdThemDG;
import img.IMG;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
        tableDSDG.removeColumn(tableDSDG.getColumnModel().getColumn(5));
    }

    public void LoadPannelDocGia() {
        MAIN.LoadDocGia();
        LayBangDG();
        CHONDOCGIA = -1;
        
        lbTenDG.setText("");
        lbMaDG.setText("");
        lbSDT.setText("");
        lbCMNDDG.setText("");
        lbDiaChi.setText("");
        lbHinhAnh.setIcon(null);
    }

    private void ChonDongDocGia() {
        CHONDOCGIA = tableDSDG.getSelectedRow();
        if (CHONDOCGIA < 0 || CHONDOCGIA >= HANDLE.DOCGIALIST.size()) {
            return;
        }
        IMG fl = new IMG();

        String imgname = (tableDSDG.getModel().getValueAt(CHONDOCGIA, 5).toString().equals("1")) ? "male" : "female";
        imgname += ".png";
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
    public void search() {
        DefaultTableModel model = (DefaultTableModel) tableDSDG.getModel();
        model.setRowCount(0);
        for (DocGia item : HANDLE.DOCGIALIST) {
            if (item.SearchOnAll(tbTImkiemDocGia.getText().trim())) {
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
        tbTImkiemDocGia = new javax.swing.JTextField();
        btThemDG = new javax.swing.JButton();
        btSuaDG = new javax.swing.JButton();
        btXoaDG = new javax.swing.JButton();

        tabpnDocGia.setBackground(new java.awt.Color(211, 212, 195));

        tableDSDG.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tableDSDG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Địa chỉ", "Số ĐT", "CMND", "Giới tính"
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
        pnTTDG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnTTDG.add(lbHinhAnh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 150));

        lbMaDG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaDG.setText("Ma Doc gia");
        pnTTDG.add(lbMaDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, -1));

        lbTenDG.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTenDG.setText("Ho Ten");
        pnTTDG.add(lbTenDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, -1, -1));

        lbCMNDDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCMNDDG.setText("CMND");
        pnTTDG.add(lbCMNDDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        lbDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaChi.setText("Dia chi");
        pnTTDG.add(lbDiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, -1));

        lbSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSDT.setText("SDT");
        pnTTDG.add(lbSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        tbTImkiemDocGia.getDocument().addDocumentListener(new DocumentListener() {
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
        tbTImkiemDocGia.setBackground(new java.awt.Color(211, 212, 195));
        tbTImkiemDocGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTImkiemDocGia.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm Độc giả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        btThemDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btThemDG.setText("Thêm");
        btThemDG.setMaximumSize(new java.awt.Dimension(72, 72));
        btThemDG.setMinimumSize(new java.awt.Dimension(72, 72));
        btThemDG.setName(""); // NOI18N
        btThemDG.setPreferredSize(new java.awt.Dimension(72, 72));
        btThemDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemDGActionPerformed(evt);
            }
        });

        btSuaDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSuaDG.setText("Sửa");
        btSuaDG.setMaximumSize(new java.awt.Dimension(72, 72));
        btSuaDG.setMinimumSize(new java.awt.Dimension(72, 72));
        btSuaDG.setName(""); // NOI18N
        btSuaDG.setPreferredSize(new java.awt.Dimension(72, 72));
        btSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaDGActionPerformed(evt);
            }
        });

        btXoaDG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btXoaDG.setText("Xóa");
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
                    .addComponent(tbTImkiemDocGia)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(btSuaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(btXoaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        tabpnDocGiaLayout.setVerticalGroup(
            tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(tbTImkiemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btThemDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabpnDocGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(tabpnDocGiaLayout.createSequentialGroup()
                        .addComponent(pnTTDG, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    }//GEN-LAST:event_btThemDGActionPerformed

    private void btSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaDGActionPerformed
        if (CHONDOCGIA != -1) {
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
    private javax.swing.JTextField tbTImkiemDocGia;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>     
