package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil2 {
	/*
	 * db.properties 파일의 내용으로 DB정보를 설정하는 방법 방법1) properties객체 이용하기
	 */
	static Properties prop;

	static {
		prop = new Properties();

		File f = new File("res/db.properties");

		try {
			FileInputStream fin = new FileInputStream(f);
			prop.load(fin);

			Class.forName(prop.getProperty("driver"));

		} catch (IOException e) {
			System.out.println("File load fail");
		} catch (ClassNotFoundException e) {
			System.out.println("DB connection fail");
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("Connection fail to Dbatabase");
			return null;
		}
	}

}