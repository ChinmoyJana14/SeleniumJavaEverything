import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinkCheck {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		  List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	      SoftAssert softAssert =new SoftAssert();
	      	for(WebElement link : links)
	      		{
		          String url= link.getAttribute("href");
		          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
		          conn.setRequestMethod("HEAD");
		          conn.connect();
		          int respCode = conn.getResponseCode();
		          System.out.println(respCode + link.getText());
		          softAssert.assertTrue(respCode<400, "The link with Text :"+link.getText()+" is broken with code" +respCode);
	       }
	      	softAssert.assertAll();
	}

}
