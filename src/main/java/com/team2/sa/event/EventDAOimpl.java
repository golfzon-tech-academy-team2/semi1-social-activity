package com.team2.sa.event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EventDAOimpl implements EventDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public void insert(EventVO vo) {

		try {
			Class.forName(EventQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(EventQuery.URL, EventQuery.USER, EventQuery.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(EventQuery.SQL_INSERT_EVENT);
			pstmt.setString(1, vo.geteTitle());
			pstmt.setString(2, vo.geteContent());
			pstmt.setString(3, vo.getGift());
			pstmt.setInt(4, vo.getaNum());
			
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

	@Override
	public void deleteEvent(int eNum) {
		try {
			Class.forName(EventQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(EventQuery.URL, EventQuery.USER, EventQuery.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(EventQuery.SQL_DELETE_EVENT);
			pstmt.setInt(1, eNum);
			
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
