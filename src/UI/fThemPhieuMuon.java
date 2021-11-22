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
import DTO.TheLoai;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private MY_HANDLE HANDLE=new MY_HANDLE();

//    public fThemPhieuMuon(MY_HANDLE xuly, JFrame main) throws SQLException {
//        initComponents();
//        this.getContentPane().setBackground(new Color(211, 212, 195));
//        db = new MY_HANDLE_CONNECTION();
//        HANDLE = xuly;
//        tbNgayMuonN.setText(java.time.LocalDate.now().toString());
//        LayBangSach();
//        LayBangTheLoai();
//    }

    public fThemPhieuMuon(fQLMUONTRA f, MY_HANDLE xuly) throws SQLException {
        initComponents();
        this.getContentPane().setBackground(new Color(211, 212, 195));
        db = new MY_HANDLE_CONNECTION();
        FATHER = f;
        HANDLE = xuly;
        tbNgayMuonN.setText(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yy")));
        LayBangSach();
        LayBangTheLoai();
        btXacNhan.setEnabled(false);
        btThem.setEnabled(false);
    }

    private void LayBangSach() {
        DefaultTableModel modelroot = (DefaultTableModel) tableDSS.getModel();
        modelroot.setRowCount(0);
        for (Sach item : HANDLE.SACHLIST) {
//            if (item.getSoLuong() > 0) {
                modelroot.addRow(new Object[]{item.getMaSach(), item.getTenSach(), item.getSoLuong()});
//            }
        }
    }
        private void LayBangTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableTheLoai.getModel();
        model.setRowCount(0);
        for (TheLoai theLoai : HANDLE.THELOAILIST) {
  
            model.addRow(theLoai.ToListString());
            
        }
        model.addRow(new String[]{"", "<html><b style=\"padding-left:50px\">*Tất cả thể loại*</b></html>"});
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        pnDSSM = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTheLoai = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanel2.setBackground(new java.awt.Color(167, 174, 130));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin phiếu mượn"));

        jPanel1.setBackground(new java.awt.Color(167, 174, 130));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tbMaDG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btTim.setText("Tìm");
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("<html><b>Họ tên</b></html>\\");

            jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel2.setText("<html><b>Mã Độc giả</b><a style=\"color:red;\"> *</a></html>");

            tbHoten.setEditable(false);
            tbHoten.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

            jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel3.setText("<html><b>Ngày mượn</b></html>");

            jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            jLabel4.setText("<html><b>Hẹn trả</b></html>");

            tbNgayHenTra_FM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));
            tbNgayHenTra_FM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

            btXacNhan.setText("<html><center><b>Xac<br>nhan<b></html>");
            btXacNhan.setActionCommand("<html><b><center>Xac<br><center>nhan<b></html>");
            btXacNhan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btXacNhanActionPerformed(evt);
                }
            });

            tbNgayMuonN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

            // Code adding the component to the parent container - not shown here
            tbNgayMuonN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yy"))));
            tbNgayMuonN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbNgayHenTra_FM, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbNgayMuonN, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                    .addComponent(tbMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btTim))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(18, 18, 18)
                    .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbMaDG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbHoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbNgayMuonN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbNgayHenTra_FM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23))
            );

            tableDSChon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
            tableDSChon.setRowHeight(40);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            tableTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
            tableTheLoai.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã", "Thể loại"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            tableTheLoai.setFillsViewportHeight(true);
            tableTheLoai.setRowHeight(40);
            tableTheLoai.setSelectionBackground(new java.awt.Color(0, 100, 50));
            tableTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseReleased(java.awt.event.MouseEvent evt) {
                    tableTheLoaiMouseReleased(evt);
                }
            });
            jScrollPane4.setViewportView(tableTheLoai);

            jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            tableDSS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
            tableDSS.setAutoscrolls(false);
            tableDSS.setRowHeight(40);
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

            javax.swing.GroupLayout pnDSSMLayout = new javax.swing.GroupLayout(pnDSSM);
            pnDSSM.setLayout(pnDSSMLayout);
            pnDSSMLayout.setHorizontalGroup(
                pnDSSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDSSMLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnDSSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addContainerGap())
            );
            pnDSSMLayout.setVerticalGroup(
                pnDSSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnDSSMLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(pnDSSM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem)
                    .addGap(54, 54, 54)
                    .addComponent(btHuyBo)
                    .addGap(111, 111, 111))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnDSSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btHuyBo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(26, 26, 26))
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
            model.addRow(new Object[]{tableDSS.getValueAt(selectedrow, 0), tableDSS.getValueAt(selectedrow, 1)});
            modelroot.setValueAt(Integer.parseInt(modelroot.getValueAt(selectedrow, 2).toString()) - 1, selectedrow, 2);
            for (Sach sach : HANDLE.SACHLIST) {
                if(sach.getMaSach().equals(modelroot.getValueAt(selectedrow, 0)))
                {
                    sach.setSoLuong((sach.getSoLuong()-1)+"");
                }
            }
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
                    
                    break;
                }
            }
            for (Sach sach : HANDLE.SACHLIST) {
                if(sach.getMaSach().equals(model.getValueAt(selectedrow, 0)))
                {
                    sach.setSoLuong((sach.getSoLuong()+1)+"");
                }
            }
            model.removeRow(selectedrow);
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

    private void tableTheLoaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTheLoaiMouseReleased
//        if (PANNELSACHENABLE) {
            ChonDongTheLoai();
//        }
    }//GEN-LAST:event_tableTheLoaiMouseReleased

    private int CHONTHELOAI=-1;
    private void ChonDongTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        CHONTHELOAI = tableTheLoai.getSelectedRow();
        if (CHONTHELOAI > HANDLE.THELOAILIST.size()) {
            return;
        }
        if (CHONTHELOAI == tableTheLoai.getRowCount() - 1 || CHONTHELOAI == -1)//tuc la chon dong tat ca the loai haoc khong chon
        {
            for (Sach sach : HANDLE.SACHLIST) {
//                if (sach.getSoLuong() > 0) {
                model.addRow(sach.ToListString());
//                }
            }
        } else {
            for (Sach sach : HANDLE.SACHLIST) {
                if (sach.getMaTheLoai().toUpperCase().equals(tableTheLoai.getValueAt(CHONTHELOAI, 1).toString().toUpperCase())) {
                    model.addRow(sach.ToListString());
                }
            }
        }
    }

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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnDSSM;
    private javax.swing.JTable tableDSChon;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTable tableTheLoai;
    private javax.swing.JTextField tbHoten;
    private javax.swing.JTextField tbMaDG;
    private javax.swing.JFormattedTextField tbNgayHenTra_FM;
    private javax.swing.JFormattedTextField tbNgayMuonN;
    // End of variables declaration//GEN-END:variables
}
