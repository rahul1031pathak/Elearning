

package manage.classroom; 

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.google.gson.Gson;

import in.Elearning.java.DbConnection;

import in.Elearning.java.S3;
 
@WebServlet("/uploadServlet")
   
public class FileUploadDBServlet extends HttpServlet {
     
  
	private static final long serialVersionUID = 1L;
	// database connection settings
	   

    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // gets values of text fields
    	
    	
    	
	Authenticate_User_Role_In_Class authentication=new Authenticate_User_Role_In_Class ();
		
		
		if(authentication.Is_Class_Admin((String) request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"))&&
				authentication.Is_Class_subAdmin ((String) request.getSession(false).getAttribute("USERID"), request.getParameter("ClassId"))){
    	
    	
    	
    	
    	
    	
    	 DbConnection dbc=new DbConnection(); 
   	  Connection con =dbc.getMysqlConnection();
   	 PreparedStatement ps=null;
   	int i;
    	
String bucketName="studyfromwebclasscontent";
		 String fileName="" ;
		 String fileNameUnique="";
      //  String filePath="" ;
        String topic="";
        String classId="";
		 String subtopic="";
		 String filePathDatabase="";
		int flag0=0;
		//int flag1=1;
		//PrintWriter out=response.getWriter();
		long id=0;
		
	


//checks if the request actually contains upload file with topic
if (!ServletFileUpload.isMultipartContent(request) ) {

Map<String, String> doc=new HashMap<String, String>();
Gson gson=new Gson();
doc.put("b", "false");

response.setContentType("application/json"); 
response.setCharacterEncoding("UTF-8");
response.getWriter().write(gson.toJson(doc));
   
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


try {
   // parses the request's content to extract file data
	  List<FileItem> formItems = upload.parseRequest(request);

   if (formItems != null && formItems.size() > 0) {
       // iterates over form's fields
       for (FileItem item : formItems) {
    		if (item.isFormField()) {
        	   
        	    if(item.getFieldName().equals("ClassId")){
        	    	classId=item.getString();
        	    }	 
            		
            	}
       	if (item.isFormField()) {
       	    String dummy1 = item.getFieldName();
       	    if(dummy1.equals("topic")){
       	     topic = item.getString();
       	    
       	}else subtopic=item.getString();
       	
       	}
       	
       	
       	
       	
           // processes only fields that are not form fields
           if (!item.isFormField()) {
        	   
        	  
                fileName = new File(item.getName()).getName();
                
              
                String extension = FilenameUtils.getExtension(fileName);
              
                
                try {
            		
           		 ps = con.prepareStatement("INSERT INTO fileuploaded (topic,subtopic,Class_Id,Filename) VALUES(?,?,?,?)"); 
           		 ps.setString(1, topic);
           		 ps.setString(2, subtopic);
           		
           		 ps.setString(3,classId);
           		 ps.setString(4,   fileName);
           		

           		  i=ps.executeUpdate();
           		  
           		 ps.close();
           		  
           		if(i==1){
        			ps=con.prepareStatement("SELECT LAST_INSERT_ID()"); 
        			ResultSet rs=ps.executeQuery();
        				if(rs.next()){
        					id= rs.getLong(1);
        					
        				
        				}
        				
        				
           		}		
           		
           	} 
           	 catch (SQLException e) {
           		e.printStackTrace();
           	}
           	
                
                
                fileNameUnique= id+"."+extension;
            
              //  filePath = UPLOAD_DIRECTORY + File.separator +  fileNameUnique ;
                filePathDatabase=classId+"/"+"uploadedItems" +"/"+ fileNameUnique;
                

                
                PrintWriter out = response.getWriter();
                ObjectMetadata omd = new ObjectMetadata();
                omd.setContentType(item.getContentType());
                omd.setContentLength(item.getSize());
                S3 s3=new S3();
                TransferManager tm= s3.GetTransferManager();
                com.amazonaws.services.s3.transfer.Upload uploadFile = tm.upload(
                		new PutObjectRequest(	bucketName, filePathDatabase,item.getInputStream() ,omd).withCannedAcl(CannedAccessControlList.PublicRead));
     		  try {
            	// Or you can block and wait for the upload to finish
     			 
     			 uploadFile.waitForUploadResult();
     			//upload.addProgressListener(arg0);
     			uploadFile.waitForCompletion();
     			flag0=1;
           
            } catch (AmazonClientException amazonClientException) {
            out.println("Unable to upload file, upload was aborted.");
            out.println("exception inside upload.waitForCompletion"+amazonClientException);
            out.println("error message"+amazonClientException.hashCode());
            out.println("error message"+amazonClientException.getStackTrace().toString());
            out.println("error message"+amazonClientException.getMessage());
            }
           }
       }
   }
} catch (Exception ex) {
   
}
//redirects client to message page




if(flag0==1){
	
	 try {
 		i=0;
   		 ps = con.prepareStatement("UPDATE fileuploaded SET File=? where File_Id=?"); 
   		
   		 ps.setString(1,  filePathDatabase);
   		 ps.setLong(2,  id);
   		  i=ps.executeUpdate();

Map<String, String> doc=new HashMap<String, String>();
Gson gson=new Gson();
doc.put("b", "true");

response.setContentType("application/json"); 
response.setCharacterEncoding("UTF-8");
response.getWriter().write(gson.toJson(doc));
   		
   	} 
   	 catch (SQLException e) {
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



}

		
try {
	 
	con.close();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	
   


		}// end of if admin subadmin check

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
    
    
    
    
    
    
    
    
    
