package hello.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import hello.test.dao.StudentDao1;
import hello.test.entity.Student;
import hello.test.service.StudentService1;

@Service
public class StudentService1Impl implements StudentService1 {
	
	@Autowired
	StudentDao1 studentDao1;


	@Override
	public Page<Student> getInfos1() {
		
		Page<Student> infos = PageHelper.startPage(1,10);
		studentDao1.findAll1();
		
		System.out.println("infos.getTotal()===="+infos.getTotal());
		System.out.println("infos.size()====="+infos.size());
		return infos;
	}


	@Override
	public Student addStudentInfo(Student stu) {
		
		studentDao1.addStudentInfo(stu);
		
		stu.getStudentId();
		
		return stu;
	}
	


}
