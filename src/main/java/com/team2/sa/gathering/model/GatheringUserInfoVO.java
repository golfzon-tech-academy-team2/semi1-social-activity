package com.team2.sa.gathering.model;

import java.util.Objects;

public class GatheringUserInfoVO extends GatheringVO{
	private int gNum;
	private String roll;
	private int uNum;
	private String uName;
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(gNum, roll, uName, uNum);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		GatheringUserInfoVO other = (GatheringUserInfoVO) obj;
		return gNum == other.gNum && Objects.equals(roll, other.roll) && Objects.equals(uName, other.uName)
				&& uNum == other.uNum;
	}
	@Override
	public String toString() {
		return "GatheringUserInfoVO [gNum=" + gNum + ", roll=" + roll + ", uNum=" + uNum + ", uName=" + uName + "]";
	}
	

}
