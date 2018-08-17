package structure.user;

public class Update_user {
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
	public Update_user(String fullname, String profilePic, String proof, String institution, String email, String foi1,
			String foi2, String foi3, String toi1, String toi2, String phone, String write_about, String city) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWrite_about() {
		return write_about;
	}
	public void setWrite_about(String write_about) {
		this.write_about = write_about;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
