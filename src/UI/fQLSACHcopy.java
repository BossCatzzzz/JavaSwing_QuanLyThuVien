package UI;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.Sach;
import DTO.TheLoai;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Magic
 */
public class fQLSACHcopy extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fMain1 MAIN;
    private boolean PANNELSACHENABLE = true;
    private int CHONSACH = -1;
    private int CHONTHELOAI = -1;

    public fQLSACHcopy(fMain1 f, MY_HANDLE xl) throws SQLException {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();
        db = new MY_HANDLE_CONNECTION();
        HANDLE = xl;
        MAIN = f;
        LoadPanelSach();

    }

    public void search() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        for (Sach item : HANDLE.SACHLIST) {
            if (item.SearchOnAll(tbTImkiemSach.getText().trim())) {
                model.addRow(item.ToListString());
            }
        }
    }

    private void LockPnTTSach(boolean b) {//============= khóa / mở các textbox
        tbTenSach.setEditable(!b);
        cbbTheLoai.setEnabled(!b);
        tbSoluong.setEditable(!b);
        tbTomTat.setEditable(!b);
        tbTacGia.setEditable(!b);
    }

    private void LoadPanelSach() {
        MAIN.LoadSach();
        LayBangSach();
        LayBangTheLoai();
        Combobox_load();

        LockPnTTSach(true);

        tableDSS.setEnabled(true);
        tableTheLoai.setEnabled(true);
        PANNELSACHENABLE = true;

        btXoa.setText("Xoa");
        btThem.setVisible(true);
        btSua.setVisible(true);
        btSua.setText("Sua");
        btThem.setText("Them");
        HANDLE.ClearTextBox(pnTTSach);
        CHONSACH = -1;
        CHONTHELOAI = -1;
    }

    private void LayBangTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableTheLoai.getModel();
        model.setRowCount(0);
//        try {
//            ResultSet rs = db.RunQuery(query);
//            while (rs.next()) {
//                model.addRow(new String[]{rs.getString(1), rs.getString(2)});
//            }
//            model.addRow(new String[]{"", "Tất cả thể loại"});
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu the loai:\n" + e.getMessage());
//        }
        for (TheLoai theLoai : HANDLE.THELOAILIST) {
            model.addRow(theLoai.ToListString());
        }
        model.addRow(new String[]{"", "Tất cả thể loại"});
    }

    private void Combobox_load() {

        for (Map.Entry<String, String> entry : HANDLE.MAPTHELOAI.entrySet()) {
            cbbTheLoai.addItem(entry.getValue());
        }

    }

    private void LayBangSach() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);

        for (Sach object : HANDLE.SACHLIST) {
            model.addRow(object.ToListString());
        }
    }

    private void ChonDongSach() {

        CHONSACH = tableDSS.getSelectedRow();
        if (CHONSACH < 0) {
            return;
        }
        tbMaSach.setText(tableDSS.getValueAt(CHONSACH, 0).toString());
        tbTenSach.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        tbSoluong.setText(tableDSS.getValueAt(CHONSACH, 2).toString());
        tbTomTat.setText(tableDSS.getValueAt(CHONSACH, 4).toString());
        tbTacGia.setText(tableDSS.getValueAt(CHONSACH, 5).toString());
        cbbTheLoai.setSelectedItem(HANDLE.MAPTHELOAI.get(Integer.parseInt(tableDSS.getValueAt(CHONSACH, 3).toString())));
    }

    private void ChonDongTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        CHONTHELOAI = tableTheLoai.getSelectedRow();
        if (CHONTHELOAI>HANDLE.THELOAILIST.size()) {
            return;
        }
        if (CHONTHELOAI == tableTheLoai.getRowCount() - 1||CHONTHELOAI==-1)//tuc la chon dong tat ca the loai
        {
            for (Sach sach : HANDLE.SACHLIST) {
                model.addRow(sach.ToListString());
            }
        } else {
            for (Sach sach : HANDLE.SACHLIST) {
                if (sach.getMaTheLoai().toUpperCase().equals(tableTheLoai.getValueAt(CHONTHELOAI, 0).toString().toUpperCase())) {
                    model.addRow(sach.ToListString());
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpnSach = new javax.swing.JPanel();
        pnTTSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbMaSach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tbTomTat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tbTacGia = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tbTenSach = new javax.swing.JTextField();
        cbbTheLoai = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tbSoluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();
        tbTImkiemSach = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTheLoai = new javax.swing.JTable();

        tabpnSach.setBackground(new java.awt.Color(211, 212, 195));
        tabpnSach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabpnSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel1.setText("Ma sach");

        tbMaSach.setEnabled(false);
        tbMaSach.setFocusable(false);

        jLabel5.setText("Tom tat");

        jLabel6.setText("Tac gia");

        btThem.setText("Them");
        btThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btThem.setMinimumSize(new java.awt.Dimension(72, 72));
        btThem.setName("add"); // NOI18N
        btThem.setPreferredSize(new java.awt.Dimension(72, 72));
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setText("Sua");
        btSua.setMaximumSize(new java.awt.Dimension(72, 72));
        btSua.setMinimumSize(new java.awt.Dimension(72, 72));
        btSua.setName(""); // NOI18N
        btSua.setPreferredSize(new java.awt.Dimension(72, 72));
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setText("Xoa");
        btXoa.setMaximumSize(new java.awt.Dimension(72, 72));
        btXoa.setMinimumSize(new java.awt.Dimension(72, 72));
        btXoa.setName(""); // NOI18N
        btXoa.setPreferredSize(new java.awt.Dimension(72, 72));
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel2.setText("Ten sach");

        tbTenSach.setName("ten"); // NOI18N

        jLabel3.setText("The loai");

        jLabel4.setText("So luong");

        tbSoluong.setName("sl"); // NOI18N

        javax.swing.GroupLayout pnTTSachLayout = new javax.swing.GroupLayout(pnTTSach);
        pnTTSach.setLayout(pnTTSachLayout);
        pnTTSachLayout.setHorizontalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnTTSachLayout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(42, 42, 42)
                            .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTTSachLayout.createSequentialGroup()
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTomTat, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        pnTTSachLayout.setVerticalGroup(
            pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTTSachLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tbMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tbTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbbTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tbSoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tbTomTat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnTTSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tbTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnTTSachLayout.createSequentialGroup()
                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tableDSS.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tableDSS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên sách", "Còn lại", "Thể loại", "Tóm tắt", "Tác giả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDSS.setFillsViewportHeight(true);
        tableDSS.setRowHeight(40);
        tableDSS.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tableDSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDSSMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDSS);
        if (tableDSS.getColumnModel().getColumnCount() > 0) {
            tableDSS.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableDSS.getColumnModel().getColumn(1).setPreferredWidth(120);
            tableDSS.getColumnModel().getColumn(2).setPreferredWidth(20);
            tableDSS.getColumnModel().getColumn(3).setPreferredWidth(30);
        }

        tbTImkiemSach.getDocument().addDocumentListener(new DocumentListener() {
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
        tbTImkiemSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTImkiemSach.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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
        if (tableTheLoai.getColumnModel().getColumnCount() > 0) {
            tableTheLoai.getColumnModel().getColumn(0).setPreferredWidth(30);
            tableTheLoai.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        javax.swing.GroupLayout tabpnSachLayout = new javax.swing.GroupLayout(tabpnSach);
        tabpnSach.setLayout(tabpnSachLayout);
        tabpnSachLayout.setHorizontalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                        .addGap(10, 10, 10)
                        .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabpnSachLayout.createSequentialGroup()
                        .addComponent(tbTImkiemSach, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                        .addGap(504, 504, 504))))
        );
        tabpnSachLayout.setVerticalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tbTImkiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tabpnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(tabpnSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed

        if (btThem.getText().equals("Them")) {//nhan khi ma no la nut add thi...
            LockPnTTSach(false);
            tableDSS.setEnabled(false);
            tableTheLoai.setEnabled(false);
            PANNELSACHENABLE = false;
            btSua.setVisible(false);

            HANDLE.ClearTextBox(pnTTSach);
            btThem.setText("Xac nhan");
            btXoa.setText("Huy bo");
        } else if (btThem.getText().equals("Xac nhan")) {
            if (!HANDLE.KiemTraNhap(pnTTSach)) {
                JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                return;
            }
            if (Integer.parseInt(tbSoluong.getText()) < 1) {
                JOptionPane.showMessageDialog(this, "Chu Y!!\nSo luong phai lon hon 0");
                return;
            }
            String[] query = {"insert into SACH values(?,?,?,?,?)", "", "", "", "", ""};
            query[1] = tbTenSach.getText();
            query[2] = tbSoluong.getText();
            query[3] = HANDLE.getKey(HANDLE.MAPTHELOAI, cbbTheLoai.getSelectedItem().toString()).toString();
            query[4] = tbTomTat.getText();
            query[5] = tbTacGia.getText();
            try {
                db.RunQuery(query);
                JOptionPane.showMessageDialog(this, "Them sach thanh cong!!\n");
                LoadPanelSach();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi them sach:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        if (CHONSACH != -1) {
            if (btSua.getText().equals("Sua")) {//dag la nut sua
                pnTTSach.requestFocus();
                tableDSS.setEnabled(false);
                tableTheLoai.setEnabled(false);
                PANNELSACHENABLE = false;
                btXoa.setText("Huy bo");
                btThem.setVisible(false);
                btSua.setText("Luu lai");
                LockPnTTSach(false);
            } else if (btSua.getText().equals("Luu lai"))//neu la nut luu lai, thi chay query
            {
                if (!HANDLE.KiemTraNhap(pnTTSach)) {
                    JOptionPane.showMessageDialog(this, "Chua dien day du thong tin");
                    return;
                }
                String[] query = {"update SACH set TenSach=?,SoLuong=?,MaTheLoai=?,TomTat=?,TacGia=? where MaSach=? ", "", "", "", "", "", ""};
                query[1] = tbTenSach.getText();
                query[2] = tbSoluong.getText();
                query[3] = HANDLE.getKey(HANDLE.MAPTHELOAI, cbbTheLoai.getSelectedItem().toString()).toString();
                query[4] = tbTomTat.getText();
                query[5] = tbTacGia.getText();
                query[6] = tbMaSach.getText();
                try {
                    db.RunQuery(query);
                    tableDSS.setEnabled(true);
                    tableTheLoai.setEnabled(true);
                    PANNELSACHENABLE = true;
                    btXoa.setText("Xoa");
                    btThem.setVisible(true);
                    btSua.setText("Sua");
                    LockPnTTSach(true);
                    JOptionPane.showMessageDialog(this, "Luu thay doi sach thanh cong!!\n");
                    LoadPanelSach();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi sua thong tin sach:\n" + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chua chon sach");
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if (btXoa.getText().equals("Huy bo")) {
            LoadPanelSach();
            return;
        } else if (btXoa.getText().equals("Xoa")) {
            if (CHONSACH == -1) {
                JOptionPane.showMessageDialog(this, "Chua chon sach!!");
                return;
            }

            if (JOptionPane.showConfirmDialog(null, "Xac nhan xoa", "Chú ý", YES_NO_OPTION) == 0) {

                String[] query = {"select * from CTPHIEUMUON where MaSach=?", tbMaSach.getText()};
                try {
                    ResultSet rs = db.RunQuery_Get(query);
                    rs.next();
                    if (rs.getRow() > 0)//tuc la con trong ct phieu muon
                    {   //thì
                        JOptionPane.showMessageDialog(this, "Loi khi xoa sach:\nSach con trong phieu muon.\nKhong the xoa!!");
                        return;
                    }
                    query[0] = "delete from SACH where MaSach=?";
                    query[1] = tbMaSach.getText();
                    db.RunQuery(query);
                    JOptionPane.showMessageDialog(this, "Da xoa sach!!\n");
                    LoadPanelSach();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi xoa sach:\n" + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btXoaActionPerformed

    private void tableDSSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSSMouseReleased
        if (PANNELSACHENABLE) {
            ChonDongSach();
        }
    }//GEN-LAST:event_tableDSSMouseReleased

    private void tableTheLoaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTheLoaiMouseReleased
        if (PANNELSACHENABLE) {
            ChonDongTheLoai();
        }
    }//GEN-LAST:event_tableTheLoaiMouseReleased

    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cbbTheLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTable tableTheLoai;
    private javax.swing.JPanel tabpnSach;
    private javax.swing.JTextField tbMaSach;
    private javax.swing.JTextField tbSoluong;
    private javax.swing.JTextField tbTImkiemSach;
    private javax.swing.JTextField tbTacGia;
    private javax.swing.JTextField tbTenSach;
    private javax.swing.JTextField tbTomTat;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>      
