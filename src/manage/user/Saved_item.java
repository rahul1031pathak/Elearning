package manage.user;

public class Saved_item {
	private String saved_id;
	private String user_id;
	private String content_id;
	public Saved_item(String saved_id, String user_id, String content_id) {
		super();
		this.saved_id = saved_id;
		this.user_id = user_id;
		this.content_id = content_id;
	}
	public String getSaved_id() {
		return saved_id;
	}
	public void setSaved_id(String saved_id) {
		this.saved_id = saved_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getContent_id() {
		return content_id;
	}
	public void setContent_id(String content_id) {
		this.content_id = content_id;
	}
	
	
}
