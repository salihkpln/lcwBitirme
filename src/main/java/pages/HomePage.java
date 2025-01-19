package pages;

import Base.BasePage;
import Base.Data;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public WebDriver webDriver;;
    BasePage basePage = new BasePage(driver);
    By loginButton = By.xpath("//span[contains(@class,'user-wrapper')]//span[1]");
    By categoryButton = By.xpath("//a[normalize-space()='ÇOCUK & BEBEK']");
    By subCategory = By.xpath("//span[normalize-space()='KIZ ÇOCUK']");
    By productCategory = By.xpath("//section[contains(@class,'content-tab')]//a[contains(@class,'')][normalize-space()='Mont ve Kaban']");
    By goToBasketButton = By.xpath("//div[contains(text(),'Sepetinize 1 adet ürün eklenmiştir.')]//div//a[normalize-space()='Sepete Git']");

    @Step("Go to login page.")
    public LoginPage goToLoginPage() {
        webDriver = basePage.startBrowser();
        webDriver.findElement(loginButton).click();

        return new LoginPage(webDriver);
    }

    @Step("Go to selected categories page.")
    public CategoryPage goToCategoryPage(WebDriver loginDriver) throws InterruptedException {
        webDriver = loginDriver;
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(categoryButton)).perform();
        Thread.sleep(2000);
        webDriver.findElement(subCategory).click();
        Thread.sleep(2000);
        webDriver.findElement(productCategory).click();
        Thread.sleep(5000);

        return new CategoryPage(webDriver);
    }

    @Step("Go to basket page.")
    public BasketPage goToBasketPage(WebDriver categoryDriver) throws InterruptedException {
        webDriver = categoryDriver;
        webDriver.findElement(goToBasketButton).click();
        Thread.sleep(5000);

        return new BasketPage(webDriver);
    }

    @Step("Go to payment page.")
    public PaymentPage goToPaymentPage(WebDriver basketDriver) throws InterruptedException {
        webDriver = basketDriver;
        Thread.sleep(5000);

        return new PaymentPage(webDriver);
    }
}
