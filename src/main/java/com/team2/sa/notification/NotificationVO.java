package com.team2.sa.notification;

import java.util.Objects;

public class NotificationVO {
	private int nnum;
	private int unum;
	private String content;
	private String when;
	public NotificationVO() {
	}
	public NotificationVO(int nnum, int unum, String content, String when) {
		super();
		this.nnum = nnum;
		this.unum = unum;
		this.content = content;
		this.when = when;
	}
	@Override
	public String toString() {
		return "NotificationVO [nnum=" + nnum + ", unum=" + unum + ", content=" + content + ", when=" + when + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(content, nnum, unum, when);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificationVO other = (NotificationVO) obj;
		return Objects.equals(content, other.content) && nnum == other.nnum && unum == other.unum
				&& Objects.equals(when, other.when);
	}
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public int getUnum() {
		return unum;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	
	
	
	
}
