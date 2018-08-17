package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Delete_Saved_Item {

	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	  
	  
	  public void deleteSavedArticle(String id,String user_id){
		  try {
	           
	             
	           
				ps = con.prepareStatement("DELETE FROM saved_article WHERE user_id=? AND article_id=?");
				ps.setString(1, user_id );
				ps.setString(2, id);
			        ps.executeUpdate();


			        connClose();


}

catch (SQLException e) {
e.printStackTrace();
}finally{
}
		  
	  }
	  
	  
	  
	  
	  public void deleteSavedNotifications(String id,String user_id){
		  try {
	           
	             
	           
				ps = con.prepareStatement("DELETE FROM saved_notifications WHERE user_id=? AND notifications_id=?");
				ps.setString(1, user_id );
				ps.setString(2, id);
			        ps.executeUpdate();

			        connClose();



}

catch (SQLException e) {
e.printStackTrace();
}finally{
}
		  
	  }
	  
	  
	  public void deleteSavedQuestions(String id,String user_id){
		  try {
	           
	             
	           
				ps = con.prepareStatement("DELETE FROM saved_questions WHERE user_id=? AND question_id=?");
				ps.setString(1, user_id );
				ps.setString(2, id);
			        ps.executeUpdate();

			        connClose();



}

catch (SQLException e) {
e.printStackTrace();
}finally{
}
		  
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
