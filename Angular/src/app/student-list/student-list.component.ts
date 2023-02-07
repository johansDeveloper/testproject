import {Component, OnInit} from '@angular/core';
import {StudentService} from '../student.service';
import {GroupService} from '../group.service';
import {Student} from '../student';
import {Observable, Subject} from 'rxjs';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Group} from '../group';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

  constructor(private studentService: StudentService, private groupService: GroupService) {
  }

  get StudentName() {
    return this.studentUpdateForm.get('studentName');
  }

  get Scholarship() {
    return this.studentUpdateForm.get('scholarship');
  }

  get DateOfEnrollment() {
    return this.studentUpdateForm.get('dateOfEnrollment');
  }

  get StudentId() {
    return this.studentUpdateForm.get('studentId');
  }

  get GroupId() {
    return this.studentUpdateForm.get('groupId');
  }

  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();

  students: Observable<Student[]>;
  groups: Observable<Group[]>;
  student: Student = new Student();
  deleteMessage = false;
  studentList: any;
  groupList: any;
  isUpdated = false;

  studentUpdateForm = new FormGroup({
    studentId: new FormControl(),
    groupId: new FormControl(),
    studentName: new FormControl('', [Validators.required, Validators.minLength(3)]),
    scholarship: new FormControl(),
    dateOfEnrollment: new FormControl()
  });

  ngOnInit() {
    this.isUpdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [[6, 16, 20, -1], [6, 16, 20, 'All']],
      processing: true
    };
    this.studentService.getStudentList().subscribe(data => {
      this.students = data;
      this.dtTrigger.next();
    });
    this.groupService.getGroupList().subscribe(data => {
      this.groups = data;
    });
  }

  getGroup(student: Student) {
    this.groupService.getGroup(student.studentId).subscribe(data => {
      this.groupList = data;
    });
    return this.groupList.groupNumber;
  }

  deleteStudent(id: number) {
    this.studentService.deleteStudent(id).subscribe(data => {
        console.log(data);
        this.deleteMessage = true;
        this.studentService.getStudentList().subscribe(data => {
          this.students = data;
        });
      },
      error => console.log(error));
  }

  updateStudent(id: number) {
    this.studentService.getStudent(id).subscribe(data => {
        this.studentList = data;
      },
      error => console.log(error));
  }

  updateStu(updStu) {
    this.student = new Student();
    this.student.studentId = this.StudentId.value;
    this.student.studentName = this.StudentName.value;
    this.student.groupId = this.GroupId.value;
    this.student.scholarship = this.Scholarship.value;
    this.student.dateOfEnrollment = this.DateOfEnrollment.value;

    this.studentService.updateStudent(this.student.studentId, this.student).subscribe(data => {
        this.isUpdated = true;
        this.studentService.getStudentList().subscribe(data => {
          this.students = data;
        });
      },
      error => console.log(error));
  }

  changeIsUpdate() {
    this.isUpdated = false;
  }
}
