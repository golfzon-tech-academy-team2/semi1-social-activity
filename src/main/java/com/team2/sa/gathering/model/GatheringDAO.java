package com.team2.sa.gathering.model;

public interface GatheringDAO {
	int insert(GatheringVO vo); //Gathering 생성
	int update(); //Gathering 수정
	int delete(); //Gathering 삭제
	GatheringVO[] selectAll(); //전체 모임 조회
	GatheringVO selectOne(); //모임 상세 조회

}
