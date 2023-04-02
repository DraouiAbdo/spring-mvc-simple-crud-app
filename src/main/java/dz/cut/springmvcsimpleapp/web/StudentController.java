package dz.cut.springmvcsimpleapp.web;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller @AllArgsConstructor
public class StudentController {
    private  IStudentService studentService;

    @GetMapping("/students")
    public String listAllStudent(Model model){
        List<Student> students= studentService.findAll();
        model.addAttribute("studentsList",students);
        return "students";
    }
}
