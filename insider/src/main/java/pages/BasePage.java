package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;
import utils.Driver;

import java.util.List;

public class BasePage {



    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



}
