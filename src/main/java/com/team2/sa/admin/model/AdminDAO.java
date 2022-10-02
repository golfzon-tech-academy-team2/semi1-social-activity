package com.team2.sa.admin.model;

import java.util.List;

import com.team2.sa.gathering.model.GatheringUserInfoVO;

public interface AdminDAO {
	List<GatheringUserInfoVO> selectAllGathering(int uNum);
	int searchUnum(String id);

}
