package com.sem.dao;

import java.util.HashMap;
import java.util.List;

import com.sem.domain.Employe;

public interface IEmployeDao {
	String INSERT_EMP_DATA = "insert into softtek_employe (emp_id,first_name,last_name,address,birth_date,gender,email,joining_date,emp_type,emp_status,contactno,exp_level,IsId)"
			+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	String DELETE_EMP = "delete from softtek_employe where emp_id=?";
	String SHOW_EMPLIST = "select * from softtek_employe";
	String SHOW_EMP ="select * from softtek_employe where emp_id =?";
	String UPDATE_Address = "update softtek_employe set address=? where emp_id=? ";
	String UPDATE_EMAIL = "update softtek_employe set email=? emp_id=?";
	String UPDATE_EMP_STATUS = "update softtek_employe set emp_status=? where emp_id=?";
	String UPDATE_CONTACTNO = "update softtek_employe set contactno=? where emp_id=?";
	String UPDATE_EXP_LEVEL = "update softtek_employe set exp_level=? where emp_id=?";
	String UPDATEALL = "update Softtek_employe set address=?,contactno=?,exp_level=?  where emp_id=? ";
	
	String READ_EMPLOYEE_GENDER_DATA = "select count(case when gender='m' then 1 end) as male_count,count(case when gender='f' then 1 end) as female_count,count(*) as total_cnt from softtek_employe";
	String READ_EMPLOYEE_TYPE_DATA = "select count(case when emp_type='pte' then 1 end) as fte_count,count(case when emp_type='con' then 1 end) as con_count,count(*) as total_cnt from softtek_employe";
	String READ_EMPLOYEE_STATUS_DATA = "select count(case when emp_status='p' then 1 end) as p_count,count(case when emp_status='c' then 1 end) as c_count,count(*) as total_cnt from softtek_employe";

//	String UPDATEPTOC="update Softtek_employe set emp_status=? where emp_id=?";
	//String CHECK_ELGIBILITY=""
	String Fetch_MDiff="Select  TIMESTAMPDIFF(MONTH, ?, now()) where emp_id = ? ";
	public List<Employe> selectAllUsers();
	public Employe viewEmploye(int emp_id);
	public int deleteEmploye(int emp_id);
	public void addEmploye(Employe employe);
	 public String ProviToPermanent();
	
	public boolean UpdateEmployee(Employe EmpUpdate);
	public HashMap<String, String> StatsgenderEmployee();

	public HashMap<String, String> StatsTypeEmployee();

	public HashMap<String, String> StatsStatusEmployee();
	public Integer GetNumberOfRows();
	public boolean validateAdmin(String email,String password);
	String  LOGIN_DATA="select * from softtek_login where email=?";
	
	 String jdbcUrl = "jdbc:mysql://localhost:3306/softtek_empmanager";
	 String jdbcUserName = "root";
	 String JdbcPassword = "Softtek@2022";
	 String UPDATE_P_TO_C = "update softtek_employe set emp_status = 'C' where emp_id=?";
	 String SELECT_ALL_PROBATION_EMP= "Select emp_id, joining_date from softtek_employe where emp_status = 'P'";
	 String FETCH_MONTH_DIFFERNCE = "SELECT TIMESTAMPDIFF(MONTH, ?, now())";
	 String Get_No_of_rows="SELECT COUNT(*) FROM softtek_employe";
}
