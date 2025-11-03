package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;
import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;

public class opscustomermanagementExecutionclass extends opsBaseclass {
	
	@Test(priority = 0, enabled = false)
	public void customermanagementapprovalflow() throws InterruptedException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.customermanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarcustmgmtname"));
	}

	@Test(priority = 0, enabled = true)
	public void customermanagementassignflow() throws InterruptedException, AWTException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.opscustomerprofileassignfunctionality(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarcustmgmtname"), prop.getProperty("opsexecutivename"));
	}
	
	@Test
	public void customermanagementrequesttorejectflow() throws InterruptedException
	{
		opscustomermanagementpage customer = new opscustomermanagementpage(driver);
		customer.customermanagementrequesttorejectactionpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("approvedoverridetext"));
	}
}
