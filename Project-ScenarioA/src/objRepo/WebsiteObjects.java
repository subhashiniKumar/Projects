package objRepo;

import org.openqa.selenium.By;

import utilities.BaseClass;

public class WebsiteObjects extends BaseClass{
	public static By hotel = By.xpath("(//a[@href=\"/hotels/\"])[1]");
	public static By location = By.xpath("//input[@data-testid='home-autosuggest-input']");
	public static By date = By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 SearchBlockUIstyles__CheckInDateWrapDiv-sc-fity7j-14 bjZxoj kSflmU']");
	public static By checkIN = By.xpath("(//span[contains(text(),'1')])[1]");
	public static By checkOut = By.xpath("(//span[contains(text(),'2')])[2]");
	public static By room = By.xpath("//input[@type=\"text\"]");
	public static By adult = By.xpath("//input[@type=\"text\"]/following:: span[7]");
	public static By done = By.xpath("//button[contains(text(), 'Done')]");
	public static By search = By.xpath("//button[@data-testid='searchHotelBtn']");
	
	public static By hotelName = By.xpath("//h4[contains(text(), 'Chettinad Avenue')]");
	public static By totalCount = By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-9 bjZxoj']");
	
	public static By hotelName1 = By.xpath("//h1[contains(text(), 'Chettinad Avenue')]");
	public static By detail = By.xpath("//input[@value='1 Adult . 0 Child . 1 Room ']");
	public static By count = By.xpath("//*[@id=\"root\"]/section[1]/section[1]/div/div/div[4]/div/div/div[2]/div/h4");
	

	public static By selRoom = By.xpath("//a[contains(text(),'Room Options')]");
	public static By selRoom1 = By.xpath("//a[contains(text(), 'Room Options')]/following:: button[1]");
	public static By fName = By.xpath("//input[@placeholder='Enter First Name']");
	public static By lName = By.xpath("//input[@placeholder='Enter Last Name']");
	public static By email = By.xpath("//input[@placeholder='Enter Email Address']");
	public static By phNo = By.xpath("//input[@placeholder='Enter Phone Number']");
	public static By pay = By.xpath("//span[contains(text(),'Proceed To Payment Options')]");
	
	public static By cardNo = By.xpath("//input[@placeholder='Card Number']");
	public static By cardName = By.xpath("//input[@placeholder='Name']");
	public static By expDate = By.xpath("//input[@placeholder='MM / YY']");
	public static By cvvNo = By.xpath("//input[@placeholder='CVV NO.']");
	
	public static By imgSrc = By.xpath("//img[@class='Roomstyles__RoomImageStyled-sc-1ivl7fs-6 bABWwi']");
	public static By guest = By.xpath("//a[@data-testid='navigation-header-cta-#guest-reviews']");
	public static By hReview = By.xpath("//a[@data-testid='navigation-header-cta-#hotel-policies']");
	public static By loc = By.xpath("//a[@data-testid='navigation-header-cta-#location']");
	public static By QA = By.xpath("//a[@data-testid='navigation-header-cta-#QnA']");

	public static By payFilter = By.xpath("//span[contains(text(), 'Pay At Hotel Available')]");
	public static By priceRange = By.xpath("//span[contains(text(), '4000')]");
	public static By rating = By.xpath("(//span[contains(text(), '4')])[5]");
	
	public static By verifyRating = By.xpath("//span[contains(text(), '4+')]");
	public static By verifyPrice = By.xpath("(//span[contains(text(), '4000')])[2]");
	

	
	public static void enterDetails() throws Exception
	{
		click(hotel);
		enterText(location,"ooty");
		click(date);
		click(checkIN);
		click(checkOut);
		click(room);
		click(adult);
		click(done);
		click(search);
	}
	public static void checkHotel() throws Exception 
	{
		getText(hotelName,"Chettinad Avenue");
		getCount(totalCount);
		changeNewTab();
		verifyDetails(hotelName1,detail,count,"Chettinad Avenue");
		click(done);
	}
	public static void enterRoomDetails() throws Exception
	{
		
		clickSelRoom(selRoom1);
		enterText(fName,"Venkatesh");
		enterText(lName,"Raja");
		enterText(email,"vraja@gmail.com");
		enterText(phNo,"9176453546");
		click(pay);
	}
	public static void enterCardDetails() throws Exception
	{
		enterText(cardNo,"222 222 2221");
		enterText(cardName,"Venkatesh");
		enterText(expDate,"02 / 24");
		enterText(cvvNo,"999");
		
	}
	public static void verifyVariousMenuOptions() throws Exception
	{
		verifyRoomOption(selRoom,imgSrc);
		
		if(verifyMenuDisplayed(guest)==true)
			System.out.println("Guest Review section is displayed");
		else
			System.out.println("Guest Review section is not displayed");
		
		if(verifyMenuDisplayed(hReview)==true)
			System.out.println("Hotel polices section is displayed");
		else
			System.out.println("Hotel polices section is not displayed");
		
		if(verifyMenuDisplayed(loc)==true)
			System.out.println("Location section is displayed");
		else
			System.out.println("Location section is not displayed");
		
		if(verifyMenuDisplayed(QA)==true)
			System.out.println("Question & Answers section is displayed");
		else
			System.out.println("Question & Answers is not displayed");
		
	}
	public static void applyFilters()
	{
		click(payFilter);
		click(priceRange);
		click(rating);
	}
	public static void verifyFilters()
	{
		verifyPriceRating(verifyPrice,verifyRating);

	}
	
}
