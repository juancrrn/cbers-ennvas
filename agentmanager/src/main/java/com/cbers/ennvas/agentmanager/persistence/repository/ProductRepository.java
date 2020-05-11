package com.cbers.ennvas.agentmanager.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

public interface ProductRepository
	extends CrudRepository<ProductEntity, Integer>
{
	List<ProductEntity> findAll();
}