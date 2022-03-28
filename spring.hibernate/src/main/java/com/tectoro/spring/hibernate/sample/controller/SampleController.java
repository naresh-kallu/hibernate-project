package com.tectoro.spring.hibernate.sample.controller;

import java.util.ArrayList;
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

import com.tectoro.spring.hibernate.sample.domain.PersonDomain;
import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.ResponseBean;
import com.tectoro.spring.hibernate.sample.domain.VendorDomain;
import com.tectoro.spring.hibernate.sample.service.SampleService;

@RestController
@RequestMapping(value = "/sampleapi")

public class SampleController {

	@Autowired
	private SampleService sampleService;

	// person and details api

	@PostMapping(value = "/save")
	public ResponseEntity<ResponseBean> save(@RequestBody PersonDomain person) {
		ResponseBean response;
		try {

			person = sampleService.save(person);
			response = new ResponseBean(person, "person added successfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		}
	}

	// person details
	@PostMapping(value = "/get")
	public ResponseEntity<ResponseBean> get(@RequestBody PersonDomain domain) {
		ResponseBean response;
		try {
			domain = sampleService.get(domain);
			response = new ResponseBean(domain, "person details retrieved successfully", null, Boolean.TRUE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);

		} catch (Exception e) {
			response = new ResponseBean(null, null, e.getMessage(), Boolean.FALSE);
			return new ResponseEntity<ResponseBean>(response, HttpStatus.OK);
		}
	}

}
