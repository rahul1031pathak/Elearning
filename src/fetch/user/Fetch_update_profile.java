package fetch.user;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import structure.user.Update_user;


/**
 * Servlet implementation class Fetch_update_profile
 */
@WebServlet("/Fetch_update_profile")
public class Fetch_update_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	if(request.getSession(false)!=null){
		 Gson gson=new Gson();
		   Dao_Fetch_User_Details dao=new Dao_Fetch_User_Details();
	    Update_user user= dao.fetchUserDetails1( (String) request.getSession(false).getAttribute("USERID"));
		

	   
		response.setContentType("application/json"); 
		   response.setCharacterEncoding("UTF-8");
		
		   response.getWriter().write(gson.toJson(user));
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
