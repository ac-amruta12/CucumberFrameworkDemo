package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;
	
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By offer=By.linkText("Top Deals");
	By searchProduct=By.xpath("//input[@type='search']");
	By productName=By.xpath("//table//tr//td[1]");
	
	public void switchToOffersPage()
	{
		driver.findElement(offer).click();
	}
	
	public void searchProductonOfferPage(String pName)
	{
		driver.findElement(searchProduct).sendKeys(pName);
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	

}
