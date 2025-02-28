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

public class Step03LogoutStepsDefinition {
	WebDriver driver = Hooks.getDriver();
	
	@Given("User has an item in the cart")
	public void user_has_an_item_in_the_cart() {
		WebElement shoppingCartNumber = driver.findElement(By.xpath("//div[normalize-space()=\"1\"]"));
		Assert.assertTrue(shoppingCartNumber.isDisplayed());
	}

	@When("User opens the menu")
	public void user_opens_the_menu() throws InterruptedException {
		WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
		menuButton.click();
		Thread.sleep(Duration.ofSeconds(3));
	}
	
	@And("Clicks the logout button")
	public void clicks_the_logout_button() {
		WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
		logoutButton.click();
	}
	
	@Then("User should be redirected to login page")
	public void user_should_be_redirected_to_login_page() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
		Assert.assertTrue(loginButton.isDisplayed());
	}
	
}
