package com.team2.sa.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOimpl implements BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAOimpl() {
		System.out.println("BoardDAOimpl()...");
		try {
			Class.forName(BoardQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(BoardVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DML
			pstmt = conn.prepareStatement(BoardQuery.INSERTBOARD);
			pstmt.setString(1, vo.getbTitle());
			pstmt.setString(2, vo.getbContent());
			pstmt.setInt(3, vo.getgNum());
			pstmt.setString(4, vo.getWriter());
			flag = pstmt.executeUpdate();
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
		
		return flag;
	}

	@Override
	public int update(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BoardVO> selectAll(int gNum) {
		System.out.println("selectAll()...");
		List<BoardVO> vos = new ArrayList<BoardVO	>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			
			pstmt = conn.prepareStatement(BoardQuery.SELECTALLBOARD);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setbContent(rs.getString("bContent"));
				vo.setbNum(rs.getInt("bNum"));
				vo.setbTitle(rs.getString("bTitle"));
				vo.setgNum(rs.getInt("gNum"));
				vo.setwDate(rs.getTimestamp("wDate"));
				vo.setWriter(rs.getString("writer"));
				vo.setTmpBnum(i);
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
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

}
