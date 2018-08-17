package fetch.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;

import structure.classroom.Notifications;


/**
 * Servlet implementation class Fetch_Notification
 */
@WebServlet("/Fetch_Notification")
public class Fetch_Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false)!=null){

		  Notifications notifications1=new Notifications();
	       
	        Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
	        Timestamp time= userdetails.fetchUserTime((String) request.getSession(false).getAttribute("USERID"));
	         notifications1.notifications=userdetails.fetchNotifications((String) request.getSession(false).getAttribute("USERID"),time);
	       
	         userdetails.connClose();
	         //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	         //String json = ow.writeValueAsString(notifications1);
	         Gson gson=new Gson();
	         Map<String, String> doc=new HashMap<String, String>();
				response.setContentType("application/json"); 
				doc.put("response code", "200");
				doc.put("message", "success");
				doc.put("data", gson.toJson(notifications1));
			  response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(notifications1));  
		}// end of login check
		 
		else{
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				Notifications notifications1=new Notifications();
				doc.put("response code", "403");
				doc.put("message", "either not login or you have not permission for this operation");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
			//	response.getWriter().write(gson.toJson(doc));
			    response.getWriter().write(gson.toJson(notifications1)); 
		}
	}

}
