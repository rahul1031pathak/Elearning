package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import in.Elearning.java.DbConnection;
import structure.user.User;



/**
 * Servlet implementation class Facebook
 */
@WebServlet("/Facebook")
public class Facebook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  String UserId="";
		  try {
				
				 ps = con.prepareStatement("SELECT * FROM facebook WHERE facebook_id=?");
					 ps.setString(1, request.getParameter("facebookId"));
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
					UserId="yes"	;
					
					}
					
					 ps.close();
					 } 
			 
			 	 
			 catch (SQLException e) {
					e.printStackTrace();
				} 
			
			 finally{ }
		  Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("UserId", UserId);
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
			 
		  try {
	    	 
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session=null;
		
		User user=null;
		
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  String UserId="";
	String b="false";
		  try {
				
				 ps = con.prepareStatement("SELECT user_id FROM facebook WHERE facebook_id=?");
					 ps.setString(1, request.getParameter("facebookId"));
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
					UserId=rs.getString(1)	;
					b="true";
					}
					 ps.close();
					 } 
			 
			 	 
			 catch (SQLException e) {
					e.printStackTrace();
				}
		
		Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
		//String UserId=request.getParameter("UserId");
		user=userdetails.fetchUserDetails(UserId);//here we fetch all the user details
		
		session=request.getSession(true); // Create a session object if it is already not  created.
		session.setMaxInactiveInterval(-1); 
		session.setAttribute("USERID",UserId);  //till here working fine
		session.setAttribute("FACEBOOKUSERID", "true"); 
	
         session.setAttribute("ISLOGIN", "true"); 
		
         userdetails.connClose();
        
         Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("b", b);
			//doc.put("error message", "user have no permission");
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
		
		

		
		
	}

}
