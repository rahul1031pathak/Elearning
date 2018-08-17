package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Save_Bookmark {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	 PreparedStatement ps;
	 
	 public boolean save_Notification(String user_id,String notifications_id){
		 if(!check_save_Notifications(user_id,notifications_id)){
			 
	
		 try {

			  ps = con.prepareStatement("INSERT INTO saved_notifications (user_id,notifications_id) VALUES(?,?)"); 
			 ps.setString(1, user_id);
			 ps.setString(2, notifications_id);
				
			  ps.executeUpdate();
			if(ps!=null){
				ps.close();	
			}
			connClose();
			return true;
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		 
		 }
		 return false;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean save_Question(String user_id,String id){
		 
		 if(!check_save_Question(user_id, id)){
			 
		
		 try {

			  ps = con.prepareStatement("INSERT INTO saved_questions (user_id,question_id) VALUES(?,?)"); 
			 ps.setString(1, user_id);
			 ps.setString(2, id);
				
			  ps.executeUpdate();
			if(ps!=null){
				ps.close();	
			}
			connClose();
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 return true;
		 } 
		 return false;
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean save_Article(String user_id,String id){
		 
		 if(!check_save_Articles(user_id, id)){
			 
		
		 try {

			  ps = con.prepareStatement("INSERT INTO saved_article(user_id,article_id) VALUES(?,?)"); 
			 ps.setString(1, user_id);
			 ps.setString(2, id);
				
			  ps.executeUpdate();
			if(ps!=null){
				ps.close();	
			}
			connClose();
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		 return true;
		 } 
		 return false;
	 }
	 
	 
	 
	 public boolean check_save_Question(String user_id,String id){
		 try {

			  ps = con.prepareStatement("SELECT  * FROM saved_questions  where user_id=? and question_id=?"); 
			 ps.setString(1, user_id);
			 ps.setString(2, id);
				
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()){	
                       return true;					
				}
			 
		
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return false;
	 } 
	 
	 
	 public boolean check_save_Notifications(String user_id,String id){
		 try {

			  ps = con.prepareStatement("SELECT  * FROM saved_notifications  where user_id=? and notifications_id=?"); 
			 ps.setString(1, user_id);
			 ps.setString(2, id);
				
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()){	
                       return true;					
				}
			 
		
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return false;
	 } 
	 
	 public boolean check_save_Articles(String user_id,String id){
		 try {

			  ps = con.prepareStatement("SELECT  * FROM saved_article  where user_id=? and article_id=?"); 
			 ps.setString(1, user_id);
			 ps.setString(2, id);
				
			 ResultSet rs = ps.executeQuery();
			 if(rs.next()){	
                       return true;					
				}
			 
		
			  
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		
		 return false;
	 }
	 
	 public void connClose(){
		 try {
			 if(con!=null){
					con.close();	
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
