package com.team2.sa.gathering.model;

public interface PriGatheringDAO {
	int insert(GatheringVO vo); //PriGathering 생성
	int update(); //PriGathering 수정
	int delete(); //PriGathering 삭제
	GatheringVO selectOne(); //모임 상세 조회

}
