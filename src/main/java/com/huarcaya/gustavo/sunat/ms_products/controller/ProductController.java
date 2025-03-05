package com.huarcaya.gustavo.sunat.ms_products.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.huarcaya.gustavo.sunat.ms_products.entities.Product;
import com.huarcaya.gustavo.sunat.ms_products.service.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Product", description = "The Product APIs")
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final IProductService productService;

	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@Operation(summary = "Get Product list")
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAll();
	}

	@Operation(summary = "Get Product by Id")
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		return productService.findById(id).map(product -> ResponseEntity.ok(product))
				.orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Create a new Product")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
		Product productClient = productService.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(productClient);
	}

	@Operation(summary = "Update a Product by Id")
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product productDetail) {
		return productService.findById(id).map(product -> {
			product.setName(productDetail.getName());
			product.setDescription(productDetail.getDescription());
			product.setPrice(productDetail.getPrice());
			Product updatedProduct = productService.save(product);
			return ResponseEntity.ok(updatedProduct);
		}).orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Delete a Product by Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		if (productService.findById(id).isPresent()) {
			productService.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
