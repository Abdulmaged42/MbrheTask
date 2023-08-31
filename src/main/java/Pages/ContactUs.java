package Pages;

import base.AppDriver;
import base.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class ContactUs {
    private WebDriver driver;
    private By nameLocator = By.xpath("//input[@id='feedId']");
    private By phoneNumberLocator = By.xpath("//input[@id='feedMobile']");
    private By subjectLocator = By.xpath("//input[@name='feedbacksubjectc']");
    private By emailLocator = By.xpath("//input[@id='feedEmail']");
    private By csCallingDropDown = By.xpath("//select[@id='feedCall']");
    private By categoryDropDown = By.xpath("//select[@id='feedReason']");
    private By typeDropDown = By.xpath("//select[@id='feedType']");
    private By messageLocator = By.xpath("//textarea[@id='feedComment']");
    private By submitLocator = By.xpath("(//*[@value='Submit'])[2]");
    private By errorMessageLocator = By.cssSelector("#captchaerrorContact");
    private By formLocator = By.cssSelector("#ContactUs");


    public ContactUs(WebDriver webDriver) {
        this.driver = webDriver;
        AppDriver.setDriver(driver);
    }

    public void setName(String name) {
        Util.scrollToSection(nameLocator);
        Util.sendKeys(nameLocator, name);
    }

    public void setPhoneNumber(String number) {
        Util.sendKeys(phoneNumberLocator, number);
    }

    public void setSubject(String subject) {
        Util.sendKeys(subjectLocator, subject);
    }

    public void setEmail(String mail) {
        Util.sendKeys(emailLocator, mail);
    }

    public void selectFromDropDown(String option, String menu) {
        findDropDownElement(menu).selectByVisibleText(option);
    }

    private Select findDropDownElement(String menu) {
        if (menu == "csCalling") {
            return new Select(driver.findElement(csCallingDropDown));
        } else if (menu == "category") {
            return new Select(driver.findElement(categoryDropDown));
        } else {
            return new Select(driver.findElement(typeDropDown));
        }

    }

    public void setMessage(String message) {
        Util.sendKeys(messageLocator, message);
    }

    public void submit() {
        WebElement element = driver.findElement(submitLocator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public String getErrorMessage() {
        Util.scrollToSection(errorMessageLocator);
        return driver.findElement(errorMessageLocator).getText();
    }

    public boolean ErrorMessageVerification() {
        Util.waitForEl(errorMessageLocator);
        return driver.findElement(errorMessageLocator).isDisplayed();
    }

    public void takeScreenShotForRecaptchaError() throws IOException {
        Util.screenShotForAnElement(errorMessageLocator, "error message");
    }

    public void takeScreenShotForForm() throws IOException {
        Util.screenShotForAnElement(formLocator, "form");
    }
    public void takeFullScreenShot() throws IOException {
        Util.screenShotForFullPage();
    }
}

