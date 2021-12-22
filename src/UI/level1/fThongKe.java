/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI.level1;

import BLL.MY_HANDLE;
import DAL.MY_HANDLE_CONNECTION;
import DTO.ThongKeSachTrongThang;
import UI.fMain1;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.sql.ResultSet;

/**
 *
 * @author Gic
 */
public class fThongKe extends javax.swing.JInternalFrame {

    private final MY_HANDLE_CONNECTION db;
    private final MY_HANDLE HANDLE;
    private fMain1 MAIN;

    public fThongKe() throws SQLException {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.getContentPane().setBackground(new Color(211,212,195));//[30,31,38]210,225,230
        db = new MY_HANDLE_CONNECTION();
        HANDLE = new MY_HANDLE();

        LoadThongKeSachTrongThang();
        setDataToChart1(jpn1);

    }

//    public fThongKe(fMain1 f) throws SQLException {
//        initComponents();
//        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
//
//        db = new MY_HANDLE_CONNECTION();
//        HANDLE = new MY_HANDLE();
//        MAIN = f;
//
//        LoadThongKeSachTrongThang();
//        setDataToChart1(jpn1);
//
//    }
    private List<ThongKeSachTrongThang> LISTTK;

    public void setDataToChart1(JPanel jpnItem) {
//        List<LopHocBean> listItem = thongKeService.getListByLopHoc();
//
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        if (listItem != null) {
//            for (LopHocBean item : listItem) {
//                dataset.addValue(item.getSo_luong_hoc_vien(), "Học viên", item.getNgay_dang_ky());
//            }
//        }

//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for (int i = 0; i < 10; i++) {
//            dataset.addValue(i + 10, "test", "20" + (i * i));
//        }
        String nam = jSpinner1.getValue().toString();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i <= 12; i++) {
            dataset.addValue(0, "Tháng", "" + i);
            for (ThongKeSachTrongThang item : LISTTK) {

                if (item.getNam().equals(nam)) {
                    if (item.getThang().equals("" + i)) {
                        dataset.addValue(item.getSoluong(), "Tháng", item.getThang());
                    }
                }
            }
        }

        JFreeChart barChart = ChartFactory.createBarChart("THỐNG KÊ SỐ LƯỢNG SÁCH MƯỢN".toUpperCase(), "Tháng", "Số lượng sách", dataset, PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 321));

        jpnItem.removeAll();
        jpnItem.setLayout(new CardLayout());
        jpnItem.add(chartPanel);
        jpnItem.validate();
        jpnItem.repaint();

        SpinnerModel model = jSpinner1.getModel();
        JComponent editor = new JSpinner.NumberEditor(jSpinner1, "####");
        jSpinner1.setEditor(editor);

    }

    private void LoadThongKeSachTrongThang() {
//        HANDLE.SACHLIST.clear();
//        HANDLE.MAPTHELOAI.clear();
        LISTTK = new ArrayList<>();
        try {
            ResultSet rs = db.RunQuery("select month(ngaymuon),YEAR(NGAYMUON),sum(solUonGMuon) from phieumuon\n"
                    + "group by month(ngaymuon),YEAR(NGAYMUON)");
//            for (int i = 1; i <= 12; i++) {
//
//                while (rs.next()) {
//                    ThongKeSachTrongThang tk = new ThongKeSachTrongThang();
//                    tk.setThang(rs.getString(1));
//                    tk.setNam(rs.getString(2));
//                    tk.setSoluong(Integer.parseInt(rs.getString(3)));
//                    LISTTK.add(tk);
//                }
//            }

            while (rs.next()) {
                ThongKeSachTrongThang tk = new ThongKeSachTrongThang();
                tk.setThang(rs.getString(1));
                tk.setNam(rs.getString(2));
                tk.setSoluong(Integer.parseInt(rs.getString(3)));
                LISTTK.add(tk);
            }

//            ResultSet rstl = db.RunQuery("select MaTheLoai,TenTheLoai from THELOAI");
//            while (rstl.next()) {
//                HANDLE.MAPTHELOAI.put(rstl.getString(1), rstl.getString(2));
//            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Co loi khi lay du lieu Thong ke:\n" + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(211, 212, 195));

        jpn1.setBackground(new java.awt.Color(211, 212, 195));
        jpn1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jpn1Layout = new javax.swing.GroupLayout(jpn1);
        jpn1.setLayout(jpn1Layout);
        jpn1Layout.setHorizontalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpn1Layout.setVerticalGroup(
            jpn1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(211, 212, 195));

        jPanel1.setBackground(new java.awt.Color(211, 212, 195));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jSpinner1.setValue(2020);
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Năm:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addGap(60, 60, 60)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addComponent(jpn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged
        setDataToChart1(jpn1);
    }//GEN-LAST:event_jSpinner1StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JPanel jpn1;
    // End of variables declaration//GEN-END:variables
}
