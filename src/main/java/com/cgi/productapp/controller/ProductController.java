package com.cgi.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.productapp.entity.Product;
import com.cgi.productapp.service.ProductService;

@RestController
@RequestMapping("/api/")
public class ProductController {

	@Autowired
	private ProductService productService;

	// handlers methods
	/*
	 * 1. method name : saveProduct purpose : to save the product details http
	 * method : Post on success print the message "SUCCESSFULLY STORE" and HTTP
	 * status is 'CREATED' on failure print the message 'NOT FOUND' and HTTP status
	 * 'INSUFFICIENT_STORING'
	 */

	@PostMapping(path = "product", consumes = { "application/json" })
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		boolean status = this.productService.saveProduct(product);
		if (status == true) {
			return new ResponseEntity<>("SUCCEESFULLY STORE IND B", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("SOME ISSUE", HttpStatus.INSUFFICIENT_STORAGE);
		}

	}

	/*
	 * 2. method name : getProducts() http method : get path : product purpose : to
	 * get all the product details and send to client
	 */

	@GetMapping(path = "product", produces = { "application/json" })
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> list = this.productService.getProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}

	/*
	 * 3. method name : getProductById() http method : GET path : product/{id}
	 * purpose : to fetch the particular record from the db.
	 */

	@GetMapping(path = "product/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
		Product product = this.productService.getProductById(id);
		if (product == null) {
			return new ResponseEntity<String>("PRODUCT-NOT-FOUND", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

	}

	/*
	 * 4. method name : deleteProductById() http method : DELETE path : product/{id}
	 * purpose : delete the product based on product id.
	 */

	@DeleteMapping(path = "product/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable("id") int id) {
		boolean b = this.productService.deleteProductById(id);
		if (b == true) {
			return new ResponseEntity<String>("SUCCESSFULLY DELETE FROM DB", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NOT FOUND", HttpStatus.NOT_FOUND);
		}

	}

	/*
	 * 5.  
	 * method name : updateProduct()
	 * http method : PUT
	 * path        : product
	 * purpose     : to update the product details
	 */

	@PutMapping(path = "product", consumes = { "application/json" })
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		 Product pr=this.productService.updateProduct(product);
		 return new ResponseEntity<Product>(pr, HttpStatus.CREATED);
		 
	}
}
