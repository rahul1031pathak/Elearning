package structure.refrence;

import java.sql.Timestamp;

public class Ques_Ref_Article {
	String id;
	String ques_id;
	
	String article_id;
	String name;
	String user_id;
	public Ques_Ref_Article(String id, String ques_id, String article_id, String name, String user_id,
			Timestamp dateTime) {
		super();
		this.id = id;
		this.ques_id = ques_id;
		this.article_id = article_id;
		this.name = name;
		this.user_id = user_id;
		this.dateTime = dateTime;
	}
	Timestamp   dateTime;
}
