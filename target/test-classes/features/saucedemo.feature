Feature: Compra y Autenticación en Sauce Demo
  Como un cliente de Sauce Demo
  Quiero poder iniciar sesión, agregar productos al carrito y completar una compra
  Para poder adquirir los productos que necesito

  Background:
    Given el usuario navega a la pagina de login de Sauce Demo

  # Criterio de Evaluación: Manejo de standard_user
  Scenario: Inicio de sesion exitoso
    When el usuario ingresa el username "standard_user" y el password "secret_sauce"
    And hace clic en el boton de login
    Then deberia ser redirigido a la pagina de productos

  # Criterio de Evaluación: Manejo de locked_out_user
  Scenario: Inicio de sesion de usuario bloqueado
    When el usuario ingresa el username "locked_out_user" y el password "secret_sauce"
    And hace clic en el boton de login
    Then deberia ver un mensaje de error indicando que el usuario esta bloqueado

  # Criterio de Evaluación: Manejo de credenciales inválidas (password incorrecto)
  Scenario: Inicio de sesion con contraseña incorrecta
    When el usuario ingresa el username "standard_user" y el password "password_incorrecto"
    And hace clic en el boton de login
    Then deberia ver un mensaje de error indicando que las credenciales no coinciden

  # Criterio de Evaluación: Agregar a carrito y checkout
  Scenario: Completar una compra exitosamente
    Given el usuario ya ha iniciado sesion exitosamente con "standard_user" y "secret_sauce"
    When agrega un producto al carrito desde el inventario
    And navega al carrito de compras
    Then verifica que el producto fue agregado correctamente
    When inicia el proceso de checkout
    And ingresa sus datos de envio: nombre "QA", apellido "Tester", codigo postal "12345"
    And continua y finaliza la orden
    Then deberia ver la confirmacion de compra exitosa