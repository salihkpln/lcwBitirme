package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends HomePage {
    public BasketPage(WebDriver driver) {
        super(driver);
    }
    public WebDriver webDriver = driver;

    @Step("Check Expected and actual result of product name")
    public BasketPage checkProductName(String productTitle) {
        String name = webDriver.findElement(By.xpath("//span[@class='rd-cart-item-title']")).getText();
        String name2 = webDriver.findElement(By.xpath("//span[@class='rd-cart-item-code']")).getText();
        Assertions.assertEquals(name + " " + name2, productTitle);
        System.out.println("Name is correct " + productTitle);

        return this;
    }

    @Step("Check Expected and actual result of color")
    public BasketPage checkColor(String color) {
        By productColor = By.xpath("//strong[normalize-space()='Bej']");
        Assertions.assertEquals(webDriver.findElement(productColor).getText(), color);
        System.out.println("Color is correct " + color);

        return this;
    }

    @Step("Check Expected and actual result of price")
    public BasketPage checkPrice() {
        By priceLeft = By.xpath("//span[@class='rd-cart-item-price mb-15']");
        By priceRight = By.xpath("//div[@class='price-info-area']//span[@class='total-grand-box-amount'][normalize-space()='1.349,99 TL']");
        Assertions.assertEquals(webDriver.findElement(priceLeft).getText(), webDriver.findElement(priceRight).getText());
        System.out.println("Price is correct ");

        return this;
    }

    @Step("Add product to favourites.")
    public BasketPage addToFavourites() throws InterruptedException {
        By addToFavouritesButton = By.xpath("//i[@class='fa fa-heart-o']");
        webDriver.findElement(addToFavouritesButton).click();
        Thread.sleep(2000);

        return this;
    }

    @Step("Click to continue to payment button for payment page.")
    public BasketPage clickContinueToPayment(String productName) throws InterruptedException {
        By continueToPaymentButton = By.xpath("//div[@class='col-md-12 pl-20 pr-20']//a[@class='main-button mt-15'][normalize-space()='ÖDEME ADIMINA GEÇ']");
        webDriver.findElement(continueToPaymentButton).click();
        Thread.sleep(3000);
        goToPaymentPage(webDriver).clickShipmentOption().chooseAddress().choosePaymentMethod().goToFavouritesPage(productName);

        return this;
    }
}
