package structure.classroom;

import java.sql.Timestamp;

public class ClassroomDetails {
	private String Class_name;
	private String Class_Admin;
	
	
	public ClassroomDetails(String class_name, String class_Admin, String discription, String class_id,
			String class_Admin_Name, String followers) {
		super();
		Class_name = class_name;
		Class_Admin = class_Admin;
		Discription = discription;
		Class_id = class_id;
		Class_Admin_Name = class_Admin_Name;
		this.followers = followers;
	}
	private String Discription;
	private String Class_id;
	Timestamp time;
	public ClassroomDetails(String class_name, String class_Admin, String discription, String class_id, Timestamp time,
			String class_Admin_Name, String answer_setting, String question_setting, String view_setting,
			String number_of_members, String number_of_subscribers) {
		super();
		Class_name = class_name;
		Class_Admin = class_Admin;
		Discription = discription;
		Class_id = class_id;
		this.time = time;
		Class_Admin_Name = class_Admin_Name;
		this.answer_setting = answer_setting;
		this.question_setting = question_setting;
		this.view_setting = view_setting;
		this.number_of_members = number_of_members;
		this.number_of_subscribers = number_of_subscribers;
	}
	public String getClass_name() {
		return Class_name;
	}
	public void setClass_name(String class_name) {
		Class_name = class_name;
	}
	public String getClass_Admin() {
		return Class_Admin;
	}
	public void setClass_Admin(String class_Admin) {
		Class_Admin = class_Admin;
	}
	public String getDiscription() {
		return Discription;
	}
	public void setDiscription(String discription) {
		Discription = discription;
	}
	public String getClass_id() {
		return Class_id;
	}
	public void setClass_id(String class_id) {
		Class_id = class_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getClass_Admin_Name() {
		return Class_Admin_Name;
	}
	public void setClass_Admin_Name(String class_Admin_Name) {
		Class_Admin_Name = class_Admin_Name;
	}
	public String getAnswer_setting() {
		return answer_setting;
	}
	public void setAnswer_setting(String answer_setting) {
		this.answer_setting = answer_setting;
	}
	public String getQuestion_setting() {
		return question_setting;
	}
	public void setQuestion_setting(String question_setting) {
		this.question_setting = question_setting;
	}
	public String getView_setting() {
		return view_setting;
	}
	public void setView_setting(String view_setting) {
		this.view_setting = view_setting;
	}
	public String getNumber_of_members() {
		return number_of_members;
	}
	public void setNumber_of_members(String number_of_members) {
		this.number_of_members = number_of_members;
	}
	public String getNumber_of_subscribers() {
		return number_of_subscribers;
	}
	public void setNumber_of_subscribers(String number_of_subscribers) {
		this.number_of_subscribers = number_of_subscribers;
	}
	private String Class_Admin_Name;
	private String 	answer_setting;
	private String question_setting;
	private String 	view_setting;
	private String number_of_members;
	private String 	number_of_subscribers;
	private String 	followers;
	public String getFollowers() {
		return followers;
	}
	public void setFollowers(String followers) {
		this.followers = followers;
	}
	public ClassroomDetails(String class_name, String class_Admin, String discription, String class_id, Timestamp time,
			String class_Admin_Name, String answer_setting, String question_setting, String view_setting,
			String number_of_members, String number_of_subscribers, String followers) {
		super();
		Class_name = class_name;
		Class_Admin = class_Admin;
		Discription = discription;
		Class_id = class_id;
		this.time = time;
		Class_Admin_Name = class_Admin_Name;
		this.answer_setting = answer_setting;
		this.question_setting = question_setting;
		this.view_setting = view_setting;
		this.number_of_members = number_of_members;
		this.number_of_subscribers = number_of_subscribers;
		this.followers = followers;
	}


	
}
