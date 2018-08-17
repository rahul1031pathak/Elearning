package manage.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import in.Elearning.java.Counting;

import in.Elearning.java.DbConnection;



/**
 * Servlet implementation class Class_Deletor
 */
@WebServlet("/Class_Deletor")
public class Class_Deletor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if( request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&&request.getParameter("ClassId")!=null ){
			ArrayList<String> classPrivacy=new ArrayList<String>();
			
			Fetch_CLass_Content Classroomfetch=new Fetch_CLass_Content();
			
			classPrivacy=Classroomfetch.FetchClassPrivacy(request.getParameter("ClassId"));
			 String classAdmin=classPrivacy.get(5);
			 int count =Integer.parseInt(classPrivacy.get(9));
			 Classroomfetch.connClose();
			 
			if( classAdmin.equals((String) request.getSession(false).getAttribute("USERID"))){	
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		   PreparedStatement ps=null;
		String id=request.getParameter("ClassId");
		
		
		 try {
           
                   
			 con.setAutoCommit(false);
							ps = con.prepareStatement("DELETE FROM subscriber_table WHERE class_id=?");
							ps.setString(1, id );
						        ps.executeUpdate();
             ps = con.prepareStatement("DELETE FROM questioninwritten WHERE class_id=?");
             ps.setString(1, id );
       ps.executeUpdate();
       
       
       ps = con.prepareStatement("DELETE FROM notification WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       
       ps = con.prepareStatement("DELETE FROM notice_board WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       ps = con.prepareStatement("DELETE FROM membership_table WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       ps = con.prepareStatement("DELETE FROM membership_req WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       ps = con.prepareStatement("DELETE FROM fileuploaded WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       ps = con.prepareStatement("DELETE FROM answerintext WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       ps = con.prepareStatement("DELETE FROM  classroom_details WHERE class_id=?");
       ps.setString(1, id );
       ps.executeUpdate();
       
       
       Counting counting=new Counting();
	     
counting.DecreaseNumberOfFollowers((String) request.getSession(false).getAttribute("USERID"),count);
		 counting.DecreaseClassCount((String) request.getSession(false).getAttribute("USERID"));
		 counting.connClose();
       
      

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
	try {
		con.rollback();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 e.printStackTrace();
  }finally{
	
}
		
		
		

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
		
		}// end of if to check class is not null	
			
			else{
			      
		    	 Map<String, String> doc=new HashMap<String, String>();
					Gson gson=new Gson();
					doc.put("b", "true");
					
					response.setContentType("application/json"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write(gson.toJson(doc));
			}
			
			
		}// end of if to check login status
		
		else{
		      
	    	 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "flase");
				doc.put("error message", "either not login or you have not permission for this operation");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
