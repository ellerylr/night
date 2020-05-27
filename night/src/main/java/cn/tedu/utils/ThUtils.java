package cn.tedu.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThUtils {
	private static TemplateEngine te;
	static {
		te=new TemplateEngine();
		ClassLoaderTemplateResolver r=new ClassLoaderTemplateResolver();
		r.setCharacterEncoding("UTF-8");
		te.setTemplateResolver(r);
	}
	public static void print(String fileName,Context context,HttpServletResponse response) throws IOException {
		String html=te.process(fileName, context);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
	}
}
