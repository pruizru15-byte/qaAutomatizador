package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    
    private Page page;

    // 1. Mapeo de Locators (Usando los selectores CSS que me proporcionaste)
    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "div.error-message-container.error > h3"; // Simplifiqué un poco tu CSS para hacerlo más resistente a cambios

    // 2. Constructor: recibe la instancia de la página desde los Steps
    public LoginPage(Page page) {
        this.page = page;
    }

    // 3. Métodos de Acción (Lo que el usuario hace en la página)
    public void navegarASauceDemo() {
        page.navigate("https://www.saucedemo.com/");
    }

    public void ingresarUsername(String username) {
        page.locator(usernameInput).fill(username);
    }

    public void ingresarPassword(String password) {
        page.locator(passwordInput).fill(password);
    }

    public void hacerClicEnLogin() {
        page.locator(loginButton).click();
    }

    // Método "Atajo" para escenarios donde solo queremos loguearnos rápido
    public void iniciarSesion(String username, String password) {
        ingresarUsername(username);
        ingresarPassword(password);
        hacerClicEnLogin();
    }

    // 4. Métodos de Validación (Para nuestros "Then" en Cucumber)
    public String obtenerMensajeError() {
        // Esperamos a que el mensaje sea visible antes de capturar el texto
        page.locator(errorMessage).waitFor();
        return page.locator(errorMessage).textContent();
    }

    public boolean estaEnPaginaInventario() {
        // Playwright espera de forma inteligente a que la URL cambie
        page.waitForURL("**/inventory.html");
        return page.url().contains("inventory.html");
    }
}