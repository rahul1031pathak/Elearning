package manage.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;
import structure.classroom.Notification;


public class Notification_Updater {
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	int j;
	
	public boolean updateNotification(String classid, Notification notification){
		
		 try {
				
				
				 ps = con.prepareStatement("INSERT INTO notification (notification_type,notification_content,class_id,generated_by,generated_by_name,generator_profile_pic,content_id) VALUES(?,?,?,?,?,?,?)");
				 ps.setString(1,  notification.getNotification_type());
				 ps.setString(2,  notification.getNotification_content());
				 ps.setString(3,  notification.getClass_id());
				 ps.setString(4,  notification.getGenerated_by());
			
				 ps.setString(5, notification.getGenerated_by_name());
				
				 ps.setString(6, notification.getGenerator_profile_pic() );
				 ps.setString(7, notification.getContent_id());
				 j=ps.executeUpdate();
				 
				
		 }	 
		 
				 catch (SQLException e) {
						e.printStackTrace();
					}
		 if(j==1){
			 return true;
		 }
		 else{
			 return false;
		 }
		 
	}
	
	
	
	public void connClose(){
		 try {

			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
