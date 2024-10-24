package com.example.database;

import com.example.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ejb.Stateless;

import java.util.List;

@Stateless
public class DataService {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Student student) {
        entityManager.persist(student);
    }

    public Student read(int id) {
        return entityManager.find(Student.class, id);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(int id) {
        Student student = read(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    public List<Student> findAllStudents() {
        return entityManager.createNamedQuery("Student.findAll", Student.class).getResultList();
    }
}
