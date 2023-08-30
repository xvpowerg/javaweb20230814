package tw.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBTools {
	private static String url = "jdbc:mysql://localhost:3306/testdb20230828?serverTimezone=CST&useSSL=false&allowPublicKeyRetrieval=true";
    private static String user = "root";
    private static String password = "123456";
    
    private DBTools() {}
    public static Connection getConnection() throws SQLException {
    	Connection con = 
    			DriverManager.getConnection(url,user,password);
    	return con;
    }
    
    public static StudentDao getMySQLStudentDao() {
    	return new MySqlDao();
    }
    public static StudentDao getMSSQLStudentDao() {
    	return new MSSQLDao();
    }
    
}
