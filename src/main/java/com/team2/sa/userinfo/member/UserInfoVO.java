package com.team2.sa.userinfo.member;

import java.sql.Date;
import java.util.Objects;

public class UserInfoVO {
	private int uNum;
	private String uName;
	private String id;
	private String pw;
	private String sex;
	private String addr;
	private Date bDay;
	public int getuNum() {
		return uNum;
	}
	public void setuNum(int uNum) {
		this.uNum = uNum;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Date getbDay() {
		return bDay;
	}
	public void setbDay(Date bDay) {
		this.bDay = bDay;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addr, bDay, id, pw, sex, uName, uNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfoVO other = (UserInfoVO) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(bDay, other.bDay) && Objects.equals(id, other.id)
				&& Objects.equals(pw, other.pw) && Objects.equals(sex, other.sex) && Objects.equals(uName, other.uName)
				&& uNum == other.uNum;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uNum=" + uNum + ", uName=" + uName + ", id=" + id + ", pw=" + pw + ", sex=" + sex
				+ ", addr=" + addr + ", bDay=" + bDay + "]";
	}
	
}
