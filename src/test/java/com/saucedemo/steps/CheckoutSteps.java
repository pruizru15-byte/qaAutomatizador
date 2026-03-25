package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class CheckoutSteps {

    // Instanciamos las páginas usando nuestro navegador activo
    InventoryPage inventoryPage = new InventoryPage(BrowserFactory.getPage());
    CartPage cartPage = new CartPage(BrowserFactory.getPage());
    CheckoutPage checkoutPage = new CheckoutPage(BrowserFactory.getPage());

    @When("agrega un producto al carrito desde el inventario")
    public void agrega_un_producto_al_carrito_desde_el_inventario() {
        inventoryPage.agregarMochilaDesdeInventario();
    }

    @When("navega al carrito de compras")
    public void navega_al_carrito_de_compras() {
        inventoryPage.irAlCarrito();
    }

    @Then("verifica que el producto fue agregado correctamente")
    public void verifica_que_el_producto_fue_agregado_correctamente() {
        Assert.assertTrue("El carrito está vacío", cartPage.hayProductosEnElCarrito());
    }

    @When("inicia el proceso de checkout")
    public void inicia_el_proceso_de_checkout() {
        cartPage.irACheckout();
    }

    @When("ingresa sus datos de envio: nombre {string}, apellido {string}, codigo postal {string}")
    public void ingresa_sus_datos_de_envio_nombre_apellido_codigo_postal(String nombre, String apellido, String zip) {
        checkoutPage.llenarDatosPersonales(nombre, apellido, zip);
    }

    @When("continua y finaliza la orden")
    public void continua_y_finaliza_la_orden() {
        checkoutPage.continuar();
        checkoutPage.finalizarCompra();
    }

    @Then("deberia ver la confirmacion de compra exitosa")
    public void deberia_ver_la_confirmacion_de_compra_exitosa() {
        String mensajeEsperado = "Thank you for your order!";
        Assert.assertEquals("El mensaje de confirmación no coincide", mensajeEsperado, checkoutPage.obtenerMensajeExito());
    }
}