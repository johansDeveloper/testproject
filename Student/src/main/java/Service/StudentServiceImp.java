package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.StudentDAO;
import Model.Student;

@Service
@Transactional
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDAO studentDao;

    @Override
    public boolean saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.getStudents();
    }

    @Override
    public boolean deleteStudent(Student student) {
        return studentDao.deleteStudent(student);
    }

    @Override
    public List<Student> getStudentByID(Student student) {
        return studentDao.getStudentByID(student);
    }

    @Override
    public boolean updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
