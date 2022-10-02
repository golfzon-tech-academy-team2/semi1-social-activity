package com.team2.sa.vote.model;

import java.sql.Date;
import java.util.Objects;

public class VoteVO {
	private int vNum;
	private String vTitle;
	private Date startDate;
	private Date endDate;
	private int gNum;
	private String vList1;
	private String vList2;
	private String vList3;
	private int vCnt1;
	private int vCnt2;
	private int vCnt3;
	public int getvNum() {
		return vNum;
	}
	public void setvNum(int vNum) {
		this.vNum = vNum;
	}
	public String getvTitle() {
		return vTitle;
	}
	public void setvTitle(String vTitle) {
		this.vTitle = vTitle;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getvList1() {
		return vList1;
	}
	public void setvList1(String vList1) {
		this.vList1 = vList1;
	}
	public String getvList2() {
		return vList2;
	}
	public void setvList2(String vList2) {
		this.vList2 = vList2;
	}
	public String getvList3() {
		return vList3;
	}
	public void setvList3(String vList3) {
		this.vList3 = vList3;
	}
	public int getvCnt1() {
		return vCnt1;
	}
	public void setvCnt1(int vCnt1) {
		this.vCnt1 = vCnt1;
	}
	public int getvCnt2() {
		return vCnt2;
	}
	public void setvCnt2(int vCnt2) {
		this.vCnt2 = vCnt2;
	}
	public int getvCnt3() {
		return vCnt3;
	}
	public void setvCnt3(int vCnt3) {
		this.vCnt3 = vCnt3;
	}
	@Override
	public int hashCode() {
		return Objects.hash(endDate, gNum, startDate, vCnt1, vCnt2, vCnt3, vList1, vList2, vList3, vNum, vTitle);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoteVO other = (VoteVO) obj;
		return Objects.equals(endDate, other.endDate) && gNum == other.gNum
				&& Objects.equals(startDate, other.startDate) && vCnt1 == other.vCnt1 && vCnt2 == other.vCnt2
				&& vCnt3 == other.vCnt3 && Objects.equals(vList1, other.vList1) && Objects.equals(vList2, other.vList2)
				&& Objects.equals(vList3, other.vList3) && vNum == other.vNum && Objects.equals(vTitle, other.vTitle);
	}
	@Override
	public String toString() {
		return "VoteVO [vNum=" + vNum + ", vTitle=" + vTitle + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", gNum=" + gNum + ", vList1=" + vList1 + ", vList2=" + vList2 + ", vList3=" + vList3 + ", vCnt1="
				+ vCnt1 + ", vCnt2=" + vCnt2 + ", vCnt3=" + vCnt3 + "]";
	}

}
