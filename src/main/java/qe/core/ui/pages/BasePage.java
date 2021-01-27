package qe.core.ui.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage {

    private By insiderDiscountArrow = By.xpath("//div[contains(@class,\"ins-side-menu-arrow\")]");
    private By wheelOfFortuneCloseButton = By.xpath("//div[@id='ins-wheel-of-fortune-adaptive']/div/div/span");
    private By insiderWithViewBlocks = By.xpath("//div[(contains(@classname,'ins') or contains(@id,'ins')) and contains(@style,'display: block')]");
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver1, WebDriverWait wait1) {
        this.driver = driver1;
        this.wait = wait1;
    }

    public void waitForElementToBeVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementToBeVisible(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ignored) {

        }
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        try{
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e){
//            closeLiveInsideDiscountIfDisplayed();
//            closeWheelOfFortuneIfDisplayed();
        }

    }

    public void waitForElementToBeSelected(WebElement element) {
        wait.until(ExpectedConditions.elementSelectionStateToBe(element, true));
    }

    public void waitForElementToBeRefreshed(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForElementToBeRefreshed(By by) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeClickable(String elementXpath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
    }

    public WebElement waitForPresenceOfElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfAllElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public boolean waitForTextToBePresentInElement(By by, String text) {
        try {
            if (wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text)))
                return true;
        } catch (TimeoutException e) {
            return false;
        }
        return false;
    }

    public boolean waitForTextToBeNonEmpty(final By by) {
        (new WebDriverWait(driver, 30)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(by).getText().length() != 0;
            }
        });
        return false;
    }

    public void waitForInvisibilityOfElementByText(By by, String text) {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
    }

    public void waitForElementToBeInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitForElementToBeInvisible(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementToBeChecked(WebElement element) {
        wait.until(elementToBeChecked(element));
    }

    public boolean isWebElementDisplayed(WebElement element) {
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    private static ExpectedCondition<WebElement> elementToBeChecked(
            final WebElement element) {
        return new ExpectedCondition<WebElement>() {

            public ExpectedCondition<WebElement> visibilityOfElement =
                    ExpectedConditions.visibilityOf(element);

            @Override
            public WebElement apply(WebDriver driver) {
                WebElement element = visibilityOfElement.apply(driver);
                try {
                    if (element != null && element.getAttribute("checked").equals("true")) {
                        return element;
                    } else {
                        return null;
                    }
                } catch (StaleElementReferenceException e) {
                    return null;
                }
            }

            @Override
            public String toString() {
                return "element to be checked : " + element;
            }
        };
    }

    public void scrollTo(WebElement element) {
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTrue(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }



    public void scrollTillBottom(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, (document.body.scrollHeight)/2)");
        wait(3);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void click(String elementXpath){
        driver.findElement(By.xpath(elementXpath)).click();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void wait(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForPageToLoad(){
        String state = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
        int count = 0;

        while (!state.equalsIgnoreCase("complete")){
            try {
                Thread.sleep(3000);
                state = (String) ((JavascriptExecutor) driver).executeScript("return document.readyState");
                count++;
                if (count == 10)
                    return;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String generateRandomString(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 9) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String randomString = salt.toString();
        return randomString;
    }

//    public void moveToElement(WebElement element) {
//        actions.moveToElement(element).build().perform();
//    }

    public boolean isDisplayed(By by){
        return driver.findElement(by).isDisplayed();
    }
    public void click(By by){
        driver.findElement(by).click();
    }

    public void closeLiveInsideDiscountIfDisplayed() {
        try {
            if (isDisplayed(insiderDiscountArrow)){
                click(insiderDiscountArrow);
            }
        }
        catch (Exception ignored){}
    }

    public void closeWheelOfFortuneIfDisplayed() {
        try {
            if (isDisplayed(wheelOfFortuneCloseButton)){
                click(wheelOfFortuneCloseButton);
            }
        }
        catch (Exception ignored){}
    }
    public void setUnBlock(){
        List<WebElement> list = driver.findElements(insiderWithViewBlocks);
        for (WebElement e : list){
            ((JavascriptExecutor) driver).executeScript("arguments[0].display=none;", e);
        }
    }
}
