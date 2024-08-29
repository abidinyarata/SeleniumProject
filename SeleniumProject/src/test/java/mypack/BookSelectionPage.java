package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookSelectionPage {
	WebDriver driver;
	
	public BookSelectionPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// Locators
	private By selectedBookLoc = By.xpath("(//div[@class='name'])[3]//a");
	
	// Action Methods
	public void selectBook()
	{
		System.out.println(driver.findElement(selectedBookLoc).getText());
		driver.findElement(selectedBookLoc).click();
	}
}