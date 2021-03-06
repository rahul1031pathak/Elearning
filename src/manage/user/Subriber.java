package manage.user;

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
 * Servlet implementation class Subriber
 */
@WebServlet("/Subriber")
public class Subriber extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){

			Validation validation=new Validation();
			boolean check=	validation.Is_Subcribe_Request_Unique((String) request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));
			
			if(check){
				
			
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		try {
			
			
			 ps = con.prepareStatement("INSERT INTO subscriber_table (user_id,class_id) VALUES(?,?)");
			 ps.setString(1, (String) request.getSession(false).getAttribute("USERID"));
			 ps.setString(2,request.getParameter("ClassId"));
			

			int i=ps.executeUpdate();
			 if(i==1){
				 
				  Counting counting=new Counting();
			      String user_id=  counting.IncreaseNumberOfSubscriber(request.getParameter("ClassId") );
counting.IncreaseNumberOfFollowers(user_id);
				
counting.connClose();	
			String b="true";
				Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", b);
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
				
				
			 }
			 
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		
			}// Is_Subcribe_Request_Unique test
			else{
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "false");
					doc.put("error message", "either not login or you have not permission for this operation");
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
		}// end of login check
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
