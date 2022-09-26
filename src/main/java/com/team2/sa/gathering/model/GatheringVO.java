package com.team2.sa.gathering.model;

import java.util.Arrays;
import java.util.Objects;

public class GatheringVO {
	
	private int gNum;
	private String gName;
	private String gContent;
	private String logo;
	private int minAge;
	private int maxAge;
	private String sex;
	private String permission;
	private String link;
	private String isPublic;
	
	public int getgNum() {
		return gNum;
	}
	public void setgNum(int gNum) {
		this.gNum = gNum;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getgContent() {
		return gContent;
	}
	public void setgContent(String gContent) {
		this.gContent = gContent;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
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
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIsPublic() {
		return isPublic;
	}
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	@Override
	public int hashCode() {
		return Objects.hash(gContent, gName, gNum, isPublic, link, logo, maxAge, minAge, permission, sex);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GatheringVO other = (GatheringVO) obj;
		return Objects.equals(gContent, other.gContent) && Objects.equals(gName, other.gName) && gNum == other.gNum
				&& Objects.equals(isPublic, other.isPublic) && Objects.equals(link, other.link)
				&& Objects.equals(logo, other.logo) && maxAge == other.maxAge && minAge == other.minAge
				&& Objects.equals(permission, other.permission) && Objects.equals(sex, other.sex);
	}
	@Override
	public String toString() {
		return "GatheringVO [gNum=" + gNum + ", gName=" + gName + ", gContent=" + gContent + ", logo=" + logo
				+ ", minAge=" + minAge + ", maxAge=" + maxAge + ", sex=" + sex + ", permission=" + permission
				+ ", link=" + link + ", isPublic=" + isPublic + "]";
	}
	
	

	


	
	

}
