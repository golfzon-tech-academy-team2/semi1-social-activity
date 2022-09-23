package com.team2.sa.login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	
}
