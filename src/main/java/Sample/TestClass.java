package Sample;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"D:\\Eclipse_Oxygen\\Selenium_Practice\\Ramesh\\Driver\\geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		// Thread.sleep(20000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();

		// Thread.sleep(10000);

		driver.findElement(By.xpath("//a[@class='login'][contains(.,'Sign in')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rkb.kumar.87@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//span[contains(.,'Sign in')]")).click();

		// searching item

		driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("Printed dress");
		driver.findElement(By.xpath("//button[contains(@name,'submit_search')]")).click();

		/*
		 * //Getting tooltip text WebElement element =
		 * driver.findElement(By.xpath("(//img[@title='Printed Summer Dress'])[2]"));
		 * 
		 * Actions builder = new Actions(driver);
		 * 
		 * builder.moveToElement(element).build().perform();
		 * 
		 * 
		 * //getting tooltip text
		 * 
		 * String tooltip_text = element.getText();
		 * 
		 * //printing tooltip text
		 * 
		 * System.out.println("ToolTip Message of the product"+tooltip_text);
		 */

		driver.findElement(By.xpath("(//img[contains(@alt,'Printed Summer Dress')])[1]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Add to cart')]")).click();
		
		//handling popup or child window
		
		String parentWinHan = driver.getWindowHandle(); //storing parent window
		String childWinHan = null;
		
		Set<String> handles = driver.getWindowHandles(); //get all window handles here
		Iterator<String> it = handles.iterator();
		while(it.hasNext()) {
			childWinHan=it.next();
		}
		
		driver.switchTo().window(childWinHan); //here switching on child window
		
		//performing action on child window
		
		driver.findElement(By.xpath("//span[contains(.,'Proceed to checkout')]")).click();
		
		//Here switching back to parent window
		
		driver.switchTo().window(parentWinHan);
		
		//Proceed to checkout
		
		driver.findElement(By.xpath("(//span[contains(.,'Proceed to checkout')])[2]")).click();
		
		
		

		// driver.close();

	}

}
