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
 * Servlet implementation class Check_Class_Privacy
 */
@WebServlet("/Check_Class_Privacy")
public class Check_Class_Privacy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getSession(false).getAttribute("USERID")!=null &&request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getParameter("ClassId")!=null){

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
		 String is_memberShipReqsent="false";
		  String zero="0";
		  String one="1";
		  String userId=(String) request.getSession(false).getAttribute("USERID");
		  request.setAttribute("ClassId", request.getParameter("ClassId"));
		  
		 
			ArrayList<String> classPrivacy=new ArrayList<String>();
			
			Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
			  
			 
			classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));
			
			request.setAttribute("CLASSNAME",classPrivacy.get(3));
				request.setAttribute("CLASSADMINNAME", classPrivacy.get(4));
				request.setAttribute("CLASSADMINID", classPrivacy.get(5));
				request.setAttribute("DISCRIPTION", classPrivacy.get(8));
				
				
				 classPrivacy=Classroomfetch.FetchAdminDetails(classPrivacy.get(5));
					request.setAttribute("ADMINEMAIL",classPrivacy.get(1));
					request.setAttribute("CLASSADMINNAME", classPrivacy.get(0));
					request.setAttribute("ADMINIDIMAGE", classPrivacy.get(2));
					request.setAttribute("ADMININSTITUTION", classPrivacy.get(3));
					request.setAttribute("ADMINFOLLOWERS", classPrivacy.get(4));
					 Classroomfetch.connClose();
		  
		  
		  
		  
		  
		  
		  
		  
		  
		 try {
				
			 ps = con.prepareStatement("SELECT * FROM classroom_details WHERE class_id=?");
				 ps.setString(1, request.getParameter("ClassId"));
				 rs=ps.executeQuery();
				 while(rs.next()){
					 if(rs.getString(2).equals(userId)){
						 is_classAdmin="true";
			 }

					 
					 
					 
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
		 
		 
		 
		 
		 if(is_classAdmin.equals("true")){
			 
			 
			 
			 
			 
			 
			 
			 request.setAttribute("is_classMember", "false");
			 request.setAttribute("can_answer", "true");
			 request.setAttribute("can_question", "true");
			 request.setAttribute("is_subscriber",  "false");
			 request.setAttribute("can_view",  "true");
			 request.setAttribute("is_memberShipReqsent", "false");
			 
			 
			 
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
			 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("myclass.jsp");
				dispatcher.forward(request,response); 
		 }
		 
	 
		 else{
		 
	 try {
				
			 
			 
			 
			 ps = con.prepareStatement("SELECT * FROM subscriber_table WHERE class_id=? AND user_id=?");
			 ps.setString(1, request.getParameter("ClassId"));
			 ps.setString(2, userId);
			 rs=ps.executeQuery();
			 
			 
			 while(rs.next()){
				 //if(rs.getString(2).equals(userId)){
					 is_subscriber="true";
					 
				 //}
				 if( can_answer.equals("true")&&is_subscriber.equals("true")){
					 
				 }
				 else{
					 can_answer="false";
				 }
				 
	 if( can_question.equals("true")&&is_subscriber.equals("true")){
					 
				 }
				 else{
					 can_question="false";
				 } 
				 
				
	 
	 if( can_view.equals("true")&&is_subscriber.equals("true")){
		 
	 }
	 else{
		 can_view="false";
	 } 
				 
				 
			 }
			 
			 
			 
			 
			 
			 
			 
			 
			 
				 ps = con.prepareStatement("SELECT * FROM membership_table WHERE class_id=? AND user_id=?");
				 ps.setString(1, request.getParameter("ClassId"));
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
				 
		
				 
				  ps = con.prepareStatement("SELECT * FROM membership_req WHERE class_id=? AND sender_id=?");
				  ps.setString(1, request.getParameter("ClassId"));
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
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 request.setAttribute("is_classMember", is_classMember);
		 request.setAttribute("can_answer", can_answer);
		 request.setAttribute("can_question", can_question);
		 request.setAttribute("is_subscriber",  is_subscriber);
		 request.setAttribute("can_view",  can_view);
		 request.setAttribute("is_memberShipReqsent", is_memberShipReqsent);
	
		 if(is_classAdmin.equals("false")){
		 	 RequestDispatcher dispatcher = request.getRequestDispatcher("otherclass.jsp");
				dispatcher.forward(request,response); 
		 }
		
		
		 	
		}
		
		 
		 
			
		}		
		
		
		
		
		
		
		
		
		 else if(request.getParameter("ClassId")!=null){
			 String is_classMember="false";
			 String is_subscriber="false";
			 String is_classAdmin="false";
			 String is_memberShipReqsent="false";
			 
 request.setAttribute("ClassId", request.getParameter("ClassId"));
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
 Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
 
 ArrayList<String> classPrivacy=new ArrayList<String>();
	classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));

		
		
		request.setAttribute("CLASSNAME",classPrivacy.get(3));
		request.setAttribute("CLASSADMINNAME", classPrivacy.get(4));
		request.setAttribute("CLASSADMINID", classPrivacy.get(5));
		request.setAttribute("DISCRIPTION", classPrivacy.get(8));
			 	 RequestDispatcher dispatcher = request.getRequestDispatcher("otherclass.jsp");
					dispatcher.forward(request,response); 
		 }
			
		 
		 
		 
		 
		 
		 
			else{

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.forward(request,response);
			}
		 
		 
		 
		 
		 
			
			
			
			
			
			
			
			
			
		
	}

}
