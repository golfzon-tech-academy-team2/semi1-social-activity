package com.team2.sa.condition.model;

public interface ConditionQuery {
	String FINDAGE = "SELECT TRUNC(MONTHS_BETWEEN(sysdate, bday)/12) AS AGE FROM userinfo where id=?";
	String FINDSEX = "select sex from userinfo where id=?";

}
