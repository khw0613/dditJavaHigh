package homework3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Jdbc_Product {
	String url = "jdbc:oracle:thin:@192.168.206.31:1521:xe";
	String userId = "PC24_PC";
	String password = "java";
	String sql = "";
	
ObservableList<String> list = FXCollections.observableArrayList();
	
	public ObservableList<String> sel_Lprod_Nm() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		list.clear();
		
	    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			sql = "select lprod_nm from lprod"; 
			rs = stmt.executeQuery(sql); 
			
			while(rs.next()) {
				list.add(rs.getString(1));
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
	    return list;
	}
	
	public ObservableList<String> sel_Prod_Name(String lprod_Nm) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		list.clear();
		
	    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			sql = "select prod_name from prod,lprod where prod_lgu = lprod_gu and lprod_nm = '"+lprod_Nm+"'"; 
			rs = stmt.executeQuery(sql);  
			
			while(rs.next()) {
				list.add(rs.getString(1));
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
	    return list;
	}
	
	public Product_VO sel_prod_All(String prod_Name) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product_VO vo = new Product_VO();
		
	    try {
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userId, password);
			stmt = conn.createStatement();
			sql = "select prod_id, prod_name, prod_lgu, prod_buyer, prod_cost,"
					  + " prod_price, prod_sale, prod_outline, prod_detail "
					  + " from prod where prod_name= '"+prod_Name+"'"; 
			rs = stmt.executeQuery(sql);  
			
			while(rs.next()) {
				vo.setProd_Id(rs.getString(1));
				vo.setProd_Name(rs.getString(2));
				vo.setProd_Lgu(rs.getString(3));
				vo.setProd_Buyer(rs.getString(4));
				vo.setProd_Cost(rs.getString(5));
				vo.setProd_Price(rs.getString(6));
				vo.setProd_Sale(rs.getString(7));
				vo.setProd_Outline(rs.getString(8));
				vo.setProd_Detail(rs.getString(9));
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
