package Tests;

import Base.BaseDemoqa;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinksTests extends BaseDemoqa {
    @BeforeMethod
    public void pageSetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        profilePage = new ProfilePage();
        elementsPage = new ElementsPage();
    }

    @Test
    public void testCheckBox() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Check Box");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/checkbox");
    }

    @Test
    public void linksHomeButton() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickonLinksHome();
       //Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void linksCreatedButton() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnCreatedButton();
    }

    @Test
    public void brokenLinksValid() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        scrollIntoView(profilePage.getButtons.get(6));
        profilePage.clickOnButton("Broken Links - Images");
        elementsPage.clickOnValidLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void brokenLinksBroken() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        scrollIntoView(profilePage.getButtons.get(6));
        profilePage.clickOnButton("Broken Links - Images");
        elementsPage.clickOnBrokenLink();
        Assert.assertEquals(driver.getCurrentUrl(), "http://the-internet.herokuapp.com/status_codes/500");
    }
}





