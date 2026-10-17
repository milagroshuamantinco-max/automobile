package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AppConfigSteps;
import com.nttdata.steps.ProductSteps;
import com.nttdata.support.ScreenshotAttacher;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStepDefs {

    private final AppConfigSteps appConfigSteps = new AppConfigSteps();
    private final ProductSteps productSteps = new ProductSteps();

    private Scenario scenario;

    @Before
    public void configurarScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("estoy en la aplicación de SauceLabs")
    public void ingreso_al_aplicativo() {
        appConfigSteps.iniciarAplicacion("saucelabs" + ".properties");
        ScreenshotAttacher.attach(scenario, "Pantalla inicial");
    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void valido_que_carguen_correctamente_los_productos_en_la_galeria() {
        Assert.assertTrue(
                "No se encontraron los productos en la galería",
                productSteps.validarCargaDeProductos()
        );
    }

    @When("agrego {int} del siguiente producto {string}")
    public void agrego_del_siguiente_producto(int cantidad, String producto) {
        productSteps.agregarProductoAlCarrito(cantidad, producto);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void valido_el_carrito_de_compra_actualice_correctamente() {
        Assert.assertTrue(
                "El carrito no se actualizó correctamente",
                productSteps.validarActualizacionCarrito()
        );
//        productSteps.regresarPantallaPrincipal();
        appConfigSteps.cerrarAplicacion("com.saucelabs.mydemoapp.android");
    }
}
