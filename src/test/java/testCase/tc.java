package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import webpages.Currenciespage;
import webpages.Locationspage;
import webpages.dashboardpage;
import webpages.loginPage;

public class tc {
	public static void main(String[] args) throws InterruptedException {
		String projectLocation = System.getProperty("user.dir");
		WebDriver driver= new ChromeDriver();
	    
	    System.setProperty("webdriver.chrome.driver", projectLocation + "/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--disable-notifications");
	    options.addArguments("--remote-allow-origins=*");
	  
	    driver.manage().window().maximize();
		driver.get("https://phptravels.site/admin/login.php");
		
		loginPage login= new loginPage (driver);
		dashboardpage dashboard= new dashboardpage (driver);
		Currenciespage currencies= new Currenciespage (driver);
		Locationspage locations= new Locationspage (driver);
		
		login.enteremail("admin@phptravels.com");
		login.enterpassword("demoadmin");
		login.loginbtnclick();
		
		dashboard.dashboardTitle();
		dashboard.clickOnSettings();
		dashboard.clickOnCurrencies();
		
		currencies.assertTitle_Currencies();
		currencies.addCurrency();
		currencies.dropdownstatus();
		currencies.entercurrencyname();
		currencies.selectCountry();
		currencies.enterRate();
		currencies.clickonSave_currency();
		currencies.editCurrency();
		currencies.enterRate();
		currencies.clickonSave_currency();
		currencies.removeCurrency();
		
		locations.clickOnLocations();
		locations.addLocation();
		locations.selectStatusdrpdown();
		locations.enterCity();
		locations.selectCountry();
		locations.saveLocations();
		locations.assertTitleLocations();
		locations.negativeTestOnAddingSameCityInLocation();
		locations.clickOnReturn();
		locations.deleteLocations();
		locations.clickOnDashboard();
		}
}