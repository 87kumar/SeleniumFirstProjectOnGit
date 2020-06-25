package RosatiProject;

import java.awt.List;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class RosatiQc {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"D:\\Eclipse_Oxygen\\Selenium_Practice\\Ramesh\\Driver\\geckodriver.exe");

		FirefoxProfile obj = new FirefoxProfile();
		obj.setPreference("geo.enabled", false);
		obj.setPreference("geo.provider.use_corelocation", false);
		obj.setPreference("geo.prompt.testing", false);
		obj.setPreference("geo.prompt.testing.allow", false);

		DesiredCapabilities obj1 = new DesiredCapabilities().firefox();

		obj1.setCapability(FirefoxDriver.PROFILE, obj);

		FirefoxDriver driver = new FirefoxDriver(obj1);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://qc-rosati.munchadoshowcase.biz/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//ul[contains(@class,'header__menu')]//a[contains(@content,'Login')]")).click();

		// handling window

		String parentwin = driver.getWindowHandle();
		String childwin = null;

		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();

		while (it.hasNext()) {
			childwin = it.next();
		}

		driver.switchTo().window(childwin);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class = 'mat-tab-label-content' and text()='SIGN UP']")).click();
		driver.findElement(By.xpath("//input[@placeholder='First Name*']")).sendKeys("Ramesh");
		driver.findElement(By.xpath("//input[@placeholder='Email*']")).sendKeys("rkumar@munchado.in");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@placeholder='Confirm Password']")).sendKeys("12345678");
		// driver.findElement(By.xpath("//button[@type='submit']")).click();

		// returning back to signin

		driver.findElement(By.xpath("//div[@class='mat-tab-label-content'][contains(.,'SIGN IN')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Email Or Phone Number']")).sendKeys("rkumar@munchado.in");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//a[text()=' Menu / Order Online ' and @class='header__online-order']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[@class='order-tabs__img-container icon-carryout-order']")).click();
		driver.findElement(By.xpath("//a[text()='View All']")).click();
		Thread.sleep(5000);

		// Drop-down handling

		/*
		 * WebElement element =
		 * driver.findElement(By.xpath("//div[@class='mat-select-arrow-wrapper']"));
		 * element.click(); Thread.sleep(7000); WebElement dropparent =
		 * driver.findElement(By.
		 * xpath("//div[contains(normalize-space(@class),'mat-select-panel-wrap ng-tns-c24-14 ng-trigger ng-trigger-transformPanelWrap ng-star-inserted')]"
		 * )); java.util.List<WebElement> DropDownList =
		 * dropparent.findElements(By.tagName("mat-option")); for(WebElement obj2 :
		 * DropDownList) { if(obj2.getText().contains("Chicago  Uptown")) {
		 * obj2.click(); }
		 */

		driver.findElement(By.xpath("//div[@class='arrow__step arrow__next2']//span[@class='icon-arrow-next']"))				.click();
		driver.findElement(By.xpath("//div[@class='arrow__step arrow__next']//span[@class='icon-arrow-next']")).click();
		driver.findElement(By.xpath("//a[text()=' Start your Order ']")).click();

		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[@class='icon-search hidden-xs']")).click();
		
		driver.findElement(By.id("mat-input-7")).sendKeys("pizza");
		Thread.sleep(4000);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[contains(normalize-space(@class),'btn btn__default btn-xs ng-star-inserted')]"))).build().perform();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(normalize-space(@class),'btn btn__default btn-xs ng-star-inserted')]")).click();

	}
}
