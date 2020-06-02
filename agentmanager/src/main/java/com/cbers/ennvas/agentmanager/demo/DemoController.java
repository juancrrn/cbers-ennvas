package com.cbers.ennvas.agentmanager.demo;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/ennvas/agm/demo")
public class DemoController
{

    @Autowired
    private ProductRepository productRepository;

    /**
     * Populates the database with demo data from a JSON file.
     */
	@GetMapping(value="/generate")
	public void generate()
	{
        System.out.println("[ENNVAS-AGM] Received demo data generation request.");

        // Retrieve demo data.

        ProductEntity[] productArray = DemoGenerator.generate();
        
        // Insert demo data.

        for (int i = 0; i < productArray.length; i++) {
            productRepository.save(productArray[i]);
        }

        System.out.println("[ENNVAS-AGM] Completed demo data generation.");
	}
}