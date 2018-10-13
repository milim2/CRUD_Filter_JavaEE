package sheridantrafalga.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridantrafalga.dao.StudentDAO;
import sheridantrafalga.dao.StudentDAOImplementation;
import sheridantrafalga.model.Student;

public class StudentController extends HttpServlet {

	private StudentDAO dao;
	private static final long serialVersionUID = 1L;
	public static final String LIST_STUDENT = "/listStudent.jsp";
	public static final String INSERT_OR_EDIT = "/student.jsp";

	public StudentController() {
		dao = new StudentDAOImplementation();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String forward = "";
		String action = req.getParameter("action");

		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(req.getParameter("ID"));

			dao.deleteStudent(studentId);
			req.setAttribute("students", dao.getAllStudents());

		} else if (action.equalsIgnoreCase("edit")) {

			forward = INSERT_OR_EDIT;
			int studentId = Integer.parseInt(req.getParameter("ID"));

			Student student = dao.getStudentById(studentId);
			req.setAttribute("student", student);

		} else if (action.equalsIgnoreCase("insert")) {

			forward = INSERT_OR_EDIT;

		} else {

			// List all student records
			forward = LIST_STUDENT;
			req.setAttribute("students", dao.getAllStudents());

		}
		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		Map<String, String> errors = new HashMap<String, String>();

		Student stu = new Student();

//		stu.setStudentID(Integer.parseInt(req.getParameter("studentID")));
//		stu.setFname(req.getParameter("fname"));
//		stu.setLname(req.getParameter("lname"));
//		stu.setCity(req.getParameter("city"));
//		stu.setProvince(req.getParameter("province"));
//		stu.setPostalcode(req.getParameter("postalcode"));
//		stu.setGpa(Double.parseDouble("gpa"));

//		if (req.getParameter("fname").equals("")) {
//			errors.put("fname", "Please enter First name");
//		} else {
//			stu.setFname(req.getParameter("fname"));
//		}
//
//		if (req.getParameter("lname").equals("")) {
//			errors.put("lname", "Please enter Last name");
//		} else {
//			stu.setLname(req.getParameter("lname"));
//		}
//
//		if (req.getParameter("city").equals("")) {
//			errors.put("city", "Please enter City");
//		} else {
//			stu.setCity(req.getParameter("city"));
//		}
//
//		if (req.getParameter("province").equals("")) {
//			errors.put("province", "Please enter Province");
//		} else {
//			stu.setProvince(req.getParameter("province"));
//		}
//
//		if (req.getParameter("postalcode").equals("")) {
//			errors.put("postalcode", "Please enter Postal Code");
//		} else {
//			stu.setProvince(req.getParameter("postalcode"));
//		}
//
//		if (req.getParameter("gpa").equals("")) {
//			errors.put("gpa", "Please enter GPA");
//		} else {
//			stu.setGpa(Double.parseDouble(req.getParameter("gpa")));
//		}
//
//		// Bring the ID
//		String studentId = req.getParameter("studentID");
//
////		if (studentId == null || studentId.isEmpty())
////			dao.addStudent(stu);
////		else {
////			stu.setStudentId(Integer.parseInt(studentId));
////			dao.updateStudent(stu);
////		}
//
//		if (errors.isEmpty()) {
//
//			if (studentId == null || studentId.isEmpty())
//				dao.addStudent(stu);
//			else {
//				stu.setStudentID(Integer.parseInt(studentId));
//				dao.updateStudent(stu);
//			}
//
//			RequestDispatcher view = req.getRequestDispatcher(LIST_STUDENT);
//			req.setAttribute("students", dao.getAllStudents());
//			view.forward(req, resp);
//
//		} else {
//
//			req.setAttribute("errors", errors);
//			req.getRequestDispatcher("validation.jsp").forward(req, resp);
//		}
//
//	}
	}
}