package fetch.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.Elearning.java.DbConnection;

public class Fetch_List {

	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	int i;
	
	public ArrayList<String> FetchSubscriberList(String classId){
		
		ArrayList<String> SubscriberList=new ArrayList<String>();
		
		            try {
		                     
		                          ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE class_id=?");
		                         ps.setString(1, classId);
		                        ResultSet rs = ps.executeQuery();
		                       while(rs.next()){
		                    	   SubscriberList.add(rs.getString(1));
		                   		
		                       }
		                      }

		      catch (SQLException e) {
		          e.printStackTrace();
		           }finally{

		}

		             return  SubscriberList;
	
		
	}
	
	
public ArrayList<String> FetchMemberList(String classId){
	ArrayList<String> SubscriberList=new ArrayList<String>();
	 
	            try {
	                      
	                         ps = con.prepareStatement("SELECT * FROM membership_table WHERE class_id=?");
	                         ps.setString(1, classId);
	                        ResultSet rs = ps.executeQuery();
	                       while(rs.next()){
	                    	   SubscriberList.add(rs.getString(1));
	                   		
	                       }
	                      }

	      catch (SQLException e) {
	          e.printStackTrace();
	           }finally{

	}

	             return  SubscriberList;

		
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
