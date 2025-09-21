package customerpageobject;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class opssigninpage extends opsBasicpage {

	public opssigninpage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement emailFieldLocator;
	
	@FindBy(xpath = "(//input[@type='password'])[1]")
	private WebElement passwordFieldLocator;
	
	@FindBy(xpath="//span[.='Request to reset']")
	private WebElement lnkRequestToReset;
	
	@FindBy(xpath="(//button[@type='submit'])[1]") 
	private WebElement btnLogin;
	
	@FindBy(xpath = "//img[@alt='Coal Mandi']/../following-sibling::nav//button")
	private List<WebElement> btnsSideBar;
	
	
	public void opssigninpage(String email, String pwd)
	{
		// enter a emailID
		waitforElement(emailFieldLocator);
		emailFieldLocator.sendKeys(email);
		// enter a password
		waitforElement(passwordFieldLocator);
		System.out.println("password :- "+ passwordFieldLocator);
		System.out.println("password :- "+ pwd);
		passwordFieldLocator.sendKeys(pwd);
		// click on signin button
		waitforElement(btnLogin);
		javascriptclick(btnLogin);
	}
}
