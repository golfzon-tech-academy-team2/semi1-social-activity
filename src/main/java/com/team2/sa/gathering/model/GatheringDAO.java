package com.team2.sa.gathering.model;

public interface GatheringDAO {
	public int insert(GatheringVO vo); //Gathering 생성
	public int update(); //Gathering 수정
	public int delete(); //Gathering 삭제
	public GatheringVO[] selectAll(); //전체 모임 조회
	public GatheringVO selectOne(); //모임 상세 조회

}
