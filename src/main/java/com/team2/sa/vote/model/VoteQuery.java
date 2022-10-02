package com.team2.sa.vote.model;

public interface VoteQuery {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "SYSTEM";
	String PASSWORD = "admin1234";
	String INSERTVOTE = "insert into vote values(seq_vote.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	String SELECTALL = "select * from vote where gnum=?";

}
