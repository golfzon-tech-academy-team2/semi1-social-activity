package com.team2.sa.admin.model;

public interface AdminQuery {
	String SELECTALLGATHERING = "select u.unum, g.gnum, g.gname from userinfo u inner join gatheringuserinfo gu\r\n"
			+ "on gu.unum = u.unum\r\n"
			+ "inner join gathering g\r\n"
			+ "on g.gnum = gu.gnum\r\n"
			+ "where roll='O' and u.unum=?";
	
	String searchUnum = "select unum from userinfo where id=?";

}
