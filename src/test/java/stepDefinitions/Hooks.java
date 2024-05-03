package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario()
	{
		testContextSetup.driver.quit();
	}
	
	@AfterStep
	public void addScenarioFailedStep(Scenario scenario) throws IOException
	{
		WebDriver driver = testContextSetup.driver;
		
		if(scenario.isFailed())
		{
			System.out.println("--after step failed--");
			File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			byte[] filecontent = FileUtils.readFileToByteArray(sourcepath); //file - byte stream 
			scenario.attach(filecontent, "image/png", "image");
		}
	}

}
