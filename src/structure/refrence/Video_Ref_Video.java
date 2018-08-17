package structure.refrence;

import java.sql.Timestamp;

public class Video_Ref_Video {
	String id;
	String video_id_1;
	
	String video_id_2;
	String name;
	String user_id;
	public Video_Ref_Video(String id, String video_id_1, String video_id_2, String name, String user_id,
			Timestamp dateTime) {
		super();
		this.id = id;
		this.video_id_1 = video_id_1;
		this.video_id_2 = video_id_2;
		this.name = name;
		this.user_id = user_id;
		this.dateTime = dateTime;
	}
	Timestamp   dateTime;
}
