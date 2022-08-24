package com.educationalDomain.Wipro.Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.educationalDomain.Wipro.POMpages.AddtoCartPage;
import com.educationalDomain.Wipro.POMpages.LoginPage;
import com.educationalDomain.Wipro.POMpages.SkillraryDemoLoginPage;
import com.educationalDomain.Wipro.genericLib.BaseClass;

public class TestCase1 extends BaseClass
{
	@Test
	public void tc1() throws FileNotFoundException, IOException
	{
		test=reports.createTest("tc1");
		LoginPage l=new LoginPage(driver);
		SkillraryDemoLoginPage s = l.demoApp(driver);
		utilities.switchTabs(driver);
		utilities.mouseHover(driver, s.getCoursebtn());
		AddtoCartPage cart = s.course(driver);
		utilities.doubleclick(driver, cart.getAddbtn());
		cart.getAddtocartbtn().click();
		utilities.alertpopupok(driver);
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title1"));
	}
}
