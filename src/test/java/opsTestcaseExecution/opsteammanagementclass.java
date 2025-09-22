package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import customerpageobject.opsteammanagementpage;

public class opsteammanagementclass extends opsBaseclass {
	
	@Test
	public void Teammanagementpage() throws InterruptedException
	{
		team = new opsteammanagementpage(driver);
		team.opscreateteammanagement(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarfeaturename"), prop.getProperty("fullname"),
				prop.getProperty("emailID"), prop.getProperty("phonenumber"));
	}
	
	
}
