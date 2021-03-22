package page;
import java.sql.*;
public class DatabasePage {

			
		 public static String getData(String columnName) throws ClassNotFoundException, SQLException {
			  // Setting properties for mysql
			 Class.forName("com.mysql.cj.jdbc.Driver");
			  // creating a connection to your local database
			  
			  String sqlUrl = "jdbc:mysql://localhost:3306/august2020";
			  String sqlUsername = "root";  
			  String sqlPass = "root";
			  String query = "select * from users";
			  Connection con = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPass);
			  
			// Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/august2020", "root", "root");
			 
			 // empowering the con reference valiable to execute queries
			  Statement smt = con.createStatement();
			  // delivering the sql query
			  ResultSet rs = smt.executeQuery(query);
			  while (rs.next()) {
			  return rs.getString(columnName);
			  }
			  return columnName;
			  }
}
