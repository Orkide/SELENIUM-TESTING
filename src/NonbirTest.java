import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.grid.web.servlet.DriverServlet;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.NonbirHomePage;
import PageObject.NonbirLoginPage;


public class NonbirTest {
	
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
	   public void testNonbirLogin() throws Exception {   
		   
		   NonbirHomePage nonbirHomePage = NonbirHomePage.load(driver);
		   driver.get("http://www.n11.com/");
	       Assert.assertEquals("n11.com - Alışverişin Uğurlu Adresi", driver.getTitle());  
	       
	       NonbirLoginPage nonbirLoginPage = nonbirHomePage.clickGirisYap();
	       nonbirLoginPage.enterUserName("orkide.tokyay@gmail.com").enterPassword("ot12345").submitLogin();
	       Thread.sleep(2000);
	       
	       nonbirHomePage.enterAranacakKelime("Samsung").clickKelimeAra();
	       Assert.assertTrue(driver.getPageSource().contains(driver.findElement(By.id("searchData")).getText()));
	       Thread.sleep(2000);
	       nonbirHomePage.clickIkinciSayfayiAc();
	       WebDriverWait wait = new WebDriverWait(driver, 10);
	      
	       Assert.assertTrue("2.Sayfadasın", driver.getCurrentUrl().contains(driver.findElement(By.name("currentPage")).getText()));
	       nonbirHomePage.clickUcuncuUrunSec().selectUrunRenk("Beyaz").clickSepeteEkle().clickSepetim();
	       Assert.assertTrue(driver.getPageSource().contains(driver.findElement(By.xpath("//*[@id='122253011953']/a/h4")).getText()));
	       nonbirHomePage.clickSepettenCikar();
	       Assert.assertEquals("Sepetiniz Boş", driver.findElement(By.cssSelector("#content > div > div.notification > div.cartEmptyText > span.title")).getText());
	       
	   }
}
