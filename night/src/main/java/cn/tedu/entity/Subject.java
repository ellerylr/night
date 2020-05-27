package cn.tedu.entity;

public class Subject {
	private int subjectid;
	private String subjectname;
	public Subject(int subjectid, String subjectname) {
		super();
		this.subjectid = subjectid;
		this.subjectname = subjectname;
	}
	public Subject() {
		super();
	}
	public int getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	@Override
	public String toString() {
		return "Subject [subjectid=" + subjectid + ", subjectname=" + subjectname + "]";
	}
	
}
