package qe.core.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qe.core.ui.driver.DriverHandler;

public class HomePage extends DriverHandler {

    private By openNavigationBar = By.xpath("//img[@alt='Open Menu']");

//    @FindBy(xpath = "//div[@class='src-components-Header-__Header-module___logo']")
//    private WebElement headerLogo;
//
//    @FindBy(xpath = "//span[contains(text(),'Sunglasses')]")
//    private WebElement sunglassesLink;
//
//    @FindBy(xpath = "//a[contains(@href,'https://uat.eyewa.com/ae-en/glasses.html')]//span[contains(text(),'Glasses')]")
//    private WebElement glassesLink;
//
//    @FindBy(xpath = "//a[contains(@href,'https://uat.eyewa.com/ae-en/blue-light-glasses.html')]")
//    private WebElement blueLighGlassesLink;
//
//    @FindBy(xpath = "//span[contains(text(),'Corrective Contact Lenses')]")
//    private WebElement correctiveContactLensesLink;
//
//    @FindBy(xpath = "//a[contains(text(),'Color Contact Lenses')]")
//    private WebElement colorContactLensesLink;
//
//    @FindBy(xpath = "//span[contains(text(),'Clearance')]")
//    private WebElement clearanceLink;
//
//    @FindBy(xpath = "//div[contains(@class,'dropdown-menu')]//a[contains(text(),'My Account')]")
//    private WebElement myAccountLink;
//
//    @FindBy(xpath = "//div[contains(@class,'dropdown-menu')]//a[contains(text(),'Sign Out')]")
//    private WebElement signOutLink;
//
//    @FindAll({@FindBy(xpath = "//ol[contains(@class,'products list items product-items row row-col-lg-3')]//li")})
//    private List<WebElement> productsList;
//
//    @FindBy(xpath = "//input[@name='firstname']")
//    private WebElement firstName;
//
//    @FindBy(xpath = "//input[@name='lastname']")
//    private WebElement lastName;
//
//    @FindBy(xpath = "//input[@name='street[0]']")
//    private WebElement address;
//
//    @FindBy(xpath = "//input[@name='city']")
//    private WebElement city;
//
//    @FindBy(xpath = "//input[@name='telephone']")
//    private WebElement mobileNumber;
//
//    @FindBy(xpath = "//*[@id='shipping-method-buttons-container']/div/button")
//    private WebElement nextButton;
//
//    @FindBy(id = "msp_cashondelivery")
//    private WebElement cashOnDeliveryLink;
//
//    @FindBy(xpath = "//*[@id=\"checkout-payment-method-load\"]/div/div/div[3]/div[2]/div[4]/div/button/span")
//    private WebElement placeOrderButton;
//
//    @FindBy(xpath = "//h1[contains(text(),'Thank you !')]")
//    private WebElement thankYouText;

    public void navigateTo(String url) {
        getDriver().navigate().to(url);
        wait(5);
    }

    public void clickOnNavigationPane() {
        getDriver().findElement(openNavigationBar).click();
        wait(5);
    }
}
