package com.tectoro.spring.hibernate.sample.domain;

public class DetailsDomain {

	
	private int detailId;
	private String wifeName;
	private String firstChildName;
	private String secondChildName;
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public String getWifeName() {
		return wifeName;
	}
	public void setWifeName(String wifeName) {
		this.wifeName = wifeName;
	}
	public String getFirstChildName() {
		return firstChildName;
	}
	public void setFirstChildName(String firstChildName) {
		this.firstChildName = firstChildName;
	}
	public String getSecondChildName() {
		return secondChildName;
	}
	public void setSecondChildName(String secondChildName) {
		this.secondChildName = secondChildName;
	}
	
	
}
