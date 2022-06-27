import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Calendar {
	
	static WebDriver driver;
	static WebDriverWait wait; 

		
	@BeforeSuite
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\Software\\Grid\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	
	@Test
	public void CheckboxTest() {
	
	driver.get("https://www.spicejet.com/");
	driver.manage().window().maximize();
	
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-testid='to-testID-origin']"))).click();	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='International']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'MCT')]"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			"//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-u8s1d r-8fdsdq']//div[text()='International']"))).click();
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			"//div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-1rjd0u6 r-1g94qm0 r-u8s1d r-8fdsdq']//div[text()='DXB']"))).click();
	//current month: (//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[1]
	//System.out.println(	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[1]"))).getText());
	//System.out.println(	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[2]"))).getText());
	//System.out.println(	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[3]"))).getText());

	}
	
	@Test
	public void ValidateEnable() {
		System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")).getAttribute("style"));
		driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")).getAttribute("style"));
		driver.findElement(By.xpath("//div[@data-testid='one-way-radio-button']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")).getAttribute("style"));

		if(driver.findElement(By.xpath("//div[@data-testid='return-date-dropdown-label-test-id']/div[@class='css-76zvg2 css-bfa6kz r-1862ga2 r-1gkfh8e']")).getAttribute("style").contains("0.5")) 
		{
			System.out.println("The return calendar is disabled");
			Assert.assertTrue(true);
		} else 
		{
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void SelectFromCalendarTest() throws ParseException {

		//SelectFromCalendar("21 December 2022");
		SelectFromCalendar2("02 May 2023");

	}
		
	 public static void SelectFromCalendar(String strDate) {
			String MonthOfProvidedDate = strDate.split(" ")[1];
			String Day = strDate.split(" ")[0];
			int i=1;
			int j=2;
			while(true){
				WebElement CurrentMonthElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[" + i + "]")));
				WebElement NextMonthElem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-adyw6z r-1kfrs79'])[" + j + "]")));

				String CurrentMonth = CurrentMonthElem.getText().split(" ")[0];
				String NextMonth = NextMonthElem.getText().split(" ")[0];
				
				if(CurrentMonth.equalsIgnoreCase(MonthOfProvidedDate)){
					driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(text(),'" + Day + "')])[" + i + "]")).click();
					break;
				} else if(NextMonth.equalsIgnoreCase(MonthOfProvidedDate)) {
					driver.findElement(By.xpath("(//div[@class='css-76zvg2 r-homxoj r-ubezar r-16dba41' and contains(text(),'" + Day + "')])[" + j + "]")).click();
					break;
				}else {
				    driver.findElement(By.xpath
				    		("//div[@data-testid='undefined-calendar-picker']//div[@data-focusable='true' and contains(@class,'r-u8s1d r-11xbo3g r-1v2oles r-1otgn73 r-16zfatd')]")).click();
				    i++;j++;
				}
			}
	 }
	 
	 public static void SelectFromCalendar2(String strDate) {
		 
			String MonthOfProvidedDate = strDate.split(" ")[1].trim();
			String DayOfProvidedDate = strDate.split(" ")[0].trim();
			String YearOfProvidedDate = strDate.split(" ")[2].trim();
			String strPattern = "^0+(?!$)";
			String strDayOfProvidedDate = DayOfProvidedDate.replaceAll(strPattern, "");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='undefined-month-" + MonthOfProvidedDate + "-" + YearOfProvidedDate + "']//div[@data-testid='undefined-calendar-day-" + strDayOfProvidedDate + "']"))).click();

	 }
	 
	 @Test
	 public void Calendar3Select() {
			driver.get("https://rahulshettyacademy.com/angularpractice/");
			driver.manage().window().maximize();
	 }
	 
	 
	
}
