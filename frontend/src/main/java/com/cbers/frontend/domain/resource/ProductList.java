package com.cbers.frontend.domain.resource;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
 * 
 * @version 1.0.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductList
{

	private List<Product> products;
}