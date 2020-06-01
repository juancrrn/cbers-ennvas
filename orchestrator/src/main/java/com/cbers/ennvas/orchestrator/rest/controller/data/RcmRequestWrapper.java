package com.cbers.ennvas.orchestrator.rest.controller.data;

import java.util.LinkedList;
import java.util.List;

import com.cbers.ennvas.orchestrator.domain.resource.AgmProduct;
import com.cbers.ennvas.orchestrator.domain.resource.FrontQuery;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

/**
 * Wraps a request with a Query and a list of Product (knowledgebase).
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
    "query",
    "stored_values"
})
public class RcmRequestWrapper
{

	private FrontQuery query;

	private List<AgmProduct> products;

	@JsonIgnore
	public RcmRequestWrapper(FrontQuery query, List<AgmProduct> products)
	{
		this.query = query;
		this.products = products;
	}

	@JsonCreator
	public RcmRequestWrapper()
	{
		this.query = new FrontQuery();
		this.products = new LinkedList<AgmProduct>();
	}
}