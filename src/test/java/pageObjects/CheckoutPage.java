package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.GenericUtils;

public class CheckoutPage {
	
	WebDriver driver;
	GenericUtils genericUtils;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;	
		genericUtils=new GenericUtils(driver);
	}
	
	By productName =By.xpath("//table//tbody//td[2]/p");
	By productQuantity =By.xpath("//table//tbody//td[3]/p");
	By applyBTN =By.xpath("//button[text()='Apply']");
	By placeOrderBTN =By.xpath("//button[text()='Place Order']");
	
	public String getProductNameAddedonCart()
	{
		String cartProdut = driver.findElement(productName).getText();
		return genericUtils.getSubstring(cartProdut);
	}
	
	public String getProductQuantityPresentinCart()
	{
		return driver.findElement(productQuantity).getText();
	}
	
	public boolean isapplyBTNVisible()
	{
		return genericUtils.isElementVisible(applyBTN);
	}
	
	public boolean isPlaceOrderBTNVisible()
	{
		return genericUtils.isElementVisible(placeOrderBTN);
	}
	

}
