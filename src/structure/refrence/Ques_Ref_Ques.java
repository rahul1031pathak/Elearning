package structure.refrence;

import java.sql.Timestamp;

public class Ques_Ref_Ques {

	
	
	String id;
	String ques_id_1;
	
	String ques_id_2;
	String name;
	String user_id;
	Timestamp   dateTime;
	
	
	public Ques_Ref_Ques(String id, String ques_id_1, String ques_id_2, String name, String user_id,
			Timestamp dateTime) {
		super();
		this.id = id;
		this.ques_id_1 = ques_id_1;
		this.ques_id_2 = ques_id_2;
		this.name = name;
		this.user_id = user_id;
		this.dateTime = dateTime;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getQues_id_1() {
		return ques_id_1;
	}
	public void setQues_id_1(String ques_id_1) {
		this.ques_id_1 = ques_id_1;
	}
	public String getQues_id_2() {
		return ques_id_2;
	}
	public void setQues_id_2(String ques_id_2) {
		this.ques_id_2 = ques_id_2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	

}
