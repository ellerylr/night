package cn.tedu.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ResultDao;
import cn.tedu.entity.Result;
import cn.tedu.utils.ThUtils;

public class FindResultServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("name");
		
		String names="";
		//取出所有cookie
		Cookie[] cookies =request.getCookies();
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if ("scorename".equals(cookie.getName())) {
					names=URLDecoder.decode(cookie.getValue(),"utf-8");
				}
			}
		}
		if (names!=null&&names.indexOf(studentName)==-1) {
			names=names.length()==0?studentName:names+","+studentName;
		}
		Cookie cc=new Cookie("scorename",URLEncoder.encode(names,"utf-8"));
		cc.setMaxAge(60);
		response .addCookie(cc);
		String[] cnames=null;
		if (names!=null&&names.length()>0) {
			cnames=names.split(",");
		}
		
		ResultDao dao =new ResultDao();
		List<Result> list=dao.findResult(studentName);
		System.out.println(list);
		Context context=new Context();
		context.setVariable("list", list);
		
		context.setVariable("cnames", cnames);
		
		ThUtils.print("findresult.html", context, response);
	}
}
