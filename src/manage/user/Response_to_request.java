package manage.user;

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

import in.Elearning.java.Counting;
import in.Elearning.java.DbConnection;
import manage.classroom.AcceptingRequest;


/**
 * Servlet implementation class Response_to_request
 */
@WebServlet("/Response_to_request")
public class Response_to_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){

		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		String flag=request.getParameter("flag")+"";
		  
		String zero="0";
		String one="1";
		Validation validation=new Validation();
	boolean check=	validation.Validate_User_For_Response_to_Request((String) request.getSession(false).getAttribute("USERID"),request.getParameter("membershipReqId"));
	//validation.connClose();
	if(!check){
		Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		
	
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
	}
		
		
		
		if(flag.equals(zero)&&check){ // this if else will decide whether we have to accept or reject the membership request
			
			try {
				
				 ps = con.prepareStatement("DELETE FROM membership_req WHERE Member_req_id=?");
				 ps.setString(1, request.getParameter("membershipReqId") );
				 ps.executeUpdate();
				 ps.close();
			
					
					
					
				
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
		
			
			
		}	
		else if(flag.equals(one)&&check){
				
				try {
					String class_id;
					 String sender_id;
					 ps = con.prepareStatement("SELECT * FROM membership_req WHERE Member_req_id=?");
					 ps.setString(1, request.getParameter("membershipReqId") );
					 ResultSet rs=  ps.executeQuery();
					 
					 while(rs.next()){
						  sender_id=rs.getString(1);
						  class_id=rs.getString(2);
						 
						  
						boolean check1 = validation.Should_Accept(sender_id, class_id);
						  
						 if(check1){ 
						  
						 AcceptingRequest ar=new AcceptingRequest();
					int i= ar.addingToMemberTable(sender_id,class_id);
						if(i==1){
							
							
							 Counting counting=new Counting();
						       String user_id= counting.IncreaseNumberOfMember(class_id);
       counting.IncreaseNumberOfFollowers(user_id);
							counting.connClose();
							ar.deletingTheReq(request.getParameter("membershipReqId") );
							ar.connClose();
							//counting.connClose();
							
							
							Map<String, String> doc=new HashMap<String, String>();
							Gson gson=new Gson();
							doc.put("b", "true");
					
							response.setContentType("application/json"); 
						    response.setCharacterEncoding("UTF-8");
							response.getWriter().write(gson.toJson(doc));
						}
						 
						
						 } // duplicate membership check if close here
						 else{
							 AcceptingRequest ar=new AcceptingRequest();
								ar.deletingTheReq(request.getParameter("membershipReqId") );
								ar.connClose();
								//counting.connClose();
								
								
								Map<String, String> doc=new HashMap<String, String>();
								Gson gson=new Gson();
								doc.put("b", "true");
						
								response.setContentType("application/json"); 
							    response.setCharacterEncoding("UTF-8");
								response.getWriter().write(gson.toJson(doc));
						 }
						
						
						
						
						
						
						  validation.connClose();
						
						
						
						
						
						
						
						 
						 
						 }
					 
					 
					 if(ps!=null){
						 ps.close();
					 }
					 
					

		}
			 
			 catch (SQLException e) {
					e.printStackTrace();
				}finally{}
					
				     
				
			
			
				
				
			} 
			
			
		 try {
			// System.out.println("closing connection");  connection will be closed here
			 if(con!=null){
				 con.close(); 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}// login check
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
