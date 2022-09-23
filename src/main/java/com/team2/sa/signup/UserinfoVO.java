package com.team2.sa.signup;

import java.sql.Date;
import java.util.Objects;

public class UserinfoVO {
	private String uname;
	private String id;
	private String pw;
	private String sex;
	private String addr;
	private String tel;
	private Date bday;
	public UserinfoVO() {
		
	}
	public UserinfoVO(String uname, String id, String pw, String sex, String addr, String tel, Date bday) {
		super();
		this.uname = uname;
		this.id = id;
		this.pw = pw;
		this.sex = sex;
		this.addr = addr;
		this.tel = tel;
		this.bday = bday;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBday() {
		return bday;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}
	@Override
	public int hashCode() {
		return Objects.hash(addr, bday, id, pw, sex, tel, uname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserinfoVO other = (UserinfoVO) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(bday, other.bday) && Objects.equals(id, other.id)
				&& Objects.equals(pw, other.pw) && Objects.equals(sex, other.sex) && Objects.equals(tel, other.tel)
				&& uname == other.uname;
	}
	@Override
	public String toString() {
		return "UserinfoVO [uname=" + uname + ", id=" + id + ", pw=" + pw + ", sex=" + sex + ", addr=" + addr + ", tel="
				+ tel + ", bday=" + bday + "]";
	}
	
	
}
