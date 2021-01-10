package ApplicationGui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
	
	private Connection con;
	
	public DatabaseConnect() {
		
		String url ="jdbc:mysql://150.140.186.221:3306/project_db20_up1053566";
		String user="db20_up1053566";
		String password="up1053566";
			
		try {
			//Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to database");
		}catch(SQLException e1) {
			System.out.println("Error");
			e1.getMessage();
			}
		}

	public Connection getCon() {
		return con;
	}
		
	

}
