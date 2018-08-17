package manage.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Dao_Verify_Of_Unique_ClassName {
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	  PreparedStatement ps;
	public int VerifyUniqueClassName(String userid, String classname){
		int flag=0;											//flag default value 0
		String originalClassName=null;
		
		 try {
				
				 PreparedStatement ps = con.prepareStatement("SELECT  Classroom_Name FROM classroom_details WHERE Class_Admin=?");
				 ps.setString(1, userid );
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()){									//
					 originalClassName=rs.getString(1);
						if(classname.equals(originalClassName)){		//
							flag++;
						}
					}
				 
				 

	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		
		return flag;
	
}
	
	
	
	public String getIdOfClassroom(String userid, String classname){
												
		String classroomid=null;
		
		 try {
				
				  ps = con.prepareStatement("SELECT * FROM classroom_details WHERE Class_Admin=? AND Classroom_Name=?");
				 ps.setString(1, userid );
				 ps.setString(2, classname );
				 ResultSet rs = ps.executeQuery();
				 while(rs.next()){									//
					 classroomid=rs.getInt(4) +"";
						
					}
				 
				 

	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		
		return classroomid;
	
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
