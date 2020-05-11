package com.cbers.ennvas.recommender.rest.controller.data;

import java.util.LinkedList;

import com.cbers.ennvas.recommender.domain.resource.ResponseProduct;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * Wraps a response with a list of ResponseProducts.
 * 
 * Uses Jackson annotations.
 * @see https://github.com/FasterXML/jackson-docs
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * @author Melany Daniela Chicaiza Quezada
 * 
 * @version 0.0.2
 */

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result_values"
})
public class RcmResponseWrapper
{

	private LinkedList<ResponseProduct> responseProducts;

	@JsonIgnore
	public RcmResponseWrapper(LinkedList<ResponseProduct> responseProducts)
	{
		this.responseProducts = responseProducts;
	}
}