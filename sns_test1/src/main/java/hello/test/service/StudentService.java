package hello.test.service;

import com.github.pagehelper.Page;

import hello.test.entity.Student;

public interface StudentService {

	public Student getInfoById(Integer id);

	public Page<Student> getInfos();
	
}
