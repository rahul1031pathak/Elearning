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

import manage.user.Fetch_saved_items;


/**
 * Servlet implementation class Fetch_Saved_questions
 */
@WebServlet("/Fetch_Saved_questions")
public class Fetch_Saved_questions extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getSession(false).getAttribute("USERID")!=null){

			 Fetch_saved_items fetch=new  Fetch_saved_items();
				response.setContentType("application/json"); 
				   response.setCharacterEncoding("UTF-8");
				
				   response.getWriter().write(fetch.Fetch_saved_questions((String) request.getSession(false).getAttribute("USERID")));
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
