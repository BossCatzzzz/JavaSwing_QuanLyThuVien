/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.level1;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.TTPhieuMuon;
import UI.IDateChooserChangeEvent;
import UI.fMain1;
import UI.level2.fThemPhieuMuon;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
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

        addDateChangedEvent(jdFrom, (evt) -> {
            System.out.println("Date changed and is now " + new SimpleDateFormat("dd/MM/yyy").format(jdFrom.getDate()) + "!");
            SearchByDate();
        });
                addDateChangedEvent(jdTo, (evt) -> {
            System.out.println("Date changed and is now " + new SimpleDateFormat("dd/MM/yyy").format(jdTo.getDate()) + "!");
            SearchByDate();
        });
    }

    
    
    public static void addDateChangedEvent(JDateChooser dt, IDateChooserChangeEvent evt) {//********************************************************************
        ((JTextField) dt.getDateEditor()
                .getUiComponent())
                .getDocument()
                .addDocumentListener(new DocumentListener() {
                    Date lastDate = dt.getDate();

                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        if (dt.getDate() != null && !dt.getDate().equals(lastDate)) {
                            SwingUtilities.invokeLater(()
                                    -> evt.run(e));
                            lastDate = dt.getDate();
                        }
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                    }
                });
    }

    
    
    public void LoadAfterCreatePM() {
        MAIN.LoadPhieuMuon();
        LayBangPhieuMuon();
        btTraSach.setVisible(false);

        rdbtTatCa.setSelected(true);

        CHONPHIEUMUON = -1;

        jdFrom.setEnabled(false);
        jdTo.setEnabled(false);
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
        if (ngaytra.toLowerCase().equals("chưa trả")) {
            btTraSach.setVisible(true);
        } else {
            ngaytra = tablePhieuMuon.getValueAt(CHONPHIEUMUON, 4).toString();
            btTraSach.setVisible(false);
        }

        tbNgayTra.setText(ngaytra);

        LayBangChiTietPhieuMuon(sophieumuon);
    }

    private void LayBangPhieuMuon() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        for (TTPhieuMuon tTPhieuMuon : HANDLE.PHIEUMUONLIST) {
            model.addRow(tTPhieuMuon.ToListString());

        }
    }

    private void LayBangChiTietPhieuMuon(String sophieumuon) {
        String[] tenCot = {"Danh sách sách mượn"};
        DefaultTableModel model = new DefaultTableModel(tenCot, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String tensach;
        String query = "select TenSach from CTPHIEUMUON,SACH where SACH.MaSach=CTPHIEUMUON.MaSach and SoPhieuMuon=" + sophieumuon;
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

    private void search() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        for (TTPhieuMuon item : HANDLE.PHIEUMUONLIST) {
            if (item.SearchOnAll(tbTImkiemPhieuMuon.getText().trim())) {
                model.addRow(item.ToListString());
            }
        }
    }

    private void SearchByDate() {
        DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
        model.setRowCount(0);
        if (jdFrom.getDate() == null) {
            // LocalDateTime dateTime = LocalDateTime.now();
            jdFrom.setDate(new Date());
        }
        if (jdTo.getDate() == null) {
            // LocalDateTime dateTime = LocalDateTime.now();
            jdTo.setDate(new Date());
        }

        for (TTPhieuMuon item : HANDLE.PHIEUMUONLIST) {
            System.out.println("" + item.getSophieumuon() + "Ngay muon: " + item.getNgaymuon() + "\tngay:" + item.getNgaymuon().getDate() + "\tthang:" + item.getNgaymuon().getMonth() + "\n" + jdFrom.getDate() + "\tngay:" + jdFrom.getDate().getDate() + "\tthang:" + jdFrom.getDate().getMonth());
            if ((item.getNgaymuon().getDate() == jdFrom.getDate().getDate() && item.getNgaymuon().getMonth() == jdFrom.getDate().getMonth() && item.getNgaymuon().getYear() == jdFrom.getDate().getYear() || item.getNgaymuon().after(jdFrom.getDate())) && item.getNgaymuon().getDate() == jdTo.getDate().getDate() && item.getNgaymuon().getMonth() == jdTo.getDate().getMonth() && item.getNgaymuon().getYear() == jdTo.getDate().getYear() || item.getNgaymuon().before(jdTo.getDate())) {
                System.out.println("\t>oke!!");
                model.addRow(item.ToListString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        btThemPhieuMuon = new javax.swing.JButton();
        btTraSach = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rdbtTatCa = new javax.swing.JRadioButton();
        rdbtDaTra = new javax.swing.JRadioButton();
        rdbtChuaTra = new javax.swing.JRadioButton();
        pnLocTheoNgay = new javax.swing.JPanel();
        rdbtTheoNgay = new javax.swing.JRadioButton();
        jdTo = new com.toedter.calendar.JDateChooser();
        jdFrom = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        tbTImkiemPhieuMuon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        tabpnPhieuMuon.setBackground(new java.awt.Color(211, 212, 195));

        jScrollPane2.setBackground(new java.awt.Color(225, 236, 243));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablePhieuMuon.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        tablePhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Số phiếu", "Tên Độc giả", "Ngày mượn", "Ngày hẹn trả", "Ngày trả", "Số lượng mượn"
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Số phiếu:");

        tbSo_PM.setEditable(false);

        tbTenDG_PM.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tên Độc giả:");

        tbNgayMuon.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Ngày mượn:");

        tbNgayHen.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Ngày hẹn trả:");

        tbNgayTra.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Ngày trả thực tế:");

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

        jPanel1.setBackground(new java.awt.Color(211, 212, 195));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        buttonGroup1.add(rdbtTatCa);
        rdbtTatCa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtTatCa.setSelected(true);
        rdbtTatCa.setText("Tất cả");
        rdbtTatCa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtTatCaItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdbtDaTra);
        rdbtDaTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtDaTra.setText("Đã trả");
        rdbtDaTra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtDaTraItemStateChanged(evt);
            }
        });

        buttonGroup1.add(rdbtChuaTra);
        rdbtChuaTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtChuaTra.setText("Chưa trả");
        rdbtChuaTra.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtChuaTraItemStateChanged(evt);
            }
        });

        pnLocTheoNgay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        buttonGroup1.add(rdbtTheoNgay);
        rdbtTheoNgay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdbtTheoNgay.setText("Theo ngày mượn");
        rdbtTheoNgay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbtTheoNgayItemStateChanged(evt);
            }
        });

        jdTo.setDateFormatString("dd-MM-y");
        jdTo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jdTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdToPropertyChange(evt);
            }
        });

        jdFrom.setDateFormatString("dd-MM-y");
        jdFrom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jdFrom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jdFromInputMethodTextChanged(evt);
            }
        });
        jdFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdFromPropertyChange(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("~");

        javax.swing.GroupLayout pnLocTheoNgayLayout = new javax.swing.GroupLayout(pnLocTheoNgay);
        pnLocTheoNgay.setLayout(pnLocTheoNgayLayout);
        pnLocTheoNgayLayout.setHorizontalGroup(
            pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocTheoNgayLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocTheoNgayLayout.createSequentialGroup()
                        .addComponent(rdbtTheoNgay)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnLocTheoNgayLayout.createSequentialGroup()
                        .addComponent(jdFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addComponent(jdTo, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnLocTheoNgayLayout.setVerticalGroup(
            pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnLocTheoNgayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbtTheoNgay)
                .addGap(7, 7, 7)
                .addGroup(pnLocTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jdTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jdFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbtTatCa)
                        .addGap(12, 12, 12)
                        .addComponent(rdbtDaTra)
                        .addGap(12, 12, 12)
                        .addComponent(rdbtChuaTra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tbTImkiemPhieuMuon)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addComponent(pnLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbtTatCa)
                            .addComponent(rdbtDaTra)
                            .addComponent(rdbtChuaTra))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbTImkiemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnLocTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout tabpnPhieuMuonLayout = new javax.swing.GroupLayout(tabpnPhieuMuon);
        tabpnPhieuMuon.setLayout(tabpnPhieuMuonLayout);
        tabpnPhieuMuonLayout.setHorizontalGroup(
            tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabpnPhieuMuonLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
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
                .addGap(12, 12, 12)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btThemPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabpnPhieuMuonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabpnPhieuMuonLayout.createSequentialGroup()
                        .addComponent(pnThongTinPhieuMuon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))
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
        if (JOptionPane.showConfirmDialog(null, "Xác nhận trả", "CHÚ Ý", YES_NO_OPTION) == 0) {

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
                JOptionPane.showMessageDialog(this, "Đã cập nhật!!\n");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật phiếu mượn:\n" + ex.getMessage());
            }
        }
        LoadAfterCreatePM();
    }//GEN-LAST:event_btTraSachActionPerformed

    private void jdFromInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jdFromInputMethodTextChanged
       
    }//GEN-LAST:event_jdFromInputMethodTextChanged

    private void rdbtDaTraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtDaTraItemStateChanged
        if (rdbtDaTra.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
            model.setRowCount(0);
            for (TTPhieuMuon tTPhieuMuon : HANDLE.PHIEUMUONLIST) {
                if (tTPhieuMuon.getNgaytra() != null) {
                    model.addRow(tTPhieuMuon.ToListString());
                }
            }
        }
    }//GEN-LAST:event_rdbtDaTraItemStateChanged

    private void rdbtChuaTraItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtChuaTraItemStateChanged
        if (rdbtChuaTra.isSelected()) {
            DefaultTableModel model = (DefaultTableModel) tablePhieuMuon.getModel();
            model.setRowCount(0);
            for (TTPhieuMuon tTPhieuMuon : HANDLE.PHIEUMUONLIST) {
                if (tTPhieuMuon.getNgaytra() == null) {
                    model.addRow(tTPhieuMuon.ToListString());
                }
            }
        }
    }//GEN-LAST:event_rdbtChuaTraItemStateChanged

    private void rdbtTatCaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtTatCaItemStateChanged
        if (rdbtTatCa.isSelected()) {
            LoadAfterCreatePM();
        }
    }//GEN-LAST:event_rdbtTatCaItemStateChanged

    private void jdFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdFromPropertyChange
        if (jdFrom.getDate() == null) {
        } else if (jdTo.getDate() != null && jdFrom.getDate().after(jdTo.getDate())) {
            jdTo.setDate(jdFrom.getDate());
            SearchByDate();
            
        }
    }//GEN-LAST:event_jdFromPropertyChange

    private void jdToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdToPropertyChange
        if (jdTo.getDate() == null) {
            //chưa biết làm gì
        } else if (jdFrom.getDate() != null && jdFrom.getDate().after(jdTo.getDate())) {
            jdFrom.setDate(jdTo.getDate());
            SearchByDate();
        }
    }//GEN-LAST:event_jdToPropertyChange


    private void rdbtTheoNgayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbtTheoNgayItemStateChanged
        if (rdbtTheoNgay.isSelected()) {
            jdFrom.setEnabled(true);
            jdTo.setEnabled(true);

            MAIN.LoadPhieuMuon();
            LayBangPhieuMuon();
            btTraSach.setVisible(false);
            CHONPHIEUMUON = -1;
        }
    }//GEN-LAST:event_rdbtTheoNgayItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btThemPhieuMuon;
    private javax.swing.JButton btTraSach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdFrom;
    private com.toedter.calendar.JDateChooser jdTo;
    private javax.swing.JPanel pnLocTheoNgay;
    private javax.swing.JPanel pnThongTinPhieuMuon;
    private javax.swing.JRadioButton rdbtChuaTra;
    private javax.swing.JRadioButton rdbtDaTra;
    private javax.swing.JRadioButton rdbtTatCa;
    private javax.swing.JRadioButton rdbtTheoNgay;
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
