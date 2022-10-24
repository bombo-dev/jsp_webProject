package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import service.Paging;

public class BoardDAO extends DAO {
	
	public List<BoardVO> selectAll() {
		String sql = "SELECT * FROM BOARD ORDER BY IDX DESC";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO row = new BoardVO();
				row.setIdx(rs.getLong("idx"));
				row.setTitle(rs.getString("title"));
				row.setViewCount(rs.getLong("viewcount"));
				row.setWriteDate(rs.getDate("writedate"));
				row.setWriter(rs.getString("writer"));
				
				list.add(row);
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println("SELECT 전체 불러오기 구문 오류 " + e.getMessage());
		} finally {
			close();
		}
		
		return null;
	}
	
	public Map<String, Object> selectAll(int page) {
		
		String sql = "SELECT * FROM "
				+ "    (SELECT ROWNUM AS R, A.* FROM "
				+ "        (SELECT * FROM BOARD ORDER BY IDX DESC) A) "
				+ " WHERE R BETWEEN ? AND ?";
		
		Map<String, Object>map = new HashMap<String, Object>();
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		Paging p = new Paging(page, boardCount());
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, p.getFirst());
			pstmt.setInt(2, p.getLast());
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO row = new BoardVO();
				
				row.setContents(rs.getString("contents"));
				row.setIdx(rs.getInt("idx"));
				row.setTitle(rs.getString("title"));
				row.setViewCount(rs.getInt("viewCount"));
				row.setWriter(rs.getString("writer"));
				
				list.add(row);
			}
			
			map.put("list", list);
			map.put("page", p);
			
			return map;
		} catch (SQLException e) {
			System.out.println("SQL 예외 : " + e.getMessage());
		} finally {
			close();
		}
		
		return null;
	}
	
	public int boardCount() {
		String sql = "SELECT COUNT(*) AS COUNT FROM BOARD";
		
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			return rs.getInt("count");
		} catch (SQLException e) {
			System.out.println("SQL 예외 : " + e.getMessage());
		} finally {
			close();
		}
		
		
		return 0;
	}
	
	public BoardVO selectOne(long idx) {
		String sql = "SELECT * FROM BOARD WHERE IDX = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, idx);
			
			rs = pstmt.executeQuery();
			rs.next();
			
			BoardVO row = new BoardVO();
			
			row.setIdx(rs.getLong("idx"));
			row.setTitle(rs.getString("title"));
			row.setContents(rs.getString("contents"));
			row.setViewCount(rs.getLong("viewcount"));
			row.setWriteDate(rs.getDate("writedate"));
			row.setWriter(rs.getString("writer"));
			
			return row;
			
		} catch (SQLException e) {
			System.out.println("SQL selectOne 예외발생 : " + e.getMessage());
		} finally {
			close();
		}
		return null;
	}
	
	public int insert(BoardVO input) {
		String sql = "INSERT INTO BOARD(TITLE, CONTENTS, WRITER) VALUES (?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input.getTitle());
			pstmt.setString(2, input.getContents());
			pstmt.setString(3, input.getWriter());
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("글 작성 insert 예외 : " + e.getMessage());
		} finally {
			close();
		}
		return 0;
	}
	
}
