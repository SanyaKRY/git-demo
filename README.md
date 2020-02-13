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
