package in.Elearning.java;

import java.sql.Timestamp;

public class Notice_In_Class {
	String notice;
	String notice_id;
	public Notice_In_Class(String notice, String notice_id, Timestamp time) {
		super();
		this.notice = notice;
		this.notice_id = notice_id;
		this.time = time;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	Timestamp time;

}
