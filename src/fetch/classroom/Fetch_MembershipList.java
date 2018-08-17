package fetch.classroom;

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
 * Servlet implementation class Fetch_MembershipList
 */
@WebServlet("/Fetch_MembershipList")
public class Fetch_MembershipList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getParameter("ClassId")!=null){
			Fetch_CLass_Content fetch=new Fetch_CLass_Content();
		
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(fetch.fetch_Memberships(request.getParameter("ClassId")));
		
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
