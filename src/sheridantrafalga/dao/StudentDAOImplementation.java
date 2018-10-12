package sheridantrafalga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridantrafalga.util.DBUtil;
import sheridantrafalga.model.Student;

// To create a new class
public class StudentDAOImplementation implements StudentDAO {

	private Connection conn;
	
	public StudentDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	
	//ADD 1 record 
	@Override
	public void addStudent(Student stu) {
		
		try {
			String query = 
					"insert into students (studentID, fName, lname, city, province, postalcode, gpa) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement( query );
			
			ps.setInt( 1, stu.getStudentID());
			ps.setString( 2, stu.getFname());
			ps.setString( 3, stu.getLname());
			ps.setString( 4, stu.getCity());
			ps.setString( 5, stu.getProvince());
			ps.setString( 6, stu.getPostalcode());
			ps.setDouble( 7, stu.getGpa());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		

	
	//DELETE 1 Student record
	@Override
	public void deleteStudent(int StudentID) {
		try {
			String query = "delete from student where studentID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, StudentID);
			ps.executeUpdate();		
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//UPDATE 1 Student record
	@Override
	public void updateStudent(Student stu) {
		try {
			String query = 
					"update students set fname=?, lname=?, city=?, province=?, postalcode=?, gpa=? where studentID=?";
			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString( 1, stu.getFname());
			ps.setString( 2, stu.getLname());
			ps.setString( 3, stu.getCity());
			ps.setString( 4, stu.getProvince());
			ps.setString( 5, stu.getPostalcode());
			ps.setDouble( 6, stu.getGpa());
			ps.setDouble( 7, stu.getStudentID());
			ps.executeUpdate();
			ps.close();
			
	} catch (SQLException e) {
		e.printStackTrace();
	}
		
		
		// List all records
		// Select all or query all
		@Override
		public List<Student> getAllStudents() {
			
			List<Student> students = new ArrayList<Student>();
			
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						("select studentID, fname, lanme, city, province, postalcode, CAST(gpa as DECIMAL(4,2)) As gpa from students"));
			
				while(rs.next()) {
					Student stud = new Student(); // Model (from 1 record)
					
					stud.setStudentID(rs.getInt("studentID"));
					stud.setFname(rs.getString("fname"));
					stud.setLname(rs.getString("lname"));
					stud.setCity(rs.getString("city"));
					stud.setProvince(rs.getString("province"));
					stud.setPostalcode(rs.getString("postalcode"));
					stud.setGpa(rs.getDouble("gpa"));
					
					students.add(stud);
					
				}
				rs.close();
				stmt.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return;
			
		}
		
	
	//LIST 1 SPECIFIC RECORD
	@Override
	public Student getStudentById(int studentid) {
		
		Student student = new Student();
		try {
			
			String query =
					"select * from students where studentID=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,  studentid);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				stu.setStudentID(rs.getInt("studentID"));
				stu.setFname(rs.getString("fname"));
				stu.setLname(rs.getString("lname"));
				stu.setCity(rs.getString("city"));
				stu.setProvince(rs.getString("province"));
				stu.setPostalcode(rs.getString("postalcode"));
				stu.setGpa(rs.getDouble("gpa"));
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return;
	}
	
	
	
//public List<Student> getStudentByGPA(double gpa) {
//		
//		List<Student> students = new ArrayList<Student>();
//		try {
//			
//			String query =
//					"select * from students where GPA=?";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ps.setDouble(1,  gpa);
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				Student stud = new Student();
//				
//				stud.setStudentID(rs.getInt("studentID"));
//				stud.setFname(rs.getString("FirstName"));
//				stud.setLname(rs.getString("LastName"));
//				stud.setCity(rs.getString("City"));
//				stud.setProvince(rs.getString("Province"));
//				stud.setPostalcode(rs.getString("Postalcode"));
//				stud.setGpa(rs.getDouble("GPA"));
//				
//				students.add(stud);
//			}
//			
//			rs.close();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return students;
//	}
//	
	
	
}

}