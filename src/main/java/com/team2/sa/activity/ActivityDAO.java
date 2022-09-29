package com.team2.sa.activity;

import java.util.List;

import com.team2.sa.event.EventVO;
import com.team2.sa.gathering.model.GatheringVO;

public interface ActivityDAO {

	public GatheringVO getGname(int gNum);

	public void insert(ActivityVO vo, String id);

	public ActivityVO selectOne(int aNum);

	public List<EventVO> selectAll(int aNum);

	public List<ActivityVO> searchList(ActivityVO vo);

	public void deleteActivity(int aNum);

}
