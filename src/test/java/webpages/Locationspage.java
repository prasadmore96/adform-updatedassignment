package webpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Locationspage {
	WebDriver driver;
	public Locationspage(WebDriver driver) {
		this.driver= driver;
	}
	By locationsicon= By.xpath("//*[@id=\"settings-collapse\"]/ul/li[6]/a");
	By addLocationsbtn= By.partialLinkText("Add");
	By Locations_statusdropdown= By.xpath("(//span[@role='combobox'])[1]");
	By enabledselection_locations= By.xpath("(//li[@role='option'])[1]");
	By Citytextbox= By.xpath("//input[@name='bG9jYXRpb25zLmNpdHk-']");
	By LocationsCountrydropdown= By.xpath("(//span[@role='combobox'])[2]");
	By selectingIndiaLocation= By.xpath("//li[@role='option'][97]");
	By LocationsSavebtn= By.linkText("Save");
	By deleteLocation= By.xpath("(//a[@title='Remove'])[1]");
	By returnBtn= By.linkText("Return");
	By dashboardicon= By.linkText("Dashboard");
	By ErrorMsgLocations= By.xpath("//body/main[1]/section[1]/div[2]/div[1]/div[1]/div[2]");
	
	//User clicks on Locations
	public void clickOnLocations() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(locationsicon));
		driver.findElement(locationsicon).click();
	}
	//User clicks on Add Location
	public void addLocation() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(addLocationsbtn));
		driver.findElement(addLocationsbtn).click();
	}
	//User selects Enable Status in Dropdown
	public void selectStatusdrpdown() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Locations_statusdropdown));
		driver.findElement(Locations_statusdropdown).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(enabledselection_locations));
		driver.findElement(enabledselection_locations).click();
	}
	//User enters City name
	public void enterCity() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Citytextbox));
		driver.findElement(Citytextbox).sendKeys("Kurla");
	}
	//User selects Country from dropdown list
	public void selectCountry() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(LocationsCountrydropdown));
		driver.findElement(LocationsCountrydropdown).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(selectingIndiaLocation));
		driver.findElement(selectingIndiaLocation).click();
		
	}
	//User clicks on Save Button
	public void saveLocations() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(LocationsSavebtn));
		driver.findElement(LocationsSavebtn).click();
	}
	//Title of the Locations page
	public void assertTitleLocations(){
		String expectedTitle3 = "Locations";
 		String actualTitle3 = driver.getTitle();
 		Assert.assertEquals(actualTitle3, expectedTitle3);
 		System.out.println("User is on Locations Page after adding country INDIA");
	}
	//Negative check whether user is able to add locations with same cities
	public void negativeTestOnAddingSameCityInLocation() {
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(addLocationsbtn));
		driver.findElement(addLocationsbtn).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(Locations_statusdropdown));
		driver.findElement(Locations_statusdropdown).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(enabledselection_locations));
		driver.findElement(enabledselection_locations).click();
		driver.findElement(Citytextbox).sendKeys("Kurla");
		
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(LocationsCountrydropdown));
		driver.findElement(LocationsCountrydropdown).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(selectingIndiaLocation));
		driver.findElement(selectingIndiaLocation).click();
		driver.findElement(LocationsSavebtn).click();
		
		//Reading the Error Message
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(ErrorMsgLocations));
		WebElement m = driver.findElement(By.xpath("/html/body/main/section/div[2]/div/div/div[3]"));
		String act = m.getText();
	    System.out.println("Error message is: "+ act);
		}
	//User clicks on Return Button
	public void clickOnReturn() {
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(returnBtn));
		driver.findElement(returnBtn).click();
	}
	//User deletes the created location
	public void deleteLocations() {
		driver.findElement(deleteLocation).click();
		driver.switchTo().alert().accept();
	}
	//User returns on Dashboard
	public void clickOnDashboard() {
		driver.findElement(dashboardicon).click();
	}
	
}
