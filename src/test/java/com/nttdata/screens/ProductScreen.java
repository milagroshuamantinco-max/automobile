package com.nttdata.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.nttdata.screens.AppConfigScreen.getDriver;

public class ProductScreen {

    private static final Duration TIMEOUT = Duration.ofSeconds(20);

    private final By productTitle =
            AppiumBy.xpath("//android.widget.TextView[@resource-id='com.saucelabs.mydemoapp.android:id/productTV']");

    private final By cantidadProducto =
            AppiumBy.xpath("//android.widget.ImageView[@content-desc='Increase item quantity']");

    private final By btnAgregarAlCarrito =
            AppiumBy.xpath("//android.widget.Button[@content-desc='Tap to add product to cart']");

    private final By cantidaCarrito =
            AppiumBy.xpath("//android.widget.RelativeLayout[@content-desc='Displays number of items in your cart']/android.widget.ImageView");

    public boolean isProductTitleDisplayed() {
        AndroidDriver driver = getDriver();
        return driver.findElement(productTitle).isDisplayed();
    }

    public void clickOnProduct(String name) {
        AndroidDriver driver = getDriver();
        By productLocator = By.xpath(String.format("//android.widget.ImageView[@content-desc='%s']", name));
        //android.widget.ImageView[@content-desc="Sauce Labs Bike Light"]
        driver.findElement(productLocator).click();
    }

    public void aumentarCantidadProducto(int cantidad) {
        AndroidDriver driver = getDriver();

        int veces = cantidad - 1;

        for (int i = 0; i < veces; i++) {
            driver.findElement(cantidadProducto).click();
        }
    }

    public void clickAgregarAlCarrito() {
        AndroidDriver driver = getDriver();
        driver.findElement(btnAgregarAlCarrito).click();
    }

    public boolean isCantidadProductoDisplayed() {
        AndroidDriver driver = getDriver();
        return driver.findElement(cantidaCarrito).isDisplayed();
    }
    public void btnBack() {
        AndroidDriver driver = getDriver();
        driver.navigate().back();
    }


}
