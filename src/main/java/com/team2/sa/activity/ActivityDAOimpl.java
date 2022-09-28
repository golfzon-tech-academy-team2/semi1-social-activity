package com.team2.sa.activity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.sa.gathering.model.GatheringVO;
import com.team2.sa.mypage.MypageQuery;
import com.team2.sa.signup.SignupQuery;

public class ActivityDAOimpl implements ActivityDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public GatheringVO getGname(int gNum) {
		GatheringVO result = new GatheringVO();
		try {
			Class.forName(MypageQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(MypageQuery.URL, MypageQuery.USER, MypageQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DQL
			pstmt = conn.prepareStatement(ActivityQuery.SQL_GETGNAME);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.setgNum(rs.getInt("gNum"));
				result.setgName(rs.getString("gName"));
				result.setLogo(rs.getString("logo"));
				if (rs.next() == true) {
					break;
				}
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void insert(ActivityVO vo) {
		try {
			Class.forName(SignupQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(ActivityQuery.SQL_INSERT);
			pstmt.setInt(1, vo.getgNum());
			pstmt.setString(2, vo.getaName());
			pstmt.setString(3, vo.getaContent());
			pstmt.setDate(4, vo.getaStartDay());
			pstmt.setDate(5, vo.getaEndDay());
			pstmt.setString(6, vo.getLocation());
			pstmt.setDate(7, vo.getStartDate());
			pstmt.setDate(8, vo.getEndDate());
			pstmt.setInt(9, vo.getMinAge());
			pstmt.setInt(10, vo.getMaxAge());
			pstmt.setString(11, vo.getSex());
			pstmt.setInt(12, vo.getMaxPerson());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
