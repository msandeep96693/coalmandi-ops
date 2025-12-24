package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;
import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;

public class opscustomermanagementExecutionclass extends opsBaseclass {
	
	// working
	@Test(priority = 0, enabled = false)
	public void opscustomermgmtactivitylistpage() throws AWTException, InterruptedException
	{
		opscustomermanagementpage activity = new opscustomermanagementpage(driver);
		activity.opscustomermanagementactivitylist(prop.getProperty("opsadminemail"),prop.getProperty("password"),
				prop.getProperty("sidebarcustmgmtname"),prop.getProperty("searchbycontactname"));
	}
		
	// working
	@Test(priority = 0, enabled = false)
	public void customermanagementapprovalflow() throws InterruptedException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.customermanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarcustmgmtname"));
	}
	
	
	@Test(priority = 0, enabled = false)
	public void customermanagementopsexecutiveapprovalflow() throws InterruptedException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.customermanagementexecutereject(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarcustmgmtname"));
	}

	@Test(priority = 1, enabled = false)
	public void customermanagementassignflow() throws InterruptedException, AWTException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.opscustomerprofileassignfunctionality(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcustmgmtname"), prop.getProperty("opsexecutivename"));
	}
	
	
	
	@Test(priority = 2, enabled = false)
	public void customermanagementrequesttorejectflow() throws InterruptedException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.customermanagementrequesttorejectactionpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("approvedoverridetext"));
	}
	
}
