package com.doit.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.doit.user.rest.Setting;
import com.doit.user.wrapper.OrderWrapper;
import com.doit.user.wrapper.ProductCategoryWrapper;
import com.doit.user.wrapper.ProductTypeWrapper;

@Service
@Transactional
public class WebService {
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
	// Consumer ProductType OrderMicroservice
	public List<ProductTypeDetail> getAllProductType() {
		String path = Setting.orderMicroserviceUrl+"/product-type/all";
		List<ProductTypeDetail> returnList = restTemplate.getForEntity(path, ProductTypeWrapper.class).getBody().getResult();
		return returnList;
	}
	
	// Consumer ProductCategory OrderMicroservice
	public List<ProductCategoryDetail> getAllProductCategory() {
		String path = Setting.orderMicroserviceUrl+"/product-category/all";
		List<ProductCategoryDetail> returnList = restTemplate.getForEntity(path, ProductCategoryWrapper.class).getBody().getResult();
		return returnList;
	}
	
	// Consumer GetAllOrder OrderMicroservice
	public List<OrderDetail> getAllOrderByBorrower(String uuidBorrower) {
		String path = Setting.orderMicroserviceUrl+"/order/"+uuidBorrower;
		List<OrderDetail> returnList = restTemplate.getForEntity(path, OrderWrapper.class).getBody().getResult();
		return returnList;
	}
}
