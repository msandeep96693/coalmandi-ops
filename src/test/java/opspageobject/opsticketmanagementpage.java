package opspageobject;

import java.awt.AWTException;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
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
	
	@FindBy(xpath = "//span[@title='All']")
	private WebElement allstatusdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']/div")
	private List<WebElement> statusoptions;
	
	@FindBy(xpath = "//td[@class='ant-table-cell']/div/div/span")
	private List<WebElement> statusnameinlist;
	
	@FindBy(xpath = "//span[.='Escalate To Admin']")
	private WebElement escalatedtoadminbtn;
	
	@FindBy(xpath = "//button[.='Submit']")
	private WebElement submitbtn;
	
	@FindBy(xpath = "//span[.='Close Ticket']")
	private WebElement closeticketbutton;
	
	
	public void ticketmanagementlistpage(String opsemail, String pwd, String sidebarticketname,
			String ticketstatusoptionnameclosed) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(opsemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarticketname);
//		executiveClickAction(sidebarticketname);
		Thread.sleep(1000);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusoptions, ticketstatusoptionnameclosed);
		
		Thread.sleep(2000);
		statusnameinlist.get(0).click();
		
		Thread.sleep(2000);
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
	}
	
	// mark as inprogress and escalate to admin
	public void ticketmanagementaction(String opsemail, String pwd, String sidebarticketname,
			String ticketstatusoptionnameopen) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(opsemail, pwd);
		
		// select the left nav bar features by name
//		ClickAction(sidebarticketname);
		executiveClickAction(sidebarticketname);
		Thread.sleep(1000);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusoptions, ticketstatusoptionnameopen);
		
		Thread.sleep(2000);
		statusnameinlist.get(0).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", markasinprogressbtn);
		
		waitforElement(markasinprogressbtn);
		javascriptclick(markasinprogressbtn);
		
		Thread.sleep(1000);
		
		waitforElement(escalatedtoadminbtn);
		escalatedtoadminbtn.click();
			
		waitforElement(selectcloseticketradiobtn);
		javascriptclick(selectcloseticketradiobtn);
		
		waitforElement(remarkstextarea);
		remarkstextarea.sendKeys("No problem");
	
		waitforElement(submitbtn);
		javascriptclick(submitbtn);
		
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);

	}
	
	public void closeticketbyopsadmin(String opsemail, String pwd, String sidebarticketname,
			String ticketstatusoptionnameescalated) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(opsemail, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarticketname);
		Thread.sleep(1000);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusoptions, ticketstatusoptionnameescalated);
		
		Thread.sleep(2000);
		statusnameinlist.get(0).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 js1.executeScript("arguments[0].scrollIntoView({block: 'center'});", closeticketbutton);
		
		waitforElement(closeticketbutton);
		javascriptclick(closeticketbutton);
		
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);

	}
	
	
	public void ticketmanagementassignpage(String email, String pwd, String sidebarticketname,
			String ticketstatusoptionnameopen, String opsexecutivename
			 ) throws AWTException, InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarticketname);
		
		waitforElement(allstatusdropdown);
		allstatusdropdown.click();
		
		selectDropdownOption(statusoptions, ticketstatusoptionnameopen);
		
		Thread.sleep(2000);
		statusnameinlist.get(0).click();
		
		waitforElement(assignbtn);
		javascriptclick(assignbtn);
		
		waitforElement(clickonopsexecutivedropdown);
		javascriptclick(clickonopsexecutivedropdown);
		
		waitforElement(opsexecutivesearchtextfield);
		opsexecutivesearchtextfield.sendKeys(opsexecutivename);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).perform();
		
		waitforElement(assignbutton2);	
		javascriptclick(assignbutton2);
		Thread.sleep(2000);
		
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
	
	public void executiveClickAction(String btn) {
	    switch(btn.toLowerCase()) {
	        case "dashboard": javascriptclick(btnsSideBar.get(0)); break;
	        case "customer management": javascriptclick(btnsSideBar.get(1)); break;
	        case "listing": javascriptclick(btnsSideBar.get(2)); break;
	        case "auction": javascriptclick(btnsSideBar.get(3)); break;
	        case "order": javascriptclick(btnsSideBar.get(4)); break;
	        case "vendor": javascriptclick(btnsSideBar.get(5)); break;
	        
	     
	        case "ticket": javascriptclick(btnsSideBar.get(6)); break;
	        case "reports": javascriptclick(btnsSideBar.get(7)); break;
	        case "help": javascriptclick(btnsSideBar.get(8)); break;
	     
	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}
	

}
