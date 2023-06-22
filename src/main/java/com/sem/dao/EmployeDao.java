package com.sem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.sem.domain.Employe;
import com.sem.helper.semHelpers;

public class EmployeDao implements IEmployeDao {

	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcUrl, jdbcUserName, JdbcPassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public List<Employe> selectAllUsers() {
		// TODO Auto-generated method stub
		List<Employe> employes = new ArrayList();
		// using try-with-resource to avoid closing resources
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_EMPLIST);) {
			// System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String address = rs.getString("address");
				String birth_date = rs.getString("birth_date");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				String contactno = rs.getString("contactno");
				int exp_level = rs.getInt("exp_level");
				String IsId = rs.getString("IsId");

				employes.add(new Employe(id, first_name, last_name, address, birth_date, gender, email, joining_date,
						emp_type, emp_status, contactno, exp_level, IsId));
				// employes.add(new Employe(id, first_name, last_name, address, birth_date,
				// gender, email, joining_date,emp_type, emp_status, contactno, exp_level));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employes;
	}

	@Override
	public Employe viewEmploye(int emp_id) {
		Employe emp = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SHOW_EMP);) {
			// System.out.println(preparedStatement);
			preparedStatement.setInt(1, emp_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("emp_id");
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String address = rs.getString("address");
				String birth_date = rs.getString("birth_date");
				String gender = rs.getString("gender");
				String email = rs.getString("email");
				String joining_date = rs.getString("joining_date");
				String emp_type = rs.getString("emp_type");
				String emp_status = rs.getString("emp_status");
				String contactno = rs.getString("contactno");
				int exp_level = rs.getInt("exp_level");
				String IsId = rs.getString("IsId");

				emp = new Employe(id, first_name, last_name, address, birth_date, gender, email, joining_date, emp_type,
						emp_status, contactno, exp_level, IsId);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int deleteEmploye(int emp_id) {
		int result = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMP);) {
			// System.out.println(preparedStatement);
			preparedStatement.setInt(1, emp_id);
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public void addEmploye(Employe employe) {

		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMP_DATA);) {
			// System.out.println(preparedStatement);

			preparedStatement.setInt(1, employe.getEmp_id());
			System.out.println(employe.getEmp_id());
			System.out.println(employe.getBirth_date());
			System.out.println(employe.getEmail());

			preparedStatement.setString(2, employe.getFirst_name());
			preparedStatement.setString(3, employe.getLast_name());
			preparedStatement.setString(4, employe.getAddress());
			preparedStatement.setString(5, employe.getBirth_date());
			preparedStatement.setString(6, employe.getGender());
			preparedStatement.setString(7, employe.getEmail());
			preparedStatement.setString(8, employe.getJoining_date());

			preparedStatement.setString(9, employe.getEmp_type());
			preparedStatement.setString(10, employe.getEmp_status());
			preparedStatement.setString(11, employe.getContactno());
			preparedStatement.setInt(12, employe.getExp_level());

			preparedStatement.setString(13, employe.getIsId());
			preparedStatement.executeUpdate();
			// System.out.println("data inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	public void ProbationToConfirmation(int emp_id) {
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(Fetch_MDiff);) {
//			PreparedStatement preparedStatement2 = connection
//					.prepareStatement("select joining_date from softtek_employe where emp_id=? ");
//			preparedStatement2.setInt(1, emp_id);
//			ResultSet executeQuery = preparedStatement2.executeQuery();
//			executeQuery.next();
//			System.out.println(executeQuery.getString("joining_date"));
//			
//			preparedStatement.setString(1, executeQuery.getString("joining_date"));
//			
//			preparedStatement.setInt(2,emp_id);
//			ResultSet rs = preparedStatement.executeQuery();
//			System.out.println("rs gen");
//			rs.next();
//			if (rs.getInt(1)>= 6) {
//				PreparedStatement preparedStatement1 = connection.prepareStatement(UPDATEPTOC);
//				preparedStatement1.setString(1, "c");
//				preparedStatement1.setInt(2, emp_id);
//				preparedStatement1.executeUpdate();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Override
	public boolean UpdateEmployee(Employe EmpUpdate) {
		boolean rowUpdated = false;
		try {
			Connection conection = getConnection();
			PreparedStatement preparedStament = conection.prepareStatement(UPDATEALL);
			// preparedStament.setString(1, EmpUpdate.getFirst_name());
			// preparedStament.setString(2, EmpUpdate.getLast_name());
			preparedStament.setString(1, EmpUpdate.getAddress());
			// preparedStament.setString(4, EmpUpdate.getGender());
			// preparedStament.setString(5, EmpUpdate.getBirth_date());
			preparedStament.setString(2, EmpUpdate.getContactno());
			preparedStament.setInt(3, EmpUpdate.getExp_level());
			preparedStament.setInt(4, EmpUpdate.getEmp_id());
			rowUpdated = preparedStament.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public String ProviToPermanent() {
		int executeUpdate = 0;
		// int Update;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(SELECT_ALL_PROBATION_EMP);) {
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String emp_id = rs.getString("emp_id");
				String joining_date = rs.getString("joining_date");
				PreparedStatement preparedStament1 = connection.prepareStatement(FETCH_MONTH_DIFFERNCE);
				preparedStament1.setString(1, joining_date);
				ResultSet rs2 = preparedStament1.executeQuery();
				rs2.next();
				if (rs2.getInt(1) > 6) {
					PreparedStatement preparedStament3 = connection.prepareStatement(UPDATE_P_TO_C);
					preparedStament3.setString(1, emp_id);
					executeUpdate = preparedStament3.executeUpdate();
					System.out.println(executeUpdate);
//					 executeUpdate = String.valueOf(Update);

				}
			}

		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return (Integer.toString(executeUpdate));
	}

	@Override
	public HashMap<String, String> StatsgenderEmployee() {
		HashMap<String, String> gendermap = new HashMap<String, String>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(READ_EMPLOYEE_GENDER_DATA);) {
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String male = rs.getString("male_count");
				String female = rs.getString("female_count");
				String total = rs.getString("total_cnt");
//				System.out.println(male);
//				System.out.println(female);
//				System.out.println(total);
				gendermap.put(new String("male_count"), male);
				gendermap.put(new String("female_count"), female);
				gendermap.put(new String("total_count"), total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gendermap;
	}

	@Override
	public HashMap<String, String> StatsTypeEmployee() {
		HashMap<String, String> typemap = new HashMap<String, String>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(READ_EMPLOYEE_TYPE_DATA);) {
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String fte = rs.getString("fte_count");
				String con = rs.getString("con_count");
				String total = rs.getString("total_cnt");
//				System.out.println(fte);
//				System.out.println(con);
//				System.out.println(total);
//				System.out.println(fte+con);
				typemap.put(new String("fte_count"), fte);
				typemap.put(new String("con_count"), con);
				typemap.put(new String("total_count"), total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return typemap;
	}

	@Override
	public HashMap<String, String> StatsStatusEmployee() {
		HashMap<String, String> statusmap = new HashMap<String, String>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(READ_EMPLOYEE_STATUS_DATA);) {
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				String permanent = rs.getString("p_count");
				String contract = rs.getString("c_count");
				String total = rs.getString("total_cnt");
//				System.out.println(permanent);
//				System.out.println(contract);
//				System.out.println(total);
				statusmap.put(new String("p_count"), permanent);
				statusmap.put(new String("c_count"), contract);
				statusmap.put(new String("total_count"), total);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusmap;
	}

	@Override
	public Integer GetNumberOfRows() {
		Integer numOfRows = 0;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(Get_No_of_rows);) {
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			numOfRows = rs.getInt("COUNT(*)");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numOfRows;
	}

//	public boolean validateAdmin(String email, String password) {
//		boolean dec = false;
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStament = connection.prepareStatement(LOGIN_DATA);) 
//		{
//			preparedStament.setString(1, email);
//			ResultSet rs = preparedStament.executeQuery();
//			while (rs.next()) {
//				String Uemail = rs.getString("email");
//				System.out.println("email from db" + Uemail);
//				String Upassword = rs.getString("Passsword");
//				System.out.println("password from db" + Upassword);
//				if (Upassword.equals(password)) {
//					dec = true;
//				}
//			}
//			
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(dec);
//		return dec;
//	}

	@Override
	public boolean validateAdmin(String email, String password) {
		String mail = null, psd = null;
		boolean dec = false;
		try (Connection connection = getConnection();
				PreparedStatement preparedStament = connection.prepareStatement(LOGIN_DATA);) {
			preparedStament.setString(1, email);
			ResultSet rs = preparedStament.executeQuery();
			while (rs.next()) {
				mail = rs.getString(1);
				System.out.println(mail);
				psd = rs.getString(2);
				System.out.println(psd);
			}
			if (email.equalsIgnoreCase(mail) && password.equals(psd)) {
				dec = true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dec;

	}
}
