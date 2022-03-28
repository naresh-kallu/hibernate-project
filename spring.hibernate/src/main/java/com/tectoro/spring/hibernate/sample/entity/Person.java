package com.tectoro.spring.hibernate.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {

	@Id
	@Column(name ="person_uid")
	private int PersonUid;

	@Column(name = "person_fname")
	private String personFname;

	@Column(name = "person_lname")
	private String personLname;

	private String Address;
	
	@OneToOne
	private Details details;

	public int getPersonUid() {
		return PersonUid;
	}

	public void setPersonUid(int personUid) {
		PersonUid = personUid;
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
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Person [PersonUid=" + PersonUid + ", personFname=" + personFname + ", personLname=" + personLname
				+ ", Address=" + Address + ", details=" + details + "]";
	}
	
	

}
