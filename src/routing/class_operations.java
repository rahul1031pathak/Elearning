package routing;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.baswell.routes.Route;
import org.baswell.routes.Routes;

@Routes(value="/class",forwardPath="/") 
public class class_operations {
   
	        
	 @Route(value="/{}/{}/{}")
	  public    void getClassWithGivenId(String classid,String className,String teacherName,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	  {
	
	String url="/class?"+"id="+classid;
	RequestDispatcher dispatcher = request.getRequestDispatcher(url); 
	dispatcher.forward(request,response);  
	
	
	         
	  }       
	   
	    
	 
	
	 

}
 
              
        