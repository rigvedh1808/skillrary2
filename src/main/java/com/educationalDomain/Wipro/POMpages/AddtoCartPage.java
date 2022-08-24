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
public class AddtoCartPage 
{
	@FindBy(id = "add")
	private WebElement addbtn;
	
	@FindBy(xpath = "//button[text()=' Add to Cart']")
	private WebElement addtocartbtn;

	public WebElement getAddbtn() {
		return addbtn;
	}
	
	public WebElement getAddtocartbtn() {
		return addtocartbtn;
	}
	public AddtoCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
