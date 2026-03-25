package com.saucedemo.utils;

import com.microsoft.playwright.*;

public class BrowserFactory {
    
    // Usamos variables estáticas para mantener la misma instancia durante el escenario
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    // Método principal para obtener la página actual
    public static Page getPage() {
        if (page == null) {
            initBrowser();
        }
        return page;
    }

    // Método privado que inicializa Playwright y el navegador
    private static void initBrowser() {
        playwright = Playwright.create();
        
        // Configuramos las opciones de lanzamiento
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setHeadless(false) // Ponlo en 'true' cuando quieras que corra en segundo plano (CI/CD)
                .setSlowMo(1000);     // Agrega un pequeño retraso para ver las acciones

        // Lanzamos Chromium (puedes cambiarlo a firefox() o webkit())
        browser = playwright.chromium().launch(launchOptions);
        
        // Creamos un contexto (es como una sesión de incógnito limpia)
        context = browser.newContext();
        
        // Abrimos una nueva pestaña
        page = context.newPage();
    }

    // Método para limpiar y cerrar todo al final de la prueba
    public static void closeBrowser() {
        if (page != null) {
            page.close();
            context.close();
            browser.close();
            playwright.close();
            page = null; // Reiniciamos la variable para el siguiente escenario
        }
    }
}