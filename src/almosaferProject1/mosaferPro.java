package almosaferProject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class mosaferPro {
	
	WebDriver driver = new ChromeDriver();
	String webSite = "https://www.almosafer.com/en";
	SoftAssert softassert = new SoftAssert();
	
	
	@BeforeTest
		public void mySetUp(){
		driver.get(webSite);
		driver.manage().window().maximize();
		WebElement welcomeMsg =  driver.findElement(By.xpath("//button[normalize-space()='Kingdom of Saudi Arabia, SAR']"));
		welcomeMsg.click();
		
	}
	
	
	@Test(priority=1)
     public void langugeTest() throws InterruptedException{
		
		String actiualLang = driver.findElement(By.tagName("html")).getAttribute("lang");
		String expictedLang = "en";
		Thread.sleep(2000);
		softassert.assertEquals( actiualLang, expictedLang, "hamzah");
		
		
	}
	@Test(priority=2)
	public void checkCurunty() {
		
		String actiualCurunty = driver.findElement(By.xpath("//button[normalize-space()='SAR']")).getText();
		
		String expictedCurunty = "SAR";
		
		softassert.assertEquals(actiualCurunty, expictedCurunty,"hamzah abdallh");
	}
	
	
	
	
	@AfterTest
      public void closeWebsite(){
		softassert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
