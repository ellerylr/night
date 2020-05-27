package cn.tedu.entity;

public class Student {
	private String studentno;
	private String studentname;
	public Student(String studentno, String studentname) {
		super();
		this.studentno = studentno;
		this.studentname = studentname;
	}
	public Student() {
		super();
	}
	public String getStudentno() {
		return studentno;
	}
	public void setStudentno(String studentno) {
		this.studentno = studentno;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	@Override
	public String toString() {
		return "Student [studentno=" + studentno + ", studentname=" + studentname + "]";
	}
	
}
