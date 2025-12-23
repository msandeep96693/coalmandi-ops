package opspageobject;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.beans.DesignMode;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

	public class opstransporterBusinesscreationpage extends opsBasicpage {

		public opstransporterBusinesscreationpage(WebDriver driver)
		{
			super(driver);
		}
		
		// xpath business profile 
		
		@FindBy(xpath="//img[@alt='Coal Mandi']/../following-sibling::nav//button") 
		private List<WebElement> btnsSideBar;
		
//		@FindBy(xpath="/html/body/div/div/div/div[3]/div/div[2]/button/span")
		@FindBy(xpath = "//span[text()='Create Business Profile']/..")
		private WebElement btnCreateBusinessProfile;

		@FindBy(xpath="//input[@type='file']")
		private WebElement uploadProfile;
		
		@FindBy(xpath="(//input[@type='text'])[1]")
		private WebElement rememberastextField;
		
		@FindBy(xpath = "(//input[@type='text'])[2]")
		private WebElement gstnumberfield;
		
		@FindBy(xpath = "//span[.='Verify GST']") // /html/body/div[1]/div/div/div[2]/div/div/div[3]/div/form/div[3]/div/button/span
		private WebElement verifygstbutton;
		
		@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
		private List<WebElement> listofstate;
		
		@FindBy(xpath = "//div[@class='ant-select-item ant-select-item-option']")
		private List<WebElement> listofdistrict;
		
//	    @FindBy(xpath = "(//input[@type='search'])[2]")
//		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div[3]/div/form/div[6]/div[2]/div/div[2]/div/div/div/span[1]")
		@FindBy(xpath = "(//span[@class='ant-select-selection-search'])[2]")
		private WebElement districtdropdown;
		
		@FindBy(xpath = "//div[.='Anantapur']")  // //div[.='Anjaw']   state - Arunachal Pradesh
		private WebElement anantapuroption;
		
//		@FindBy(xpath = "(//input[@type='search'])[1]")
 		@FindBy(xpath = "(//span[@class='ant-select-selection-search'])[1]")
//		@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div/div/div/div/div/div[3]/div/form/div[6]/div[1]/div/div[2]/div/div/div/span[1]")
		private WebElement statedropdown;   
		
		@FindBy(xpath = "//div[.='Andhra Pradesh']")  // //div[.='Arunachal Pradesh']
		private WebElement andhrapradeshoption;
		
		
		
		
		@FindBy(xpath = "(//input[@type='text'])[7]")
		private WebElement contactnamefield;
		
		@FindBy(xpath = "(//input[@type='text'])[8]")
		private WebElement desginationfield;
		
		@FindBy(xpath = "//input[@type='email']")
		private WebElement emailfield;
		
		@FindBy(xpath = "(//input[@type='text'])[9]")
		private WebElement mobilenumberfield;
		
		
		
		@FindBy(xpath = "(//input[@type='search'])[3]")
		private WebElement onwershipdropdown;
		
		@FindBy(xpath = "//div[.='LLP']")  
		private WebElement llpoption;
		
		@FindBy(xpath = "(//input[@type='search'])[4]")
		private WebElement industrydropdown;
		
		@FindBy(xpath = "//div[.='Brick Kilns & Ceramics']")  
		private WebElement brickkilnoption;
		
		@FindBy(xpath = "(//div[@class='ant-select-selector'])[5]")  // (//input[@type='search'])[5]
		private WebElement producttotradedropdown;
		
		@FindBy(xpath = "//div[.='PET Coke']") 
		private WebElement petcokeoption;
		
		@FindBy(xpath = "//div[@title='Coking Coal (HSN - 27011910)']/div")  // //div[.='Coking Coal']
		private WebElement cokingcoaloption;
		
		@FindBy(xpath = "//div[.='Thermal Coal']")
		private WebElement thermalcoaloption;
		
		@FindBy(xpath = "//div[.='Metallurgical Coal (HSN - 27011910)']")
		private WebElement metallurgicalcoaloption;
		
		@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[2]")
		private WebElement originofcoaldropdown;
		
		@FindBy(xpath = "(//div[@class='ant-select-selection-overflow'])[3]")
		private WebElement portsofoperationdropdown;
		
		@FindBy(xpath = "//div[@class='ant-select-item-option-content']")
		private List<WebElement> alldropdownoption;
		
		@FindBy(xpath = "//div[.='Domestic']") 
		private WebElement domesticoption;  
		
		@FindBy(xpath = "//div[.='International']")
		private WebElement internationaloption;
		
		@FindBy(xpath = "//button[@type='submit']")
		private WebElement saveandproceedbutton;
		
		
		// add business profile address
		
		@FindBy(xpath = "//span[.='Add Sub-Business Unit']/..")
		private WebElement addbusinessunitbutton;
		
		@FindBy(xpath = "(//input[@type='text'])[3]")
		private WebElement businessnamefielddata;
		
		@FindBy(xpath = "//div[@class='ant-form-item-control-input']/div/textarea")
		private WebElement subunitaddressfielddata;
		
		@FindBy(xpath = "//span[.='Save']/..")
		private WebElement savebutton;
		
		@FindBy(xpath = "//span[.='Proceed to KYC']/..")
		private WebElement proceedtokycbutton;

		
		// kyc page
		@FindBy(xpath = "//button[.='Proceed to KYC']")
		private WebElement proceedtokycbutton1;
		
		@FindBy(xpath = "//input[@name='authorizationLetter']")
		private WebElement authorizationletter;
		
		@FindBy(xpath = "//input[@name='gstCertificateFile']")
		private WebElement gstCertificateFile;
		
		@FindBy(xpath = "//input[@type='file']")
		private List<WebElement> uploadFiles;
		
		@FindBy(xpath = "//input[@type='file']")
		private List<WebElement> uploadFiles1;
		
		@FindBy(xpath = "//span[@class='font-medium text-base']")
		private List<WebElement> labelList;
		
		@FindBy(xpath = "//button[@type='submit']")    // //span[.='Submit']/..
		private List<WebElement> submitButtons;
		
		@FindBy(xpath = "(//input[@type='text'])[3]")
		private WebElement TANnumbertextfield;
		
		@FindBy(xpath = "(//input[@type='text'])[4]")
		private WebElement LUTnumbertextfield;
		
		@FindBy(xpath = "(//span[.='Yes']/..)[1]")
		private WebElement LUTradioyesbutton;
		
		@FindBy(xpath = "(//input[@type='text'])[5]")
		private WebElement Ifsccodetextfield;
		
		@FindBy(xpath = "//button[.='Verify IFSC']")
		private WebElement verifyifscbtn;
		
		@FindBy(xpath = "//input[@type='password']")
		private WebElement accountnotextfield;
		
		@FindBy(xpath = "(//input[@type='number'])[1]")
		private WebElement confirmaccountnotextfield;
			
		@FindBy(xpath = "(//span[.='Yes']/..)[2]")
		private WebElement udyamyesradiobutton;
		
		@FindBy(xpath = "(//input[@type='text'])[8]")
		private WebElement udyamnotextfield;
		
		@FindBy(xpath = "(//span[@aria-label='calendar']/../..)[1]")
		private WebElement clickonudyamdatefield;
		
		@FindBy(xpath = "//button[contains(@class,'prev-button')]")
		private WebElement previousbutton;
		
		@FindBy(xpath = "//div[@class='react-calendar__month-view__days']/button/abbr")
		private List<WebElement> listofdates;
		
		@FindBy(xpath = "(//span[.='Yes']/..)[3]")
		private WebElement iecyesradiobutton;
		
		@FindBy(xpath = "(//input[@type='text'])[9]")
		private WebElement iecnotextfield;
		
		@FindBy(xpath = "(//span[@aria-label='calendar']/../..)[2]")
		private WebElement clickoniecdatefield;
		
		@FindBy(xpath = "(//input[@type='number'])[2]")
		private WebElement DnBnotextfield;
		
		@FindBy(xpath = "//button[.='Save & Proceed']")
		private WebElement saveproceedbuton;
		
		@FindBy(xpath = "//span[.='Confirm info correctness']")
		private WebElement confirminfocorrectnesscheckbox;
		
		@FindBy(xpath = "//span[.='Accept terms']")
		private WebElement accepttermscheckbox;
		
		@FindBy(xpath = "//button[.='Submit for Verification']")
		private WebElement submitforverification;

		@FindBy(xpath = "//span[.='Is Same as Business Owner ?']")
		private WebElement Issameasbusinessownercheckbox;
		
		//Transporter xpath
		
		@FindBy(xpath = "//button[.='Add Transporter']")
		private WebElement addtransportbtn;

		@FindBy(xpath = "(//div[@class='ant-select-selector'])[7]")
		private WebElement sourceofcoaldropdown;
		
		@FindBy(xpath = "(//input[@type='text'])[11]")
		private WebElement licensenumberfield;
		
		@FindBy(xpath = "//input[@placeholder='Enter vehicle number']")
		private WebElement vehiclenumberfield;
		
		@FindBy(xpath = "//input[@placeholder='Enter capacity']")
		private WebElement vehiclecapacityfield;
		
		// kyc page
		
		@FindBy(xpath = "(//input[@type='file'])[1]")
		private WebElement authorizationuploadfile;
		
		@FindBy(xpath = "(//input[@type='file'])[2]")
		private WebElement pancarduploadfile;
		
		@FindBy(xpath = "//span[@aria-label='user']") 
		private WebElement profileicon;
		
		@FindBy(xpath = "//span[.='Settings']/..")
		private WebElement settingbtn;
		
		@FindBy(xpath = "//div[@data-node-key='business_profiles']")
		private WebElement businessprofiletab;
		
		@FindBy(xpath = "//button[.='Add Business Profile']")
		private WebElement addbusinessprofilebtn;
		
		// transport account creation xpath
		@FindBy(xpath = "(//input[@type='text'])[1]") 
		private WebElement fullnametextfield;

		@FindBy(xpath = "(//input[@type='text'])[2]")
		private WebElement whatsappnumbertextfield;
		
		@FindBy(xpath = "(((//label[@title='WhatsApp Number (Primary)'])[2]/../following-sibling::div/div)[1]/div/span/span/span/div/div/span/span)[1]/input") 
		private WebElement countrycodetextfiled;
		
//		@FindBy(xpath = "(//label[@title='Email ID'])[2]/../following-sibling::div/div/div/input") 
		@FindBy(xpath = "//input[@type='email']")
		private WebElement emailIDtextfield;
		
		@FindBy(xpath = "//button[@type='submit']/span")
		private WebElement sendotpbutton;

		@FindBy(xpath = "//*[@id='root']/div[2]/div/div/form/div[1]/div[2]/div/div/div/div/div/div/input")
		private List<WebElement> whatsappotpinputfield;
		
		@FindBy(xpath = "//*[@id='root']/div[2]/div/div/form/div[2]/div[2]/div/div/div/div/div/div/input")
		private List<WebElement> emailotpinputfield;
		
		@FindBy(xpath = "(//input[@type='password'])[1]")
		private WebElement enterpassword;
		
		@FindBy(xpath = "(//input[@type='password'])[2]")
		private WebElement enterconfirmpassword;
		
		@FindBy(xpath = "//span[.='Create Account']")
		private WebElement createaccountbtn;
		
		public void Transportercreatebbusinessprofile(
				 String email, String pwd,  String transportname, String mobilenumber,
				 String createpassword, String confirmpassword,  String gstnumber,  
				 String designation,String ifsccode, String accountno, String confirmaccountno, 
				 String udyamno, String udyamdateno,
				String iecdateno, String licensenumber  
				) throws InterruptedException, AWTException  
		{ 
			opssigninpage opssign = new opssigninpage(driver);
			opssign.opssigninpage(email, pwd); 
			
//			createaccountpage account = new createaccountpage(driver);
//			account.createbusinessaccount(mobilenumber, createpassword, confirmpassword);
			
			ClickAction(transportname);
			
			waitforElement(addtransportbtn);
			javascriptclick(addtransportbtn);
			
			switchtoanothertab();
			
			// enter a fullname into field
			try {
				waitforElement(fullnametextfield);
				fullnametextfield.sendKeys(setRandomName());
			} catch (StaleElementReferenceException e) {
				waitforElement(fullnametextfield);
				fullnametextfield.sendKeys(setRandomName());
			}
			
			
			
			// enter a whatsapp number 
			waitforElement(whatsappnumbertextfield);
			whatsappnumbertextfield.sendKeys(mobilenumber);
			
			// enter a emailID
			waitforElement(emailIDtextfield);
			emailIDtextfield.sendKeys(setRandomEmail());
			
			// click on send otp button
			Thread.sleep(2000);
			javascriptclick(sendotpbutton);
			
//			// enter otp into textfields and click enter button on keyboard
			
//			wait.until(d -> whatsappotpinputfield.stream().allMatch(field -> !field.getAttribute("value").isEmpty()));
			
			// Give user 15 seconds to enter OTP
			Thread.sleep(25000);
			
			// enter password
			waitforElement(enterpassword);
			enterpassword.sendKeys(createpassword);

			// enter confirm password
			waitforElement(enterconfirmpassword);
			enterconfirmpassword.sendKeys(confirmpassword);
			
			// click on create account button
			waitforElement(createaccountbtn);
			javascriptclick(createaccountbtn);
			
			waitforElement(btnCreateBusinessProfile);
			javascriptclick(btnCreateBusinessProfile);
			
			// upload a business profile image
			try {
				Thread.sleep(5000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].style.display='block';", uploadProfile);
				uploadProfile.sendKeys("/home/active34/Downloads/photos /QA club photos/Club 7.png");
				} catch (ElementNotInteractableException e) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].style.display='block';", uploadProfile);
					uploadProfile.sendKeys("/home/active34/Downloads/photos /QA club photos/Club 7.png");
				}  // /home/active34/Downloads/photos /QA club photos/business logo.jpeg
			// C:\Users\User\Desktop\Background images\Bg-1.jpg
			
			// remember me as textfield
			waitforElement(rememberastextField);      
			rememberastextField.sendKeys(setRandomBusinessName());
			
			// Enter GST number 
			waitforElement(gstnumberfield);
			gstnumberfield.sendKeys(gstnumber);
			String GSTnumber = gstnumberfield.getText();
			
			// enter gst verify button
			waitforElement(verifygstbutton);
			verifygstbutton.click();
	
			Thread.sleep(3000);
			
			// ownership 
			waitforElement(onwershipdropdown);
			onwershipdropdown.click();
			
			Thread.sleep(1000);
			selectDropdownOption(alldropdownoption, "LLP");
			
			// industry
			waitforElement(industrydropdown);
			industrydropdown.click();
			
			waitforElement(brickkilnoption);
			javascriptclick(brickkilnoption);
			
//			Thread.sleep(1000);
//			selectDropdownOption(alldropdownoption, "cement");			
			
			// product to trade
			waitforElement(producttotradedropdown);
			producttotradedropdown.click();
			
			Thread.sleep(1000);
			alldropdownoption.get(0).click();
			Thread.sleep(1000);
			alldropdownoption.get(1).click();
			
//			Thread.sleep(1000);
//			selectDropdownOption(alldropdownoption, "Metallurgical");
//			Thread.sleep(1000);
//			selectDropdownOption(alldropdownoption, "Thermal");
			
			Thread.sleep(1000);
			Robot rob=new Robot();
			rob.keyPress(KeyEvent.VK_ESCAPE);
			rob.keyRelease(KeyEvent.VK_ESCAPE);
			
			Hiddenelement(originofcoaldropdown);
			
			// origin of coal
			waitforElement(originofcoaldropdown);
			originofcoaldropdown.click();
			
			Thread.sleep(1000);
//			selectDropdownOption(alldropdownoption, "Domestic");
			alldropdownoption.get(4).click();
			Thread.sleep(1000);
//			selectDropdownOption(alldropdownoption, "International");
			alldropdownoption.get(5).click();
			
			Robot rob1=new Robot();
			rob1.keyPress(KeyEvent.VK_ESCAPE);
			rob1.keyRelease(KeyEvent.VK_ESCAPE);
			
			// Source of coal
			waitforElement(sourceofcoaldropdown);
			sourceofcoaldropdown.click();
						
			Thread.sleep(1000);
			selectDropdownOption(alldropdownoption, "Private");
			Thread.sleep(1500);
			selectDropdownOption(alldropdownoption, "CIL");
					
			rob.keyPress(KeyEvent.VK_ESCAPE);
			rob1.keyRelease(KeyEvent.VK_ESCAPE);
			
			waitforElement(vehiclenumberfield);
			vehiclenumberfield.sendKeys("KA34BB12345");
			
			waitforElement(vehiclecapacityfield);
			vehiclecapacityfield.sendKeys("100");

			
			// Is same as business owner
//			waitforElement(Issameasbusinessownercheckbox);
//			javascriptclick(Issameasbusinessownercheckbox);
			
			// contact info data
			// -----------------------------------
			// enter contact name 
			waitforElement(contactnamefield);
			contactnamefield.sendKeys(setRandomName());
			
			// enter designation 
			waitforElement(desginationfield);
			desginationfield.sendKeys(designation);
			
			// enter email 
			waitforElement(emailfield);
			emailfield.sendKeys(setRandomEmail());
			
			// enter contact number
			waitforElement(mobilenumberfield);
			mobilenumberfield.sendKeys(setRandomMobileNumber());
			
			// click on save & proceed button
			waitforElement(saveandproceedbutton);
			saveandproceedbutton.click();
			
			scrollBottomofPage();
			
			// verify review page
			String Reviewurl = driver.getCurrentUrl();
			System.out.println(Reviewurl);
			
			Thread.sleep(2000);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", proceedtokycbutton);
			
			// click on proceed to kyc button
			waitforElement(proceedtokycbutton);
			javascriptclick(proceedtokycbutton);
			
			// -----------------------------------------------------
			
			// KYC document
			// authorization 
			Thread.sleep(2000);
			kycdocuploadandsubmit("Authorization Letter", uploadFiles, submitButtons);
			
//			// PAN Card
			Thread.sleep(1500);
			kycdocuploadandsubmit("PAN Card", uploadFiles, submitButtons);
			Thread.sleep(1500);
			
			// GST Certificate 
			kycdocuploadandsubmit("GST Certificate", uploadFiles, submitButtons);
			Thread.sleep(1500);
			
			// TAN certificate
			waitforElement(TANnumbertextfield);
			TANnumbertextfield.sendKeys(setRandomMobileNumber());
			
			Thread.sleep(1000);
			kycdocuploadandsubmit("TAN Certificate", uploadFiles, submitButtons);
			Thread.sleep(3000);
					
			// LUT Certificate
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			By radioBtn = By.xpath("(//input[@type='radio'])[1]");

			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(radioBtn));

//			// Scroll to element
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			
			waitforElement(LUTradioyesbutton);
			LUTradioyesbutton.click();
			
			Thread.sleep(2000);
			waitforElement(LUTnumbertextfield);
			LUTnumbertextfield.sendKeys(setRandomMobileNumber());
			
			kycdocuploadandsubmit("LUT Certificate", uploadFiles, submitButtons);
			Thread.sleep(2000);			
			
			// Bank Details
			Thread.sleep(1000);
			waitforElement(Ifsccodetextfield);
			Ifsccodetextfield.clear();
			Ifsccodetextfield.sendKeys(ifsccode);
			
			waitforElement(verifyifscbtn);
			javascriptclick(verifyifscbtn);
			
			Thread.sleep(3000);
			waitforElement(accountnotextfield);
			accountnotextfield.clear();
			accountnotextfield.sendKeys(accountno);
			
			Thread.sleep(1000);
			waitforElement(confirmaccountnotextfield);
			confirmaccountnotextfield.clear();
			confirmaccountnotextfield.sendKeys(confirmaccountno);
		
			
			Thread.sleep(1000);
			kycdocuploadandsubmit("Bank Details", uploadFiles, submitButtons);
			Thread.sleep(1000);
			
			// udyam certificate
			
			
			waitforElement(udyamyesradiobutton);
			javascriptclick(udyamyesradiobutton);
			
			Thread.sleep(1000);
			waitforElement(udyamnotextfield);
			udyamnotextfield.sendKeys(udyamno);
			
			Thread.sleep(1000);
			// udyam date picker pending
			waitforElement(clickonudyamdatefield);
			javascriptclick(clickonudyamdatefield);
			
			Thread.sleep(1000);
			datepicker(udyamdateno);
			
			Thread.sleep(1000);
			kycdocuploadandsubmit("Udyam Certificate (MSME)", uploadFiles, submitButtons);
			Thread.sleep(1000);
			
			
			// IEC certificate
			
			
//			waitforElement(iecyesradiobutton);
////			javascriptclick(iecyesradiobutton);
//			iecyesradiobutton.click();
			
			Thread.sleep(1000);
			waitforElement(iecnotextfield);
			iecnotextfield.sendKeys(setRandomMobileNumber());
			
			Thread.sleep(1000);
			// date picker iec 
			waitforElement(clickoniecdatefield);
			javascriptclick(clickoniecdatefield);
			
			Thread.sleep(1000);
			datepicker(iecdateno);
			
			Thread.sleep(1000);
			kycdocuploadandsubmit("IEC Certificate", uploadFiles, submitButtons);
			Thread.sleep(1000);
			
			// Licence number
			waitforElement(licensenumberfield);
			licensenumberfield.sendKeys(licensenumber);
			
			Thread.sleep(1000);
			kycdocuploadandsubmit("License Document (Permit/RC)", uploadFiles, submitButtons);
			Thread.sleep(1000);
			
			scrollBottomofPage();
			
			waitforElement(saveproceedbuton);
			javascriptclick(saveproceedbuton);
			
			scrollBottomofPage();
			
			// Review page - Two check box
			waitforElement(confirminfocorrectnesscheckbox);
			javascriptclick(confirminfocorrectnesscheckbox);
			
			waitforElement(accepttermscheckbox);
			javascriptclick(accepttermscheckbox);
			
			Thread.sleep(2000);
//			// submit for verification 
			waitforElement(submitforverification);
			javascriptclick(submitforverification);
			
			Thread.sleep(1000);
			
			System.out.println("Business profile created and your Your KYC documents are being reviewed.");
			
		
	}

		
		public void kycdocuploadandsubmit(String labelnames, List<WebElement> uploadFiles, List<WebElement> submitButtons) throws InterruptedException 
		{
			
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			 
			 for (int i = 0; i < labelList.size(); i++) {
		        String labelText = labelList.get(i).getText().trim();
		        System.out.println("Found label: " + labelText);

		        if (labelText.contains(labelnames)) {
		        	
		            WebElement uploadInput = uploadFiles.get(i);
		            WebElement submitButton = submitButtons.get(i);	

		            // Make upload input visible (if hidden)
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            js.executeScript("arguments[0].style.display='block';", uploadInput);
		            
		            //Wait until input is clickable before upload
//		            wait.until(ExpectedConditions.elementToBeClickable(uploadInput));
		            
		            Thread.sleep(3000);
// /home/active34/Downloads/photos /QA club photos/Club 7.png
		          //  C:\\Users\\User\\Desktop\\Background images\\Bg-1.jpg
		            // Upload the file
		            uploadInput.sendKeys("/home/active34/Downloads/photos /QA club photos/Club 7.png");
		            System.out.println("✅ File uploaded for label: " + labelnames);
		            
		            js.executeScript("arguments[0].scrollIntoView({block: 'center'});", submitButton);
		            
		            // Click the corresponding submit button
		            js.executeScript("arguments[0].click();", submitButton);
		            
//		            Thread.sleep(3000);
		            System.out.println("✅ Submit button clicked for label: " + labelnames);

		            // ✅ Confirmation handling - Toast/Popup message
		            try {
//		            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		                WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
		                    By.xpath("//div[@class='ant-notification-notice-message']")
		                ));
		                System.out.println("✅ Confirmation: " + confirmationMsg.getText());
		            } catch (org.openqa.selenium.TimeoutException e) {
		                System.out.println("⚠ No confirmation message appeared — continuing...");
		            } 
		            break;
		        }
		    }
		}


		
		public void datepicker(String dateno) throws InterruptedException
		{
			javascriptclick(previousbutton);
			Thread.sleep(500);
			javascriptclick(previousbutton);
			Thread.sleep(500);
			
			
			for (WebElement date : listofdates) {
		        String dateText = date.getText().trim(); 
		        if (dateText.equals(dateno)) {
		            date.click();
		            System.out.println("✅ Date selected: " + dateno);
		            break;
		        }
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
		
		public void switchtoanothertab()
		{
			// Store current window handle
			String parentWindow = driver.getWindowHandle();
			System.out.println("Parent ID - "+ parentWindow);

			// Wait for new tab to appear
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(driver -> driver.getWindowHandles().size() > 1);

			// Switch to the newly opened tab
			for (String windowHandle : driver.getWindowHandles()) {
			    if (!windowHandle.equals(parentWindow)) {
			        driver.switchTo().window(windowHandle);
			        break;
			    }
			}
			
			// Now you are in the new tab and can interact with elements there
			System.out.println("Switched to new tab: " + driver.getTitle());
		}
}
