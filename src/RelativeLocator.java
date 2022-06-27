import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		WebElement elem = driver.findElement(By.cssSelector("input[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("Label")).above(elem)).getText());
		
		WebElement dob = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		
		driver.findElement(with(By.tagName("input")).toLeftOf(By.xpath("//label[text()='Check me out if you Love IceCreams!']"))).click();
		
		driver.findElement(with(By.tagName("Input")).toRightOf(By.cssSelector("#inlineRadio1"))).click();

	}

}
