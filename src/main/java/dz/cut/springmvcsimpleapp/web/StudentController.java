package dz.cut.springmvcsimpleapp.web;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import dz.cut.springmvcsimpleapp.service.StudentService1;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller @AllArgsConstructor
public class StudentController {
    private  IStudentService studentService;

    @GetMapping("/index")
    public String listAllStudent(Model model,
                                 @RequestParam(name="page",defaultValue = "0")int page,
                                 @RequestParam(name="size", defaultValue = "5") int size,
                                 @RequestParam(name="keyword", defaultValue = "") String keyword){
//        List<Student> students= studentService.findAll();

//        model.addAttribute("studentsList",students);

        //Page<Student> studentsPage= studentService.findAll(PageRequest.of(page,size));
        Page<Student> studentsPage = studentService.findStudentsByNameContains(keyword, PageRequest.of(page,size));
        model.addAttribute("studentsList",studentsPage.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("pageSize",size);
        model.addAttribute("keyword",keyword);
        model.addAttribute("pages",new int[studentsPage.getTotalPages()]);
        return "index";
    }


    @PostMapping("/delete")
    public String delete(Model model,
                         @RequestParam() Long id){
        studentService.deleteStudentById(id);
        return "redirect:/index";
    }


    @GetMapping("/create")
    public String create(){
        return "create";
    }
    @PostMapping("/create")
    public String create(Model model,
                         @RequestParam String name,
                         @RequestParam Date birthDate,
                         @RequestParam int score){

        Student s = new Student();
        s.setName(name); s.setGraduated(false);
        s.setRank(score);s.setBirthDate(new Date());
        studentService.addNewStudent(s);
        return "redirect:/index";
    }

    @GetMapping("/")
    public String home(){
        return "redirect:/index";
    }
}










