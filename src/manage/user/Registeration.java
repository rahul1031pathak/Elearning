package manage.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import in.Elearning.java.DbConnection;
import in.Elearning.java.EncoderDecoder;


/**
 * Servlet implementation class Registeration
 */
@WebServlet("/Registeration")
public class Registeration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		if(request.getParameter("fullname")!=null&& request.getParameter("email")!=null&&request.getParameter("password")!=null ){
			
		DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null;
		int i;
		boolean b;
		 Dao_User_Registration registeration=new Dao_User_Registration();
		b=registeration.verifyUserIsUnique(request.getParameter("email"));
		registeration.connClose();
		if(b){
		 
		 try {
				
				 ps = con.prepareStatement("INSERT INTO user_details (fullname,email,password,profilepic,proof) VALUES(?,?,?,?,?)"); 
				 ps.setString(1, request.getParameter("fullname"));
				 ps.setString(2, request.getParameter("email"));
				 ps.setString(3, request.getParameter("password"));
				 ps.setString(4, "https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/profile-placeholder.gif");
				 ps.setString(5, "https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/profile-placeholder.gif");
				  i=ps.executeUpdate();
				  if(i==1){
		 //if user has registered successfully then we have to create session and fetch his class details just as in login process
					  
					 // EncoderDecoder encoderdecode =new EncoderDecoder();
					  try {
					String encrypted =EncoderDecoder.encrypt(request.getParameter("email"));
					String subject= "This is verification email from studfromweb";
					String BODY = "<H1>"+" <a href="+"https://www.studyfromweb.com/EmailVerifier?q="+encrypted +">Activate Account</a>"+"</H1>";
					BODY=BODY+"<img src=\"https://s3-ap-southeast-1.amazonaws.com/studyfromwebcontent/verification_email.gif\" height=\"60%\" width=\"80%\">";
					SendVerificationEmail sendVerificationEmail=new SendVerificationEmail(request.getParameter("email"), BODY,subject);
					sendVerificationEmail.sendMail();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
				/*	  HttpSession session=null;
					  User user=null;
					  User_Class_Details ClassDetails;
					  Dao_Fetch_User_Details  userdetails=new Dao_Fetch_User_Details(); 

						user=userdetails.fetchUserDetails(request.getParameter("email"),request.getParameter("password")); //here we fetch all the user details
						String userid=user.getUserId()+"";
						session=request.getSession(true);      // Create a session object if it is already not  created.
						session.setMaxInactiveInterval(-1);
						session.setAttribute("USERNAME",user.getFullname());
						session.setAttribute("USERID",userid);  //till here working fine
						session.setAttribute("FACEBOOKUSERID", "false"); 
						ClassDetails=userdetails.fetchUserAsAdminClassRoomList(user.getUserId()+""); //fetching name and id of all the classroom created by this user
						session.setAttribute("ClassDetails",ClassDetails);
						
						session.setAttribute("USER",user);
						
						
						Member member=new Member();
						member.membershipReqlist= userdetails.fetchUserMembershipRequest(userid);
						
						
						
						ArrayList<String> classIdListSubscribed=new ArrayList<String> ();
						ArrayList<String> classIdListAlreadyMember=new ArrayList<String> ();
						classIdListAlreadyMember=userdetails.fetchClassesAlreadyMember(userid);
						classIdListSubscribed=userdetails.fetchClassIdListSubscribed(userid);
						session.setAttribute("classIdListAlreadyMember",classIdListAlreadyMember.size());  //working fine
						
						member.alreadyMember= userdetails.fetchClassesDetailsAlreadyMember(classIdListAlreadyMember);
						member.alreadySubscribed=userdetails.fetchSubscribedClassesDetails(classIdListSubscribed);
						session.setAttribute("member",member); 
						
						
						Notifications notifications1=new Notifications();
			            //ArrayList<Notification> notifications=new ArrayList<Notification>();
			             notifications1.notifications=userdetails.fetchNotifications(userid);
			             session.setAttribute("notifications", notifications1);
			             session.setAttribute("ISLOGIN", "true"); 
			             userdetails.connClose();  */
			             
			             
			             
				  response.setContentType("text/html"); 
				    response.setCharacterEncoding("UTF-8");
					response.getWriter().write("true");
				  }
				
			} 
			 catch (SQLException e) {
				e.printStackTrace();
			}finally{
				
			}
		 try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else{
			response.setContentType("text/html"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
		}
		
		 try {
	    	 
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		
	
		else{
			response.setContentType("text/html"); 
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write("false");
		}
	}

}
