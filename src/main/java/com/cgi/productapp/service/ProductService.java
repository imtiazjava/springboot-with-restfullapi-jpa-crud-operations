package com.cgi.productapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cgi.productapp.entity.Product;
import com.cgi.productapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public boolean saveProduct(Product product) {
		this.productRepository.save(product);
		return true;
	}

	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}

	public Product getProductById(int pid) {
		Optional<Product> op = this.productRepository.findById(pid);
		if (op.isPresent()) {
			return op.get();

		} else {
			return null;
		}

	}
	
	
	public boolean deleteProductById(int pid) {
		  this.productRepository.deleteById(pid);
		  return true;
	}

	public Product updateProduct(Product product) {
		 
		return this.productRepository.save(product);
	}

}
