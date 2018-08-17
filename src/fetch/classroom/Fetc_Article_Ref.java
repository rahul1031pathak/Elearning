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
import structure.refrence.Article_Ref_Article;
import structure.refrence.Article_Ref_Result;
import structure.refrence.Article_Ref_Video;
import structure.refrence.Ques_Ref_Article;

/**
 * Servlet implementation class Fetc_Article_Ref
 */
@WebServlet("/Fetc_Article_Ref")
public class Fetc_Article_Ref extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		
		 PreparedStatement ps;
		 Article_Ref_Result result=new Article_Ref_Result ();
		 Ques_Ref_Article q;
		 Article_Ref_Article a;
		 Article_Ref_Video v;
		 
		 
		    
		 
		 
		 
		 
		 
		 try {
				ps=con.prepareStatement("SELECT * FROM ref_article_article WHERE article_id_1=? AND class_id=?");
				 ps.setString(1,request.getParameter("article_id") );
				 ps.setString(2,request.getParameter("class_id"));
				 ResultSet rs=  ps.executeQuery();
				 while(rs.next()){
					
					 a=new  Article_Ref_Article(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
					 result.Article_Ref_Article_list.add(a);
				 }
				 
				 
				 
					ps=con.prepareStatement("SELECT * FROM ref_ques_article WHERE article_id=? AND class_id=? ");
					 ps.setString(1,request.getParameter("article_id") );
					 ps.setString(2,request.getParameter("class_id"));
					 rs=  ps.executeQuery();
					while(rs.next()){
						
						 q=new Ques_Ref_Article(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
						 result.Ques_Ref_Article_list.add(q);
					 }
					  
				 
				 
					 
						ps=con.prepareStatement("SELECT * FROM ref_article_video WHERE article_id=? AND class_id=?");
						 ps.setString(1,request.getParameter("artcile_id") );
						 ps.setString(2,request.getParameter("class_id"));
						 rs=  ps.executeQuery();
						 while(rs.next()){
							
							v=new  Article_Ref_Video(rs.getInt(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(2),rs.getTimestamp(6));
							 result.Article_Ref_Video_list.add(v);
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




