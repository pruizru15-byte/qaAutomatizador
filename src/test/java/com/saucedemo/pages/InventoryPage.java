package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class InventoryPage {
    private Page page;

    // Locators exactos de tu análisis
    private final String btnAddBackpack = "#add-to-cart-sauce-labs-backpack";
    private final String iconCart = "#shopping_cart_container > a";

    public InventoryPage(Page page) {
        this.page = page;
    }

    public void agregarMochilaDesdeInventario() {
        // Agregamos directo sin entrar al detalle, como mencionaste
        page.locator(btnAddBackpack).click();
    }

    public void irAlCarrito() {
        page.locator(iconCart).click();
    }
}