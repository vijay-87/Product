package com.sample.service;

import java.util.List;



import com.sample.entity.Product;

public interface IprodService {
	
	String saveProduct(Product product);
	List<Product> getAllProduct();
	Product getProductById(Long prodId);
	String deleteProdcutById(Long prodId);
	String postAllProduct(List<Product> product);
	
	 
	

}
