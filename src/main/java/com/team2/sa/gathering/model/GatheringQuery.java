package com.team2.sa.gathering.model;

public interface GatheringQuery {
	String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	String USER = "SYSTEM";
	String PASSWORD = "admin1234";
	String GATHERING_INSERT = "insert into gathering values(seq_gathering.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	String PUBGATHERING_INSERT = "insert into gathering values(seq_gathering.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	String PRIGATHERING_INSERT = "insert into gathering values(seq_gathering.NEXTVAL,?,?,?,?,?,?,?,?,?)";
	String GATHERING_UPDATE = "";
	String GATHERING_DELETE = "";
	String GATHERING_SELECTALL = "select * from gathering where ispublic = 'T'  ORDER BY gnum ASC";
	String GATHERING_SELECTONE = "";

}