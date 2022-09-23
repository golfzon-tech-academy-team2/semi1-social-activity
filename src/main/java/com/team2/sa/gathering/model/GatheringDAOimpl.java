package com.team2.sa.gathering.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GatheringDAOimpl implements GatheringDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public GatheringDAOimpl() {
		try {
			Class.forName(GatheringQuery.DRIVER_NAME);
			System.out.println("Driver successed..");
			
//			jdbcConnectionTest();
			

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int insert(GatheringVO vo) {
		int flag = 0;
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
	public GatheringVO[] selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GatheringVO selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

}
