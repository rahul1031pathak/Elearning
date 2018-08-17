package fetch.classroom;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

import in.Elearning.java.DbConnection;
import in.Elearning.java.S3;

/**
 * Servlet implementation class FileFetcher
 */
@WebServlet("/FileFetcher")
public class FileFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
	int i;
	 
	 private static final int BUFSIZE = 4096;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
        
		      
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bucketName="studyfromwebclasscontent";
		// PrintWriter out=response.getWriter();
	       // out.println("mimeType");
	        
	        
			 // get upload id from URL's parameters
	     
	       try {
				
				 PreparedStatement ps = con.prepareStatement("SELECT  * FROM fileuploaded WHERE File_Id=?");
				 ps.setString(1,request.getParameter("FileId") );
				 ResultSet rs = ps.executeQuery();
				 if(rs.next()){	
					 // gets file name and file blob data
				 String filename=rs.getString(5);
					 String fileKey=rs.getString(3);
					
				//String	 filePath = getServletContext().getRealPath( rs.getString(3))  ;
				// File file = new File(filePath);
				    int length   = 0;
				  //  ServletOutputStream outStream = response.getOutputStream();
				  //  ServletContext context  = getServletConfig().getServletContext();
				  //  String mimetype = context.getMimeType(filePath);

				    // sets response content type
				  //  if (mimetype == null) {
				  //      mimetype = "application/octet-stream";
				   // }
				   // response.setContentType(mimetype);
				   // response.setContentLength((int)file.length());
				   // String fileName = (new File(filePath)).getName();

				    // sets HTTP header
				    
				    InputStream inputStream=null;
				    S3 s3=new S3();
				    AmazonS3 s3client =s3.GetamazonS3Client();
				   
				    try {
		 	        	//out.print("inside try");
		 	        	  GetObjectRequest request1 = new GetObjectRequest(bucketName,fileKey);
		 	        	// out.print("bucket and key getobject req sucees");
	 	      
	 	         S3Object object = s3client.getObject(request1);
	 	      //  out.print("Downloading an object success");
	 	       inputStream = object.getObjectContent();
	 	     // out.print("inputStream  success");
	 	   //  response.getWriter().print("Content-Type: "  + object.getObjectMetadata().getContentType());
	            response.setContentType(object.getObjectMetadata().getContentType());
	           response.setContentLength((int)object.getObjectMetadata().getContentLength());
	           response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
	           ServletOutputStream outStream = response.getOutputStream();
	 	     DataInputStream in = new DataInputStream(inputStream);//exception will occur as we have fetched response.getwriter earlier 
	 	    // int length=0;
	            byte[] byteBuffer = new byte[BUFSIZE];
	            while ((in != null) && ((length = in.read(byteBuffer)) != -1))
	            {
	                outStream.write(byteBuffer,0,length);
	            }
	            in.close();
	            outStream.close();
	         //   out.print("just before catch");
		 	           } catch (AmazonServiceException ase) {
		 	        	  response.getWriter().print("Caught an AmazonServiceException, which" +
		 		            		" means your request made it " +
		 		                    "to Amazon S3, but was rejected with an error response" +
		 		                    " for some reason.");
		 		        	 response.getWriter().print("Error Message:    " + ase.getMessage());
		 		        	 response.getWriter().print("HTTP Status Code: " + ase.getStatusCode());
		 		        	 response.getWriter().print("AWS Error Code:   " + ase.getErrorCode());
		 		        	 response.getWriter().print("Error Type:       " + ase.getErrorType());
		 		        	 response.getWriter().print("Request ID:       " + ase.getRequestId());
		 	        }
		 	        
		 	        catch (AmazonClientException ace) {
		 	        	 response.getWriter().println("Caught an AmazonClientException, which means"+
		 	            		" the client encountered " +
		 	                    "an internal error while trying to " +
		 	                    "communicate with S3, " +
		 	                    "such as not being able to access the network.");
		 	        	 response.getWriter().println("Error Message: " + ace.getMessage());
		 	        }

		 	       catch (Exception ex) {
		 	    	  response.getWriter().println("message File Upload Failed due to " + ex.getLocalizedMessage());
		 	    	 response.getWriter().println("message File Upload Failed due to " + ex.getStackTrace().toString());
		            }   
		 	 
		                         
		            } else {
		                // no file found
		               // response.getWriter().print("File not found for the id: " );  
		            }
						
					}
	       catch (SQLException ex) {
	           ex.printStackTrace();
	           //response.getWriter().print("SQL Error: " + ex.getMessage());
	       } catch (IOException ex) {
	           ex.printStackTrace();
	           //response.getWriter().print("IO Error: " + ex.getMessage());
	       } 
		
        
        

	}//do post method ending

}//servlet class ending
