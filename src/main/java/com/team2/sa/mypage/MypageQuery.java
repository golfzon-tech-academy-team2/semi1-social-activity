package com.team2.sa.mypage;

public interface MypageQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";
	String SQL_PW_CHECK = "select pw from userinfo where id=?";
	String SQL_MYINFO = "select uname, pw, sex, addr, tel, bday from userinfo where id=?";
	String MOD_NAME = "update userinfo set uname=? where id=?";
	String MOD_PW = "update userinfo set pw=? where id=?";
	String MOD_ADDR = "update userinfo set addr=? where id=?";
	String MOD_TEL = "update userinfo set tel=? where id=?";
	String SQL_SIGNOUT = "delete from userinfo where id=?";
}
