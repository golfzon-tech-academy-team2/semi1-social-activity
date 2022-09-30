package com.team2.sa.activity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.event.EventVO;
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
	public void insert(ActivityVO vo, String id) {
		int uNum = 0;
		int aNum = 0;
		
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

			pstmt = conn.prepareStatement(ActivityQuery.SQL_GET_UNUM);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				uNum = rs.getInt("unum");
				if (rs.next() == true) {
					break;
				}
			}
			
			pstmt = conn.prepareStatement(ActivityQuery.SQL_GET_ANUM);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				aNum = rs.getInt("currval");
				if (rs.next() == true) {
					break;
				}
			}
			
			pstmt = conn.prepareStatement(ActivityQuery.SQL_INSERT_ACTINFO);
			pstmt.setInt(1, aNum);
			pstmt.setInt(2, uNum);
			rs = pstmt.executeQuery();
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
	public ActivityVO selectOne(int aNum) {
		ActivityVO result = new ActivityVO();
		try {
			Class.forName(ActivityQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DQL
			pstmt = conn.prepareStatement(ActivityQuery.SQL_SELECT_ONE);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result.setaNum(rs.getInt("anum"));
				result.setaName(rs.getString("aname"));
				result.setaContent(rs.getString("acontent"));
				result.setaStartDay(rs.getDate("astartday"));
				result.setaEndDay(rs.getDate("aendday"));
				result.setLocation(rs.getString("location"));
				result.setStartDate(rs.getDate("startdate"));
				result.setEndDate(rs.getDate("enddate"));
				result.setPersonCnt(rs.getInt("personcnt"));
				result.setMinAge(rs.getInt("minage"));
				result.setMaxAge(rs.getInt("maxage"));
				result.setSex(rs.getString("sex"));
				result.setMaxPerson(rs.getInt("maxperson"));
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
	public List<EventVO> selectAll(int aNum) {
		List<EventVO> vos = new ArrayList<EventVO>();

		try {
			Class.forName(ActivityQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
//			System.out.println("conn successed...");
			// DQL
			pstmt = conn.prepareStatement(ActivityQuery.SQL_SELECT_EVENT);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				EventVO vo = new EventVO();
				vo.setaNum(aNum);
				vo.seteNum(rs.getInt("eNum"));
				vo.seteTitle(rs.getString("etitle"));
				vo.seteContent(rs.getString("econtent"));
				vo.setGift(rs.getString("gift"));

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

	@Override
	public List<ActivityVO> searchList(ActivityVO vo) {
		List<ActivityVO> vos = new ArrayList<ActivityVO>();

		try {
			Class.forName(ActivityQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
//			System.out.println("conn successed...");
			// DQL
			if (vo.getSex().equals("X")) {

				pstmt = conn.prepareStatement(ActivityQuery.SQL_SEARCH_X);
				pstmt.setString(1, "%"+vo.getLocation()+"%");
				pstmt.setInt(2, vo.getMinAge());
				pstmt.setInt(3, vo.getMinAge());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ActivityVO result = new ActivityVO();
					result.setgNum(rs.getInt("gnum"));
					result.setaNum(rs.getInt("anum"));
					result.setaName(rs.getString("aname"));
					result.setaContent(rs.getString("acontent"));
					result.setaStartDay(rs.getDate("astartday"));
					result.setaEndDay(rs.getDate("aendday"));
					result.setLocation(rs.getString("location"));
					result.setStartDate(rs.getDate("startdate"));
					result.setEndDate(rs.getDate("enddate"));
					result.setPersonCnt(rs.getInt("personcnt"));
					result.setMinAge(rs.getInt("minage"));
					result.setMaxAge(rs.getInt("maxage"));
					result.setSex(rs.getString("sex"));
					result.setMaxPerson(rs.getInt("maxperson"));

					vos.add(result);
				}
			} else {

				pstmt = conn.prepareStatement(ActivityQuery.SQL_SEARCH_O);
				pstmt.setString(1, vo.getSex());
				pstmt.setString(2, "%"+vo.getLocation()+"%");
				pstmt.setInt(3, vo.getMinAge());
				pstmt.setInt(4, vo.getMinAge());
				rs = pstmt.executeQuery();

				while (rs.next()) {
					ActivityVO result = new ActivityVO();
					result.setgNum(rs.getInt("gnum"));
					result.setaNum(rs.getInt("anum"));
					result.setaName(rs.getString("aname"));
					result.setaContent(rs.getString("acontent"));
					result.setaStartDay(rs.getDate("astartday"));
					result.setaEndDay(rs.getDate("aendday"));
					result.setLocation(rs.getString("location"));
					result.setStartDate(rs.getDate("startdate"));
					result.setEndDate(rs.getDate("enddate"));
					result.setPersonCnt(rs.getInt("personcnt"));
					result.setMinAge(rs.getInt("minage"));
					result.setMaxAge(rs.getInt("maxage"));
					result.setSex(rs.getString("sex"));
					result.setMaxPerson(rs.getInt("maxperson"));

					vos.add(result);
				}
			}

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vos;
	}

	@Override
	public void deleteActivity(int aNum) {

		try {
			Class.forName(ActivityQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
//		System.out.println("conn successed...");
			// DQL
			pstmt = conn.prepareStatement(ActivityQuery.SQL_DELETE_ACTIVITYUSERINFO);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(ActivityQuery.SQL_DELETE_ACTIVITY);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();
			

			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
