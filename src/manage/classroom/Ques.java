package manage.classroom;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.user.Verifier;

/**
 * Servlet implementation class Ques
 */
@WebServlet("/Ques")
public class Ques extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(  request.getParameter("quesId")!=null){

			 
request.setAttribute("ClassId", request.getParameter("ClassId"));
	HttpSession session=null;
session=request.getSession(true);
session.setAttribute("ISLOGIN", "false");
session.setAttribute("USERID", null);
		request.setAttribute("quesId",request.getParameter("quesId"));
         
		Verifier verifier=new Verifier();
	
	
	verifier.connClose();
		
	request.setAttribute("ClassId",request.getParameter("ClassId"));
	
		request.setAttribute("is_admin", "false");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("answerNotAdmin.jsp");
			dispatcher.forward(request,response);
	
	
		}
 
		else{
			 RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request,response);
		}
	 
   
	
	}

}
