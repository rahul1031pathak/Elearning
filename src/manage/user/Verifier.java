package manage.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Verifier {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	int i;
	 PreparedStatement ps;
	
	public String FetchClassAdmin(String id1){
		 ResultSet rs = null;
		 String classAdmin = null;
		 try {
			
			
			 ps = con.prepareStatement("SELECT Class_Admin FROM classroom_details WHERE class_id=?"); 
			ps.setString(1,id1);
			 rs=ps.executeQuery();
			
			while( rs.next()){  
				
				classAdmin=rs.getString(1)+"";	
			}  
			
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		} 
		 return classAdmin;
	 }
	
	
	
	public void connClose(){  
		 try {
	    	 // ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
