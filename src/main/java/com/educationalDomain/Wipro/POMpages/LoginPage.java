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
public class LoginPage 
{
	/**
	 * It is used to store all the login elements
	 */
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearsbtn;
	
	@FindBy(xpath = "(//a[text()=' SkillRary Demo APP'])[2]")
	private WebElement skillrarydemoapp;
	
	@FindBy(xpath = "//a[text()=' Contact Us ']")
	private WebElement contactusbtn;
	
	@FindBy(name = "q")
	private WebElement searchbox;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement searchbtn;
	
	public WebElement getGearsbtn() {
		return gearsbtn;
	}
	public WebElement getSkillrarydemoapp() {
		return skillrarydemoapp;
	}
	public WebElement getContactusbtn() {
		return contactusbtn;
	}
	public WebElement getSearchbox() {
		return searchbox;
	}
	public WebElement getSearchbtn() {
		return searchbtn;
	}
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public SkillraryDemoLoginPage demoApp(WebDriver driver)
	{
		gearsbtn.click();
		skillrarydemoapp.click();
		return new SkillraryDemoLoginPage(driver);
	}
	public ContactUsPage contactus(WebDriver driver)
	{
		contactusbtn.click();
		return new ContactUsPage(driver);
	}
	public CoreJavaPage searchcourse(String coursename,WebDriver driver)
	{
		searchbox.sendKeys(coursename);
		searchbtn.click();
		return new CoreJavaPage(driver);
	}
	
}
