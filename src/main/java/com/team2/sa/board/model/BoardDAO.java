package com.team2.sa.board.model;

import java.util.List;

public interface BoardDAO {
	public int insert(BoardVO vo);
	public int update(BoardVO vo);
	public int delete(int bNum);
	public List<BoardVO> selectAll(int gNum);
	public List<BoardVO> searchList(String searchKey, String searchWord);
	public int findUnum(String id);

}
