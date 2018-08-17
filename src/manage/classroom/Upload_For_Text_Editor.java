package manage.classroom;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import in.Elearning.java.S3;

/**
 * Servlet implementation class Upload_For_Text_Editor
 */
@WebServlet("/Upload_For_Text_Editor")
public class Upload_For_Text_Editor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// String UPLOAD_DIRECTORY = (String) request.getSession(false).getAttribute("CLASSID")+File.separator+"Questions";
	  String UPLOAD_DIRECTORY="" ; //String UPLOAD_DIRECTORY = request.getParameter("ClassId")+"/"+"Questions";
		// String filePathDatabase="";
		 String fileName="" ;
        String filePath="" ;
       
		 String fileNameUnique="";
	
		
		if (!ServletFileUpload.isMultipartContent(request) ) {
		    // if not, we stop here
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/MyclassroomFetcher_reloader1");
		//dispatcher.forward(request,response);
			 Map<String, String> doc=new HashMap<String, String>();
				Gson gson=new Gson();
				doc.put("b", "false");
				doc.put("error message", "something went wrong");
				response.setContentType("application/json"); 
			    response.setCharacterEncoding("UTF-8");
				response.getWriter().write(gson.toJson(doc));
		    
		}
		else{
		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// sets memory threshold - beyond which files are stored in disk
		factory.setSizeThreshold(MEMORY_THRESHOLD);
		// sets temporary location to store files
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

		ServletFileUpload upload = new ServletFileUpload(factory);
		 
		// sets maximum size of upload file
		upload.setFileSizeMax(MAX_FILE_SIZE);
		 
		// sets maximum size of request (include file + form data)
		upload.setSizeMax(MAX_REQUEST_SIZE);

	
		try {
			
			 String extension = FilenameUtils.getExtension(fileName);
			
		    // parses the request's content to extract file data
			  List<FileItem> formItems = upload.parseRequest(request);

		    if (formItems != null && formItems.size() > 0) {
		        // iterates over form's fields
		        for (FileItem item : formItems) {
		            // processes only fields that are not form fields
		        	
		        	if (item.isFormField()) {
		        	    String dummy = item.getFieldName();
		        	    if(item.getFieldName().equals("ClassId")){
		        	    	
		            		 UPLOAD_DIRECTORY = item.getString()+"/";
		            		 System.out.println("ClassId"+UPLOAD_DIRECTORY);
		            		  
		            	}
		            	
		        	    if(dummy.equals("type")){
		        	   
		        	    	 UPLOAD_DIRECTORY = UPLOAD_DIRECTORY + item.getString();
		        	    	 System.out.println("type"+UPLOAD_DIRECTORY);
		        	} 
		        	    
		        	}
		        	
		        	
		        
		        	
		            if (!item.isFormField()) {
		                 fileName = new File(item.getName()).getName();
		                

		                 extension = FilenameUtils.getExtension(fileName);
		                 String uniqueID = UUID.randomUUID().toString();
		                 fileNameUnique= uniqueID+"."+extension;
		          
		                 
		                 filePath = UPLOAD_DIRECTORY + "/" + fileNameUnique;
		                 System.out.println("filePath"+filePath);  
		         
		                 String bucketName="studyfromwebclasscontent";
		                 ObjectMetadata omd = new ObjectMetadata();
		                 omd.setContentType(item.getContentType());
		              
		                 omd.setContentLength(item.getSize());
		                 
		      
		                 
		                 
		                  File outfile = new File(fileNameUnique);
		                 
		                 BufferedImage image = javax.imageio.ImageIO.read(item.getInputStream());
		                
		               BufferedImage scaledImg = Scalr.resize(image, Scalr.Method.AUTOMATIC,Mode.AUTOMATIC, 600, 600);
		              
		               ImageIO.write( scaledImg, extension, outfile); 
		              
		               
		                 
		               
		                 S3 s3=new S3();
		             AmazonS3 s3client =s3.GetamazonS3Client1(); 
		            
		         
		      		  try {
		      			
		      		//	s3client.putObject(new PutObjectRequest( bucketName,  filePath ,item.getInputStream(),omd).withCannedAcl(CannedAccessControlList.PublicRead));
		      			
		      		
		      			s3client.putObject(new PutObjectRequest( bucketName,  filePath ,outfile).withCannedAcl(CannedAccessControlList.PublicRead));
		      		
		      			// filePathDatabase=s3client.getResourceUrl( bucketName,  filePath);
		      			
		             } catch (AmazonClientException amazonClientException) {
		    
		            	 Map<String, String> doc=new HashMap<String, String>();
		 				Gson gson=new Gson();
		 				doc.put("b", "false");
		 				doc.put("error message", "something went wrong");
		 				response.setContentType("application/json"); 
		 			    response.setCharacterEncoding("UTF-8");
		 				response.getWriter().write(gson.toJson(doc));
		             }
		                 
		
		            }
		        }
		    }
		} catch (Exception ex) {
		    
		}
	
		Map<String, String> doc=new HashMap<String, String>();
		Gson gson=new Gson();
		doc.put("b", "true");
		doc.put("location", filePath);
		response.setContentType("application/json"); 
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(gson.toJson(doc));

			
	}

}}
