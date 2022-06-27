import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Checkbox {
		
		@Test
		public void CheckboxTest() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox']#checkBoxOption1"))).click();
		assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']#checkBoxOption1")).isSelected());
		
		driver.findElement(By.cssSelector("input[type='checkbox']#checkBoxOption1")).click();
		assertEquals(false,driver.findElement(By.cssSelector("input[type='checkbox']#checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("input[type='checkbox']")));
	}

}
