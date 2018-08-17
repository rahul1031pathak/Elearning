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
import structure.refrence.Ques_Ref_Article;
import structure.refrence.Ques_Ref_Ques;
import structure.refrence.Ques_Ref_Result;
import structure.refrence.Ques_Ref_Video;

/**
 * Servlet implementation class Fetch_Question_Ref
 */
@WebServlet("/Fetch_Question_Ref")
public class Fetch_Question_Ref extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		
		 PreparedStatement ps;
		 Ques_Ref_Result result=new Ques_Ref_Result();
		 Ques_Ref_Ques q;
		 Ques_Ref_Article a;
		 Ques_Ref_Video v;
		 try {
			ps=con.prepareStatement("SELECT * FROM ref_ques_ques WHERE ques_id_1=? AND class_id=? ");
			 ps.setString(1,request.getParameter("ques_id") );
	 ps.setString(2,request.getParameter("class_id"));
			 ResultSet rs=  ps.executeQuery();
			while(rs.next()){
				
				 q=new Ques_Ref_Ques(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
				 result.Ques_Ref_Ques_list.add(q);
			 }
			 
			 
			 
				ps=con.prepareStatement("SELECT * FROM ref_ques_article WHERE ques_id=? AND class_id=? ");
				 ps.setString(1,request.getParameter("ques_id") );
			 ps.setString(2,request.getParameter("class_id"));
				 rs=  ps.executeQuery();
				while(rs.next()){
					
					 a=new Ques_Ref_Article(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
					 result.Ques_Ref_Article_list.add(a);
				 }
				  
			 
			 
				 
					ps=con.prepareStatement("SELECT * FROM ref_ques_video WHERE ques_id=? AND class_id=?");
					 ps.setString(1,request.getParameter("ques_id") );
				 ps.setString(2,request.getParameter("class_id"));
					 rs=  ps.executeQuery();
					 while(rs.next()){
						
						v=new  Ques_Ref_Video(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
						 result.Ques_Ref_Video_list.add(v);
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
