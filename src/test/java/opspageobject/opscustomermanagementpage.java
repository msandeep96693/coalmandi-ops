package opspageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class opscustomermanagementpage extends opsBasicpage {

	public opscustomermanagementpage(WebDriver driver) {
		super(driver);
		}

	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath="//a[@href='/customer-management/activities']") 
	private WebElement activitiessubbtn;
	
	@FindBy(xpath = "//a[@href='/customer-management/assigned']")
	private WebElement assignedtosubbtn;
	
	@FindBy(xpath = "//a[@href='/customer-management/reject-requests']")
	private WebElement rejectionrequestsubbtn;
	
	@FindBy(xpath="//div[@class='w-full']/div[2]//span[text()='Pending KYC Approval']/../../div[2]//button") 
	private List<WebElement> viewButton;
	
	@FindBy(xpath="//div[text()='KYC Upload']") 
	private WebElement KycUploadButton;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter rejection reason... (Minimum 5 characters)']")
	private WebElement rejectionreasontextarea;
	
	@FindBy(xpath = "//button[.='Submit Rejection']")
	private WebElement submitrejectionbtn;
	
	@FindBy(xpath = "//button[.='Submit Review']")
	private WebElement submitreviewbtn;
	
	@FindBy(xpath = "//span[.='Approved']")
	private WebElement approvedsectionbtn;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr")
	private List<WebElement> listofapproveddata;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement opsmanagerprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement opslogout;
	
	@FindBy(xpath = "//div[@class='ant-notification-notice-message']/..")
	private WebElement successconfirmationmessage;
	
	
 // --------------------------------------------------------------
	
	@FindBy(xpath = "//button[.='Assign']")
	private WebElement assignbtn;
	
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	private WebElement clickonopsexecutivedropdown;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtextfield;
	
	//div[@class='ant-select-item ant-select-item-option']
	@FindBy(xpath = "(//button[.='Assign'])[2]")
	private WebElement assignbutton2;
	
	@FindBy(xpath = "//span[@class='font-medium']/..")
	private WebElement assginedname;
	
	@FindBy(xpath = "(//button[.='View'])[1]")
	private WebElement viewbtn;
	
	
	@FindBy(xpath="//div[@class='w-full']/div[2]//span[text()='Pending KYC Approval']/../../div[2]/div//div/div/div/div/div") 
	private List<WebElement> cardpendingKycApprovel;
	
	@FindBy(xpath="//div[@class='w-full']/div[2]//span[text()='Rejected KYC']/../../div[2]/div")         
	private List<WebElement> cardRejectedKyc;
	
	
	

	
	
	
	public void customermanagementactivitypage(String email, String pwd, String sidenavbarname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		Thread.sleep(1000);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
		
//		click on pending KYC approval
		ClickOnApprovalFiles(1);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
		scrollUntilElementVisible(KycUploadButton);
		
		waitforElement(KycUploadButton);
		javascriptclick(KycUploadButton);
		
		clickOnCard("Authorization Letter", "Accept");
		clickOnCard("PAN Card", "Accept");
		clickOnCard("GST Certificate", "Accept");
		clickOnCard("TAN Certificate", "Accept");
		clickOnCard("LUT Certificate", "Accept");
		clickOnCard("Cancelled Cheque", "Accept");
		clickOnCard(" Udyam Certificate (MSME)", "Accept");
		clickOnCard("IEC Certificate", "Accept");
		clickOnCard("D&B Certificate", "Accept");
		
		
		
		waitforElement(submitreviewbtn);
		javascriptclick(submitreviewbtn);
		
		waitforElement(approvedsectionbtn);
		javascriptclick(approvedsectionbtn);
		
		for(int i = 0; i< listofapproveddata.size(); i++)
		{
			Thread.sleep(1000);
			String approveddata = listofapproveddata.get(1).getText();
			System.out.println("Approved data :- "+approveddata);
			break;
		}
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		}
	
	
	public void opscustomerprofileassignfunctionality(String email, String pwd, String sidenavbarname) throws AWTException, InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidenavbarname);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
				
//		click on pending KYC approval
		ClickOnApprovalFiles(1);
		
		Thread.sleep(4000);
				
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
		waitforElement(assignbtn);
		javascriptclick(assignbtn);
		
		waitforElement(clickonopsexecutivedropdown);
		javascriptclick(clickonopsexecutivedropdown);
		
		Thread.sleep(2000);
		waitforElement(searchtextfield);
		searchtextfield.sendKeys("sandeep");
		
		Robot rt = new Robot();
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyRelease(KeyEvent.VK_ENTER);
		
		waitforElement(assignbutton2);
		javascriptclick(assignbutton2);
		
//		waitforElement(successconfirmationmessage);
//		String confirmationmsg = successconfirmationmessage.getText();
//		System.out.println("Created confirmation message :- "+ confirmationmsg);
		
		waitforElement(assignedtosubbtn);
		javascriptclick(assignedtosubbtn);
		
		for(int i = 0; i< listofapproveddata.size(); i++)
		{
			Thread.sleep(1000);
			String approveddata = listofapproveddata.get(1).getText();
			System.out.println("Approved data :- "+approveddata);
			break;
		}
		
		waitforElement(viewbtn);
		javascriptclick(viewbtn);
		
		String url1 = driver.getCurrentUrl();
		System.out.println("customer details page current URL : - "+url1);
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void ClickOnApprovalFiles(int value)
	{
		   for(int i = 0; i< viewButton.size(); i++)
		   {
			   viewButton.get(value).click();
			   break;
		   }
	} 
	
	public WebElement getCardElement(String cardName, String action) {
	    try {
	        String xpath = String.format("//p[text()='%s']/..//span[text()='%s']",
	                cardName, action);

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

	        return element;

	    } catch (Exception e) {
//	        System.out.println("Card or action not available: " + cardName + " - " + action);
	        return null;
	    }
	}

	public void clickOnCard(String card, String action) throws InterruptedException {
	    WebElement element = getCardElement(card, action);

	    if (element != null) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            javascriptclick(element);
	            System.out.println("Clicked: " + card + " -> " + action + " ✅");
	        } catch (Exception ex) {
	            System.out.println("Click failed for: " + card + " -> " + action + " ⛔");
	        }
	    } else {
	        System.out.println("Skipping: " + card + " -> " + action + " ❌");
	    }
	    
	    Thread.sleep(2000); // Give UI time to update
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
