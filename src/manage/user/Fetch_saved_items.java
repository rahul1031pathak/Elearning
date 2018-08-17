package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import structure.classroom.Article;
import structure.classroom.Notification;
import structure.classroom.Question;

public class Fetch_saved_items {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	
	
	public ArrayList<String> Fetch_saved_notifications_id(String user_id){
		ArrayList<String> ids=new ArrayList<String> ();
		
		
		 
        try {
        	 ResultSet rs;    
        	
								 ps = con.prepareStatement("SELECT  notifications_id FROM saved_notifications WHERE user_id=? ORDER BY saved_notifications_id DESC");
       
								 ps.setString(1, user_id );
            rs = ps.executeQuery();
             while(rs.next()){	
            	// Saved_item saved_item= new Saved_item(rs.getInt(1)+"",rs.getString(2),rs.getString(3));
            	 ids.add(rs.getString(1));
               }              
             
    }
  catch (SQLException e) {
      e.printStackTrace();
       }finally{

}
   return ids;
	}
	
	
	
	public String Fetch_saved_notifications(String user_id){
		
		ArrayList<Notification> notifications=new ArrayList<Notification>();
		ArrayList<String> 	ids =Fetch_saved_notifications_id(user_id);
		 
		 try {
        	 ResultSet rs;    
        	for(int i=0;i<ids.size();i++){
								 ps = con.prepareStatement("SELECT  * FROM notification WHERE notification_id=? ORDER BY DateTime DESC LIMIT 100");
          ps.setString(1,ids.get(i) );
            rs = ps.executeQuery();
             while(rs.next()){	
            	 Notification notification=new Notification(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getTimestamp(9));
            		notifications.add(notification);
            	 
             }
        	}
		 }
  catch (SQLException e) {
      e.printStackTrace();
       }finally{

    	
       }
  
		   Gson gson=new Gson();
    	 
    	 
    	  
    	   connClose();
    	   return gson.toJson( notifications);
	}
	
	
	
	
	
	
	
	public ArrayList<String> Fetch_saved_questions_id(String user_id){
		ArrayList<String> ids=new ArrayList<String> ();
		
		
		 
        try {
        	 ResultSet rs;    
        	
								 ps = con.prepareStatement("SELECT  question_id FROM saved_questions WHERE user_id=? ORDER BY saved_questions_id DESC");
       
								 ps.setString(1, user_id );
            rs = ps.executeQuery();
             while(rs.next()){	
           
            	 ids.add(rs.getString(1));
               }              
             
    }
  catch (SQLException e) {
      e.printStackTrace();
       }finally{

}
   return ids;
	}
	
	
	
	public String Fetch_saved_questions(String user_id){
		 ResultSet rs = null;
		
		ArrayList<Question> questionList=new ArrayList<Question>();
		ArrayList<String> ids =Fetch_saved_questions_id(user_id);
		 try {
			 for(int i=0;i<ids.size();i++){
			 ps = con.prepareStatement("SELECT * FROM questioninwritten WHERE ques_id=? ");
			
			 ps.setString(1, ids.get(i));
			 rs=ps.executeQuery();
			 
			// try {
				 while(rs.next()){
					
					 Question qesans=new Question(ids.get(i),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
						questionList.add(qesans);
			//	 }
			
		} //finally{ }
			  }
		 }
		 catch (SQLException e) {
			e.printStackTrace(); 
		} finally{ }
  
		   Gson gson=new Gson();
    	 
    	 
    	
    	   connClose();
    	  
    	   return gson.toJson(questionList);
	}
	
	
	
	
	
	
	
	
	

	public ArrayList<String> Fetch_saved_article_ids(String user_id){
		ArrayList<String> ids=new ArrayList<String> ();
		
		
		 
        try {
        	 ResultSet rs;    
        	
								 ps = con.prepareStatement("SELECT  article_id FROM saved_article WHERE user_id=? ORDER BY saved_article_id DESC");
       
								 ps.setString(1, user_id );
            rs = ps.executeQuery();
             while(rs.next()){	
            	
            	 ids.add(rs.getString(1));
               }              
             
    }
  catch (SQLException e) {
      e.printStackTrace();
       }finally{

}
   return ids;
	}
	
	
	
	
	
	
	
	

	public String Fetch_saved_articles(String user_id){
		 ResultSet rs = null;
		 ArrayList<Article> articleList=new  ArrayList<Article>();
		 ArrayList<String> ids =Fetch_saved_article_ids(user_id);
		
		 try {
				
			 for(int i=0;i<ids.size();i++){
				
			 ps = con.prepareStatement("SELECT * FROM article WHERE article_id=? ORDER BY datetime DESC LIMIT 100");
			 ps.setString(1, ids.get(i));
			 rs=ps.executeQuery();
			 
			 try {
				 while(rs.next()){
					 
					 Article aticle=new  Article(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
					 
					 articleList.add(aticle);
					 
				 } 
			 }
		  finally{ }
			  }
		 }
		 catch (SQLException e) {
			e.printStackTrace(); 
		} finally{ }
  
		   Gson gson=new Gson();
    	 
    	 
    	   connClose();
    	   return gson.toJson(articleList);
	
	}
	
	
	
	
	
	public void connClose(){ 
		 try {
			 if(ps!=null){
				 ps.close(); 
			 }
	    	 
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	
	
	
	
	

}
