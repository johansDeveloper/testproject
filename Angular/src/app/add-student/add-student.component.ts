import {Component, OnInit} from '@angular/core';
import {StudentService} from '../student.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Student} from '../student';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  constructor(private studentService: StudentService) {
  }

  get StudentName() {
    return this.studentSaveForm.get('studentName');
  }

  get Scholarship() {
    return this.studentSaveForm.get('scholarship');
  }

  get DateOfEnrollment() {
    return this.studentSaveForm.get('dateOfEnrollment');
  }

  get Group() {
    return this.studentSaveForm.get('groupId');
  }

  student: Student = new Student();
  submitted = false;

  studentSaveForm = new FormGroup({
    studentName: new FormControl('', [Validators.required, Validators.minLength(3)]),
    groupId: new FormControl('', [Validators.required]),
    scholarship: new FormControl(),
    dateOfEnrollment: new FormControl(),
  });

  static FormatDate(date) {
    const dateArray = date.split('/');
    const dateOut = new Date(dateArray[2], dateArray[1] - 1, dateArray[0]);
    return  dateOut.toDateString();
  }

  ngOnInit() {
    this.submitted = false;
  }

  saveStudent(saveStudent) {
    this.student = new Student();
    this.student.studentName = this.StudentName.value;
    this.student.groupId = this.Group.value;
    this.student.scholarship = this.Scholarship.value;
    this.student.dateOfEnrollment = AddStudentComponent.FormatDate(this.DateOfEnrollment.value);
    this.submitted = true;
    this.save();
  }

  save() {
    this.studentService.createStudent(this.student)
      .subscribe(data => console.log(data), error => console.log(error));
    this.student = new Student();
  }

  addStudentForm() {
    this.submitted = false;
    this.studentSaveForm.reset();
  }
}
