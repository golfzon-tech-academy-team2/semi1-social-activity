package com.team2.sa.gathering.model;

import java.util.List;

public interface GatheringUserInfoDAO {
	int insert(GatheringUserInfoVO vo);
	int update(); 
	int delete(); 
	List<GatheringUserInfoVO> selectAll(); //전체 모임 조회
	GatheringUserInfoVO selectOne(); //모임 상세 조회


}
