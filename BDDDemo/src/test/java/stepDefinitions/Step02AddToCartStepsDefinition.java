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

public class Step02AddToCartStepsDefinition {
	WebDriver driver = Hooks.getDriver();

	@Given("User is on the products page and selects an item")
	public void user_is_on_the_products_page_and_selects_an_item() throws InterruptedException {
		WebElement itemName = driver.findElement(By.xpath("//div[normalize-space()=\"Sauce Labs Backpack\"]"));
		itemName.click();
		Thread.sleep(Duration.ofSeconds(3));
	}

	@When("User clicks on Add to cart button")
	public void user_clicks_on_add_to_cart_button() throws InterruptedException {
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@id=\"add-to-cart\"]"));
		addToCartButton.click();
		Thread.sleep(Duration.ofSeconds(3));
	}

	
	@Then("The item should appear in the cart and should contain correct item")
	public void the_item_should_appear_in_the_cart_and_should_contain_correct_item() throws InterruptedException {
		WebElement shoppingCartButton = driver.findElement(By.xpath("//span[@class=\"shopping_cart_badge\"]"));
		shoppingCartButton.click();
		Thread.sleep(Duration.ofSeconds(3));
		WebElement itemName = driver.findElement(By.xpath("//div[normalize-space()=\"Sauce Labs Backpack\"]"));
		Assert.assertTrue(itemName.isDisplayed());
		WebElement shoppingCartNumber = driver.findElement(By.xpath("//div[normalize-space()=\"1\"]"));
		Assert.assertTrue(shoppingCartNumber.isDisplayed());
	}

	@And("User navigates back to products page")
	public void user_navigates_back_to_products_page() throws InterruptedException {
		WebElement continueShoppingButton = driver.findElement(By.xpath("//button[@id=\"continue-shopping\"]"));
		continueShoppingButton.click();
		Thread.sleep(Duration.ofSeconds(3));
		WebElement productsTitle = driver.findElement(By.xpath("//span[normalize-space()=\"Products\"]"));
		Assert.assertTrue(productsTitle.isDisplayed());
	}

}