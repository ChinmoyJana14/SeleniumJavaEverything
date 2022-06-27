import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		
		String requiredDate = "1 December 2022";
		String requiredMonth = requiredDate.split(" ")[1];
		String requiredday = requiredDate.split(" ")[0];
		driver.findElement(By.id("travel_date")).click();
		
		
		while(!driver.findElement(By.cssSelector("div.datepicker-days .datepicker-switch")).getText().contains(requiredMonth)) {
			driver.findElement(By.cssSelector("div.datepicker-days .next")).click();
		}
		
		driver.findElement(By.xpath("//td[@class='day' and contains(text(),'" +requiredday+ "')]")).click();		
		
	}

}
