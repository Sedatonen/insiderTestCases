package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigurationReader;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;


public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String url = ConfigurationReader.get("base_url");
        driver.get(url);
        driver.manage().deleteAllCookies();

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String targetDirectory = "target/screenshots/";
            File targetFile = new File(targetDirectory + iTestResult.getName() + ".png");
            Files.createDirectories(targetFile.getParentFile().toPath());
            Files.move(screenshotFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Ekran görüntüsü kaydedildi: " + targetFile.getAbsolutePath());
        }
        Driver.get().quit();
    }
}
