package routing;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.baswell.routes.Route;
import org.baswell.routes.Routes;
     

@Routes(value="/question",forwardPath="/")
public class question_route {
     
		 @Route(value="/{}/{}")
		  public    void getClassWithGivenId(String quesid,String ques_content,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
		  {
		  
		String url="/AnswerFetcher?"+"quesId="+quesid+"&ClassId=&"+"ques_cont="+ques_content;
		RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
		dispatcher.forward(request,response);  
		  
		
		         
		   
}
}