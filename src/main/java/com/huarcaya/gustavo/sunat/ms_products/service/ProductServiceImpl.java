package com.huarcaya.gustavo.sunat.ms_products.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.huarcaya.gustavo.sunat.ms_products.entities.Product;
import com.huarcaya.gustavo.sunat.ms_products.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

}
