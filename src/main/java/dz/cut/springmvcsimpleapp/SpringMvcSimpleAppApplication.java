package dz.cut.springmvcsimpleapp;

import dz.cut.springmvcsimpleapp.entities.Student;
import dz.cut.springmvcsimpleapp.service.IStudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringMvcSimpleAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcSimpleAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(IStudentService studentService){
        return args -> {
//            Stream.of("Amine","Omar","Youcef").forEach( name ->
//                    Student s1 = new Student(null,"Amine",new Date(),true,99);
//            );

            Student s1 = new Student(null,"Nasro",new Date(),true,50);

            Student s2 = new Student(null,"Omar",new Date(),false,20);
            Student s3 = new Student(null,"Youcef",new Date(),true,80);

            studentService.addNewStudent(s1);
            studentService.addNewStudent(s2);
            studentService.addNewStudent(s3);
        };
    }
}
