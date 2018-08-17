package structure.classroom;

import java.sql.Timestamp;

public class Question {
	
	
	private String ques_id;
	private String topic;
    private	String qes_content;
private		String qes_raiser ;
private	 String classid;
private	 String ques_raiser_name;
private	 Timestamp   dateTime;

	
	
	
	
	public Question(String ques_id, String topic, String qes_content, String qes_raiser, String classid,
			String ques_raiser_name, Timestamp dateTime) {
		super();
		this.ques_id = ques_id;
		this.topic = topic;
		this.qes_content = qes_content;
		this.qes_raiser = qes_raiser;
		this.classid = classid;
		this.ques_raiser_name = ques_raiser_name;
		this.dateTime = dateTime;
	}
	
	
	
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	
	
	public String getQues_raiser_name() {
		return ques_raiser_name;
	}
	public void setQues_raiser_name(String ques_raiser_name) {
		this.ques_raiser_name = ques_raiser_name;
	}
	
	public String getQues_id() {
		return ques_id;
	}
	public void setQues_id(String ques_id) {
		this.ques_id = ques_id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public String getQes_content() {
		return qes_content;
	}
	public void setQes_content(String qes_content) {
		this.qes_content = qes_content;
	}
	public String getQes_raiser() {
		return qes_raiser;
	}
	public void setQes_raiser(String qes_raiser) {
		this.qes_raiser = qes_raiser;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	

	

}
