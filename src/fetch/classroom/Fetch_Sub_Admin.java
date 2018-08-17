package fetch.classroom;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import structure.user.Sub_Admin;


/**
 * Servlet implementation class Fetch_Sub_Admin
 */
@WebServlet("/Fetch_Sub_Admin")
public class Fetch_Sub_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Sub_Admin> sub_admin_list=new ArrayList<Sub_Admin>();
		Sub_Admin sub_admin;
		
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  ResultSet rs = null;
		  try {
				
				 ps = con.prepareStatement("SELECT * FROM sub_admin WHERE class_id=?");
			
				 ps.setString(1,request.getParameter("ClassId"));
				 rs=ps.executeQuery();
				 while(rs.next()){
					
					 sub_admin=new Sub_Admin(rs.getInt(1)+"",rs.getString(2),rs.getString(3),"","",rs.getTimestamp(4));
					 sub_admin_list.add(sub_admin);
				 }
				 
				
					 for(int i=0;i<sub_admin_list.size();i++){
						 ps = con.prepareStatement("SELECT fullname,email FROM user_details WHERE user_id=?");
							
						 ps.setString(1,sub_admin_list.get(i).getSub_admin_user_id());
						 rs=ps.executeQuery();
						 while(rs.next()){
							
							 sub_admin_list.get(i).setSub_admin_name(rs.getString(1));
							 sub_admin_list.get(i).setSub_admin_email(rs.getString(2));
					 }
				

				 } 
		  }
		 catch (SQLException e) {
				e.printStackTrace();
			} 
		
		 finally{ }
				 
		 
		 try {
	    	  ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			Gson gson=new Gson();
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(sub_admin_list));
	}

		
		
	}

	


