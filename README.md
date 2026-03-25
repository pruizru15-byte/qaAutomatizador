# 🚀 Reto de Automatización - SauceDemo QA

Este proyecto implementa una suite de pruebas automatizadas para la aplicación web [SauceDemo](https://www.saucedemo.com/), utilizando tecnologías de vanguardia y siguiendo las mejores prácticas de la industria en el área de Quality Assurance.

---

## 🛠️ Stack Tecnológico

*   **Lenguaje:** Java 24
*   **Herramienta de Automatización:** Playwright
*   **Marco de Trabajo (BDD):** Cucumber
*   **Motor de Pruebas:** JUnit 4
*   **Gestor de Dependencias:** Maven
*   **Patrón de Diseño:** Page Object Model (POM)

---

## 🏗️ Estrategia y Patrones Utilizados

Se ha implementado el patrón de diseño **Page Object Model (POM)** para garantizar la mantenibilidad y escalabilidad del código. Cada página de la aplicación (`LoginPage`, `InventoryPage`, `CartPage`, `CheckoutPage`) está representada por una clase Java que encapsula sus selectores y lógica de interacción.

### Características Principales:
*   **BDD con Cucumber:** Los escenarios están escritos en lenguaje Gherkin (español), facilitando la comunicación entre perfiles técnicos y de negocio.
*   **Navegador Dinámico:** Configurado para correr de forma interactiva (`headless: false`) con un leve retraso (`SlowMo`) para permitir la supervisión visual.
*   **Evidencias:** Generación automática de reportes HTML con capturas de pantalla integradas después de cada paso ejecutado.
*   **Ganchos (Hooks):** Gestión centralizada del ciclo de vida del navegador (Setup y TearDown).

---

## 📂 Estructura del Proyecto

```text
saucedemo-playwright-qa/
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.saucedemo.hooks/      # Ganchos de configuración (Screenshots, Setup)
│   │   │   ├── com.saucedemo.pages/      # Clases del Page Object Model
│   │   │   ├── com.saucedemo.runners/    # Ejecutor de pruebas (JUnit/Cucumber)
│   │   │   ├── com.saucedemo.steps/      # Definición de pasos (Glue code)
│   │   │   └── com.saucedemo.utils/      # Utilidades (Navegador, Config)
│   │   └── resources/
│   │       └── features/                 # Archivos .feature (Gherkin)
├── target/                               # Reportes generados (tras ejecución)
└── pom.xml                               # Configuración de Maven
```

---

## 🚀 Instrucciones de Ejecución

### 1. Pre-requisitos
*   Java JDK (instalado y en el PATH).
*   Maven (instalado y en el PATH).

### 2. Instalación de Dependencias
Ejecute el siguiente comando en la terminal para descargar las librerías necesarias y preparar el entorno:
```bash
mvn clean install
```

### 3. Ejecutar las Pruebas
Para ejecutar la suite completa de escenarios:
```bash
mvn test -Dtest=TestRunner
```

---

## 📊 Reportes y Evidencias

Tras la ejecución, podrá encontrar el informe interactivo con las capturas de pantalla integradas en:
`target/cucumber-reports/report.html`

---

## 🧪 Escenarios Evaluados
1.  **Inicio de sesión exitoso:** Validación con `standard_user`.
2.  **Usuario bloqueado:** Validación de mensaje de error con `locked_out_user`.
3.  **Credenciales inválidas:** Validación de mensaje con contraseña incorrecta.
4.  **Flujo completo de compra:** Desde el login hasta la confirmación final de la orden.
