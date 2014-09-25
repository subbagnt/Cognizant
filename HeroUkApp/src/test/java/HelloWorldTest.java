import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class HelloWorldTest {

    private WebDriver driver;
    private String  testSite = "http://the-internet.herokuapp.com/";
    private HomePage homePage;
    private DynamicallyLoadedPage dynamicallyLoadedPage;
    String actualText;

    @BeforeClass
      public void setUp(){
           driver = new FirefoxDriver();
          homePage = new HomePage(driver);
          homePage.goToPage(testSite);
          dynamicallyLoadedPage = homePage.clickOnTextLink("Dynamic Loading");

          dynamicallyLoadedPage.clickOnElement1();
          dynamicallyLoadedPage.clickOnStartButton();
        actualText = dynamicallyLoadedPage.getFinishText();

      }

    @Test
    public void  testHelloWorld(){
        assertEquals("Hello World!",actualText);
    }
@AfterTest
    public void quit(){
    driver.quit();
}


}
