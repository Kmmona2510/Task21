package Task21;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) { 
		// Launch the browser
		WebDriver driver =new ChromeDriver();  
		
		//load the url
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		
		
		//maximize the window
		driver.manage().window().maximize();    
		
		
		// use implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); 
		
		 //click the text to the next window
		driver.findElement(By.linkText("Click Here")).click(); 
		
	//using window handle method to handles the windows  it returns the set
	Set<String> window = driver.getWindowHandles();         
		 
	//convert set to list for get the window
	List<String>  windowlist =new ArrayList<>(window);            
		
		windowlist.get(1);
		
	
	//switch the window using index 
	 driver.switchTo().window(windowlist.get(1));                     
		
	String newwindow = driver.findElement(By.tagName("h3")).getText();   
					
	//verify the window can switch to print the text in child window
	if(newwindow.equals("New Window")) {								
		System.out.println("The text present in the page:" +newwindow);
	}	
		else
	{
		System.out.println("The page not in new window");
	}
	
	//close the child window
    	driver.close();       
    	
    //switch to the parent window
	driver.switchTo().window(windowlist.get(0));         
	
	String parentwindow = driver.findElement(By.tagName("h3")).getText();  
	
	//verify the parent window is active
	if(parentwindow.equals("Opening a new window"))	{					 
	
	System.out.println("The Parent Window is active:" +parentwindow);
	}	
		else {
		System.out.println("The parent window not active");
	}
	
	//close the browser
     driver.quit();                         
		
		
		
		
		
		
	}

}
