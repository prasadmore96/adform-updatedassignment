package webpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Currenciespage {
	WebDriver driver;
	public Currenciespage(WebDriver driver) {
		this.driver= driver;

}
	By addCurrencybtn= By.xpath("/html/body/main/section/div[2]/div/div/div[1]/div[1]/a");
	By currencystatusdropdown= (By.xpath("(//span[@role='combobox'])[1]"));
	By enabledselection= By.xpath("//li[@role='option'][1]");
	By currencynametextbox= By.xpath("//input[@name='Y3VycmVuY2llcy5uYW1l']"); 
	By currencyCountrydropdown= (By.xpath("(//span[@role='combobox'])[2]"));
	By selectingIndia= By.xpath("//li[@role='option'][105]");
	By currencyRatetextbox= By.xpath("//input[@name='Y3VycmVuY2llcy5yYXRl']");
	By Savebtn_currency= By.linkText("Save");
	By EditCurrencybtn= (By.xpath("(//a[@title='Edit'])[1]"));
	By deleteCurrencybtn= By.xpath("(//a[@title='Remove'])[1]");
	
	//User clicks on Add Button
	public void addCurrency() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(addCurrencybtn));
 	    driver.findElement(addCurrencybtn).click();
	}
	//User selects Enabled in Status Dropdown
 	   public void dropdownstatus() {
 			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(currencystatusdropdown));
 			driver.findElement(currencystatusdropdown).click();
 			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(enabledselection));
 			driver.findElement(enabledselection).click();
	}
 	   //User enters Currency Name
	public void entercurrencyname() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(currencynametextbox));
		driver.findElement(currencynametextbox).sendKeys("INR");
	}
	//User selects Country from Dropdown
	public void selectCountry() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(currencyCountrydropdown));
		driver.findElement(currencyCountrydropdown).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(selectingIndia));
		driver.findElement(selectingIndia).click();
	}
	//User enters Rate
	public void enterRate() {
		driver.findElement(currencyRatetextbox).sendKeys("9.0");
	}
	//User clicks on Save Button
	public void clickonSave_currency() {
	driver.findElement(Savebtn_currency).click();
	}
	//Title of the Currnecies page
	public void assertTitle_Currencies() {
		String expectedTitle2 = "Currencies";
  		String actualTitle2 = driver.getTitle();
  		Assert.assertEquals(actualTitle2, expectedTitle2);
  		System.out.println("User is on Currencies Page after adding currency INR");
	}
	//User clicks on Edit Button
	public void editCurrency() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(EditCurrencybtn));
		driver.findElement(EditCurrencybtn).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(currencyRatetextbox));
		driver.findElement(currencyRatetextbox).click();
		driver.findElement(currencyRatetextbox).clear();
		//User updates the value from 9.00 to 10.00
		driver.findElement(currencyRatetextbox).sendKeys("10.0");
		System.out.println("Currency rate is updated from 9.00 to 10.0");
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Savebtn_currency));
		driver.findElement(Savebtn_currency).click();
	}
	//User deletes the created Currency
	public void removeCurrency() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(deleteCurrencybtn));
		driver.findElement(deleteCurrencybtn).click();
		driver.switchTo().alert().accept();
	}
}
