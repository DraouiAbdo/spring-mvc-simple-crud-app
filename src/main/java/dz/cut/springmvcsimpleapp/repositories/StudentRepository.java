package dz.cut.springmvcsimpleapp.repositories;

import dz.cut.springmvcsimpleapp.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findStudentById(Long id);
    Student findStudentByNameContains(String kw);
}
