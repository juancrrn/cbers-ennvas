package com.cbers.ennvas.agentmanager.application.service;

import java.util.List;
import java.util.stream.Collectors;

import com.cbers.ennvas.agentmanager.domain.converter.ProductEntityToUniqueProductResponseConverter;
import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;
import com.cbers.ennvas.agentmanager.rest.controller.data.ProductResponse;
import com.cbers.ennvas.agentmanager.rest.controller.data.UniqueProductResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Product service interface implementation.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductEntityToUniqueProductResponseConverter productEntityToUniqueProductResponseConverter;

	/**
	 * Returns all the products.
	 * 
	 * @return All the products.
	 */
	@Override
	public ProductResponse getAllProducts() {
		ProductResponse response = new ProductResponse();

		List<ProductEntity> allProducts = productRepository.findAll();
		List<UniqueProductResponse> uniqueProductsList = allProducts
			.stream()
			.map(e -> productEntityToUniqueProductResponseConverter.convert(e))
			.collect(Collectors.toList());

		response.setProducts(uniqueProductsList);
		
		return response;
	}
}