package Tests;

import Base.BaseDemoqa;
import Pages.BookStorePage;
import Pages.HomePage;
import Pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void userCanLogIn() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        String validUsername = excelReader.getStringData("Login", 1, 0);
        bookStorePage.insertUserName(validUsername);
        String validPassword = excelReader.getStringData("Login", 1, 1);
        bookStorePage.insertPassword(validPassword);
        bookStorePage.clickOnLoginButton();
        waitForVisibility(bookStorePage.userNameValue);
        Assert.assertEquals(bookStorePage.userNameValue.getText(),"mia.wallace");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");

    }
    @Test
    public void userCannotLogInWithInvalidUsername() {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        for (int i = 2; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String validPassword = excelReader.getStringData("Login", 1, 1);
            waitForVisibility(bookStorePage.userName);
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
        for (int i = 2; i < excelReader.getLastRow("Login"); i++) {
            String validUserName = excelReader.getStringData("Login", 1, 0);
            //String invalidPassword = excelReader.getStringData("Login", i, 3);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            waitForVisibility(bookStorePage.userName);
            bookStorePage.insertUserName(validUserName);
            waitForVisibility(bookStorePage.password);
            bookStorePage.insertPassword(invalidPassword);
            bookStorePage.clickOnLoginButton();
            //Assert.assertTrue(bookStorePage.loginButton.isDisplayed());
            Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        }
    }
    @Test
    public void userCannotLogInWithInvalidUsernameAndPassword() throws InterruptedException {
        scrollIntoView(homePage.getCards.get(0));
        homePage.clickOnBookstore();
        scrollIntoView(profilePage.getButtons.get(profilePage.getButtons.size() - 1));
        profilePage.clickOnButton("Login");
        for (int i = 2; i < excelReader.getLastRow("Login"); i++) {
            String invalidUsername = excelReader.getStringData("Login", i, 2);
            String invalidPassword = excelReader.getStringData("Login", i, 3);
            waitForVisibility(bookStorePage.userName);
            bookStorePage.insertUserName(invalidUsername);
            bookStorePage.insertPassword(invalidPassword);
            bookStorePage.clickOnLoginButton();
           // Assert.assertFalse(isDisplayed());
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

    /*@AfterMethod
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();*/
    }



