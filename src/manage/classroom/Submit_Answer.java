package manage.classroom;

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

import fetch.user.Dao_Fetch_User_Details;
import in.Elearning.java.DbConnection;
import structure.classroom.Notification;
import structure.user.User;

/**
 * Servlet implementation class Submit_Answer
 */
@WebServlet("/Submit_Answer")
public class Submit_Answer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getParameter("ClassId")!=null&&request.getParameter("answer")!=null){

		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  
			int i;
			
		  Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 
		     User user= userdetails.fetchUserDetails((String) request.getSession(false).getAttribute("USERID"));
		     userdetails.connClose();

			try {
				
			 ps = con.prepareStatement("INSERT INTO answerintext (ques_id,class_id,ans_content,ans_giver,ans_giver_name) VALUES(?,?,?,?,?) "); 
			 ps.setString(1,request.getParameter("Ques_Id") );
			 ps.setString(2,request.getParameter("ClassId") );
			 ps.setString(3, "<div>"+request.getParameter("answer")+"</div>");
			
			 ps.setString(4, (String) request.getSession(false).getAttribute("USERID"));
			 ps.setString(5, user.getFullname());
			
			i= ps.executeUpdate();
			if(i==1){
				
				 ps=con.prepareStatement("SELECT LAST_INSERT_ID()"); 
					ResultSet rs=ps.executeQuery();
						if(rs.next()){
							long content_id= rs.getLong(1);
				 Notification notification=new Notification("Answer","<div>"+request.getParameter("answer")+"</div>",request.getParameter("ClassId"),(String) request.getSession(false).getAttribute("USERID"),user.getFullname(),user.getProfilepic(),content_id+"");

				 Notification_Updater notificationUpdater=new Notification_Updater();
				 
				 notificationUpdater.updateNotification(request.getParameter("ClassId"), notification);
				 notificationUpdater.connClose();
			}
		
			 
			} 
			
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{}
			
			
			 try {
		    	  ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "true");
		
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}// end of if login check
		
			else{
				 
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "false");
					doc.put("error message", "something went wrong");
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));

				 
			 }
		
		}
		
		
	


}//end of servlet
