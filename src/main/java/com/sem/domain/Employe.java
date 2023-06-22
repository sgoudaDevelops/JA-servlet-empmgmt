package com.sem.domain;

public class Employe {
	private int emp_id;
	private String first_name;
	private String last_name;
	private String address;
	private String birth_date;
	private String gender;
	private String email;
	private String joining_date;
	private String emp_type;
	private String emp_status;
	private String contactno;
	private int exp_level;
	private String IsId;

	public Employe(int emp_id, String first_name, String last_name, String address, String birth_date, String gender,
			String email, String joining_date, String emp_type, String emp_status, String contactno, int exp_level,
			String IsId) {
		super();
		this.emp_id = emp_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.birth_date = birth_date;
		this.gender = gender;
		this.email = email;
		this.joining_date = joining_date;
		this.emp_type = emp_type;
		this.emp_status = emp_status;
		this.contactno = contactno;
		this.exp_level = exp_level;
		this.IsId = IsId;
	}
	public Employe(int emp_id, String address, String contactno, int exp_level) {
		super();
		this.emp_id = emp_id;
		this.address = address;
		this.contactno = contactno;
		this.exp_level = exp_level;
	}

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	



//	public Employe(int emp_id, String first_name, String last_name, String address, String birth_date, String gender,
//			String email, String joining_date, String emp_type, String emp_status, String contactno, int exp_level) {
//		super();
//		this.emp_id = emp_id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.address = address;
//		this.birth_date = birth_date;
//		this.gender = gender;
//		this.email = email;
//		this.joining_date = joining_date;
//		this.emp_type = emp_type;
//		this.emp_status = emp_status;
//		this.contactno = contactno;
//		this.exp_level = exp_level;
//	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoining_date() {
		return joining_date;
	}

	public void setJoining_date(String joining_date) {
		this.joining_date = joining_date;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getEmp_status() {
		return emp_status;
	}

	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public int getExp_level() {
		return exp_level;
	}

	public void setExp_level(int exp_level) {
		this.exp_level = exp_level;
	}

	public String getIsId() {
		return IsId;
	}

	public void setIsId(String isId) {
		IsId = isId;
	}

	@Override
	public String toString() {
		return "Employe [emp_id=" + emp_id + ", first_name=" + first_name + ", last_name=" + last_name + ", address="
				+ address + ", birth_date=" + birth_date + ", gender=" + gender + ", email=" + email + ", joining_date="
				+ joining_date + ", emp_type=" + emp_type + ", emp_status=" + emp_status + ", contactno=" + contactno
				+ ", exp_level=" + exp_level + ", IsId=" + IsId + "]";
	}
	

//	@Override
//	public String toString() {
//		return "Employe [emp_id=" + emp_id + ", first_name=" + first_name + ", last_name=" + last_name + ", address="
//				+ address + ", birth_date=" + birth_date + ", gender=" + gender + ", email=" + email + ", joining_date="
//				+ joining_date + ", emp_type=" + emp_type + ", emp_status=" + emp_status + ", contactno=" + contactno
//				+ ", exp_level=" + exp_level + "]";
//	}

}
