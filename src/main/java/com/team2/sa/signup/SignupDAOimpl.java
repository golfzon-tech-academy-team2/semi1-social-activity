package com.team2.sa.signup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.sa.notification.NotificationQuery;

public class SignupDAOimpl implements SignupDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insert(UserinfoVO vo) {
		
		int flag = 0;
		try {
			Class.forName(SignupQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(SignupQuery.URL, SignupQuery.USER, SignupQuery.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(SignupQuery.SQL_INSERT_USERINFO);
			pstmt.setString(1, vo.getUname());
			pstmt.setString(2, vo.getId());
			pstmt.setString(3, vo.getPw());
			pstmt.setString(4, vo.getSex());
			pstmt.setString(5, vo.getAddr());
			pstmt.setString(6, vo.getTel());
			pstmt.setDate(7, (Date) vo.getBday());
			flag = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(NotificationQuery.SQL_GET_CURRVAL);
			rs = pstmt.executeQuery();
			
			int uNum = 0;
			
			while(rs.next()) {
				uNum = rs.getInt("currval");
				if (rs.next() == true) {
					break;
				}
			}
			
			pstmt = conn.prepareStatement(NotificationQuery.SQL_INSERT_NOTI);
			pstmt.setInt(1, uNum);
			pstmt.setString(2, "회원가입이 완료되었습니다. 소셜 액티비티 가입을 환영합니다!");
			
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
		} // end finally
		return flag;
	}

	@Override
	public int idCheck(String id) {
		int result = -1;
		try {
			Class.forName(SignupQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(SignupQuery.URL, SignupQuery.USER, SignupQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DQL
			pstmt = conn.prepareStatement(SignupQuery.SQL_ID_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				result = 1;
			} else {
				result = 0;
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
