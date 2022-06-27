import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("a")).size());		
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		WebElement columnFooterDriver = footerDriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		int links = columnFooterDriver.findElements(By.tagName("a")).size();
		System.out.println(links);
		
		for(int i = 1; i<links; i++) {
			
			String clickOnTheLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);			
			columnFooterDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnTheLinkTab);	
			
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(links));
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		it.next();//For parent window
	
		  while (it.hasNext()) {
			  		driver.switchTo().window(it.next());
			  		System.out.println("Child Window Title " + driver.getTitle());
	        }

	}

}
