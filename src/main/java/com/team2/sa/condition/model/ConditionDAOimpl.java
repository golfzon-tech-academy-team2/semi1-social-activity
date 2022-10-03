package com.team2.sa.condition.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardQuery;
import com.team2.sa.gathering.model.GatheringQuery;

public class ConditionDAOimpl implements ConditionDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public ConditionDAOimpl() {
		try {
			Class.forName(GatheringQuery.DRIVER_NAME);
			System.out.println("Driver successed..");
			
//			jdbcConnectionTest();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String findSex(String id) {
		String sex = "";
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(ConditionQuery.FINDSEX); //query�� ��
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				sex = rs.getString("sex");

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
		return sex;
	}

	@Override
	public int findAge(String id) {
		int age = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			pstmt = conn.prepareStatement(ConditionQuery.FINDAGE); //query�� ��
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()){
				age = rs.getInt("age");

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
		return age;
	}

}
