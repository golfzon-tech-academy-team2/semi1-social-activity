package com.team2.sa.vote.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardQuery;

public class VoteDAOimpl implements VoteDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public VoteDAOimpl() {
		System.out.println("VoteDAOimpl()...");
		try {
			Class.forName(BoardQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(VoteVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					VoteQuery.URL, 
					VoteQuery.USER, 
					VoteQuery.PASSWORD);
			pstmt = conn.prepareStatement(VoteQuery.INSERTVOTE);
			pstmt.setString(1, vo.getvTitle());
			pstmt.setDate(2, vo.getStartDate());
			pstmt.setDate(3, vo.getEndDate());
			pstmt.setInt(4, vo.getgNum());
			pstmt.setString(5, vo.getvList1());
			pstmt.setString(6, vo.getvList2());
			pstmt.setString(7, vo.getvList3());
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setInt(10, 0);
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
	public List<VoteVO> selectAll(int gNum) {
		List<VoteVO> vos = new ArrayList<VoteVO>();
		try {
			conn = DriverManager.getConnection(
					VoteQuery.URL, 
					VoteQuery.USER, 
					VoteQuery.PASSWORD);
			//????????????
			pstmt = conn.prepareStatement(VoteQuery.SELECTALL);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				VoteVO vo = new VoteVO();
				vo.setvTitle(rs.getString("vTitle"));
				vo.setStartDate(rs.getDate("startDate"));
				vo.setEndDate(rs.getDate("endDate"));
				vo.setvNum(rs.getInt("vNum"));
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
	public VoteVO selectOne(int vNum) {
		VoteVO vo = new VoteVO();
		try {
			conn = DriverManager.getConnection(
					VoteQuery.URL, 
					VoteQuery.USER, 
					VoteQuery.PASSWORD);
			pstmt = conn.prepareStatement(VoteQuery.SELECTONE); //query?????? ?????????
			pstmt.setInt(1, vNum);
			rs = pstmt.executeQuery();//?????????????????? ???????????? ?????????
			
			while(rs.next()){
				vo.setvTitle(rs.getString("vTitle"));
				vo.setvNum(rs.getInt("vNum"));
				vo.setvCnt1(rs.getInt("vCnt1"));
				vo.setvCnt2(rs.getInt("vCnt2"));
				vo.setvCnt3(rs.getInt("vCnt3"));
				vo.setvList1(rs.getString("vList1"));
				vo.setvList2(rs.getString("vList2"));
				vo.setvList3(rs.getString("vList3"));
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
	public int update(String vList, int vNum) {
		int flag = 0;
		System.out.println(vList);
		try {
			conn = DriverManager.getConnection(
					VoteQuery.URL, 
					VoteQuery.USER, 
					VoteQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DML
			if(vList.equals("vCnt1")) {
				pstmt = conn.prepareStatement(VoteQuery.UPDATE1);
			}else if(vList.equals("vCnt2")) {
				pstmt = conn.prepareStatement(VoteQuery.UPDATE2);
			}else if(vList.equals("vCnt3")) {
				pstmt = conn.prepareStatement(VoteQuery.UPDATE3);

			}				
			pstmt.setInt(1, vNum);
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

}
