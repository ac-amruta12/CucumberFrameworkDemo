package Utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericUtils {
	
    WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public  void switchToChild()
	{
        Set<String> win = driver.getWindowHandles();
		
		Iterator<String> win_itr = win.iterator();
		String parentWin = win_itr.next();
		String child = win_itr.next();
		driver.switchTo().window(child);
	}
	
	public String getSubstring(String str)
	{
		return str.split("-")[0].trim();
	}

	public boolean isElementVisible(By by)
	{
		boolean bln = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		try
		{
	    bln = wait.until(ExpectedConditions.presenceOfElementLocated(by)).isDisplayed();
		}
		catch(Exception e)
		{}
		return bln;   
	}
}
