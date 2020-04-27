package com.cbers.ennvas.recommender.rest.controller.data;

import java.util.LinkedList;

import com.cbers.ennvas.recommender.domain.ResultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Wraps a response with a list of ResultValues.
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
 * @version 0.1
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result_values"
})
public class RcmResponseWrapper
{

	@JsonProperty("result_values")
	private LinkedList<ResultValue> resultValues;

	@JsonIgnore
	public RcmResponseWrapper(LinkedList<ResultValue> resultValues)
	{
		this.resultValues = resultValues;
	}

	@JsonProperty("result_values")
	public LinkedList<ResultValue> getResultValues()
	{
		return this.resultValues;
	}

}