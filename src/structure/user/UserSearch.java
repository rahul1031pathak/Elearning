package structure.user;

import java.sql.Timestamp;

public class UserSearch {
	String fullname;
	String userId;
	String numberOfFollowers;
	String profilePic;                         
	String proof;
	String institution;
	String email;
	String foi1;
	String foi2;
	String foi3;
	String toi1;
	String toi2;
	String phone;
	String write_about;
	String city;
	String is_teacher;
	Timestamp time;
	public UserSearch(String fullname, String profilePic, String proof, String institution, String email, String foi1,
			String foi2, String foi3, String toi1, String toi2, String phone, String write_about, String city,String numberOfFollowers
			) {
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
		
	}
	
	
	public UserSearch(String fullname, String profilePic, String proof, String institution, String email, String foi1,
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
	public UserSearch(String fullname, String userId, String numberOfFollowers, String profilePic, String proof,
			String institution, String email, String foi1, String foi2, String foi3, String toi1, String toi2) {
		super();
		this.fullname = fullname;
		this.userId = userId;
		this.numberOfFollowers = numberOfFollowers;
		this.profilePic = profilePic;
		this.proof = proof;
		this.institution = institution;
		this.email = email;
		this.foi1 = foi1;
		this.foi2 = foi2;
		this.foi3 = foi3;
		this.toi1 = toi1;
		this.toi2 = toi2;
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
	public UserSearch(String fullname, String userId, String numberOfFollowers, String profilePic, String proof,
			String institution, String email) {
		super();
		this.fullname = fullname;
		this.userId = userId;
		this.numberOfFollowers = numberOfFollowers;
		this.profilePic = profilePic;
		this.proof = proof;
		this.institution = institution;
		this.email = email;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserSearch(String fullname, String userId, String numberOfFollowers, String profilePic, String proof,
			String institution) {
		super();
		this.fullname = fullname;
		this.userId = userId;
		this.numberOfFollowers = numberOfFollowers;
		this.profilePic = profilePic;
		this.proof = proof;
		this.institution = institution;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNumberOfFollowers() {
		return numberOfFollowers;
	}
	public void setNumberOfFollowers(String numberOfFollowers) {
		this.numberOfFollowers = numberOfFollowers;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getProof() {
		return proof;
	}
	public void setProof(String proof) {
		this.proof = proof;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	

}
