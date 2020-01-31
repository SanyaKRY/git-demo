package test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jaskier {	
	
  private static final String EMAIL="kartera42@gmail.com";
  private static final String PASSWORD="satx3q4fqb7m";	
  private static final String NECESSARY_SMILEY_FACE="money_mouth_face";
  private WebDriver driver;
		
  @BeforeMethod()
  public void signIn() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://github.com/");
	driver.findElement(By.xpath("//*[@href='/login']")).click();
	driver.findElement(By.xpath("//*[@name='login']")).sendKeys(EMAIL);
	driver.findElement(By.xpath("//*[@name='password']")).sendKeys(PASSWORD);
	driver.findElement(By.xpath("//*[@value='Sign in']")).click();    
  }

  @AfterMethod
  public void rollBack() {
    new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions
	    .invisibilityOf(driver.findElement(By.cssSelector("button.js-user-status-submit"))));	        
    driver.findElement(By.cssSelector("summary.js-toggle-user-status-edit")).click();
    driver.findElement(By.cssSelector("button.js-clear-user-status-button")).click();  
    driver.quit();
    driver = null;
  }

  @Test
  public void setSmileyFaceTest(){		
    driver.findElement(By.xpath("//*[@aria-label='View profile and more']//*[@class='avatar']")).click();
    driver.findElement(By.cssSelector("summary.js-toggle-user-status-edit")).click();              
	    
    try {
	  Thread.sleep(1000);
	} catch (InterruptedException e) {			
	  e.printStackTrace();
	}
	    
    driver.findElement(By.cssSelector("button.js-toggle-user-status-emoji-picker")).click(); 
    List<WebElement> smileysFace =  driver.findElements(By.xpath("//*[@aria-label='People Emoji']//g-emoji"));  
    WebElement smileyFace = smileysFace.stream()
    	.filter(smiley -> smiley.getAttribute("alias").contains(NECESSARY_SMILEY_FACE))
        .findFirst()
        .orElse(null);
    smileyFace.click();        
    driver.findElement(By.cssSelector("button.js-user-status-submit")).click();  
    Assert.assertTrue(driver.findElement(By.xpath("//*[@class='g-emoji']")).getAttribute("alias")
        .contains(NECESSARY_SMILEY_FACE), "Beda"); 
  }
	    
}

