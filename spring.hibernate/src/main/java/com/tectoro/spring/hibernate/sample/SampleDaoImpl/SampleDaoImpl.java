package com.tectoro.spring.hibernate.sample.SampleDaoImpl;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.tectoro.spring.hibernate.sample.SampleDao.SampleDao;
import com.tectoro.spring.hibernate.sample.domain.DetailsDomain;
import com.tectoro.spring.hibernate.sample.domain.PersonDomain;
import com.tectoro.spring.hibernate.sample.domain.ProductsDomain;
import com.tectoro.spring.hibernate.sample.domain.VendorDomain;
import com.tectoro.spring.hibernate.sample.entity.Details;
import com.tectoro.spring.hibernate.sample.entity.Person;
import com.tectoro.spring.hibernate.sample.entity.Products;
import com.tectoro.spring.hibernate.sample.entity.Vendor;

@Repository
public class SampleDaoImpl implements SampleDao {

	@Override
	public PersonDomain save(PersonDomain person) {

		SessionFactory sessionFactory = config();
		Session session = sessionFactory.openSession();

		// create person

		Person domain = new Person();
		domain.setPersonUid(person.getPersonUid());
		domain.setPersonFname(person.getPersonFname());
		domain.setPersonLname(person.getPersonLname());
		domain.setAddress(person.getAddress());

		// create Details
		Details detailsDomain = new Details();
		detailsDomain.setDetailId(person.getDetailsDomain().getDetailId());
		detailsDomain.setWifeName(person.getDetailsDomain().getWifeName());
		detailsDomain.setFirstChildName(person.getDetailsDomain().getFirstChildName());
		detailsDomain.setSecondChildName(person.getDetailsDomain().getSecondChildName());

		domain.setDetails(detailsDomain);

		// doing transaction

		Transaction transaction = session.beginTransaction();

		session.save(domain);
		session.save(detailsDomain);

		transaction.commit();

		session.close();
		sessionFactory.close();

		return person;
	}
	// TODO Auto-generated method stub

	public SessionFactory config() {
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = conf.buildSessionFactory();
		return sessionFactory;
	}

	@Override
	public PersonDomain get(PersonDomain domain) {

		SessionFactory sessionFactory = config();
		Session session = sessionFactory.openSession();
		int id = domain.getPersonUid();

		Person person = (Person) session.load(Person.class, id);

		Details details = (Details) session.get(Details.class, person.getDetails().getDetailId());
//		
//		Person person2 = (Person)session.load(Person.class,1);
//		System.out.println(person2.toString());
//				// TODO Auto-generated method stub


//		Person person3 = (Person)session.get(Person.class,1);
//	    System.out.println(person2.toString());
//		System.out.println(person3.toString());


		PersonDomain domain2 = new PersonDomain();
		domain2.setPersonUid(person.getPersonUid());
		domain2.setPersonFname(person.getPersonFname());
		domain2.setPersonLname(person.getPersonLname());
		domain2.setAddress(person.getAddress());

		DetailsDomain detailsDomain = new DetailsDomain();
		detailsDomain.setDetailId(details.getDetailId());
		detailsDomain.setWifeName(details.getWifeName());
		detailsDomain.setFirstChildName(details.getFirstChildName());
		detailsDomain.setSecondChildName(details.getSecondChildName());

		domain2.setDetailsDomain(detailsDomain);

		return domain2;
	}

	@Override
	public VendorDomain saveVendor(VendorDomain domain) {
		
		
		
		return null;
	}

	@Override
	public ProductsDomain saveProductsWithVendor(ProductsDomain domain) throws Exception{
		
		try
		{
		SessionFactory factory = config();
		Session session = factory.openSession();
		
		Products products = new Products();
		products.setProductId(domain.getProductId());
		products.setProductName(domain.getProductName());
		products.setPrice(domain.getPrice());
		
		Vendor vendor = new Vendor();
		vendor.setVendorId(domain.getDomain().getVendorId());
		vendor.setVendorCompany(domain.getDomain().getVendorCompany());
		vendor.setVendorName(domain.getDomain().getVendorName());
		
		products.setVendor(vendor);
		
		Transaction transaction = session.beginTransaction();
		session.save(vendor);
		session.save(products);
		
		transaction.commit();
		
		session.close();
		factory.close();
		
		
		
		return domain;
		}catch (Exception e) {
		throw e;
		}
	}

	public ProductsDomain updateProducts(ProductsDomain domain) {
		
		SessionFactory factory = config();
		Session session = factory.openSession();
		
		Products products = new Products();
		products.setProductId(domain.getProductId());
		products.setProductName(domain.getProductName());
		products.setPrice(domain.getPrice());
		Vendor vendor = new Vendor();
		vendor.setVendorId(domain.getDomain().getVendorId());
		products.setVendor(vendor);
		
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(products);
		
		transaction.commit();
		
		factory.close();
		session.close();
		
		return domain;
	}

	@Override
	public List<ProductsDomain> getProductList(int vendorId) {
		

		SessionFactory sessionFactory = config();
		Session session = sessionFactory.openSession();
		//String id = String.valueOf(vendorId);
		String query = "from Products where vendor_id=:x ";
		
		Query q = session.createQuery(query);
		q.setParameter("x", vendorId);
	
		List<Products> products = q.list();
		List<ProductsDomain> productsList = new ArrayList<ProductsDomain>();
		for(Products p : products)
		{
			ProductsDomain domain = new ProductsDomain();
			domain.setProductId(p.getProductId());
			domain.setProductName(p.getProductName());
			domain.setPrice(p.getPrice());
			VendorDomain vendor = new VendorDomain();
			vendor.setVendorId(p.getVendor().getVendorId());
			domain.setDomain(vendor);
			productsList.add(domain);
		
		}
		return productsList;
		
	}

}
