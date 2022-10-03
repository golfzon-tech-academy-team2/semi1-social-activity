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
	String SQL_GET_CURRVAL = "select seq_userinfo.currval from dual";
	String SQL_INSERT_NOTI = "insert into notification(nnum, unum, content, when) values(seq_notification.nextval, ?, ?, to_char(current_date,'YYYY-MM-DD HH24:MI'))";
}
