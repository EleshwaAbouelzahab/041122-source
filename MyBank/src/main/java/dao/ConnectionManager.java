package dao;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


// this is the class where i will make a connection to the database.
public class ConnectionManager {
	
	// this is an instance of the Connection.
	private static Connection connection;
	
	//this is our connection data
	private static String connectionString = "jdbc:postgresql://heffalump.db.elephantsql.com:5432/csrfqqiy",
			
				username = "csrfqqiy",
				password = "MwNyk9QXfNtOnLAynvDABRj-zdXXil9_";
	
	public static Connection getConnection() {
		
		//this will not compile without being in a try/catch block
		try {
				if (connection == null || connection.isClosed()) {
				//this ensures that the driver class is loaded before we try to use it.
				Class.forName("org.postgresql.Driver");
				
				//this says to use the DrvierMangaer to make sure there us a suitable driver to make the connection string work
				connection = DriverManager.getConnection(connectionString, username, password);
				
				}
				
				return connection;
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

