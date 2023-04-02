package dz.cut.springmvcsimpleapp.service;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional @AllArgsConstructor
public class StudentService1 implements IStudentService {
    StudentRepository studentRepository;
    @Override
    public Student addNewStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public Student findStudentByNameContains(String keyword) {

        return studentRepository.findStudentByNameContains(keyword);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
