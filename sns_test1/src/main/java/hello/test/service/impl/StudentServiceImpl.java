package hello.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import hello.test.dao.StudentDao;
import hello.test.entity.Student;
import hello.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao studentDao;

	@Override
	public Student getInfoById(Integer id) {
		
		Student stud = new Student();
		stud.setStudentId(id);
		
		return studentDao.getInfo(stud);
		
	}

	@Override
	public Page<Student> getInfos() {
		
		Page<Student> infos = PageHelper.startPage(1,10);
		studentDao.findAll();
		
		long res = infos.getTotal();
		
		int size = infos.size();
		
		Student stu = infos.get(0);
		
		return infos;
	}

}
