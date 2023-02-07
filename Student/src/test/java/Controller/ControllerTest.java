package Controller;

import Model.Group;
import Model.Student;
import Service.GroupService;
import Service.StudentService;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author JohansCaicedo
 */
@WebMvcTest(Controller.class)
public class ControllerTest {
    
    @Autowired
  private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Autowired
    GroupService groupService;

    public ControllerTest() {

    }

    @Test
    public void saveStudentTest() {
        Student student = new Student();
        student.setStudentName("Name Student");
        student.setScholarship("scolarship");

        boolean response = studentService.saveStudent(student);

        assertTrue(response);
    }

    public void allStudents() {

        List<Student> students
                = studentService.getStudents();
        assertNotNull(students);
    }

    public void allGroups() {

        List<Group> groups = groupService.getGroups();
        assertNotNull(groups);
    }

    public void deleteStudent() {

        int studentId = 0;
        Student student = new Student();
        student.setStudentId(studentId);

        boolean success
                = studentService.deleteStudent(student);

        assertTrue(success);

    }

    public void updateStudent() {

        int studentId = 0;
        Student student = new Student();
        student.setStudentId(studentId);

        boolean response = studentService.updateStudent(student);

        assertTrue(response);
    }

}
