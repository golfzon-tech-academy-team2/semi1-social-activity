package com.team2.sa.board.model;

import java.sql.Timestamp;
import java.util.Objects;

public class BoardVO {
	private int bNum;
	private int tmpBnum;
	private String bTitle;
	private String bContent;
	private int gNum;
	private int uNum;
	private Timestamp wDate;
	private String isNotice;
	private String id;
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getTmpBnum() {
		return tmpBnum;
	}
	public void setTmpBnum(int tmpBnum) {
		this.tmpBnum = tmpBnum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public int getuNum() {
		return uNum;
	}
	public void setuNum(int uNum) {
		this.uNum = uNum;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	public String getIsNotice() {
		return isNotice;
	}
	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BoardVO [bNum=" + bNum + ", tmpBnum=" + tmpBnum + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", gNum=" + gNum + ", uNum=" + uNum + ", wDate=" + wDate + ", isNotice=" + isNotice + ", id=" + id
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bContent, bNum, bTitle, gNum, id, isNotice, tmpBnum, uNum, wDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BoardVO other = (BoardVO) obj;
		return Objects.equals(bContent, other.bContent) && bNum == other.bNum && Objects.equals(bTitle, other.bTitle)
				&& gNum == other.gNum && Objects.equals(id, other.id) && Objects.equals(isNotice, other.isNotice)
				&& tmpBnum == other.tmpBnum && uNum == other.uNum && Objects.equals(wDate, other.wDate);
	}
	
	
	
}
