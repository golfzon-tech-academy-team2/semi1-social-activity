package com.team2.sa.gathering.model;

import java.util.List;

public interface PubGatheringDAO {
	int insert(GatheringVO vo); //PubGathering 생성
	int update(); //PubGathering 수정
	int delete(); //PubGathering 삭제
	List<GatheringVO> selectAll(); //전체 모임 조회
	GatheringVO selectOne(); //모임 상세 조회
	public List<GatheringVO> searchList(String minAge, String maxAge, String sex);
}
