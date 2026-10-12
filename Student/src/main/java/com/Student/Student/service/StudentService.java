package com.Student.Student.service;

import com.Student.Student.model.Student;
import com.Student.Student.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElseThrow(()->
                new RuntimeException("Student not found"));
    }

    public  Student addStudent(Student student) {
        return repository.save(student);
    }


    public Student updateStudent(Long id, Student newStudent) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        existingStudent.setName(newStudent.getName());
        existingStudent.setCourse(newStudent.getCourse());

        return repository.save(existingStudent);
    }

    public String deleteStudent(Long id) {
        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));
        repository.delete(existingStudent);
        return "deleted successfully";
    }

    public List<Student>searchByCourse(String course){
        return repository.findByCourse(course);
    }


}
