package com.Student.Student.controller;

import com.Student.Student.model.Student;
import com.Student.Student.response.ApiResponse;
import com.Student.Student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public String hello(){
        return "annu";
    }

    @PostMapping
    public String hy(){
        return "annu";
    }*/


    @RestController
    @RequestMapping("/students")
    public class StudentController {

        @Autowired
        private StudentService service;

        @GetMapping
        public ResponseEntity<ApiResponse<List<Student>>>getStudents() {

            List<Student> students = service.getAllStudents();
            ApiResponse<List<Student>> response = new ApiResponse<>(
                    ApiResponse.SUCCESS,
                    "Student fetched successfully",
                    students

            );
            return new ResponseEntity<>( response, HttpStatus.OK);
        }


        @GetMapping("/{id}")
        public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable Long id){
            Student student= service.getStudentById(id);
            ApiResponse<Student> response=new ApiResponse<>(
                    ApiResponse.SUCCESS,
                    "Student fetched successfully ",
                    student

            );
            return new ResponseEntity<>(response,HttpStatus.OK);
        }



        @PostMapping
        public ResponseEntity<ApiResponse< Student>>addStudent(@RequestBody Student student) {
            Student students= service.addStudent(student);
            ApiResponse<Student> response=new ApiResponse<>(
                    ApiResponse.SUCCESS, "Student added successfully",
                    student
            );
            return new ResponseEntity<>(response,HttpStatus.OK);
        }


        @PutMapping("/{id}")
        public ResponseEntity<ApiResponse< Student>> updateStudent(@PathVariable Long id,@RequestBody Student student){
            Student students= service.updateStudent(id,student);
            ApiResponse<Student> response=new ApiResponse<>(
                    ApiResponse.SUCCESS,
                    "Student updated successfully",
                    student
            );
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
   /* @DeleteMapping("{id}")
        public ResponseEntity<String> deleteStudent(@PathVariable Long id){
            //return service.deleteStudent(id);
            String message=service.deleteStudent(id);
            return new ResponseEntity<>( message,HttpStatus.FOUND);
    }*/

        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponse<String>> deleteStudent(
                @PathVariable Long id){

            String message = service.deleteStudent(id);
            ApiResponse<String> response = new ApiResponse<>(
                    ApiResponse.SUCCESS,
                    message,
                    null
            );

            return new ResponseEntity<>(response, HttpStatus.OK);
        }


        @GetMapping("/course/{course}")
        public List<Student>searchByCourse(@PathVariable String course){
            return service.searchByCourse(course);
    }
    }
