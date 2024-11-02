package com.example.service;

import com.example.model.Student;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;

@Stateless
public class StudentService {

    @PersistenceContext(unitName = "my-persistence-unit")
    private EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void deleteStudent(int studentId) {
        Student student = entityManager.find(Student.class, studentId);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    public Student findStudent(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    public List<Student> getLimitedStudents(int maxResults) {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class);
        query.setMaxResults(maxResults); // встановлюємо максимальну кількість результатів
        return query.getResultList(); // отримуємо список результатів
    }
    // Використання JPQL Functional Expressions: CONCAT і UPPER
    public List<String> getUpperCaseNames() {
        return entityManager.createQuery(
                        "SELECT CONCAT(UPPER(s.name), ' - ', s.email) FROM Student s", String.class)
                .getResultList();
    }
}
