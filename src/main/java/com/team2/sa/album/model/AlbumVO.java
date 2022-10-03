package com.team2.sa.album.model;

import java.util.Objects;

public class AlbumVO {
	private int gNum;
	private String fileName;
	private int uNum;
	private String uName;
	private int aNum;
	private String type;
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
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
	public int getaNum() {
		return aNum;
	}
	public void setaNum(int aNum) {
		this.aNum = aNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(aNum, fileName, gNum, type, uName, uNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlbumVO other = (AlbumVO) obj;
		return aNum == other.aNum && Objects.equals(fileName, other.fileName) && gNum == other.gNum
				&& Objects.equals(type, other.type) && Objects.equals(uName, other.uName) && uNum == other.uNum;
	}
	@Override
	public String toString() {
		return "AlbumVO [gNum=" + gNum + ", fileName=" + fileName + ", uNum=" + uNum + ", uName=" + uName + ", aNum="
				+ aNum + ", type=" + type + "]";
	}
	
	

}
