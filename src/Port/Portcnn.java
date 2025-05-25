package Port;

import java.sql.*;

public class Portcnn {
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }
    }

    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/lms";
            con = DriverManager.getConnection(url, "root", "1111");
//         con.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static PreparedStatement prepareStatement(String sql) {
        PreparedStatement pstmt = null;
        try {
            Connection con = getConnection(); // 이거 누락됐을 수 있어
            pstmt = con.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public static Statement createStatement() {
        Statement stmt = null;
        try {
            Connection con = getConnection();
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }
}
