package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opsordermanagementpage;

public class opsordermanagementExecutionclass extends opsBaseclass  {
	
	@Test(priority = 0, enabled = false)
	public void ordermanagementlistpage() throws InterruptedException
	{
		opsordermanagementpage order = new opsordermanagementpage(driver);
		order.opsordermanagementlistpage(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarordername"), prop.getProperty("statusoptionname"));
		
	}

}
