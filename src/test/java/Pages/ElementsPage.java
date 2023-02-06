package Pages;

import Base.BaseDemoqa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BaseDemoqa {
    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullName;

    @FindBy(id = "userEmail")
    public WebElement emailAddress;

    @FindBy(id = "currentAddress")
    public WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddress;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(id = "created")
    public WebElement createdButton;

    @FindBy(id = "no-content")
    public WebElement noContentLink;

    @FindBy(id = "moved")
    public WebElement movedLink;

    @FindBy(id = "bad-request")
    public WebElement badRequestLink;

    @FindBy(id = "unauthorized")
    public WebElement unauthorizedLink;

    @FindBy(id = "forbidden")
    public WebElement forbiddenLink;

    @FindBy(id = "invalid-url")
    public WebElement notFoundLink;

    @FindBy(linkText = "Click Here for Valid Link")
    public WebElement validLink;

    @FindBy(linkText = "Click Here for Broken Link")
    public WebElement brokenLink;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/label")
    public WebElement radioButtonYes;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/label")
    public WebElement radioButtonImpressive;

    @FindBy(css = "custom-control-label.disabled")
    public WebElement radioButtonNo;

    @FindBy(className = "mt-3")
    public WebElement messageYes;

    @FindBy(className = "mt-3")
    public WebElement messageImpressive;

    @FindBy(id = "linkResponse")
    public WebElement linkNotification;

    public String getLinkNotification(){return linkNotification.getText();}

    public String getName(){ return name.getText();}
    public void clickOnRadioButtonNo(){radioButtonNo.click();}

    public String getmessageTextYes(){return messageYes.getText();}
    public String getmessageTextImpressive(){return messageImpressive.getText();}

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
    public void clickOnNoContentLink(){noContentLink.click();}

    public void clickOnMovedLink(){movedLink.click();}
    public void clickOnBadRequestlink(){badRequestLink.click();}
    public void clickOnUnauthorizedLink(){unauthorizedLink.click();}
    public void clickOnForbiddenLink(){forbiddenLink.click();}
    public void clickOnNotFound(){notFoundLink.click();}

    public void clickOnValidLink(){validLink.click();}

    public void clickOnBrokenLink(){brokenLink.click();
    }

    public void clickOnRadioButtonYes(){ radioButtonYes.click();}

    public void clickOnRadioButtonImpressive(){radioButtonImpressive.click();}
}


