package com.team2.sa.login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.notification.NotificationVO;

public class SigninDAOimpl implements SigninDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Override
	public int signin(String id, String pw) {

		int result = -1;
		try {
			Class.forName(SigninQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(SigninQuery.URL, SigninQuery.USER, SigninQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DQL
			pstmt = conn.prepareStatement(SigninQuery.SQL_ID_EXIST);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
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
	@Override
	public List<NotificationVO> getAlerts(String id) {
		List<NotificationVO> vos = new ArrayList<NotificationVO>();
		try {
			Class.forName(SigninQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(SigninQuery.URL, SigninQuery.USER, SigninQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DQL
			pstmt = conn.prepareStatement(SigninQuery.SQL_CHECK_NOTIFICATION);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NotificationVO vo = new NotificationVO();
				vo.setNnum(rs.getInt("nnum"));
				vo.setUnum(rs.getInt("unum"));
				vo.setContent(rs.getString("content"));
				
				if(rs.getInt("mm") < 60) {
					vo.setWhen(Integer.toString(rs.getInt("mm")) + "분 전");
				} else {
					if (rs.getInt("hh") <= 23) {
						vo.setWhen(Integer.toString(rs.getInt("hh")) + "시간 전");
					} else {
						if (rs.getInt("dd") <= 364) {
							vo.setWhen(Integer.toString(rs.getInt("dd")) + "일 전");
						} else {
							vo.setWhen(Integer.toString(rs.getInt("yy")) + "년 전");
						}
					}
				}
				
				vos.add(vo);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vos;
	}
	
	
}
