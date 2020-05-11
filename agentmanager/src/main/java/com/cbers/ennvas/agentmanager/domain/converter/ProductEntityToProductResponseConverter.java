package com.cbers.ennvas.agentmanager.domain.converter;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.rest.controller.data.UniqueProductResponse;

import org.springframework.core.convert.converter.Converter;

public class ProductEntityToProductResponseConverter
	implements Converter<ProductEntity, UniqueProductResponse>
{

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
		
		return response;
	}
}