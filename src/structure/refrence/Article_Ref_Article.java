package structure.refrence;

import java.sql.Timestamp;

public class Article_Ref_Article {
	String id;
	String article_id_1;
	
	String article_id_2;
	String name;
	String user_id;
	public Article_Ref_Article(String id, String article_id_1, String article_id_2, String name, String user_id,
			Timestamp dateTime) {
		super();
		this.id = id;
		this.article_id_1 = article_id_1;
		this.article_id_2 = article_id_2;
		this.name = name;
		this.user_id = user_id;
		this.dateTime = dateTime;
	}
	Timestamp   dateTime;

}
