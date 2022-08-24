package com.educationalDomain.Wipro.Scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.educationalDomain.Wipro.POMpages.ContactUsPage;
import com.educationalDomain.Wipro.POMpages.LoginPage;
import com.educationalDomain.Wipro.genericLib.BaseClass;

public class TestCase2 extends BaseClass
{
	
	@Test(dataProvider = "readExcelData")
	public void tc2(String name,String email,String subject,String message) throws EncryptedDocumentException, IOException, InterruptedException
	{
		test=reports.createTest("tc2");
		LoginPage l=new LoginPage(driver);
		Thread.sleep(3000);
		ContactUsPage c = l.contactus(driver);
		Thread.sleep(3000);
		c.sendDetails(name,email,subject,message);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title2"));
	}
}
