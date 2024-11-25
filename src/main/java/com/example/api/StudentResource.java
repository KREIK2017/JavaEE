package com.example.api;

import com.example.model.Student;
import com.example.service.StudentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/students") // Базовий шлях API
@Produces(MediaType.APPLICATION_JSON) // Формат відповіді - JSON
@Consumes(MediaType.APPLICATION_JSON) // Формат запиту - JSON
public class StudentResource {

    @Inject
    private StudentService studentService;

    // 1. Створення нового студента
    @POST
    public Response createStudent(Student student) {
        studentService.createStudent(student);
        return Response.status(Response.Status.CREATED).entity("Студент створений").build();
    }

    // 2. Отримання всіх студентів
    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 3. Отримання студента за ID
    @GET
    @Path("/{id}")
    public Response getStudentById(@PathParam("id") int id) {
        Student student = studentService.findStudent(id);
        if (student != null) {
            return Response.ok(student).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Студент не знайдений").build();
        }
    }

    // 4. Оновлення студента
    @PUT
    @Path("/{id}")
    public Response updateStudent(@PathParam("id") int id, Student updatedStudent) {
        Student student = studentService.findStudent(id);
        if (student != null) {
            updatedStudent.setId(id); // встановлюємо ID для оновлення
            studentService.updateStudent(updatedStudent);
            return Response.ok("Студент оновлений").build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Студент не знайдений").build();
        }
    }

    // 5. Видалення студента за ID
    @DELETE
    @Path("/{id}")
    public Response deleteStudent(@PathParam("id") int id) {
        studentService.deleteStudent(id);
        return Response.ok("Студент видалений").build();
    }

    // 6. Пошук обмеженої кількості студентів
    @GET
    @Path("/limited")
    public List<Student> getLimitedStudents(@QueryParam("maxResults") int maxResults) {
        return studentService.getLimitedStudents(maxResults);
    }

    // 7. Використання JPQL Functional Expressions
    @GET
    @Path("/uppercase")
    public List<String> getUpperCaseNames() {
        return studentService.getUpperCaseNames();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudentsAsJson() {
        return studentService.getStudentsAsJson();
    }

}
