package com.educationalDomain.Wipro.Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.educationalDomain.Wipro.POMpages.LoginPage;
import com.educationalDomain.Wipro.POMpages.SkillraryDemoLoginPage;
import com.educationalDomain.Wipro.POMpages.TestingPage;
import com.educationalDomain.Wipro.genericLib.BaseClass;

public class TestCase4 extends BaseClass
{
	@Test
	public void tc4() throws SQLException, FileNotFoundException, IOException
	{
		test=reports.createTest("tc4");
		LoginPage l=new LoginPage(driver);
		SkillraryDemoLoginPage s = l.demoApp(driver);
		utilities.switchTabs(driver);
		utilities.dropdown(s.getDropdown(), fu.getPropertyFile("dropdown"));
		s.testing(driver);
		fu.queryExecution("select * from verification", 1, "fhdfh");
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title4"));
	}
	
}
