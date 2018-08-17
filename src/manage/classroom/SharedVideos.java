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
 * Servlet implementation class SharedVideos
 */
@WebServlet("/SharedVideos")
public class SharedVideos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		if(request.getSession(false)!=null &&request.getSession(false).getAttribute("ISLOGIN").equals("true")&& request.getParameter("ClassId")!=null){

		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		  int i;
		
		String is_playlist=request.getParameter("is_playlist");
	
		
		try {
			
			 ps = con.prepareStatement("INSERT INTO shared_videos (shared_videos_id,is_playlist,class_id,Content_Of_Video) VALUES(?,?,?,?)");
				 ps.setString(1, request.getParameter("videoId"));
				 ps.setString(2,  is_playlist);
				  ps.setString(3, request.getParameter("ClassId"));
				 
			  ps.setString(4, request.getParameter("Content_Of_Video"));
				 i=ps.executeUpdate();
				 
				 if(i==1){
					
					
					 Map<String, String> doc=new HashMap<String, String>();
						Gson gson=new Gson();
						doc.put("b", "true");
						
						response.setContentType("application/json"); 
					    response.setCharacterEncoding("UTF-8");
						response.getWriter().write(gson.toJson(doc));
						 try {
					    	  ps.close();
							con.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 }
				 
				 else{
					 Map<String, String> doc=new HashMap<String, String>();
						Gson gson=new Gson();
						doc.put("b", "false");
						response.setContentType("application/json"); 
					    response.setCharacterEncoding("UTF-8");
						response.getWriter().write(gson.toJson(doc));
				 }
				 
			}catch (SQLException e) {
				e.printStackTrace();
			}
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
