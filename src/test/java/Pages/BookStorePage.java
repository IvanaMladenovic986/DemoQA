package Pages;

import Base.BaseDemoqa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookStorePage extends BaseDemoqa {
    public BookStorePage(){PageFactory.initElements(driver, this);}

    public @FindBy(className = "text")
    List<WebElement> getButtons;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(id = "firstname")
    public WebElement firstName;

    @FindBy(id = "lastname")
    public WebElement lastName;

    @FindBy(id = "userName")
    public WebElement userName;

    @FindBy(id= "password")
    public WebElement password;
    @FindBy(id = "recaptcha-anchor-label")
    public WebElement recaptcha;
    @FindBy(id = "register")
    public WebElement registerButton;
    @FindBy(id = "login")
    public WebElement loginButton;
    @FindBy(css = "btn.btn-primary")
    public WebElement logOutButton;

    public void clickOnLogOutButton(){logOutButton.click();}

    public void clickOnLoginButton(){loginButton.click();}

    public void insertFirstName(String firstname){
        firstName.clear();
        firstName.sendKeys(firstname);
    }

    public void insertLastName(String lastname){
        lastName.clear();
        lastName.sendKeys(lastname);
    }
    public void insertUserName(String username){
     userName.clear();
     userName.sendKeys(username);
    }
    public void insertPassword(String passWord){
        password.clear();
        password.sendKeys(passWord);
    }


    public void clickOnNewUser(){newUserButton.click();}

    public void clickOnButton(String name) {
        for (int i = 0; i < getButtons.size(); i++) {
            if (getButtons.get(i).getText().equals(name)) {
                getButtons.get(i).click();
                break;
            }
        }
    }
}
