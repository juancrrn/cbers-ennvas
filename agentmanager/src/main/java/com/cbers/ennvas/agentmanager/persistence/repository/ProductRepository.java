package com.cbers.ennvas.agentmanager.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

/**
 * TODO Describe this class
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
	 * TODO Describe this method
	 */
	List<ProductEntity> findAll();
}