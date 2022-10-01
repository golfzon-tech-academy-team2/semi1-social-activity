package com.team2.sa.gathering.model;

import java.util.Objects;

public class GatheringUserInfo extends GatheringVO {
	private String uName;
	private int uNum;
	private String roll;
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getuNum() {
		return uNum;
	}
	public void setuNum(int uNum) {
		this.uNum = uNum;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(roll, uName, uNum);
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
		GatheringUserInfo other = (GatheringUserInfo) obj;
		return Objects.equals(roll, other.roll) && Objects.equals(uName, other.uName) && uNum == other.uNum;
	}
	@Override
	public String toString() {
		return "GatheringUserInfo [uName=" + uName + ", uNum=" + uNum + ", roll=" + roll + "]";
	}

}
