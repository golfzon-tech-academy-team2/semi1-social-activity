package com.team2.sa.mypage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.activity.ActivityDAO;
import com.team2.sa.activity.ActivityDAOimpl;
import com.team2.sa.activity.ActivityInhereted;
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

	@Override
	public List<MyGatheringInherited> mygathering(String id) {
		List<MyGatheringInherited> vos = new ArrayList<MyGatheringInherited>();
		
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
			pstmt = conn.prepareStatement(MypageQuery.SQL_MYGATHERING);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				MyGatheringInherited vo = new MyGatheringInherited();
				vo.setGname(rs.getString("gname"));
				vo.setGcontent(rs.getString("gcontent"));
				vo.setLogo(rs.getString("logo"));
				vo.setMinage(rs.getInt("minage"));
				vo.setMaxage(rs.getInt("maxage"));
				vo.setGnum(rs.getInt("gnum"));
				
				if (rs.getString("roll").equals("O")) {
					vo.setRoll("운영자");
				} else if (rs.getString("roll").equals("L")) {
					vo.setRoll("리더");
				} else {
					vo.setRoll("멤버");
				}
				
				if (rs.getString("sex").equals("F")) {
					vo.setSex("여자");
				} else if (rs.getString("sex").equals("M")) {
					vo.setSex("남자");
				} else {
					vo.setSex("상관 없음");
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

	@Override
	public List<ActivityInhereted> myactivity(String id) {
		List<ActivityInhereted> vos = new ArrayList<ActivityInhereted>();

		try {
			Class.forName(MypageQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(MypageQuery.URL, MypageQuery.USER, MypageQuery.PASSWORD);
//			System.out.println("conn successed...");
			// DQL
			pstmt = conn.prepareStatement(MypageQuery.SQL_MYACTIVITY);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			ActivityDAO dao = new ActivityDAOimpl();
			while (rs.next()) {
				ActivityInhereted vo = new ActivityInhereted();
				vo.setgNum(rs.getInt("gnum"));
				vo.setgName(dao.getGname(rs.getInt("gnum")).getgName());
				vo.setaNum(rs.getInt("anum"));
				vo.setaName(rs.getString("aname"));
				vo.setaContent(rs.getString("acontent"));
				vo.setLocation(rs.getString("location"));
				vo.setaStartDay(rs.getDate("astartday"));
				vo.setaEndDay(rs.getDate("aendday"));
				vo.setStartDate(rs.getDate("startdate"));
				vo.setEndDate(rs.getDate("enddate"));
				vo.setPersonCnt(rs.getInt("personcnt"));
				vo.setMinAge(rs.getInt("minage"));
				vo.setMaxAge(rs.getInt("maxage"));
				
				if (rs.getString("sex").equals("F")) {
					vo.setSex("여자");
				} else if (rs.getString("sex").equals("M")) {
					vo.setSex("남자");
				} else {
					vo.setSex("상관없음");
				}

				vo.setMaxPerson(rs.getInt("maxperson"));

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
