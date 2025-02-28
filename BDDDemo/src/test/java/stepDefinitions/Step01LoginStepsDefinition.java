package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Step01LoginStepsDefinition {
	WebDriver driver = Hooks.getDriver();
	

	@Given("User is on login page")
	public void user_is_on_login_page() {
		
		driver.get("https://www.saucedemo.com/");
	}
	
	@When("User enters valid username and password")
	public void user_enters_valid_username_and_password() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
		WebElement usernameTextField = driver.findElement(By.xpath("//input[@id=\"user-name\"]"));
		usernameTextField.sendKeys("standard_user");
		WebElement passwordTextField = driver.findElement(By.xpath("//input[@id=\"password\"]"));
		passwordTextField.sendKeys("secret_sauce");
	}

	@And("Click on Login button")
	public void click_on_Login_button() throws InterruptedException {
		Thread.sleep(Duration.ofSeconds(3));
		WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
		loginButton.click();
	}

	@Then("User is navigated to products page")
	public void user_is_navigated_to_products_page() throws InterruptedException {
		WebElement productsTitle = driver.findElement(By.xpath("//span[normalize-space()=\"Products\"]"));
		Assert.assertTrue(productsTitle.isDisplayed());
		Thread.sleep(Duration.ofSeconds(3));
	}

}
