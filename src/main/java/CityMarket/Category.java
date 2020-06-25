package CityMarket;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Category {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"D:\\Eclipse_Oxygen\\Selenium_Practice\\Ramesh\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.citymarketnorwalk.com/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		Thread.sleep(35000);

		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();

		String parentwin = driver.getWindowHandle();
		String childwin = null;

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			childwin = it.next();
		}

		driver.switchTo().window(parentwin);

		driver.findElement(By.xpath("//input[@id='magestore-sociallogin-popup-email']"))
				.sendKeys("sunrise5701@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password*']")).sendKeys("Hello@12345");
		driver.findElement(By.xpath("//button[@id='magestore-button-sociallogin']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[contains(@class,'hamburger')]")).click();

		Thread.sleep(4000);

		// WebElement Category_List =
		// driver.findElement(By.xpath("//ul[normalize-space(@class)='nav-primary
		// mmenu__parent-list']"));

		// WebElement Category_List =
		// driver.findElement(By.xpath("//ul[starts-with(@class,'nav-primary')]"));

		Thread.sleep(15000);
		// List<WebElement> All_Category_Element_List =
		// Category_List.findElements(By.xpath("//li[contains(normalize-space(@class),
		// 'top parent')]"));

		List<WebElement> Parent_Category = driver.findElements(By.xpath("//li/div[@class='mmenu__parent-category']"));

		for (WebElement All_Category_Element_List_iterator : Parent_Category) {

			System.out.println(All_Category_Element_List_iterator.getText());

			Actions act1 = new Actions(driver);
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(All_Category_Element_List_iterator));
			act1.moveToElement(All_Category_Element_List_iterator).build().perform();

			Thread.sleep(5000);

			List<WebElement> Sub_Category = driver.findElements(By.xpath("//li/div[@class='mmenu__parent-category']"));

			for (WebElement Subl_Category_Element : Sub_Category) {

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				
				if (All_Category_Element_List_iterator.getText().contains("Beverages")) {

					System.out.println(All_Category_Element_List_iterator.getText());

					Thread.sleep(10000);

					All_Category_Element_List_iterator.findElement(By.xpath("//span[contains(text(),'Water')]")).click();
                    
					Thread.sleep(15000);
					driver.findElement(By.xpath("//strong//a[contains(text(),'Dasani Purified Water - 20fl oz')]")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[@type='submit' and @id='product-addtocart-button']")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//a[normalize-space(@class)='action showcart icon icon-main-cart']")).click();
					Thread.sleep(6000);
					driver.findElement(By.xpath("//a[normalize-space(@class)='action viewcart btn btn__hollow btn-block']")).click();
					Thread.sleep(6000);
					driver.findElement(By.xpath("//button[normalize-space(@class)='action primary checkout']")).click();
					Thread.sleep(20000);
					driver.findElement(By.xpath("//div[contains(text(),'Shipping Address')]//following::input[3]")).sendKeys("745 MANHATTAN AVENUE (BETWEEN MESEROLE & NORMAN AVE.), NEW YORK, NY 11222");
									
					driver.findElement(By.xpath("//div[contains(text(),'Shipping Address')]//following::input[5]")).sendKeys("New York");
					
					//Select drpstate = new Select();
					
					driver.findElement(By.xpath("//div[contains(text(),'Shipping Address')]//following::input[7]")).sendKeys("11222");
                    driver.findElement(By.xpath("//div[contains(text(),'Shipping Address')]//following::input[8]")).sendKeys("7183839463");
                    driver.findElement(By.xpath("//div[contains(text(),'Shipping Address')]//following::input[9]")).sendKeys("Hey, please make it spicy & crispy");
					 
					driver.findElement(By.xpath("//input[@type='radio' and @id='43']")).click();
					executor.executeScript("arguments[0].click();", Subl_Category_Element);
					
					

					break;
					
					

				}
				

			}
			
			

		}
		

		/*
		 * List<WebElement> Menu_Parent_Category =
		 * All_Category_Element_List_iterator.findElements(By.tagName("div"));
		 * 
		 * for (WebElement Menu_Parent_Category_iterator : Menu_Parent_Category ) {
		 * 
		 * List<WebElement> Sub_Menu =
		 * Menu_Parent_Category_iterator.findElements(By.tagName("ul"));
		 * 
		 * for(WebElement Sub_Menu_Iterator : Sub_Menu) {
		 * 
		 * List<WebElement> Sub_li = Sub_Menu_Iterator.findElements(By.tagName("li"));
		 * 
		 * for(WebElement Sub_li_iterator : Sub_li) {
		 * 
		 * Actions act1 = new Actions(driver);
		 * act1.moveToElement(Sub_li_iterator).build().perform();
		 * 
		 * System.out.println(Sub_li_iterator.getText());
		 * 
		 * } } }
		 */
	}
	
	

}
