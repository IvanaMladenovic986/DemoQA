package Pages;

import Base.BaseDemoqa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BaseDemoqa {
    public WebTablesPage(){PageFactory.initElements(driver, this);}

    @FindBy(id = "addNewRecordButton")
    public WebElement addNewButton;


    public void clickOnAddNew(){addNewButton.click();}
}
