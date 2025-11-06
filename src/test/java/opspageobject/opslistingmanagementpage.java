package opspageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class opslistingmanagementpage extends opsBasicpage {

	public opslistingmanagementpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	// list page
	
	@FindBy(xpath = "//input[@placeholder='Search by Business Name, Coal Type']")
	private WebElement listsearchtextfield;
	
	@FindBy(xpath = "(//div[@class='flex flex-col gap-2'])[1]")
	private WebElement listdata;
	
	@FindBy(xpath = "//button[.='View Details']")
	private WebElement viewdetailsbtn;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement opsmanagerprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement opslogout;
	
	// listing details page
	
	@FindBy(xpath = "//button[.='Assign']")
	private WebElement assignbtn;
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	private WebElement clickonopsexecutivedropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement opsexecutivesearchtextfield;
	
	//div[@class='ant-select-item ant-select-item-option']
	@FindBy(xpath = "(//button[.='Assign'])[2]")
	private WebElement assignbutton2;
	
	@FindBy(xpath = "//span[@class='font-medium']/..")
	private WebElement assginedname;

	@FindBy(xpath = "//button[.='Approve']")
	private WebElement approvebtn;
	
	@FindBy(xpath = "//span[.='Others']")
	private WebElement othersection;
	
	@FindBy(xpath = "(//input[@type='search'])[2]")   // 
	private WebElement clickonstatusdropdown;
	
	@FindBy(xpath = "//div[.='Assigned']")
	private WebElement assignedoption;
	
	@FindBy(xpath = "((//div[@class='w-full']/div[2]/div/div/div)[1]/div)[1]")
	private WebElement listingdata;
	
	@FindBy(xpath = "//button[.='Request To Reject']")
	private WebElement requesttorejectbtn;
	
	@FindBy(xpath = "(((//div[@class='overflow-hidden'])[2]/div)[2]/div/div)[2]/button/span")
	private WebElement requesttorejectviewbtn;
	
	@FindBy(xpath = "//button[.='Rejection with Reason']")
	private WebElement rejectionwithreasonbtn;
	
	@FindBy(xpath = "//textarea")
	private WebElement rejectionreasontextarea;
	
	@FindBy(xpath = "//button[.='Submit Rejection']")
	private WebElement submitrejectionbtn;
	
	public void listingmanagementlistpage(String email, String pwd, String sidenavbarname, String searchbybusinessname)
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		waitforElement(listsearchtextfield);
		listsearchtextfield.sendKeys(searchbybusinessname);
		
		String data = listdata.getText();
		System.out.println("Data :- "+ data);
		
		// pending approval 
		waitforElement(viewdetailsbtn);
		javascriptclick(viewdetailsbtn);
		
		String url1 = driver.getCurrentUrl();
		System.out.println("Listing details url :- "+ url1);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
	}
	
	public void listingmanagementapprovalpage(String email, String pwd, String sidenavbarname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		// pending approval
		waitforElement(viewdetailsbtn);
		javascriptclick(viewdetailsbtn);
		
		scrollBottomofPage();
		
		waitforElement(requesttorejectbtn);
		javascriptclick(requesttorejectbtn);
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
	}
	
	public void listingmanagementexecutiverejectpage(String email, String pwd, String sidenavbarname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		// pending approval
//		waitforElement(viewdetailsbtn);
//		javascriptclick(viewdetailsbtn);
		
		waitforElement(requesttorejectviewbtn);
		javascriptclick(requesttorejectviewbtn);
		
		scrollBottomofPage();
		
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
		
		// pending approval
		waitforElement(viewdetailsbtn);
		javascriptclick(viewdetailsbtn);
		
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
//		waitforElement(othersection);
//		javascriptclick(othersection);
//		
//		waitforElement(clickonstatusdropdown);
//		javascriptclick(clickonstatusdropdown);
//		
//		waitforElement(assignedoption);
//		javascriptclick(assignedoption);
//		
//		String assigneddata = listingdata.getText();
//		System.out.println("Assigned data :- "+ assigneddata);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
	}
	
	public void listingmanagementrequesttorejectpage(String email, String pwd, String sidenavbarname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		waitforElement(requesttorejectviewbtn);
		javascriptclick(requesttorejectviewbtn);
		
		scrollBottomofPage();
		
		waitforElement(rejectionwithreasonbtn);
		javascriptclick(rejectionwithreasonbtn);
		Thread.sleep(2000);
		
		waitforElement(rejectionreasontextarea);
		rejectionreasontextarea.clear();
		Thread.sleep(1500);
		rejectionreasontextarea.sendKeys("WE CAN ACCEPT THE LISTING");
		
		waitforElement(submitrejectionbtn);
		javascriptclick(submitrejectionbtn);
		Thread.sleep(1000);
		
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
