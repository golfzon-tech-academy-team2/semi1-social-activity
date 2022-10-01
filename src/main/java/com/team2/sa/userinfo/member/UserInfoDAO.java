package com.team2.sa.userinfo.member;

import java.util.List;


public interface UserInfoDAO {
	public List<UserInfoJoinVO> selectAll(int gNum);

}
