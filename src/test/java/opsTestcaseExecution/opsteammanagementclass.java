package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import customerpageobject.opsteammanagementpage;

public class opsteammanagementclass extends opsBaseclass {
	
	@Test
	public void Teammanagementpage() throws InterruptedException
	{
		team = new opsteammanagementpage(driver);
		team.opsteammanagement(prop.getProperty("opsemail"), prop.getProperty("password"));
	}

}
