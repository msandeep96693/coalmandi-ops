package opspageobject;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class opsordermanagementpage extends opsBasicpage {

	public opsordermanagementpage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath = "//input[@placeholder='Search by order ID and coal type']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//span[@title='All Status']")
	private WebElement clickonstatusdropdown;
	
	@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
	private List<WebElement> statusdropdownoptionlist;
	
	@FindBy(xpath = "(//div[@class='w-full']/div)[2]/div/div")
	private List<WebElement> orderlistdata;
	
	@FindBy(xpath = "//button[.='View Details']")
	private List<WebElement> viewdetailsbtns;
	
	public void opsordermanagementlistpage(String email, String pwd, String sidenavbarname , String statusoptionname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		Thread.sleep(1000);
		
		// search by coal type or order id
		waitforElement(searchtextfield);
		searchtextfield.sendKeys("Metallurgical Coal");
		
		waitforElement(clickonstatusdropdown);
		clickonstatusdropdown.click();
		
		selectDropdownOption(statusdropdownoptionlist, "In Progress");
		
		clickViewButtonUsingContains("In Progress");
		
		Thread.sleep(2000);
	}
	
	
	
	
	
	public void clickViewButtonUsingContains(String statusTextToMatch) throws InterruptedException {

	    boolean found = false;

	    for (int i = 0; i < orderlistdata.size(); i++) {
	        
	    	Thread.sleep(2000);
	        String statusText = orderlistdata.get(i).getText().trim();
	        System.out.println("Row Status: " + statusText);

	        if (statusText.toLowerCase().contains(statusTextToMatch.toLowerCase())) {
	            
	            WebElement viewButton = viewdetailsbtns.get(i);

	            // Scroll button into view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewButton);
	            Thread.sleep(600);

	            // Click using JS for reliability
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewButton);
	            
	            System.out.println("✅ View button clicked for status containing: " + statusTextToMatch);
	            
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        System.out.println("❌ No row found with status containing: " + statusTextToMatch);
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
