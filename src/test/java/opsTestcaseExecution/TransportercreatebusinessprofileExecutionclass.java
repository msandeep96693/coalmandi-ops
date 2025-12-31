package opsTestcaseExecution;

import java.awt.AWTException;

import org.testng.annotations.Test;


import Basepackage.opsBaseclass;
import opspageobject.consumerBusinesscreationpage;
import opspageobject.opstransporterBusinesscreationpage;

public class TransportercreatebusinessprofileExecutionclass extends opsBaseclass  {

	@Test(priority = 0, enabled = true)
	public void TransportercreatebusinessprofileExecutionclass() throws InterruptedException, AWTException
	{
		Transporterprofile = new opstransporterBusinesscreationpage(driver);
		Transporterprofile.Transportercreatebbusinessprofile(prop.getProperty("opsemail"), prop.getProperty("password"),prop.getProperty("sidebartransportname"),
				prop.getProperty("mobilebnumber"),prop.getProperty("createpassword"),prop.getProperty("confirmpassword"), 
				prop.getProperty("gstnumber"), prop.getProperty("designation"), prop.getProperty("IFSCcode"), prop.getProperty("accountno"),
				 prop.getProperty("confirmaccountno"),prop.getProperty("udyamno"), prop.getProperty("udyamdateno"),
				 prop.getProperty("iecdateno"), prop.getProperty("licensenumber")
				 );		
		  	
	}
	
	@Test(priority = 0, enabled = false)
	public void TransportercreatebusinessprofileExecutionclass2() throws InterruptedException, AWTException
	{
		consumerBusinesscreationpage Transporterprofile = new consumerBusinesscreationpage(driver);
		Transporterprofile.Transportercreatebbusinessprofile(prop.getProperty("opsemail"), prop.getProperty("password"),prop.getProperty("sidebartransportname"),
				prop.getProperty("mobilebnumber"),prop.getProperty("createpassword"),prop.getProperty("confirmpassword"), 
				prop.getProperty("gstnumber"), prop.getProperty("designation"), prop.getProperty("IFSCcode"), prop.getProperty("accountno"),
				 prop.getProperty("confirmaccountno"),prop.getProperty("udyamno"), prop.getProperty("udyamdateno"),
				 prop.getProperty("iecdateno"), prop.getProperty("licensenumber")
				 );		
		  	
	}
	
	// working
	@Test(priority = 1, enabled = false)
	public void TransporterlistExecutionclass() throws InterruptedException, AWTException
	{
		Transporterprofile = new opstransporterBusinesscreationpage(driver);
		Transporterprofile.transportermanagementlistpage(prop.getProperty("opsemail"), 
				prop.getProperty("password"), prop.getProperty("sidebartransportname"));				  	
	}
}
