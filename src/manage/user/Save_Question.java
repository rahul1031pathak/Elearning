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
 * Servlet implementation class Save_Question
 */
@WebServlet("/Save_Question")
public class Save_Question extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getSession(false).getAttribute("USERID")!=null&& request.getParameter("quesId")!=null){

			
			Save_Bookmark save=new Save_Bookmark();
			save.save_Question((String) request.getSession(false).getAttribute("USERID"),request.getParameter("quesId"));
			 String b="true";
				
				Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", b);
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
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
