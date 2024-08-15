import java.sql.*;
public class conn_jdbc {
    public static void main(String[] args) throws SQLException {
        String JDBC_URL = "jdbc:mysql://localhost:3306/student?useSSL=false";
        String JDBC_USER = "root";
        String JDBC_PASSWORD = "Qa123456";

        Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);{
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, name, age FROM student WHERE id=? ")) {
                ps.setObject(1, "M"); // 注意：索引从1开始
                ps.setObject(2, 3);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        long id = rs.getLong("id");
                        String name = rs.getString("name");
                    }
                }
            }




    }

}

}
