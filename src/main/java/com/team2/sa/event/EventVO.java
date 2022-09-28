package com.team2.sa.event;

import java.util.Objects;

public class EventVO {

	private int eNum;
	private String eTitle;
	private String eContent;
	private String gift;
	private int aNum;
	
	
	
	public EventVO() {
	}
	
	
	public EventVO(int eNum, String eTitle, String eContent, String gift, int aNum) {
		super();
		this.eNum = eNum;
		this.eTitle = eTitle;
		this.eContent = eContent;
		this.gift = gift;
		this.aNum = aNum;
	}


	public int geteNum() {
		return eNum;
	}
	public void seteNum(int eNum) {
		this.eNum = eNum;
	}
	public String geteTitle() {
		return eTitle;
	}
	public void seteTitle(String eTitle) {
		this.eTitle = eTitle;
	}
	public String geteContent() {
		return eContent;
	}
	public void seteContent(String eContent) {
		this.eContent = eContent;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aNum, eContent, eNum, eTitle, gift);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventVO other = (EventVO) obj;
		return aNum == other.aNum && Objects.equals(eContent, other.eContent) && eNum == other.eNum
				&& Objects.equals(eTitle, other.eTitle) && Objects.equals(gift, other.gift);
	}
	@Override
	public String toString() {
		return "EventVO [eNum=" + eNum + ", eTitle=" + eTitle + ", eContent=" + eContent + ", gift=" + gift + ", aNum="
				+ aNum + "]";
	}
	
	
}
