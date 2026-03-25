package com.saucedemo.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Ruta donde están nuestros archivos Gherkin
        features = "src/test/resources/features",
        
        // Paquetes donde Cucumber debe buscar el código Java (Steps y Hooks)
        glue = {"com.saucedemo.steps", "com.saucedemo.hooks"},
        
        // Configuración de los reportes de salida
        plugin = {
                "pretty", // Imprime el resultado en la consola de forma legible
                "html:target/cucumber-reports/report.html", // Genera un reporte HTML local
                "json:target/cucumber-reports/cucumber.json" // Genera un JSON (útil para integraciones CI/CD)
        },
        
        // Hace que la salida en consola sea más limpia (sin caracteres extraños)
        monochrome = true
)
public class TestRunner {
    // Esta clase se deja vacía intencionalmente. 
    // Las anotaciones de arriba hacen todo el trabajo de configuración.
}