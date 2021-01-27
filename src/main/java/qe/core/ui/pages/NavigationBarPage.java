package qe.core.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qe.core.ui.driver.DriverHandler;

public class NavigationBarPage extends DriverHandler {

    private String selectCategoryButton = "//a[text()='CATEGORY']";

    @FindBy(xpath = "//p[text()='PRODUCT']")
    private String selectProduct;

    @FindBy(xpath = "//a[text()='TYPE']")
    private String selectType;

    @FindBy(xpath = "//a[text()='CATEGORY']/parent::div/p")
    private WebElement collapseCategory;

    @FindBy(xpath = "//div[contains(@class,'src-components-MenuFooter-__MenuFooter-module___changeLanguage')]")
    private WebElement changeLanguage;

    @FindBy(xpath = "//span[text()='change country']")
    private WebElement changeCountry;

    @FindBy(xpath = "//span[text()='create an account']")
    private WebElement createAnAccountButton;

    @FindBy(xpath = "//span[text()='sign out']")
    private WebElement signOutButton;

    private By signInButton = By.xpath("//span[text()='sign in']");

    @FindBy(xpath = "//span[contains(text(),'Color Contact Lenses')]")
    private WebElement colorContactLensesLink;

//    public void clickSelectedCategory(String categoryName) {
//        basePage.waitForElementToBeClickable(selectCategoryButton.replace("CATEGORY", categoryName));
//        basePage.click(selectCategoryButton.replace("CATEGORY", categoryName));
//    }
//
//    public void clickCreateAnAccount() {
//        basePage.waitForElementToBeClickable(createAnAccountButton);
//        createAnAccountButton.click();
//    }
//
//    public void clickSignOut() {
//        basePage.waitForElementToBeClickable(signOutButton);
//        signOutButton.click();
//    }
//
    public void clickSignIn() {
        wait(5);
        getDriver().findElement(signInButton).click();
    }
//
//
//    public void clickOnCCLLink() throws Exception {
//        waitForElementToBeVisible(colorContactLensesLink);
//        colorContactLensesLink.click();
//        basePage.wait(5);
//    }
}
