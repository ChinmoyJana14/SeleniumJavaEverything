import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GlobalValues {

	public static void main(String[] args) throws IOException {
		
		FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator +"src\\data.properties");
		//System.out.println("Present Project Directory : "+ System.getProperty("user.dir") + File.separator +"src\\data.properties");
		Properties property = new Properties();
		property.load(inputStream);
		System.out.println(property.getProperty("url"));
		//run time update
		property.setProperty("browser", "Firefox");
		System.out.println(property.getProperty("browser"));
		//For physical update
		FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+ File.separator +"src\\data.properties");
		property.store(outputStream, null);
	}

}
