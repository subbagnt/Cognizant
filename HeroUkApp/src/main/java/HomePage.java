import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

      private WebDriver driver;
       WebDriverWait wait;

        public HomePage(WebDriver driver){
            this.driver = driver;
            wait = new WebDriverWait(driver,20);

        }

        public  HomePage goToPage(String url){
            driver.get(url);
            if(!driver.getTitle().equals("The Internet")){
                throw new IllegalStateException("Incorrect page in place. Page displayed is:"+driver.getCurrentUrl());
            }
            return this;
        }

        public DynamicallyLoadedPage clickOnTextLink(String link){
            driver.findElement(By.linkText(link)).click();
              return new DynamicallyLoadedPage(driver);
        }

}
