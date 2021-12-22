package UI.level1;

import BLL.MY_HANDLE;
import Bookcovers.BookCover_Handle;
import DAL.MY_HANDLE_CONNECTION;
import DTO.Sach;
import DTO.TheLoai;
import UI.fMain1;
import UI.level2.fdThemSach;
import UI.level2.fdThemTheLoai;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Magic
 */
public class fQLSACH extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fMain1 MAIN;
    //private boolean PANNELSACHENABLE = true;
    private int CHONSACH = -1;
    private int CHONTHELOAI = -1;
    private fdThemSach fthem;
    private fdThemTheLoai ftlthem;

    public fQLSACH(fMain1 f, MY_HANDLE xl, boolean v) throws SQLException {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        initComponents();

        btSua.setVisible(v);
        btSuaTheLoai.setVisible(v);
        btThem.setVisible(v);
        btThemTheLoai.setVisible(v);
        btXoa.setVisible(v);
        btXoaTheLoai.setVisible(v);

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

    public void search_test() {
        TableRowSorter rowSorter = new TableRowSorter();
        rowSorter.setRowFilter(null);
        String text = tbTImkiemSach.getText();
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }



    public void LoadPanelSach() {
        MAIN.LoadSach();
        MAIN.LoadTheLoai();
        LayBangSach();
        LayBangTheLoai();

        HANDLE.ClearTextBox(pnTTSach);
        CHONSACH = -1;
        CHONTHELOAI = -1;

        lbSoLuongSach.setText("" + HANDLE.SACHLIST.size());
    }

    private void LayBangTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableTheLoai.getModel();
        model.setRowCount(0);
        for (TheLoai theLoai : HANDLE.THELOAILIST) {
            model.addRow(theLoai.ToListString());
        }
        model.addRow(new String[]{"", "<html><b style=\"padding-left:50px\">*Tất cả sách*</b></html>"});
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
        lbMaSach.setText(tableDSS.getValueAt(CHONSACH, 0).toString());

        //lbTenSach.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        lbTenSach.setText(HANDLE.BreakLineTitle(tableDSS.getValueAt(CHONSACH, 1).toString()));

        lbSoLuong.setText(tableDSS.getValueAt(CHONSACH, 2).toString());
        taTomTat.setText(tableDSS.getValueAt(CHONSACH, 4).toString());
        //lbTomTat.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        lbTacGia.setText(tableDSS.getValueAt(CHONSACH, 5).toString());
        //lbTheLoai.setText(HANDLE.MAPTHELOAI.get(tableDSS.getValueAt(CHONSACH, 3).toString().toUpperCase()));
        lbTheLoai.setText(tableDSS.getValueAt(CHONSACH, 3).toString());

        //jTextPane1.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        //jTextArea1.setText(tableDSS.getValueAt(CHONSACH, 1).toString());
        BookCover_Handle fl = new BookCover_Handle();

        String imgname = (lbMaSach.getText() + ".jpg");
        URL link = fl.getClass().getResource(imgname);
        if (link == null) {

            imgname = (lbMaSach.getText() + ".png");
            link = fl.getClass().getResource(imgname);
            if (link == null) {
                link = fl.getClass().getResource("noimg.jpg");
            }
        }
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(link);
            Image dimg = myPicture.getScaledInstance(lbAnhBia.getWidth(), lbAnhBia.getHeight(), Image.SCALE_SMOOTH);
            lbAnhBia.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi lay anh bia:\n" + ex);
        }

    }

    private void ChonDongTheLoai() {
        DefaultTableModel model = (DefaultTableModel) tableDSS.getModel();
        model.setRowCount(0);
        CHONTHELOAI = tableTheLoai.getSelectedRow();
        if (CHONTHELOAI > HANDLE.THELOAILIST.size()) {
            return;
        }
        if (CHONTHELOAI == tableTheLoai.getRowCount() - 1 || CHONTHELOAI == -1)//               tuc la chon dong tat ca the loai
        {
            for (Sach sach : HANDLE.SACHLIST) {
                model.addRow(sach.ToListString());
            }
            tbMaTheLoai.setText("All");
            tbTenTheLoai.setText("All");
            lbSoLuongSach.setText("" + HANDLE.SACHLIST.size());
        } else {//                                                                              toi day tuc la da chon mot trong cac the loai sach co trong db
            for (Sach sach : HANDLE.SACHLIST) {
                if (sach.getTenTheLoai().toUpperCase().equals(tableTheLoai.getValueAt(CHONTHELOAI, 1).toString().toUpperCase())) {
                    model.addRow(sach.ToListString());
                }
            }

            tbMaTheLoai.setText(tableTheLoai.getValueAt(CHONTHELOAI, 0).toString());
            tbTenTheLoai.setText(tableTheLoai.getValueAt(CHONTHELOAI, 1).toString());

            String[] query = {"select COUNT(MaSach) from THELOAI,sach where sach.MaTheLoai=THELOAI.MaTheLoai and THELOAI.MaTheLoai=?", tbMaTheLoai.getText()};
            try {
                ResultSet rs = db.RunQuery_Get(query);
                rs.next();
                lbSoLuongSach.setText(rs.getString(1));

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi xuat thong tin the loai:\n" + ex.getMessage());
            }

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabpnSach = new javax.swing.JPanel();
        pnThongTinTheLoai = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tbTenTheLoai = new javax.swing.JTextField();
        lbTenTheLoai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tbMaTheLoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbSoLuongSach = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableTheLoai = new javax.swing.JTable();
        btXoaTheLoai = new javax.swing.JButton();
        btSuaTheLoai = new javax.swing.JButton();
        btThemTheLoai = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pnThongTinSach = new javax.swing.JPanel();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        pnTTSach = new javax.swing.JPanel();
        lbMaSach = new javax.swing.JLabel();
        lbTomTat = new javax.swing.JLabel();
        lbTacGia = new javax.swing.JLabel();
        lbTenSach = new javax.swing.JLabel();
        lbTheLoai = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbAnhBia = new javax.swing.JLabel();
        lbTextSoLuong = new javax.swing.JLabel();
        lbTextTheLoai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taTomTat = new javax.swing.JTextArea();
        btThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDSS = new javax.swing.JTable();
        tbTImkiemSach = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1646, 683));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        tabpnSach.setBackground(new java.awt.Color(211, 212, 195));
        tabpnSach.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        tabpnSach.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        pnThongTinTheLoai.setBackground(new java.awt.Color(211, 212, 195));
        pnThongTinTheLoai.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Thể loại", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 24))); // NOI18N
        pnThongTinTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(167, 174, 130));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbTenTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTenTheLoai.setText("Ten the loai");
        tbTenTheLoai.setEnabled(false);

        lbTenTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbTenTheLoai.setText("Tên thể loại");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Mã thể loại");

        tbMaTheLoai.setEditable(false);
        tbMaTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbMaTheLoai.setText("Ma the loai");
        tbMaTheLoai.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Số lượng sách :");

        lbSoLuongSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbSoLuongSach.setText("999");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbSoLuongSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbMaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbTenTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTenTheLoai))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbSoLuongSach))
                .addGap(22, 22, 22))
        );

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
        tableTheLoai.setAutoscrolls(false);
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
            tableTheLoai.getColumnModel().getColumn(0).setPreferredWidth(60);
            tableTheLoai.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        btXoaTheLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btXoaTheLoai.setToolTipText("Xóa thể loại đã chọn");
        btXoaTheLoai.setMaximumSize(new java.awt.Dimension(72, 72));
        btXoaTheLoai.setMinimumSize(new java.awt.Dimension(72, 72));
        btXoaTheLoai.setName(""); // NOI18N
        btXoaTheLoai.setPreferredSize(new java.awt.Dimension(72, 72));
        btXoaTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaTheLoaiMouseClicked(evt);
            }
        });

        btSuaTheLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/write.png"))); // NOI18N
        btSuaTheLoai.setToolTipText("Sửa thể loại này");
        btSuaTheLoai.setMaximumSize(new java.awt.Dimension(72, 72));
        btSuaTheLoai.setMinimumSize(new java.awt.Dimension(72, 72));
        btSuaTheLoai.setName(""); // NOI18N
        btSuaTheLoai.setPreferredSize(new java.awt.Dimension(72, 72));
        btSuaTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaTheLoaiMouseClicked(evt);
            }
        });

        btThemTheLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/page (1).png"))); // NOI18N
        btThemTheLoai.setToolTipText("Thêm thể loại mới");
        btThemTheLoai.setMaximumSize(new java.awt.Dimension(72, 72));
        btThemTheLoai.setMinimumSize(new java.awt.Dimension(72, 72));
        btThemTheLoai.setName("add"); // NOI18N
        btThemTheLoai.setPreferredSize(new java.awt.Dimension(72, 72));
        btThemTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThemTheLoaiMouseClicked(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        javax.swing.GroupLayout pnThongTinTheLoaiLayout = new javax.swing.GroupLayout(pnThongTinTheLoai);
        pnThongTinTheLoai.setLayout(pnThongTinTheLoaiLayout);
        pnThongTinTheLoaiLayout.setHorizontalGroup(
            pnThongTinTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinTheLoaiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(pnThongTinTheLoaiLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinTheLoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSuaTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btXoaTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnThongTinTheLoaiLayout.setVerticalGroup(
            pnThongTinTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinTheLoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnThongTinTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinTheLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btXoaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSuaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btThemTheLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(99, 99, 99))
        );

        pnThongTinSach.setBackground(new java.awt.Color(211, 212, 195));
        pnThongTinSach.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Thông tin sách", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 36))); // NOI18N

        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/write.png"))); // NOI18N
        btSua.setToolTipText("Sửa thông tin sách này");
        btSua.setMaximumSize(new java.awt.Dimension(72, 72));
        btSua.setMinimumSize(new java.awt.Dimension(72, 72));
        btSua.setName(""); // NOI18N
        btSua.setPreferredSize(new java.awt.Dimension(72, 72));
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btXoa.setToolTipText("Xoá sách này");
        btXoa.setMaximumSize(new java.awt.Dimension(72, 72));
        btXoa.setMinimumSize(new java.awt.Dimension(72, 72));
        btXoa.setName(""); // NOI18N
        btXoa.setPreferredSize(new java.awt.Dimension(72, 72));
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });

        pnTTSach.setBackground(new java.awt.Color(167, 174, 130));
        pnTTSach.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnTTSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        pnTTSach.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbMaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbMaSach.setText("Mã sách");
        pnTTSach.add(lbMaSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        lbTomTat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTomTat.setText("Tóm tắt :");
        pnTTSach.add(lbTomTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));

        lbTacGia.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        lbTacGia.setText("Tác giả");
        pnTTSach.add(lbTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, -1, -1));

        lbTenSach.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTenSach.setText("Tên sách");
        lbTenSach.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbTenSach.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        pnTTSach.add(lbTenSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, 50));

        lbTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTheLoai.setText("Thể loại");
        pnTTSach.add(lbTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, -1, -1));

        lbSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbSoLuong.setText("0");
        pnTTSach.add(lbSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        lbAnhBia.setText("Ảnh bìa");
        pnTTSach.add(lbAnhBia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 170, 230));

        lbTextSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTextSoLuong.setText("Số lượng còn lại :");
        pnTTSach.add(lbTextSoLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        lbTextTheLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbTextTheLoai.setText("Thể loại :");
        pnTTSach.add(lbTextTheLoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        taTomTat.setEditable(false);
        taTomTat.setBackground(new java.awt.Color(167, 174, 130));
        taTomTat.setColumns(20);
        taTomTat.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        taTomTat.setLineWrap(true);
        taTomTat.setRows(5);
        taTomTat.setWrapStyleWord(true);
        taTomTat.setAutoscrolls(false);
        taTomTat.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        taTomTat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        taTomTat.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(taTomTat);

        pnTTSach.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 220, 70));

        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/book.png"))); // NOI18N
        btThem.setToolTipText("Thêm sách mới");
        btThem.setMaximumSize(new java.awt.Dimension(72, 72));
        btThem.setMinimumSize(new java.awt.Dimension(72, 72));
        btThem.setName("add"); // NOI18N
        btThem.setPreferredSize(new java.awt.Dimension(72, 72));
        btThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThemMouseClicked(evt);
            }
        });

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
        tableDSS.setRowHeight(50);
        tableDSS.setSelectionBackground(new java.awt.Color(0, 100, 50));
        tableDSS.setShowGrid(false);
        tableDSS.setShowHorizontalLines(true);
        tableDSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableDSSMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableDSS);
        if (tableDSS.getColumnModel().getColumnCount() > 0) {
            tableDSS.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableDSS.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableDSS.getColumnModel().getColumn(2).setPreferredWidth(15);
            tableDSS.getColumnModel().getColumn(3).setPreferredWidth(40);
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
        tbTImkiemSach.setBackground(new java.awt.Color(211, 212, 195));
        tbTImkiemSach.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbTImkiemSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm trong sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        javax.swing.GroupLayout pnThongTinSachLayout = new javax.swing.GroupLayout(pnThongTinSach);
        pnThongTinSach.setLayout(pnThongTinSachLayout);
        pnThongTinSachLayout.setHorizontalGroup(
            pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinSachLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnThongTinSachLayout.createSequentialGroup()
                        .addComponent(tbTImkiemSach, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                        .addGap(410, 410, 410)
                        .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThongTinSachLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addGroup(pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThongTinSachLayout.createSequentialGroup()
                                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))))))
        );
        pnThongTinSachLayout.setVerticalGroup(
            pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThongTinSachLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbTImkiemSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                    .addGroup(pnThongTinSachLayout.createSequentialGroup()
                        .addComponent(pnTTSach, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(pnThongTinSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout tabpnSachLayout = new javax.swing.GroupLayout(tabpnSach);
        tabpnSach.setLayout(tabpnSachLayout);
        tabpnSachLayout.setHorizontalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(pnThongTinTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnThongTinSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tabpnSachLayout.setVerticalGroup(
            tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabpnSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabpnSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnThongTinSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnThongTinTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(tabpnSach);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tableTheLoaiMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTheLoaiMouseReleased
        // if (PANNELSACHENABLE) {
        ChonDongTheLoai();
        // }
    }//GEN-LAST:event_tableTheLoaiMouseReleased

    private void tableDSSMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDSSMouseReleased
        //if (PANNELSACHENABLE) {
        ChonDongSach();
        //}
    }//GEN-LAST:event_tableDSSMouseReleased

    private void btThemTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThemTheLoaiMouseClicked
        if (ftlthem != null) {
            ftlthem = null;
        }
        try {
            ftlthem = new fdThemTheLoai(MAIN, true, this, HANDLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi tao form them the loai:\n" + ex.getMessage());
        }
        ftlthem.setLocationRelativeTo(null);
        ftlthem.show();
    }//GEN-LAST:event_btThemTheLoaiMouseClicked

    private void btSuaTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaTheLoaiMouseClicked
        if (CHONTHELOAI > -1 && CHONTHELOAI < tableTheLoai.getRowCount()-1) {
            TheLoai tl = new TheLoai();
            tl.setMatl(tbMaTheLoai.getText());
            tl.setTentl(tbTenTheLoai.getText());
            if (ftlthem != null) {
                ftlthem = null;
            }
            try {
                ftlthem = new fdThemTheLoai(MAIN, true, this, tl, HANDLE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Loi khi tao form them the loai:\n" + ex.getMessage());
            }
            ftlthem.setLocationRelativeTo(null);
            ftlthem.show();

        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn một thể loại");
        }
    }//GEN-LAST:event_btSuaTheLoaiMouseClicked

    private void btXoaTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaTheLoaiMouseClicked
        if (CHONTHELOAI == -1) {
            JOptionPane.showMessageDialog(this, "Hãy chọn một thể loại");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "CHÚ Ý", YES_NO_OPTION) == 0) {

            String[] query = {"select * from Sach where Matheloai=?", tbMaTheLoai.getText()};
            try {
                ResultSet rs = db.RunQuery_Get(query);
                rs.next();
                if (rs.getRow() > 0)//tuc la co sach thuoc
                {   //thì
                    JOptionPane.showMessageDialog(this, "Còn sách thuộc thể loại này\nKhông thể xóa!!");
                    return;
                }
                //neu khong co trong phieu muon thi xoa...
                query[0] = "delete from TheLoai where MaTheLoai=?";
                //query[1] = tbMaTheLoai.getText();
                db.RunQuery(query);

                JOptionPane.showMessageDialog(this, "Đã xóa thể loại!!\n");
                LoadPanelSach();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa thể loại:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btXoaTheLoaiMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
        if (CHONSACH == -1) {
            JOptionPane.showMessageDialog(this, "Chưa chọn sách!!");
            return;
        }

        if (JOptionPane.showConfirmDialog(null, "Xác nhận xóa", "CHÚ Ý", YES_NO_OPTION) == 0) {

            String[] query = {"select * from CTPHIEUMUON where MaSach=?", lbMaSach.getText()};
            try {
                ResultSet rs = db.RunQuery_Get(query);
                rs.next();
                if (rs.getRow() > 0)//tuc la con trong ct phieu muon
                {   //thì
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa sách:\nSách có trong phiếu mượn\nKhông được xóa!!");
                    return;
                }
                //neu khong co trong phieu muon thi xoa...
                query[0] = "delete from SACH where MaSach=?";
                query[1] = lbMaSach.getText();
                db.RunQuery(query);

                try {
                    Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + lbMaSach.getText() + ".jpg"));
                    Files.deleteIfExists(Paths.get(System.getProperty("user.dir") + "\\src\\Bookcovers\\" + lbMaSach.getText() + ".png"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Loi khi xoa anh bia!!\n" + ex.getMessage());
                }

                JOptionPane.showMessageDialog(this, "Đã xóa sách!!\n");
                LoadPanelSach();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sách:\n" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btXoaMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
        if (CHONSACH != -1) {
            Sach edit = new Sach();
            edit.setMaSach(lbMaSach.getText());
            edit.setTenSach(tableDSS.getValueAt(CHONSACH, 1).toString());
            edit.setTacgia(lbTacGia.getText());
            edit.setSoLuong(lbSoLuong.getText());
            edit.setTomTat(taTomTat.getText());
            edit.setTenTheLoai(HANDLE.getKey(HANDLE.MAPTHELOAI, lbTheLoai.getText()));

            if (fthem != null) {
                fthem = null;
            }
            try {
                fthem = new fdThemSach(MAIN, true, this, edit, HANDLE);
            } catch (SQLException ex) {
                Logger.getLogger(fQLSACH.class.getName()).log(Level.SEVERE, null, ex);
            }
            fthem.setLocationRelativeTo(null);
            fthem.show();

        } else {
            JOptionPane.showMessageDialog(this, "Hãy chọn sách");
        }
    }//GEN-LAST:event_btSuaMouseClicked

    private void btThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThemMouseClicked
        if (fthem != null) {
            fthem = null;
        }
        try {
            fthem = new fdThemSach(MAIN, true, this, HANDLE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Loi khi tao form them sach:\n" + ex.getMessage());
        }
        fthem.setLocationRelativeTo(null);
        fthem.show();        // TODO add your handling code here:
    }//GEN-LAST:event_btThemMouseClicked

    // <editor-fold defaultstate="collapsed" desc="Generated Code">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSua;
    private javax.swing.JButton btSuaTheLoai;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThemTheLoai;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXoaTheLoai;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAnhBia;
    private javax.swing.JLabel lbMaSach;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbSoLuongSach;
    private javax.swing.JLabel lbTacGia;
    private javax.swing.JLabel lbTenSach;
    private javax.swing.JLabel lbTenTheLoai;
    private javax.swing.JLabel lbTextSoLuong;
    private javax.swing.JLabel lbTextTheLoai;
    private javax.swing.JLabel lbTheLoai;
    private javax.swing.JLabel lbTomTat;
    private javax.swing.JPanel pnTTSach;
    private javax.swing.JPanel pnThongTinSach;
    private javax.swing.JPanel pnThongTinTheLoai;
    private javax.swing.JTextArea taTomTat;
    private javax.swing.JTable tableDSS;
    private javax.swing.JTable tableTheLoai;
    private javax.swing.JPanel tabpnSach;
    private javax.swing.JTextField tbMaTheLoai;
    private javax.swing.JTextField tbTImkiemSach;
    private javax.swing.JTextField tbTenTheLoai;
    // End of variables declaration//GEN-END:variables
}// </editor-fold>      
