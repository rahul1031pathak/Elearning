package manage.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fetch.classroom.Fetch_CLass_Content;
import in.Elearning.java.DbConnection;


/**   
 * Servlet implementation class MyclassroomFetcher
 */
@WebServlet("/class")
public class MyclassroomFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps =null;
		  ResultSet rs = null;
		
		String can_view="false";
		 String  can_question="false";  
		 String  can_answer="false";
		 String is_classMember="false";
		 String is_subscriber="false";     
		 String is_classAdmin="false";
		 String is_subAdmin="false";
		 String is_memberShipReqsent="false";
		  String zero="0";
		  String one="1";
		 
		if(  request.getSession(false)!=null&&request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()&&request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
			 String userId=(String) request.getSession(false).getAttribute("USERID");
			 String classid=request.getParameter("id").trim();
		// if login and class id is also in url
			
			Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
			ArrayList<String> classPrivacy=new ArrayList<String>();
			classPrivacy=Classroomfetch.FetchClassPrivacy(classid);
		  
			// first check for class admin  
			 String classAdmin=classPrivacy.get(5); 
			 if(classAdmin.equals((String) request.getSession(false).getAttribute("USERID")) ){
				  can_view="true";
					 can_question="true";
					 can_answer="true";        
					 is_classMember="false";
					 is_subscriber="false";
					 is_classAdmin="true";
					 is_subAdmin="false";
					  is_memberShipReqsent="false";
					  request.setAttribute("ISCLASSADMIN", "true");
			 }  // end of if when user is admin
		
			 else {
				 // if user is not admin
				 
				 
				 // checking for member subscriber and privacy setting
				 
				 
				 try {
						
					 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
						 ps.setString(1,classid);
						 rs=ps.executeQuery();
						 while(rs.next()){
							 
							 if(rs.getString(7).equals(one)){
								 can_answer="true"; 
							 }else{if(rs.getString(7).equals(zero)){
								 can_answer="false";}
							 }
							 
							 
							 if(rs.getString(8).equals(one)){
								 can_question="true"; 
							 }else{if(rs.getString(8).equals(zero)){
								 can_question="false";}
							 }

							 if(rs.getString(9).equals(one)){
								 can_view="true"; 
							 }else{if(rs.getString(9).equals(zero)){
								 can_view="false";}
							 }
							 
							
							 
						 }
						 
						 } 
				 
				 	 
				 catch (SQLException e) {
						e.printStackTrace();
					} 
				
				 finally{ }
				 
				 
				 try {
						
						 ps = con.prepareStatement("SELECT * FROM membership_table WHERE class_id=? AND user_id=?");
						 ps.setString(1, classid);
						 ps.setString(2, userId);
						 rs=ps.executeQuery();
						 while(rs.next()){
							// if(rs.getString(2).equals(userId)){
								 is_classMember="true";
								 can_answer="true";
								 can_question="true"; 
								 can_view="true";
							// }
							 
							 
						 }
						 
						 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE class_id=? AND user_id=?");
						 ps.setString(1, classid);
						 ps.setString(2, userId);
						 rs=ps.executeQuery();
						 
						 
						 while(rs.next()){
							 //if(rs.getString(2).equals(userId)){
								 is_subscriber="true";
								 
							 //}
							 
							 
							 
							
							 
							 
						 }
						 
						  ps = con.prepareStatement("SELECT * FROM membership_req WHERE class_id=? AND sender_id=?");
						  ps.setString(1, classid);
						  ps.setString(2, userId);
						  rs=ps.executeQuery();
						  if(rs.next()){
							  is_memberShipReqsent="true";
						  }
						 
						 
						 
						 } 
				 catch (SQLException e) {
						e.printStackTrace();
					} 
				
				 finally{ }
						 
				 
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
				 
				 
				 
				 
				 //// end of checking 
				 is_subAdmin=Classroomfetch.is_subAdmin(userId, classid); 
				 
				 if(is_subAdmin.equals("true")){
					  can_view="true";
						 can_question="true";
						 can_answer="true";
						
						 is_classAdmin="false";
						 is_subAdmin="true";
						
				 }
				 
				 
				 
				 
				 
			 } // else ending if user is not admin 
		
		
		// common operations in both case
		
			  request.setAttribute("ClassId", classid);
				 request.setAttribute("is_classMember", is_classMember);
				 request.setAttribute("can_answer", can_answer);
				 request.setAttribute("can_question", can_question);
				 request.setAttribute("is_subscriber",  is_subscriber);
				 request.setAttribute("can_view",  can_view);
				 request.setAttribute("is_classAdmin", is_classAdmin);
				 request.setAttribute("is_subAdmin", is_subAdmin);
				 request.setAttribute("is_memberShipReqsent", is_memberShipReqsent);
		
				 
				
					request.setAttribute("CLASSNAME",classPrivacy.get(3));
					request.setAttribute("CLASSADMINNAME", classPrivacy.get(4));
					request.setAttribute("CLASSADMINID", classPrivacy.get(5));
					request.setAttribute("DISCRIPTION", classPrivacy.get(8));
					request.setAttribute("number_of_members", classPrivacy.get(6));
					request.setAttribute("number_of_subscribers", classPrivacy.get(7));
					
				 classPrivacy=Classroomfetch.FetchAdminDetails(classPrivacy.get(5));
				 
					request.setAttribute("ADMINEMAIL",classPrivacy.get(1));
					request.setAttribute("CLASSADMINNAME", classPrivacy.get(0));
					request.setAttribute("ADMINIDIMAGE", classPrivacy.get(2));
					request.setAttribute("ADMININSTITUTION", classPrivacy.get(3));
					request.setAttribute("ADMINFOLLOWERS", classPrivacy.get(4));
		
					
					if(is_classAdmin.equals("true")||is_subAdmin.equals("true")){
						RequestDispatcher dispatcher = request.getRequestDispatcher("class/class.jsp");
						dispatcher.forward(request,response);
					}
					
					else{
						RequestDispatcher dispatcher = request.getRequestDispatcher("class/class.jsp");
						dispatcher.forward(request,response);
					}
		
		}// end of login check
		
		// if not login and still class id is there in url
		else	if(request.getParameter("id")!=null&&!request.getParameter("id").isEmpty()){
			 String classid=request.getParameter("id");
			 
request.setAttribute("ClassId", classid);
	HttpSession session=null;
session=request.getSession(true);
session.setAttribute("ISLOGIN", "false");
session.setAttribute("USERID", null);
request.setAttribute("is_classMember", is_classMember);       
request.setAttribute("can_answer", "false");
request.setAttribute("can_question", "false");   
request.setAttribute("is_subscriber",  is_subscriber);
request.setAttribute("can_view", "false");
request.setAttribute("is_memberShipReqsent", is_memberShipReqsent);
request.setAttribute("is_classAdmin",is_classAdmin);
request.setAttribute("is_subAdmin", is_subAdmin);
Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();

ArrayList<String> classPrivacy=new ArrayList<String>();
	classPrivacy=Classroomfetch.FetchClassPrivacy(classid);         

	request.setAttribute("CLASSNAME",classPrivacy.get(3));
	request.setAttribute("CLASSADMINNAME", classPrivacy.get(4));
	request.setAttribute("CLASSADMINID", classPrivacy.get(5));
	request.setAttribute("DISCRIPTION", classPrivacy.get(8));
	request.setAttribute("number_of_members", classPrivacy.get(6));
	request.setAttribute("number_of_subscribers", classPrivacy.get(7));
		
	 classPrivacy=Classroomfetch.FetchAdminDetails(classPrivacy.get(5));
	 
		request.setAttribute("ADMINEMAIL",classPrivacy.get(1));
		request.setAttribute("CLASSADMINNAME", classPrivacy.get(0));
		request.setAttribute("ADMINIDIMAGE", classPrivacy.get(2));
		request.setAttribute("ADMININSTITUTION", classPrivacy.get(3));
		request.setAttribute("ADMINFOLLOWERS", classPrivacy.get(4));
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("class/class.jsp");
		dispatcher.forward(request,response);
					
		 } 
		
		// if not not login and class id is not there is url
		
		else{

			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request,response);
		}
		
} // end of get
}// end of servlet 
