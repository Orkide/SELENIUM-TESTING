package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NonbirHomePage extends NonbirBasePageObject{
	  
    private static final String GIRIS_YAP_BUTTON_XPATH="//*[@id='header']/div/div/div[2]/div[2]/div[1]/div/div/a[1]";	
    
    private static final String ARAMA_ICIN_KELIME_GIR_ID="searchData";	
    private static final String ARAMA_YAP_BUTTON_XPATH="//*[@id='header']/div/div/div[2]/div[1]/a/span";	
//    private static final String IKINCI_SAYFAYI_AC_CSS="span.icon.iconSearch";	
    private static final String UCUNCU_URUN_SEC_XPATH="//*[@id='p-29327048']/div[1]/a/img";
    private static final String UCUNCU_URUN_RENK_SEC_ID="94480617";
    private static final String URUN_SEPETE_EKLE_BUTTON_XPATH="//*[@id='contentProDetail']/div/div[2]/div[2]/div[3]/div[3]/a[2]";
    private static final String URUN_SEPETE_GIT_BUTTON_CSS="a.myBasket";
    private static final String URUN_SEPETTEN_CIKAR_BUTTON_CSS="#basketItemTable > tbody > tr.product.checked > td:nth-child(1) > form > span > a";
    
	public NonbirHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static NonbirHomePage load(WebDriver driver){
		driver.get(BASE_URL);
		return new NonbirHomePage(driver);
	}
	
	public NonbirLoginPage clickGirisYap() {
		driver.findElement(By.xpath(GIRIS_YAP_BUTTON_XPATH)).click();
		return new NonbirLoginPage(driver);
	}
	
	public NonbirHomePage enterAranacakKelime(String kelime) {
		driver.findElement(By.id(ARAMA_ICIN_KELIME_GIR_ID)).sendKeys(kelime);
		return this;
	}
	
	public NonbirHomePage clickKelimeAra() {
		driver.findElement(By.xpath(ARAMA_YAP_BUTTON_XPATH)).click();
		return this;
	}
	
	public NonbirHomePage clickIkinciSayfayiAc() {
		driver.findElement(By.linkText("2")).click();
		return this;
	}
	
	public NonbirHomePage clickUcuncuUrunSec() {
		driver.findElement(By.xpath(UCUNCU_URUN_SEC_XPATH)).click();
		return this;
	}
	
	public NonbirHomePage selectUrunRenk(String renk) {
		driver.findElement(By.id(UCUNCU_URUN_RENK_SEC_ID)).sendKeys(renk);		
		return this;
	}
	
	public NonbirHomePage clickSepeteEkle() {
		driver.findElement(By.xpath(URUN_SEPETE_EKLE_BUTTON_XPATH)).click();	
		return this;
	}
	
	public NonbirHomePage clickSepetim() {
		driver.findElement(By.cssSelector(URUN_SEPETE_GIT_BUTTON_CSS)).click();	
		return this;
	}
	
	public NonbirHomePage clickSepettenCikar() {
		driver.findElement(By.cssSelector(URUN_SEPETTEN_CIKAR_BUTTON_CSS)).click();	
		return this;
	}
	

}
