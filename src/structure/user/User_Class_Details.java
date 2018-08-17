package structure.user;

public class User_Class_Details {

	                 
	public User_Class_Details(String classroom_id, String classroom_Name, String number_of_members,
			String number_of_subscribers) {
		super();
		Classroom_id = classroom_id;
		Classroom_Name = classroom_Name;
		this.number_of_members = number_of_members;
		this.number_of_subscribers = number_of_subscribers;
	}
	public String getClassroom_id() {
		return Classroom_id;
	}
	public void setClassroom_id(String classroom_id) {
		Classroom_id = classroom_id;
	}
	public String getClassroom_Name() {
		return Classroom_Name;
	}
	public void setClassroom_Name(String classroom_Name) {
		Classroom_Name = classroom_Name;
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
	private String Classroom_id;
	private String Classroom_Name;
	private String number_of_members;
	private String number_of_subscribers;
	
}
