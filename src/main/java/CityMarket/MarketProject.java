package CityMarket;

import java.sql.DriverManager;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MarketProject {

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

		Thread.sleep(8000);
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("milk");
		Thread.sleep(7000);
		driver.findElement(By.xpath("//button[@class='action search']")).click();

		Thread.sleep(20000);

		WebElement wrapper_list = driver.findElement(
				By.xpath("//div[normalize-space(@class)='products wrapper cp__products-wrapper grid products-grid']"));
		List<WebElement> ol_wrapper_list = wrapper_list.findElements(By.tagName("ol"));

		ProductSearch:

		for (WebElement ol_wrapper_list_iterator : ol_wrapper_list) {

			List<WebElement> li_item_container = ol_wrapper_list_iterator.findElements(By.tagName("li"));

			for (WebElement li_item_container_iterator : li_item_container) {

				List<WebElement> li_1 = li_item_container_iterator
						.findElements(By.xpath(".//div[normalize-space(@class)='product-item-info product__card']"));

				for (WebElement card_details : li_1) {

					List<WebElement> sub_div = card_details.findElements(By.xpath(
							".//div[normalize-space(@class)='product details product-item-details product__card-details']"));

					for (WebElement sub_tag_strong : sub_div) {

						List<WebElement> sub_strong = sub_tag_strong.findElements(By.xpath(
								".//strong[normalize-space(@class)='product name product-item-name product__item-title']"));

						for (WebElement sub_strong_iterator : sub_strong) {

							Actions act = new Actions(driver);

							act.moveToElement(sub_strong_iterator).build().perform();

							if (sub_strong_iterator.getText().contains("Lactaid Lactose Free Whole")) {

								act.moveToElement(sub_strong_iterator).build().perform();

								sub_strong_iterator.click();

								break ProductSearch;
							}

						}
					}
				}
			}
		}

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
		
		Thread.sleep(10000);

		
		driver.findElement(By.xpath("//button[normalize-space(@type)='submit'][normalize-space(@title)='Add'][contains(text(),'+')]")).click();

		// clicking on cart
		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[normalize-space(@class)='action showcart icon icon-main-cart']")).click();
		
		//clicking on hamburger
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//span[contains(@class,'hamburger')]")).click();
		
		WebElement Category_List = driver.findElement(By.xpath("//ul[normalize-space(@class)='nav-primary mmenu__parent-list']/li"));
		List<WebElement> All_Category_Element_List = Category_List.findElements(By.tagName("div"));
		
		for(WebElement All_Category_Element_List_iterator : All_Category_Element_List) {
			
			System.out.println(All_Category_Element_List_iterator.getText());
			
			if( All_Category_Element_List_iterator.getText().contains("Beverages")) {
				
				System.out.println("ok");
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

		/*
		 * WebElement element_product_Wraper_list = driver.findElement(By
		 * .xpath("//div[normalize-space(@class) = 'products wrapper cp__products-wrapper grid products-grid']"
		 * )); List<WebElement> element_product_item_wraper =
		 * element_product_Wraper_list.findElements(By.tagName("ol"));
		 * 
		 * ProductSearch:
		 * 
		 * for (WebElement element_product_item_wraper_itrator :
		 * element_product_item_wraper) {
		 * 
		 * List<WebElement> element_product_item_container =
		 * element_product_item_wraper_itrator .findElements(By.tagName("li")); for
		 * (WebElement element_product_item_container_itrator :
		 * element_product_item_container) {
		 * 
		 * List<WebElement> element_product_item_info_container =
		 * element_product_item_container_itrator .findElements(By.
		 * xpath(".//div[normalize-space(@class) = 'product-item-info product__card']"))
		 * ; for (WebElement element_product_item_info_cart :
		 * element_product_item_info_container) {
		 * 
		 * List<WebElement> element_product_item_info_details_cart =
		 * element_product_item_info_cart .findElements(By.xpath(
		 * ".//div[normalize-space(@class) = 'product details product-item-details product__card-details']"
		 * )); for (WebElement element_product_item_info_cart_itrator :
		 * element_product_item_info_details_cart) {
		 * 
		 * List<WebElement> element_product_item_info_details_cart_name =
		 * element_product_item_info_cart_itrator .findElements(By.xpath(
		 * ".//strong[normalize-space(@class) = 'product name product-item-name product__item-title']"
		 * ));
		 * 
		 * for (WebElement element_product_item_info_details_cart_name_itrator :
		 * element_product_item_info_details_cart_name) { Actions act = new
		 * Actions(driver);
		 * act.moveToElement(element_product_item_info_details_cart_name_itrator).build(
		 * ).perform();
		 * 
		 * if (element_product_item_info_details_cart_name_itrator.getText()
		 * .contains("Skim Plus 100% Fat Free Milk - 64fl oz")) {
		 * act.moveToElement(element_product_item_info_details_cart_name_itrator).build(
		 * ) .perform(); element_product_item_info_details_cart_name_itrator.click();
		 * 
		 * break ProductSearch; }
		 * 
		 * }
		 * 
		 * } } } }
		 */
		 

	}

}
