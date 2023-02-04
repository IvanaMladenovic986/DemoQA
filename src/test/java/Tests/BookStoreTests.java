package Tests;

import Base.BaseDemoqa;
import Pages.BookStorePage;
import Pages.HomePage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.transform.sax.SAXResult;

public class BookStoreTests extends BaseDemoqa {

    @BeforeMethod
    public void SetUp() {
        driver.manage().window().maximize();
        driver.get(homeURL);
        homePage = new HomePage();
        profilePage = new ProfilePage();
        bookStorePage = new BookStorePage();
    }
    @Test
    public void addNewUser() {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
//        profilePage.clickOnButton("Login");
//        bookStorePage.clickOnNewUser();
//        Assert.assertTrue(bookStorePage.registerButton.isDisplayed());
    }
    @Test
    public void userCanLogIn() {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        String validUsername = excelReader.getStringData("Login", 1, 0);
        bookStorePage.insertUserName(validUsername);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");

    }
    @Test
    public void userCannotLogInWithInvalidUsername() {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            bookStorePage.insertUserName(invalidUsername);
            bookStorePage.insertPassword(validPassword);
            bookStorePage.clickOnLoginButton();
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        }
    }
    @Test
    public void userCannotLogInWithInvalidPassword() {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String validUserName = excelReader.getStringData("Login", 1, 0);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            bookStorePage.insertUserName(validUserName);
            bookStorePage.insertPassword(invalidPassword);
            bookStorePage.clickOnLoginButton();
           // Assert.assertTrue(bookStorePage.loginButton.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        }
    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        for (int i = 1; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            Thread.sleep(2);
            bookStorePage.insertUserName(invalidUsername);
            bookStorePage.insertPassword(invalidPassword);
            bookStorePage.clickOnLoginButton();
            Assert.assertFalse(isDisplayed(bookStorePage.logOutButton));
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        }
    }
    @Test
    public  void userCannotLoginWithEmptyUsername(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        String emptyUsername = "";
        String validPassword = excelReader.getStringData("Login", 1, 1);
        bookStorePage.insertUserName(emptyUsername);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        Assert.assertTrue(bookStorePage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }
    @Test
    public void userCannotLoginWithEmptyPassword(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        String validUsername = excelReader.getStringData("Login", 0,1);
        String emptyPassword = "";
        bookStorePage.insertUserName(validUsername);
        bookStorePage.insertPassword(emptyPassword);
        bookStorePage.clickOnLoginButton();
        Assert.assertTrue(bookStorePage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }
    @Test
    public void userCannotLoginWithEmptyUsernameAndPassword(){
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        String emptyUsername = "";
        String emptyPassword ="";
        bookStorePage.insertUserName(emptyUsername);
        bookStorePage.insertPassword(emptyPassword);
        bookStorePage.clickOnLoginButton();
        Assert.assertTrue(bookStorePage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
    }
}


