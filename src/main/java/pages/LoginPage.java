package pages;

import Base.Data;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends HomePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    Data data = new Data();
    public WebDriver webDriver = driver;

    By userNameField = By.xpath("//input[@placeholder='E-posta Adresi veya Telefon Numarası']");
    By continueButton = By.xpath("//button[normalize-space()='Devam Et']");
    By passwordField = By.xpath("//input[@placeholder='Şifreniz']");
    By loginButton = By.xpath("//button[@type='submit']");

    @Description("Fill the text area with valid user name.")
    @Step("Fill the email/username text area.")
    public LoginPage fillEmailTextArea() {
        webDriver.findElement(userNameField).sendKeys(data.userName);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return this;
    }

    @Description("Click continue button to reach password text area.")
    @Step("Click the continue button.")
    public LoginPage clickContinueButton() {
        webDriver.findElement(continueButton).click();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return this;
    }

    @Description("Fill the text area with valid password.")
    @Step("Fill the password text area.")
    public LoginPage fillPasswordTextArea() {
        webDriver.findElement(passwordField).sendKeys(data.password);
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return this;
    }

    @Description("Click login button for successful login process.")
    @Step("Click the login button.")
    public LoginPage clickLoginButton() throws InterruptedException {
        webDriver.findElement(loginButton).click();
        Thread.sleep(30000);
        goToCategoryPage(webDriver)
                .filterSize()
                .filterColor()
                .sortBestSellers()
                .selectProduct()
                .addToBasket();

        return this;
    }
}
