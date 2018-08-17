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

import in.Elearning.java.Counting;
import in.Elearning.java.DbConnection;
import manage.user.Validation;


/**
 * Servlet implementation class Delete_Membership
 */
@WebServlet("/Delete_Membership")
public class Delete_Membership extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
			 DbConnection dbc=new DbConnection(); 
			  Connection con =dbc.getMysqlConnection();
		    PreparedStatement ps = null;
			Validation validation=new Validation();
			String userid="";
			boolean check_admin=	validation.Is_Class_Admin((String)request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));
			boolean check_member=	validation.can_delete_membership((String)request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));

		if(check_admin&&request.getParameter("userId")!=null){userid=request.getParameter("userId");}	
		if(check_member){userid=(String)request.getSession(false).getAttribute("USERID");}
		
			validation.connClose();
			if(!check_admin&&!check_member){
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "false");
				
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
			
			
			else{	 try {
         
                
                    
							ps = con.prepareStatement("DELETE FROM membership_table WHERE class_id=? AND user_id=?");
							ps.setString(1, request.getParameter("ClassId"));
							ps.setString(2, userid);
						        ps.executeUpdate();
						        System.out.println("done");
						        Counting counting=new Counting();
						       String id= counting.DecreaseNumberOfMember(request.getParameter("ClassId"));
         counting.DecreaseNumberOfFollowers(id);

         counting.connClose();
      
     	try {
	    	// System.out.println("closing connection"); 
			 if(con!=null){
					con.close();	 
			 }
			   if(ps!=null){
		        	  ps.close(); 
		         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 Map<String, String> doc=new HashMap<String, String>();
			Gson gson=new Gson();
			doc.put("b", "true");
			//doc.put("id", request.getParameter("ClassId"));
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(doc));
       
       
   }

catch (SQLException e) {
 e.printStackTrace();
 
  }finally{

}
	
			}// end of else to check admin
		
		
		}// end of login check
		 
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
