package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void openBrowser(String browser , String port) throws Exception
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{ 
			System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL(port),cap);
			System.out.println(browser + " browser is up and running");
			driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL(port),cap);
			System.out.println(browser + " browser is up and running");
			driver.manage().window().maximize();
		}
		else 
			System.out.println("Unable to launch " + browser + " browser");	
	}
	
	public static void openAUT() 
	{
		try {
			driver.get("https://www.shopclues.com/");
			System.out.println("AUT is up and running");
		} catch (Exception e) {
			System.out.println("Unable to open URL " + e.getMessage());
		}
		
	}
	
	public static void click(By locName) 
	{
		try {
			Thread.sleep(5000);
			driver.findElement(locName).click();
			System.out.println("Clicked on the element having locator:- " + locName);
		} catch (Exception e) {
			System.out.println("Unable to click on the element having locator:- " + locName);
		}
	}
	
	public static void enterTxt(By locName, String data) {
		try {
			Thread.sleep(2000);
			driver.findElement(locName).clear();
			driver.findElement(locName).sendKeys(data);
			System.out.println("Entered the - " + data + " - into the textbox having locator:- " + locName);
		} catch (Exception e) {
			System.out.println("Unable to Entered the value into the textbox having locator:-" + locName);
		}
	}
	public static void switchTab()
	{
		Set<String> tab = driver.getWindowHandles();
		String ntab = (String)tab.toArray()[1];
		driver.switchTo().window(ntab);
		System.out.println("Switched to new tab: " +driver.getTitle());
	}
	public static void getTxt(By locName , By locName1) throws Exception
	{
		Thread.sleep(3000);
		String pName = driver.findElement(locName).getText();
		String amount = driver.findElement(locName1).getText();
		System.out.println("Logged Product name and price");
		System.out.println("Product Name:" +pName);
		System.out.println("Price :" +amount);
	}
	public static void robotHeadphones(By locName,By locName1) throws AWTException, Exception
	{
		Thread.sleep(3000);
		WebElement we = driver.findElement(locName);
		Actions act = new Actions(driver);
		act.moveToElement(we).click().build().perform();
		System.out.println("Control moved to search bar");
		
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_H);
		rb.keyRelease(KeyEvent.VK_H);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		rb.keyPress(KeyEvent.VK_A);
		rb.keyRelease(KeyEvent.VK_A);
		rb.keyPress(KeyEvent.VK_D);
		rb.keyRelease(KeyEvent.VK_D);
		rb.keyPress(KeyEvent.VK_P);
		rb.keyRelease(KeyEvent.VK_P);
		rb.keyPress(KeyEvent.VK_H);
		rb.keyRelease(KeyEvent.VK_H);
		rb.keyPress(KeyEvent.VK_O);
		rb.keyRelease(KeyEvent.VK_O);
		rb.keyPress(KeyEvent.VK_N);
		rb.keyRelease(KeyEvent.VK_N);
		rb.keyPress(KeyEvent.VK_E);
		rb.keyRelease(KeyEvent.VK_E);
		rb.keyPress(KeyEvent.VK_S);
		rb.keyRelease(KeyEvent.VK_S);
		System.out.println("Entered the text HEADPHONES in search bar");
		Thread.sleep(3000);

		WebElement we1 = driver.findElement(locName1);
		Actions act1 = new Actions(driver);
		act1.moveToElement(we1).click().build().perform();
		System.out.println("Search button clicked");

	}
	public static void verifySearchCount(By locName) throws Exception
	{
		Thread.sleep(3000);
		String count = driver.findElement(locName).getText();
		if(Integer.parseInt(count) > 0)
			System.out.println("The product search count is greater than zero:" +count);
		else
			System.out.println("The product is not found");
	}
	public static void closeBrowser()
	{
		driver.quit();
	}
	

}
