package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QualityAssurancePage extends BasePage{

    @FindBy(xpath = "//*[text()='See all QA jobs']")
    public WebElement seeAllJobsButton;

    public void clickSeeAllQaJobsButton(){
        seeAllJobsButton.click();
    }
}

