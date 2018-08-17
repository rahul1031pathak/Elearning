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
 * Servlet implementation class Delete_Saved_Items
 */
@WebServlet({"/Delete_Saved_Items","/Elearning/Delete_Saved_Items"})
public class Delete_Saved_Items extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if( request.getSession(false)!=null&&request.getParameter("flag")!=null){
if(request.getParameter("flag").equals("article")){
	
		 Delete_Saved_Item deleteSavedItems= new  Delete_Saved_Item();
		 deleteSavedItems.deleteSavedArticle(request.getParameter("articleId"),(String)request.getSession(false).getAttribute("USERID"));
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("b", "true");
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));	 
}



if(request.getParameter("flag").equals("notification")){
	
		 Delete_Saved_Item deleteSavedItems= new  Delete_Saved_Item();
		 deleteSavedItems.deleteSavedNotifications(request.getParameter("NotificationId"),(String)request.getSession(false).getAttribute("USERID"));
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("b", "true");
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));	 
}


if(request.getParameter("flag").equals("question")){
	
	 Delete_Saved_Item deleteSavedItems= new  Delete_Saved_Item();
	 deleteSavedItems.deleteSavedQuestions (request.getParameter("ques_Id"),(String)request.getSession(false).getAttribute("USERID"));
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "true");
		
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));	 
}




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

}
