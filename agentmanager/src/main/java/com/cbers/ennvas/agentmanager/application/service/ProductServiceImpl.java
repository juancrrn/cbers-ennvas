package com.cbers.ennvas.agentmanager.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cbers.ennvas.agentmanager.domain.converter.ProductEntityToProductResponseConverter;
import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;
import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;
import com.cbers.ennvas.agentmanager.rest.controller.data.UniqueProductResponse;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService
{

	private ProductRepository repository;
	private ProductEntityToProductResponseConverter entityToResponseConverter;

	@Override
	public ProductResponse getAllProducts() {
		ProductResponse response = new ProductResponse();

		List<ProductEntity> allProducts = repository.findAll();
		List<UniqueProductResponse> uniqueProductsList = allProducts.stream().map(e -> entityToResponseConverter.convert(e)).collect(Collectors.toList());
		response.setProducts(uniqueProductsList);
		
		return response;
	}
	
}