package structure.user;

import java.sql.Timestamp;

public class MembershipReq {
	String senderId;
	String classId;
	String senderName;
	Timestamp time;

	String className;
	String member_req_id;
	String profile_pic;
	String proof_pic;
	String institute;
 


public MembershipReq(String senderId, String classId, String senderName, Timestamp time, String className,
			String member_req_id, String profile_pic, String proof_pic, String institute) {
		super();
		this.senderId = senderId;
		this.classId = classId;
		this.senderName = senderName;
		this.time = time;
		this.className = className;
		this.member_req_id = member_req_id;
		this.profile_pic = profile_pic;
		this.proof_pic = proof_pic;
		this.institute = institute;
	}

public String getMember_req_id() {
		return member_req_id;
	}

	public void setMember_req_id(String member_req_id) {
		this.member_req_id = member_req_id;
	}




public String getClassName() {
	return className;
}

public void setClassName(String className) {
	this.className = className;
}

public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}

}
