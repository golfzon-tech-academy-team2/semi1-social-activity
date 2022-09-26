package com.team2.sa.gathering.model;

import java.util.List;

public interface PubGatheringDAO {
	public int insert(GatheringVO vo); //PubGathering 생성
	public int update(); //PubGathering 수정
	public int delete(); //PubGathering 삭제
	public List<GatheringVO> selectAll(); //전체 모임 조회
	public GatheringVO selectOne(); //모임 상세 조회
	public List<GatheringVO> searchList(String minAge, String maxAge, String sex);
}
