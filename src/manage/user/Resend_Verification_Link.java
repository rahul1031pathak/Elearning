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

import in.Elearning.java.EncoderDecoder;


/**
 * Servlet implementation class Resend_Verification_Link
 */
@WebServlet("/Resend_Verification_Link")
public class Resend_Verification_Link extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
		 try {
				String encrypted =EncoderDecoder.encrypt(request.getParameter("email"));
				String subject= "This is verification email from studyfromweb";
				String BODY = "<H1>"+" <a href="+"https://www.studyfromweb.com/EmailVerifier?q="+encrypted +">Activate Account</a>"+"</H1>";
				BODY=BODY+"<img src=\"https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/verification_email.gif\" height=\"60%\" width=\"80%\">";
				SendVerificationEmail sendVerificationEmail=new SendVerificationEmail(request.getParameter("email"), BODY,subject);
				sendVerificationEmail.sendMail();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					doc.put("b", "false");
					
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
				}
	
			doc.put("b", "true");
		
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
	}

	
}
