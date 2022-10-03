package com.team2.sa.signup;

public interface SignupQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";

	String SQL_INSERT_USERINFO = 
			"insert into userinfo(unum, uname, id, pw, sex, addr, tel, bday) "
			+ "values(seq_userinfo.nextval, ?, ?, ?, ?, ?, ?, ?)";
	String SQL_ID_CHECK = "select * from userinfo where id=?";
}
