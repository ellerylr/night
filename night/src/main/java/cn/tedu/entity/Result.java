package cn.tedu.entity;

public class Result {
	private int id;
	private int subjectid;
	private int score;
	
	private Student student;
	private Subject subject;
	public Result(int id, int subjectid, int score, Student student, Subject subject) {
		super();
		this.id = id;
		this.subjectid = subjectid;
		this.score = score;
		this.student = student;
		this.subject = subject;
	}
	public Result(int id, int subjectid, int score) {
		super();
		this.id = id;
		this.subjectid = subjectid;
		this.score = score;
	}
	public Result() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", subjectid=" + subjectid + ", score=" + score + ", student=" + student
				+ ", subject=" + subject + "]";
	}
	
	
}
