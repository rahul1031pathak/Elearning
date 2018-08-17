package structure.classroom;

import java.sql.Timestamp;


public class Dao_Answer {
	
	private	String ans_id;
	private	String ques_id;
	private String classid;
	private	String ans_content;
	private	String ans_giver;
	
	private	String answer_giver_name;
	private	Timestamp time;
	
	
	
	public Dao_Answer(String ans_id, String ques_id, String classid, String ans_content, String ans_giver,
			String answer_giver_name, Timestamp time) {
		super();
		this.ans_id = ans_id;
		this.ques_id = ques_id;
		this.classid = classid;
		this.ans_content = ans_content;
		this.ans_giver = ans_giver;
		this.answer_giver_name = answer_giver_name;
		this.time = time;
	}
	public String getQues_id() {
		return ques_id;
	}
	public void setQues_id(String ques_id) {
		this.ques_id = ques_id;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getAns_id() {
		return ans_id;
	}
	public void setAns_id(String ans_id) {
		this.ans_id = ans_id;
	}
	public String getAns_content() {
		return ans_content;
	}
	public void setAns_content(String ans_content) {
		this.ans_content = ans_content;
	}
	public String getAns_giver() {
		return ans_giver;
	}
	public void setAns_giver(String ans_giver) {
		this.ans_giver = ans_giver;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getAnswer_giver_name() {
		return answer_giver_name;
	}
	public void setAnswer_giver_name(String answer_giver_name) {
		this.answer_giver_name = answer_giver_name;
	}
	
	public Dao_Answer(String ans_id, String ans_content, String ans_giver, Timestamp time, String answer_giver_name
			) {
		super();
		this.ans_id = ans_id;
		this.ans_content = ans_content;
		this.ans_giver = ans_giver;
		this.time = time;
		this.answer_giver_name = answer_giver_name;
		
	}
	

}
