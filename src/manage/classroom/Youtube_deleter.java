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
 * Servlet implementation class Youtube_deleter
 */
@WebServlet("/Youtube_deleter")
public class Youtube_deleter extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
		
			Validation validation=new Validation();
			
			boolean can_delete=	validation.Can_Delete_YoutubeVideo((String)request.getSession(false).getAttribute("USERID"),request.getParameter("videoId"));
			validation.connClose();
			System.out.println((String)request.getSession(false).getAttribute("USERID")+"/"+request.getParameter("videoId")+"/"+can_delete);
			if(can_delete){
			
			DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		 try {
				
			 ps = con.prepareStatement("DELETE  FROM shared_videos WHERE id=?");
				
				ps.setString(1, request.getParameter("videoId"));
				 ps.executeUpdate();
				 } 
			 
			 
		 catch (SQLException e) {
				e.printStackTrace();
			} 
		
		 finally{ }
		
		 
		 try {
	    	  ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("b", "true");
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
	}// can delete
		
			 
			else{		 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "false");
				doc.put("error message", "either not login or you have not permission for this operation");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));	
			}	
		}//login check
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
