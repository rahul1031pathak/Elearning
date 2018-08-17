package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Validation {
	DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps=null;
	  
	public boolean Validate_User_For_Response_to_Request(String userid,String membershipId){
		
		 try {
			 ps = con.prepareStatement("SELECT Class_Admin_Id FROM membership_req WHERE Member_req_id=?");
			 ps.setString(1, membershipId );
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
	
	
	
	
	
	
	
	
	
	
	
	

	public boolean can_delete_membership(String userid,String classid){

		 try {
			 ps = con.prepareStatement("SELECT * FROM membership_table WHERE user_id=? and class_id=?");
			 ps.setString(1, userid);
			 ps.setString(2, classid);
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
	
	
	
	
	
	

	public boolean can_delete_subscribtion(String userid,String classid){

		 try {
			 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE user_id=? and class_id=?");
			 ps.setString(1, userid);
			 ps.setString(2, classid);
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
	
	
	
	
	
	
	
	
	
	
	
	public boolean Can_Delete_Question(String userid,String quesid){
		String qes_raiser = null;
		String class_id = null;
		 try {
			 ps = con.prepareStatement("SELECT qes_raiser,class_id FROM questioninwritten WHERE ques_id=?");
			 ps.setString(1, quesid );
			ResultSet rs=  ps.executeQuery();
			while(rs.next()){
				qes_raiser=rs.getString(1);
				class_id=rs.getString(2);;
				
			}
			
			if(userid.equals(qes_raiser)){
			
				return true;
			}
			else if(Is_Class_Admin(userid,class_id)){
				
				return true;
			}
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		
		return false;
		
		
	}
		
	
	
	public boolean Can_Delete_Article(String userid,String article_id){
		
		
		String article_raiser = null;
		String class_id = null;
		 try {
			 ps = con.prepareStatement("SELECT article_writer,class_id FROM article WHERE article_id=?");
			 ps.setString(1, article_id );
			ResultSet rs=  ps.executeQuery();
			while(rs.next()){
				article_raiser=rs.getString(1);
				class_id=rs.getString(2);;
				
			}
			
			if(userid.equals(article_raiser)){
			
				return true;
			}
			else if(Is_Class_Admin(userid,class_id)){
				
				return true;
			}
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	
	
	public boolean Can_Delete_YoutubeVideo(String userid,String video_id){
		
		
		String class_id = null;
		 try {
			 ps = con.prepareStatement("SELECT class_id FROM shared_videos WHERE id=?");
			 ps.setString(1, video_id );
			ResultSet rs=  ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString(1)+"hello");
				class_id=rs.getString(1);
				
			}
			
			 if(Is_Class_Admin(userid,class_id)){
				
				return true;
			}
			else return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		
		return false;
		
	}
	
	
	
	
	

	public boolean Should_Accept(String sender_id,String class_id){
		
		
		
		 try {
			 ps = con.prepareStatement("SELECT * FROM membership_table WHERE user_id=? AND class_id=?");
			 ps.setString(1, sender_id );
			 ps.setString(2, class_id );
			ResultSet rs=  ps.executeQuery();
			while(rs.next()){
				return false;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		
		return true;
		
	}
	
	
	
	
	
	
	public boolean Is_Subcribe_Request_Unique(String sender_id,String class_id){
		
		
		
		 try {
			 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE user_id=? AND class_id=?");
			 ps.setString(1, sender_id );
			 ps.setString(2, class_id );
			ResultSet rs=  ps.executeQuery();
			while(rs.next()){
				return false;
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
			
		}
		
		return true;
		
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
