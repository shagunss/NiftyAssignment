package co.NiftyTesting;

import java.io.File;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Test_1 {

			public static void main(String[] args) throws Exception {
				// TODO Auto-generated method stub

				System.setProperty("webdriver.chrome.driver", "C:/Users/KING/Downloads/chromedriver_win32/chromedriver.exe");
				
				ChromeOptions options = new ChromeOptions();
				
				options.addArguments("--disable-notifications");
				
				
				options.addArguments("--remote-allow-origins=*");
				
				WebDriver driver = new ChromeDriver(options);
				
//				driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
				
				//navigating to the website
				driver.get("https://zebra-qr.com/");
				
				//Test Case:1 Navigating to the registration page
				
//				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				Thread.sleep(3000);
				driver.findElement(By.xpath("//header/nav[@id='navbar-main']/div[1]/div[2]/a[2]")).click();
				
				//handling multiple windows
				
				String currentTab = driver.getWindowHandle();
				for(String tab : driver.getWindowHandles())
				{
					if(!tab.equals(currentTab))
					{
						driver.switchTo().window(tab);
					}
				}
				
				Thread.sleep(2000);
				
				driver.findElement(By.id("name")).sendKeys("ABC");
				
				driver.findElement(By.id("name_owner")).sendKeys("Shagun");
				
				JavascriptExecutor js = (JavascriptExecutor)driver;  
				js.executeScript("scrollBy(0, 300)"); 
				
				driver.findElement(By.id("email_owner")).sendKeys("sharmashagun9983@gmail.com");
				
				Thread.sleep(2000);
				
				
				
				WebElement countryField = driver.findElement(By.className("iti__selected-flag"));
				//Click on the country field to expand the country options
				countryField.click();
				
				WebElement countryOption = driver.findElement(By.xpath("//span[contains(text(),'India (भारत)')]"));

				// Click on the country option
				countryOption.click();
				
				Thread.sleep(2000);
				
				driver.findElement(By.id("phone_owner")).sendKeys("9315443958");
				
				driver.findElement(By.id("thesubmitbtn")).click();
				
				
				
				Thread.sleep(2000);
				//closing the new tab
				driver.close();
				
				driver.switchTo().window(currentTab);
				
				
				//Test case: 2 logging in as a owner
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//header/nav[@id='navbar-main']/div[1]/div[2]/a[1]")).click();
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//button[contains(text(),'Login as Owner')]")).click();
				
				

	}

}
