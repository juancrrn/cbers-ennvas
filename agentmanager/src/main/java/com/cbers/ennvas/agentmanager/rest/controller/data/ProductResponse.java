package com.cbers.ennvas.agentmanager.rest.controller.data;

import java.util.List;

import lombok.Data;

@Data
public class ProductResponse
{
	
	private List<UniqueProductResponse> products;
}