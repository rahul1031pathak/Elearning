package structure.classroom;

import java.sql.Timestamp;

public class Article {

	
	String article_id;
	String topic;
	
	String article_content; 
	String classid;
	String article_writer ;
	String article_writer_name;
	Timestamp   dateTime;
	
	
	public Article(String article_id, String topic,  String article_content, String article_writer,
			String article_writer_name, Timestamp dateTime) {
		super();
		this.article_id = article_id;
		this.topic = topic;
		this.article_content = article_content;
		this.article_writer = article_writer;
		this.article_writer_name = article_writer_name;
		this.dateTime = dateTime;
		
	}
	public String getArticle_id() {
		return article_id;
	}
	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	
	public Article(String article_id, String topic, String article_content, String classid, String article_writer,
			String article_writer_name, Timestamp dateTime) {
		super();
		this.article_id = article_id;
		this.topic = topic;
		this.article_content = article_content;
		this.classid = classid;
		this.article_writer = article_writer;
		this.article_writer_name = article_writer_name;
		this.dateTime = dateTime;
	}
	public String getArticle_content() {
		return article_content;
	}
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}
	public String getArticle_writer() {
		return article_writer;
	}
	public void setArticle_writer(String article_writer) {
		this.article_writer = article_writer;
	}
	public String getArticle_writer_name() {
		return article_writer_name;
	}
	public void setArticle_writer_name(String article_writer_name) {
		this.article_writer_name = article_writer_name;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
	
}
