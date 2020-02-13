# git-demo

GitHub · Where software is built

http://barancev.github.io/


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
