package opspageobject;

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
//		clickOnCard(" Udyam Certificate (MSME)", "Accept");
//		clickOnCard("IEC Certificate", "Accept");
//		clickOnCard("D&B Certificate", "Accept");
		
		
		
		waitforElement(submitreviewbtn);
		javascriptclick(submitreviewbtn);
		
		waitforElement(selectrating);
		javascriptclick(selectrating);
		
		waitforElement(approvewithratingbtn);
		javascriptclick(approvewithratingbtn);
		
		
		Thread.sleep(500);
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
