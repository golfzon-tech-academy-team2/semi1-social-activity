package com.team2.sa.board.model;

import java.util.List;

public interface BoardJoinDAO {
	public BoardJoinVO selectOne(int bNum);
	public BoardJoinVO selectNotice(int gNum);
	public List<BoardJoinVO> selectAll(int gNum);

}
