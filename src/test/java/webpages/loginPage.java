package webpages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class loginPage {
		WebDriver driver;
		public loginPage(WebDriver driver) {
			this.driver= driver;

	}
		By emailtextbox= By.id("email");
		By passwordtextbox= By.id("password");
		By Loginbtn= By.id("submit");
		
		//methods
		public void enteremail(String email) {
			driver.findElement(emailtextbox).sendKeys(email);
		}

		public void enterpassword(String password) {
			driver.findElement(passwordtextbox).sendKeys(password);
		}
		public void loginbtnclick() {
			driver.findElement(Loginbtn).click();
		}
}
