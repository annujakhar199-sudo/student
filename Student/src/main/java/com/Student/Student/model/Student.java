package com.Student.Student.model;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.http.ResponseEntity;


@Entity
public class Student {
@Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String course;
    @Lob
    private byte[] image;

    public Student(){

    }

    public Student(Long id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }
}
