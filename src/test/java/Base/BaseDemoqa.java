package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseDemoqa {
    public  static WebDriver driver;
    public  WebDriverWait wdwait;
    public ExcelReader excelReader;
    public HomePage homePage;
    public ProfilePage profilePage;
    public ElementsPage elementsPage;
    public BookStorePage bookStorePage;
    public ButtonsPage buttonsPage;

    public String homeURL;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        excelReader = new ExcelReader("src/test/java/DemoQA.xlsx");
        homeURL = excelReader.getStringData("URL",0,0);

    }
    public void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public void waitForVisibility(WebElement element){
        wdwait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForClickability(WebElement element){
        wdwait.until(ExpectedConditions.elementToBeClickable(element));
    }

}

