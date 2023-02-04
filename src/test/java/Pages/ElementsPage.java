package Pages;

import Base.BaseDemoqa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BaseDemoqa {
    public ElementsPage(){PageFactory.initElements(driver, this);}

     @FindBy (id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement emailAddress;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
   public WebElement permanentAddress;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(id = "created")
    public WebElement createdButton;

    @FindBy(id= "linkResponse")
    public WebElement notification;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement validLink;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    public WebElement radioButtonYes;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/label")
    public WebElement radioButtonImpressive;


    public void insertFullName(String fullname){
        fullName.clear();
        fullName.sendKeys(fullname);
    }

    public void insertEmail(String email){
        emailAddress.clear();
        emailAddress.sendKeys(email);
    }

    public void insertCurrentAddress(String currentaddress){
        currentAddress.clear();
        currentAddress.sendKeys(currentaddress);
    }
    public void insertPermanentAddress(String permanentaddress){
        permanentAddress.clear();
        permanentAddress.sendKeys(permanentaddress);
    }
    public void clickOnSubmitButton(){
        submitButton.click();
    }

    public void clickonLinksHome(){homeLink.click();}
    public void clickOnCreatedButton(){createdButton.click();}

    public void clickOnValidLink(){validLink.click();}

    public void clickOnBrokenLink(){brokenLink.click();
    }

    public void clickOnRadioButtonYes(){ radioButtonYes.click();}

    public void clickOnRadioButtonImpressive(){radioButtonImpressive.click();}
}


