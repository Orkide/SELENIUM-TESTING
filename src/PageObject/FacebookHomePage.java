package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookHomePage extends FacebookBasePageObject {
	

	private static final String ARROW_ID="userNavigationLabel";
	private static final String LOGOUT_BUTTON_XPATH="//*[@id='logout_form']/label";	
	private static final String FACEBOOK_BUTTON_CSS="input.uiLinkButtonInput";
	
		/**
		 * @author CI
		 * 
		 */
			
		public FacebookHomePage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}

		public static FacebookLoginPage load(WebDriver driver){
			driver.get(BASE_URL);
			return new FacebookLoginPage(driver);
		}
			
		public FacebookHomePage clickArrow() {
		    driver.findElement(By.id(ARROW_ID)).click();
		    return this;
		}
		
		public FacebookHomePage submitLogout() {
		    driver.findElement(By.xpath(LOGOUT_BUTTON_XPATH)).click();
		    return this;
		}
		
		public FacebookHomePage clickFacebookButton() {
		    driver.findElement(By.cssSelector(FACEBOOK_BUTTON_CSS)).click();
		    return this;
		}
		
		

}
