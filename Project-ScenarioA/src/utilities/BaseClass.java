package utilities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BaseClass {
	
	public static WebDriver driver;
	public static String hotelName,count;
	
	
	
	public static void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", ".\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome Browser setup done sucessfully");
				
	}
	public static void openAUT()
	{
		try {
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		System.out.println("AUT is up and running" + driver.getTitle());
		}
		catch(Exception e)
		{
			System.out.println("Unable to open URL " + e.getMessage());
		}
	
	}
	public static void click(By locName)
	{
		try {
			Thread.sleep(2000);
			driver.findElement(locName).click();
			System.out.println("Clicked on the element having locator:- " + locName);
		} catch (Exception e) {
			System.out.println("Unable to click on the element having locator:- " + locName);
		}
	}
	public static void clickSelRoom(By locName)
	{
		try {
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(2000);
			driver.findElement(locName).click();
			System.out.println("Clicked on the element having locator:- " + locName);
		} catch (Exception e) {
			System.out.println("Unable to click on the element having locator:- " + locName);
		}
	}
	public static void enterText(By locName , String data) throws Exception
	{
			Thread.sleep(2000);
			driver.findElement(locName).clear(); 
			WebElement we = driver.findElement(locName);
			we.sendKeys(data);
			Thread.sleep(2000);
			Actions act = new Actions(driver);
			act.sendKeys(Keys.DOWN).perform();
			act.sendKeys(Keys.ENTER).perform();
			System.out.println("Entered the - " + data + " - into the textbox having locator:- " + locName);

	}

	public static void getCount(By locName)
	{
		int i = driver.findElements(locName).size();
		System.out.println("Total count is :" +i);
	}
	public static void getText(By locName , String s) throws Exception
	
	{
		Thread.sleep(5000);
		hotelName = driver.findElement(locName).getText();
		System.out.println("Hotel Name is: " +hotelName);
		
		if(hotelName.equalsIgnoreCase(s))
		{
			driver.findElement(locName).click();
		}
		else
			System.out.println(hotelName + "is not found in the list");
	}
	public static void verifyDetails(By locName , By locName1 , By locName2,String s) throws Exception
	{
		hotelName = driver.findElement(locName).getText();
		driver.findElement(locName1).click();
		Thread.sleep(2000);
		count = driver.findElement(locName2).getText();
		if(hotelName.equalsIgnoreCase(s) && count.equalsIgnoreCase("1"))
			System.out.println("Booking details matching ...please enter Guest details");
		else
			System.out.println("Booking details are not matching");
		
	} 
	public static void verifyRoomOption(By locName , By locImage) throws Exception
	{
		navigateBack();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(locName).click();
		if(driver.findElement(locName).isDisplayed())
		{
		driver.findElement(locImage);
		System.out.println("Room Options has displayed and logged the image");
		}
		else
			System.out.println("Room Options has not displayed and not logged the image");
	}
	public static boolean verifyMenuDisplayed(By locName)
	{
		driver.findElement(locName).click();
		if(driver.findElement(locName).isDisplayed())
			return true;
		else
			return false;			
	}
	public static void verifyPriceRating(By locName, By locName1)
	{
		driver.findElement(locName).isDisplayed();
		System.out.println("Verified filter by price");
		driver.findElement(locName1).isDisplayed();
		System.out.println("Verified filter by rating");
	}
	public static void changeNewTab()
	{
		Set<String> tab = driver.getWindowHandles();
		String ntab = (String) tab.toArray()[1];
		driver.switchTo().window(ntab);
		System.out.println("Switched to new tab " + driver.getTitle());
	}
	public static void navigateBack()
	{
		driver.navigate().back(); //back to guest details page
		driver.navigate().back(); // back to hotel details page
	}
	public static void closeBrowser()
	{
		driver.close();
	}

}
