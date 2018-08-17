package manage.classroom;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;

import fetch.classroom.Fetch_CLass_Content;
import manage.user.Verifier;


/**
 * Servlet implementation class AnswerFetcher
 */
@WebServlet("/AnswerFetcher")
public class AnswerFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!request.getParameter("quesId").isEmpty()&&request.getSession(false)!= null&&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
       
		String classid;
		request.setAttribute("quesId",request.getParameter("quesId"));
		Fetch_CLass_Content class_content=new Fetch_CLass_Content();
		if(request.getParameter("ClassId")!=null &&request.getParameter("ClassId").isEmpty()){
			
			classid=class_content.fetchClassNameWithQuesId( request.getParameter("quesId"));
		}
		
		else{  
			classid=request.getParameter("ClassId");
		}
		
	Verifier verifier=new Verifier();
String classAdminFromVerifier=	verifier.FetchClassAdmin(classid);

verifier.connClose();  

		      
	request.setAttribute("ClassId",classid);
		
	request.setAttribute("ques_content",Jsoup.parse(request.getParameter("ques_cont")).text());
	request.setAttribute("CLASSADMINNAME", request.getParameter("classAdminName"));
	request.setAttribute("CLASSNAME", request.getParameter("classname"));
	
	//String out=Normalizer.normalize(Jsoup.parse(request.getParameter("ques_cont")).text().toLowerCase(), Form.NFD)
	//        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	 //       .replaceAll("[^\\p{Alnum}]+", "-");
	//System.out.println( out );
	
//	System.out.println(   request.getParameter("classAdminName") );
	String is_subAdmin=class_content.is_subAdmin((String) request.getSession(false).getAttribute("USERID"), classid); 
	request.setAttribute("is_subAdmin", is_subAdmin);
	if(classAdminFromVerifier.equals((String) request.getSession(false).getAttribute("USERID")) ){
		request.setAttribute("is_admin", "true");
	   
         }  
	
	else{
		request.setAttribute("is_admin", "false");
		
	}
	//System.out.println(" getServletContext()"+ getServletContext()+" getServletContext()..."+ getServletContext().getRealPath("/answer.jsp"));       
	//System.out.println("11111"+getServletContext().getContextPath());
	//System.out.println("222"+getServletContext());
	RequestDispatcher dispatcher = request.getRequestDispatcher("/answer.jsp");    
		dispatcher.forward(request,response);
	
		}
  
		
		
		
		else	if(  request.getParameter("quesId")!=null &&request.getParameter("quesId").isEmpty()){

			Fetch_CLass_Content class_content=new Fetch_CLass_Content();
			
			// Map<String, String> doc=new HashMap<String, String>();
			 String classid=class_content.fetchClassNameWithQuesId( request.getParameter("quesId"));
			

	HttpSession session=null;
session=request.getSession(true);
session.setAttribute("ISLOGIN", "false");
session.setAttribute("USERID", null);
		request.setAttribute("quesId",request.getParameter("quesId"));

		Verifier verifier=new Verifier();
	
	
	verifier.connClose();
		
	request.setAttribute("ClassId",classid);
	request.setAttribute("ques_content",Jsoup.parse(request.getParameter("ques_cont")).text());
	request.setAttribute("CLASSADMINNAME", request.getParameter("classAdminName"));
	request.setAttribute("CLASSNAME", request.getParameter("classname"));
		request.setAttribute("is_admin", "false");
		request.setAttribute("is_subAdmin", "false");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("answer.jsp");  
			dispatcher.forward(request,response);
	
	
		}  
		
		
		
		else{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request,response);
		}
	 
   
	
	}
	
	

}
