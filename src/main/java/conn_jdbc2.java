import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.github.javafaker.Faker;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.Random;

public class conn_jdbc2 {

    private static final String URL = "jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Qa123456";

    // 创建连接  
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    static DataSource dataSource = DataBaseConfig.ds;
    // 插入数据  
    public static void insert(String name, int age, int score) {
        String sql = "INSERT INTO student (name, age,score) VALUES (?, ?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 查询数据  
    public static void select() {
        String sql = "SELECT id, name, age,score FROM student";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int score = rs.getInt("score");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", score: " + score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 更新数据  
    public static void update(long id, String newName, int newAge) {
        String sql = "UPDATE student SET name = ?, age = ? WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.setInt(2, newAge);
            pstmt.setLong(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除数据  
    public static void delete(String newName) {
        String sql = "DELETE FROM student WHERE name = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        // 示例：插入、查询、更新、删除
        for (int i = 0; i < 10; i++) {
            Student student = Student.get_data();
            insert(student.getName(), student.getAge(), student.getScore());
            select();
        }

//        update(1, "Jane Doe", 21);
//        select();
//        delete("Jayde McClure");
//        select();
        Connection conn = getConnection();

    }
    }
