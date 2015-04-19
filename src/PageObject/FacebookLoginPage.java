package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage extends FacebookBasePageObject {
	
	private static final String LOGIN_URL="/login.php";	
	
	private static final String USER_NAME_TEXT_ID="email";
	private static final String PASSWORD_TEXT_ID="pass";
	private static final String LOGIN_BUTTON_ID="u_0_2";
	

	public FacebookLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
	public static FacebookLoginPage load(WebDriver driver){
		driver.get(BASE_URL + LOGIN_URL);
		return new FacebookLoginPage(driver);
	}	
	
	public FacebookLoginPage enterUserName(String userName) {
	    driver.findElement(By.id(USER_NAME_TEXT_ID)).sendKeys(userName);
		return this;
	}
	
	public FacebookLoginPage enterPassword(String password) {
	    driver.findElement(By.id(PASSWORD_TEXT_ID)).sendKeys(password);
		return this;
	}
	
	public FacebookHomePage submitLogin() {
	    driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
	    return new FacebookHomePage(driver);
	}
	
	public FacebookWantPassPage submitLoginNotPass() {
	    driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
	    return new FacebookWantPassPage(driver);
	}
	
	

}
