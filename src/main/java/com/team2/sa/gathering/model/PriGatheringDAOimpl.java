package com.team2.sa.gathering.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriGatheringDAOimpl implements PriGatheringDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PriGatheringDAOimpl() {
		try {
			Class.forName(GatheringQuery.DRIVER_NAME);
			System.out.println("Driver successed..");
			
//			jdbcConnectionTest();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(GatheringVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					GatheringQuery.URL, 
					GatheringQuery.USER, 
					GatheringQuery.PASSWORD);
			//DML
			pstmt = conn.prepareStatement(GatheringQuery.PRIGATHERING_INSERT);
			pstmt.setString(1, vo.getgName());
			pstmt.setString(2, vo.getgContent());
			pstmt.setString(3, vo.getLogo());
			pstmt.setInt(4, vo.getMinAge());
			pstmt.setInt(5, vo.getMaxAge());
			pstmt.setString(6, vo.getSex());
			pstmt.setString(7, "");
			pstmt.setString(8, "temp_link_for_test");
			pstmt.setString(9, "F");
			
			
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
	public GatheringVO selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
