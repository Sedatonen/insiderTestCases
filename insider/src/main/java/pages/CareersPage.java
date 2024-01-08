package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class CareersPage extends BasePage {

    @FindBy(id = "page-head")
    public WebElement careersPageHead;

    @FindBy(xpath = "//*[text()='See all teams']")
    public WebElement seeAllTeamsButton;

    @FindBy(id = "career-find-our-calling")
    public WebElement allTeamsBlocks;

    @FindBy(id = "career-our-location")
    public WebElement ourLocation;

    @FindBy(xpath = "//*[text()='Life at Insider']")
    public WebElement lifeAtInsider;

    @FindBy(xpath = "//*[text()='Quality Assurance']")
    public WebElement qualityAssuranceButton;

    public void clickQAButton() {

        BrowserUtils.clickWithJS(seeAllTeamsButton);
        BrowserUtils.clickWithJS(qualityAssuranceButton);
    }
}
