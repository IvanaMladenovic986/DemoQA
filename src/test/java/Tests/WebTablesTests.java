package Tests;

import Base.BaseDemoqa;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class WebTablesTests extends BaseDemoqa {

    public WebTablesTests(){PageFactory.initElements(driver, this);}
}
