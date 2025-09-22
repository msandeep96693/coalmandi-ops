package opsTestcaseExecution;

import org.testng.annotations.Test;

import Basepackage.opsBaseclass;
import opspageobject.opssigninpage;

public class opssigninExecustionclass extends opsBaseclass {
	
	@Test
	public void opssignin()
	{
		opssign = new opssigninpage(driver);
		opssign.opssigninpage(prop.getProperty("opsemail"), prop.getProperty("password"));
	}

}
