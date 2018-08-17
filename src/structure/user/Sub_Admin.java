package structure.user;

import java.sql.Timestamp;

public class Sub_Admin {
 private String id_sub_admin;
 private String class_id;
private String  sub_admin_user_id;
private String  sub_admin_name;
private String  sub_admin_email;;
public Sub_Admin(String id_sub_admin, String class_id, String sub_admin_user_id, String sub_admin_name,
		String sub_admin_email, Timestamp time) {
	super();
	this.id_sub_admin = id_sub_admin;
	this.class_id = class_id;
	this.sub_admin_user_id = sub_admin_user_id;
	this.sub_admin_name = sub_admin_name;
	this.sub_admin_email = sub_admin_email;
	this.time = time;
}
public String getId_sub_admin() {
	return id_sub_admin;
}
public void setId_sub_admin(String id_sub_admin) {
	this.id_sub_admin = id_sub_admin;
}
public String getClass_id() {
	return class_id;
}
public void setClass_id(String class_id) {
	this.class_id = class_id;
}
public String getSub_admin_user_id() {
	return sub_admin_user_id;
}
public void setSub_admin_user_id(String sub_admin_user_id) {
	this.sub_admin_user_id = sub_admin_user_id;
}
public String getSub_admin_name() {
	return sub_admin_name;
}
public void setSub_admin_name(String sub_admin_name) {
	this.sub_admin_name = sub_admin_name;
}
public String getSub_admin_email() {
	return sub_admin_email;
}
public void setSub_admin_email(String sub_admin_email) {
	this.sub_admin_email = sub_admin_email;
}
public Timestamp getTime() {
	return time;
}
public void setTime(Timestamp time) {
	this.time = time;
}
private Timestamp time;



}
