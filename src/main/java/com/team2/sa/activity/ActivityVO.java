package com.team2.sa.activity;

import java.sql.Date;
import java.util.Objects;

public class ActivityVO {

	private int gNum;
	private int aNum;
	private String aName;
	private String aContent;
	private Date aStartDay;
	private Date aEndDay;
	private String location;
	private Date startDate;
	private Date endDate;
	private int personCnt;
	private int minAge;
	private int maxAge;
	private String sex;
	private int maxPerson;
	
	public ActivityVO() {
	}

	public ActivityVO(int gNum, int aNum, String aName, String aContent, Date aStartDay, Date aEndDay, String location,
			Date startDate, Date endDate, int personCnt, int minAge, int maxAge, String sex,
			int maxPerson) {
		super();
		this.gNum = gNum;
		this.aNum = aNum;
		this.aName = aName;
		this.aContent = aContent;
		this.aStartDay = aStartDay;
		this.aEndDay = aEndDay;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.personCnt = personCnt;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.sex = sex;
		this.maxPerson = maxPerson;
	}

	public int getgNum() {
		return gNum;
	}

	public void setgNum(int gNum) {
		this.gNum = gNum;
	}

	public int getaNum() {
		return aNum;
	}

	public void setaNum(int aNum) {
		this.aNum = aNum;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaContent() {
		return aContent;
	}

	public void setaContent(String aContent) {
		this.aContent = aContent;
	}

	public Date getaStartDay() {
		return aStartDay;
	}

	public void setaStartDay(Date aStartDay) {
		this.aStartDay = aStartDay;
	}

	public Date getaEndDay() {
		return aEndDay;
	}

	public void setaEndDay(Date aEndDay) {
		this.aEndDay = aEndDay;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public int getPersonCnt() {
		return personCnt;
	}

	public void setPersonCnt(int personCnt) {
		this.personCnt = personCnt;
	}
	
	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aContent, aEndDay, aName, aNum, aStartDay, endDate, gNum, location, maxAge, maxPerson,
				minAge, personCnt, sex, startDate);
	}

	@Override
	public String toString() {
		return "ActivityVO [gNum=" + gNum + ", aNum=" + aNum + ", aName=" + aName + ", aContent=" + aContent
				+ ", aStartDay=" + aStartDay + ", aEndDay=" + aEndDay + ", location=" + location + ", startDate="
				+ startDate + ", endDate=" + endDate + ", personCnt=" + personCnt + ", minAge=" + minAge + ", maxAge="
				+ maxAge + ", sex=" + sex + ", maxPerson=" + maxPerson + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityVO other = (ActivityVO) obj;
		return Objects.equals(aContent, other.aContent) && Objects.equals(aEndDay, other.aEndDay)
				&& Objects.equals(aName, other.aName) && aNum == other.aNum
				&& Objects.equals(aStartDay, other.aStartDay) && Objects.equals(endDate, other.endDate)
				&& gNum == other.gNum && Objects.equals(location, other.location) && maxAge == other.maxAge
				&& maxPerson == other.maxPerson && minAge == other.minAge && personCnt == other.personCnt
				&& Objects.equals(sex, other.sex) && Objects.equals(startDate, other.startDate);
	}

}
