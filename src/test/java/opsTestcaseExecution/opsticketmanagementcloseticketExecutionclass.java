package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opsticketmanagementpage;

public class opsticketmanagementcloseticketExecutionclass extends opsBaseclass {
	
	@Test
	public void closeticketpage() throws InterruptedException
	{
		opsticketmanagementpage ticket = new opsticketmanagementpage(driver);
		ticket.ticketmanagementaction(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarticketname"));
	}
	
	
	//@Test
	public void Assignticketpage() throws InterruptedException, AWTException
	{
		opsticketmanagementpage ticket = new opsticketmanagementpage(driver);
		ticket.listingmanagementassignpage(prop.getProperty("opsemail"), prop.getProperty("password"),
				prop.getProperty("sidebarticketname"), prop.getProperty("opsexecutivename"));
				
				
	}
	

}
