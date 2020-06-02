package com.cbers.ennvas.agentmanager.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

import com.google.gson.Gson;

public class DemoGenerator
{

    /**
     * Demo data JSON file path.
     */
    private static final String DEMO_DATA_JSON_PATH =
        "src/main/resources/demo/demo-products.json";

    /**
     * 
     */
    public static ProductEntity[] generate()
    {
        String jsonData = "";
		
		try {
            jsonData =
                new String(Files.readAllBytes(Paths.get(DEMO_DATA_JSON_PATH)));
		} catch (IOException e) {
			e.printStackTrace();
        }
        
        System.out.println("[ENNVAS-AGM] JSON demo data retrieved successfully.");
		
		Gson gson = new Gson();
		
        return gson.fromJson(jsonData, ProductEntity[].class);
    }
}