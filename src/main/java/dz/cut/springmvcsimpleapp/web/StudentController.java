package dz.cut.springmvcsimpleapp.web;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller @AllArgsConstructor
public class StudentController {
    private  IStudentService studentService;

    @GetMapping("/students")
    public String listAllStudent(Model model,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size", defaultValue = "5") int size){
//        List<Student> students= studentService.findAll();

//        model.addAttribute("studentsList",students);
        Page<Student> studentsPage= studentService.findAll(PageRequest.of(page,size));
        model.addAttribute("studentsList",studentsPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("pageSize",size);
        model.addAttribute("pages",new int[studentsPage.getTotalPages()]);
        return "students";
    }
}
