import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class Miscelleanous {
	
	@Test
	public void test1() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		
		FirefoxOptions options2 = new FirefoxOptions();
		options2.setAcceptInsecureCerts(true);
		
		EdgeOptions options3 = new EdgeOptions();
		options3.setAcceptInsecureCerts(true);
		
		Proxy proxy = new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy", proxy);
		
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");// it should navigate to home page after clicking any element
	}

}
