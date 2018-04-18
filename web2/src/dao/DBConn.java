package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection getConn() {
		try {
			//1. jar파일 로딩
			Class.forName("org.mariadb.jdbc.Driver");
			//2. DB에 접속, 접속된 객체는 conn
			Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kte901", "root", "class901");
			return conn;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
