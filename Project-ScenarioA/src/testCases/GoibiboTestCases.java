package testCases;

import org.testng.annotations.Test;

import objRepo.WebsiteObjects;
import utilities.BaseClass;

public class GoibiboTestCases extends BaseClass{
	
	@Test(priority = 0)
	public static void scenario1() throws Exception
	{
		openBrowser();
		openAUT();
		WebsiteObjects.enterDetails();
	}
	
	@Test(priority = 1 , dependsOnMethods = "scenario1")
	public static void scenario2() throws Exception
	{
		
		WebsiteObjects.checkHotel();
		WebsiteObjects.enterRoomDetails();
		WebsiteObjects.enterCardDetails();
		
	}
	@Test(priority = 2 , dependsOnMethods = "scenario2")
	public static void scenario3() throws Exception
	{
		WebsiteObjects.verifyVariousMenuOptions();
	}
	@Test(priority = 3)
	public static void scenario4() throws Exception
	{
		openAUT();
		WebsiteObjects.enterDetails();
		WebsiteObjects.applyFilters();
		WebsiteObjects.verifyFilters();
	}
	@Test(priority = 4)
	public static void quitBrowser()
	{
		closeBrowser();
	}

}
