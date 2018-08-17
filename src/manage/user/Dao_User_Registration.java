package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Dao_User_Registration {
	
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	int emailcount=0;
	 public boolean verifyUserIsUnique(String email){
	
	 try {
			
		 ps = con.prepareStatement("SELECT COUNT(email)  FROM user_details WHERE email=?");
			 ps.setString(1, email);
			 ResultSet rs = ps.executeQuery();
			 while (rs.next()) {
			      emailcount = rs.getInt(1);
			    }
			 
			 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	
	 
	 if(emailcount==0){
		 return true;
	
	 }
	 else{
		 return false;
	 }
	 
	 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public String getUserId(String email){
			String userid="";
		 try {
				
			 ps = con.prepareStatement("SELECT user_id  FROM user_details WHERE email=?");
				 ps.setString(1, email);
				 ResultSet rs = ps.executeQuery();
				 while (rs.next()) {
					 userid=rs.getString(1);
				    }
				 
				 

	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		
		return userid;
		
		 
		 
		 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void connClose(){
		 try {
			 if(ps!=null){
				 ps.close(); 
			 }
			 if(con!=null){
				 con.close();
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}