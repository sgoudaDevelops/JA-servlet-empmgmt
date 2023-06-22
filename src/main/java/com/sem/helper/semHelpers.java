package com.sem.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sem.dao.EmployeDao;

public class semHelpers {
	static int countemp;
	
	public static int EmpidGen() {
		EmployeDao empDao = new EmployeDao();
		Connection connection = empDao.getConnection(); 
		Statement Statements;
		try {
			Statements = connection.createStatement();
			ResultSet rs = Statements.executeQuery("select max(emp_id) from softtek_employe");
			rs.next();
			countemp = rs.getInt(1);
			countemp++;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return countemp;
	}

	public static String EmpISGen(String firstName, String lastName) {
		String isid = "";
		if (firstName.length() >= 2 && lastName.length() >= 2) {
			isid = firstName.substring(0, 2) + lastName.substring(lastName.length() - 2, lastName.length());
			return isid.toUpperCase();
		} else if (firstName.length() >= 2 && lastName.length() == 1) {
			isid = firstName.substring(0, 3) + lastName.substring(0);
			return isid.toUpperCase();
		} else if (firstName.length() < 2 && lastName.length() >= 2) {
			isid = firstName.substring(0) + lastName.substring(lastName.length() - 3);
			return isid.toUpperCase();
		} else if (firstName.length() < 2 && lastName.length() < 2) {
			isid = firstName.substring(0) + lastName.substring(0);
			return isid.toUpperCase();
		} else if (lastName.length() == 0) {
			isid = firstName.substring(0, 2) + firstName.substring(firstName.length() - 2);
			return isid.toUpperCase();
		}
		return isid;
	}

	public static String EmpMailGen(String FirstName, String LastName) {
		//System.out.println(FirstName + "." + LastName + "@softtek.com".toLowerCase());
		return FirstName + "." + LastName + "@softtek.com".toLowerCase();
	}

	public static String Emp_Status(String joining_date) {
		return null;
	}

	public static String getCurrentDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date today = Calendar.getInstance().getTime();
		String strDate = df.format(today);
		return strDate;
	}
	
}
