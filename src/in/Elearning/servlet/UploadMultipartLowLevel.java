package in.Elearning.servlet;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PartETag;

import com.amazonaws.services.s3.model.UploadPartRequest;

import in.Elearning.java.S3;




/**
 * Servlet implementation class UploadMultipartLowLevel
 */
@WebServlet("/UploadMultipartLowLevel")
public class UploadMultipartLowLevel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	
	   	//String UPLOAD_DIRECTORY = "c:"+File.separator+"uploads"+File.separator+(String) request.getSession(false).getAttribute("USERID")+File.separator+(String) request.getSession(false).getAttribute("CLASSID")+File.separator+"uploadedItems";
	   	//String UPLOAD_DIRECTORY = (String) request.getSession(false).getAttribute("CLASSID")+File.separator+"uploadedItems";
	String bucketName="studyfromwebvideos";
			 String fileName="" ;
			// String fileNameUnique="";
	     //  String filePath="" ;
	       String topic="";
			 String subtopic="";
			 String filePathDatabase="";
			int flag0=0;
			//int flag1=1;
			//PrintWriter out=response.getWriter();
			long id=0;
			
		


	//checks if the request actually contains upload file with topic
	if (!ServletFileUpload.isMultipartContent(request) ) {
	  // if not, we stop here
		RequestDispatcher dispatcher = request.getRequestDispatcher("/MyclassroomFetcher_reloader1");
	dispatcher.forward(request,response);
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
	//String uploadPath = getServletContext().getRealPath("")
	   //   +  File.separator+ UPLOAD_DIRECTORY;
	//out.println(uploadPath);




	//creates the directory if it does not exist
	/*   File uploadDir = new File(UPLOAD_DIRECTORY );
	if (!uploadDir.exists()) {
	  uploadDir.mkdirs();
	} */
	//S3 s3=new S3();
	//AmazonS3 s3client =s3.GetamazonS3Client();
	//s3.createFolder(bucketName, UPLOAD_DIRECTORY, s3client);

	try {
	  // parses the request's content to extract file data
		  List<FileItem> formItems = upload.parseRequest(request);

	  if (formItems != null && formItems.size() > 0) {
	      // iterates over form's fields
	      for (FileItem item : formItems) {
	 
	      	if (item.isFormField()) {
	      	    String dummy = item.getFieldName();
	      	    if(dummy.equals("topic")){
	      	     topic = item.getString();
	      	    
	      	}else subtopic=item.getString();
	      	
	      	}
	      	
	      	
	      	
	      	
	          // processes only fields that are not form fields
	          if (!item.isFormField()) {
	       	   
	       	  
	               fileName = new File(item.getName()).getName();
	               
	             
	               String extension = FilenameUtils.getExtension(fileName);
	               
	               
	          /*     try {
	           		
	          		 ps = con.prepareStatement("INSERT INTO fileuploaded (topic,subtopic,Class_Id,Filename) VALUES(?,?,?,?)"); 
	          		 ps.setString(1, topic);
	          		 ps.setString(2, subtopic);
	          		
	          		 ps.setString(3,(String) request.getSession(false).getAttribute("CLASSID") );
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
	               filePathDatabase=(String) request.getSession(false).getAttribute("CLASSID")+"/"+"uploadedItems" +"/"+ fileNameUnique;
	               

	           /*   File storeFile = new File(filePath);
	             // out.println( fileName);
	              // saves the file on disk
	              item.write(storeFile);
	              flag0=1;   */
	               
	            final   PrintWriter out = response.getWriter();
	            
	               ObjectMetadata omd = new ObjectMetadata();
	               omd.setContentType(item.getContentType());
	               omd.setContentLength(item.getSize());
	               S3 s3=new S3();
	               out.println(item.getContentType());
	               InputStream is=item.getInputStream();
	             
	              // BasicAWSCredentials s3Client =s3.credentialsProvider();
	               //BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJ4AMNFNAQMBF52QQ","G33HDL3yxZzoS9Y+Kb2xplhNHbRJ2z4G24qWBQWt" );
	              // AmazonS3Client s3Client = new AmazonS3Client(credentials);
	               AmazonS3Client s3Client =s3.GetamazonS3Client();
	            /*   
	               putObjectRequest.setProgressListener(new ProgressListener() {
	       			@Override
	       			public void progressChanged(ProgressEvent progressEvent) {
	       			 
	       				out.println("Transferred bytes: " + 
	       						progressEvent.getBytesTransfered());   
	       			}
	       		}); */
	               
	          
	             //  AmazonS3 s3Client =s3.GetamazonS3Client();
	               
	               
	            // Create a list of UploadPartResponse objects. You get one of these
	               // for each part upload.
	               List<PartETag> partETags = new ArrayList<PartETag>();

	               // Step 1: Initialize.
	               InitiateMultipartUploadRequest initRequest = new 
	                    InitiateMultipartUploadRequest(bucketName, fileName);
	               out.println("0");
	               out.println(s3Client.doesBucketExist(bucketName));
	               InitiateMultipartUploadResult initResponse = 
	               	                   s3Client.initiateMultipartUpload(initRequest);
	               out.println("1");
	              
	               long contentLength = item.getSize();
	               long partSize = 5242880; // Set part size to 5 MB.
	               out.println("2");
	               try {
	                   // Step 2: Upload parts.
	            	  
	                   long filePosition = 0;
	                   for (int i = 1; filePosition < contentLength; i++) {
	                       // Last part can be less than 5 MB. Adjust part size.
	                	   out.println("3");
	                   	partSize = Math.min(partSize, (contentLength - filePosition));
	                    out.println("4");
	                       // Create request to upload a part.
	                       UploadPartRequest uploadRequest = new UploadPartRequest()
	                           .withBucketName(bucketName).withKey(fileName)
	                           .withUploadId(initResponse.getUploadId()).withPartNumber(i)
	                           .withFileOffset(filePosition).
	                           withInputStream(is)
	                           .withPartSize(partSize);
	                      
                          out.println(i);
	                       // Upload part and add response to our list.
	                       partETags.add(
	                       		s3Client.uploadPart(uploadRequest).getPartETag());

	                       filePosition += partSize;
	                   }

	                   // Step 3: Complete.
	                   CompleteMultipartUploadRequest compRequest = new 
	                                CompleteMultipartUploadRequest(
	                                		bucketName, 
	                                		fileName, 
	                                           initResponse.getUploadId(), 
	                                           partETags);

	                   s3Client.completeMultipartUpload(compRequest);
	               } catch (Exception e) {
	            	   out.println("s3Client.abortMultipartUpload");
	                   s3Client.abortMultipartUpload(new AbortMultipartUploadRequest(
	                		   bucketName, fileName, initResponse.getUploadId()));
	               }
	               
	               
	               
	     
	               
	               
	               
	               
	               
	               
	               
	          }
	      }
	  }
	} catch (Exception ex) {
	  
	}
		
		}

		
	}

}

