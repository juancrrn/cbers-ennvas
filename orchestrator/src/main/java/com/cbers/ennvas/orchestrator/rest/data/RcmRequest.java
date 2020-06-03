package com.cbers.ennvas.orchestrator.rest.data;

import java.util.List;

import com.cbers.ennvas.orchestrator.domain.resource.Product;
import com.cbers.ennvas.orchestrator.domain.resource.Query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Wraps a request with a Query and a list of Product (knowledge base).
 * 
 * Uses Jackson annotations.
 * @see https://github.com/FasterXML/jackson-docs
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RcmRequest
{

	private Query query;

	private List<Product> products;
}