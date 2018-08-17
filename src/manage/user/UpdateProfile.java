package manage.user;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.imgscalr.Scalr;
import org.imgscalr.Scalr.Mode;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.google.gson.Gson;

import fetch.user.Dao_Fetch_User_Details;
import in.Elearning.java.DbConnection;
import in.Elearning.java.S3;
import structure.user.Update_user;




/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int i;
	// upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		 DbConnection dbc=new DbConnection(); 
		  Connection con =dbc.getMysqlConnection();
		  PreparedStatement ps=null ;
		String UPLOAD_DIRECTORY = (String) request.getSession(false).getAttribute("USERID");
		
		 String fileName="" ;
        String filePath="" ;
        Dao_Fetch_User_Details dao=new Dao_Fetch_User_Details();
      
        Update_user user= dao.fetchUserDetails1( (String) request.getSession(false).getAttribute("USERID"));
        String profilePicPathDatabase=user.getProfilePic();
		 String proofPathDatabase=user.getProof();
		String foi1=user.getFoi1();
		String foi2=user.getFoi2();
		String foi3=user.getFoi3();
		String toi1=user.getToi1();
		String toi2=user.getToi2();
	
		String phone =user.getPhone();
		String write_about=user.getWrite_about();
		
		String city=user.getCity(); 
		int countfoi=1;
		int counttoi=1;
		String Username=user.getFullname();
		String institution="";
		//PrintWriter out=response.getWriter();
		
//checks if the request actually contains upload file with topic
if (!ServletFileUpload.isMultipartContent(request) ) {
   // if not, we stop here
	 Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "false");
		doc.put("error message", "either not login or you have not permission for this operation");
		response.setContentType("application/json"); 
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));
//out.println("request.getParameter(isPic)");
   
}
else{
//configures upload settings
DiskFileItemFactory factory = new DiskFileItemFactory();
//sets memory threshold - beyond which files are stored in disk
factory.setSizeThreshold(MEMORY_THRESHOLD);
//sets temporary location to store files
factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

ServletFileUpload upload = new ServletFileUpload(factory);

//sets maximum size of upload file
upload.setFileSizeMax(MAX_FILE_SIZE);

//sets maximum size of request (include file + form data)
upload.setSizeMax(MAX_REQUEST_SIZE);

//constructs the directory path to store upload file
//this path is relative to application's directory
//String uploadPath = getServletContext().getRealPath("") + File.separator   +UPLOAD_DIRECTORY ;
//out.println(uploadPath);
//creates the directory if it does not exist
/*File uploadDir = new File(UPLOAD_DIRECTORY);
if (!uploadDir.exists()) {
   uploadDir.mkdirs();
}
*/
try {
   // parses the request's content to extract file data
	  List<FileItem> formItems = upload.parseRequest(request);
	 
   if (formItems != null && formItems.size() > 0) {
       // iterates over form's fields
       for (FileItem item : formItems) {
           // processes only fields that are not form fields
    	  
       if (item.isFormField()) {
       	    String dummy = item.getFieldName();
       	// out.println( dummy ); working fine
       	    if(dummy.equals("FOI")){
       	    	
       	    	if(countfoi==1){
       	    		
       	    		if(item.getString().equals("")||item.getString().equals(null)){
       	    			
       	    			foi1=user.getFoi1();
       	    		}else{
       	    			
       	    			foi1=item.getString();	
       	    		}
       	    	
       	    	countfoi++;
       	    	
       	    	}else if(countfoi==2){
if(item.getString().equals("")||item.getString().equals(null)){
       	    			
       	    			foi2=user.getFoi2();
       	    		}else{
       	    			foi2=item.getString();	
       	    		}
           	    	
           	    	countfoi++;
           	    	
           	    	}else if(countfoi==3){
           	    		if(item.getString().equals("")||item.getString().equals(null)){
           	    			
           	    			foi3=user.getFoi3();
           	    		}else{
           	    			foi2=item.getString();
               	    	
               	    	
           	    	}
           	    		countfoi++;
       	}
       	    }  	
       	    
       	 if(dummy.equals("TOI")){
       		if(counttoi==1){
       			if(item.getString().equals("")||item.getString().equals(null)){
   	    			
   	    			toi1=user.getToi1();
   	    		}else{
   	    			toi1=item.getString();
       	    	
       	    	
   	    	}
       	    	counttoi++;
       	    	
       	    	}else if(counttoi==2){
       	    		if(item.getString().equals("")||item.getString().equals(null)){
       	    			
       	    			toi2=user.getToi2();
       	    		}else{
       	    			toi2=item.getString();
           	    	
           	    	
       	    	}
           	    	counttoi++;
           	    	
           	    	}
        	    
        	}
        	
       	if(dummy.equals("name")){
       		if(item.getString().equals("")||item.getString().equals(null)){
	    			
       			Username=user.getFullname();
	    		}else{
	    			
	    			Username = item.getString();
	      	    	// request.getSession(false).setAttribute("USERNAME",Username);
   	    	
	    	}
    	    
    	    	
    	    	
    	    
    	}
    	
       	
    	if(dummy.equals("institution")){
    	   
    		if(item.getString().equals("")||item.getString().equals(null)){
    			institution=user.getInstitution();
       			
	    		}else{
	    			
	    			institution = item.getString();
   	    	
	    	}
    	    	
    	    	
    	    
    	}
     	   
    	
    	
    	
    	
     	
    	if(dummy.equals("phone")){
    	   
    		if(item.getString().equals("")||item.getString().equals(null)){
    			phone=user.getPhone();
       			
	    		}else{
	    			
	    			phone= item.getString();
   	    	
	    	}
    	    	
    	    	
    	    
    	}
    	
    	
    	
    	
    	if(dummy.equals("write_about")){
     	   
    		if(item.getString().equals("")||item.getString().equals(null)){
    			write_about=user.getWrite_about();
       			
	    		}else{
	    			
	    			write_about= item.getString();
   	    	
	    	}
    	    	
    	    	
    	    
    	}
    	
    	
    	
    	if(dummy.equals("current_city")){
      	   
    		if(item.getString().equals("")||item.getString().equals(null)){
    			city=user.getCity();
       			
	    		}else{
	    			
	    			city= item.getString();
   	    	
	    	}
    	    	
    	    	
    	    
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
       	     	}// if checking for formfield
       	
       	
       	
       else  if (!item.isFormField()) {
        	     fileName = new File(item.getName()).getName();
                String dummy=item.getFieldName();
              filePath = UPLOAD_DIRECTORY + "/"+ fileName;
              // File storeFile = new File(filePath);
             //  out.println( fileName);
               // saves the file on disk
               if(fileName.equals("")||fileName.equals(null)){
            	   
               }
               else{
            	   if(dummy.equals("file-1[]")){
            	  // item.write(storeFile);

                       
                       String bucketName="studyfromwebuserinfo";
                       ObjectMetadata omd = new ObjectMetadata();
                       omd.setContentType(item.getContentType());
                       omd.setContentLength(item.getSize());
                       
                       String extension = FilenameUtils.getExtension(fileName);

                       
                     
                       File outfile = new File(fileName);
                      BufferedImage image = javax.imageio.ImageIO.read(item.getInputStream());  
                     BufferedImage scaledImg = Scalr.resize(image, Scalr.Method.AUTOMATIC,Mode.AUTOMATIC, 600, 600);
                      ImageIO.write( scaledImg, extension, outfile);
               
                       
                       
                       
                      S3 s3=new S3();
                   profilePicPathDatabase=s3.getUlrPrefix()+"/"+bucketName+"/"+(String) request.getSession(false).getAttribute("USERID")+"/"+ fileName;
                 
                   AmazonS3 s3client =s3.GetamazonS3Client1(); 
                   
                   // BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJ4AMNFNAQMBF52QQ","G33HDL3yxZzoS9Y+Kb2xplhNHbRJ2z4G24qWBQWt" );
                  //  AmazonS3Client s3client = new AmazonS3Client(credentials);
                     
                   //   filePathDatabase=s3.getUlrPrefix()+"/"+bucketName+"/"+(String) request.getSession(false).getAttribute("CLASSID")+"/"+"Questions" + "/" + fileNameUnique;
                    
           		  try {
           			
           		//	s3client.putObject(new PutObjectRequest( bucketName,  filePath ,item.getInputStream(),omd).withCannedAcl(CannedAccessControlList.PublicRead));
           			
           			
           			s3client.putObject(new PutObjectRequest( bucketName,  filePath ,outfile).withCannedAcl(CannedAccessControlList.PublicRead));
           		
           			// filePathDatabase=s3client.getResourceUrl( bucketName,  filePath);
           			
                  } catch (AmazonClientException amazonClientException) {
                   /* out.println("Unable to upload file, upload was aborted.");
                    out.println("exception inside upload.waitForCompletion"+amazonClientException);
                    out.println("error message"+amazonClientException.hashCode());
                    out.println("error message"+amazonClientException.getStackTrace().toString());
                    out.println("error message"+amazonClientException.getMessage());  */
                    }
                   
                   
                  
            	   }
            	   else if(dummy.equals("file-2[]")){
            		 //  item.write(storeFile);

                       
                       String bucketName="studyfromwebuserinfo";
                       ObjectMetadata omd = new ObjectMetadata();
                       omd.setContentType(item.getContentType());
                       omd.setContentLength(item.getSize());
                       
                       String extension = FilenameUtils.getExtension(fileName);
                       File outfile = new File(fileName);
                       BufferedImage image = javax.imageio.ImageIO.read(item.getInputStream());  
                      BufferedImage scaledImg = Scalr.resize(image, Scalr.Method.AUTOMATIC,Mode.AUTOMATIC, 600, 600);
                       ImageIO.write( scaledImg, extension, outfile);
                       
                       
                       
                       S3 s3=new S3();
                	   proofPathDatabase=s3.getUlrPrefix()+"/"+bucketName+"/"+(String) request.getSession(false).getAttribute("USERID")+"/"+ fileName;

                       
                      
                       
                	 
                	   AmazonS3 s3client =s3.GetamazonS3Client1(); 
                       
                       // BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJ4AMNFNAQMBF52QQ","G33HDL3yxZzoS9Y+Kb2xplhNHbRJ2z4G24qWBQWt" );
                      //  AmazonS3Client s3client = new AmazonS3Client(credentials);
                         
                       //   filePathDatabase=s3.getUlrPrefix()+"/"+bucketName+"/"+(String) request.getSession(false).getAttribute("CLASSID")+"/"+"Questions" + "/" + fileNameUnique;
                        
               		  try {
               			
               		//	s3client.putObject(new PutObjectRequest( bucketName,  filePath ,item.getInputStream(),omd).withCannedAcl(CannedAccessControlList.PublicRead));
               			
               			
               			s3client.putObject(new PutObjectRequest( bucketName,  filePath ,outfile).withCannedAcl(CannedAccessControlList.PublicRead));
               		
               			// filePathDatabase=s3client.getResourceUrl( bucketName,  filePath);
               			
                      } catch (AmazonClientException amazonClientException) {
                       /* out.println("Unable to upload file, upload was aborted.");
                        out.println("exception inside upload.waitForCompletion"+amazonClientException);
                        out.println("error message"+amazonClientException.hashCode());
                        out.println("error message"+amazonClientException.getStackTrace().toString());
                        out.println("error message"+amazonClientException.getMessage());  */
                        }
                	  
                	   
            	   }
               }
              
           }
       }// end of for loop
   }// end of if conditions checking for null of form content
} // end of try
catch (Exception ex) {
   
}

//out.println( Username ); 
	}// end of if




	
	try {
		
		 ps = con.prepareStatement("UPDATE user_details SET foi1 = ?, foi2 = ? ,foi3 = ?,	toi1=?,	toi2=?,	profilepic=?,proof=? ,fullname=?,institution=?,phone=?,write_about=?,city=? WHERE user_id = ?"); 
		 ps.setString(1, foi1);
		 ps.setString(2, foi2);
		 ps.setString(3,  foi3);
		 ps.setString(4,toi1);
		 ps.setString(5, toi2);
		 ps.setString(6,profilePicPathDatabase );
		 ps.setString(7,proofPathDatabase );
		 ps.setString(8, Username);
		 ps.setString(9, institution);
		 ps.setString(10, phone);
		 ps.setString(11, write_about);
		 ps.setString(12, city);
		 ps.setString(13, (String) request.getSession(false).getAttribute("USERID"));
		  i=ps.executeUpdate();
		  if(i==1){
			
			user.setProfilePic(profilePicPathDatabase);
			 user.setProof( proofPathDatabase);
			user.setFoi1(foi1);
			user.setFoi2(foi2);
			user.setFoi3(foi3);
			
			user.setToi1(toi1);
			user.setToi2(toi2); 
			user.setInstitution(institution);
			user.setFullname(Username );
			user.setCity(city);
			user.setPhone(phone);
			user.setProfilePic(proofPathDatabase);
			user.setProof(proofPathDatabase);
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "true");
			
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(user));
		  }else{
			  Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "false");
				doc.put("error message", "either not login or you have not permission for this operation");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		  }
		
	}
	 catch (SQLException e) {
		e.printStackTrace();
	}
	
	 try {
   	  ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}// end of post
}//end of servlet
