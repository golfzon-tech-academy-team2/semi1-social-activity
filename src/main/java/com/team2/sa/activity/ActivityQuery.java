package com.team2.sa.activity;

public interface ActivityQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";
	String SQL_GETGNAME = "select gnum, gname, logo from gathering where gnum=?";
	String SQL_INSERT = "insert into activity(gnum, anum, aname, acontent, astartday, aendday, location, startdate, "
			+ "enddate, personcnt, isend, minage, maxage, sex, maxperson)"
			+ "values(?, seq_activity.nextval, ?, ?, ?, ?, ?, ?, ?, 0, 'F', ?, ?, ?, ?)";
}
