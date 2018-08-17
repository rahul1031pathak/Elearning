package manage.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import manage.user.Validation;



/**
 * Servlet implementation class Question_Deleter
 */
@WebServlet("/Question_Deleter")
public class Question_Deleter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	
				if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true") &&request.getParameter("quesId")!=null){
	 
					
					Validation validation=new Validation();
					
					boolean can_delete=	validation.Can_Delete_Question((String)request.getSession(false).getAttribute("USERID"),request.getParameter("quesId"));
					validation.connClose();
					
					if(can_delete){
					
					
					 DbConnection dbc=new DbConnection(); 
					  Connection con =dbc.getMysqlConnection();
					    PreparedStatement ps=null;
					    
				 try {
					 con.setAutoCommit(false);
					   ps = con.prepareStatement("DELETE FROM notification WHERE notification_type=? AND content_id=?");
				        ps.setString(1,"Question");
				        ps.setString(2, request.getParameter("quesId"));
				        ps.executeUpdate();
		             
								ps = con.prepareStatement("DELETE FROM questioninwritten WHERE ques_id=?");
								ps.setString(1, request.getParameter("quesId"));
								
							        ps.executeUpdate();
							        
							        ps = con.prepareStatement("DELETE FROM answerintext WHERE ques_id=?");
							        ps.setString(1, request.getParameter("quesId"));
							        ps.executeUpdate();
							        
							        ps = con.prepareStatement("DELETE FROM saved_questions WHERE question_id=?");
							        ps.setString(1, request.getParameter("quesId"));
							        ps.executeUpdate();
							   
							        
							        con.commit();
							 		  con.setAutoCommit(true); 
							        
							        
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "true");
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));


		}

		catch (SQLException e) {
		e.printStackTrace();
		}finally{

		}
				
				 try {
					 
					 
					 if(ps!=null){  ps.close();
						}
					 
					 if(con!=null){
						 con.close();
					 }
			    	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
					
					
				
					
					} // can_delete  check if
					
					
					
					else{
						
						 Map<String, String> doc=new HashMap<String, String>();
							Gson gson=new Gson();
							doc.put("b", "false");
							doc.put("error message", "either not login or you have not permission for this operation");
							response.setContentType("application/json"); 
						    response.setCharacterEncoding("UTF-8");
							response.getWriter().write(gson.toJson(doc));
						
					}
				 
				 
				 
				 
				 
				 
	
				}	// checking login
		
		
				
				
				
				
				
				
				
				else
				 {
					 Map<String, String> doc=new HashMap<String, String>();
						Gson gson=new Gson();
						doc.put("b", "false");
						doc.put("error message", "either not login or you have not permission for this operation");
						response.setContentType("application/json"); 
					    response.setCharacterEncoding("UTF-8");
						response.getWriter().write(gson.toJson(doc));
				 }
		
		
		
		
		
		
		
		
	}

}
