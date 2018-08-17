package in.Elearning.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.Elearning.java.SearchByName;
import in.Elearning.java.SearchEngine;
import structure.classroom.FinalClassList;
/**
 * Servlet implementation class Search
 */        
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	String filter=request.getParameter("SelectFilter");	
	
	if(filter.equals("TeacherName")){
		
		ArrayList<String> idlist=new ArrayList<String>();
		
		SearchByName sbn=new SearchByName();
		idlist=sbn.fetchTeacherClassIdListByTeacherName(request.getParameter("searchbox"));
		FinalClassList list=new FinalClassList();
		SearchEngine se=new SearchEngine();
		list.userlistSearch=se.fetchUserDetailsByUserIdList(idlist)  ;
		list.classdetailsWithTeacherId=sbn.fetchClassDetailsByGivenIdsList(idlist);
	
		request.setAttribute("list", list );
	sbn.connClose();
	se.connClose();
		RequestDispatcher rd=request.getRequestDispatcher("ClassRoomListOfGivenTeacherName.jsp");
		rd.forward(request, response);
	}
	
	else if(filter.equals("Institution")){
		ArrayList<String> idlist=new ArrayList<String>();
		SearchEngine se=new SearchEngine();
		FinalClassList list=new FinalClassList();
		idlist= se.fetchTeacherClassIdListByInstitutionName(request.getParameter("searchbox"))  ;
	
		list.userlistSearch=se.fetchUserDetailsByUserIdList(idlist)  ;
		list.classdetailsWithTeacherId=se.fetchClassDetailsByGivenIdsList(idlist);
		
		se.connClose();
		
		request.setAttribute("list", list );
		RequestDispatcher rd=request.getRequestDispatcher("ClassRoomListOfGivenTeacherName.jsp");
		rd.forward(request, response);
		
		
	}
	
	else if(filter.equals("Email")){
		
		SearchEngine se=new SearchEngine();
		FinalClassList list=new FinalClassList();
		
	
		list.userlistSearch=se.fetchUserDetailsByUserEmail(request.getParameter("searchbox"))  ;
		if(!list.userlistSearch.isEmpty()){
			list.classdetailsWithTeacherId=se.fetchClassDetailsByEmail(list.userlistSearch.get(0).getUserId());
		}
		
		
		
		se.connClose();
		
		request.setAttribute("list", list );
		RequestDispatcher rd=request.getRequestDispatcher("ClassRoomListOfGivenTeacherName.jsp");
		rd.forward(request, response);
	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
