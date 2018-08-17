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

import in.Elearning.java.DbConnection;
import manage.user.Validation;

/**
 * Servlet implementation class Privacy_Setter_of_Class
 */
@WebServlet("/Privacy_Setter_of_Class")
public class Privacy_Setter_of_Class extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getParameter("ClassId")!=null){

			Validation validation=new Validation();
			boolean check=	validation.Is_Class_Admin((String) request.getSession(false).getAttribute("USERID"),  request.getParameter("ClassId"));
			
			if(check){
				
			
			
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		String view="1";
		String answer="0";
		String Ques="0";
		if(request.getParameter("answer")==null){
			
		}else{
			answer=request.getParameter("answer");
		}
		if(request.getParameter("question")==null){
			
		}
		else{
			Ques=request.getParameter("question");
		}
		if(request.getParameter("view")==null){
			
		}else{
			view=request.getParameter("view");
		}
		
		try {
		
			 ps = con.prepareStatement("UPDATE classroom_details SET answer_setting = ?, question_setting = ? ,view_setting = ? WHERE class_id = ?");
			 ps.setString(1, answer);
			 ps.setString(2, Ques);
			 ps.setString(3, view );
			 ps.setString(4, request.getParameter("ClassId") );

			  ps.executeUpdate();	
				Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				
				
				
				doc.put("b","true");
				response.setContentType("application/json"); 
			   response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
				
				

}
	 
	 catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
	
		 try {
	    	  ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}// check class admin
		 
			else{
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "false");
					doc.put("error message", "user have no permission");
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
			
			
		}// end of if to check session
		
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
