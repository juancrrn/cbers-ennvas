package com.cbers.ennvas.agentmanager.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;
import com.cbers.ennvas.agentmanager.persistence.repository.ProductRepository;
import com.google.gson.Gson;

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

    /**
     * Demo data JSON file path.
     */
    private static final String DEMO_DATA_JSON_PATH =
        "src/main/resources/demo/demo-products.json";

    @Autowired
    private ProductRepository repository;

    /**
     * Populates the database with demo data from a JSON file.
     */
	@GetMapping(value="/generate")
	public void generate()
	{
        System.out.println("[ENNVAS-AGM] Received demo data generation request.");

        // Retrieve demo data.

        String jsonData = "";
		
		try {
            jsonData =
                new String(Files.readAllBytes(Paths.get(DEMO_DATA_JSON_PATH)));
		} catch (IOException e) {
			e.printStackTrace();
        }
        
        System.out.println("[ENNVAS-AGM] JSON demo data retrieved successfully.");
		
		Gson gson = new Gson();
		
        ProductEntity[] productArray =
            gson.fromJson(jsonData, ProductEntity[].class);
        
        // Insert demo data.

        for (int i = 0; i < productArray.length; i++) {
            repository.save(productArray[i]);
        }

        System.out.println("[ENNVAS-AGM] Completed demo data generation.");
	}
}