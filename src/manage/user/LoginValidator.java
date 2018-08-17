package manage.user;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import structure.user.User;
  

/**                         
 * Servlet implementation class LoginValidator
 */
@WebServlet("/LoginValidator")
public class LoginValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=null;
		String userName=request.getParameter("loginemail");						//Loading user inputs into variables.
		String password=request.getParameter("loginpassword");
		User user=null;
		
		Dao_Login_Validator lv=new Dao_Login_Validator();
		int flag=lv.loginValidator(userName,password);
		
		if(flag==2){
			   Map<String, String> doc=new HashMap<String, String>();
	 			Gson gson=new Gson();
	 			doc.put("b", "verify");
	 			doc.put("username", request.getParameter("loginemail"));
	 			response.setContentType("application/json"); 
	 		   response.setCharacterEncoding("UTF-8");
	 			response.getWriter().write(gson.toJson(doc));
			
			   
		}
		if (flag==1){    
			//validation true
			

Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 

			user=userdetails.fetchUserDetails(userName, password);//here we fetch all the user details
			String userid=user.getUserId()+"";
			session=request.getSession(true); // Create a session object if it is already not  created.
			//session.setMaxInactiveInterval(-1); 
	
			
			   Map<String, String> doc=new HashMap<String, String>();
		
			session.setAttribute("USERID",userid);  //till here working fine
			session.setAttribute("FACEBOOKUSERID", "false"); 
	
             session.setAttribute("ISLOGIN", "true"); 
             userdetails.connClose();
          
 			Gson gson=new Gson();  
 			doc.put("b", "true");
 			doc.put("username", request.getParameter("loginemail"));
 			response.setContentType("application/json"); 
 		   response.setCharacterEncoding("UTF-8");
 			response.getWriter().write(gson.toJson(doc));
             
		}
		else if(flag==0){
			//session=request.getSession(false); // Create a session object if it is already not  created.
			   Map<String, String> doc=new HashMap<String, String>();
	 			Gson gson=new Gson();
	 			doc.put("b", "false");
	 			doc.put("username", request.getParameter("loginemail"));
	 			response.setContentType("application/json"); 
	 		   response.setCharacterEncoding("UTF-8");
	 			response.getWriter().write(gson.toJson(doc));
	             
			
		}
		
		
		
		
	}

}
