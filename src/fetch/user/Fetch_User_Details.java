package fetch.user;

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

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import structure.user.UserSearch;


/**
 * Servlet implementation class Fetch_User_Details
 */
@WebServlet("/Fetch_User_Details")
public class Fetch_User_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 
		if( request.getSession(false)!=null){
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  ResultSet rs = null;
		  UserSearch userSearch = null;   
		  try {   
				
				 ps = con.prepareStatement("SELECT * FROM user_details WHERE user_id=?");
				
				 ps.setString(1, (String) request.getSession(false).getAttribute("USERID"));
				 rs=ps.executeQuery();
				 while(rs.next()){
					
					 userSearch=new UserSearch(rs.getString(1),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(2),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(18),rs.getString(19),rs.getString(20),rs.getString(14),rs.getInt(16)+"",rs.getTimestamp(5));
                	
				 }
			
				 if(ps!=null){
					  ps.close(); 
				 }
				if(con!=null){
					con.close();
				}
					
				 } 
		 catch (SQLException e) {
				e.printStackTrace();
			} 
		
		 finally{ }
		
			Gson gson=new Gson();
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(userSearch));
	}
		else{
			  Map<String, String> doc=new HashMap<String, String>();
	 			Gson gson=new Gson();
	 			doc.put("b", "false");
	 			doc.put("msg","not login");
	 			response.setContentType("application/json"); 
	 		   response.setCharacterEncoding("UTF-8");
	 			response.getWriter().write(gson.toJson(doc));
		}
		
	}
	

}
