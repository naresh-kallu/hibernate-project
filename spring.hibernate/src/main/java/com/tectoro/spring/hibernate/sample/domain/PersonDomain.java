package com.tectoro.spring.hibernate.sample.domain;


public class PersonDomain {

    private int personUid;
	private String personFname;
	private String personLname;
	private String address;
	private DetailsDomain detailsDomain;
	public int getPersonUid() {
		return personUid;
	}
	public void setPersonUid(int personUid) {
		this.personUid = personUid;
	}
	public String getPersonFname() {
		return personFname;
	}
	public void setPersonFname(String personFname) {
		this.personFname = personFname;
	}
	public String getPersonLname() {
		return personLname;
	}
	public void setPersonLname(String personLname) {
		this.personLname = personLname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public DetailsDomain getDetailsDomain() {
		return detailsDomain;
	}
	public void setDetailsDomain(DetailsDomain detailsDomain) {
		this.detailsDomain = detailsDomain;
	}
	
	
	
}
