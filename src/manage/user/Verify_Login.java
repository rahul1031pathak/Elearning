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

/**
 * Servlet implementation class Verify_Login
 */
@WebServlet("/Verify_Login")
public class Verify_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
		if(request.getSession(false)!=null){
			doc.put("b", "true");
			
			   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		        response.setDateHeader("Expires", 0); // Proxies. 
		        
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
		}
		else{
	doc.put("b", "false");

	   response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
       response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
       response.setDateHeader("Expires", 0); // Proxies. 
	
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
		}
		
		
	}




}
