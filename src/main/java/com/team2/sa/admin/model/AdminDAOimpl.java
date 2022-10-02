package com.team2.sa.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.team2.sa.board.model.BoardQuery;
import com.team2.sa.board.model.BoardVO;
import com.team2.sa.gathering.model.GatheringUserInfoVO;

public class AdminDAOimpl implements AdminDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AdminDAOimpl() {
		System.out.println("AdminDAOimpl()...");
		try {
			Class.forName(BoardQuery.DRIVER_NAME);
			System.out.println("Driver successed..");

//			jdbcConnectionTest();	

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<GatheringUserInfoVO> selectAllGathering(int uNum) {
		System.out.println("selectAll()...");
		List<GatheringUserInfoVO> vos = new ArrayList<GatheringUserInfoVO>();
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			
			pstmt = conn.prepareStatement(AdminQuery.SELECTALLGATHERING);
			pstmt.setInt(1, uNum);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GatheringUserInfoVO vo = new GatheringUserInfoVO();
				vo.setgNum(rs.getInt("gNum"));
				vo.setgName(rs.getString("gName"));
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
	public int searchUnum(String id) {
		int uNum = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
			
			pstmt = conn.prepareStatement(AdminQuery.searchUnum);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				uNum = rs.getInt("uNum");
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
		return uNum;
	}

	@Override
	public int update(GatheringUserInfoVO vo) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
//			System.out.println("conn successed...");
			//DML
			pstmt = conn.prepareStatement(AdminQuery.UPDATEGATHERING);
			pstmt.setString(1, vo.getgName());
			pstmt.setString(2, vo.getgContent());
			pstmt.setString(3, vo.getLogo());
			pstmt.setInt(4, vo.getMinAge());
			pstmt.setInt(5, vo.getMaxAge());
			pstmt.setString(6, vo.getSex());
			pstmt.setString(7, vo.getPermission());
			pstmt.setString(8, "");
			pstmt.setInt(9, vo.getgNum());
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
	public int delete(int gNum) {
		int flag = 0;
		try {
			conn = DriverManager.getConnection(
					BoardQuery.URL, 
					BoardQuery.USER, 
					BoardQuery.PASSWORD);
//			System.out.println("conn successed...");
			//�Է�, ����, ���� : DML
			pstmt = conn.prepareStatement(AdminQuery.DELETEGATHERING1); //query�� ��
			pstmt.setInt(1, gNum); //query�� ?ó��
			flag = pstmt.executeUpdate();//������ ���� ���
			pstmt = conn.prepareStatement(AdminQuery.DELETEGATHERING2); //query�� ��
			pstmt.setInt(1, gNum); //query�� ?ó��
			flag = pstmt.executeUpdate();//������ ���� ���
			
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

}
