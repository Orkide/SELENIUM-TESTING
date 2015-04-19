package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NonbirLoginPage extends NonbirBasePageObject {

    private static final String LOGIN_URL="/giris-yap";		
  	
	private static final String USER_NAME_TEXT_ID="email";
	private static final String PASSWORD_TEXT_ID="password";
	private static final String LOGIN_BUTTON_ID="loginButton";
	
	
	
	public NonbirLoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
	public static NonbirLoginPage load(WebDriver driver){
		driver.get(BASE_URL + LOGIN_URL);
		return new NonbirLoginPage(driver);
	}	
	
	public NonbirLoginPage enterUserName(String userName) {
	    driver.findElement(By.id(USER_NAME_TEXT_ID)).sendKeys(userName);
		return this;
	}
	
	public NonbirLoginPage enterPassword(String password) {
	    driver.findElement(By.id(PASSWORD_TEXT_ID)).sendKeys(password);
		return this;
	}
	
	public NonbirLoginPage submitLogin() {
	    driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
	    return new NonbirLoginPage(driver);
	}
	

}
