package structure.classroom;

public class SharedVideos {
	
	String id;
	String shared_videos_id;
	String is_playlist;
	String class_id;
	String video_content;
	public SharedVideos(String id, String shared_videos_id, String is_playlist, String class_id, String video_content) {
		super();
		this.id = id;
		this.shared_videos_id = shared_videos_id;
		this.is_playlist = is_playlist;
		this.class_id = class_id;
		this.video_content = video_content;
	}
	public String getVideo_content() {
		return video_content;
	}
	public void setVideo_content(String video_content) {
		this.video_content = video_content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShared_videos_id() {
		return shared_videos_id;
	}
	public void setShared_videos_id(String shared_videos_id) {
		this.shared_videos_id = shared_videos_id;
	}
	public String getIs_playlist() {
		return is_playlist;
	}
	public void setIs_playlist(String is_playlist) {
		this.is_playlist = is_playlist;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public SharedVideos(String id, String shared_videos_id, String is_playlist, String class_id) {
		super();
		this.id = id;
		this.shared_videos_id = shared_videos_id;
		this.is_playlist = is_playlist;
		this.class_id = class_id;
	}
	

}
