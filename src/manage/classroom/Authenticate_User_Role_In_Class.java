package manage.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.Elearning.java.DbConnection;

public class Authenticate_User_Role_In_Class {
	
	DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps=null;

	public boolean Is_Class_Admin(String userid,String classid){

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
	
	
	
	
	
	
	
	
	public boolean Is_Class_subAdmin(String userid,String classid){

		 try {
			 ps = con.prepareStatement("SELECT sub_admin_user_id FROM sub_admin WHERE class_id=?");
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
	
	
	
	
	
	public boolean Is_Class_Member(String userid,String classid){

		 try {
			 ps = con.prepareStatement("SELECT * FROM membership_table WHERE class_id=? AND user_id=?");
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
	


	public boolean Is_Class_Subscriber(String userid,String classid){

		 try {
			 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE class_id=? AND user_id=?");
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
	
	
	
	
	public ArrayList<String> User_Role(String userId,String classId){
		
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps =null;
		  ResultSet rs = null;
		 String can_view="";
		 String  can_question="";
		 String  can_answer="";
		 String is_classMember="false";
		 String is_subscriber="false";
		 String is_classAdmin="false";
		 String is_subAdmin="false";
		 String is_memberShipReqsent="false";
		  String zero="0";
		  String one="1";
		;
		
		
		
		
		 try {
				
			 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
				 ps.setString(1, classId);
				 rs=ps.executeQuery();
				 while(rs.next()){
					 
				
					 if(rs.getString(7).equals(one)){
						 can_answer="true"; 
					 }else{if(rs.getString(7).equals(zero)){
						 can_answer="false";}
					 }
					 
					 
					 if(rs.getString(8).equals(one)){
						 can_question="true"; 
					 }else{if(rs.getString(8).equals(zero)){
						 can_question="false";}
					 }

					 if(rs.getString(9).equals(one)){
						 can_view="true"; 
					 }else{if(rs.getString(9).equals(zero)){
						 can_view="false";}
					 }
					 
					 if(rs.getString(2).equals(userId)){
						 is_classAdmin="true";
						 can_answer="true";
						 can_question="true"; 
						 can_view="true";
					 }
					 
				 }
				 
				 ps = con.prepareStatement("SELECT * FROM membership_table WHERE class_id=? AND user_id=?");
				 ps.setString(1, classId);
				 ps.setString(2, userId);
				 rs=ps.executeQuery();
				 while(rs.next()){
					// if(rs.getString(2).equals(userId)){
						 is_classMember="true";
						 can_answer="true";
						 can_question="true"; 
						 can_view="true";
					// }
					 
					 
				 }
				 
				 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE class_id=? AND user_id=?");
				 ps.setString(1, classId);
				 ps.setString(2, userId);
				 rs=ps.executeQuery();
				 
				 
				 while(rs.next()){
					 //if(rs.getString(2).equals(userId)){
						 is_subscriber="true";
				 
				 }
				 
				  ps = con.prepareStatement("SELECT * FROM membership_req WHERE class_id=? AND sender_id=?");
				  ps.setString(1, classId);
				  ps.setString(2, userId);
				  rs=ps.executeQuery();
				  if(rs.next()){
					  is_memberShipReqsent="true";
					  
				  }
				  
				  
				  
				  
				  ps = con.prepareStatement("SELECT sub_admin_user_id FROM sub_admin WHERE class_id=?");
					 ps.setString(1, classId);
					 rs=ps.executeQuery();
					 while(rs.next()){   
						 if(rs.getString(1).equals(userId)){
							 is_subAdmin="true";
							 can_answer="true";
							 can_question="true"; 
							 can_view="true";
						 }
					 }	 
					
				  
				 
				  ps.close();
				 
				 
				 } 
		 catch (SQLException e) {
				e.printStackTrace();
			} 
		
		 finally{ }
				 
		 
		 try {
	    	 
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				ArrayList<String> result=new ArrayList<String>();
				
	
				
				result.add(	is_classAdmin); //0
		 result.add(is_subAdmin);   //1
		 result.add( is_classMember); //2
		 result.add(is_subscriber);  //3
		 result.add(can_question);   //4
		 result.add(can_answer);     //5
		 result.add( can_view);      //6
	 result.add( is_memberShipReqsent);
	 connClose();
		 	return result;
		}
		
		 
	
	
	
	
	
	
	
	public void connClose(){ 
		 try {
			 if(ps!=null){
				 ps.close(); 
			 }
	    	
			// changed during winter 
if(con!=null){
	con.close();
}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
