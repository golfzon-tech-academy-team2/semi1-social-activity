package com.team2.sa.gathering.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

}
