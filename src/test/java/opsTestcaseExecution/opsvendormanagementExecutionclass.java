package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;
import opspageobject.opsvendormanagementpage;

public class opsvendormanagementExecutionclass  extends opsBaseclass {

	// working
	@Test(priority = 0, enabled = true)
	public void opsvendorapprovalflow() throws InterruptedException
	{
		opsvendormanagementpage customer = new opsvendormanagementpage(driver);
		customer.vendormanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"));
	}
}
