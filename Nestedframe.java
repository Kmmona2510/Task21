package Task21;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nestedframe {

	public static void main(String[] args) throws InterruptedException {
		
		//Launch the Browser
		WebDriver driver = new ChromeDriver();
		
		//Load the url		
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//use implicitly wait for time dealy to find elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
		//Switch to top frame
		WebElement topFrame=driver.findElement(By.xpath("//frame[@name='frame-top']"));
		
		driver.switchTo().frame(topFrame);
		
		
		//verify that three frames in bottom frame
		if(topFrame.equals(topFrame)) {
			System.out.println("The frame is in top frame and it has three frames");
			
		}  else {
			System.out.println("Its not a top frame");
		}
		
		
		//switch to left frame
	WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
	
	driver.switchTo().frame(leftFrame);
	
	String leftText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
	
	
	//verify that the left frame text
	if(leftText.contains("LEFT")) {
		
		System.out.println("The frame switch to LeftFrame");
		
	}  else {
		System.out.println("The frame not switch");
	}
	
	//switch to parent frame
	driver.switchTo().parentFrame();
	
	
	//switch to middle frame
	WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
	
	driver.switchTo().frame(middleFrame);
	
	//verify the middle frame text
	
	String middleText = driver.findElement(By.xpath("//div[@id='content']")).getText();
	
	if(middleText.contains("MIDDLE")) {
		
		System.out.println("The frame switch to MiddletFrame");
		
	}  else {
		System.out.println("The frame not switch");
	}
		
	
	//switch to parent frame
	driver.switchTo().parentFrame();
	
	//switch to right frame
	
	WebElement rightFrame = driver.findElement(By.xpath("//frame[@name='frame-right']"));
	
	driver.switchTo().frame(rightFrame);
	
	//verify the text of right frame
	
	String rightText = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
	
	if(rightText.contains("RIGHT")) {
		
		System.out.println("The Frame Switch to RighFrame");
	} else {
		System.out.println("The Frame not Switch");
	}
	
	//switch to default content
	
	 driver.switchTo().defaultContent();
	 
	 //switch to bottom frame
	
	 WebElement bottomFrame = driver.findElement(By.xpath("(//frame[@scrolling='no'])[2]"));
	 
	 driver.switchTo().frame(bottomFrame);
	
	 System.out.println("bottom frame switched");
	
	 
	 //verify that bottom frame text
	 String bottom = driver.findElement(By.tagName("body")).getText();

	System.out.println(bottom);
	 
	if(bottom.contains("BOTTOM")) {
		 System.out.println("The frame switched to bottom frame");
	 }  else {
		 System.out.println("The frame not switch");
	 }
	 
	//switch to parent frame
	 driver.switchTo().parentFrame();
	 
	
	 //verify the title of webpage
	 String title = driver.getCurrentUrl();
	 
	 System.out.println(title);
	 
	 if(title.contains("FRAMES")) {
		 
		 System.out.println("Its a correct page title");
	 } else {
		 System.out.println("The page title is :" +title);
	 }
	 
	 
	 
	driver.close();    //close the tab
	
	}

}
