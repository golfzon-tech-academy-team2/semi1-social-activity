package com.team2.sa.board.model;

import java.sql.Timestamp;
import java.util.Objects;

public class BoardVO {
	private int bNum;
	private int tmpBnum;
	private String bTitle;
	private String bContent;
	private int gNum;
	private int wNum;
	private Timestamp wDate;
	private String wName;
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
	public int getwNum() {
		return wNum;
	}
	public void setwNum(int wNum) {
		this.wNum = wNum;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	public String getwName() {
		return wName;
	}
	public void setwName(String wName) {
		this.wName = wName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bContent, bNum, bTitle, gNum, tmpBnum, wDate, wName, wNum);
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
				&& gNum == other.gNum && tmpBnum == other.tmpBnum && Objects.equals(wDate, other.wDate)
				&& Objects.equals(wName, other.wName) && wNum == other.wNum;
	}
	@Override
	public String toString() {
		return "BoardVO [bNum=" + bNum + ", tmpBnum=" + tmpBnum + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", gNum=" + gNum + ", wNum=" + wNum + ", wDate=" + wDate + ", wName=" + wName + "]";
	}
	
	

	

}
