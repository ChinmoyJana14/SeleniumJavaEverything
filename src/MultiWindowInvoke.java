import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiWindowInvoke {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		//New Window/TAB Invoke
		//driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW); //we can use this too
		Set<String> windows = driver.getWindowHandles();//["ParentWindowId","ChildWindowId"]
		Iterator<String> it = windows.iterator();
		String parentWindow = it.next();//For parent window
		String childWindow =it.next();//For child window
		driver.switchTo().window(childWindow);
		driver.get("https://rahulshettyacademy.com");
		String s = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentWindow);
		WebElement nameBox = driver.findElement(By.cssSelector("input[name='name']"));
		nameBox.sendKeys(s);	
		//Partial Screenshot
		File scrFile = nameBox.getScreenshotAs(OutputType.FILE);//Partial Screenshot
		FileUtils.copyFile(scrFile, new File("C:\\Repository\\SeleniumJava\\SeleniumTextScreenshot.jpg"));
		//Get height width
		System.out.println(nameBox.getRect().getHeight());
		System.out.println(nameBox.getRect().getWidth());
		System.out.println(nameBox.getRect().getDimension());
		System.out.println(nameBox.getRect().getDimension().getHeight());

		
	}

}
