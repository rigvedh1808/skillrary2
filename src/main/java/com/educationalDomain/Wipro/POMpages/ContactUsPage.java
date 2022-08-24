package com.educationalDomain.Wipro.POMpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Prateek
 *
 */
public class ContactUsPage
{
	@FindBy(name = "name")
	private WebElement nametb;
	
	@FindBy(name = "sender")
	private WebElement emailtb;
	
	@FindBy(name = "subject")
	private WebElement subjecttb;
	
	@FindBy(name = "message")
	private WebElement messagetb;
	
	@FindBy(xpath = "//button[text()='Send us mail']")
	private WebElement sendbtn;
	
	
	public ContactUsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void sendDetails(String name,String email,String subject,String message)
	{
		nametb.sendKeys(name);
		emailtb.sendKeys(email);
		subjecttb.sendKeys(subject);
		messagetb.sendKeys(message);
		sendbtn.click();
	}
}
