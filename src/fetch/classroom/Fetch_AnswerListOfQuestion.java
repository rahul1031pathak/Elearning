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
 * Servlet implementation class Fetch_AnswerListOfQuestion
 */                  
@WebServlet("/Fetch_AnswerListOfQuestion")
public class Fetch_AnswerListOfQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getParameter("quesId")!=null){
		Answer_Fetcher af=new Answer_Fetcher(); 
		String answerList=af.FetchAnswer(request.getParameter("quesId"));
		// System.out.println(answerList);  working great
		af.connClose();
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(answerList);
	
	}// end of login check
	 
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
