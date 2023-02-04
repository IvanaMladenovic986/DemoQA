package Pages;

import Base.BaseDemoqa;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseDemoqa {
    public ProfilePage(){PageFactory.initElements(driver, this);}

    public @FindBy(className = "text")
    List<WebElement> getButtons;

    public void clickOnButton(String name) {
        for (int i = 0; i < getButtons.size(); i++) {
            if (getButtons.get(i).getText().equals(name)) {
                getButtons.get(i).click();
                break;
            }
        }
    }
}

