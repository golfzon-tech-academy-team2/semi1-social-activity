package com.team2.sa.board.model;

public interface BoardQuery {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "SYSTEM";
	String PASSWORD = "admin1234";
	String SELECTALLBOARD = "select * from board where gNum=? ORDER BY bnum ASC";

}
