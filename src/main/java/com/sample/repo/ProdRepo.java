package com.sample.repo;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.entity.Product;

public interface ProdRepo extends MongoRepository<Product, Long>{

	
	

}
