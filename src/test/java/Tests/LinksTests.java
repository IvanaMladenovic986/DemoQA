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
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://demoqa.com/");
       // Assert.assertEquals(homeURL,"https://demoqa.com/");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void linksCreatedButton() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnCreatedButton();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 201 and status text Created");
    }
    @Test
    public void linksNoContent() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnNoContentLink();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(),"Link has responded with staus 204 and status text No Content");}

    @Test
    public void linksMoved() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnMovedLink();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 301 and status text Moved Permanently");
    }
    @Test
    public void linksBadRequest() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnBadRequestlink();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 400 and status text Bad Request");
    }
    @Test
    public void linksUnauthorized() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnUnauthorizedLink();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 401 and status text Unauthorized");
    }
    @Test
    public void linksForbidden() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnForbiddenLink();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 403 and status text Forbidden");
    }
    @Test
    public void linksNotFound() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Links");
        elementsPage.clickOnNotFound();
        waitForVisibility(elementsPage.linkNotification);
        Assert.assertEquals(elementsPage.getLinkNotification(), "Link has responded with staus 404 and status text Not Found");
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





