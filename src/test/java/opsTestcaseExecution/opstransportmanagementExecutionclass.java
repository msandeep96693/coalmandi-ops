package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opstransportmanagementpage;

public class opstransportmanagementExecutionclass extends opsBaseclass  {

	@Test
	public void createtransportmanagement() throws InterruptedException
	{
		opstransportmanagementpage transport = new opstransportmanagementpage(driver);
		transport.opscreatetransportmanagement(prop.getProperty("opsemail"), prop.getProperty("password"), 
				prop.getProperty("sidebartransportname"));
	}
}
