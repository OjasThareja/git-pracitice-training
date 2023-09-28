package temp;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SwiggyWebApplication 
{
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void Testcase() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement location_textbox= driver.findElement(By.id("location"));
		location_textbox.sendKeys("Chandni Chowk");
		Thread.sleep(4000);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		List<WebElement> Location_set = driver.findElements(By.xpath("//span[@class='_2W-T9']"));
		
		for(WebElement loc : Location_set)
		{
			if(loc.getText().contains("Chandni Chowk"))
			{
				loc.click();
				break;
			}
		}
		
		Thread.sleep(4000);
		
		if(driver.findElement(By.id("all_restaurants")).isDisplayed())
		{
			
		}
		else
		{
			
		}
		
		driver.findElement(By.xpath("//span[text()='Search']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Search for restaurants and food']")).sendKeys("Dosa");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//b[text()='Dosa']")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@class='styles_restaurant__20fB8']"))));
		
		String RestaurantName = driver.findElement(By.xpath("//div[@class='styles_restaurantName__5VIQZ styles_restaurantNameBold__2OmFY']")).getText();	
		String FoodName = driver.findElement(By.xpath("//h3[@class='styles_itemNameText__3ZmZZ']")).getText();	
		
		driver.findElement(By.xpath("//div[text()='ADD']")).click();
		
		Thread.sleep(4000);
		
		if(driver.findElements(By.xpath("//div[@class='draJe']")).size()!=0)
		{
			
			//if(driver.findElement(By.xpath("//input[@type='checkbox']")).getAttribute("value").equalsIgnoreCase("0"))
			//{
			//	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
			//}
			
			driver.findElement(By.xpath("//span[text()='Add Item']")).click();
			Thread.sleep(4000);
		}
		
		
		driver.findElement(By.xpath("//span[text()='Cart']")).click();
		Thread.sleep(5000);
		if(driver.findElements(By.xpath("//span[text()='Secure Checkout']")).size()!=0)
		{
			System.out.println("Checkoutpage opened");
		}
		else
		{
			System.out.println("Checkoutpage NOT opened");
		}
		
		if(driver.findElements(By.xpath("//div[text()='"+FoodName+"']")).size()!=0)
		{
			System.out.println("Food Item successfully added in cart");
			System.out.println(driver.findElement(By.xpath("//div[text()='"+FoodName+"']")).getText());
		}
		else
		{
			System.out.println("Food Item Not added in cart");
		}
		
		String R_name = driver.findElement(By.xpath("//div[@class='V7Usk']")).getText();
		if(RestaurantName.contains(R_name) || R_name.contains(RestaurantName))
		{
			System.out.println("Restaurant successfully added in cart");
			System.out.println(driver.findElement(By.xpath("//div[@class='V7Usk']")).getText()+"--"+RestaurantName);
		}
		else
		{//
			System.out.println(driver.findElement(By.xpath("//div[@class='V7Usk']")).getText()+"--"+RestaurantName);
			System.out.println("Restaurant NOT added in cart");
		}
		
		
	}
}
