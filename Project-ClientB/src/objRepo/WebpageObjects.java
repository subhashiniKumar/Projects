package objRepo;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class WebpageObjects extends BaseClass {
	 
	public static By msgDisplay = By.xpath("//button[contains(text(), 'Don')]");
	
	public static By signIn = By.xpath("(//a[contains(text(), 'Sign In')])[1]");
	public static By email = By.xpath("//input[@id='main_user_login']");
	public static By login = By.xpath("//a[contains(text(), 'Login via OTP')]");
	public static By close = By.xpath("//a[@id='a_close_id']");
	
	public static By searchText = By.xpath("//input[@id='autocomplete']");
	public static By searchButton = By.xpath("//a[@class='srch_action btn orange']");
	public static By imgClick = By.xpath("//img[@onclick='homePageTracking(this);']");
	
	public static By proName = By.xpath("//h1[@itemprop='name']");
	public static By proPrice = By.xpath("//span[@class='f_price']");
	public static By results = By.xpath("//i[@id='instdcnt']");
	

	public static void clickSignIn()
	{
		click(msgDisplay);
		click(signIn);
	}
	public static void checkLoginCredentials(String data)
	{
		enterTxt(email,data);
		click(login);
	}
	public static void closeModal()
	{
		click(close);
	}
	public static void searchProduct()
	{
		enterTxt(searchText, "NIKE SHOES");
		click(searchButton);
		click(imgClick);
	}
	public static void logProductDetails() throws Exception
	{
		getTxt(proName,proPrice);
		
	}
	public static void headphoneRobotClass() throws Exception
	{
		click(msgDisplay);
		robotHeadphones(searchText,searchButton);
		verifySearchCount(results);
	}

}
