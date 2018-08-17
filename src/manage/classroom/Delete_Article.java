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
 * Servlet implementation class Delete_Article
 */
@WebServlet("/Delete_Article")
public class Delete_Article extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){	
			
			Validation validation=new Validation();
			
			boolean can_delete=	validation.Can_Delete_Article((String)request.getSession(false).getAttribute("USERID"),request.getParameter("articleId"));
			validation.connClose();
			if(can_delete){
			
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		String id= request.getParameter("articleId");
	
		 
		 try {
	           
             
			 con.setAutoCommit(false);
					ps = con.prepareStatement("DELETE FROM article WHERE article_id=?");
					ps.setString(1, id );
				        ps.executeUpdate();
				        
				        
				        ps = con.prepareStatement("DELETE FROM notification WHERE notification_type=? and content_id=?");
				        ps.setString(1,"Article");
				        ps.setString(2,id);
				        ps.executeUpdate();
				        

						//ps = con.prepareStatement("DELETE FROM article WHERE article_id=?");
						//ps.setString(1, id );
					 //       ps.executeUpdate();
				        con.commit();
				 		  con.setAutoCommit(true); 
 
 Map<String, String> doc=new HashMap<String, String>();
	Gson gson=new Gson();
	doc.put("b", "true");
	
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
		 
		 
		 
		}// end of validation
			
			else{

				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "true");
					doc.put("error message", "either not login or you have not permission for this operation");
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
			
			
		}	// end of login check	
		else
		{
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "true");
				doc.put("error message", "either not login or you have not permission for this operation");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}
	}// end of post

}
