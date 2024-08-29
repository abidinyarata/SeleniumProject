package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookDetailsPage {
	WebDriver driver;
	
	public BookDetailsPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// Locators
	private By strPriceLoc = By.xpath("//div[@class='price__item']");
	private By btnAddCartLoc = By.id("button-cart");
	private By addedToastMessageLoc = By.xpath("//div[@class='swal2-icon swal2-success swal2-icon-show']");
	private By closeToastLoc = By.xpath("//button[@class='swal2-close']");
	private By btnCartLoc = By.xpath("//div[@id='cart']");
	private By btnGoCartLoc = By.xpath("//a[normalize-space()='Sepete Git']");
	
	// Actions Methods
	public void getPrice()
	{
		String strPrice = driver.findElement(strPriceLoc).getText();
		strPrice = strPrice.replace(',', '.');
		double price = Double.parseDouble(strPrice);
		System.out.println(price);
	}
	
	public void addCart()
	{
		driver.findElement(btnAddCartLoc).click();
	}
	
	public boolean isAdded()
	{
		return driver.findElement(addedToastMessageLoc).isDisplayed();
	}
	
	public void closeToastMsg()
	{
		driver.findElement(closeToastLoc).click();
	}
	
	public void goCart()
	{
		driver.findElement(btnCartLoc).click();
		driver.findElement(btnGoCartLoc).click();
	}
}