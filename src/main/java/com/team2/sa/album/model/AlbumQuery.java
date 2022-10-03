package com.team2.sa.album.model;

public interface AlbumQuery {
	String insertAlbum = "INSERT INTO album VALUES (?, ?, ?, ?,seq_album.NEXTVAL,?)";
	String findName = "select uname from userinfo where id=?";
	String fineUnum = "select unum from userinfo where id=?";
	String selectAll = "select * from album where gnum = ? order by anum asc";
	String selectOne = "select * from album where anum = ?";
	String delete = "delete from album where anum = ?";
	
}
