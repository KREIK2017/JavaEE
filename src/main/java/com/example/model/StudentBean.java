package com.example.model;

 import com.example.service.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class StudentBean implements Serializable {

    @EJB
    private StudentService studentService;

    private Student student = new Student();
    private List<Student> students;
    private int studentId;
    private List<Student> limitedStudents;
    @PostConstruct
    public void init() {
        students = studentService.getAllStudents();
        limitedStudents = studentService.getLimitedStudents(5); // наприклад, 5 студентів

    }

    public void createStudent() {
        studentService.createStudent(student);
        students = studentService.getAllStudents();
        student = new Student();  // Очищення після створення
    }

    public void deleteStudent(int id) {
        studentService.deleteStudent(id);
        students = studentService.getAllStudents();
    }

    public void loadStudent(Student student) {
        this.student = studentService.findStudent(student.getId());
    }

    public void updateStudent() {
        studentService.updateStudent(student);
        students = studentService.getAllStudents();
    }
    public void findStudent() {
        student = studentService.findStudent(studentId);
    }
    private List<String> upperCaseNames;
    public List<String> getUpperCaseNames() {
        if (upperCaseNames == null) {
            upperCaseNames = studentService.getUpperCaseNames();
        }
        return upperCaseNames;
    }
    // Getters and Setters
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public List<Student> getStudents() { return students; }
    public void setStudents(List<Student> students) { this.students = students; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public List<Student> getLimitedStudents() {
        return limitedStudents; // Виправлено
    }
}
