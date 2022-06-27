import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sandbox {

	
	@Test
	public void Test01() {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		String text=null;
		
		List<WebElement> checkboxLabels = driver.findElements(By.xpath("(//div[@id='checkbox-example']/fieldset/label)"));
		 for (WebElement webElement : checkboxLabels) {
			if (webElement.findElement(By.tagName("input")).isSelected()) {
				 text = webElement.getText();			 
			}
		}
		 System.out.println(text);
		 WebElement elem = driver.findElement(By.id("dropdown-class-example"));
		 Select dropDwon = new Select(elem);
		 dropDwon.selectByVisibleText(text);
		 
		 driver.findElement(By.id("name")).sendKeys(text);
		 driver.findElement(By.id("alertbtn")).click();
		 
		 assertTrue(driver.switchTo().alert().getText().contains(text));
		 
	}

}
