package manage.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import structure.user.UserHomeDemo;


/**    
 * Servlet implementation class Fetch_HomePageDetails
 */
@WebServlet("/Fetch_HomePageDetails")
public class Fetch_HomePageDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if( request.getSession(false)!=null  ){

		UserHomeDemo userHomeDemo =new UserHomeDemo();
		Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
		userHomeDemo.createdClassroomList=userdetails.fetchUserAsAdminClassRoomList((String) request.getSession(false).getAttribute("USERID"));
		
		    
		userHomeDemo.alreadyMember=userdetails.fetchClassesDetailsAlreadyMember((String) request.getSession(false).getAttribute("USERID"));
		userHomeDemo.subscribed=userdetails.fetchSubscribedClassesDetails((String) request.getSession(false).getAttribute("USERID"));
		userHomeDemo.user=userdetails.fetchUserDetails((String) request.getSession(false).getAttribute("USERID"));
		
		       
		 userdetails.connClose();
			Gson gson=new Gson();
		response.setContentType("application/json"); 
		   response.setCharacterEncoding("UTF-8");
		  
			response.getWriter().write(gson.toJson(userHomeDemo));
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
