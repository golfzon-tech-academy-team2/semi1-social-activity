package com.team2.sa.mypage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.team2.sa.signup.UserinfoVO;

public class MypageDAOimpl implements MypageDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	@Override
	public String pwcheck(String id) {

		String result = "";
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
			pstmt = conn.prepareStatement(MypageQuery.SQL_PW_CHECK);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getString("pw");
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
	public UserinfoVO getMyInfo(String id) {
		UserinfoVO result = new UserinfoVO();
		try {
			Class.forName(MypageQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(MypageQuery.URL, MypageQuery.USER, MypageQuery.PASSWORD);
//				System.out.println("conn successed...");
			// DQL
			pstmt = conn.prepareStatement(MypageQuery.SQL_MYINFO);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				result.setUname(rs.getString("uname"));
				result.setId(id);
				result.setPw(rs.getString("pw"));
				result.setSex(rs.getString("sex"));
				result.setAddr(rs.getString("addr"));
				result.setTel(rs.getString("tel"));
				result.setBday(rs.getDate("bday"));
				System.out.println(rs.getString("pw"));
				System.out.println(rs.getString("sex"));
				System.out.println(rs.getString("addr"));
				System.out.println(rs.getString("tel"));
				System.out.println(rs.getDate("bday"));
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
	public void modname(String id, String name) {
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
			pstmt = conn.prepareStatement(MypageQuery.MOD_NAME);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modpw(String id, String pw) {
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
			pstmt = conn.prepareStatement(MypageQuery.MOD_PW);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void modaddr(String id, String addr) {
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
			pstmt = conn.prepareStatement(MypageQuery.MOD_ADDR);
			pstmt.setString(1, addr);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modtel(String id, String tel) {
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
			pstmt = conn.prepareStatement(MypageQuery.MOD_TEL);
			pstmt.setString(1, tel);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void signout(String id) {
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
			pstmt = conn.prepareStatement(MypageQuery.SQL_SIGNOUT);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
