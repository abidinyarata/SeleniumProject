package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
	WebDriver driver;
	
	SearchPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// Locators
	private By searchBoxLoc = By.id("search-input");
	private By searchButtonLoc = By.cssSelector(".button-search");
	
	// Action Methods
	public void inputAuthorName(String author)
	{
		driver.findElement(searchBoxLoc).sendKeys(author);
	}
	
	public void search()
	{
		driver.findElement(searchButtonLoc).click();
	}
}