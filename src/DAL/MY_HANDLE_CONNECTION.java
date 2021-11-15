/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

//import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 * @author Magic
 */
public class MY_HANDLE_CONNECTION {

    private Connection conn;

    public MY_HANDLE_CONNECTION() throws SQLException {
        String cntString = "jdbc:sqlserver://PRIME\\PRIMESQL:1433;databaseName=QUANLYTHUVIEN";
        try {
            conn = DriverManager.getConnection(cntString, "sa", "123456");
        } catch (SQLException e) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Có lỗi khi kết nối DB~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    public ResultSet RunQuery(String query) throws SQLException {
        ResultSet rs = null;
        Statement state = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(query);
        } catch (SQLException ex) {
            JFrame f = new JFrame();
            JOptionPane.showMessageDialog(f, "Co loi khi truy van Query:" + ex.getMessage());
        }

//        state.close();
        return rs;
    }

    public boolean RunQuery(String[] query) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(query[0]);
        for (int i = 1; i < query.length; i++) {
            ps.setString(i, query[i]);
        }
        if (ps.executeUpdate() > 0) {
            ps.close();
            return true;
        }
//        ps.close();
        return false;
    }

    public ResultSet RunQuery_Get(String[] query) throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = conn.prepareStatement(query[0]);
        for (int i = 1; i < query.length; i++) {
            ps.setString(i, query[i]);
        }
        try {
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Loi khi chay query!!!");
        }
//        ps.close();
        return rs;
    }

    public void Close() throws SQLException {
        conn.close();
    }

}
