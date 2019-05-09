package homework4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import homework3.Product_VO;

public class jdbcZipCode {
	String url = "jdbc:oracle:thin:@192.168.206.31:1521:xe";
	String userId = "PC24_PC";
	String password = "java";
	String sql = "";
	
	public ZipCode_VO sel_Zipcode(String prod_Name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ZipCode_VO vo = new ZipCode_VO();
		
	    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			sql = "select prod_id, prod_name, prod_lgu, prod_buyer, prod_cost,"
					  + " prod_price, prod_sale, prod_outline, prod_detail "
					  + " from prod where prod_name= '"+prod_Name+"'"; 
			rs = stmt.executeQuery(sql);  
			
			while(rs.next()) {
				vo.setZipcode(rs.getString(1));
				vo.setCity(rs.getString(2));
				vo.setStreet(rs.getString(3));
				vo.setStreet_num(rs.getString(4));
			}
				
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (rs != null) try {rs.close();}catch(SQLException e) {}
			if (stmt != null) try {stmt.close();}catch(SQLException e) {}
			if (conn != null) try {conn.close();}catch(SQLException e) {}
		}
	    return vo;
	}
	
}
