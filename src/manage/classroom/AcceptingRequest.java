package manage.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class AcceptingRequest {
	
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	int i=0;
	 PreparedStatement ps;
	public int addingToMemberTable(String user_id ,String class_id){
		try {
			
		
			  ps = con.prepareStatement("INSERT INTO membership_table (user_id,class_id) VALUES (?,?) ");
			 ps.setString(1, user_id );
			 ps.setString(2, class_id );
			 i=ps.executeUpdate();
			 if(i==1){
				 
				 ps=con.prepareStatement("SELECT * FROM subscriber_table WHERE user_id=? AND class_id=?");
				 ps.setString(1, user_id );
				 ps.setString(2, class_id );
				 ResultSet rs=  ps.executeQuery();
				 if(rs.next()){
					 ps = con.prepareStatement("DELETE FROM subscriber_table WHERE user_id=? AND class_id=?");
					 ps.setString(1, user_id );
					 ps.setString(2, class_id );
					 ps.executeUpdate();
					 i=0;
					 
				 }
				 
				 
					
				 
			 }
				 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	
		return i;
		
	}
	
	
	public void deletingTheReq(String id ){
	
	
	
		try {
	
			 PreparedStatement ps = con.prepareStatement("DELETE FROM membership_req WHERE Member_req_id=?");
			 ps.setString(1, id );
			 ps.executeUpdate();				 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	
	}
	
	
	public void IncreaseNumberOfMember(String id ){
		
		
		
		try {
			
			 PreparedStatement ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
			 ps.setString(1, id );
			 ResultSet  rs=  ps.executeQuery();
			 
			 while(rs.next()){
				int countMember= rs.getInt(10);
				countMember++;
				
				
				 ps = con.prepareStatement(" UPDATE  classroom_details SET number_of_members= ? WHERE class_id = ?");
				 ps.setInt(1, countMember);
				 ps.setString(2, id);
				 ps.executeUpdate();
				
			 }
			 
							 

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
