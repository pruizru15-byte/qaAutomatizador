package com.saucedemo.pages;

import com.microsoft.playwright.Page;

public class CartPage {
    private Page page;

    // Locators de tu análisis
    private final String btnCheckout = "#checkout";
    private final String inventoryItems = ".cart_item"; // Verificamos que exista al menos un item

    public CartPage(Page page) {
        this.page = page;
    }

    public boolean hayProductosEnElCarrito() {
        page.waitForSelector(inventoryItems);
        return page.locator(inventoryItems).count() > 0;
    }

    public void irACheckout() {
        page.locator(btnCheckout).click();
    }
}