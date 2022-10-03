package com.team2.sa.notification;

public interface NotificationQuery {

	String SQL_GET_CURRVAL = "select seq_userinfo.currval from dual";
	String SQL_INSERT_NOTI = "insert into notification(nnum, unum, content, when) values(seq_notification.nextval, ?, ?, to_char(current_date,'YYYY-MM-DD HH24:MI'))";
	String SQL_GET_UNUM = "select unum from userinfo where id = ?";
	String SQL_GET_GNAME = "select gname from gathering where gnum = ?";
	String getGatheringUnum = "select unum from gatheringuserinfo gu left join gathering g on gu.gnum = g.gnum where g.gnum = ?";
	String SQL_GET_ANAME = "select aname from activity where anum = ?";

}
