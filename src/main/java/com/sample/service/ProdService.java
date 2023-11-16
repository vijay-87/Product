package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.entity.Product;
import com.sample.repo.ProdRepo;

@Service
public class ProdService implements IprodService {
	
	@Autowired
	ProdRepo prodRepo;
	

	@Override
	public String saveProduct(Product product) {
		prodRepo.save(product);
		return "SuceesFully Saved" ;
	}

	@Override
	public List<Product> getAllProduct() {
		return prodRepo.findAll();
		
	}


	@Override
	public Product getProductById(Long prodId) {
		
		return prodRepo.findById(prodId).get();
	}

	@Override
	public String deleteProdcutById(Long prodId) {
		boolean delete=false;
		if(prodRepo.existsById(prodId)) {
			prodRepo.deleteById(prodId);
			delete=true;
			
		}
		return "Deleted Successfully";
	}

	@Override
	public String postAllProduct(List<Product>  product) {
		prodRepo.saveAll(product);
		return "Saved All SucessFully";
	}

	

}
