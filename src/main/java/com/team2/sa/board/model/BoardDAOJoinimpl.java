package com.team2.sa.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOJoinimpl implements BoardVOJoinDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAOJoinimpl() {
		System.out.println("BoardDAOJoinimpl()...");
		try {
			Class.forName(BoardQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<BoardVOJoin> selectAll(int gNum) {
		System.out.println("selectAll()...");
		List<BoardVOJoin> vos = new ArrayList<BoardVOJoin	>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			//여기부터
			pstmt = conn.prepareStatement(BoardQuery.SELECTALLBOARD);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				BoardVOJoin vo = new BoardVOJoin();
				vo.setbNum(rs.getInt("bNum"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setwDate(rs.getTimestamp("wDate"));
				vo.setTmpBnum(i);
				vo.setwName(rs.getString("uName"));
				vos.add(vo);
				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vos;
	}

}
