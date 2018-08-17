package manage.user;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendVerificationEmail {

    static final String FROM = "studyfromweb@studyfromweb.com";   // Replace with your "From" address. This address must be verified.
     // String TO = "rahul1031pathak@gmail.com";  // Replace with a "To" address. If your account is still in the 
                                                       // sandbox, this address must be verified.
    String TO ;
     //String BODY = " <a href="+"www.studyfromweb.com"+">verify</a>";
      String BODY;
      String SUBJECT ;
  
    public SendVerificationEmail(String tO, String bODY,String SUBJECT) {
														
														TO = tO;
														BODY = bODY;
														this.SUBJECT=SUBJECT;
													}

	
    
    // Supply your SMTP credentials below. Note that your SMTP credentials are different from your AWS credentials.
  //  static final String SMTP_USERNAME = "AKIAJ4KLGIA7VSD6TXRQ";  // Replace with your SMTP username.
  //  static final String SMTP_PASSWORD = "AurJFrkyyUSknGEmlB9MLTiryZg//NGbkUOakn9Fg5rt";  // Replace with your SMTP password.
    
    
   



	static final String SMTP_USERNAME = "AKIAJNKSAI3F2NXPRXSQ";  // Replace with your SMTP username.
    static final String SMTP_PASSWORD = "AijyabqRGvxAxp0+sj7Fz2crFcvTZr/14ty4LR+HgY36";  // Replace with your SMTP password.
    
    
    // Amazon SES SMTP host name. This example uses the US West (Oregon) region.
    static final String HOST = "email-smtp.us-west-2.amazonaws.com";    
    
    // The port you will connect to on the Amazon SES SMTP endpoint. We are choosing port 25 because we will use
    // STARTTLS to encrypt the connection.
    static final int PORT =25;

    public  void sendMail() throws Exception {

        // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtps");
    	props.put("mail.smtp.port", PORT); 
    	 props.put("mail.smtp.host", HOST);
    	// Set properties indicating that we want to use STARTTLS to encrypt the connection.
    	// The SMTP session will begin on an unencrypted connection, and then the client
        // will issue a STARTTLS command to upgrade to an encrypted connection.
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.starttls.required", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	   Session session = Session.getInstance(props);
    	try {
    	  // Create a default MimeMessage object.
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(FROM));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO,
           InternetAddress.parse(TO));

        // Set Subject: header field
        message.setSubject(SUBJECT);

        // This mail has 2 part, the BODY and the embedded image
        MimeMultipart multipart = new MimeMultipart("related");

        // first part (the html)
        BodyPart messageBodyPart = new MimeBodyPart();
     //  String htmlText = "<H1>"+BODY+""+"</H1><img src=\"cid:image\">";
       
  //  StringWriter writer = new StringWriter();
  // IOUtils.copy(new FileInputStream(new File("C://Users//rahul//Downloads//5.txt")), writer);
  //  IOUtils.copy(new FileInputStream(new File(path+ File.separator+"verification.txt")), writer);

  // System.out.println(writer.toString()+BODY);
       messageBodyPart.setContent(  BODY , "text/html");
        // add it
      multipart.addBodyPart(messageBodyPart);

 
        // second part (the image)
        messageBodyPart = new MimeBodyPart();
     //   File contextDir = new File("C://Users//rahul//Downloads//7.jpg");
     //   DataSource fds = new FileDataSource(contextDir);
      
   //     messageBodyPart.ATTACHMENT();
        
    //    StringWriter writer = new StringWriter();
    //    IOUtils.copy(new FileInputStream(new File("C://Users//rahul//Downloads//5.txt")), writer);
     //  messageBodyPart.setDataHandler(new DataHandler(new URL("https://s3-ap-southeast-1.amazonaws.com/studyfromwebclasscontent/globe.png")));
     //  messageBodyPart.setHeader("Content-ID", "<image>");

        // add image to the multipart
  // multipart.addBodyPart(messageBodyPart);
        
        // put everything together
     message.setContent(multipart);
        // Send message
        
       
      Transport transport = session.getTransport();
   
        transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
       // Transport .send(message);
        transport.sendMessage(message, message.getAllRecipients());
      //  System.out.println("Sent message successfully....");

     } catch (MessagingException e) {
        throw new RuntimeException(e);
     }
            
        // Create a transport.        
    
  
    }
}