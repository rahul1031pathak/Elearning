package database.opreation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Refrence_Manager_For_Deleting {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	  
	  
	  
	  public boolean delete_ques_ref_ques(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_ques_ques WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			}  
			
	  
	  
	  public boolean delete_ques_ref_article(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_ques_article WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			} 
	  
	  
	  public boolean delete_ques_ref_video(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_ques_video WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			} 
	  
	  
	  public boolean delete_article_ref_video(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_article_video WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			} 
	  
	  
	  public boolean delete_video_ref_video(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_video_video WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			} 
	  
	  
	  public boolean delete_article_ref_article(String user_id,String id){
		  try {
				ps = con.prepareStatement("DELETE FROM ref_article_article WHERE id=?");
				 ps.setString(1, id);
				
				
			    ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			  return true; 
			} 
		  
	  }


