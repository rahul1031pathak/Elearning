package fetch.classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.google.gson.Gson;

import in.Elearning.java.DbConnection;
import structure.classroom.Dao_Answer;
import structure.classroom.Question;
import structure.classroom.QuestionWithAnswers;

public class Answer_Fetcher {
	 DbConnection dbc=new DbConnection(); 
	  Connection con =dbc.getMysqlConnection();
		PreparedStatement ps ;
	int i;
	 public  String  FetchAnswer(String quesid) {
	 
	 Gson gson=new Gson();
	 QuestionWithAnswers questionWithAnswers=new QuestionWithAnswers();
		 try {
			 ResultSet rs = null;
			 ps = con.prepareStatement("SELECT * FROM answerintext WHERE ques_id=?");
			 ps.setString(1, quesid);
			 rs=ps.executeQuery();
			 
			 try {
				 //boolean t=rs.next();
					while(rs.next()){
						Dao_Answer answer=new Dao_Answer(rs.getString(1)+"",rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
						questionWithAnswers.answerList.add(answer);					
					// t=rs.next();
					}
			
		} finally{ }
		 }
		 catch (SQLException e) {
			e.printStackTrace();
		} 
		 questionWithAnswers.question=fetchQuestion(quesid);
		return gson.toJson(questionWithAnswers);
	
	 }
	 
	 
	 public   Question fetchQuestion(String quesid){
		 ResultSet rs = null;
		 
		 Question question=null;
			 try {
				
				PreparedStatement ps = con.prepareStatement("SELECT * FROM questioninwritten WHERE ques_id=?");
				 ps.setString(1, quesid);
				 rs=ps.executeQuery();
				 
				 try {
					 while(rs.next()){
					 question=new Question(quesid,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getTimestamp(7));
						
						
						}
				
			} finally{ }
			 }
			 catch (SQLException e) {
				e.printStackTrace();
			} 
			 
			 return  question;
		
		 }
	 
	 public void connClose(){
		 try {
			 
			 if(ps!=null){
				  ps.close(); 
			 }
			 
	    	if(con!=null){
	    		con.close();
	    	}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 
	 
	 
	 
	 
	
}
