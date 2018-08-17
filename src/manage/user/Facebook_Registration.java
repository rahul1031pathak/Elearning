package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import in.Elearning.java.DbConnection;
import structure.user.User;


/**
 * Servlet implementation class Facebook_Registration
 */
@WebServlet("/Facebook_Registration")
public class Facebook_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		int i;
		boolean b;
		String profilepic="https:"+"/"+"/"+"graph.facebook.com"+"/"+request.getParameter("facebookId")+"/"+"picture"+"?type=large";
		 long id=0;
		 Dao_User_Registration registeration=new Dao_User_Registration();
		b=registeration.verifyUserIsUnique(request.getParameter("email"));
		registeration.connClose();
		
		if(b){
		
		 try {
				
				 ps = con.prepareStatement("INSERT INTO user_details (fullname,email,password,profilepic,proof,verify) VALUES(?,?,?,?,?,?)"); 
				 ps.setString(1, request.getParameter("name"));
				 ps.setString(2, request.getParameter("email"));
				 ps.setString(3, "");
				 ps.setString(4, profilepic);
				
				 ps.setString(5, "https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/profile-placeholder.gif");
				 ps.setInt(6,1);
				  i=ps.executeUpdate();
				  if(i==1){
		 //if user has registered successfully then we have to create session and fetch his class details just as in login process
					  
					  
					  ps=con.prepareStatement("SELECT LAST_INSERT_ID()"); 
						ResultSet rs=ps.executeQuery();
							if(rs.next()){
								id= rs.getLong(1);
					  
					  
							}
					  
							else{
								 Map<String, String> doc=new HashMap<String, String>();
									Gson gson=new Gson();
									doc.put("b", "false");
									doc.put("error message", "user have no permission");
									response.setContentType("application/json"); 
								    response.setCharacterEncoding("UTF-8");
									response.getWriter().write(gson.toJson(doc));
							}
							
							
							
							
		 ps = con.prepareStatement("INSERT INTO facebook (facebook_id,user_id) VALUES(?,?)");	  
					  
		 ps.setString(1, request.getParameter("facebookId"));
		 ps.setLong(2, id);
			int j=ps.executeUpdate();	  
			
					if(j==1){  
					  
					  
					  
					  
					  
					  HttpSession session=null;
					  User user=null;
					  
					  Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
					 
						user=userdetails.fetchUserDetails(String.valueOf(id)); //here we fetch all the user details
					//	String userid=user.getUserId()+"";
						session=request.getSession(true);      // Create a session object if it is already not  created.
						
						 
						
						
							session.setAttribute("USERID",String.valueOf(id));  //till here working fine
							session.setMaxInactiveInterval(-1); 
				
							  //till here working fine
							session.setAttribute("FACEBOOKUSERID", "true"); 
						//	request.setAttribute("institute",user.getInstitution());
						//	request.setAttribute("number_of_followers",user.getNumberOfFollowers());
				             session.setAttribute("ISLOGIN", "true"); 
						
					
					  
			             userdetails.connClose();
			             Map<String, String> doc=new HashMap<String, String>();
							Gson gson=new Gson();
							doc.put("b", "true");
							doc.put("error message", "user have no permission");
							response.setContentType("application/json"); 
						    response.setCharacterEncoding("UTF-8");
							response.getWriter().write(gson.toJson(doc));
				  }
				
					
					
					else{
						
						
						
						String userid=registeration.getUserId(request.getParameter("email"));
						
						
						if(userid.equals("")||userid.equals(null)){
							  Map<String, String> doc=new HashMap<String, String>();
								Gson gson=new Gson();
								doc.put("b", "true");
								doc.put("error message", "something went wrong");
								response.setContentType("application/json"); 
							    response.setCharacterEncoding("UTF-8");
								response.getWriter().write(gson.toJson(doc));
						}
						
						
						
						else{
				
				             Map<String, String> doc=new HashMap<String, String>();
								Gson gson=new Gson();
								doc.put("b", "false");
								doc.put("error message", "user already exits");
								response.setContentType("application/json"); 
							    response.setCharacterEncoding("UTF-8");
								response.getWriter().write(gson.toJson(doc));
						
						
						}
						
					}
					
					
					
			} 
		 }
			 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		}
		
		else{
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "false");
				doc.put("error message", "user have no permission");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}
		
		 try {
			 ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}


