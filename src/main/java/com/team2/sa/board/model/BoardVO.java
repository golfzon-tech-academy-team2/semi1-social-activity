package com.team2.sa.board.model;

import java.sql.Timestamp;
import java.util.Objects;

public class BoardVO {
	private int bNum;
	private int tmpBnum;
	private String bTitle;
	private String bContent;
	private int gNum;
	private String writer;
	private Timestamp wDate;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Timestamp getwDate() {
		return wDate;
	}
	public void setwDate(Timestamp wDate) {
		this.wDate = wDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(bContent, bNum, bTitle, gNum, tmpBnum, wDate, writer);
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
				&& Objects.equals(writer, other.writer);
	}
	@Override
	public String toString() {
		return "BoardVO [bNum=" + bNum + ", tmpBnum=" + tmpBnum + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", gNum=" + gNum + ", writer=" + writer + ", wDate=" + wDate + "]";
	}
	

}
