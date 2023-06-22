package com.sem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sem.dao.EmployeDao;
import com.sem.dao.EmployeDao;
import com.sem.domain.Employe;
import com.sem.helper.semHelpers;
import com.sem.domain.Employe;

@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeDao empDAO = new EmployeDao();
	private List<Employe> listEmployee;
	List<Employe> subEmployeeList = new ArrayList<Employe>();
	private List<Employe> searchEmployee = new ArrayList<Employe>();

	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		listEmployee = empDAO.selectAllUsers();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Action = request.getServletPath();
		switch (Action) {
		case "/delete":

			try {
				deleteEmployee(request, response);
				break;
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "/view":
			viewEmploye(request, response);
			break;
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			addEmploye(request, response);
			break;
		case "/edit":
			try {
				showEditForm(request, response);
				break;

			} catch (SQLException | ServletException | IOException e) {
				e.printStackTrace();
			}

		case "/update":
			editEmploye(request, response);
			break;
		case "/pTOc":
			// probationarToConfirm(request, response);
			try {
				comfirmEmployee(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/statics":
			try {
				statsEmployee(request, response);
			} catch (SQLException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/popup":
			try {
				popEmployee(request, response);
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/list":
			try {
				listEmployee(request, response);
			} catch (SQLException |IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;
		case "/loginValidation":
			ValidateEmp(request, response);
			break;
		default:
			showLogin(request, response);
			break;

		}

	}

	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher Dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		Dispatcher.forward(request, response);
	}


	private void ValidateEmp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	  response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      
      boolean validateAdmin = empDAO.validateAdmin(request.getParameter("email"),request.getParameter("password"));
		if(validateAdmin==true){
			HttpSession session = request.getSession(true); // reuse existing
            // session if exist
            // or create one
            session.setAttribute("user", request.getParameter("email"));
            session.setMaxInactiveInterval(5); // 0 seconds
            init();
			response.sendRedirect("list");
		}
		else{
			out.println("<html> <body>");
			out.println("<div class=\"alert alert-danger\" role=\"alert\">\r\n Either user name or password is wrong.\r\n </div>");     
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		int recordsPerPage = 5;
		int size = listEmployee.size();
		int start = (currentPage * recordsPerPage) - recordsPerPage;
		if (request.getParameter("searchName") == null) {
			if (size - start < recordsPerPage) {
				subEmployeeList = listEmployee.subList(start, size);
			} else {
				subEmployeeList = listEmployee.subList(start, (start + recordsPerPage));
			}
			request.setAttribute("listEmployee", subEmployeeList);

		} else if (request.getParameter("searchName") != null) {
			String firstName = request.getParameter("searchName");
			searchEmployee.clear();
			for (Employe i : listEmployee) {
				if (i.getFirst_name().equalsIgnoreCase(firstName)) {
					searchEmployee.add(i);
				}
				request.setAttribute("searchEmployee", searchEmployee);
			}
		}
		int rows;
		if (request.getParameter("searchName") != null) {
			rows = searchEmployee.size();
		} else {
			rows = listEmployee.size();
		}
		int nOfPages = rows / recordsPerPage;
		if (nOfPages % recordsPerPage > 0) {
			nOfPages++;
		}
		request.setAttribute("noOfPages", nOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("recordsPerPage", recordsPerPage);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list-user.jsp");
		dispatcher.forward(request, response);
	}


//	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// List<Employe> listEmployee = empDAO.selectAllUsers();
//		int currentPage = 1;
//		if (request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));
//		}
//		int recordsPerPage = 5;
//		int size = listEmployee.size();
//		int start = (currentPage * recordsPerPage) - recordsPerPage;
//		if (size - start < 5) {
//			List<Employe> subEmployeeList = listEmployee.subList(start, size);
//			request.setAttribute("listEmployee", subEmployeeList);
//		} else {
//			List<Employe> subEmployeeList = listEmployee.subList(start, (start + recordsPerPage));
//			request.setAttribute("listEmployee", subEmployeeList);
//		}
//		int rows = empDAO.GetNumberOfRows();
//		int nOfPages = rows / recordsPerPage;
//		if (nOfPages % recordsPerPage > 0) {
//			nOfPages++;
//		}
//		request.setAttribute("noOfPages", nOfPages);
//		request.setAttribute("currentPage", currentPage);
//		request.setAttribute("recordsPerPage", recordsPerPage);
//		// request.setAttribute("listEmployee", listEmployee);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list-user.jsp");
//
//		dispatcher.forward(request, response);
//	}

	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("emp_id"));
		empDAO.deleteEmploye(id);
		init();
		response.sendRedirect("list");

	}

	private void viewEmploye(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		Employe Employe = empDAO.viewEmploye(emp_id);
		RequestDispatcher Dispatcher = request.getRequestDispatcher("/WEB-INF/views/view2.jsp");
		request.setAttribute("viewEmployee", Employe);
		Dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher Dispatcher = request.getRequestDispatcher("/WEB-INF/views/newForm.jsp");
		Dispatcher.forward(request, response);
	}

	private void addEmploye(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// int emp_id= Integer.parseInt(request.getParameter("emp_id"));
		int emp_id = semHelpers.EmpidGen();

		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String address = request.getParameter("address");
		String birth_date = request.getParameter("birth_date");
		String gender = request.getParameter("gender");
		String email = semHelpers.EmpMailGen(first_name, last_name);
		// String joining_date=request.getParameter("joining_date");
		String joining_date = semHelpers.getCurrentDate();
		String emp_type = request.getParameter("emp_type");
		String emp_status = request.getParameter("emp_status");
		String contactno = request.getParameter("contactno");
		int exp_level = Integer.parseInt(request.getParameter("exp_level"));
		String IsId = semHelpers.EmpISGen(first_name, last_name);
		Employe emp = new Employe(emp_id, first_name, last_name, address, birth_date, gender, email, joining_date,
				emp_type, emp_status, contactno, exp_level, IsId);
		empDAO.addEmploye(emp);
		init();
		response.sendRedirect("list");

	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		Employe existingUser = empDAO.viewEmploye(emp_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editForm.jsp");
		request.setAttribute("employee", existingUser);
		dispatcher.forward(request, response);
	}

	private void editEmploye(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int emp_id = Integer.parseInt(request.getParameter("emp_id"));
		String address = request.getParameter("address");
		String contactno = request.getParameter("contactno");
		int exp_level = Integer.parseInt(request.getParameter("exp_level"));
		Employe emp = new Employe(emp_id, address, contactno, exp_level);
		empDAO.UpdateEmployee(emp);
		init();
		response.sendRedirect("list");

	}

//	private void probationarToConfirm(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String rs = empDAO.ProviToPermanent();
//		init();
//		response.sendRedirect("list");
//	}
	private void comfirmEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		response.sendRedirect("list");
	}

	private void popEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String rs = empDAO.ProviToPermanent();
		int rs1 = Integer.parseInt(rs);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/popup.jsp");
		request.setAttribute("message", rs1);
		dispatcher.forward(request, response);
	}

	private void statsEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		HashMap<String, String> gendermap = empDAO.StatsgenderEmployee();
		request.setAttribute("genderStat", gendermap);
		HashMap<String, String> typemap = empDAO.StatsTypeEmployee();
		request.setAttribute("typeStat", typemap);
		HashMap<String, String> statusmap = empDAO.StatsStatusEmployee();
		request.setAttribute("statusStat", statusmap);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/stat.jsp");
		dispatcher.forward(request, response);
	}

}