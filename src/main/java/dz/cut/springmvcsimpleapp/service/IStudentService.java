package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Student addNewStudent(Student student);
    Student findStudentById(Long id);
    Student findStudentByNameContains(String keyword);
    Page<Student> findAll(Pageable pageable);
}
