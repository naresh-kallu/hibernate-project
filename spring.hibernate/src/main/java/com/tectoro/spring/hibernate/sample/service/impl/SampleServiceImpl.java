package com.tectoro.spring.hibernate.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tectoro.spring.hibernate.sample.SampleDao.SampleDao;
import com.tectoro.spring.hibernate.sample.domain.PersonDomain;
import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.VendorDomain;
import com.tectoro.spring.hibernate.sample.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private SampleDao sampleDao;
	@Override
	public PersonDomain save(PersonDomain person) {
		
		return sampleDao.save(person);
	}

	public PersonDomain get(PersonDomain domain) {
		
		return sampleDao.get(domain);
	}

	@Override
	public VendorDomain saveVendor(VendorDomain domain) {
		
		return sampleDao.saveVendor(domain);
	}

	public ProductsDomain saveProductsWithVendor(ProductsDomain domain) throws Exception {
		
		try
		{
		return sampleDao.saveProductsWithVendor(domain);
		}catch (Exception e) {
			
			throw e;
		}
		
	}

	@Override
	public ProductsDomain updateProducts(ProductsDomain domain) {
		
		return sampleDao.updateProducts(domain);
	}

	public List<ProductsDomain> getProductList(int vendorId) {
		
		return sampleDao.getProductList(vendorId);
	}

}
