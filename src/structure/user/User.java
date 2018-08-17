package structure.user;

import java.sql.Timestamp;

public class User {
	
	String fullname;
	String email;
	String Password;
	int userId;
	String foi1;
	String foi2;
	String foi3;
	String toi1;
	String toi2;
	String profilepic;
	String proof;
	String institution;
	String followers;
	
	String profilePic;                         
	
	String phone;
	String write_about;
	String city;
	String is_teacher;
	Timestamp time;
	
	
	
	
	
	public User(String fullname, String profilePic, String proof, String institution, String email, String foi1,
			String foi2, String foi3, String toi1, String toi2, String phone, String write_about, String city,String numberOfFollowers,String is_teacher
			, Timestamp time) {
		super();
		this.fullname = fullname;
		this.profilePic = profilePic;
		this.proof = proof;
		this.institution = institution;
		this.email = email;
		this.foi1 = foi1;
		this.foi2 = foi2;
		this.foi3 = foi3;
		this.toi1 = toi1;
		this.toi2 = toi2;
		this.phone = phone;
		this.write_about = write_about;
		this.city = city;
		this.numberOfFollowers = numberOfFollowers;
		this.is_teacher = is_teacher;
		this.time = time;
	}
	
	
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	String numberOfFollowers;
	Timestamp DateTime;
	
	
	
	public User(String fullname, String email, String password, int userId, String foi1, String foi2, String foi3,
			String toi1, String toi2, String profilepic, String proof, String institution, String numberOfFollowers,
			Timestamp dateTime) {
		super();
		this.fullname = fullname;
		this.email = email;
		Password = password;
		this.userId = userId;
		this.foi1 = foi1;
		this.foi2 = foi2;
		this.foi3 = foi3;
		this.toi1 = toi1;
		this.toi2 = toi2;
		this.profilepic = profilepic;
		this.proof = proof;
		this.institution = institution;
		this.numberOfFollowers = numberOfFollowers;
		DateTime = dateTime;
	}
	
	
	
	
	
	public User(String fullname, String email,  String foi1, String foi2, String foi3,
			String toi1, String toi2, String profilepic, String proof, String institution, String numberOfFollowers,
			Timestamp dateTime) {
		super();
		this.fullname = fullname;
		this.email = email;
	
		this.foi1 = foi1;
		this.foi2 = foi2;
		this.foi3 = foi3;
		this.toi1 = toi1;
		this.toi2 = toi2;
		this.profilepic = profilepic;
		this.proof = proof;
		this.institution = institution;
		this.numberOfFollowers = numberOfFollowers;
		DateTime = dateTime;
	}
	
	
	public String getNumberOfFollowers() {
		return numberOfFollowers;
	}
	public void setNumberOfFollowers(String numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	public String getFoi1() {
		return foi1;
	}
	public void setFoi1(String foi1) {
		this.foi1 = foi1;
	}
	public String getFoi2() {
		return foi2;
	}
	public void setFoi2(String foi2) {
		this.foi2 = foi2;
	}
	public String getFoi3() {
		return foi3;
	}
	public void setFoi3(String foi3) {
		this.foi3 = foi3;
	}
	public String getToi1() {
		return toi1;
	}
	public void setToi1(String toi1) {
		this.toi1 = toi1;
	}
	public String getToi2() {
		return toi2;
	}
	public void setToi2(String toi2) {
		this.toi2 = toi2;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public User(String fullname, String email, String password, int userId, Timestamp dateTime) {
		super();
		this.fullname = fullname;
		this.email = email;
		Password = password;
		this.userId = userId;
		DateTime = dateTime;
	}
	public User(String fullname, String email, int userId, String profilepic,String proof, String institution, Timestamp dateTime) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.userId = userId;
		this.profilepic = profilepic;
		this.institution = institution;
		DateTime = dateTime;
		this.proof=proof;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Timestamp getDateTime() {
		return DateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		DateTime = dateTime;
	}
	
	
}
