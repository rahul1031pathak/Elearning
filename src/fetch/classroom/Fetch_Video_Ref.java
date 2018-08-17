package fetch.classroom;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import structure.refrence.Article_Ref_Video;
import structure.refrence.Ques_Ref_Video;
import structure.refrence.Video_Ref_Result;
import structure.refrence.Video_Ref_Video;


/**
 * Servlet implementation class Fetch_Video_Ref
 */
@WebServlet("/Fetch_Video_Ref")
public class Fetch_Video_Ref extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		
		 PreparedStatement ps;
		 Video_Ref_Result result=new Video_Ref_Result();
		 Ques_Ref_Video q;
		 Article_Ref_Video a;
		 Video_Ref_Video v;
		 try {
			ps=con.prepareStatement("SELECT * FROM ref_article_video WHERE video_id=? AND class_id=?");
			 ps.setString(1,request.getParameter("video_id") );
			 ps.setString(2,request.getParameter("class_id"));
			 ResultSet rs=  ps.executeQuery();
			 if(rs.next()){
				
				 a=new Article_Ref_Video(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
				 result.Article_Ref_Video_list.add(a);
			 }
			 
			 
			 
				ps=con.prepareStatement("SELECT * FROM ref_video_video WHERE video_id_1=? AND class_id=?");
				 ps.setString(1,request.getParameter("video_id") );
				 ps.setString(2,request.getParameter("class_id"));
				 rs=  ps.executeQuery();
				 if(rs.next()){
					
					v=new Video_Ref_Video(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
					 result.Video_Ref_Video_list.add(v);
				 }
				  
			  
			 
				 
					ps=con.prepareStatement("SELECT * FROM ref_ques_video WHERE video_id=? AND class_id=?");
					 ps.setString(1,request.getParameter("video_id") );
					 ps.setString(2,request.getParameter("class_id"));
					 rs=  ps.executeQuery();
					 if(rs.next()){
						
						q=new  Ques_Ref_Video(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
						 result.Ques_Ref_Video_list .add(q);
					 }
			 
			 
			 
			 
			 
			 
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			Gson gson=new Gson();
			
			response.setContentType("application/json"); 
			   response.setCharacterEncoding("UTF-8");
			  
				response.getWriter().write(gson.toJson(result));
		
	}

	
		
	
	}



