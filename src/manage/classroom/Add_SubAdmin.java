package manage.classroom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import database.opreation.Manage_Admin_Of_Class;

/**
 * Servlet implementation class Add_SubAdmin
 */
@WebServlet("/Add_SubAdmin")
public class Add_SubAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
		Manage_Admin_Of_Class m=new Manage_Admin_Of_Class();
		
	if(	m.Add_Admin(  request.getParameter("class_id"), (String) request.getSession(false).getAttribute("USERID"), request.getParameter("subAdminEmail"))){
		doc.put("b", "true");
	}
	else{
		doc.put("b", "false");
	}
	response.setContentType("application/json"); 
    response.setCharacterEncoding("UTF-8");
	response.getWriter().write(gson.toJson(doc));
		
	}

}
