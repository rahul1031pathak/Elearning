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

import fetch.classroom.Fetch_CLass_Content;
import manage.user.Verifier;



/**
 * Servlet implementation class Answer_Fetcher_For_Andriod
 */
@WebServlet("/Answer_Fetcher_For_Andriod")
public class Answer_Fetcher_For_Andriod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!request.getParameter("quesId").isEmpty()&&request.getSession(false)!= null&&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
//System.out.println(request.getParameter("quesId").length());
			
			String classid;
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("ISLOGIN", "true");
				doc.put("quesId",request.getParameter("quesId"));

				
				if(request.getParameter("ClassId").isEmpty()){
					Fetch_CLass_Content class_content=new Fetch_CLass_Content();
					classid=class_content.fetchClassNameWithQuesId( request.getParameter("quesId"));
				}
				
				else{
					classid=request.getParameter("ClassId");
				}
				
			Verifier verifier=new Verifier();
		String classAdminFromVerifier=	verifier.FetchClassAdmin(classid);
		
		verifier.connClose();
			
		doc.put("ClassId",classid);
	
			
		if(classAdminFromVerifier.equals((String) request.getSession(false).getAttribute("USERID")) ){
			
			doc.put("is_admin", "true");

	         } 
		
		else{
	
			request.setAttribute("is_admin", "false");
			doc.put("is_admin", "false");
		}
		doc.put("b", "true");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
			}
	  
			
			
			
			else	if(  request.getParameter("quesId")!=null&&request.getSession(false)== null){
				
				String classid;
				if(request.getParameter("ClassId").isEmpty()){
					Fetch_CLass_Content class_content=new Fetch_CLass_Content();
					classid=class_content.fetchClassNameWithQuesId( request.getParameter("quesId"));
				}
				
				else{
					classid=request.getParameter("ClassId");
				}
				
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "true");
				doc.put("ClassId", classid);
	
				doc.put("ISLOGIN", "false");
				doc.put("USERID", null);
				doc.put("quesId",request.getParameter("quesId"));

	
			
		
		
		doc.put("is_admin", "false");
		response.setContentType("application/json"); 
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

}
