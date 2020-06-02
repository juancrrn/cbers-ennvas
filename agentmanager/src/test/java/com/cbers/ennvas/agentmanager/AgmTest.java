package com.cbers.ennvas.agentmanager;

import static org.assertj.core.api.Assertions.assertThat;

import com.cbers.ennvas.agentmanager.application.service.ProductServiceImpl;
import com.cbers.ennvas.agentmanager.domain.converter.ProductEntityToProductResponseConverter;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;
import com.cbers.ennvas.agentmanager.rest.controller.AgmRestController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests AgentManager dependency injection.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@SpringBootTest
public class AgmTest
{
    
    @Autowired
    private AgmRestController agmRestController;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
	private ProductEntityToProductResponseConverter productEntityToProductResponseConverter;

    /**
     * Tests {@link AgmRestController}, {@link ProductRepository},
     * {@link ProductEntityToProductResponseConverter} and
     * {@link ProductServiceImpl} injection.
     * 
     * @throws Exception
     */
    @Test
    public void contextLoads() throws Exception
    {
        assertThat(agmRestController).isNotNull();
        assertThat(productRepository).isNotNull();
        assertThat(productServiceImpl).isNotNull();
        assertThat(productEntityToProductResponseConverter).isNotNull();
    }
}