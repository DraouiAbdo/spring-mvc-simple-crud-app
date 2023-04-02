package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;

import java.util.List;

public interface IStudentService {
    Student addNewStudent(Student student);
    Student findStudentById(Long id);
    Student findStudentByNameContains(String keyword);
    List<Student> findAll();
}
