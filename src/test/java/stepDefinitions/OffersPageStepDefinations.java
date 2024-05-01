package stepDefinitions;

import org.testng.Assert;

import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import pageObjects.OffersPage;

public class OffersPageStepDefinations {
	
	//WebDriver driver;
	//String aProductName;
	TestContextSetup testContextSetup;
	
	public OffersPageStepDefinations(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@Then("^User searched product with shortform as (.+) on offer page to check existance of product$")
	public void user_searched_product_with_shortform_as_on_offer_page_to_check_existance_of_product(String string) throws InterruptedException {
	    
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.switchToOffersPage();
		Thread.sleep(3000);
		testContextSetup.genericUtils.switchToChild();
		Thread.sleep(2000);
		offersPage.searchProductonOfferPage(string);
		Thread.sleep(3000);
	
		String expProductName = offersPage.getProductName();
		
		System.out.println(expProductName);
		
		Assert.assertEquals(testContextSetup.aProductName, expProductName);
		
	}

}
