package sheridantrafalga.dao;

import java.util.List;

import sheridantrafalga.model.*;

//Data Access Object it is one of J2EE pattern
public interface StudentDAO {

	public void addStudent (Student student);
	public void deleteStudent (int studentID);
	public void updateStudent (Student student);
	public List<Student> getAllStudents();
	public Student getStudentById (int studentID);	
}
