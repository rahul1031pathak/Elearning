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



/**
 * Servlet implementation class Fetch_Class_Details
 */
@WebServlet("/Fetch_Class_Details")
public class Fetch_Class_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
		ArrayList<String> classPrivacy=new ArrayList<String>();
		classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
		

			doc.put("CLASSNAME",classPrivacy.get(3));
			doc.put("CLASSADMINNAME", classPrivacy.get(4));
			doc.put("CLASSADMINID", classPrivacy.get(5));
			doc.put("DISCRIPTION", classPrivacy.get(8));
			doc.put("number_of_members", classPrivacy.get(6));
			doc.put("number_of_subscribers", classPrivacy.get(7));
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		
		
	}


}
