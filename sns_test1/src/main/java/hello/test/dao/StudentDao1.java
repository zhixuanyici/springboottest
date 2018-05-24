package hello.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import hello.test.entity.Student;

@Mapper
public interface StudentDao1 {


	@Select("select * from  student")      
	public List<Student> findAll1();

	@Insert("insert into student(student_name,student_number,class_id) "
			+ "values(#{studentName},#{studentNumber},#{classId})")
	@Options(useGeneratedKeys=true,keyProperty="studentId") 
	public int addStudentInfo(Student stu); 

	
}
