package manage.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Elearning.java.DbConnection;

public class Dao_Login_Validator {
	
	
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
		 PreparedStatement ps;
	public int loginValidator(String loginemail, String loginpassword){
		int flag=0;											//flag default value 0
		String originalPassword=null;
		
		  
		 try {  
			
			 ps = con.prepareStatement("SELECT  password ,verify FROM user_details WHERE email=?");
				 ps.setString(1, loginemail );
				 ResultSet rs = ps.executeQuery();
				 if(rs.next()){									//userID with the chosen privilege exists
						originalPassword=rs.getString(1);
						if(rs.getInt(2)==1){
						if(loginpassword.equals(originalPassword)){		//password matches
							flag=1;
						}else{
							flag=0;								//password mismatch
						}
						}
						
						else{
							flag=2;
						}  
					}
		    	  
				 

	}
		 
		 catch (SQLException e) {
				e.printStackTrace();
			}finally{
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
		
		return flag;
		
	}

}
