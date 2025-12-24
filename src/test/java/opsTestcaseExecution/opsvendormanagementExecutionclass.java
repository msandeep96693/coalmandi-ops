package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;
import opspageobject.opsvendormanagementpage;

public class opsvendormanagementExecutionclass  extends opsBaseclass {

	// working
	@Test(priority = 0, enabled = false)
	public void opsvendorapprovalflow() throws InterruptedException
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"));
	}
	
	// working
	@Test(priority = 1, enabled = true)
	public void vendormanagementlistpage() throws InterruptedException 
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementactivitylistflow(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"), prop.getProperty("searchbyvendorcontactname"),
				prop.getProperty("todateformat"));
	}
}
