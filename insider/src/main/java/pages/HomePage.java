package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(), 'Company')]")
    public WebElement companyButton;

    @FindBy(xpath = "//*[text()='Careers']")
    public WebElement careersButton;

    @FindBy(id = "wt-cli-accept-all-btn")
    public WebElement acceptCookieButton;

    public void clickToCareerButton() {
        BrowserUtils.waitForClickability(acceptCookieButton);
        acceptCookieButton.click();
        companyButton.click();
        careersButton.click();
    }
}
