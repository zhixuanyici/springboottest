package hello.test.entity;

/**
 * Created by fangzhipeng on 2017/4/20.
 */
public class Student {
    private int studentId ;
    private String studentName ;
    private String studentNumber ;
    private int classId;
    
    
    
	public Student() {}
	
	
	
	public Student(String studentName, String studentNumber, int classId) {
		super();
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.classId = classId;
	}


	public Student(int studentId, String studentName, String studentNumber, int classId) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentNumber = studentNumber;
		this.classId = classId;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
    
    
}
