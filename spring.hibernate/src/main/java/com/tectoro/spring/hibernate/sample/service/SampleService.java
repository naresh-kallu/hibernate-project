package com.tectoro.spring.hibernate.sample.service;

import java.util.List;

import com.tectoro.spring.hibernate.sample.domain.PersonDomain;
import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.ResponseBean;
import com.tectoro.spring.hibernate.sample.domain.VendorDomain;

public interface SampleService {

	PersonDomain save(PersonDomain person);

	PersonDomain get(PersonDomain domain);

	VendorDomain saveVendor(VendorDomain domain);

	ProductsDomain saveProductsWithVendor(ProductsDomain domain) throws Exception;

	ProductsDomain updateProducts(ProductsDomain domain);

	List<ProductsDomain> getProductList(int vendorId);


}
