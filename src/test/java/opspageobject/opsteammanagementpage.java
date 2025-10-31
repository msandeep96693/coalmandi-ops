package opspageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.viewdefs.Icon;


public class opsteammanagementpage extends opsBasicpage {
	
	public opsteammanagementpage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath="//a[@href='/customer-management/activities']") 
	private List<WebElement> btnSubManage;
	
	// create team member
	@FindBy(xpath = "//span[.='Add Team Member']/..")
	private WebElement addteammemberbtn;
	
	@FindBy(xpath = "//input[@placeholder='Enter full name']")
	private WebElement enterfullnamefield;
	
	@FindBy(xpath = "//input[@placeholder='Enter email address']")
	private WebElement enteremailaddressfield;
	
	@FindBy(xpath = "//input[@placeholder='Enter phone number']")
	private WebElement enterphonenumberfield;
	
	@FindBy(xpath = "//span[.='Create Team Member']/..")
	private WebElement clickoncreateteammemberbtn; 
	
	@FindBy(xpath = "//div[@class='flex items-start justify-between mb-4']")
	private List<WebElement> teammemberlistdata;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']/..")
	private WebElement successconfirmationmessage;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement opsmanagerprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement opslogout;
	
	@FindBy(xpath = "//span[.='View Details']/..")
	private List<WebElement> viewdetailsbuttons;
	
	// Edit ops team member
	
	@FindBy(xpath = "//button[.='Edit Profile']")
	private WebElement editprofilebutton;
	
	@FindBy(xpath = "//button[.='Update Team Member']")
	private WebElement updateteammemberbutton;
	
	@FindBy(xpath = "//h1")
	private WebElement updatedteammembername;
	
	// Team member list page
	
	@FindBy(xpath = "//input[@placeholder='Search by name, email']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//input[@type='search']")
	private List<WebElement> searchandfilterfield;
	
	@FindBy(xpath = "//span[@title='All Status']")
	private WebElement allstatusfilter;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']/..")
	private List<WebElement> statusdropdownoptions;
	
	@FindBy(xpath = "//div[@class='space-y-3 mb-4']")
	private List<WebElement> teammembersearchlistdata;
	
	
	
	public void opscreateteammanagement(String email, String pwd, String sidebarfeaturename
			 ) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		Thread.sleep(1000);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
		
		// enter a full name
		waitforElement(enterfullnamefield);
		enterfullnamefield.sendKeys(setRandomName());
		
		// enter a email ID
		waitforElement(enteremailaddressfield);
		enteremailaddressfield.sendKeys(setRandomEmail());
		
		// enter a phone number
		waitforElement(enterphonenumberfield);
		enterphonenumberfield.sendKeys(setRandomMobileNumber());
		
		// click on create team member button
		waitforElement(clickoncreateteammemberbtn);
		javascriptclick(clickoncreateteammemberbtn);
		
		Thread.sleep(2000);
		// confirmation 
		waitforElement(successconfirmationmessage);
		String confirmationmsg = successconfirmationmessage.getText();
		System.out.println("Created confirmation message :- "+ confirmationmsg);
		
		// cross check the created team member
		for(int i = 0; i<=teammemberlistdata.size(); i++)
		{
				String executivedata = teammemberlistdata.get(0).getText().trim();
				System.out.println("Executive data :- "+ executivedata);
				break;
		}
		
		// click on view details button
		for(int i = 0; i<= viewdetailsbuttons.size(); i++)
		{
			viewdetailsbuttons.get(0).click();
			break;
		}
		
		String teamdetailspage = driver.getCurrentUrl();
		System.out.println("Team Details page :- "+ teamdetailspage);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		
	}
	
	public void opsupdateteammember(String email, String pwd, String sidebarfeaturename
			) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		Thread.sleep(1000);
		
		// click on view details button
				for(int i = 0; i<= viewdetailsbuttons.size(); i++)
				{
					viewdetailsbuttons.get(0).click();
					break;
				}
				
				String teamdetailspage = driver.getCurrentUrl();
				System.out.println("Team Details page :- "+ teamdetailspage);
				
				
				// update the team member
				waitforElement(editprofilebutton);
				javascriptclick(editprofilebutton);
				
				// enter a full name
				waitforElement(enterfullnamefield);
				enterfullnamefield.clear();
				Thread.sleep(500);
				enterfullnamefield.sendKeys(setRandomName());
				
				// enter a phone number
				waitforElement(enterphonenumberfield);
				enterphonenumberfield.clear();
				Thread.sleep(500);
				enterphonenumberfield.sendKeys(setRandomMobileNumber());
				
				// click on update button
				waitforElement(updateteammemberbutton);
				javascriptclick(updateteammemberbutton);
				
				Thread.sleep(2000);
				// confirmation 
				waitforElement(successconfirmationmessage);
				String updateconfirmationmsg = successconfirmationmessage.getText();
				System.out.println("updated confirmation message :- "+ updateconfirmationmsg);
				
				// cross check the created team member
				waitforElement(updatedteammembername);
				String updatedname = updatedteammembername.getText();
				System.out.println("Update Name :- "+ updatedname);
				
				Thread.sleep(2000);
				
				waitforElement(opsmanagerprofileicon);
				javascriptclick(opsmanagerprofileicon);
				
				waitforElement(opslogout);
				javascriptclick(opslogout);
	}
	
	
	public void listteammanagement(String email, String pwd, String sidebarfeaturename, 
			String emailsearchdata, String optionname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarfeaturename);
		Thread.sleep(1000);
		
		// search a textfield
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(emailsearchdata);
		Thread.sleep(4000);
		
		// Fetch list of data based on search data
		for(int i = 0; i<=teammembersearchlistdata.size(); i++)
		{
				String executivedata = teammembersearchlistdata.get(i).getText().trim();
				System.out.println("Executive data :- "+ executivedata);
				break;
		}
		
		
		waitforElement(allstatusfilter);
		allstatusfilter.click();
		
//		All status dropdown
		selectDropdownOption(statusdropdownoptions, optionname);
		
		// Fetch list of data based on search data
				for(int i = 0; i<=teammembersearchlistdata.size(); i++)
				{
						String executivedata = teammembersearchlistdata.get(i).getText().trim();
						System.out.println("Executive data :- "+ executivedata);
						break;
				}	
				
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
	        case "ticket": javascriptclick(btnsSideBar.get(6)); break;
	        case "reports": javascriptclick(btnsSideBar.get(7)); break;

	        case "activities": javascriptclick(btnsSideBar.get(0)); break;
	        case "assigned": javascriptclick(btnsSideBar.get(1)); break;
	        case "rejection request": javascriptclick(btnsSideBar.get(2)); break;
	        case "kyc":javascriptclick(btnsSideBar.get(3)); break;

	        default: throw new NoSuchElementException("Button not found: " + btn);
	    }
	}

}
