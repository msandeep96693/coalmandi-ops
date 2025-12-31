package opspageobject;

import java.awt.AWTException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class opsvendormanagementpage extends opsBasicpage {

	public opsvendormanagementpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
	private List<WebElement> btnsSideBar;
	
	@FindBy(xpath="//a[@href='/vendor-management/activities']") 
	private WebElement activitiessubbtn;
	
	@FindBy(xpath="((//div[@class='overflow-hidden'])[2]/div)[2]/div//button") 
	private List<WebElement> viewButton; 
	
	@FindBy(xpath = "//button[.='Submit Review']")
	private WebElement submitreviewbtn;
	
	@FindBy(xpath = "(//div[contains(@class,'ant-rate')]//span[@aria-label='star'])[8]")
	private WebElement selectrating;
	
	@FindBy(xpath = "//button[.='Approve with Ratings']")
	private WebElement approvewithratingbtn;
	
	@FindBy(xpath = "//span[.='Approved Vendors']")
	private WebElement approvedsectionbtn;
	
	@FindBy(xpath = "//tbody[@class='ant-table-tbody']/tr")
	private List<WebElement> listofapproveddata;
	
	@FindBy(xpath = "//span[@class='text-sm font-medium text-white']/..")
	private WebElement opsmanagerprofileicon;
	
	@FindBy(xpath = "//button[.='Logout']")
	private WebElement opslogout;
	
	@FindBy(xpath="//div[@class='w-full']/div[2]//span[text()='Incomplete Profiles']/../../div[2]/div")  
	private List<WebElement> cardInComplete;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement searchtextfield;
	
	@FindBy(xpath = "//input[@placeholder='From Date']")
	private WebElement fromdate;
	
	@FindBy(xpath = "//input[@placeholder='To Date']")
	private WebElement todate;
	
	// assign
	@FindBy(xpath = "(//button[.='Assign'])[2]")
	private WebElement assignbutton2;
		
	@FindBy(xpath = "//button[.='Assign']")
	private WebElement assignbtn;
		
	@FindBy(xpath = "//span[@class='ant-select-selection-item']")
	private WebElement clickonopsexecutivedropdown;
		
	@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
	private List<WebElement> executiveoptions;
		
	@FindBy(xpath = "//a[@href='/vendor-management/assigned']")
	private WebElement assignedtosubbtn;
		
	// request to reject - ops executive
	@FindBy(xpath = "//div[@class='w-full']/div[2]//span[text()='Request to Reject']/../../div[2]//button")
	private List<WebElement> viewbuttonrequesttorejectprofile;
	
	@FindBy(xpath="//div[text()='KYC Upload']") 
	private WebElement KycUploadButton;
	
	@FindBy(xpath = "//button[.='Request To Reject']")
	private WebElement requesttorejctionbutton;
	
	@FindBy(xpath = "//div[@class='w-full']/div[2]//span[text()='Assigned Profiles']/../../div[2]//button")
	private List<WebElement> viewbuttonassignedprofiles;
	
	
	// --------
	@FindBy(xpath = "//a[@href='/vendor-management/reject-requests']")
	private WebElement rejectionrequestsubbtn;
	
	@FindBy(xpath = "//div[@class='ant-table-content']/table//tbody//button[.='View']")
	private WebElement requesttorejectviewbutton;
	
	@FindBy(xpath = "//span[@title='Undo review']")   // cross check //span[@title='Undo review']
	private WebElement undobutton;
	
	@FindBy(xpath = "//span[.='Accept']")
	private WebElement acceptbutton;
	
	@FindBy(xpath = "//button[.='Approve']")
	private WebElement approvebtn;
	
	@FindBy(xpath = "//textarea[contains(@placeholder, 'approving despite the rejection')]")
	private WebElement overrideapprovetextarea;
	
	@FindBy(xpath = "//button[.='Approve with Override']")
	private WebElement approvewithoverridebtn;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter rejection reason... (Minimum 5 characters)']")
	private WebElement rejectionreasontextarea;
	
	@FindBy(xpath = "//button[.='Submit Rejection']")
	private WebElement submitrejctionbutton;
	
	public void vendormanagementactivitylistflow(String email, String pwd, String sidebarvendorname,
			String searchbyvendorcontactname, String todateformat) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarvendorname);
		Thread.sleep(1000);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
		
		waitforElement(searchtextfield);
		searchtextfield.sendKeys(searchbyvendorcontactname);
		
		Thread.sleep(2000);
		
		for(WebElement complete:cardInComplete)
		{
//			Thread.sleep(500);
			String Businessdata = complete.getText();
			System.out.println("Business data :- "+ Businessdata);
		}
		
		Thread.sleep(1000);
		waitforElement(fromdate);
		fromdate.sendKeys(currentdatefetch());
		
		Thread.sleep(2000);
		waitforElement(todate);
		todate.sendKeys(todateformat);
		
		waitforElement(searchtextfield);
		searchtextfield.click();
		
//		Robot rt = new Robot();
//		rt.keyPress(KeyEvent.VK_ENTER);
//		rt.keyRelease(KeyEvent.VK_ENTER);
		
//		Thread.sleep(500);
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ESCAPE);
		
		Thread.sleep(1500);
		for(WebElement complete:cardInComplete)
		{
			Thread.sleep(500);
			String Businessdata = complete.getText();
			System.out.println("Business data :- "+ Businessdata);
		}
		
		
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		
		
	}
	
	
	public void vendormanagementactivitypage(String email, String pwd, String sidebarvendorname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarvendorname);
		Thread.sleep(1000);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
		
//		click on pending KYC approval
		ClickOnApprovalFiles(0);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
//		scrollUntilElementVisible(KycUploadButton);
		
//		waitforElement(KycUploadButton);
//		javascriptclick(KycUploadButton);
		
		clickOnCard("Authorization Letter", "Accept");
		clickOnCard("PAN Card", "Accept");
		clickOnCard("GST Certificate", "Accept");
		clickOnCard("TAN Certificate", "Accept");
		clickOnCard("LUT Certificate", "Accept");
		clickOnCard("Cancelled Cheque", "Accept");
		clickOnCard(" Udyam Certificate (MSME)", "Accept");
		clickOnCard("IEC Certificate", "Accept");

		waitforElement(submitreviewbtn);
		javascriptclick(submitreviewbtn);
		
		waitforElement(selectrating);
		javascriptclick(selectrating);
		
		waitforElement(approvewithratingbtn);
		javascriptclick(approvewithratingbtn);
		
		
		Thread.sleep(500);
		waitforElement(approvedsectionbtn);
		javascriptclick(approvedsectionbtn);
		
//		for(int i = 0; i< listofapproveddata.size(); i++)
//		{
//			Thread.sleep(1000);
//			String approveddata = listofapproveddata.get(1).getText();
//			System.out.println("Approved data :- "+approveddata);
//			break;
//		}
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		}
	
	public void opsvendorprofileassignfunctionality(String email, String pwd, String sidebarvendorname,
			String opsexecutivename) throws AWTException, InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(email, pwd);
		
		// select the left nav bar features by name
		ClickAction(sidebarvendorname);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
				
		//click on pending KYC approval
		ClickOnApprovalFiles(0);
		
		Thread.sleep(3000);
				
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
		waitforElement(assignbtn);
		javascriptclick(assignbtn);
		
		Thread.sleep(1500);
		waitforElement(clickonopsexecutivedropdown);
//		javascriptclick(clickonopsexecutivedropdown);
		clickonopsexecutivedropdown.click();
		
		executiveoptions.get(0).click();
		
//		
//		Thread.sleep(1000);
//		waitforElement(searchtextfield);
//		searchtextfield.sendKeys(opsexecutivename);
//		
//		Thread.sleep(1500);
////		Robot rt = new Robot();
////		rt.keyPress(KeyEvent.VK_ENTER);
////		rt.keyRelease(KeyEvent.VK_ENTER);
//		
//		Actions act = new Actions(driver);
////		act.sendKeys(Keys.ENTER);
//		act.sendKeys(Keys.ESCAPE);
		
		Thread.sleep(500);
		waitforElement(assignbutton2);
		javascriptclick(assignbutton2);
		
		waitforElement(assignedtosubbtn);
		javascriptclick(assignedtosubbtn);
		
		for(int i = 0; i< listofapproveddata.size(); i++)
		{
			Thread.sleep(1000);
			String approveddata = listofapproveddata.get(1).getText();
			System.out.println("Approved data :- "+approveddata);
			break;
		}
		
//		waitforElement(viewbtn);
//		javascriptclick(viewbtn);
		
		String url1 = driver.getCurrentUrl();
		System.out.println("customer details page current URL : - "+url1);
		Thread.sleep(2000);
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
	}
	
	public void vendormanagementexecutereject(String opsexecutiveemail, String pwd, String sidebarvendorname) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);
		opssign.opssigninpage(opsexecutiveemail, pwd);
		
		// select the left nav bar features by name
//		ClickAction(sidebarvendorname);
		executiveClickAction(sidebarvendorname);
		Thread.sleep(1000);
		
		// click on add team member button
		waitforElement(activitiessubbtn);
		javascriptclick(activitiessubbtn);
		
//		click on pending KYC approval
		clickOnAssignedprofileviewbutton(0);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
//		scrollUntilElementVisible(KycUploadButton);
//		
//		waitforElement(KycUploadButton);
//		javascriptclick(KycUploadButton);
		
		clickOnCard("Authorization Letter", "Reject");
		clickOnCard("PAN Card", "Accept");
		clickOnCard("GST Certificate", "Accept");
		clickOnCard("TAN Certificate", "Accept");
		clickOnCard("LUT Certificate", "Accept");
		clickOnCard("Cancelled Cheque", "Accept");
		clickOnCard(" Udyam Certificate (MSME)", "Accept");
		clickOnCard("IEC Certificate", "Accept");

		
		waitforElement(requesttorejctionbutton);
		javascriptclick(requesttorejctionbutton);
		
		clickOnrequesttorejectprofileviewbutton(0);
		
//		for(int i = 0; i< listofapproveddata.size(); i++)
//		{
//			Thread.sleep(500);
//			String approveddata = listofapproveddata.get(1).getText();
//			System.out.println("Approved data :- "+approveddata);
//			break;
//		}
		
		waitforElement(opsmanagerprofileicon);
		javascriptclick(opsmanagerprofileicon);
		
		waitforElement(opslogout);
		javascriptclick(opslogout);
		
		}
	
	public void vendormanagementrequesttorejectactionpage(String email, String pwd,String sidebarvendorname,  
			String approvedoverridetext ) throws InterruptedException
	{
		opssigninpage opssign = new opssigninpage(driver);	
		opssign.opssigninpage(email, pwd);
		
		ClickAction(sidebarvendorname);
		
		// select the left nav bar features by name
		waitforElement(rejectionrequestsubbtn);
		javascriptclick(rejectionrequestsubbtn);
		
		String url = driver.getCurrentUrl();
		System.out.println("URL :- "+ url);
		
		waitforElement(requesttorejectviewbutton);
		javascriptclick(requesttorejectviewbutton);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", undobutton);
				
//		waitforElement(undobutton);
//		javascriptclick(undobutton);		
//		
//		waitforElement(acceptbutton);
//		javascriptclick(acceptbutton);
		
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", approvebtn);
		
		waitforElement(approvebtn);
		javascriptclick(approvebtn);
		
		waitforElement(overrideapprovetextarea);
		overrideapprovetextarea.sendKeys(approvedoverridetext);
		
		waitforElement(approvewithoverridebtn);
		javascriptclick(approvewithoverridebtn);
		
		Thread.sleep(500);
		waitforElement(selectrating);
		javascriptclick(selectrating);
		
		waitforElement(approvewithratingbtn);
		javascriptclick(approvewithratingbtn);
		
		waitforElement(approvewithoverridebtn);
		javascriptclick(approvewithoverridebtn);
		
		Thread.sleep(500);
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
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            javascriptclick(element);
	            System.out.println("Clicked: " + card + " -> " + action + " ✅");

	            Thread.sleep(1500); // Allow popup/modal to appear

	            // ---- ADD NEW FUNCTIONALITY ----
	            if (action.equalsIgnoreCase("Reject")) {

	                // Locate textarea
//	                WebElement textarea = driver.findElement(By.xpath("//textarea[contains(@formcontrolname,'remarks') or contains(@placeholder,'Reason')]"));
//	                textarea.sendKeys("Rejecting due to automation test scenario");

	            	waitforElement(rejectionreasontextarea);
	            	rejectionreasontextarea.sendKeys("Rejecting due to automation test scenario");
	            	
	                // Locate Submit Rejection button
//	                WebElement submitRejectionButton = driver.findElement(By.xpath("//button[contains(text(),'Submit') or contains(text(),'Reject')]"));
	                
	            	wait.until(ExpectedConditions.elementToBeClickable(submitrejctionbutton));
	            	submitrejctionbutton.click(); 

	                System.out.println("Rejection submitted for card: " + card + " ❌");

	            } else if (action.equalsIgnoreCase("Accept")) {

	                // If Accept button already clicked above, no extra UI action needed
	                System.out.println("Accepted card: " + card + " ✔️");
	            }

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
	
	public void clickOnAssignedprofileviewbutton(int value)
	{
		 for(int i = 0; i< viewbuttonassignedprofiles.size(); i++)
		   {
			 viewbuttonassignedprofiles.get(value).click();
			   break;
		   }
	}
	
	public void clickOnrequesttorejectprofileviewbutton(int value)
	{
		 for(int i = 0; i< viewbuttonrequesttorejectprofile.size(); i++)
		   {
			 viewbuttonrequesttorejectprofile.get(value).click();
			   break;
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
