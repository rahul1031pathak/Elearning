package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;

/**
 * Servlet implementation class Password_Recovery
 */
@WebServlet("/Password_Recovery")
public class Password_Recovery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null; 
		  String password="";
		  String subject= "Password Recovery From Studyfromweb.com";
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
			
				
			
		try {
			  ps = con.prepareStatement("SELECT password FROM  user_details WHERE email=?"); 
				
				 ps.setString(1,request.getParameter("email"));
				
				
				 ResultSet rs = ps.executeQuery();
				 if(rs.next()){	
					password=rs.getString(1); 
				 }
				 else{
						doc.put("b", "false");
				 }
				
				 String BODY ="Your password is : "+ password;
				SendVerificationEmail sendVerificationEmail=new SendVerificationEmail(request.getParameter("email"), BODY,subject);
				sendVerificationEmail.sendMail();
				doc.put("b", "true");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
						doc.put("b", "false");
						response.setContentType("application/json"); 
					    response.setCharacterEncoding("UTF-8");
						response.getWriter().write(gson.toJson(doc));
				}
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
	}

}
