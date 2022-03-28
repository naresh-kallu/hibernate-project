package com.tectoro.spring.hibernate.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.ResponseBean;
import com.tectoro.spring.hibernate.sample.service.SampleService;

@RestController
@RequestMapping(value = "/sampleapi2")
public class SampleController2 {

	@Autowired
	private SampleService sampleService;

	// vendor and product saving

	@PostMapping(value = "/savevendor")
	public ResponseEntity<ResponseBean> save(@RequestBody ProductsDomain domain) {
		ResponseBean bean;
		try {
			domain = sampleService.saveProductsWithVendor(domain);
			bean = new ResponseBean(domain, "vendor added successfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);

		} catch (Exception e) {
			bean = new ResponseBean(domain, e.getMessage(), null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
		}
	}

	// adding products with the product id
	@PostMapping(value = "/updateProductlist")
	public ResponseEntity<ResponseBean> update(@RequestBody ProductsDomain domain) {
		ResponseBean bean;
		try {
			domain = sampleService.updateProducts(domain);
			bean = new ResponseBean(domain, "vendor added successfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);

		} catch (Exception e) {
			bean = new ResponseBean(domain, e.getMessage(), null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
		}
	}

	@GetMapping(value = "/getproductslist")
	public ResponseEntity<ResponseBean> update(@RequestParam("id") int vendorId) {
		List<ProductsDomain> products = null;

		ResponseBean bean;

		try {
			products = sampleService.getProductList(vendorId);
			bean = new ResponseBean(products," productslist retrieved" , null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);
		} catch (Exception e) {
			bean = new ResponseBean(products,e.getMessage(), null, Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(bean, HttpStatus.OK);		}

	}


}
