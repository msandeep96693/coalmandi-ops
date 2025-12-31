package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opscustomermanagementpage;
import opspageobject.opsvendormanagementpage;

public class opsvendormanagementExecutionclass  extends opsBaseclass {

	// working
	@Test(priority = 1, enabled = false)
	public void vendormanagementlistpage() throws InterruptedException 
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementactivitylistflow(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"), prop.getProperty("searchbyvendorcontactname"),
				prop.getProperty("todateformat"));
		}
	
	// working
	@Test(priority = 0, enabled = false)
	public void opsvendorapprovalflow() throws InterruptedException
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementactivitypage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"));
	}

	@Test(priority = 0, enabled = false)
	public void opsvendorassignflow() throws InterruptedException, AWTException
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.opsvendorprofileassignfunctionality(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"), prop.getProperty("opsexecutivename"));
	}
	
	@Test(priority = 0, enabled = false)
	public void opsvendorexecutereject() throws InterruptedException, AWTException
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementexecutereject(prop.getProperty("opsexecutiveemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"));
	}
	
	@Test(priority = 0, enabled = true)
	public void vendormanagementrequesttorejectflow() throws InterruptedException, AWTException
	{
		opsvendormanagementpage opsvendor = new opsvendormanagementpage(driver);
		opsvendor.vendormanagementrequesttorejectactionpage(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebarvendorname"), prop.getProperty("approvedoverridetext"));
	}
	
	
}
