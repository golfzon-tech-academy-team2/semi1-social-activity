package com.team2.sa.activity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.board.model.BoardJoinVO;
import com.team2.sa.board.model.BoardQuery;
import com.team2.sa.event.EventVO;
import com.team2.sa.gathering.model.GatheringVO;
import com.team2.sa.mypage.MypageQuery;
import com.team2.sa.signup.SignupQuery;
import com.team2.sa.userinfo.member.UserInfoVO;

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

	@Override
	public int checkGathering(int aNum, String id) {

		int result = -1;
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_CHECK_GATHERING);
			pstmt.setInt(1, aNum);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("checkGathering");
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
	public int getGnum(int aNum) {
		int result = -1;
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_GETGNUM);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("gNum");
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
	public int checkActivity(int aNum, String id) {
		int result = -1;
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_CHECK_ACTIVITY);
			pstmt.setInt(1, aNum);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("checkActivity");
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
	public void signUpActivity(int aNum, String id) {
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_SIGNUP_ACTIVITY);
			pstmt.setInt(1, aNum);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			pstmt = conn.prepareStatement(ActivityQuery.SQL_ADD_PERSONCNT);
			pstmt.setInt(1, aNum);
			pstmt.setInt(2, aNum);
			rs = pstmt.executeQuery();
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ActivityVO vo) {
		try {
			Class.forName(SignupQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(ActivityQuery.URL, ActivityQuery.USER, ActivityQuery.PASSWORD);
			System.out.println("conn successed...");

			pstmt = conn.prepareStatement(ActivityQuery.SQL_UPDATE);
			pstmt.setString(1, vo.getaName());
			pstmt.setString(2, vo.getaContent());
			pstmt.setDate(3, vo.getaStartDay());
			pstmt.setDate(4, vo.getaEndDay());
			pstmt.setString(5, vo.getLocation());
			pstmt.setDate(6, vo.getStartDate());
			pstmt.setDate(7, vo.getEndDate());
			pstmt.setInt(8, vo.getMinAge());
			pstmt.setInt(9, vo.getMaxAge());
			pstmt.setString(10, vo.getSex());
			pstmt.setInt(11, vo.getMaxPerson());
			pstmt.setInt(12, vo.getaNum());
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
	public int checkLeader(int aNum, String id) {
		int result = -1;
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_CHECK_LEADER);
			pstmt.setInt(1, aNum);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("checkLeader");
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
	public int getGatheringUserNum(int gNum) {

		int result = -1;
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
			pstmt = conn.prepareStatement(ActivityQuery.SQL_GET_G_USER_NUM);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("number");
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
	public List<ActivityVO> selectAllActivity(int gNum) {
		List<ActivityVO> vos = new ArrayList<ActivityVO>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			//여기부터
			pstmt = conn.prepareStatement(ActivityQuery.SELECTALL_ACTIVITY);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				ActivityVO vo = new ActivityVO();
				vo.setgNum(rs.getInt("gnum"));
				vo.setaNum(rs.getInt("anum"));
				vo.setaName(rs.getString("aname"));
				vo.setaContent(rs.getString("acontent"));
				vo.setaStartDay(rs.getDate("astartday"));
				vo.setaEndDay(rs.getDate("aendday"));
				vo.setLocation(rs.getString("location"));
				vo.setStartDate(rs.getDate("startdate"));
				vo.setEndDate(rs.getDate("enddate"));
				vo.setPersonCnt(rs.getInt("personcnt"));
				vo.setMinAge(rs.getInt("minage"));
				vo.setMaxAge(rs.getInt("maxage"));
				vo.setSex(rs.getString("sex"));
				vo.setMaxPerson(rs.getInt("maxperson"));
				vos.add(vo);
				i++;
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vos;
	}

	@Override
	public List<UserInfoVO> activityMember(int aNum) {
		List<UserInfoVO> vos = new ArrayList<UserInfoVO>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			//여기부터
			pstmt = conn.prepareStatement(ActivityQuery.SQL_ACTIVITYMEMBER);
			pstmt.setInt(1, aNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				UserInfoVO vo = new UserInfoVO();
				vo.setuName(rs.getString("uname"));
				if (rs.getString("sex").equals("M")) {
					vo.setSex("남자");
				} else {
					vo.setSex("여자");
				}
				vos.add(vo);
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vos;
	}

}
