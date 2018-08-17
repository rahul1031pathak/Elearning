package structure.user;

public class AlreadyMember {
	
	String ClassroomName;
	String ClassAdminName;
	String ClassId;
	public AlreadyMember(String classroomName, String classAdminName, String classId) {
		super();
		ClassroomName = classroomName;
		ClassAdminName = classAdminName;
		ClassId = classId;
	}
	public String getClassroomName() {
		return ClassroomName;
	}
	public void setClassroomName(String classroomName) {
		ClassroomName = classroomName;
	}
	public String getClassAdminName() {
		return ClassAdminName;
	}
	public void setClassAdminName(String classAdminName) {
		ClassAdminName = classAdminName;
	}
	public String getClassId() {
		return ClassId;
	}
	public void setClassId(String classId) {
		ClassId = classId;
	}
	
}
