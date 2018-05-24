package hello.test.service;

import com.github.pagehelper.Page;

import hello.test.entity.Student;

public interface StudentService1 {


	public Page<Student> getInfos1();

	public Student addStudentInfo(Student stu);
	
}
