package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public abstract class DAO {
	private Context ctx;
	protected DataSource ds;
	
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	
	public DAO() {
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			
		} catch (NamingException e) {
			System.out.println("생성자 예외 : " + e.getMessage());
		} finally {
			close();
			// DataSource를 불러오면 커넥션이 활성화가 되어 있기 떄문에
			// 바로 닫아줄 필요가 있다. 여기서 실제로 닫는 것은 아니고 pool로 반납하는 것!
		}
	}
	
	protected void close() {
		
		try {
			if( rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String test() {
		
		String sql = "SELECT BANNER FROM v$VERSION";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			return rs.getString("banner");
		} catch (SQLException e) {
			
		} finally {
			close();
		}
		
		
		return null;
	}
}
