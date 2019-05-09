package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

/*
 *    db.properties파일의 내용으로 DB정보를 설정하는 방법
 *  방법1) Properties객체 이용하기
 */
public class DBUtil3 {
	static ResourceBundle bundle; // ResourceBundle객체 변수 선언

	static {
		bundle = ResourceBundle.getBundle("db"); // 객체생성
		System.out.println("드라이버 로딩 성공!");

		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!");
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(bundle.getString("url"), bundle.getString("user"),
					bundle.getString("pass"));
		} catch (SQLException e) {
			System.out.println("DB연결 실패! ");
			return null;
		}
	}
}
