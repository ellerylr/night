package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Result;
import cn.tedu.entity.Student;
import cn.tedu.entity.Subject;
import cn.tedu.utils.DBUtils;

public class ResultDao {

	public List<Result> findResult(String studentName) {
		ArrayList<Result> list=new ArrayList<>();
		//获取数据库连接
		try (Connection conn = DBUtils.getConn();) {
			String sql="select s.studentno,s.studentname,sub.subjectname,r.score from result r join student s on r.studentno=s.studentno "
					+ "join subject sub on sub.subjectid=r.subjectid where s.studentname=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, studentName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student s=new Student();
				Result r=new Result();
				Subject sub=new Subject();
				s.setStudentno(rs.getString(1));
				s.setStudentname(rs.getString(2));
				r.setScore(rs.getInt(4));
				sub.setSubjectname(rs.getString(3));
				
				r.setSubject(sub);
				r.setStudent(s);
				
				list.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addResult(Result r) {
		//获取数据库连接
		try (Connection conn = DBUtils.getConn();) {
			PreparedStatement ps = conn.prepareStatement("insert into result values (null,?,?,?,current_date)");

			ps.setString(1, r.getStudent().getStudentno());
			ps.setInt(2, r.getSubject().getSubjectid());
			ps.setInt(3, r.getScore());
			ps.executeUpdate();
			System.out.println("添加完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
