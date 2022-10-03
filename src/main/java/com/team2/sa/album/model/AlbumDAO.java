package com.team2.sa.album.model;

import java.util.List;

public interface AlbumDAO {
	public int insert(AlbumVO vo);
	public List<AlbumVO> selectAll(int gNum);
	public AlbumVO selectOne(int aNum);
	public int findUnum(String id);
	public String findName(String id);
	public int delete(int aNum);

}
