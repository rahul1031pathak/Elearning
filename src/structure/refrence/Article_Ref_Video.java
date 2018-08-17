package structure.refrence;

import java.sql.Timestamp;

public class Article_Ref_Video {
	String id;
	String article_id;
	
	String Video_id;
	String name;
	String user_id;
	public Article_Ref_Video(String id, String article_id, String video_id, String name, String user_id,
			Timestamp dateTime) {
		super();
		this.id = id;
		this.article_id = article_id;
		Video_id = video_id;
		this.name = name;
		this.user_id = user_id;
		this.dateTime = dateTime;
	}
	Timestamp   dateTime;

}
