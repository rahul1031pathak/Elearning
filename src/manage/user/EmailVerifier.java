package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fetch.user.Dao_Fetch_User_Details;
import in.Elearning.java.DbConnection;
import in.Elearning.java.EncoderDecoder;
import structure.user.User;


/**
 * Servlet implementation class EmailVerifier
 */
@WebServlet("/EmailVerifier")
public class EmailVerifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null; 
	
		  try {

         
             String s1=request.getQueryString();
            s1=s1.substring(2);
			
		String emaildecoded= EncoderDecoder.decrypt(s1);
	String userid="";
		 ps = con.prepareStatement("UPDATE  user_details SET verify=? WHERE email=?"); 
		 ps.setInt(1,1);
		 ps.setString(2,emaildecoded);
		 ps.executeUpdate();
	
		 ps = con.prepareStatement("SELECT user_id FROM  user_details WHERE email=?"); 
		
		 ps.setString(1,emaildecoded);
		
		
		 ResultSet rs = ps.executeQuery();
		 if(rs.next()){	
			userid=rs.getString(1); 
		 }
		 else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
				dispatcher.forward(request,response);
		 }
		HttpSession session=null;
	
		User user=null;
		Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 

	
		session=request.getSession(true); // Create a session object if it is already not  created.
		//session.setMaxInactiveInterval(-1); 
		user=userdetails.fetchUserDetails(userid);
		session.setAttribute("USER",user);
		session.setAttribute("time",user.getDateTime());
		session.setAttribute("USERNAME",user.getFullname());   
		session.setAttribute("generator_profile_pic",user.getProfilepic());
		session.setAttribute("proof_pic",user.getProof());
		session.setAttribute("USERID",userid);  //till here working fine
		session.setAttribute("FACEBOOKUSERID", "false"); 
		session.setAttribute("institute",user.getInstitution());
		
         session.setAttribute("ISLOGIN", "true"); 
         userdetails.connClose();
         if(ps!=null){
        	 ps.close(); 
         }
         if(con!=null){
        		con.close(); 
         }
 		
 	
         RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
			dispatcher.forward(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
