package com.Student.Student.repo;

import com.Student.Student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   List<Student>findByCourse(String course);
}
