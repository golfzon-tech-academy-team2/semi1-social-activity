package com.team2.sa.album.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardQuery;
import com.team2.sa.vote.model.VoteQuery;

public class AlbumDAOimpl implements AlbumDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AlbumDAOimpl() {
		System.out.println("AlbumDAOimpl()...");
		try {
			Class.forName(BoardQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(AlbumVO vo) {
		int flag = 0;
		//finduNum(id)
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(AlbumQuery.insertAlbum);
			pstmt.setInt(1, vo.getgNum());
			pstmt.setString(2, vo.getFileName());
			pstmt.setInt(3, vo.getuNum());
			pstmt.setString(4, vo.getuName());
			pstmt.setString(5, vo.getType());
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
	public List<AlbumVO> selectAll(int gNum) {
		System.out.println("selectAll()...");
		List<AlbumVO> vos = new ArrayList<AlbumVO>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			//여기부터
			pstmt = conn.prepareStatement(AlbumQuery.selectAll);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				AlbumVO vo = new AlbumVO();
				vo.setFileName(rs.getString("fileName"));
				vo.setgNum(rs.getInt("gNum"));
				vo.setType(rs.getString("type"));
				vo.setuName(rs.getString("uName"));
				vo.setuNum(rs.getInt("uNum"));
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
	public AlbumVO selectOne(int aNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int findUnum(String id) {
		int uNum = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(AlbumQuery.fineUnum); //query�� ��
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				System.out.println(rs.getInt("uNum"));
				uNum = rs.getInt("uNum");
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
		return uNum;
	}

	@Override
	public String findName(String id) {
		String uName = "";
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(AlbumQuery.findName); //query�� ��
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				uName = rs.getString("uName");
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
		return uName;
	}

}
