package com.team2.sa.mypage;

import com.team2.sa.signup.UserinfoVO;

public interface MypageDAO {
	public String pwcheck(String id);
	
	public UserinfoVO getMyInfo(String id);
	
	public void modname(String id, String name);

	public void modpw(String id, String pw);

	public void modaddr(String id, String addr);

	public void modtel(String id, String tel);

	public void signout(String id);
}