package opspageobject;

import java.awt.AWTException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class opsticketmanagementpage extends opsBasicpage {

	public opsticketmanagementpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath = "(//div[@class='w-full']/div)[3]/div/div")
	private List<WebElement> ticketlistdata;
	
	@FindBy(xpath = "//button[.='Mark as In Progress']")
	private WebElement markasinprogressbtn;
	
	@FindBy(xpath = "//button[.='Close Ticket']")
	private WebElement closeticketbtn;
	
	@FindBy(xpath = "//span[.='No changes, the contract will continue.']")
	private WebElement selectcloseticketradiobtn;
	
	@FindBy(xpath = "//textarea")
	private WebElement remarkstextarea;
	
	@FindBy(xpath = "(//button[.='Close Ticket'])[2]")
	private WebElement closeticketbtn2;
	
	@FindBy(xpath = "//button[.='Assign']")
	private WebElement assignbtn;
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	private WebElement clickonopsexecutivedropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement opsexecutivesearchtextfield;
	
	//div[@class='ant-select-item ant-select-item-option']
	@FindBy(xpath = "(//button[.='Assign'])[2]")
	private WebElement assignbutton2;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement opsmanagerprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement opslogout;
	
	
	
	
	public void ticketmanagementaction(String email, String pwd, String sidenavbarname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		Thread.sleep(1000);
		
		for (int i = 0; i < ticketlistdata.size(); i++) {
		    
		        // Re-fetch element each loop iteration (avoid stale reference)
		        WebElement ticketdata = ticketlistdata.get(i);

		        String data = ticketdata.getText().trim();
		        System.out.println("Ticket data :- " + data);

		        if (data.equalsIgnoreCase("in progress") || data.toLowerCase().contains("in progress")) {
		            ticketdata.click();
		            break;
		        }
		}
		
		Thread.sleep(2000);
		
		scrollBottomofPage();
		
//		waitforElement(markasinprogressbtn);
//		javascriptclick(markasinprogressbtn);
		
		waitforElement(closeticketbtn);
		javascriptclick(closeticketbtn);
		
		waitforElement(selectcloseticketradiobtn);
		javascriptclick(selectcloseticketradiobtn);
		
		waitforElement(remarkstextarea);
		remarkstextarea.sendKeys("No problem");
		
		waitforElement(closeticketbtn2);
		javascriptclick(closeticketbtn2);
		
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);

	}
	
	
	public void listingmanagementassignpage(String email, String pwd, String sidenavbarname, String opsexecutivename) throws AWTException, InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		Thread.sleep(1000);
		for (int i = 0; i < ticketlistdata.size(); i++) {
		    
	        // Re-fetch element each loop iteration (avoid stale reference)
	        WebElement ticketdata = ticketlistdata.get(i);

	        String data = ticketdata.getText().trim();
	        System.out.println("Ticket data :- " + data);

	        if (data.equalsIgnoreCase("Open") || data.toLowerCase().contains("open")) {
	            ticketdata.click();
	            break;
	        }
	}
		
		
		
		waitforElement(assignbtn);
		javascriptclick(assignbtn);
		
		waitforElement(clickonopsexecutivedropdown);
		javascriptclick(clickonopsexecutivedropdown);
		
		waitforElement(opsexecutivesearchtextfield);
		opsexecutivesearchtextfield.sendKeys(opsexecutivename);
		
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		
//		waitforElement(assignbutton2);	
//		javascriptclick(assignbutton2);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
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
