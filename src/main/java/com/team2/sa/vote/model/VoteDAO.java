package com.team2.sa.vote.model;

import java.util.List;

public interface VoteDAO {
	public int insert(VoteVO vo);
	public List<VoteVO> selectAll(int gNum);

}
