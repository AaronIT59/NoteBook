package entity;

public class tbl_profile {
	
	protected int id;
	protected String first_name;
	protected String last_name;
	protected String email_mobile;
	protected String password;
	protected String birthday;
	protected String sex;
	protected String avata;
	
	public tbl_profile() {
		
	}
	
	public tbl_profile(int id, String first_name, String last_name, String email_mobile, String password,
			String birthday, String sex, String avata) {
		
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_mobile = email_mobile;
		this.password = password;
		this.birthday = birthday;
		this.sex = sex;
		this.avata = avata;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail_mobile() {
		return email_mobile;
	}
	public void setEmail_mobile(String email_mobile) {
		this.email_mobile = email_mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAvata() {
		return avata;
	}
	public void setAvata(String avata) {
		this.avata = avata;
	}
	
	
	
}
