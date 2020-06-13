package com.cbers.ennvas.agentmanager.domain.converter;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.rest.controller.data.UniqueProductResponse;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * ProductEntity to UniqueProductResponse converter class.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Component
public class ProductEntityToUniqueProductResponseConverter
	implements Converter<ProductEntity, UniqueProductResponse>
{

	/**
	 * Converts a ProductEntity object to a UniqueProductResponse object.
	 * 
	 * @param source ProductEntity object.
	 * 
	 * @return UniqueProductResponse object.
	 */
	@Override
	public UniqueProductResponse convert(ProductEntity source)
	{
		UniqueProductResponse response = new UniqueProductResponse();

		response.setBrand(source.getBrand());
		response.setDescription(source.getDescription());
		response.setName(source.getName());
		response.setPrice(source.getPrice());
		response.setRating(source.getRating());
		response.setShippingPrice(source.getShippingPrice());
		response.setShippingTime(source.getShippingTime());
		response.setStock(source.getStock());
		response.setType(source.getType());
		response.setProviderName(source.getProviderName());
		response.setProviderUniqueUrl(source.getProviderUniqueUrl());
		
		return response;
	}
}