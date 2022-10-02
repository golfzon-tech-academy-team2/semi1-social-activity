package com.team2.sa.login;

import java.util.List;

import com.team2.sa.notification.NotificationVO;

public interface SigninDAO {
	public int signin(String id, String pw);

	public List<NotificationVO> getAlerts(String id);
}
