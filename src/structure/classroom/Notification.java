package structure.classroom;

import java.sql.Timestamp;

public class Notification {
	
	public String notification_id;
	
	String notification_type;
	String notification_content	;
	String class_id;
	String 	generated_by;
	
	String 	generated_by_name;
	
	String generator_profile_pic;
	String content_id;
	Timestamp time;
	
	
	
	
	public Notification(String notification_id, String notification_type, String notification_content, String class_id,
			String generated_by, String generated_by_name,  String generator_profile_pic,
			String content_id, Timestamp time) {
		super();
		this.notification_id = notification_id;
		this.notification_type = notification_type;
		this.notification_content = notification_content;
		this.class_id = class_id;
		this.generated_by = generated_by;
		this.generated_by_name = generated_by_name;
		
		this.generator_profile_pic = generator_profile_pic;
		this.content_id = content_id;
		this.time = time;
	}
	public Notification(String notification_type, String notification_content, String class_id, String generated_by,
			String generated_by_name, String generator_profile_pic, String content_id) {
		super();
		this.notification_type = notification_type;
		this.notification_content = notification_content;
		this.class_id = class_id;
		this.generated_by = generated_by;
		this.generated_by_name = generated_by_name;
		this.generator_profile_pic = generator_profile_pic;
		this.content_id = content_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}


	public String getGenerator_profile_pic() {
		return generator_profile_pic;
	}
	public void setGenerator_profile_pic(String generator_profile_pic) {
		this.generator_profile_pic = generator_profile_pic;
	}
	
	public String getGenerated_by_name() {
		return generated_by_name;
	}
	public void setGenerated_by_name(String generated_by_name) {
		this.generated_by_name = generated_by_name;
	}
	

	public Notification(String notification_id, String notification_type, String notification_content, String class_id,
			String generated_by, Timestamp time, String generated_by_name, 
			String generator_profile_pic) {
		super();
		this.notification_id = notification_id;
		this.notification_type = notification_type;
		this.notification_content = notification_content;
		this.class_id = class_id;
		this.generated_by = generated_by;
		this.time = time;
		this.generated_by_name = generated_by_name;
		
		this.generator_profile_pic = generator_profile_pic;
	}
	public String getNotification_id() {
		return notification_id;
	}
	public void setNotification_id(String notification_id) {
		this.notification_id = notification_id;
	}
	public String getNotification_type() {
		return notification_type;
	}
	public void setNotification_type(String notification_type) {
		this.notification_type = notification_type;
	}
	public String getNotification_content() {
		return notification_content;
	}
	public void setNotification_content(String notification_content) {
		this.notification_content = notification_content;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getGenerated_by() {
		return generated_by;
	}
	public void setGenerated_by(String generated_by) {
		this.generated_by = generated_by;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	

}
