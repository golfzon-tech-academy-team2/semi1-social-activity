package com.team2.sa.login;

public interface SigninQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "oracle";
	String SQL_ID_EXIST = "select * from userinfo where id=? and pw=?";
}
