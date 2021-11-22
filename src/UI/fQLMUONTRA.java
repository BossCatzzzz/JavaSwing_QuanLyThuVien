/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.TTPhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class fQLMUONTRA extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private final fMain1 MAIN;
    private int CHONPHIEUMUON;
    private fThemPhieuMuon fThemPM;

    public fQLMUONTRA(fMain1 f, MY_HANDLE xl) throws SQLException {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = xl;
        MAIN = f;

        LoadAfterCreatePM();
    }

    public void LoadAfterCreatePM() {
        MAIN.LoadPhieuMuon();
        LayBangPhieuMuon();
        btTraSach.setVisible(false);

        CHONPHIEUMUON = -1;
    }

    private void ChonDongPhieuMuon() {
        CHONPHIEUMUON = tablePhieuMuon.getSelectedRow();
        if (CHONPHIEUMUON < 0 || CHONPHIEUMUON >= HANDLE.PHIEUMUONLIST.size()) {
            return;
        }

        String sophieumuon = HANDLE.ExcludeHTML(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 0).toString());
        tbSo_PM.setText(sophieumuon);
        tbTenDG_PM.setText(HANDLE.ExcludeHTML(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 1).toString()));
        tbNgayMuon.setText(HANDLE.ExcludeHTML(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 2).toString()));
        tbNgayHen.setText(HANDLE.ExcludeHTML(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 3).toString()));
        String ngaytra = HANDLE.ExcludeHTML(tablePhieuMuon.getValueAt(CHONPHIEUMUON, 4).toString());
        if (ngaytra == null || ngaytra.equals("null")) {
            ngaytra = "chưa trả";
            btTraSach.setVisible(true);
        } else {
            ngaytra = tablePhieuMuon.getValueAt(CHONPHIEUMUON, 4).toString();
            btTraSach.setVisible(false);
        }

        tbNgayTra.setText(ngaytra);

        LayBangChiTietPhieuMuon("select TenSach from CTPHIEUMUON,SACH where SACH.MaSach=CTPHIEUMUON.MaSach and SoPhieuMuon=" + sophieumuon);
    }

    private void LayBangPhieuMuon() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        for (TTPhieuMuon tTPhieuMuon : HANDLE.PHIEUMUONLIST) {
            model.addRow(tTPhieuMuon.ToListString());

        }
    }

    private void LayBangChiTietPhieuMuon(String query) {
        String[] tenCot = {"Danh sách sách mượn"};
        DefaultTableModel model = new DefaultTableModel(tenCot, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tensach;
        try {
            ResultSet rs = db.RunQuery(query);
            while (rs.next()) {
                tensach = rs.getString(1);
                model.addRow(new Object[]{tensach});
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu:\n" + ex.getMessage());
        }
        tableCTPM.setModel(model);
    }

    public void search() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        for (TTPhieuMuon item : HANDLE.PHIEUMUONLIST) {
            if (item.SearchOnAll(tbTImkiemPhieuMuon.getText().trim())) {
                model.addRow(item.ToListString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpnPhieuMuon = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePhieuMuon = new javax.swing.JTable();
        pnThongTinPhieuMuon = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCTPM = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        tbSo_PM = new javax.swing.JTextField();
        tbTenDG_PM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tbNgayMuon = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tbNgayHen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbNgayTra = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tbTImkiemPhieuMuon = new javax.swing.JTextField();
        btThemPhieuMuon = new javax.swing.JButton();
        btTraSach = new javax.swing.JButton();

        tabpnPhieuMuon.setBackground(new java.awt.Color(211, 212, 195));

        jScrollPane2.setBackground(new java.awt.Color(225, 236, 243));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablePhieuMuon.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tablePhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "So phieu", "Ten Doc gia", "Ngay muon", "Ngay hen tra", "Ngay tra", "So luong"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePhieuMuon.setFillsViewportHeight(true);
        tablePhieuMuon.setRowHeight(40);
        tablePhieuMuon.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tablePhieuMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePhieuMuonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePhieuMuon);

        pnThongTinPhieuMuon.setBackground(new java.awt.Color(167, 174, 130));
        pnThongTinPhieuMuon.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableCTPM.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tableCTPM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Danh sách sách mượn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCTPM.setAutoscrolls(false);
        tableCTPM.setFillsViewportHeight(true);
        tableCTPM.setRowHeight(40);
        tableCTPM.setRowSelectionAllowed(false);
        tableCTPM.setSelectionBackground(new java.awt.Color(0, 100, 50));
        jScrollPane3.setViewportView(tableCTPM);

        jLabel7.setText("So phieu:");

        tbSo_PM.setEditable(false);

        tbTenDG_PM.setEditable(false);

        jLabel8.setText("Ten Doc gia:");

        tbNgayMuon.setEditable(false);

        jLabel9.setText("Ngay muon:");

        tbNgayHen.setEditable(false);

        jLabel10.setText("Ngay hen tra:");

        tbNgayTra.setEditable(false);

        jLabel11.setText("Ngay tra:");

        javax.swing.GroupLayout pnThongTinPhieuMuonLayout = new javax.swing.GroupLayout(pnThongTinPhieuMuon);
        pnThongTinPhieuMuon.setLayout(pnThongTinPhieuMuonLayout);
        pnThongTinPhieuMuonLayout.setHorizontalGroup(
            pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                        .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNgayHen, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbTenDG_PM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbSo_PM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnThongTinPhieuMuonLayout.setVerticalGroup(
            pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinPhieuMuonLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tbSo_PM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tbTenDG_PM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tbNgayMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tbNgayHen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnThongTinPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tbNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btThemPhieuMuon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_doc.png"))); // NOI18N
        btThemPhieuMuon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemPhieuMuonActionPerformed(evt);
            }
        });

        btTraSach.setText("Trả sách");
        btTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTraSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabpnPhieuMuonLayout = new javax.swing.GroupLayout(tabpnPhieuMuon);
        tabpnPhieuMuon.setLayout(tabpnPhieuMuonLayout);
        tabpnPhieuMuonLayout.setHorizontalGroup(
            tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
                    .addComponent(tbTImkiemPhieuMuon))
                .addGap(18, 18, 18)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(btTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnThongTinPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btThemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        tabpnPhieuMuonLayout.setVerticalGroup(
            tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnPhieuMuonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btThemPhieuMuon)))
                .addGap(18, 18, 18)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(pnThongTinPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabpnPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabpnPhieuMuon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePhieuMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePhieuMuonMouseClicked
        ChonDongPhieuMuon();
    }//GEN-LAST:event_tablePhieuMuonMouseClicked


    private void btThemPhieuMuonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemPhieuMuonActionPerformed

        MAIN.LoadSach();
        fThemPM = null;
        try {
            fThemPM = new fThemPhieuMuon(this, HANDLE);
        } catch (SQLException ex) {

        }

        fThemPM.setLocationRelativeTo(null);
        fThemPM.show();
        //fThemPM.requestFocus();
    }//GEN-LAST:event_btThemPhieuMuonActionPerformed

    private void btTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTraSachActionPerformed
        // khi click nut nay thi cap nhat ngay hiên tai vao ngay tra, ++++++++++++++++++++++++++++++++++++++++++++++++++
        //dong thoi lay ra tat ca ctpm cua phieu nay, moi ctpm kiem tra ma sach va tang sl sach do len 1+++++++++++++++++++++++++++++

        if (JOptionPane.showConfirmDialog(null, "Xac nhan da tra", "Chú ý", YES_NO_OPTION) == 0) {

            String[] query = {"update PHIEUMUON set NgayTraThucTe=? where SoPhieuMuon=? ", "", ""};
            query[1] = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yy"));

            query[2] = tbSo_PM.getText();
            String query_next = "select MaSach from CTPHIEUMUON where SoPhieuMuon=" + tbSo_PM.getText();

            try {
                ResultSet rs = db.RunQuery(query_next);
                while (rs.next()) {
                    String masachcancapnhat = rs.getString(1);
                    String[] query_next_next = {"update SACH set SoLuong=(SoLuong+1) where MaSach=?", "" + masachcancapnhat};
                    db.RunQuery(query_next_next);
                }
                db.RunQuery(query);
                //  LoadAfterCreatePM();
                HANDLE.ClearTextBox(pnThongTinPhieuMuon);
                JOptionPane.showMessageDialog(this, "Da cap nhat!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi cap nhat phieu muon:\n" + ex.getMessage());
            }
        }
        LoadAfterCreatePM();
    }//GEN-LAST:event_btTraSachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThemPhieuMuon;
    private javax.swing.JButton btTraSach;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel pnThongTinPhieuMuon;
    private javax.swing.JTable tableCTPM;
    private javax.swing.JTable tablePhieuMuon;
    private javax.swing.JPanel tabpnPhieuMuon;
    private javax.swing.JTextField tbNgayHen;
    private javax.swing.JTextField tbNgayMuon;
    private javax.swing.JTextField tbNgayTra;
    private javax.swing.JTextField tbSo_PM;
    private javax.swing.JTextField tbTImkiemPhieuMuon;
    private javax.swing.JTextField tbTenDG_PM;
    // End of variables declaration//GEN-END:variables
}
