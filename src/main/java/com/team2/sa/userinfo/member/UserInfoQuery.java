package com.team2.sa.userinfo.member;

public interface UserInfoQuery {
	String SELECTALLMEMBER = "select u.uname, g.roll,u.unum from userinfo u inner join gatheringuserinfo g on u.unum = g.unum where gNum=?";
}
