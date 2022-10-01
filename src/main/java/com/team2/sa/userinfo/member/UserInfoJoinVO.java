package com.team2.sa.userinfo.member;

import java.util.Objects;

public class UserInfoJoinVO extends UserInfoVO {
	private String roll;

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
		result = prime * result + Objects.hash(roll);
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
		UserInfoJoinVO other = (UserInfoJoinVO) obj;
		return Objects.equals(roll, other.roll);
	}

	@Override
	public String toString() {
		return "UserInfoJoinVO [roll=" + roll + "]";
	}

}
