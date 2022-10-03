package com.team2.sa.login;

public interface SigninQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";
	String SQL_ID_EXIST = "select * from userinfo where id=? and pw=?";
	String SQL_CHECK_NOTIFICATION = "select nnum, unum, content, when"
			+ ", ROUND(ROUND(TO_DATE(to_char(current_date,'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI') - TO_DATE(when, 'YYYY-MM-DD HH24:MI'), 0)/365, 0) as yy"
			+ ", ROUND(TO_DATE(to_char(current_date,'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI') - TO_DATE(when, 'YYYY-MM-DD HH24:MI'), 0) AS dd"
			+ ", ROUND((TO_DATE(to_char(current_date,'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI') - TO_DATE(when, 'YYYY-MM-DD HH24:MI')) * 24, 0) AS hh"
			+ ", ROUND((TO_DATE(to_char(current_date,'YYYY-MM-DD HH24:MI'), 'YYYY-MM-DD HH24:MI') - TO_DATE(when, 'YYYY-MM-DD HH24:MI')) * 24 * 60, 0) AS mm from notification"
			+ " where unum = (select unum from userinfo where id = ?) and rownum <= 20 order by when desc";
}
