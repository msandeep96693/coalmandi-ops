package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opslistingmanagementpage;

public class opslistingmanagementExecutionclass extends opsBaseclass {
	
	//working
	@Test(priority = 0, enabled = true)
	public void listingmanagementlist() throws InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementlistpage(prop.getProperty("opsadminemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"), prop.getProperty("searchbybusinessname"));
	}
	
	// working
	@Test(priority = 1, enabled = false)
	public void listingmanagementapproval() throws InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementapprovalpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"));
	}
	
	// working
	@Test(priority = 1, enabled = false)
	public void listingmanagementrequesttorejctexecutive() throws InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementexecutiverejectpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"));
		
	}
	
	// working
	@Test(priority = 2, enabled = false)
	public void listingmanagementassign() throws AWTException, InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementassignpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"),prop.getProperty("opsexecutivename"));
		
	}
	
	// working
	@Test(priority = 3, enabled = false)
	public void listingmanagementrequesttoreject() throws InterruptedException
	{
		opslistingmanagementpage list = new opslistingmanagementpage(driver);
		list.listingmanagementrequesttorejectpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarlistingname"));
		
	}
	
	

}
