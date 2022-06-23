package week6.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		login();

	}

	public void login() {

		// enter username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		// enter password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// click login
		driver.findElement(By.className("decorativeSubmit")).click();

	}

	@AfterMethod
	public void postCondition() {
		driver.close();
	}

}
