package Task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();   //Launch the Browser
		
	 	driver.manage().window().maximize();       //Maximize the window
	 	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  //use wait
		
		driver.get("https://the-internet.herokuapp.com/iframe");   //launch the url
		
		WebElement frame =	driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));      //find the frame element
		
		driver.switchTo().frame(frame);          //switch the frame using frame element 
		
		driver.findElement(By.tagName("P")).clear();     //clear the text
		
	    driver.findElement(By.tagName("P")).sendKeys("Hello People");     //type the text
		
		driver.close();           //close the tab

	}

}
