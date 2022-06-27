import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		/*
		driver.get("https://www.rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		String ParentWindowId = it.next();
		String ChildWindowId = it.next();
		driver.switchTo().window(ChildWindowId);
		String userName = driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].split("with")[0].trim();
		driver.switchTo().window(ParentWindowId);
		driver.findElement(By.id("username")).sendKeys(userName);
		*/
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href*='/windows']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href*='/windows/new']"))).click();
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		String ParentWindowId = it.next();
		String ChildWindowId = it.next();
		driver.switchTo().window(ChildWindowId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		driver.switchTo().window(ParentWindowId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

		
	}

}
