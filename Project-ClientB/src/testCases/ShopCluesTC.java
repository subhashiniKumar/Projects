package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objRepo.WebpageObjects;
import utilities.BaseClass;
import utilities.ExcelReading;

public class ShopCluesTC extends BaseClass{
	
	@Parameters({"Browser" , "portURL"})
@Test(priority = 0 , groups = "Group1")
	public static void scenario1(String bName, String pName) throws Exception
	{
		String path = ".\\src\\dataSet\\ClientB-Login-Credentials.xlsx";
		openBrowser(bName,pName);
		openAUT();
		WebpageObjects.clickSignIn();
		ExcelReading.setupExcel(path, "Sheet1");
		for(int i = 1; i<6; i++)
		{
			String data = ExcelReading.getData(i, 0);
			WebpageObjects.checkLoginCredentials(data);
		}
		WebpageObjects.closeModal();
		
	}
@Test(priority = 1 , groups = "Group1")
	public static void scenario2() throws Exception
	{
		
		WebpageObjects.searchProduct();
		switchTab();
		WebpageObjects.logProductDetails();
		closeBrowser();
	}
@Parameters({"Browser" , "portURL"})
@Test(priority = 2, groups = "Using Robot Class")
	public static void scenario3(String bName, String pName) throws Exception
	{
		openBrowser(bName,pName);
		openAUT();
		WebpageObjects.headphoneRobotClass();
		closeBrowser();
	}
}
