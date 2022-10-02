package com.team2.sa.vote.model;

public interface VoteQuery {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "SYSTEM";
	String PASSWORD = "admin1234";
	String INSERTVOTE = "insert into vote values(seq_vote.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	String SELECTALL = "select * from vote where gnum=?";
	String SELECTONE = "select * from vote where vNum=?";
	String UPDATE1 = "update vote set vcnt1 = vcnt1+1 where vNum=?";
	String UPDATE2 = "update vote set vcnt2 = vcnt2+1 where vNum=?";
	String UPDATE3 = "update vote set vcnt3 = vcnt3+1 where vNum=?";//vcnt,vcnt,vnum

}
