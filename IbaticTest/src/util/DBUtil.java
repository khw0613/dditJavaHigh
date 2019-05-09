package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * JDBC 드라이버를 로딩하고 Connectionro객체를 생성하는 메서드로 구성된 클래
 */
public class DBUtil {
	//처음 생성될때 한번 호출
	static {
		try {
			// 드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패!!");
			e.printStackTrace();
		}
	}
	
	//커넥션 객체를 생성하는 메서드
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.206.31:1521:xe",
					"PC24_PC",
					"java"
					);
		}catch (SQLException e) {
			System.out.println("DB연결 실패!!");
			e.printStackTrace();
			return null;
		}
	}
}
