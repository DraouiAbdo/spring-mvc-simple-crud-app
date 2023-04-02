package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;

public interface IStudentService {
    Student addNewStudent(Student student);
    Student findStudentById(Long id);
    Student findStudentByNameContains(String keyword);
}
