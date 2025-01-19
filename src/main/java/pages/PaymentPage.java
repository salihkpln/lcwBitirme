package pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends HomePage{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public WebDriver webDriver = driver;
    By shipmentOption = By.xpath("//div[contains(text(),'Adrese Teslimat')]");
    By addressOption = By.xpath("//div[@class='SelectableButton addressContainer ActiveButton']");
    By paymentMethod = By.xpath("//label[@for='PaymentButtonRadio_PaymentCardMasterpassView']");

    @Step("Choose shipment option")
    public PaymentPage clickShipmentOption() throws InterruptedException {
        webDriver.findElement(shipmentOption).click();
        Thread.sleep(3000);

        return this;
    }

    @Step("Choose address")
    public PaymentPage chooseAddress() throws InterruptedException {
        webDriver.findElement(addressOption).click();
        Thread.sleep(3000);

        return this;
    }


    @Step("Choose payment method.")
    public PaymentPage choosePaymentMethod() throws InterruptedException {
        webDriver.findElement(paymentMethod).click();
        Thread.sleep(3000);

        return this;
    }

    @Step("Go to favourites page and check the name.")
    public PaymentPage goToFavouritesPage(String productName) throws InterruptedException {
        webDriver.navigate().to("https://www.lcw.com/favorilerim");
        Thread.sleep(3000);
        String name = webDriver.findElement(By.xpath("//h5[contains(text(),'Kapüşonlu Kız Çocuk Kaban')]")).getText();
        Assertions.assertEquals(name, productName);

        return this;
    }
}
