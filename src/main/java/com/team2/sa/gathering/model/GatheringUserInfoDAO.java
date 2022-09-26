package com.team2.sa.gathering.model;

import java.util.List;

public interface GatheringUserInfoDAO {
	public int insert(int gNum, String roll, String signedid);
	public int update(); 
	public int delete(); 
	public int getGnum();
	public List<GatheringUserInfoVO> selectAll(); //전체 모임 조회
	public GatheringUserInfoVO selectOne(); //모임 상세 조회


}
