package database.opreation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Manage_Admin_Of_Class {

	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	  
		
		private boolean Is_Class_Admin(String userid,String classid){

			 try {
				 ps = con.prepareStatement("SELECT Class_Admin FROM classroom_details WHERE class_id=?");
				 ps.setString(1, classid);
				ResultSet rs=  ps.executeQuery();
				while(rs.next()){
					if(rs.getString(1).equals(userid)){
						return true;
					}
					else{
						return false;
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
				return false;
			}
			
			return false;
			
			
		}
		
	public boolean Add_Admin(String class_id,String user_id,String sub_admin_email ){
		
		if(Is_Class_Admin( user_id,class_id)){
			String sub_admin_user_id=getUserId(sub_admin_email);
			
			if(!sub_admin_user_id.isEmpty()){
		  try {
			ps = con.prepareStatement("INSERT INTO sub_admin (class_id,sub_admin_user_id) VALUES(?,?)");
			 ps.setString(1, class_id);
			 ps.setString(2, sub_admin_user_id);
			 
			int i=ps.executeUpdate();
			if(i==1){
				return true;
			}   
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
			}
		  return true;
		}
			
			
		else{
		return false;
		}	
	  }
	
	
	
	
	
	
	
	
	
	public boolean Delete_Admin(String class_id,String user_id,String sub_admin_user_id ,String id_sub_admin){
		
		
		if(Is_Class_Admin( user_id,class_id)){
		  try {
			ps = con.prepareStatement("DELETE FROM sub_admin WHERE id_sub_admin=?");
			 ps.setString(1, id_sub_admin);
			
			
		    ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  return true; 
		}  
		  
		else{
			return false;
		}
			
	  }
		 
	
	
	
	
	private String getUserId(String email){
		
		try {
			 ps = con.prepareStatement("SELECT user_id,fullname FROM user_details WHERE email=?");
			 ps.setString(1, email);
			ResultSet rs=  ps.executeQuery();
			while(rs.next()){

return rs.getString(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		return "";
	}
	
	
	
	
	
	
	public boolean change_Class_Admin(String class_id,String user_id,String new_admin_email){
		if(Is_Class_Admin( user_id,class_id)){
		
			
			
			if(Is_Class_Admin( user_id,class_id)){
				String new_admin_user_id=getUserId(new_admin_email);
				
				if(!new_admin_user_id.isEmpty()){
			  try {
				ps = con.prepareStatement("UPDATE classroom_details set Class_Admin=? WHERE class_id=?");
				
				 ps.setString(1, new_admin_user_id);
				 ps.setString(2, class_id);
				int i=ps.executeUpdate();
				if(i==1){
					return true;
				}   
				else {
					return false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				}
			  return true;
			}
				
				
			else{
			
			}	
		  }
		
		return false;
			
			
			
		}
	}
	
	
	

	

	
	
	
	
	

