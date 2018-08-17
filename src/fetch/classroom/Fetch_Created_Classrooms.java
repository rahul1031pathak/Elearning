package fetch.classroom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import structure.user.User_Class_Details;



/**
 * Servlet implementation class Fetch_Created_Classrooms
 */
@WebServlet("/Fetch_Created_Classrooms")
public class Fetch_Created_Classrooms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){

			ArrayList<User_Class_Details > createdClassroomList=new ArrayList<User_Class_Details >();
			Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
			createdClassroomList=userdetails.fetchUserAsAdminClassRoomList((String) request.getSession(false).getAttribute("USERID"));
		
			 userdetails.connClose();
				Gson gson=new Gson();
				
			response.setContentType("application/json"); 
			   response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(createdClassroomList));
		
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
