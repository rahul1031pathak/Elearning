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


/**
 * Servlet implementation class Delete_FileUploaded
 */
@WebServlet("/Delete_FileUploaded")
public class Delete_FileUploaded extends HttpServlet {
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
		if( request.getSession(false).getAttribute("ISLOGIN")!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")){

		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
	      PreparedStatement ps;
		
		String fileid=request.getParameter("fileId").trim();
    	
			
    	  
    			 try {
    		            
                     
 							ps = con.prepareStatement("DELETE FROM fileuploaded WHERE class_id=? AND File_Id=?");
 							ps.setString(1, request.getParameter("ClassId"));
 							ps.setString(2, fileid);
 						        ps.executeUpdate();
 						      
 			ps.close();
 		
        
        
    }

 catch (SQLException e) {
  e.printStackTrace();
   }finally{

 }
 		
    		try {
  	    	 // ps.close();
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
			
		}
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
