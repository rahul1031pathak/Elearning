package manage.classroom;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
import structure.classroom.Notification;
import structure.user.User;

/**
 * Servlet implementation class WriteArticle
 */
@WebServlet("/WriteArticle")

public class WriteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if( request.getSession(false)!=null &&request.getParameter("ClassId")!=null){
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  int i;
		
		int flag1=1;
		long content_id;
		if(request.getParameter("article")==null ||request.getParameter("article")==""){
		
		flag1=0;
			
		}
	
		
		Authenticate_User_Role_In_Class authentication=new Authenticate_User_Role_In_Class ();
		ArrayList<String> check=new ArrayList<String>();	
		check=authentication.User_Role((String) request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));
		
		
		
if(flag1==1&&check.get(6).equals("true")){
try {

	
	
	 Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
     User user= userdetails.fetchUserDetails((String) request.getSession(false).getAttribute("USERID"));
     userdetails.connClose();
	
	
	
	 ps = con.prepareStatement("INSERT INTO article (topic,article_content,article_writer,class_id,article_writer_name) VALUES(?,?,?,?,?)"); 
	 ps.setString(1, request.getParameter("topic"));
	
	 ps.setString(2,"<div>"+ request.getParameter("article")+"</div>");
	 ps.setString(4,request.getParameter("ClassId") );
	 ps.setString(3, (String) request.getSession(false).getAttribute("USERID"));
	 ps.setString(5, user.getFullname());
	
	  i=ps.executeUpdate();
	  if(i==1){
			 
			ps=con.prepareStatement("SELECT LAST_INSERT_ID()"); 
			ResultSet rs=ps.executeQuery();
				if(rs.next()){
					content_id= rs.getLong(1);
					
	 Notification notification=new Notification("Article","<div>"+ request.getParameter("article")+"</div>",request.getParameter("ClassId"),(String) request.getSession(false).getAttribute("USERID"),user.getFullname(),user.getProfilepic(),content_id+"");
	 Notification_Updater notificationUpdater=new Notification_Updater();
	 
	 notificationUpdater.updateNotification(request.getParameter("ClassId"), notification);
	 notificationUpdater.connClose();
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "true");

		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
	 
}else{
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		doc.put("error message", "either not login or you have not permission for this operation");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
}
	  ps.close();
} 
}
 catch (SQLException e) {
	 
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		doc.put("error message", "something went wrong");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
}finally{
	
	 

}// end of finally

}//end of if

else{
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		doc.put("error message", "either not login or you have not permission for this operation");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
}


try {
	  
	con.close();
} catch (SQLException e) {
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		doc.put("error message", "something went wrong");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
}

		}// end of if login check
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
