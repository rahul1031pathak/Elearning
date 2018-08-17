package fetch.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import in.Elearning.java.Notice_In_Class;

import structure.classroom.Article;
import structure.classroom.FileContent;
import structure.classroom.Question;
import structure.classroom.SharedVideos;
import structure.user.User;
import structure.user.UserList;

public class Fetch_CLass_Content {

	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	int i;
	

	  public String  getUploadedFileListInJsonSting(String ClassId){
		  ResultSet rs = null;
		  
		  Gson gson=new Gson();
			ArrayList<FileContent> fileList=new ArrayList<FileContent>();
			 try {
				
			 ps = con.prepareStatement("SELECT * FROM fileuploaded WHERE Class_Id=? ORDER BY datetime DESC ");
				 ps.setString(1, ClassId);
				 rs=ps.executeQuery();
				 
				 try {
					 boolean t=rs.next();
						while(t){
							FileContent fileContent =new FileContent(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getString(6),rs.getString(7));
							fileList.add(fileContent);
						 t=rs.next();
						}
				
			} finally{ }
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
			 return gson.toJson(fileList);
	  }
	  
	  
	  
	  public String  FetchQuestions(String ClassId){
		  ResultSet rs = null;
  
		  
		  Gson gson=new Gson();
			ArrayList<Question> questionList=new ArrayList<Question>();
	  
		
			 
			 
			 try {
					
					 ps = con.prepareStatement("SELECT * FROM questioninwritten WHERE Class_Id=? ORDER BY datetime DESC ");
					 ps.setString(1, ClassId);
					 rs=ps.executeQuery();
					 
					 try {
						 while(rs.next()){
							
							 String id=rs.getInt(1)+"";
							 Question qesans=new Question(id,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
							 questionList.add(qesans);
						 }
					
				} finally{ }
				 }
				 catch (SQLException e) {
					e.printStackTrace(); 
				} 
			 
			  return gson.toJson(questionList);
	  } 
	  
	  
	  
	  
	  
	  
	  public String  FetchArticles(String ClassId){
		  ResultSet rs = null;
  
		  
		  Gson gson=new Gson();
			ArrayList<Article> articleList=new ArrayList<Article>();
	  
		
			 
			 
			 try {
					

				 ps = con.prepareStatement("SELECT * FROM article WHERE class_id=? ORDER BY datetime DESC LIMIT 100");
				 ps.setString(1, ClassId);
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
						 
						 Article aticle=new  Article(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
						 
						 articleList.add(aticle);
						 
					 } 
				
			} finally{ } 
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
			 
			  return gson.toJson(articleList);
	  } 
	  
	  public String fetch_Yuotube_List(String ClassId){
		  ResultSet rs = null;
		  Gson gson=new Gson();
		  ArrayList<SharedVideos> youtubeVideoList=new ArrayList<SharedVideos>();
			 try {
					
				 ps = con.prepareStatement("SELECT * FROM shared_videos WHERE class_id=?");
				 ps.setString(1, ClassId);
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
						 
						 SharedVideos sharedVideos=new   SharedVideos(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
						 
						 youtubeVideoList.add(sharedVideos);
						 
					 }
				
			} finally{ } 
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
	  return gson.toJson(youtubeVideoList);
	  }
	  
	  
	  
	  
	  

		public String fetch_Memberships(String class_id){
			//ArrayList<String> ids=new ArrayList<String>();
			UserList userlist=new UserList();
			User user=null;
	            try {
	                     
	                  //       ps = con.prepareStatement("SELECT user_id FROM membership_table WHERE class_id=?");
                   ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id IN(SELECT user_id FROM membership_table WHERE class_id=?)");
     
	            	ps.setString(1, class_id);
	                        ResultSet rs = ps.executeQuery();
	                       while(rs.next()){
	                   		//ids.add(rs.getString(1));
	                    		user=new User(rs.getString(1),rs.getString(2),rs.getInt(4),rs.getString(11),rs.getString(12),rs.getString(13),rs.getTimestamp(5));
	                               userlist.userlist.add(user);
	                       }
	                      }

	      catch (SQLException e) {
	          e.printStackTrace();
	           }finally{

	}
     
	            Gson gson=new Gson();
		    	 
		    	 
		    	   connClose();
		    	   return gson.toJson(userlist);
	          //   return   fetchUserDetailsByUserIdList(ids);

	}
	  
	  
		
		

		public String fetch_subscribers(String class_id){
			//ArrayList<String> ids=new ArrayList<String>();
			UserList userlist=new UserList();
			User user=null;
	            try {
	                     
	                         ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id IN(SELECT user_id FROM subscriber_table WHERE class_id=?)");
	                         ps.setString(1, class_id);
	                        ResultSet rs = ps.executeQuery();
	                       while(rs.next()){
	                    		user=new User(rs.getString(1),rs.getString(2),rs.getInt(4),rs.getString(11),rs.getString(12),rs.getString(13),rs.getTimestamp(5));
	                               userlist.userlist.add(user);
	                   		
	                       }
	                      }

	      catch (SQLException e) {
	          e.printStackTrace();
	           }finally{

	}
	            Gson gson=new Gson();
		    	 
		    	 
		    	   connClose();
		    	   return gson.toJson(userlist);
        //System.out.println(ids.size());
       // return   fetchUserDetailsByUserIdList(ids);

	}
		
		
		
		
		
	  
		public String fetchUserDetailsByUserIdList(ArrayList<String> ids  ){
			
							UserList userlist=new UserList();
							User user=null;
									try {
											
	                          for(int i=0;i<ids.size();i++){
												 ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
	                        ps.setString(1, ids.get(i) );
												// Array array = con.createArrayOf("varchar", ids.toArray());
												// ps.setArray(1, array);
	                            ResultSet rs = ps.executeQuery();
	                            while(rs.next()){	 
	                            	user=new User(rs.getString(1),rs.getString(2),rs.getInt(4),rs.getString(11),rs.getString(12),rs.getString(13),rs.getTimestamp(5));
	                               userlist.userlist.add(user);
	                            }
	                          }


		}

		catch (SQLException e) {
						e.printStackTrace();
						}finally{

	}

									  Gson gson=new Gson();
								    	 
								    	 
							    	   connClose();
							    	   return gson.toJson(userlist);
				
	}
	  
	  
	  
	  public String Fetch_Notices_From_Class(String ClassId){
		  ResultSet rs = null;
		  Gson gson=new Gson();
			ArrayList<Notice_In_Class> noticeList=new ArrayList<Notice_In_Class>();
		  try {
				
				 ps = con.prepareStatement("SELECT * FROM notice_board WHERE class_id=? ORDER BY  notice_id DESC LIMIT ?");
				 ps.setString(1, ClassId);
				 ps.setInt(2, 4 );
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
						 
						 Notice_In_Class notice=new Notice_In_Class(rs.getString(2),rs.getString(3),rs.getTimestamp(4));
						 
						 noticeList.add(notice);
						 
					 }
				
			} finally{ } 
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
		  return gson.toJson(noticeList);
	  }
	  
	  
	  
	  
	  
	  public  ArrayList<String> FetchClassPrivacy(String ClassId){
		  ResultSet rs = null;
		  ArrayList<String> classPrivacy=new ArrayList<String>();
		  try {
				
				 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
				 ps.setString(1, ClassId);
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
						
						 classPrivacy.add(rs.getString(9));
						 classPrivacy.add(rs.getString(8));
						 classPrivacy.add(rs.getString(7));
						 classPrivacy.add(rs.getString(1));
						 classPrivacy.add(rs.getString(6));
						 classPrivacy.add(rs.getString(2));
						 classPrivacy.add(rs.getString(10));
						 classPrivacy.add(rs.getString(11));
						 classPrivacy.add(rs.getString(3));
						 classPrivacy.add(rs.getString(12));
					 }
				
			} finally{ }
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
		  
		  
		  return classPrivacy;
	  }
	  
	  public  ArrayList<String> FetchAdminDetails(String ClassId){
		  ResultSet rs = null;
		  ArrayList<String> admin_details=new ArrayList<String>();
		  try {
				
				 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
				 ps.setString(1, ClassId);
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
						 admin_details.add(rs.getString(1));
						 admin_details.add(rs.getString(2));
						 admin_details.add(rs.getString(11));
						 admin_details.add(rs.getString(13));
						 admin_details.add(rs.getString(14));
					 }
				
			} finally{ }
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
		  
		  
		  return admin_details;
	  }
	  
	  
	  public String fetchClassNameWithQuesId(String quesid){
		String classid="";
		 ResultSet rs = null;
		 try {
			ps = con.prepareStatement("SELECT class_id FROM questioninwritten WHERE ques_id=?");
			 ps.setString(1,quesid);
			 rs=ps.executeQuery();
		while(rs.next()){
			classid=rs.getString(1);
		}
		 }catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return classid;
		
		
	} 
	
		 
	  public String is_subAdmin(String user_id,String class_id){
		 
		  
		  ResultSet rs = null;
			 try {
				ps = con.prepareStatement("SELECT sub_admin_user_id FROM sub_admin WHERE class_id=?");
				 ps.setString(1,class_id);
				 rs=ps.executeQuery();
			while(rs.next()){
			if(rs.getString(1).equals(user_id)){
			return "true";
			}
			
			}
			 }catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		  
		  
		  
		  return "false";
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
