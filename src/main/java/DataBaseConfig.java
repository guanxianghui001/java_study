import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class DataBaseConfig {

    // 声明静态变量  
    static HikariConfig config = new HikariConfig();
    static DataSource ds;

    // 使用静态初始化块来初始化静态变量  
    static {
        config.setJdbcUrl("jdbc:mysql://localhost:3306/student?serverTimezone=UTC&useSSL=false");
        config.setUsername("root");
        config.setPassword("Qa123456");
        config.addDataSourceProperty("connectionTimeout", "1000"); // 连接超时：1秒  
        config.addDataSourceProperty("idleTimeout", "60000"); // 空闲超时：60秒  
        config.addDataSourceProperty("maximumPoolSize", "10"); // 最大连接数：10  

        // 使用配置初始化DataSource  
        ds = new HikariDataSource(config);
    }

    // 防止实例化此类  
    private DataBaseConfig() {
        throw new AssertionError("No instances for you!");
    }

    // 可以添加获取DataSource的方法  
    public static DataSource getDataSource() {
        return ds;
    }
}