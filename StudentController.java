package p.example.p;

import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    public class StudentController {
        private final StudentService studentService;
        public StudentController(StudentService studentService) {
            this.studentService = studentService;
        }
        @GetMapping("/all")
        public List<Student> getStudents(){
            return studentService.getStudents();
        }
        @PostMapping("/add")
        public void addStudent(@RequestBody Student student){
            studentService.addStudent(student);
        }
        @GetMapping("/test")
        public String test(){
            return "Test successfull";
        }
    }



