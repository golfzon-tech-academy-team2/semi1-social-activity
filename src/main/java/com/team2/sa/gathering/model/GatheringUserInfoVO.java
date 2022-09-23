package com.team2.sa.gathering.model;

import java.util.Objects;

public class GatheringUserInfoVO {
	int gNum;
	String roll;
	int uNum;
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
	@Override
	public int hashCode() {
		return Objects.hash(gNum, roll, uNum);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GatheringUserInfoVO other = (GatheringUserInfoVO) obj;
		return gNum == other.gNum && Objects.equals(roll, other.roll) && uNum == other.uNum;
	}
	@Override
	public String toString() {
		return "GatheringUserInfoVO [gNum=" + gNum + ", roll=" + roll + ", uNum=" + uNum + "]";
	}

}
