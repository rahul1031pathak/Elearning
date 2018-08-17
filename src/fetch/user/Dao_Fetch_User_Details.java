package fetch.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

import in.Elearning.java.DbConnection;

import structure.classroom.Notification;
import structure.user.AlreadyMember;
import structure.user.MembershipReq;
import structure.user.Update_user;
import structure.user.User;
import structure.user.UserList;
import structure.user.User_Class_Details;




public class Dao_Fetch_User_Details {

	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	 
	public User fetchUserDetails(String loginemail, String loginpassword){
											//flag default value 0
		User user=null;
		 try {
				
				  ps = con.prepareStatement("SELECT  * FROM user_details WHERE email=?");
				 ps.setString(1, loginemail );
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()){	
				user=new User(rs.getString(1),rs.getString(2),"",rs.getInt(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)+"",rs.getTimestamp(5));
	//				 user=new User(rs.getString(1),rs.getString(2),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)+"",rs.getTimestamp(5));
	
					}
				 
				 

	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		
		return user;
		
	}
	
	 
		public User fetchUserDetails(String id){
												//flag default value 0
			User user=null;
			 try {
					
					  ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
					 ps.setString(1, id );
					 ResultSet rs = ps.executeQuery();
					 while(rs.next()){	
						 
						 // changed during winter
				 user=new User(rs.getString(1),rs.getString(2),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)+"",rs.getTimestamp(5));
						//	user=new User(rs.getString(1),rs.getString(2),"",rs.getInt(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)+"",rs.getTimestamp(5));
	
						}
					 
					 

		}
			 
			 catch (SQLException e) {
					e.printStackTrace();
				}finally{
					
				}
			
			return user;
			
		}
		
		
		
		
		
		
		
		
		
		
		

		public Update_user fetchUserDetails1(String id){
												//flag default value 0
			Update_user userSearch=null;
			 try {
					
					  ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
					 ps.setString(1, id );
					 ResultSet rs = ps.executeQuery();
					 while(rs.next()){	
						 
						 // changed during winter
                      userSearch=new Update_user(rs.getString(1),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(2),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(18),rs.getString(19),rs.getString(20));
						//	user=new User(rs.getString(1),rs.getString(2),"",rs.getInt(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getInt(14)+"",rs.getTimestamp(5));
	
						}
					 
					 

		}
			 
			 catch (SQLException e) {
					e.printStackTrace();
				}finally{
					
				}
			
			return userSearch ;
			
		}
		
	
	
	
	public ArrayList<User_Class_Details > fetchUserAsAdminClassRoomList(String userid){
		
		ArrayList<User_Class_Details > createdClassroomList=new ArrayList<User_Class_Details >();
            try {
                      
                        ps = con.prepareStatement("SELECT * FROM classroom_details WHERE Class_Admin=?");
                         ps.setString(1, userid);
                        ResultSet rs = ps.executeQuery();
                       while(rs.next()){
                    	   
                    	   User_Class_Details  classDetails =new User_Class_Details (rs.getString(4),rs.getString(1),rs.getInt(10)+"",rs.getInt(11)+"");
                    	   createdClassroomList.add(classDetails);
                       }


                         
                       ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id IN (SELECT class_id FROM sub_admin where sub_admin_user_id=?)");
                       ps.setString(1, userid);
                     rs = ps.executeQuery(); 
                   
                     while(rs.next()){
                    	
                  	   User_Class_Details  classDetails =new User_Class_Details (rs.getString(4),rs.getString(1),rs.getInt(10)+"",rs.getInt(11)+"");
                  	   createdClassroomList.add(classDetails);
                     }

}

catch (SQLException e) {
e.printStackTrace();
}finally{

}

return createdClassroomList;

}
	
	
	public ArrayList<String > fetchClassIdAsAdmin(String userid){
		
		ArrayList<String > createdClassroomList=new ArrayList<String>();
            try {
                      
                        ps = con.prepareStatement("SELECT class_id FROM classroom_details WHERE Class_Admin=?");
                         ps.setString(1, userid);
                        ResultSet rs = ps.executeQuery();
                       while(rs.next()){
                    	   createdClassroomList.add(rs.getString(1));
                       }



}

catch (SQLException e) {
e.printStackTrace();
}finally{

}

return createdClassroomList;

}


	
	public UserList fetchUserDetailsByUserIdList( ArrayList<String> ids){
		//flag default value 0
						UserList userlist1=new UserList();
						User user=null;
								try {
										
                          for(int i=0;i<ids.size();i++){
											 ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
                         ps.setString(1, ids.get(i) );
                            ResultSet rs = ps.executeQuery();
                            while(rs.next()){	
                            	user=new User(rs.getString(1),rs.getString(2),rs.getInt(4),rs.getString(11),rs.getString(12),rs.getString(13),rs.getTimestamp(5));
                               userlist1.userlist.add(user);
                            }
                          }


	}

	catch (SQLException e) {
					e.printStackTrace();
					}finally{

}

			return userlist1;
			
}	
	
	
	
	
	
	public ArrayList<MembershipReq> fetchUserMembershipRequest(String userid){
		ArrayList<MembershipReq> membershiplist=new ArrayList<MembershipReq>();
 String userid1=userid+"";
            try {
                     
                         ps = con.prepareStatement("SELECT * FROM membership_req WHERE Class_Admin_Id=?");
                         ps.setString(1, userid1);
                        ResultSet rs = ps.executeQuery();
                       while(rs.next()){
                   		MembershipReq membershipreq=new MembershipReq(rs.getString(1),rs.getString(2),rs.getString(3),rs.getTimestamp(4),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10));
                   		membershiplist.add(membershipreq);
                   		
                       }
                      }

      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}

             return  membershiplist;

}
	
	
	
	public ArrayList<String> fetchClassesAlreadyMember(String userid){
		ArrayList<String> classIdListAlreadyMember=new ArrayList<String>();
 String userid1=userid+"";
            try {
                      
                         ps = con.prepareStatement("SELECT * FROM membership_table WHERE user_id=?");
                         ps.setString(1, userid1);
                        ResultSet rs = ps.executeQuery();
                       while(rs.next()){
                   		classIdListAlreadyMember.add(rs.getString(2));
                   		
                       }
                      }

      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}

             return  classIdListAlreadyMember;

}

	
	
	
	
	

	public ArrayList<String> fetchClassIdListSubscribed(String userid){
		ArrayList<String> classIdListAlreadyMember=new ArrayList<String>();
 String userid1=userid+"";
            try {
                      
                         ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE user_id=?");
                         ps.setString(1, userid1);
                        ResultSet rs = ps.executeQuery();
                       while(rs.next()){
                   		classIdListAlreadyMember.add(rs.getString(2));
                   		
                       }
                      }

      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}

             return  classIdListAlreadyMember;

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<AlreadyMember> fetchClassesDetailsAlreadyMember(String user_id){
		
 
 ArrayList<AlreadyMember> alreadymemberList=new ArrayList<AlreadyMember>();
            try {
                     
            	  ps = con.prepareStatement(" SELECT * FROM classroom_details WHERE class_id IN (SELECT class_id FROM membership_table WHERE user_id=?)");
                  ps.setString(1, user_id);
                 ResultSet rs = ps.executeQuery();
                while(rs.next()){
            		
            	 AlreadyMember alreadymember=new AlreadyMember(rs.getString(1),rs.getString(6),rs.getInt(4)+"");
         	 alreadymemberList.add(alreadymember);
                	 
                 }
               
                      }

      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}

             return alreadymemberList;

}

		
	
	

	public ArrayList<Notification> fetchNotifications(String id,Timestamp time){
		
		
		
		
		
		Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
		ArrayList<String> classIdListAlreadyMember=new ArrayList<String> ();
		ArrayList<String> classIdListSubscribed=new ArrayList<String> ();
		ArrayList<String> classIdListAdmin=new ArrayList<String> ();
		classIdListAlreadyMember=userdetails.fetchClassesAlreadyMember(id);
		classIdListSubscribed=userdetails.fetchClassIdListSubscribed(id);
		classIdListAdmin=userdetails.fetchClassIdAsAdmin(id);
		userdetails.connClose();
		
		
		
		
 
 ArrayList<Notification> notifications=new ArrayList<Notification>();
            try {
            	 ResultSet rs; 
            	 
            	 for(int i=0;i<classIdListAdmin.size();i++){
					 ps = con.prepareStatement("SELECT  * FROM notification WHERE class_id=? ORDER BY DateTime DESC LIMIT 15");
ps.setString(1, classIdListAdmin.get(i) );

rs = ps.executeQuery();
 while(rs.next()){	
	 Notification notification=new Notification(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getTimestamp(9));
	 notifications.add(notification);
	 
 }
            	 
            	 }         	 
            	for(int i=0;i<classIdListAlreadyMember.size();i++){
									 ps = con.prepareStatement("SELECT  * FROM notification WHERE class_id=? AND DateTime>=? ORDER BY DateTime DESC LIMIT 10");
              ps.setString(1, classIdListAlreadyMember.get(i) );
              ps.setTimestamp(2,time);
                rs = ps.executeQuery();
                 while(rs.next()){	
                	 Notification notification=new Notification(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getTimestamp(9));
                	 notifications.add(notification);
                	 
                 }
                 
                 
                 for(int j=0;j<classIdListSubscribed.size();j++){
					// ps = con.prepareStatement("SELECT  * FROM notification WHERE class_id=? ORDER BY DateTime DESC LIMIT 10");
					 ps = con.prepareStatement("SELECT  * FROM notification WHERE class_id=? AND DateTime>=? ORDER BY DateTime DESC LIMIT 10");
					 ps.setTimestamp(2,time);
                	 
                	 ps.setString(1, classIdListSubscribed.get(j) );
 rs = ps.executeQuery();
 while(rs.next()){	
	 Notification notification=new Notification(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getTimestamp(9));
	 notifications.add(notification);
	 
 }
                 }              
                 
            	}
                 
            
            }
      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}
            
            ArrayList<String> deletedNotificationsIds= fetchDeletedNotifications(id);
            Collections.sort(deletedNotificationsIds);
        	
         outer: for(int j = 0; j < notifications.size(); j++)
            {
     		
            	if(deletedNotificationsIds.isEmpty()){ break outer;}
            	
            	else{
            	
            		 int index = Collections.binarySearch(deletedNotificationsIds,notifications.get(j).getNotification_id());
            				
            	
                 	if(index>=0){
             
                 	
                 		 notifications.remove(j);
                 	
                 		deletedNotificationsIds.remove(index); 
                 		 j=-1;
                 	}
                 	
                 	
            	}
            	
            	
            }   
            
            
      
          
           
          //   return  new ArrayList<Notification>(resultList); 
            return notifications;

}
	

	
	
	

	public ArrayList<AlreadyMember> fetchSubscribedClassesDetails(String user_id){
		
 
 ArrayList<AlreadyMember> alreadymemberList=new ArrayList<AlreadyMember>();
            try {
                      
                            
									 ps = con.prepareStatement("SELECT  * FROM  classroom_details WHERE class_id IN (SELECT class_id FROM subscriber_table WHERE user_id=?)");
              ps.setString(1, user_id );
                 ResultSet rs = ps.executeQuery();
                 while(rs.next()){	
                	 AlreadyMember alreadymember=new AlreadyMember(rs.getString(1),rs.getString(6),rs.getInt(4)+"");
                	 alreadymemberList.add(alreadymember);
             
               }
                      }

      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}

             return alreadymemberList;

}
	
	
	
	
	
	

	public ArrayList<String> fetchDeletedNotifications(String id){
		
		ArrayList<String> deletedNotificationsIds=new ArrayList<String> ();
		
		
 
            try {
            	 ResultSet rs;    
            	
									 ps = con.prepareStatement("SELECT  notification_id FROM delete_notification WHERE user_id=? ORDER BY notification_id DESC");
              ps.setString(1, id );
                rs = ps.executeQuery();
                 while(rs.next()){	
                	
                	 deletedNotificationsIds.add(rs.getString(1));
              
                 
                 
                    }              
                 
            	
                 
            
            }
      catch (SQLException e) {
          e.printStackTrace();
           }finally{

}
            

             return deletedNotificationsIds;

}

	
	
	
	
	public Timestamp fetchUserTime(String id){
		Timestamp time = null;
try {

ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
ps.setString(1, id );
ResultSet rs = ps.executeQuery();
while(rs.next()){	


time=rs.getTimestamp(5);
}



}

catch (SQLException e) {
e.printStackTrace();
}finally{

}

return time;

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
