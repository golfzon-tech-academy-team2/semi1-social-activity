package com.team2.sa.gathering.model;

import java.util.List;

public interface GatheringUserInfoDAO {
	int insert(int gNum, String roll, String signedid);
	int update(); 
	int delete(); 
	int getGnum();
	List<GatheringUserInfoVO> selectAll(); //전체 모임 조회
	GatheringUserInfoVO selectOne(); //모임 상세 조회


}
