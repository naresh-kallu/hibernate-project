package com.tectoro.spring.hibernate.sample.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;

@Entity
public class Vendor {

	@Id
	@Column(name = "vendor_id")
	private int vendorId;
	private String vendorName;
	private String vendorCompany;
	
	@OneToMany(mappedBy = "vendor")
	private List<Products> products;
	
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorCompany() {
		return vendorCompany;
	}
	public void setVendorCompany(String vendorCompany) {
		this.vendorCompany = vendorCompany;
	}
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
}
