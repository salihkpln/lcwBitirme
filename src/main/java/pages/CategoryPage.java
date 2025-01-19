package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;

public class CategoryPage extends HomePage {
    public CategoryPage(WebDriver driver) {
        super(driver);
    }
    public WebDriver webDriver = driver;
    By size1 = By.xpath("//span[contains(text(),'5-6 Yaş')]");
    By size2 = By.xpath("//body/div[@id='root']/div[@class='page-wrapper']/div[@class='product-list-container']/div[@class='product-list']/div[@class='container-fluid']/div[@class='product-list__content-area']/div[@class='desktop-filter-area desktop-filter-area--fixed']/div[@class='desktop-filter-area__content']/div[@class='filter']/div[@class='collapsible-filter-container']/div[@class='collapsible-filter-container__body']/div[@class='collapsible-filter-container__content-area collapsible-filter-container__content-area--size-filter']/div[3]/span[1]");
    By size3 = By.xpath("//span[contains(text(),'6-7 Yaş')]");
    By color = By.xpath("//span[normalize-space()='BEJ']");
    By sortButton = By.xpath("//button[@class='dropdown-button__button']");
    By bestSellersOption = By.xpath("//a[normalize-space()='En çok satanlar']");
    By selectProduct = By.xpath("//a[@title='Kapüşonlu Kız Çocuk Kaban']//h5[@class='product-card__brand-title'][normalize-space()='LCW Kids']");
    By availableStockOption = By.xpath("//button[contains(text(),'5-6 Yaş')]");
    By addToBasketButton = By.xpath("//button[normalize-space()='SEPETE EKLE']");

    @Step("Filter products with [5-6], [6] and [6-7] year options.")
    public CategoryPage filterSize() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        executor.executeScript("window.scrollBy(0,1350)");
        webDriver.findElement(size1).click();
        Thread.sleep(5000);
        webDriver.findElement(size2).click();
        Thread.sleep(5000);
        webDriver.findElement(size3).click();
        Thread.sleep(5000);

        return this;
    }

    @Step("Filter color to beige.")
    public CategoryPage filterColor() throws InterruptedException {
        JavascriptExecutor executor = (JavascriptExecutor) webDriver;
        webDriver.findElement(color).click();
        Thread.sleep(5000);
        executor.executeScript("window.scrollTo(0,0)");

        return this;
    }

    @Step("Sort the products as best sellers")
    public CategoryPage sortBestSellers() throws InterruptedException {
        webDriver.findElement(sortButton).click();
        webDriver.findElement(bestSellersOption).click();
        Thread.sleep(5000);
        return this;
    }

    @Step("Select the 4th product")
    public CategoryPage selectProduct() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        webDriver.findElement(selectProduct).click();
        Thread.sleep(5000);
        js.executeScript("document.querySelector('.evam-first-screenControl').style.display = 'none';");
        Thread.sleep(5000);

        return this;
    }

    @Step("Add product to basket.")
    public CategoryPage addToBasket() throws InterruptedException {
        webDriver.findElement(availableStockOption).click();
        Thread.sleep(5000);
        webDriver.findElement(addToBasketButton).click();
        Thread.sleep(2000);
        String productTitle = webDriver.findElement(By.xpath("//div[contains(@class,'drop-down-menu drop-down-menu--cart-menu drop-down-menu--active')]//h2[contains(@class,'cart-item__details__title')][normalize-space()='LC Waikiki Kaban']")).getText();
        String productName = webDriver.findElement(By.xpath("//a[contains(text(),'Bej Kapüşonlu Kız Çocuk Kaban')]")).getText();
        String color = webDriver.findElement(By.xpath("//label[normalize-space()='Bej']")).getText();
        goToBasketPage(webDriver)
                .checkProductName(productTitle).checkColor(color).checkPrice().addToFavourites().clickContinueToPayment(productName);
        Thread.sleep(5000);

        return this;
    }
}
