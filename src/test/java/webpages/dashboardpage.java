package webpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class dashboardpage {
	WebDriver driver;
	public dashboardpage(WebDriver driver) {
		this.driver= driver;
}
	By settingsicon= By.xpath("/html/body/main/header/ul/li[2]/button");
	By Currenciesicon= By.xpath("//*[@id=\"settings-collapse\"]/ul/li[4]/a");
	By Locationsicon= By.xpath("//*[@id=\"settings-collapse\"]/ul/li[6]/a");
	
	//Title of the Dashboard page
	public void dashboardTitle() 
	{
	    String expectedTitle = "Dashboard";
  	    String actualTitle = driver.getTitle();
  	    Assert.assertEquals(actualTitle, expectedTitle);
	}
	//User clicks on Settings
	public void clickOnSettings() {
		driver.findElement(settingsicon).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//User clicks on Currencies under Settings
	public void clickOnCurrencies() {
		driver.findElement(Currenciesicon).click();
		}
	//User clicks on Locations under Settings
	public void clickOnLocations() {
		driver.findElement(Locationsicon).click();
	}
}
