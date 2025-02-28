package com.huarcaya.gustavo.sunat.ms_products.service;

import java.util.List;
import java.util.Optional;

import com.huarcaya.gustavo.sunat.ms_products.entities.Product;

public interface IProductService {

	List<Product> findAll();

	Optional<Product> findById(Long id);

	Product save(Product product);

	void deleteById(Long id);

}
