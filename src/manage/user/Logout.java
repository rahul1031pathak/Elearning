package manage.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
             
/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")      
public class Logout extends HttpServlet {    
	private static final long serialVersionUID = 1L;
                  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false)!=null){
			HttpSession session=request.getSession(false);
			
			session.invalidate(); 
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "true");
				response.setContentType("application/json"); 
				response.setHeader("Cache-Control", "private,no-store,no-cache");
			   response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}
	
		else{
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "false");
				response.setContentType("application/json"); 
			   response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
