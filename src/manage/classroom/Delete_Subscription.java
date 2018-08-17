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
 * Servlet implementation class Delete_Subscription
 */
@WebServlet("/Delete_Subscription")
public class Delete_Subscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){
		
			 DbConnection dbc=new DbConnection(); 
			  Connection con =dbc.getMysqlConnection();
			Validation validation=new Validation();
			String userid="";
			boolean check_admin=	validation.Is_Class_Admin((String)request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));
			boolean check_member=	validation.can_delete_subscribtion((String)request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"));

			validation.connClose(); 
			

			if(check_admin&&request.getParameter("userId")!=null){userid=request.getParameter("userId");}	
			if(check_member){userid=(String)request.getSession(false).getAttribute("USERID");}
			if(!check_admin&&!check_member){  
				 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "false");
				
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
			
			
			
			else{		try {
            
                    PreparedStatement ps;
                    
							ps = con.prepareStatement("DELETE FROM subscriber_table WHERE class_id=? AND user_id=?");
							ps.setString(1, request.getParameter("ClassId"));
							ps.setString(2,  userid);
						        ps.executeUpdate();
						        Counting counting=new Counting();
						      String id=  counting.DecreaseNumberOfSubscriber(request.getParameter("ClassId"));
         counting.DecreaseNumberOfFollowers(id);
         counting.connClose();
if(ps!=null){
	ps.close();
}

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
		
		
			} // end of else to check admin
			
			
		 try {
	    	// System.out.println("closing connection"); 
			 if(con!=null){
				 con.close(); 
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
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
