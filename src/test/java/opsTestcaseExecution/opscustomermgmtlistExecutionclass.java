package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementlistpage;

public class opscustomermgmtlistExecutionclass extends opsBaseclass {
	
	@Test
	public void opscustomermgmtactivitylistpage() throws AWTException, InterruptedException
	{
		opscustomermanagementlistpage activity = new opscustomermanagementlistpage(driver);
		activity.opscustomermanagementactivitylist(prop.getProperty("opsemail"),prop.getProperty("password"),
				prop.getProperty("sidebarcustmgmtname"),prop.getProperty("searchbycontactname"));
	}
	
	

}
