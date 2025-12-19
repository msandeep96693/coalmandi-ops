package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opsticketmanagementpage;

public class opsticketmanagementcloseticketExecutionclass extends opsBaseclass {
	
	// working
	@Test(priority = 0, enabled = false)
	public void escalateticketpage() throws InterruptedException
	{
		opsticketmanagementpage ticket = new opsticketmanagementpage(driver);
		ticket.ticketmanagementaction(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarticketname"), prop.getProperty("ticketstatusoptionnameopen"));
	}
	
	@Test(priority = 1, enabled = true)
	public void closeticketbyopsadminpage() throws InterruptedException
	{
		opsticketmanagementpage ticket = new opsticketmanagementpage(driver);
		ticket.closeticketbyopsadmin(prop.getProperty("opsadminemail"), prop.getProperty("password"),
				prop.getProperty("sidebarticketname"), prop.getProperty("ticketstatusoptionnameescalated"));
	}
	
	// working
	@Test(priority = 2, enabled = false)
	public void Assignticketpage() throws InterruptedException, AWTException
	{
		opsticketmanagementpage ticket = new opsticketmanagementpage(driver);
		ticket.ticketmanagementassignpage(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarticketname"),prop.getProperty("ticketstatusoptionnameopen") ,
				prop.getProperty("opsexecutivename"));
				
				
	}
	

}
