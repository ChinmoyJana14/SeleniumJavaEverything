import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.cssSelector("a#nav-link-accountList"))).build().perform();
		
		a.moveToElement(driver.findElement(By.cssSelector("input#twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
	}

}
