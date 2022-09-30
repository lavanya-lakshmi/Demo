package com.selenium.demo;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {

     WebDriverManager.chromedriver().browserVersion("106.0.5249.61").setup();
     WebDriver driver=new ChromeDriver();
     driver.manage().window().maximize();
     
     String year="2022";
     String month="Oct";
     String date="5";
    		 
     driver.get("https://www.easemytrip.com/");
      Thread.sleep(9000);
     driver.findElement(By.linkText("FLIGHTS")).click();
     driver.findElement(By.id("FromSector_show")).click();
     driver.findElement(By.id("spn12")).click();
     
    driver.findElement(By.id("Editbox13_show")).click();
    WebElement textbox = driver.findElement(By.id("a_Editbox13_show"));
    textbox.sendKeys("pune");
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    
    driver.findElement(By.xpath("//div[@class='mflexcol']//div//p//span[@id='spnPune']")).click();
    
    //calender
    driver.findElement(By.id("dvfarecal")).click();
    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    
   // month and year selection
    while(true){
    	
    
    String monthyear = driver.findElement(By.xpath("//div[@class='month2']")).getText();
    String arr[]= monthyear.split(" ");
    String getmonth= arr[0];
    String getyear= arr[1];
    
    if(getmonth.equalsIgnoreCase(month) && getyear.equalsIgnoreCase(year))
    	break;
    else
    	driver.findElement(By.xpath("//div//img[@id='img2Nex']")).click();
    }
    
    //date selection
    List<WebElement> dates=driver.findElements(By.xpath("//div[@class='box']//div[@class='days']//li[@style='visibility:show']"));
    for(WebElement ele : dates)
    {
    	String dt[]=ele.getText().split("\n");
    	System.out.print(dt[0]);
    
    if(dt[0].equals(date))	{
    	System.out.println(" date found");
    	ele.click();
    	break;
     }
    else
    	System.out.println(" not found");
    }
    //search button
    driver.findElement(By.xpath("//div[@class='fss_flex search_colm']/button[@class='srchBtnSe']")).click();
    // check boxes
    driver.findElement(By.id("pAir India")).click();
    driver.findElement(By.id("chkTimeDep")).click();
    
    //price
    String generalprice =driver.findElement(By.xpath("//div[@class='ai-rs']//span[@class='fnt17 ng-binding ng-scope']")).getText();
    System.out.println("flight ticket : "+generalprice);
    String price=driver.findElement(By.xpath("/html/body/form/div[9]/div[5]/div/div[2]/div[2]/div/div/div[4]/div[20]/div[1]/div[1]/div[5]/div[1]/div[2]")).getText();
    System.out.println("Air India flight ticket : "+price);
  
   
   
  }
}
