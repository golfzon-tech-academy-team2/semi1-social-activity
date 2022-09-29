package com.team2.sa.board.model;

public interface BoardQuery {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "SYSTEM";
	String PASSWORD = "admin1234";
//	String SELECTALLBOARD = "select * from board where gNum=? ORDER BY bnum ASC";
	String SELECTALLBOARD = "select b.bnum, b.btitle, b.wdate, u.uname from userinfo u inner join board on u.unum = b.unum where gNum = ? order by b.bnum asc";
	String INSERTBOARD = "insert into board values(seq_board.NEXTVAL,?,?,?,?,SYSDATE,(select uname from userinfo where unum=?))";
	String FINDUNUM = "select unum from userinfo where id=?";

}
