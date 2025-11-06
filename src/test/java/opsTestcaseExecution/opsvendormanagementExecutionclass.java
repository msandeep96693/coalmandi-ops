package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;
import opspageobject.opsvendormanagementpage;

public class opsvendormanagementExecutionclass  extends opsBaseclass {

	@Test
	public void opsvendorapprovalflow() throws InterruptedException
	{
		opsvendormanagementpage customer = new opsvendormanagementpage(driver);
		customer.customermanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"));
	}
}
