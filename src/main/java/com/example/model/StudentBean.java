package com.example.model;

import com.example.database.DataService;
import com.example.model.Student;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class StudentBean {

    @Inject
    private DataService dataService;
    private int studentId;
    private Student student = new Student();
    private List<Student> students;

    public void createStudent() {
        dataService.create(student);
        student = new Student();
        loadStudents();
    }
    public void deleteStudent(int id) {
        dataService.delete(id);
    }
    public void updateStudent() {
        dataService.update(student);
        student = new Student();
        loadStudents();
    }
    public void loadStudent(Student student) {
        this.student = student;
    }
    public List<Student> getStudents() {
        if (students == null) {
            loadStudents();
        }
        return students;
    }

    private void loadStudents() {
        students = dataService.findAllStudents();
    }

    public Student getStudent() {
        return student;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}