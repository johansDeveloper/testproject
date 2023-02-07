package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.Student;
import Model.Group;
import Service.StudentService;
import Service.GroupService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class Controller {

    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupService groupService;

    @PostMapping("save-student")
    public boolean saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("students-list")
    public List<Student> allStudents() {
        return studentService.getStudents();
    }

    @GetMapping("group-list")
    public List<Group> allGroups() {
        return groupService.getGroups();
    }

    @DeleteMapping("delete-student/{studentId}")
    public boolean deleteStudent(@PathVariable("studentId") int studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.deleteStudent(student);
    }

    @GetMapping("student/{studentId}")
    public List<Student> allStudentsByID(@PathVariable("studentId") int studentId, Student student) {
        student.setStudentId(studentId);
        return studentService.getStudentByID(student);
    }

    @GetMapping("group/{groupId}")
    public List<Group> allGroupsByID(@PathVariable("groupId") int groupId, Group group) {
        group.setGroupId(groupId);
        return groupService.getGroupByID(group);
    }

    @PostMapping("update-student/{studentId}")
    public boolean updateStudent(@RequestBody Student student, @PathVariable("studentId") int studentId) {
        student.setStudentId(studentId);
        return studentService.updateStudent(student);
    }
}
