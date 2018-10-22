package sheridantrafalga.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridantrafalga.dao.StudentDAO;
import sheridantrafalga.dao.StudentDAOImplementation;
import sheridantrafalga.model.Student;

public class StudentController extends HttpServlet {

	private StudentDAO dao;
	

	private String gpastr; // (GPA as a String)
	private double gpadbl; // (GPA as a double primitive)

	// Tomcat 6 (older Tomcat Implementation was looking for this)
	private static final long serialversionUID = 7878L;
	
	public static final String LIST_STUDENT = "/listStudent.jsp"; // for only display
	public static final String INSERT_OR_EDIT = "/student.jsp";
	public static final String LIST_STUDENTS_BY_CITY = "/listStudentsByCity.jsp";
	public static final String LIST_STUDENTS_WITH_GPA = "/listStudentsWithGPA.jsp";

	public StudentController() {
		dao = new StudentDAOImplementation();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		String action = req.getParameter("action");
		String forward = "";

		if (action.equalsIgnoreCase("delete")) {
		
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(req.getParameter("studentId"));

			dao.deleteStudent(studentId);
			
			req.setAttribute("students", dao.getAllStudents());
			
			
		} else if (action.equalsIgnoreCase("edit")) {
			
			forward = INSERT_OR_EDIT;
			
			int studentId = Integer.parseInt(req.getParameter("studentId"));

			Student student = dao.getStudentById(studentId);
			
			req.setAttribute("student", student);
			
			
		} else if (action.equalsIgnoreCase("insert")) {
			
			forward = INSERT_OR_EDIT;
			
			
		} else if (action.equalsIgnoreCase("searchstudentsbycity")) {

			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_BY_CITY;
			
			String cityRequest = req.getParameter("city");

			req.setAttribute("students", dao.getStudentByCity(cityRequest));
			
			
		} else if (action.equalsIgnoreCase("searchstudentswithgpa")) {

			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_WITH_GPA;
			
			String gpaRequest = req.getParameter("gpa");
			
			double gpadblRequest = Double.parseDouble(gpaRequest);
			req.setAttribute("students", dao.getStudentByGpa(gpadblRequest));
			
			
		} else {

			// LIST ALL RECORDS or Students
			forward = LIST_STUDENT;
			req.setAttribute("students", dao.getAllStudents());
		}

		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		Student student = new Student();
		
		student.setFname(req.getParameter("fname"));
		student.setLname(req.getParameter("lname"));
		student.setCity(req.getParameter("city"));
		student.setProvince(req.getParameter("province"));
		student.setPostalcode(req.getParameter("postalcode"));

		// valueOf or try-catch block
		gpastr = req.getParameter("gpa");

		try {
			gpadbl = Double.parseDouble(gpastr);
			
		} catch (NumberFormatException e) {
			
			throw new RuntimeException(gpadbl + " is not a number");
		}

	
		student.setGpa(gpadbl);

		String studentId = req.getParameter("studentID");

		if (studentId == null || studentId.isEmpty())
			dao.addStudent(student);
		else {
			student.setStudentID(Integer.parseInt(studentId));
			dao.updateStudent(student);
		}		
		
		RequestDispatcher view = req.getRequestDispatcher(LIST_STUDENT);
		req.setAttribute("students", dao.getAllStudents());
		
		view.forward(req, resp);

	}

}
