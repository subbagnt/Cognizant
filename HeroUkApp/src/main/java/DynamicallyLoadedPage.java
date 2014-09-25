import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DynamicallyLoadedPage {

    private WebDriver driver;
    WebDriverWait wait ;

    By startButton = By.cssSelector("div#start button");
    By finish = By.id("finish");

    public DynamicallyLoadedPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);

    }

    public DynamicallyLoadedPage clickOnElement1(){
        driver.findElement(By.cssSelector("div#content div.example a")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#start button"))).isDisplayed();
        return this;
    }

    public void clickOnStartButton(){

        driver.findElement(startButton).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(finish)));
    }

    public String getFinishText(){
         return driver.findElement(finish).getText();
    }
}
