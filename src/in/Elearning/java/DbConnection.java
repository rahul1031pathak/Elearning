package in.Elearning.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection con;
	
public Connection getMysqlConnection(){
		String DRIVER="com.mysql.jdbc.Driver";  
	 	//String DBURL="jdbc:mysql://aa1hfcsqafl0ctq.cl8xireep4wv.us-west-2.rds.amazonaws.com:3306/ebdb";
		
		    
	//String DBUSER="rahul1031pathak";
//	String DBPASSWORD="29083110";  
		
 	String DBURL="jdbc:mysql://aar33vj7u9pa7n.ccamqfyh1rir.ap-southeast-1.rds.amazonaws.com/ebdb";
 	String DBUSER="rahul103pathak";
   String DBPASSWORD="06053110";
 	
//String DBURL="jdbc:mysql://localhost:3306/ebdb";
	//String DBUSER="root";
	//String DBPASSWORD="";   
	
	
	

		try {
			Class.forName(DRIVER);
			 con= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (SQLException sqle){
			sqle.printStackTrace();
		}
		
		return con;
	
}

}
