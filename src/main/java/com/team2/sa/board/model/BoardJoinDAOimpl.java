package com.team2.sa.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardJoinDAOimpl implements BoardJoinDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardJoinDAOimpl() {
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
	public List<BoardJoinVO> selectAll(int gNum) {
		System.out.println("selectAll()...");
		List<BoardJoinVO> vos = new ArrayList<BoardJoinVO	>();
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
				BoardJoinVO vo = new BoardJoinVO();
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

	@Override
	public BoardJoinVO selectOne(int bNum) {
		BoardJoinVO vo = new BoardJoinVO();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(BoardQuery.SELECTONEBOARD); //query�� ��
			pstmt.setInt(1, bNum);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				vo.setbNum(bNum);;
				vo.setbContent(rs.getString("bContent"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setwName(rs.getString("uName"));
				vo.setwDate(rs.getTimestamp("wDate"));

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
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

	@Override
	public BoardJoinVO selectNotice(int gNum) {
		BoardJoinVO vo = new BoardJoinVO();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(BoardQuery.SHOWNOTICE);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				vo.setbNum(rs.getInt("bNum"));
				vo.setbContent(rs.getString("bContent"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setwName(rs.getString("uName"));
				vo.setwDate(rs.getTimestamp("wDate"));
				if (rs.next() == true) {
					break;
				}
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
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return vo;
	}

}
