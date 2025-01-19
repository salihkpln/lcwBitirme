package Base;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BasePage {
    public WebDriver driver;
    public String homeUrl = "https://www.lcw.com";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeAll
    public WebDriver startBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get(homeUrl);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[@id='cookieseal-banner-accept']")).click();

        return driver;
    }
}
