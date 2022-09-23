package com.team2.sa.signup;

public interface SignupDAO {
	public int insert(UserinfoVO vo);
	public int idCheck(String id);
}
