package Service;

import java.util.List;

import Model.Student;

public interface StudentService {
	public boolean saveStudent(Student student);
	public List<Student> getStudents();
	public boolean deleteStudent(Student student);
	public List<Student> getStudentByID(Student student);
	public boolean updateStudent(Student student);
}
