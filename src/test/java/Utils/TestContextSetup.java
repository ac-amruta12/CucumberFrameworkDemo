package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
//heart of FW = all classes will get initialized from here

public class TestContextSetup {
	
	public WebDriver driver;
	public String aProductName;
	public int aQuantity;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContextSetup() throws IOException
	{
		testBase = new TestBase();
		driver=testBase.webDriverManager();
		pageObjectManager= new PageObjectManager(driver);
		genericUtils=new GenericUtils(driver);
	}
	
}
