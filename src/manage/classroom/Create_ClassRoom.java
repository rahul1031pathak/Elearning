package manage.classroom;

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
import in.Elearning.java.Counting;

import in.Elearning.java.DbConnection;
import structure.user.User;


/**
 * Servlet implementation class Create_ClassRoom
 */
@WebServlet("/Create_ClassRoom")
public class Create_ClassRoom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int i;  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false)!=null&&request.getSession(false).getAttribute("USERID")!=null 
				&& !request.getParameter("ClassName").isEmpty() 
				&& !request.getParameter("about_classroom").isEmpty()){

		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null ;
		Dao_Verify_Of_Unique_ClassName uniqueclassname=new Dao_Verify_Of_Unique_ClassName();
		 Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
	     User user= userdetails.fetchUserDetails((String) request.getSession(false).getAttribute("USERID"));
	     userdetails.connClose();
	
		int flag=uniqueclassname.VerifyUniqueClassName((String) request.getSession(false).getAttribute("USERID"), request.getParameter("ClassName"));
		if(flag==0){ 
		try { 
			
			  ps = con.prepareStatement("INSERT INTO classroom_details (Classroom_Name,Class_Admin,Discription,Class_Admin_Name,answer_setting,question_setting,view_setting) VALUES(?,?,?,?,?,?,?)");
			 ps.setString(1, request.getParameter("ClassName"));
			 ps.setString(2, (String) request.getSession(false).getAttribute("USERID"));
			 ps.setString(3, request.getParameter("about_classroom"));
			 ps.setString(4, user.getFullname());
			 ps.setString(5, "1");
			 ps.setString(6, "1");
			 ps.setString(7, "1");
			
			 i=ps.executeUpdate();
			 
			 ps = con.prepareStatement("UPDATE user_details SET is_teacher=? where user_id=?"); 
			 ps.setInt(1, 1);
			 ps.setString(2,(String) request.getSession(false).getAttribute("USERID"));
			 ps.executeUpdate();
			 if(ps!=null){
				 ps.close(); 
			 }
			
			 if(i==1){
				
				 Counting counting=new Counting();
				 counting.IncreaseClassCount((String) request.getSession(false).getAttribute("USERID"));
				 counting.connClose();
		
				uniqueclassname.connClose();
		 }
			 
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String b="true";
		Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", b);
		
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
		
		
		
		
		try {
			if(ps!=null){
				 ps.close();
			}
	    	if(con!=null){
	    		con.close();
	    	}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
		else{	String b="false";
		Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", b);
		doc.put("msg", "already created by this name or please re login");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
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

	

}
