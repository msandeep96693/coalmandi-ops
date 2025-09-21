package customerpageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class opsteammanagementpage extends opsBasicpage{
	
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
	
	@FindBy(xpath = "//span[.='View Details']/..")
	private List<WebElement> viewdetailsbuttons;
	
	public void opsteammanagement(String email, String pwd) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction("team");
		Thread.sleep(3000);
		
		// click on add team member button
		waitforElement(addteammemberbtn);
		javascriptclick(addteammemberbtn);
		
		Thread.sleep(3000);
		
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
