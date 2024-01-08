package tests;

import org.testng.annotations.Test;
import pages.*;

import static org.testng.AssertJUnit.*;

public class InsiderTest extends TestBase {
    HomePage homePage = new HomePage();
    CareersPage careersPage = new CareersPage();
    QualityAssurancePage qualityAssurancePage = new QualityAssurancePage();
    OpenPositionsPage openPositionsPage = new OpenPositionsPage();
    String expectedHomePageTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
    String expectedQaPageUrl = "https://useinsider.com/careers/quality-assurance/";
    String expectedLocationName = "Istanbul, Turkey";
    String expectedDepartmentName = "Quality Assurance";
    String expectedLeverUrl = "https://jobs.lever.co/useinsider";

    @Test
    public void insiderTestCase() {
        assertEquals(driver.getTitle(), expectedHomePageTitle);

        homePage.clickToCareerButton();
        assertTrue(careersPage.careersPageHead.isDisplayed());
        assertTrue(careersPage.ourLocation.isDisplayed());
        assertTrue(careersPage.allTeamsBlocks.isDisplayed());
        assertTrue(careersPage.lifeAtInsider.isDisplayed());

        careersPage.clickQAButton();
        assertEquals(expectedQaPageUrl, driver.getCurrentUrl());

        qualityAssurancePage.clickSeeAllQaJobsButton();

        openPositionsPage.selectLocations(expectedLocationName);
        assertEquals(expectedLocationName, openPositionsPage.getLocationName());
        assertEquals(expectedDepartmentName, openPositionsPage.getDepartmentName());

        openPositionsPage.selectRole();

        openPositionsPage.switchToNewTab();
        assertTrue(driver.getCurrentUrl().contains(expectedLeverUrl));
    }
}
