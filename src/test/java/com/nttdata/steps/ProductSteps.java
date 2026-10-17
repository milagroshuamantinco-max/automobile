package com.nttdata.steps;

import com.nttdata.screens.AppConfigScreen;
import com.nttdata.screens.ProductScreen;

public class ProductSteps {

    private final ProductScreen productScreen = new ProductScreen();

    public boolean validarCargaDeProductos() {
        System.out.println("[ProductSteps] Validando carga de productos en la galería...");
        return productScreen.isProductTitleDisplayed();
    }

    public void agregarProductoAlCarrito(int cantidad, String producto) {
        System.out.println("[ProductSteps] Agregando producto al carrito: " + producto);
        productScreen.clickOnProduct(producto);
        productScreen.aumentarCantidadProducto(cantidad);
        productScreen.clickAgregarAlCarrito();
        System.out.println("Actividad actual: " +
                AppConfigScreen.getDriver().currentActivity());
    }


    public boolean validarActualizacionCarrito() {
        System.out.println("[ProductSteps] Validando actualización del carrito...");
        return productScreen.isCantidadProductoDisplayed();
    }

    public void regresarPantallaPrincipal() {
        System.out.println("[ProductSteps] Regresando a la pantalla principal...");
        productScreen.btnBack();
    }


}
