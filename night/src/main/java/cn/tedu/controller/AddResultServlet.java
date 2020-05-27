package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.ResultDao;
import cn.tedu.entity.Result;
import cn.tedu.entity.Student;
import cn.tedu.entity.Subject;

public class AddResultServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentno=request.getParameter("studentno");
		int subjectid=Integer.parseInt(request.getParameter("subjectid"));
		String studentname=request.getParameter("studentname");
		int score=Integer.parseInt(request.getParameter("score"));
		
		Result r=new Result();
		Student s=new Student();
		Subject su=new Subject();
		s.setStudentno(studentno);
		su.setSubjectid(subjectid);
		r.setStudent(s);
		r.setSubject(su);
		r.setScore(score);
		
		
		ResultDao dao=new ResultDao();
		dao.addResult(r);
		response.sendRedirect("find.html");
	}
}
