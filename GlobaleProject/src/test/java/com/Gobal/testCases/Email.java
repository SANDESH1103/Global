package com.Gobal.testCases;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import javax.activation.MailcapCommandMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Email {
	static WebDriver driver ;
	@Test
public static void  mail()throws InterruptedException, AWTException {
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
	
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.manage().window().maximize();
	driver.get("https://www.globalindustrial.com/");
	//Thread.sleep(1000);
	try {
		boolean isPopupVisible=driver.findElement(By.xpath("//button[@class='ltkpopup-close']")).isEnabled();
		if (isPopupVisible) {
		driver.findElement(By.xpath("//button[@class='ltkpopup-close']")).click();
		System.out.println("popup close sucessfully");

		}

		} catch (Exception e) {
		System.out.println("Coupancode popup not present");
		}
	
	driver.findElement(By.xpath("//a[contains(text(),'QUICK ORDER')]")).click();
	
	
	

	//driver.findElement(By.xpath("(//*[@type='button'])[3]")).click();
	scrollIntoView();
	driver.findElement(By.xpath("//a[@class='uploadDocsLink']")).click();
	 StringSelection sel = new StringSelection("C:\\Users\\Sandesh Sonawane\\Downloads\\Quick_Order_Template.xlsx");
	 
	   // Copy to clipboard
	
	
	        
//	  // Press Enter 
//	 robot.keyPress(KeyEvent.VK_ENTER);
//	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 driver.findElement(By.xpath("//div[@class='span']")).click();
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	 System.out.println("selection" +sel);
	Robot robot=new Robot();
	
	 // Press Enter
	 robot.keyPress(KeyEvent.VK_CONTROL);

	// Release Enter
	 robot.keyRelease(KeyEvent.VK_C);
	 
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_C);
	Thread.sleep(500);
	  // Press CTRL+V
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);

	// Release CTRL+V
	 
	 
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	//driver.findElement(By.xpath("(//*[@class='UI']//table//td//div/div//span)[2]")).click();
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	
}

public static void scrollIntoView(){
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollTo(0,1500)");
}
}
