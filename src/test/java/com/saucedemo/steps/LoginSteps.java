package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.BrowserFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {

    // Instanciamos nuestra página de Login pasándole el navegador actual
    LoginPage loginPage = new LoginPage(BrowserFactory.getPage());

    @Given("el usuario navega a la pagina de login de Sauce Demo")
    public void el_usuario_navega_a_la_pagina_de_login_de_sauce_demo() {
        loginPage.navegarASauceDemo();
    }

    @When("el usuario ingresa el username {string} y el password {string}")
    public void el_usuario_ingresa_el_username_y_el_password(String username, String password) {
        loginPage.ingresarUsername(username);
        loginPage.ingresarPassword(password);
    }

    @When("hace clic en el boton de login")
    public void hace_clic_en_el_boton_de_login() {
        loginPage.hacerClicEnLogin();
    }

    @Then("deberia ser redirigido a la pagina de productos")
    public void deberia_ser_redirigido_a_la_pagina_de_productos() {
        // Usamos JUnit Assert para validar que el método devuelva 'true'
        Assert.assertTrue("El usuario no fue redirigido al inventario", loginPage.estaEnPaginaInventario());
    }

    @Then("deberia ver un mensaje de error indicando que el usuario esta bloqueado")
    public void deberia_ver_un_mensaje_de_error_indicando_que_el_usuario_esta_bloqueado() {
        String mensajeObtenido = loginPage.obtenerMensajeError();
        // Validamos que el mensaje de error contenga la palabra clave esperada
        Assert.assertTrue("El mensaje de error no es el esperado", mensajeObtenido.contains("locked out"));
    }

    @Given("el usuario ya ha iniciado sesion exitosamente con {string} y {string}")
    public void el_usuario_ya_ha_iniciado_sesion_exitosamente_con_y(String username, String password) {
        // Este step nos sirve de atajo para el escenario de compra completa
        loginPage.navegarASauceDemo();
        loginPage.iniciarSesion(username, password);
        Assert.assertTrue("Fallo el login previo a la compra", loginPage.estaEnPaginaInventario());
    }
}