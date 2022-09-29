package com.team2.sa.board.model;

import java.util.List;

public interface BoardJoinDAO {
	public BoardJoinVO selectOne(int bNum);
	public List<BoardJoinVO> selectAll(int gNum);

}
