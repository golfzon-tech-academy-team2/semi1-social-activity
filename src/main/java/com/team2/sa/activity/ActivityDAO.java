package com.team2.sa.activity;

import com.team2.sa.gathering.model.GatheringVO;

public interface ActivityDAO {

	public GatheringVO getGname(int gNum);

	public void insert(ActivityVO vo, String id);

	public ActivityVO selectOne(int aNum);

}
