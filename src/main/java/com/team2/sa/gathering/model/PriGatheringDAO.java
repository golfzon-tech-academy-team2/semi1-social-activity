package com.team2.sa.gathering.model;

public interface PriGatheringDAO {
	public int insert(GatheringVO vo); //PriGathering 생성
	public int update(); //PriGathering 수정
	public int delete(); //PriGathering 삭제
	public GatheringVO selectOne(); //모임 상세 조회

}
