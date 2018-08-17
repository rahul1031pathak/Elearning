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

import in.Elearning.java.Counting;
import in.Elearning.java.DbConnection;

/**
 * Servlet implementation class Delete_User_From_Class
 */
@WebServlet("/Delete_User_From_Class")
public class Delete_User_From_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&&request.getSession(false).getAttribute("ISCLASSADMIN").equals("true")){
			
			
			if(request.getParameter("flag").equals("membership")){
			
			DbConnection dbc=new DbConnection(); 
			  Connection con =dbc.getMysqlConnection();
			  PreparedStatement ps=null;
			try {
				ps = con.prepareStatement("DELETE FROM membership_table WHERE class_id=? AND user_id=?");
					ps.setString(1, request.getParameter("ClassId"));
					ps.setString(2, request.getParameter("user_id"));
				        ps.executeUpdate();	

						 Counting counting=new Counting();
					       String user_id= counting.DecreaseNumberOfMember( request.getParameter("ClassId"));
  counting.IncreaseNumberOfFollowers(user_id);
						counting.connClose();
					
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
			
			
			}
			
			
			
			
			
			
			if(request.getParameter("flag").equals("subscriber")){
			
			DbConnection dbc=new DbConnection(); 
			  Connection con =dbc.getMysqlConnection();
			  PreparedStatement ps=null;
			try {
				ps = con.prepareStatement("DELETE FROM subscriber_table WHERE class_id=? AND user_id=?");
					ps.setString(1, (String)request.getSession(false).getAttribute("CLASSID"));
					ps.setString(2, request.getParameter("user_id"));
				        ps.executeUpdate();	
				        
				        
				   	 Counting counting=new Counting();
				       String user_id= counting.DecreaseNumberOfSubscriber( request.getParameter("ClassId"));
counting.IncreaseNumberOfFollowers(user_id);
					counting.connClose();
				        
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
			
			
			}	
			
			 String b="true";
				
				Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", b);
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
			
			
			
			
			
			
		}
		
		else{
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
