package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;

public interface IStudentService {
    Student findStudentById(Long id);
    Student findStudentByName(String name);
}
