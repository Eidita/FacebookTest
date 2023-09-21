package assertion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	
	@BeforeTest
	public void openApp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void assertTest() {
		String actualUrl="https://www.facebook.com/";
		String expectedUrl=driver.getCurrentUrl();
		System.out.println("Facebook expected Url is" +expectedUrl);
		Assert.assertEquals(actualUrl, expectedUrl);
		
		String actualTitle="Facebook - log in or sign up";
		String expectedTitle=driver.getTitle();
		System.out.println("Facebook expected Title is" +expectedTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	@Test
	public void loginTest() {
		driver.findElement(By.id("email")).sendKeys("Eidita");
		driver.findElement(By.name("pass")).sendKeys("abcd");
		driver.findElement(By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy' and 'name=login']")).click();
		
	}
	
	

}
