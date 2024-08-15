
import java.sql.*;

public class conn_jdbc1 {

    public static void main(String[] args) throws SQLException {
        // 数据库URL，包括JDBC子协议、数据库地址、数据库名
        String url = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
        // 数据库用户
        String user = "root";
        // 数据库密码
        String password = "Qa123456";

//        try {
//            // 加载并注册JDBC驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 建立连接
//            Connection conn = DriverManager.getConnection(url, user, password);
//
//            // 创建Statement对象来执行SQL语句
//            Statement stmt = conn.createStatement();
//
//            // 执行查询并获取结果集
//            String sql = "SELECT * FROM student"; // 替换为你的查询语句
//            ResultSet rs = stmt.executeQuery(sql);
//
//            // 处理结果集
//            while (rs.next()) {
//                // 假设你的表有id和name两个字段
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                System.out.println("ID: " + id + ", Name: " + name);
//            }
//
//            // 关闭资源
//            rs.close();
//            stmt.close();
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Connection conn = DriverManager.getConnection(url, user, password);
        {
            try (PreparedStatement ps = conn.prepareStatement("SELECT id, name, age FROM student WHERE score=? ")) {
                long score = 99;
                ps.setLong(1, score);// 注意：索引从1开始
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Long age = rs.getLong("age");
                        String name = rs.getString("name");
                        System.out.println(age+name+score);
                    }
                }
            }


        }
    }
}