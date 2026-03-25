package com.saucedemo.hooks;

import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        // Esto se ejecuta antes de la primera palabra (Given/When/Then) de cada escenario
        System.out.println("▶ Iniciando escenario: " + scenario.getName());
        
        // Llamamos a la fábrica para asegurarnos de que el navegador se levante
        BrowserFactory.getPage();
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        // Esto se ejecuta después de cada paso (Given/When/Then)
        try {
            byte[] screenshot = BrowserFactory.getPage().screenshot();
            scenario.attach(screenshot, "image/png", "Captura de pantalla del paso");
        } catch (Exception e) {
            System.err.println("❌ No se pudo tomar la captura de pantalla: " + e.getMessage());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        // Esto se ejecuta al finalizar cada escenario, sin importar si pasó o falló
        System.out.println("⏹ Finalizando escenario: " + scenario.getName() + " | Estado: " + scenario.getStatus());

        // BONUS: Si el escenario falla, podemos tomar una captura de pantalla automáticamente
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = BrowserFactory.getPage().screenshot();
                scenario.attach(screenshot, "image/png", "Captura de pantalla del error");
                System.out.println("📸 Captura de pantalla guardada para el escenario fallido.");
            } catch (Exception e) {
                System.err.println("No se pudo tomar la captura de pantalla: " + e.getMessage());
            }
        }

        // Finalmente, destruimos la instancia del navegador para limpiar todo
        BrowserFactory.closeBrowser();
    }
}