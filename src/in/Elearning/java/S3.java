package in.Elearning.java;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;

public class S3 {
	
	private static final String SUFFIX = "/";
	//BasicAWSCredentials credentials = new BasicAWSCredentials( "AKIAJ4AMNFNAQMBF52QQ","G33HDL3yxZzoS9Y+Kb2xplhNHbRJ2z4G24qWBQWt" );
//	BasicAWSCredentials credentials = new BasicAWSCredentials( "AKIAJRS2ZOMTT3DYIX6Q","dXO6YjxwCwLgyZm8P1q4c3x1SbtoBwSHejuerSfn" );

	BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAJCMNOGZEPAFQYQFQ","rimqvJz1f4bTD+xCR8Emuh89L3W5FMqbK4NUNgOS" );

	
	public BasicAWSCredentials credentialsProvider(){
		return credentials ;
	}
	
	
	
	
	
	public AmazonS3Client GetamazonS3Client()
	{
		//String bucketName = "learnforfun";
		//BasicAWSCredentials credentials = new BasicAWSCredentials( "AKIAJYQN5YNCDV73CWLA","nZ7z7YQ34VVFh88IcPAnW4e+uiEiQk3Ad858Rbr4" );
		// create a client connection based on credentials
		
		AmazonS3Client s3client = new AmazonS3Client(credentials);
		System.out.println( s3client.getRegion().name());
		System.out.println( s3client.getRegion());
		s3client.setRegion(Region.getRegion(Regions  .AP_SOUTHEAST_1));
		
		//String folderName = "testfolder";
		//create(bucketName, folderName, s3client);
		
		return s3client ;
		
	}
	

	public AmazonS3 GetamazonS3Client1()
	{
		//String bucketName = "learnforfun";
	//	AWSCredentials credentials = new BasicAWSCredentials( "AKIAJ4AMNFNAQMBF52QQ","G33HDL3yxZzoS9Y+Kb2xplhNHbRJ2z4G24qWBQWt" );;
	AWSCredentials credentials = new BasicAWSCredentials( "AKIAJCMNOGZEPAFQYQFQ","rimqvJz1f4bTD+xCR8Emuh89L3W5FMqbK4NUNgOS" );;

		// create a client connection based on credentials
		
		AmazonS3 s3client = new AmazonS3Client(credentials);
	//s3client.setRegion(Region.getRegion(Regions  .AP_SOUTHEAST_1));
		//String folderName = "testfolder";
		//create(bucketName, folderName, s3client);
		
		return s3client ;
		
	}
	
	
	public void createFolder(String bucketName, String folderName, AmazonS3 client) {
		// create meta-data for your folder and set content-length to 0
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentLength(0);
		// create empty content
		InputStream emptyContent = new ByteArrayInputStream(new byte[0]);
		// create a PutObjectRequest passing the folder name suffixed by /
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,
				folderName + SUFFIX, emptyContent, metadata);
		// send request to S3 to create folder
		client.putObject(putObjectRequest);
	}

	public TransferManager GetTransferManager () {
		 TransferManager tm = new TransferManager(credentials);
		 return tm;
	}

	public String getUlrPrefix(){
		return "https://s3-ap-southeast-1.amazonaws.com";
	}
	
	

}
