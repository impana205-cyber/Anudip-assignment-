package lbs;

	
	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnection {
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/library_db",
	                "root",
	                "password"
	            );
	        } catch (Exception e) {
	            System.out.println("Database Connection Error");
	            return null;
	        }
	    }
	}
	



