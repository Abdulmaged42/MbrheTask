package base;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Util {

    public static void scrollToSection(By section) {
        JavascriptExecutor js = (JavascriptExecutor) AppDriver.getDriver();
        WebElement element = AppDriver.getDriver().findElement(section);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public static void click(By byEl) {
        waitForEl(byEl);
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byEl)).click();
    }

    public static void sendKeys(By byEl, String text) {
        waitForEl(byEl);
        AppDriver.getDriver().findElement(byEl).sendKeys(text);
    }

    public static void waitForEl(By byEl) {
        new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(byEl));
    }

    public static void screenShotForAnElement(By locator,String imgName) throws IOException {
        waitForEl(locator);
        WebElement element = AppDriver.getDriver().findElement(locator);
        File source = element.getScreenshotAs(OutputType.FILE);

        File destination = new File(imgName+".png");
        FileHandler.copy(source, destination);
    }
    public static void screenShotForFullPage() throws IOException {

        File file =((FirefoxDriver) AppDriver.getDriver()).getFullPageScreenshotAs(OutputType.FILE);

        FileHandler.copy(file, new File("full page.png"));
    }
}
