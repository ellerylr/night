package cn.tedu.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static BasicDataSource ds;
	static {
		//创建属性对象 该对象用于读取属性配置文件
				Properties p = new Properties();
				//得到文件的输入流 
				InputStream ips = DBUtils.class.getClassLoader()
						.getResourceAsStream("jdbc.properties");
				//把文件加载到属性对象中
				try {
					p.load(ips);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//读取数据
				String driver = p.getProperty("driver");
				String url = p.getProperty("url");
				String username = p.getProperty("username");
				String password = p.getProperty("password");

				//		//注册驱动
				//		Class.forName(driver);
				//		//获取连接
				//		Connection conn = DriverManager.getConnection(
				//				url, username, password);
				//创建数据库连接池对象
				ds = new BasicDataSource();
				//设置数据库连接信息
				ds.setDriverClassName(driver);
				ds.setUrl(url);
				ds.setUsername(username);
				ds.setPassword(password);//别抄我的 
				//设置初始连接数量
				ds.setInitialSize(3);
				//设置最大连接数量
				ds.setMaxActive(5);
	}
	
	public static Connection getConn() throws Exception {
		
		//从连接池中获取连接 异常抛出
		Connection conn = ds.getConnection();
		System.out.println(conn);
		return conn;
	}
}
