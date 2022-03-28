package com.tectoro.spring.hibernate.sample.SampleDao;

import java.util.List;


import com.tectoro.spring.hibernate.sample.domain.PersonDomain;
import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.VendorDomain;

public interface SampleDao {

	PersonDomain save(PersonDomain person);

	PersonDomain get(PersonDomain domain);

	VendorDomain saveVendor(VendorDomain domain);

	ProductsDomain saveProductsWithVendor(ProductsDomain domain) throws Exception;

	ProductsDomain updateProducts(ProductsDomain domain);

	List<ProductsDomain> getProductList(int vendorId) ;
	

}
