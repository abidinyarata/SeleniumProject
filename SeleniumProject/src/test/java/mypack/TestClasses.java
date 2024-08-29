package mypack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClasses {
	public static void run() throws InterruptedException
	{
		WebDriver driver = null;
			
		driver = init(driver);
		searchTest(driver);
		advanceSearchTest(driver);
		bookSelectPageTest(driver);
		bookDetailsPageTest(driver);
		cartPageTest(driver);
	}
	
	public static WebDriver init(WebDriver driver)
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.kitapyurdu.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='cookiescript_accept']")).click();
		
		return driver;
	}
	
	public static void searchTest(WebDriver driver) throws InterruptedException 
	{
		SearchPage searchPage = new SearchPage(driver);
		
		searchPage.inputAuthorName("Sabahattin Ali");
		Thread.sleep(2000);
		searchPage.search();
	}
	
	public static void advanceSearchTest(WebDriver driver)
	{
		AdvancedSearchPage advancedSearchPage = new AdvancedSearchPage(driver);
		
		advancedSearchPage.checkInStock();
		advancedSearchPage.sortByAlphabeticely();
		advancedSearchPage.selectPage();
	}
	
	public static void bookSelectPageTest(WebDriver driver) throws InterruptedException
	{
		BookSelectionPage bookSelectionPage = new BookSelectionPage(driver);
		bookSelectionPage.selectBook();
	}
	
	public static void bookDetailsPageTest(WebDriver driver)
	{
		BookDetailsPage bookDetailsPage = new BookDetailsPage(driver);
		
		bookDetailsPage.addCart();
		
		if (bookDetailsPage.isAdded()) {
			System.out.println("Ürün eklendi");
			bookDetailsPage.closeToastMsg();
		}
		
		bookDetailsPage.goCart();
	}
	
	public static void cartPageTest(WebDriver driver) throws InterruptedException 
	{
		CartPage cartPage = new CartPage(driver);
		
		cartPage.inputValue("2");
		cartPage.updateQuantity();
		
		if (cartPage.isTotalEqual())
			System.out.println("Eşit");
		else
			System.out.println("Eşit değil");
		
		cartPage.clearCart();
		
		if (cartPage.isEmpty())
			System.out.println("Sepet boş");
		else
			System.out.println("Sepet boş değil");
	}
}