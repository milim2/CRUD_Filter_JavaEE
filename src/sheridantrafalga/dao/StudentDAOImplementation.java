package sheridantrafalga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridantrafalga.model.Student;
import sheridantrafalga.util.DBUtil;

public class StudentDAOImplementation implements StudentDAO {

	
private Connection conn;
	
	public StudentDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	public void addStudent(Student stu) {
		
		try {
			String query = "insert into students(fname, lname, city, province, postalcode, gpa)values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, stu.getFname());
			ps.setString(2, stu.getLname());
			ps.setString(2, stu.getCity());
			ps.setString(2, stu.getProvince());
			ps.setString(3, stu.getPostalcode());
			ps.setDouble(4, stu.getGpa());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteStudent(int StudentId) {
		try {
			
			String query = "delete from students where studentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, StudentId);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateStudent(Student stu) {
		
		try {
			
			String query = "UPDATE students SET fname=?, lname=?, city=?, province=?, postalcode=?, gpa=? WHERE studentID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, stu.getFname());
			ps.setString(2, stu.getLname());
			ps.setString(3, stu.getCity());
			ps.setString(4, stu.getProvince());
			ps.setString(5, stu.getPostalcode());
			ps.setDouble(6, stu.getGpa());
			
			ps.setInt(7, stu.getStudentID());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	// SELECT ALL or QUERY ALL
	public List<Student> getAllStudents() {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			
			Statement stmt = conn.createStatement();
			// select CAST(gpa as DECIMAL(3, 2)) AS gpa from student;
			// ResultSet rs = stmt.executeQuery("select * from student");
			
			ResultSet rs = stmt.executeQuery(
			("select studentID, fname, lname, city, province, postalcode, CAST(gpa as DECIMAL(3, 2)) As gpa from students"));
			
			while(rs.next()) {
				Student stu = new Student();
				stu.setStudentID (rs.getInt("studentID"));
				stu.setFname (rs.getString("fname"));
				stu.setLname (rs.getString("lname"));
				stu.setCity (rs.getString("city"));
				stu.setProvince (rs.getString("province"));
				stu.setPostalcode (rs.getString("postalcode"));
				stu.setGpa (rs.getDouble("gpa"));
				
				students.add(stu);
			}
			rs.close();
			stmt.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return students;		
	}
	
	
	public Student getStudentById(int studentId) {
		
		Student stu = new Student();
		try {
			
			String query = "select * from students where studentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				stu.setStudentID(rs.getInt("studentID"));
				stu.setFname(rs.getString("fname"));
				stu.setLname(rs.getString("lname"));
				stu.setCity (rs.getString("city"));
				stu.setProvince (rs.getString("province"));
				stu.setPostalcode (rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("gpa"));
				
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return stu;
		
	}
	
	
	public List<Student> getStudentByProgram(String city) {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			
			String query = "select * from students where city=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, city);
			ResultSet rs = ps.executeQuery();
						
			while(rs.next()) {
				
				Student stu = new Student();
				
				stu.setStudentID(rs.getInt("studentID"));
				stu.setFname(rs.getString("fname"));
				stu.setLname(rs.getString("lname"));
				stu.setCity (rs.getString("city"));
				stu.setProvince (rs.getString("province"));
				stu.setPostalcode (rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("gpa"));
				
				students.add(stu);
			}
			rs.close();
			// stmt.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return students;		
	}
	
	
	public List<Student> getStudentByGPA (double gpa) {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			
			//Convert JAVA double to MySQL decimal datatype
			//CAST(gpa as DECIMAL(3,2)) AS gpa
			
			String query = "select * from students where gpa=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setDouble(1, gpa);		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Student stu = new Student();
				
				stu.setStudentID(rs.getInt("studentID"));
				stu.setFname(rs.getString("fname"));
				stu.setLname(rs.getString("lname"));
				stu.setCity (rs.getString("city"));
				stu.setProvince (rs.getString("province"));
				stu.setPostalcode (rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("gpa"));
				
				students.add(stu);
			}
			rs.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return students;		
	}
}
