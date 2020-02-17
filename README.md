# git-demo

GitHub · Where software is built

http://barancev.github.io/
https://xpinjection.com/articles/waits-and-timeouts-in-webdriver/
https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
https://vike.io/ru/563322/
http://learn-automation.com/fluentwait-in-selenium-webdriver/
https://github.com/zviartouski/webdriver-from-scratch/blob/master/src/test/java/waits/WebDriverSyncDemoFluent.java


new WebDriverWait(driver, 30000).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver drive) {
                return drive.findElement(By.xpath("//*[@name='login']")).getAttribute("value").length() != 0;
           }
       });
		
    
    new WebDriverWait(driver, 30000).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver drive) {
                return drive.findElement(By.xpath("//*[@name='login']")).getText().length() != 0;
           }
       });
    
    
    
new WebDriverWait(driver, 30000).until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.xpath("//*[@name='login']"))				.getAttribute("value").length() != 0);
		
    
    
    new WebDriverWait(driver, 30000).until((ExpectedCondition<Boolean>) driver -> driver.findElement(By.xpath("//*[@name='login']"))				.getText().length() != 0);
    
    
    
    
new WebDriverWait(driver, 30000).until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(By.xpath("//*[@name='login']")), "value"));

new WebDriverWait(driver, 30000).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By
.xpath("//*[@id='myElem' and text() != '']")));


wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
             WebElement el = d.findElement(By.id("id_expense_amt"));
             String value = el.getAttribute('value');
             if(value.length() != 0 && !value.equals("0")) {
                return true;
             }
          }
});
	
	
	
	
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
 
import org.openqa.selenium.WebDriver;
 
import org.openqa.selenium.WebElement;
 
import org.openqa.selenium.chrome.ChromeDriver;
 
import org.openqa.selenium.support.ui.FluentWait;
 
import com.google.common.base.Function;
 
public class FluentWaitDEmo {
 
public static void main(String[] args) throws InterruptedException {
 
           // Start browser
 
          WebDriver driver = new ChromeDriver();
 
           // Maximize browser
 
          driver.manage().window().maximize();
 
     // Start the application 
 
     driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html");
 
// Click on timer so clock will start
 
          driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
 
 
 
// Create object of FluentWait class and pass webdriver as input
 
          FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
 
 
 
           // It should poll webelement after every single second
 
          wait.pollingEvery(1, TimeUnit.SECONDS);
 
 
 
           // Max time for wait- If conditions are not met within this time frame then it will fail the script
 
          wait.withTimeout(10, TimeUnit.SECONDS);
 
 
 
       // we are creating Function here which accept webdriver and output as WebElement-
 
          WebElement element = wait.until(new Function<WebDriver, WebElement>() {
 
 
 
                // apply method- which accept webdriver as input
 
               @Override
 
               
public WebElement apply(WebDriver arg0) 
{
 
      // find the element
 
       WebElement ele = arg0.findElement(By.xpath("//p[@id='demo']"));
 
// Will capture the inner Text and will compare will WebDriver
 
// If condition is true then it will return the element and wait will be over
 
                     if (ele.getAttribute("innerHTML").equalsIgnoreCase("WebDriver")) 
                      {
 
                          System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
 
                          return ele;
 
                     }
 
// If condition is not true then it will return null and it will keep checking until condition is not true
 
else {
        System.out.println("Value is >>> " + ele.getAttribute("innerHTML"));
 
           return null;
 
       }
 
               }
 
          });
 
// If element is found then it will display the status
 
          System.out.println("Final visible status is >>>>> " + element.isDisplayed());
 
     }
 
}	
