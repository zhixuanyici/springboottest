package hello.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import hello.test.entity.Student;
import hello.test.service.StudentService;
import hello.test.service.StudentService1;

@RestController
@RequestMapping("/student")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentService1 studentService1;
	
	@GetMapping("/add")
	public Student addStudent(
			@RequestParam(value="name")String name,
			@RequestParam(value="number")String number){
		
		Student stu = new Student(name,number,2);
		return studentService1.addStudentInfo(stu);
	}
	
	@GetMapping("/info/{id}")
	public Student getStudentInfoById(@PathVariable("id")Integer id){
		return studentService.getInfoById(id);
	}
	
	@GetMapping("/info/lists")
	public Page<Student> infos(){
		return studentService.getInfos();
	}
	
	
	@GetMapping("/info/lists1")
	public Page<Student> infos1(){
		return studentService1.getInfos1();
	}
}
