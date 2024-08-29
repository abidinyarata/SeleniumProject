package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchPage {
	WebDriver driver;
	
	public AdvancedSearchPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// Locators
	private By drpSortLoc = By.xpath("//div[@class='sort']//select[@onchange='location = this.value;']");
	private By inStockLoc = By.xpath("//label[normalize-space()='Stokta Olanlar']");
	private By pageTwoLoc = By.xpath("//div[@class='links']//a[1]");
	
	// Actions Methods
	public void checkInStock()
	{
		driver.findElement(inStockLoc).click();
	}
	
	public void sortByAlphabeticely()
	{
		Select drpEleSelect = new Select(driver.findElement(drpSortLoc));
		drpEleSelect.selectByVisibleText("Alfabetik");
	}
	
	public void selectPage()
	{
		driver.findElement(pageTwoLoc).click();
	}
}