package LoginFacebook;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenApplication {
	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Test
	public void idLocator() {
		driver.findElement(By.id("email")).sendKeys("dsc");
		driver.findElement(By.id("email")).clear();
	}
	@Test
	public void linkText() {
		driver.findElement(By.linkText("Forgot password?")).click();
	}
	@Test
	public void partialLinkText() {
		driver.navigate().back();
		driver.findElement(By.partialLinkText("Create")).click();

}}
