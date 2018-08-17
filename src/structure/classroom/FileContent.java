package structure.classroom;



public class FileContent {
	private String topic;
	private String subTopic;
	private	String fileUploadedPath;
private	String fileUploadedName;
private	String fileUploadedId;

private String discription;

public String getTopic() {
	return topic;
}

public void setTopic(String topic) {
	this.topic = topic;
}

public String getSubTopic() {
	return subTopic;
}

public void setSubTopic(String subTopic) {
	this.subTopic = subTopic;
}

public String getFileUploadedPath() {
	return fileUploadedPath;
}

public void setFileUploadedPath(String fileUploadedPath) {
	this.fileUploadedPath = fileUploadedPath;
}

public String getFileUploadedName() {
	return fileUploadedName;
}

public void setFileUploadedName(String fileUploadedName) {
	this.fileUploadedName = fileUploadedName;
}

public String getFileUploadedId() {
	return fileUploadedId;
}

public void setFileUploadedId(String fileUploadedId) {
	this.fileUploadedId = fileUploadedId;
}

public String getDiscription() {
	return discription;
}

public void setDiscription(String discription) {
	this.discription = discription;
}

public FileContent(String topic, String subTopic, String fileUploadedPath, String fileUploadedName,
		String fileUploadedId, String discription) {
	super();
	this.topic = topic;
	this.subTopic = subTopic;
	this.fileUploadedPath = fileUploadedPath;
	this.fileUploadedName = fileUploadedName;
	this.fileUploadedId = fileUploadedId;
	this.discription = discription;
}


}
