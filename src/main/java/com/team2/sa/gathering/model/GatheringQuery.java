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
	String GATHERING_SEARCHLIST = "select * from gathering where minAge>=? and maxAge<=? and sex=? and ispublic='T' order by gnum desc";
	String PUBGATHERING_JOIN = "insert into gatheringuserinfo values(?,?,(select unum from userinfo where id=?))";
	String GET_GNUM = "SELECT gNum FROM (SELECT * FROM gathering ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
}
