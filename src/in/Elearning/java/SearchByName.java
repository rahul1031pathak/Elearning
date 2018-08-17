package in.Elearning.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import structure.classroom.ClassroomDetails;
import structure.classroom.FinalClassListFetchByUsingTeacherName;

public class SearchByName {

	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps ;
	public ArrayList<String> fetchTeacherClassIdListByTeacherName(String name){
			ArrayList<String> idlist=new ArrayList<String>();

		 try {
				
				 ps = con.prepareStatement("SELECT  * FROM user_details WHERE fullname like ? AND classCount >= ? ORDER BY  followers DESC ");
				 ps.setString(1,  "%" + name + "%" );
				 ps.setInt(2,1 );
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()){	
			idlist.add(rs.getInt(4)+"");
						
					}
				 
	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		
		return idlist;  
	
}
	
	
	public ArrayList<FinalClassListFetchByUsingTeacherName> fetchClassDetailsByGivenIdsList(ArrayList<String> idlist){

	ArrayList<FinalClassListFetchByUsingTeacherName> classdetailsWithTeacherId=new ArrayList<FinalClassListFetchByUsingTeacherName>();
	//FinalClassList finallist=new FinalClassList();
	
	
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
