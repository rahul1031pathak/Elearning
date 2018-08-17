package manage.classroom;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.opreation.Refrence_Manager_For_Adding;

/**
 * Servlet implementation class Refrence_Adder
 */
@WebServlet("/Refrence_Adder")
public class Refrence_Adder extends HttpServlet {
	private static final long serialVersionUID = 1L;
                   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	/*	Enumeration params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = (String)params.nextElement();
		 System.out.println("Parameter     Name - "+paramName+", Value - "+request.getParameter(paramName));
		}        */
		
		Refrence_Manager_For_Adding rm=new Refrence_Manager_For_Adding();
		
		String refrenceTO=request.getParameter("refrenceTO");
		String refrenceFrom=request.getParameter("refrenceFrom");
		

		if(refrenceFrom.equals("question")&&refrenceTO.equals("question")){
			rm.question_ref_question(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		} 
		
		else if(refrenceFrom.equals("question")&&refrenceTO.equals("article")){
			rm.question_ref_article(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		
		else if(refrenceFrom.equals("question")&&refrenceTO.equals("video")){
			rm.question_ref_video(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		
		
		
		
		
		if(refrenceFrom.equals("article")&&refrenceTO.equals("article")){
			rm.article_ref_article(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		else if(refrenceFrom.equals("article")&&refrenceTO.equals("video")){
			rm.video_ref_article(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		else if(refrenceFrom.equals("article")&&refrenceTO.equals("question")){
			rm.question_ref_article(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		
		
		if(refrenceFrom.equals("video")&&refrenceTO.equals("question")){
			rm.question_ref_video(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
		}
		else 
			if(refrenceFrom.equals("video")&&refrenceTO.equals("article")){
				rm.video_ref_article(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
			}
			else
				if(refrenceFrom.equals("video")&&refrenceTO.equals("video")){
					rm.video_ref_video(request.getParameter("refFromId"),request.getParameter("refToId") , request.getParameter("userName"), (String) request.getSession(false).getAttribute("USERID"),request.getParameter("class_id"));
				}
		
	}

}
