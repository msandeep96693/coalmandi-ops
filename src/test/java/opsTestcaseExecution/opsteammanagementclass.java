package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opsteammanagementpage;

public class opsteammanagementclass extends opsBaseclass {
	
//	@Test
	public void Teammanagementpage() throws InterruptedException
	{
		team = new opsteammanagementpage(driver);
		team.opscreateteammanagement(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarteamname"));
	}
	
//	@Test
	public void updateteammember() throws InterruptedException
	{
		team = new opsteammanagementpage(driver);
		team.opsupdateteammember(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarteamname"));
	}
	
	@Test
	public void listteammanagement() throws InterruptedException
	{
		team = new opsteammanagementpage(driver);
		team.listteammanagement(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarteamname"), prop.getProperty("emailsearchdata"),
				prop.getProperty("statusoptionname"));
	}
	
}
