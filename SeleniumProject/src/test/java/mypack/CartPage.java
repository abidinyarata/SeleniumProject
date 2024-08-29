package mypack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	// Locators
	private By txtQuantityLoc = By.name("quantity");
	private By btnUpdateLoc = By.xpath("//i[@title='Güncelle']");
	private By txtProductPriceLoc = By.xpath("//span[@class='price-new']");
	private By txtTotalPriceLoc = By.xpath("//tbody//td[@class='total']");
	private By btnClearCart = By.xpath("//td[@class='remove']//a[@class='alt']");
	private By txtCartEmptyLoc = By.xpath("//div[@id='cart-items-empty']");
	
	// Actions Methods
	public void clear()
	{
		driver.findElement(txtQuantityLoc).clear();
	}
	
	public void inputValue(String count)
	{
		clear();
		driver.findElement(txtQuantityLoc).sendKeys(count);
	}
	
	public void updateQuantity()
	{
		driver.findElement(btnUpdateLoc).click();
	}
	
	public double getPrice()
	{
		String strPrice = driver.findElement(txtProductPriceLoc).getText();
		strPrice = strPrice.replace(',', '.');
		return Double.parseDouble(strPrice);
	}
	
	public double getTotalPrice()
	{
		String totalStr = driver.findElement(txtTotalPriceLoc).getText();
		totalStr = totalStr.replace(',', '.');
		return Double.parseDouble(totalStr);
	}
	
	public boolean isTotalEqual()
	{
		return 2 * getPrice() == getTotalPrice();
	}
	
	public void clearCart()
	{
		driver.findElement(btnClearCart).click();
		driver.findElement(By.xpath("//button[@class='swal2-close']")).click();
	}
	
	public boolean isEmpty() throws InterruptedException 
	{
		Thread.sleep(3000);
		String actualText = driver.findElement(txtCartEmptyLoc).getText();
		String expectedText = "Sepetiniz boş";
		return actualText.equals(expectedText);
	}
}