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
	String SQL_MYGATHERING = "select roll, g.gnum, gname, gcontent, logo, minage, maxage, sex from gatheringuserinfo ginfo left join gathering g"
			+ " on ginfo.gnum = g.gnum where unum=(select unum from userinfo where id=?)";
	String SQL_MYACTIVITY = "select a.gnum, a.anum, aname, acontent, location, astartday, aendday, startdate, enddate, personcnt, minage, maxage, sex, maxperson from activityuserinfo ainfo left join activity a"
			+ " on ainfo.anum = a.anum where ainfo.unum=(select unum from userinfo where id=?)";
	String SQL_SIGNOUT_ACTIVITY = "delete from activityuserinfo where anum=? and unum=(select unum from userinfo where id=?)";
	String SQL_DECREASE_PERSONCNT = "update activity set personcnt = (select personcnt from activity where anum = ?) - 1 where anum = ?";
}
