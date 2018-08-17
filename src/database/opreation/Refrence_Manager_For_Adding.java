package database.opreation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Refrence_Manager_For_Adding {
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	  
	                            
	  
	  public boolean question_ref_question(String ques_id_1,String ques_id_2,String name,String user_id,String class_id){
		
			  try {
					ps = con.prepareStatement("INSERT INTO ref_ques_ques (ques_id_1,ques_id_2,name,user_id,class_id) VALUES(?,?,?,?,?)");
					 ps.setString(1, ques_id_1);
					 ps.setString(2, ques_id_2);
					 ps.setString(3, name);
					 ps.setString(4, user_id);
					 ps.setString(5, class_id);
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
				
	 
		  
		return false;  
	  }
	  
	  public boolean question_ref_article(String ques_id,String article_id,String name,String user_id,String class_id){
		  
		  
		  
		  try {
				ps = con.prepareStatement("INSERT INTO ref_ques_article (ques_id,article_id,name,user_id,class_id) VALUES(?,?,?,?,?)");
				 ps.setString(1, ques_id);
				 ps.setString(2, article_id);
				 ps.setString(3, name);
				 ps.setString(4, user_id);
				 ps.setString(5, class_id);
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
		  
		  
			return false;  
		  }
	  
	  
	  
	  
	  
	  public boolean question_ref_video(String ques_id,String video_id,String name,String user_id,String class_id){
		  
		 try {
				ps = con.prepareStatement("INSERT INTO ref_ques_video (ques_id,video_id,name,user_id,class_id) VALUES(?,?,?,?,?)");
				 ps.setString(1, ques_id);
				 ps.setString(2, video_id);
				 ps.setString(3, name);
				 ps.setString(4, user_id);
				 ps.setString(5, class_id);
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
		  
		  
		  
			return false;  
		  }
	  
	  
	  
	  
	  
	  public boolean video_ref_video(String video_id_1,String video_id_2,String name,String user_id,String class_id){
		  
		  
		  try {
				ps = con.prepareStatement("INSERT INTO ref_video_video (video_id_1,video_id_2,name,user_id,class_id) VALUES(?,?,?,?,?)");
				 ps.setString(1, video_id_1);
				 ps.setString(2, video_id_2);
				 ps.setString(3, name);
				 ps.setString(4, user_id);
				 ps.setString(5, class_id);
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
		  
		  
		  
		  
		  
		  
		  
			return false;  
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  public boolean article_ref_article(String article_id_1,String article_id_2,String name,String user_id,String class_id){
	  try {
				ps = con.prepareStatement("INSERT INTO ref_article_article (article_id_1,artcile_id_2,name,user_id,class_id) VALUES(?,?,?,?,?)");
				 ps.setString(1,article_id_1);
				 ps.setString(2,article_id_2); 
				 ps.setString(3, name);
				 ps.setString(4, user_id);
				 ps.setString(5, class_id);
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
		  
		  
		  
			return false;  
		  }
	  
	  
	  public boolean video_ref_article(String video_id,String article_id,String name,String user_id,String class_id){
		  
		  try {
				ps = con.prepareStatement("INSERT INTO ref_article_video (article_id,video_id,name,user_id,class_id) VALUES(?,?,?,?,?)");
				 ps.setString(1,article_id);
				 ps.setString(2,video_id);
				 ps.setString(3, name);
				 ps.setString(4, user_id);
				 ps.setString(5, class_id);
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
		
			return false;  
		  }
	  
	  
	  
	  
	  
}
