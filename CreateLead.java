package week6.day1.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead extends TestBase {

	@Test
	public void createLead() throws InterruptedException {
		
		// click crm/sfa
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Simon");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Steward");

		WebElement eleSourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select selectSource = new Select(eleSourceDropDown);

		selectSource.selectByVisibleText("Conference");

		driver.findElement(By.name("submitButton")).click();

		Thread.sleep(5000);

		System.out.println(driver.findElement(By.id("viewLead_firstName_sp")).getText());
	}

}
