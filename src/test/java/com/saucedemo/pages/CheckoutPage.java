package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CheckoutPage {
    private Page page;

    // Locators Step One (Datos)
    private final String inputFirstName = "#first-name";
    private final String inputLastName = "#last-name";
    private final String inputPostalCode = "#postal-code";
    private final String btnContinue = "#continue";

    // Locators Step Two (Resumen)
    private final String btnFinish = "#finish";

    // Locators Complete (Éxito)
    private final String msjComplete = "#checkout_complete_container > h2";
    private final String btnBackToProducts = "#back-to-products";

    public CheckoutPage(Page page) {
        this.page = page;
    }

    public void llenarDatosPersonales(String nombre, String apellido, String zip) {
        page.locator(inputFirstName).fill(nombre);
        page.locator(inputLastName).fill(apellido);
        page.locator(inputPostalCode).fill(zip);
    }

    public void continuar() {
        page.locator(btnContinue).click();
    }

    public void finalizarCompra() {
        page.locator(btnFinish).click();
    }

    public String obtenerMensajeExito() {
        page.locator(msjComplete).waitFor();
        return page.locator(msjComplete).textContent();
    }
}