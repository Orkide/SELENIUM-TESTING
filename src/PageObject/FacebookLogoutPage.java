package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLogoutPage extends FacebookBasePageObject{

	private static final String LOGOUT_URL="/?stype=lo&jlou=Afd3JKxe2CdHNlVujTomW2wkIV9sBm8D_XS7jYS9KYbRS35f1_rTXLzHEt6bJxfvr27miz0XZZM-XL8u4LqD0Pyx2wbgW9WPmjIBUHt2EChe0A&smuh=1887&lh=Ac9V8xEi7i27Cm16";
	
	private static final String USER_NAME_TEXT_ID="email";
	private static final String LOGIN_BUTTON_ID="u_0_l";
	
	private static final String FACEBOOK_LOGIN_BUTTON_XPATH="//*[@id='blueBarNAXAnchor']/div/div/div/div[1]/h1/a/i";
	
	public FacebookLogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static FacebookLogoutPage load(WebDriver driver){
		driver.get(BASE_URL + LOGOUT_URL);
		return new FacebookLogoutPage(driver);
	}	
		
	public FacebookLogoutPage clickFacebookButton() {
		driver.findElement(By.xpath(FACEBOOK_LOGIN_BUTTON_XPATH)).click();
		return this;
	}

	public FacebookLogoutPage enterEmail(String email) {
		driver.findElement(By.id(USER_NAME_TEXT_ID)).sendKeys(email);
		return this;
	}
	
	public FacebookWantPassPage clickSubmitButton() {
		driver.findElement(By.id(LOGIN_BUTTON_ID)).click();
		return new FacebookWantPassPage(driver);
	}

}
