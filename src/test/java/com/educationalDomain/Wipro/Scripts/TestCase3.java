package com.educationalDomain.Wipro.Scripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.educationalDomain.Wipro.POMpages.CoreJavaPage;
import com.educationalDomain.Wipro.POMpages.LoginPage;
import com.educationalDomain.Wipro.POMpages.WishlistPage;
import com.educationalDomain.Wipro.genericLib.BaseClass;

public class TestCase3 extends BaseClass
{
	@Test
	public void tc3() throws FileNotFoundException, IOException, InterruptedException
	{
		
		test=reports.createTest("tc3");
		LoginPage l=new LoginPage(driver);
		CoreJavaPage c = l.searchcourse(fu.getPropertyFile("cn"), driver);
		WishlistPage w = c.corejavaselenium(driver);
		w.getAccpetbtn().click();
		Thread.sleep(5000);
		utilities.switchframe(driver);
		w.playpause();
		utilities.switchbackfromframe(driver);
		w.getAddtowishlist().click();
		
		Assert.assertEquals(driver.getTitle(), fu.getPropertyFile("title3"));
	}
}
