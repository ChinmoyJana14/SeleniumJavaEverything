import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Scroll {

	@Test
	public void Test1() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> nos = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum =0;
		for (WebElement webElement : nos) {
			
			sum = sum + Integer.parseInt(webElement.getText());
		}
		System.out.println(sum);
		assertTrue(driver.findElement(By.cssSelector(".totalAmount")).getText().contains(Integer.toString(sum)));
		
	}
}
