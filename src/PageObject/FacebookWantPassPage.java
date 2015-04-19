package PageObject;

import org.openqa.selenium.WebDriver;

public class FacebookWantPassPage extends FacebookBasePageObject{

	private static final String WITHOUT_PASS_LOGIN_URL="/login.php?login_attempt=1";
	
	public FacebookWantPassPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static FacebookWantPassPage load(WebDriver driver){
		driver.get(BASE_URL + WITHOUT_PASS_LOGIN_URL);
		return new FacebookWantPassPage(driver);
	}	

}
