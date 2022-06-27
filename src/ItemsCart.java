import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.checkerframework.checker.units.qual.Length;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemsCart {
	
	public static WebDriverWait wait;

	public static void main(String[] args) {
		
		String[] items = {"Walnuts", "Brocolli", "Water Melon", "Cucumber"};
		//String[] srr = new String[3];
		
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		addToCart(driver, items);

		driver.findElement(By.cssSelector("a.cart-icon[href$='#']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}
		
	
	public static void addToCart(WebDriver driver, String[] strArray) {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));		
		List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("h4.product-name")));
		List<String> veggies = Arrays.asList(strArray);
		
		int j=0;
		for(int i=0; i<products.size(); i++) {
			
			if(veggies.contains(products.get(i).getText().split("-")[0].trim())) {
				j++;
				//Do not rely on Text locator like //button[contains(text(),'ADD TO CART')]
				driver.findElements(By.xpath("//div[@class='product-action']/button[@type='button']")).get(i).click();
				//break; it is required for 1 veggie only
				if(j==strArray.length) {
					break;
				}
			}
		}
	}

}
