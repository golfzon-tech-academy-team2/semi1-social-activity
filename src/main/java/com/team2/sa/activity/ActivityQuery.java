package com.team2.sa.activity;

public interface ActivityQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";
	String SQL_GETGNAME = "select gnum, gname, logo from gathering where gnum=?";
	String SQL_INSERT = "insert into activity(gnum, anum, aname, acontent, astartday, aendday, location, startdate, "
			+ "enddate, personcnt, minage, maxage, sex, maxperson)"
			+ "values(?, seq_activity.nextval, ?, ?, ?, ?, ?, ?, ?, 1, ?, ?, ?, ?)";
	String SQL_GET_UNUM = "select unum from userinfo where id=?";
	String SQL_GET_ANUM = "select seq_activity.currval from dual";
	String SQL_INSERT_ACTINFO = "insert into activityuserinfo(anum, unum) values(?, ?)";
	String SQL_SELECT_ONE = "select * from activity where anum=?";
	String SQL_SELECT_EVENT = "select e.enum, a.anum, etitle, econtent, gift from event e left join activity a"
			+ " on e.anum = a.anum where a.anum=?";
	String SQL_SEARCH_X = "select * from activity where location like ? and minage <= ? and maxage >= ? order by aNum desc";
	String SQL_SEARCH_O = "select * from activity where sex=? and location like ? minage <= ? and maxage >= ? order by aNum desc";
	String SQL_DELETE_ACTIVITY = "delete from activity where anum = ?";
	String SQL_DELETE_ACTIVITYUSERINFO = "delete from activityuserinfo where anum = ?";
	String SQL_CHECK_GATHERING = "select count(gnum) as \"checkGathering\" from gatheringuserinfo where "
			+ "gnum = (select gnum from activity where anum = ?) and "
			+ "unum = (select unum from userinfo where id = ?)";
	String SQL_GETGNUM = "select gnum from activity where anum = ?";
	String SQL_CHECK_ACTIVITY = "select count(anum) \"checkActivity\" from activityuserinfo where anum=? and "
			+ "unum = (select unum from userinfo where id=?)";
	String SQL_SIGNUP_ACTIVITY = "insert into activityuserinfo(anum, unum) values(?, (select unum from userinfo where id=?))";
	String SQL_UPDATE = "update activity set aname=?, acontent=?, astartday=?, aendday=?, location=?, startdate=?, enddate=?, minage=?, maxage=?, sex=?, maxperson=? where anum=?";
}
