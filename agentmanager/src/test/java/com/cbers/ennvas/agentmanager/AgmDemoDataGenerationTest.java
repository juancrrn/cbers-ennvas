package com.cbers.ennvas.agentmanager;

import static org.assertj.core.api.Assertions.assertThat;

import com.cbers.ennvas.agentmanager.demo.DemoGenerator;
import com.cbers.ennvas.agentmanager.persistence.entity.ProductEntity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Tests AgentManager demo data generation.
 * 
 * @author Juan Francisco Carrión Molina
 * @author Raquel Pérez González de Ossuna
 * @author Olga Posada Iglesias
 * @author Nicolás Pardina Popp
 * 
 * @version 1.0.0
 */

@SpringBootTest
public class AgmDemoDataGenerationTest
{

    private ProductEntity[] productEntityArray;

    @Test
    public void demoDataGeneration() throws Exception
    {
        System.out.println("[ENNVAS-AGM][AgmDemoDataGenerationTest] Initializing.");

        productEntityArray = DemoGenerator.generate();

        System.out.println("[ENNVAS-AGM][AgmDemoDataGenerationTest] Assertions.");

        assertThat(productEntityArray.length).isGreaterThan(0);
    }
}