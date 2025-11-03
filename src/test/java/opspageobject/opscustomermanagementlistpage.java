package opspageobject;

import java.awt.AWTException;
import java.awt.Event;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class opscustomermanagementlistpage extends opsBasicpage {

	public opscustomermanagementlistpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath="//a[@href='/customer-management/activities']") 
	private WebElement activitiessubbtn;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//input[@placeholder='From Date']")
	private WebElement fromdate;
	
	@FindBy(xpath = "//input[@placeholder='To Date']")
	private WebElement todate;
	
	@FindBy(xpath="//div[@class='w-full']/div[2]//span[text()='Incomplete Profiles']/../../div[2]/div")  
	private List<WebElement> cardInComplete;

	
	
	
	public void opscustomermanagementactivitylist(String email, String pwd, String sidenavbarname,
			String searchbycontactname) throws AWTException, InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbycontactname);
		
		waitforElement(fromdate);
		fromdate.sendKeys(currentdatefetch());
		
		waitforElement(todate);
		todate.sendKeys(currentdatefetch());
		
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
		for(WebElement complete:cardInComplete)
		{
			String Businessdata = complete.getText();
			System.out.println("Business data :- "+ Businessdata);
		}
	}
	
	public void ClickAction(String btn) {
	    switch(btn.toLowerCase()) {
	        case "dashboard": javascriptclick(btnsSideBar.get(0)); break;
	        case "customer management": javascriptclick(btnsSideBar.get(1)); break;
	        case "listing": javascriptclick(btnsSideBar.get(2)); break;
	        case "auction": javascriptclick(btnsSideBar.get(3)); break;
	        case "order": javascriptclick(btnsSideBar.get(4)); break;
	        case "team": javascriptclick(btnsSideBar.get(5)); break;
	        case "vendor": javascriptclick(btnsSideBar.get(6)); break;
	        
	        case "transporter": javascriptclick(btnsSideBar.get(7)); break;
	        case "ticket": javascriptclick(btnsSideBar.get(8)); break;
	        case "reports": javascriptclick(btnsSideBar.get(9)); break;
	        case "help": javascriptclick(btnsSideBar.get(10)); break;
	     
	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	

}
