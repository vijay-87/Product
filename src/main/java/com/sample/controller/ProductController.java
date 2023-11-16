package com.sample.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.entity.Product;
import com.sample.service.IprodService;

@RestController
@Tag(
		name = "PRODUCT CONTROLLER "
)
public class ProductController {
	
	@Autowired
	IprodService prodService;
	
	@PostMapping(value="/post")
	public ResponseEntity<String> creatProduct(@RequestBody Product product) {
		return new ResponseEntity<String>(prodService.saveProduct(product),HttpStatus.OK);
		
	}
	@Operation(
			summary = "Finding all the products from db",
			description = "getting all the products from the db"
	)
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Product>> getAllProduct() {
		return new ResponseEntity<List<Product>>(prodService.getAllProduct(),HttpStatus.OK);
	}
	
	@GetMapping(value="/getProdId/{prodId}")
	public ResponseEntity<Product> getProductById(@PathVariable Long prodId) {
		return new ResponseEntity<Product>(prodService.getProductById(prodId),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteById/{prodId}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long prodId) {
		return new ResponseEntity<String>(prodService.deleteProdcutById(prodId),HttpStatus.OK);
	}
	
	@PostMapping(value="/postAll")
	public String postAllProduct(@RequestBody List<Product> product) {
		prodService.postAllProduct(product);
		return "saved all sucessfully";
	}
	

}

