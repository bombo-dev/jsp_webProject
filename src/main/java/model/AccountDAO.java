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

public class AccountDAO extends DAO{
	
	public AccountVO selectOne(AccountVO user) {
		
		String sql = "SELECT * FROM ACCOUNT WHERE ID = ? AND PW = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			AccountVO row = new AccountVO();
			
			row.setBirth(rs.getString("birth"));
			row.setEmail(rs.getString("email"));
			row.setId(rs.getString("id"));
			row.setIdx(rs.getInt("idx"));
			row.setJoinDate(rs.getDate("joindate"));
			row.setName(rs.getString("name"));
			row.setNick(rs.getString("nick"));
			row.setPhone(rs.getString("phone"));
			row.setPw(rs.getString("pw"));
			
			return row;
			
		} catch (SQLException e) {
			System.out.println("SQL selectOne 예외 : " + e.getMessage());
		} finally {
			close();
		}
		
		return null;
		
	}
	
	public int insert(AccountVO input) {
		String sql = "INSERT INTO ACCOUNT(ID, PW, NICK, NAME, BIRTH, PHONE, EMAIL) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input.getId());
			pstmt.setString(2, input.getPw());
			pstmt.setString(3, input.getNick());
			pstmt.setString(4, input.getName());
			pstmt.setString(5, input.getBirth());
			pstmt.setString(6, input.getPhone());
			pstmt.setString(7, input.getEmail());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL insert 예외 : " + e.getMessage());
		} finally {
			close();
		}
		return 0;
	}
}
