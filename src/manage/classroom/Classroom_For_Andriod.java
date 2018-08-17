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

import fetch.classroom.Fetch_CLass_Content;
import in.Elearning.java.DbConnection;


/**
 * Servlet implementation class Classroom_For_Andriod
 */
@WebServlet("/Classroom_For_Andriod")
public class Classroom_For_Andriod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

Map<String, String> doc=new HashMap<String, String>();
	
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps =null;
		  ResultSet rs = null;
		 String can_view="";
		 String  can_question="";
		 String  can_answer="";
		 String is_classMember="false";
		 String is_subscriber="false";
		 String is_classAdmin="false";
		 String is_memberShipReqsent="false";
		  String zero="0";
		  String one="1";
		
		
		
		if(request.getSession(false)!=null &&request.getSession(false).getAttribute("USERID")!=null &&request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getParameter("ClassId")!=null){

			  String userId=(String) request.getSession(false).getAttribute("USERID");
			  
			  
	ArrayList<String> classPrivacy=new ArrayList<String>();
				
				Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
				  
				 
				classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));
			
				doc.put("ISLOGIN","true");
				doc.put("LOGINUSER",userId);	
				doc.put("CLASSNAME",classPrivacy.get(3));
				doc.put("CLASSADMINNAME", classPrivacy.get(4));
				doc.put("CLASSADMINID", classPrivacy.get(5));
				doc.put("DISCRIPTION", classPrivacy.get(8));
					
					
					 classPrivacy=Classroomfetch.FetchAdminDetails(classPrivacy.get(5));
					 doc.put("ADMINEMAIL",classPrivacy.get(1));
					 doc.put("CLASSADMINNAME", classPrivacy.get(0));
					 doc.put("ADMINIDIMAGE", classPrivacy.get(2));
					 doc.put("ADMININSTITUTION", classPrivacy.get(3));
					 doc.put("ADMINFOLLOWERS", classPrivacy.get(4));
						 Classroomfetch.connClose();
						 
						 
						 doc.put("ClassId", request.getParameter("ClassId"));
			  
			  
			  
			
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
				 
				 
				 doc.put("is_classAdmin","true");
					Gson gson=new Gson();
					 is_classMember="true";
					doc.put("b", "true");
					is_subscriber="true";
					 is_memberShipReqsent="true";
					 can_answer="true";
					 can_question="true"; 
					 can_view="true";
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
			
						 doc.put("is_classMember", is_classMember);
						 doc.put("can_answer", can_answer);
						 doc.put("can_question", can_question);
						 doc.put("is_subscriber",  is_subscriber);
						 doc.put("can_view",  can_view);
						 doc.put("is_memberShipReqsent", is_memberShipReqsent);
						 doc.put("is_classAdmin",is_classAdmin);
							Gson gson=new Gson();
							doc.put("b", "true");
							
							
						
							response.setContentType("application/json"); 
						   response.setCharacterEncoding("UTF-8");
							response.getWriter().write(gson.toJson(doc));
		}
	
			
		
		
		
		}	
		
		
		
		
		
				
			else if(request.getParameter("ClassId")   !=null &&!request.getParameter("ClassId").isEmpty()){
		
			System.out.println(request.getParameter("ClassId").isEmpty());
	ArrayList<String> classPrivacy=new ArrayList<String>();
				
				Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
				  
				 
				classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));
			
				doc.put("LOGINUSER","");
				doc.put("ISLOGIN","false");
				doc.put("CLASSNAME",classPrivacy.get(3));
				doc.put("CLASSADMINNAME", classPrivacy.get(4));
				doc.put("CLASSADMINID", classPrivacy.get(5));
				doc.put("DISCRIPTION", classPrivacy.get(8));
					
					
					 classPrivacy=Classroomfetch.FetchAdminDetails(classPrivacy.get(5));
					 doc.put("ADMINEMAIL",classPrivacy.get(1));
					 doc.put("CLASSADMINNAME", classPrivacy.get(0));
					 doc.put("ADMINIDIMAGE", classPrivacy.get(2));
					 doc.put("ADMININSTITUTION", classPrivacy.get(3));
					 doc.put("ADMINFOLLOWERS", classPrivacy.get(4));
						 Classroomfetch.connClose();
						 
						 
						 doc.put("ClassId", request.getParameter("ClassId"));
						 doc.put("is_classMember", is_classMember);
						 doc.put("can_answer", can_answer);
						 doc.put("can_question", can_question);
						 doc.put("is_subscriber",  is_subscriber);
						 doc.put("can_view",  can_view);
						 doc.put("is_memberShipReqsent", is_memberShipReqsent);
						 doc.put("is_classAdmin",is_classAdmin);
						 doc.put("b", "true");
							Gson gson=new Gson();
							
							
							
						
							response.setContentType("application/json"); 
						   response.setCharacterEncoding("UTF-8");
							response.getWriter().write(gson.toJson(doc));
			
			
			}
				
				 
		
			else{
				doc.put("b", "false");
				doc.put("ISLOGIN","false");
				doc.put("ClassId", "");
				doc.put("LOGINUSER","");
				Gson gson=new Gson();
				
				
				
				
				response.setContentType("application/json"); 
			   response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
			}
		
		
		
		
		
		
		
		

	}

	
}
