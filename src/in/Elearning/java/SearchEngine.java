package in.Elearning.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import structure.classroom.ClassroomDetails;
import structure.classroom.FinalClassListFetchByUsingTeacherName;
import structure.user.UserSearch;

public class SearchEngine {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps ;
	public ArrayList<String> fetchTeacherClassIdListByInstitutionName(String name){
		
		ArrayList<String> idlist=new ArrayList<String>();

	 try {
			
			 ps = con.prepareStatement("SELECT  * FROM user_details WHERE institution like ? AND classCount >= 1 ORDER BY  followers DESC");
			 ps.setString(1,  "%" + name + "%" );
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){	
		idlist.add(rs.getInt(4)+"");
					
				}
			 
}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	 try {
	   	  ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return idlist;

}

	
	
	
	
	public ArrayList<UserSearch>  fetchUserDetailsByUserIdList( ArrayList<String> ids){
		//flag default value 0
			ArrayList<UserSearch> userlistSearch=new ArrayList<UserSearch>();
			 DbConnection dbc=new DbConnection(); 
			  Connection con =dbc.getMysqlConnection();
			  PreparedStatement ps=null ;

						//User user=null;
								try {
										
                          for(int i=0;i<ids.size();i++){
											 ps = con.prepareStatement("SELECT  * FROM user_details WHERE user_id=?");
                         ps.setString(1, ids.get(i) );
                            ResultSet rs = ps.executeQuery();
                            while(rs.next()){	
                            	UserSearch userSearch=new UserSearch(rs.getString(1),rs.getInt(4)+"",rs.getInt(14)+"",rs.getString(11),rs.getString(12),rs.getString(13));
                            	 userlistSearch.add(userSearch);
                            }
                          }


	}

	catch (SQLException e) {
					e.printStackTrace();
					}finally{

}
			return  userlistSearch;
			
}	
	
	
	
	
	
	
	

public ArrayList<FinalClassListFetchByUsingTeacherName> fetchClassDetailsByGivenIdsList(ArrayList<String> idlist){
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps=null ;
ArrayList<FinalClassListFetchByUsingTeacherName> classdetailsWithTeacherId=new ArrayList<FinalClassListFetchByUsingTeacherName>();
//FinalClassList finallist=new FinalClassList();

//fclfbutn.userlistSearch =fetchUserDetailsByUserIdList(idlist)  ;
	 try {
			
			for(int i=0; i<idlist.size();i++){
				FinalClassListFetchByUsingTeacherName fclfbutn=new FinalClassListFetchByUsingTeacherName();
				fclfbutn.teacher_id=idlist.get(i);
			
			 ps = con.prepareStatement("SELECT  * FROM classroom_details WHERE Class_Admin=?");
			 ps.setString(1, idlist.get(i) );
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){	
				 ClassroomDetails classroomdeatils = new ClassroomDetails(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4)+"",rs.getTimestamp(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)+"",rs.getInt(11)+"");
				 fclfbutn.classdetails.add(classroomdeatils);
	             }
			 
			 
			 classdetailsWithTeacherId.add(fclfbutn);
					
				}
			 
			
	 }
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	 
	
	return classdetailsWithTeacherId;

}



public ArrayList<UserSearch>  fetchUserDetailsByUserEmail(String email){
	
		ArrayList<UserSearch> userlistSearch=new ArrayList<UserSearch>();
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null ;

					//User user=null;
							try {
									
                     
										 ps = con.prepareStatement("SELECT  * FROM user_details WHERE email=?");
                     ps.setString(1, email);
                        ResultSet rs = ps.executeQuery();
                        while(rs.next()){	
                        	UserSearch userSearch=new UserSearch(rs.getString(1),rs.getInt(4)+"",rs.getInt(14)+"",rs.getString(11),rs.getString(12),rs.getString(13));
                        	 userlistSearch.add(userSearch);
                        }
                     


}

catch (SQLException e) {
				e.printStackTrace();
				}finally{

}
		return  userlistSearch;
		
}



public ArrayList<FinalClassListFetchByUsingTeacherName> fetchClassDetailsByEmail(String user_id){
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps=null ;
ArrayList<FinalClassListFetchByUsingTeacherName> classdetailsWithTeacherId=new ArrayList<FinalClassListFetchByUsingTeacherName>();

	 try {
			
			
				FinalClassListFetchByUsingTeacherName fclfbutn=new FinalClassListFetchByUsingTeacherName();
				
			
			 ps = con.prepareStatement("SELECT  * FROM classroom_details WHERE Class_Admin=?");
			 ps.setString(1, user_id );
			 ResultSet rs = ps.executeQuery();
			 while(rs.next()){	
				 ClassroomDetails classroomdeatils = new ClassroomDetails(rs.getString(1),rs.getString(2), rs.getString(3),rs.getInt(4)+"",rs.getTimestamp(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(10)+"",rs.getInt(11)+"");
				 fclfbutn.classdetails.add(classroomdeatils);
	             }
			 
			 
			 classdetailsWithTeacherId.add(fclfbutn);
					
				}
			 
			
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	 
	
	return classdetailsWithTeacherId;

}













public void connClose(){
	 try {
	   	 // ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
	

}
