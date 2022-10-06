package com.team2.sa.gathering.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.notification.NotificationQuery;

public class GatheringUserInfoDAOimpl implements GatheringUserInfoDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GatheringUserInfoDAOimpl() {
		try {
			Class.forName(GatheringQuery.DRIVER_NAME);
			System.out.println("Driver successed..");
			
//			jdbcConnectionTest();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(int gNum, String roll, String signedid) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					GatheringQuery.URL, 
					GatheringQuery.USER, 
					GatheringQuery.PASSWORD);
			//DML
			pstmt = conn.prepareStatement(GatheringQuery.PUBGATHERING_JOIN);
			pstmt.setInt(1, gNum);
			pstmt.setString(2, roll);
			pstmt.setString(3, signedid);
			
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(NotificationQuery.SQL_GET_GNAME);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			
			String gName = "";
			
			while(rs.next()) {
				gName = rs.getString("gname");
				if (rs.next() == true) {
					break;
				}
			}
			
			pstmt = conn.prepareStatement(NotificationQuery.SQL_GET_UNUM);
			pstmt.setString(1, signedid);
			rs = pstmt.executeQuery();
			
			int uNum = 0;
			
			while(rs.next()) {
				uNum = rs.getInt("unum");
				if (rs.next() == true) {
					break;
				}
			}
			
			flag = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(NotificationQuery.SQL_INSERT_NOTI);
			pstmt.setInt(1, uNum);
			pstmt.setString(2, gName + " 모임 생성이 완료되었습니다");
			
			pstmt.executeUpdate();
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
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GatheringUserInfoVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GatheringUserInfoVO selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	//생성 즉시 gNum을 가져오는 method 
	public int getGnum() {
		int gNum = 0;
		try {
			conn = DriverManager.getConnection(GatheringQuery.URL,GatheringQuery.USER,GatheringQuery.PASSWORD);
			pstmt = conn.prepareStatement(GatheringQuery.GET_GNUM);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				gNum = rs.getInt("max");
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
		return gNum;
	}

}
