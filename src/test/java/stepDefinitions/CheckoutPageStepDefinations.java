package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.GreenKartPage;

public class CheckoutPageStepDefinations {

	TestContextSetup testContextSetup;

	public CheckoutPageStepDefinations(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("User verified product name and quantity on checkout")
	public void user_verified_product_name_and_quantity_on_checkout() throws InterruptedException 
	{
		CheckoutPage checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		String cartProductName = checkoutPage.getProductNameAddedonCart().split("-")[0].trim();
		System.out.println("product on cart : "+cartProductName);
		
		Thread.sleep(2000);
		int cartProductQuantity = Integer.parseInt(checkoutPage.getProductQuantityPresentinCart());
		System.out.println("cart product quantity : "+ cartProductQuantity);
		Assert.assertEquals(testContextSetup.aProductName, cartProductName);
		Assert.assertEquals(testContextSetup.aQuantity,cartProductQuantity );
	}
	
	
	@Then("User verified that Apply and Place Order buttons are visible on checkout")
	public void user_verified_that_apply_and_place_order_buttons_are_visible_on_checkout() throws InterruptedException {
		CheckoutPage checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		System.out.println(checkoutPage.isapplyBTNVisible());
		Thread.sleep(2000);
		System.out.println(checkoutPage.isPlaceOrderBTNVisible());
	}

}
