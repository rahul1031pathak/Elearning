package in.Elearning.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import in.Elearning.java.SearchByName;
import in.Elearning.java.SearchEngine;
import structure.classroom.FinalClassList;

/**
 * Servlet implementation class Search_Teacher_Classroom_By_Teacher_Name
 */
@WebServlet("/Search_Teacher_Classroom_By_Teacher_Name")
public class Search_Teacher_Classroom_By_Teacher_Name extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ArrayList<String> idlist=new ArrayList<String>();
			
		SearchByName sbn=new SearchByName();
		SearchEngine se=new SearchEngine();
		idlist=sbn.fetchTeacherClassIdListByTeacherName(request.getParameter("TeacherName"));
		FinalClassList list=new FinalClassList();
		list.userlistSearch=se.fetchUserDetailsByUserIdList(idlist);
		list.classdetailsWithTeacherId=sbn.fetchClassDetailsByGivenIdsList(idlist);
		sbn.connClose();
		se.connClose();
		request.getSession(false).setAttribute("list", list );

		   Gson gson=new Gson();
			
			response.setContentType("application/json"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(gson.toJson(list));
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
