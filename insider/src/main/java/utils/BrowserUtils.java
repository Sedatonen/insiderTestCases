package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {
   static Actions action = new Actions(Driver.get());

    public static void waitForClickability(WebElement element) {

        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void scrollToElement(WebElement element) {

        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView({ block: 'center' });", element);
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }
}
