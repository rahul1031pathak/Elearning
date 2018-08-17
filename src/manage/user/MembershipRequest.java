package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import in.Elearning.java.DbConnection;
import structure.user.User;


/**
 * Servlet implementation class MembershipRequest
 */
@WebServlet("/MembershipRequest")
public class MembershipRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(  request.getSession(false).getAttribute("USERID")!=null&&request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){

		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
		     User user= userdetails.fetchUserDetails((String) request.getSession(false).getAttribute("USERID"));
		     userdetails.connClose();
		try {
			
			 ps = con.prepareStatement("INSERT INTO membership_req (sender_id,class_id,sender_name,Class_Admin_Id,class_name,profile_pic,proof_pic,institute) VALUES(?,?,?,?,?,?,?,?)");
			 ps.setString(1, (String) request.getSession(false).getAttribute("USERID"));
			 ps.setString(2,request.getParameter("ClassId"));
			 ps.setString(3,user.getFullname());
			 ps.setString(4,request.getParameter("CLASSADMINID"));
			 ps.setString(5,request.getParameter("CLASSNAME"));
			 ps.setString(6,user.getProfilepic());
			 ps.setString(7,user.getProfilepic());
			 ps.setString(8,user.getInstitution());
			int i=ps.executeUpdate();
			 if(i==1){
					
			String b="true";
				Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", b);
				
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
				
				
			 }
			 
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 try {
	    	  ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
