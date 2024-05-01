package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.GreenKartPage;

public class GreenKartPageStepDefinations {

	// WebDriver driver;
	// String aProductName;
	TestContextSetup testContextSetup;

	public GreenKartPageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() {

	}

	@When("^User Searched product with shortform as (.+) and capture actual name of product$")
	public void user_searched_product_with_shortform_as_and_capture_actual_name_of_product(String str)
			throws InterruptedException {
		
		GreenKartPage greenKartPage = testContextSetup.pageObjectManager.getGreenKartPage();
		greenKartPage.searchItem(str);
		Thread.sleep(3000);

		testContextSetup.aProductName = greenKartPage.getProductNameofSearchItem().split("-")[0].trim();
		System.out.println(testContextSetup.aProductName);
	}

	@When("^User provided product quantity (.+) and Added product to cart$")
	public void user_provided_product_quantity_and_added_product_to_cart(Integer quantity) throws InterruptedException {
		GreenKartPage greenKartPage = testContextSetup.pageObjectManager.getGreenKartPage();
		greenKartPage.enterQuantity(quantity);
		
		Thread.sleep(2000);
		greenKartPage.addProductToCart();
		String entered_quantity = greenKartPage.getQuantityOfProduct();
		
		testContextSetup.aQuantity=Integer.parseInt(entered_quantity);
		System.out.println("entered quantity : "+ testContextSetup.aQuantity);
		
	}
	
	@When("User proceed to checkout")
	public void user_proceed_to_checkout() {
		GreenKartPage greenKartPage = testContextSetup.pageObjectManager.getGreenKartPage();
		greenKartPage.goToCart();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		greenKartPage.proceedToCheckout();
	}

}
