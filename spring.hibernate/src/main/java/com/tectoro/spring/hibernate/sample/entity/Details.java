package com.tectoro.spring.hibernate.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Details {
	
	@Id
	@Column(name = "detail_id")
	private int detailId;
	
	@Column(name = "wife_name")
	private String wifeName;
	
	@Column(name = "first_child")
	private String firstChildName;
	
	@Column(name = "second_child")
	private String secondChildName;
	
	@OneToOne(mappedBy = "details")
	private Person person;
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
