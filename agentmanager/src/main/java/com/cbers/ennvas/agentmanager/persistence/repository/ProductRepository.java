package com.cbers.ennvas.agentmanager.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

@Repository
public interface ProductRepository
	extends CrudRepository<ProductEntity, Integer>
{
	List<ProductEntity> findAll();
}