package com.team2.sa.event;

public interface EventQuery {

	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "system";
	String PASSWORD = "admin1234";

	String SQL_INSERT_EVENT = 
			"insert into event(enum, etitle, econtent, gift, anum)"
			+ "values(seq_event.nextval, ?, ?, ?, ?)";
	String SQL_DELETE_EVENT = "delete from event where enum=?";
}
