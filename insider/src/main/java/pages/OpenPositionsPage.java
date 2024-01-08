package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.Driver;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class OpenPositionsPage extends BasePage {

    @FindBy(id = "filter-by-location")
    public WebElement locationDropdown;

    @FindBy(id = "filter-by-department")
    public WebElement departmentDropdown;

    @FindBy(xpath = "//*[text()='View Role']")
    public List<WebElement> viewRoleButtons;

    @FindBy(xpath = "//*[@data-team='qualityassurance']")
    public List<WebElement> qualityAssuranceRole;

    public void selectLocations(String location) {
        Select select = new Select(locationDropdown);
        select.selectByVisibleText(location);
    }

    public String getLocationName() {
        Select select = new Select(locationDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getDepartmentName() {
        Select select = new Select(departmentDropdown);
        return select.getFirstSelectedOption().getText();
    }

    public void selectRole() {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        BrowserUtils.scrollToElement(qualityAssuranceRole.get(randomNumber));
        BrowserUtils.clickWithJS(viewRoleButtons.get(randomNumber));
    }

    public void switchToNewTab() {
        Set<String> windowHandles = Driver.get().getWindowHandles();
        Driver.get().switchTo().window(windowHandles.toArray()[1].toString());
    }


}
