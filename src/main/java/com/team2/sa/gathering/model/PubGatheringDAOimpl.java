package com.team2.sa.gathering.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PubGatheringDAOimpl implements PubGatheringDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public PubGatheringDAOimpl() {
		try {
			Class.forName(GatheringQuery.DRIVER_NAME);
			System.out.println("Driver successed..");
			
//			jdbcConnectionTest();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<GatheringVO> searchList(String minAge, String maxAge, String sex) {
		List<GatheringVO> vos = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(
					GatheringQuery.URL, 
					GatheringQuery.USER, 
					GatheringQuery.PASSWORD);
			//�˻� : DQL
			pstmt = conn.prepareStatement(GatheringQuery.GATHERING_SEARCHLIST);

			pstmt.setString(1, minAge);
			pstmt.setString(2, maxAge);
			pstmt.setString(3, sex);
			rs = pstmt.executeQuery();//������ ���� ���
			
			while(rs.next()) {//������ ����� �������� �𸣴ϱ�
				GatheringVO vo = new GatheringVO();
				vo.setgName(rs.getString("gName"));
				vo.setgContent(rs.getString("gContent"));
				vo.setgNum(Integer.parseInt(rs.getString("gNum")));
				vo.setIsPublic(rs.getString("isPublic"));
				vo.setLink(rs.getString("link"));
				vo.setLogo(rs.getString("logo"));
				vo.setMaxAge(Integer.parseInt(rs.getString("maxAge")));
				vo.setMinAge(Integer.parseInt(rs.getString("minAge")));
				vo.setPermission(rs.getString("permission"));
				vo.setSex(rs.getString("sex"));
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

	@Override
	public int insert(GatheringVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					GatheringQuery.URL, 
					GatheringQuery.USER, 
					GatheringQuery.PASSWORD);
			//DML
			pstmt = conn.prepareStatement(GatheringQuery.PUBGATHERING_INSERT);
			pstmt.setString(1, vo.getgName());
			pstmt.setString(2, vo.getgContent());
			pstmt.setString(3, vo.getLogo());
			pstmt.setInt(4, vo.getMinAge());
			pstmt.setInt(5, vo.getMaxAge());
			pstmt.setString(6, vo.getSex());
			pstmt.setString(7, vo.getPermission());
			pstmt.setString(8, "");
			pstmt.setString(9, "T");
			
			
			flag = pstmt.executeUpdate();
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
		
		return flag;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GatheringVO> selectAll() {
		List<GatheringVO> vos = new ArrayList<GatheringVO>();
		try {
			conn = DriverManager.getConnection(GatheringQuery.URL,GatheringQuery.USER,GatheringQuery.PASSWORD);
			pstmt = conn.prepareStatement(GatheringQuery.GATHERING_SELECTALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GatheringVO vo = new GatheringVO();
				vo.setgName(rs.getString("gName"));
				vo.setgContent(rs.getString("gContent"));
				vo.setgNum(Integer.parseInt(rs.getString("gNum")));
				vo.setIsPublic(rs.getString("isPublic"));
				vo.setLink(rs.getString("link"));
				vo.setLogo(rs.getString("logo"));
				vo.setMaxAge(Integer.parseInt(rs.getString("maxAge")));
				vo.setMinAge(Integer.parseInt(rs.getString("minAge")));
				vo.setPermission(rs.getString("permission"));
				vo.setSex(rs.getString("sex"));
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

	@Override
	public GatheringUserInfoVO selectOne(int gNum) {
		GatheringUserInfoVO vo = new GatheringUserInfoVO();
		try {
			conn = DriverManager.getConnection(GatheringQuery.URL,GatheringQuery.USER,GatheringQuery.PASSWORD);
			pstmt = conn.prepareStatement(GatheringQuery.GATHERING_SELECTONE);
			pstmt.setInt(1, gNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setgName(rs.getString("gName"));
				vo.setgContent(rs.getString("gContent"));
				vo.setgNum(Integer.parseInt(rs.getString("gNum")));
				vo.setIsPublic(rs.getString("isPublic"));
				vo.setLink(rs.getString("link"));
				vo.setLogo(rs.getString("logo"));
				vo.setMaxAge(Integer.parseInt(rs.getString("maxAge")));
				vo.setMinAge(Integer.parseInt(rs.getString("minAge")));
				vo.setPermission(rs.getString("permission"));
				vo.setSex(rs.getString("sex"));
//				vo.setuNum(rs.getInt("uNum"));
				vo.setuName(rs.getString("uName"));
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
		return vo;
	}

}
