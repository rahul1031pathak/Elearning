package in.Elearning.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Counting {
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	
	  PreparedStatement ps;
	
	public String IncreaseNumberOfMember(String id){
		String user_id="";

		try {
			
			ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
			 ps.setString(1, id );
			 ResultSet  rs=  ps.executeQuery();
			 
			 while(rs.next()){
				int countMember= rs.getInt(10);
				int countFollowers=rs.getInt(12);
				user_id=rs.getString(2).trim();
				countMember++;
				countFollowers++;
				
				 ps = con.prepareStatement(" UPDATE  classroom_details SET number_of_members= ? ,followers= ? WHERE class_id = ?");
				 ps.setInt(1, countMember);
				 ps.setInt(2, countFollowers);
				 ps.setString(3, id);
				 ps.executeUpdate();
				
			 }
			 
							 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	return user_id;
	}
	
	
	
	
public String DecreaseNumberOfMember(String id){
	String user_id="";

		try {
			
			 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
			 ps.setString(1, id );
			 ResultSet  rs=  ps.executeQuery();
			 
			 while(rs.next()){
				int countMember= rs.getInt(10);
				int countFollowers=rs.getInt(12);
				user_id=rs.getString(2);
				countMember--;
				countFollowers--;
				
				 ps = con.prepareStatement(" UPDATE  classroom_details SET number_of_members= ?, followers= ? WHERE class_id = ?");
				 ps.setInt(1, countMember);
				 ps.setInt(2, countFollowers);
				 ps.setString(3, id);
				 ps.executeUpdate();
				
			 }
			 
							 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return user_id;
	}
	
	
	
	
	
	
public String IncreaseNumberOfSubscriber(String id){
	String user_id="";

		try {
			
			 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
			 ps.setString(1, id );
			 ResultSet  rs=  ps.executeQuery();
			 
			 while(rs.next()){
				int countSubscriber= rs.getInt(11);
				int countFollowers=rs.getInt(12);
				user_id=rs.getString(2);
				 countSubscriber++;
				 countFollowers++;
				
				 ps = con.prepareStatement(" UPDATE  classroom_details SET number_of_subscribers= ? , followers= ? WHERE class_id = ?");
				 ps.setInt(1, countSubscriber);
				 ps.setInt(2, countFollowers);
				 ps.setString(3, id);
				 ps.executeUpdate();
				
			 }
			 
							 

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return user_id;
	}

	
public String DecreaseNumberOfSubscriber(String id){
	
	String user_id="";
	try {
		
		 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int countSubscriber= rs.getInt(11);
			int countFollowers=rs.getInt(12);
			user_id=rs.getString(2);
			 countSubscriber--;
			 countFollowers--;
			
			 ps = con.prepareStatement(" UPDATE  classroom_details SET number_of_subscribers= ? , followers= ? WHERE class_id = ?");
			 ps.setInt(1, countSubscriber);
			 ps.setInt(2, countFollowers);
			 ps.setString(3, id);
			 ps.executeUpdate();
			
		 }
		 
						 

}
 
 catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
	}
	return user_id;
}


public void DecreaseNumberOfFollowers(String id){
	

	try {
	
		 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int countfollowers= rs.getInt(14);
			countfollowers--;
			
			
			 ps = con.prepareStatement(" UPDATE  user_details SET followers= ? WHERE user_id= ?");
			 ps.setInt(1, countfollowers);
			 ps.setString(2, id);
			 ps.executeUpdate();
			
		 }
		 
						 

}
 
 catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
	}

}
	
	
	
public void DecreaseNumberOfFollowers(String id,int count){
	

	try {
	
		 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int countfollowers= rs.getInt(14);
			countfollowers=countfollowers-count;
			
			
			 ps = con.prepareStatement(" UPDATE  user_details SET followers= ? WHERE user_id= ?");
			 ps.setInt(1, countfollowers);
			 ps.setString(2, id);
			 ps.executeUpdate();
			
		 }
		 
						 

}
 
 catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
	}

}



public void IncreaseNumberOfFollowers(String id){
	

	try {
		
		 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int countfollowers= rs.getInt(14);
			countfollowers++;
			
			
			 ps = con.prepareStatement(" UPDATE  user_details SET followers= ? WHERE user_id= ?");
			 ps.setInt(1, countfollowers);
			 ps.setString(2, id);
			 ps.executeUpdate();
			
		 }
		 
						 

}
 
 catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
	}

}






public void IncreaseClassCount(String id){
	

	try {
		
		 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int ClassCount= rs.getInt(15);
			ClassCount++;
			
			
			 ps = con.prepareStatement(" UPDATE  user_details SET classCount= ? WHERE user_id= ?");
			 ps.setInt(1, ClassCount);
			 ps.setString(2, id);
			 ps.executeUpdate();
			
		 }
		 
						 

}
 
 catch (SQLException e) {
		e.printStackTrace();
	}finally{
		
	}

}




public void DecreaseClassCount(String id){
	

	try {
	
		 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
		 ps.setString(1, id );
		 ResultSet  rs=  ps.executeQuery();
		 
		 while(rs.next()){
			int ClassCount= rs.getInt(15);
			ClassCount--;
			
			
			 ps = con.prepareStatement(" UPDATE  user_details SET classCount= ? WHERE user_id= ?");
			 ps.setInt(1, ClassCount);
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
   	  ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}	
	
	
	

}
