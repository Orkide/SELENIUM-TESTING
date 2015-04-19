
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.FacebookHomePage;
import PageObject.FacebookLoginPage;
import PageObject.FacebookLogoutPage;

public class FacebookTest {
	
  private WebDriver driver;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {	  
    driver = new FirefoxDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Dimension d = new Dimension(1630,1000);
    driver.manage().window().setSize(d);
  }

   @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

   
   @Test
   public void testFacebookLogin() throws Exception {   
	   
	   FacebookLoginPage facebookLoginPage = FacebookLoginPage.load(driver);
	   facebookLoginPage = facebookLoginPage.enterUserName("orkide.tokyay@gmail.com").enterPassword("2137577");
	   facebookLoginPage.submitLogin();	  
	   
	   
	   // Anticipate web browser response, with an explicit wait
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='blueBarNAXAnchor']/div[1]/div/div/div[1]/ul/li[1]/a/span")));

	    // Run a test
	    String message = messageElement.getText();
	    Assert.assertEquals(message, "Ecrin");
	    // Conclude a test
	    driver.quit(); 			     
   }
   
   @Test
   public void testFacebookLogout() throws Exception {   
	   
	   FacebookLoginPage facebookLoginPage = FacebookLoginPage.load(driver);
	   facebookLoginPage = facebookLoginPage.enterUserName("orkide.tokyay@gmail.com").enterPassword("2137577");
	   FacebookHomePage facebookHomePage = facebookLoginPage.submitLogin();	 
	   facebookHomePage.clickArrow().submitLogout();
	   Thread.sleep(1000);

	   FacebookLogoutPage facebookLogoutPage = FacebookLogoutPage.load(driver);
	   facebookLogoutPage.enterEmail("orkide.tokyay@gmail.com").clickSubmitButton();
	 
	   WebDriverWait wait = new WebDriverWait(driver, 10);
	   String message = driver.findElement(By.xpath("//*[@id='login_form']/div[2]/div[1]")).getText();
	   
	   Thread.sleep(1000);
	   Assert.assertTrue(wait.until(ExpectedConditions.not((ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='login_form']/div[2]/div[1]"), message)))));			
	   
   }

}
