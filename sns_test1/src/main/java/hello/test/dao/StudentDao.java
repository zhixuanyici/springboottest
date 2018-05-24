package hello.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import hello.test.entity.Student;

@Mapper
public interface StudentDao {


	@Select("SELECT * FROM student WHERE studentid = #{studentid}")
	public Student getInfo(Student stud);

	@Results({  
	    @Result(property="studentId",column="student_id"),     
	    @Result(property="studentName",column="student_name"),     
	    @Result(property="studentNumber",column="student_number"),
//	    @Result(property="classId",column="class_id")
	})  
	
	@Select("select * from  student")      
	public List<Student> findAll(); 

	
}
