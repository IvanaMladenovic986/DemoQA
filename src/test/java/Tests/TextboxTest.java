package Tests;

import Base.BaseDemoqa;
import Pages.ElementsPage;
import Pages.HomePage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxTest extends BaseDemoqa {

    @BeforeMethod
    public void pageSetUp(){
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        profilePage = new ProfilePage();
        elementsPage = new ElementsPage();
    }
    @Test
    public void test1() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
            homePage.clickOnElements();
    }
    @Test
    public void test2() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size()-1));
        profilePage.clickOnButton("Text Box");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demoqa.com/text-box");
    }
    @Test
    public void textBox(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size()-1));
        profilePage.clickOnButton("Text Box");
        elementsPage.insertFullName("Mia Wallace");
        elementsPage.insertEmail("mia.wallace@gmail.com");
        elementsPage.insertCurrentAddress("Hollywood, LA, CA");
        elementsPage.insertPermanentAddress("Los Angeles, CA");
        elementsPage.clickOnSubmitButton();
        Assert.assertEquals(elementsPage.getName(), "Name:Mia Wallace");
    }
    @Test
    public void radioButtonYes(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size()-1));
        profilePage.clickOnButton("Radio Button");
        elementsPage.clickOnRadioButtonYes();
        Assert.assertEquals(elementsPage.getmessageTextYes(), "You have selected Yes");

    }
    @Test
    public void radioButtonImpressive(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size()-1));
        profilePage.clickOnButton("Radio Button");
        elementsPage.clickOnRadioButtonImpressive();
        Assert.assertEquals(elementsPage.getmessageTextImpressive(), "You have selected Impressive");
    }
    @Test
    public void radioButtonNo(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnElements();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size()-1));
        profilePage.clickOnButton("Radio Button");
        elementsPage.clickOnRadioButtonNo();
    }
}
