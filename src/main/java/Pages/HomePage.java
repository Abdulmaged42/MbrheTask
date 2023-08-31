package Pages;

import base.AppDriver;
import base.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class HomePage {
    private WebDriver driver;
    private By skipLocator = By.xpath("//a[@class='introjs-button introjs-skipbutton' or @text='Skip']");
    private By contactUsLocator = By.xpath("//a[@title='Contact Us']");
    private By bookingLocator = By.xpath("(//a[@href='/Book-Appointment'])");
    private By contactInformationLinkLocator = By.xpath("(//a[@href='/AboutUs/Contact-Us'])[2]");


    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        AppDriver.setDriver(driver);
    }

    public void skipOnboarding() {
        Util.click(skipLocator);
    }

    public void openContactUs() {
        Util.click(contactUsLocator);
    }

    public ContactUs clickOnContactInformation() {
        driver.findElement(contactInformationLinkLocator).click();
        return new ContactUs(driver);
    }


}
