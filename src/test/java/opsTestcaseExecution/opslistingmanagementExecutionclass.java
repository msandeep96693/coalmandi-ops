package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opslistingmanagementpage;

public class opslistingmanagementExecutionclass extends opsBaseclass {
	
	@Test(priority = 0, enabled = false)
	public void listingmanagementlist()
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementlistpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"), prop.getProperty("searchbybusinessname"));
		
	}
	
	@Test(priority = 1, enabled = false)
	public void listingmanagementapproval()
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementapprovalpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"));
		
	}
	
	@Test(priority = 2, enabled = true)
	public void listingmanagementassign() throws AWTException, InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementassignpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"),prop.getProperty("opsexecutivename"));
		
	}
	
	@Test(priority = 3, enabled = false)
	public void listingmanagementrequesttoreject()
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementrequesttorejectpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"));
		
	}

}
