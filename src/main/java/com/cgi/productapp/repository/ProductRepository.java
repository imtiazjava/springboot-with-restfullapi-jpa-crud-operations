package com.cgi.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cgi.productapp.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
