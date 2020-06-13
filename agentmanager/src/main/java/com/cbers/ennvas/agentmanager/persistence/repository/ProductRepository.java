package com.cbers.ennvas.agentmanager.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

/**
 * Product repository.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@Repository
public interface ProductRepository
	extends CrudRepository<ProductEntity, Integer>
{

	/**
	 * Returns a list with all the stored products.
	 */
	List<ProductEntity> findAll();
}