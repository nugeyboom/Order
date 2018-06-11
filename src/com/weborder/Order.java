package com.weborder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws IOException {
		Random rand = new Random();
		int num = rand.nextInt(101);
		
		String str = String.valueOf(num);
		
		BufferedReader br = new BufferedReader(new FileReader("MiddleName.csv"));
		String line ="";
		
		List<String> middleName = new ArrayList<>();
		while((line=br.readLine())!=null){
			middleName.add(line);
			
		}
		String name = middleName.get((new Random()).nextInt(middleName.size()));
		
		
		
		
		System.setProperty("webdriver.chrome.driver","/Users/nugebui/Documents/selenium dependencies/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[3]/a")).click();
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(str);
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("John"+" " +name+" "+ "Smith");
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
		StringBuilder s = new StringBuilder();
		 for (int i = 0; i < 5; i++) {
			s.append((int)(Math.random()*10));
		}
		
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(s);
		 
		 int card = (int)(Math.random()*3);
		    driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_"+card)).click();
		    
		    //Enter any card number. If you selected Visa, card number should start with 4. If you selected Master, card number should start with 5. If you selected American Express, card number should start with 3. New card number should be auto generated every time you run the test. Card numbers should be 16 digits for Visa and Master, 15 for American Express.
		    switch (card) {
		    case 0:
		      driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(4));
		      driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(rand.nextInt(10)));
		      break;
		    case 1: 
		      driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(5));
		      driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(rand.nextInt(10)));
		      break;
		    case 2: 
		      driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(Integer.toString(3)); 
		      break;
		    }
		    
		    StringBuilder ccnum = new StringBuilder();
		    
		    for (int i = 0; i < 14; i++) {
		      ccnum.append((int)(Math.random()*10));
		    }
		    
		    driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(ccnum.toString());
		    
		 
		 driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("04/20");
		 
		//driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
