package com.huarcaya.gustavo.sunat.ms_products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huarcaya.gustavo.sunat.ms_products.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
