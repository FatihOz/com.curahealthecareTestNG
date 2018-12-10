package com.curahealthecareTestNG.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.curahealthecareTestNG.Utilities.Driver;

public class LogoutPage {

	
	public LogoutPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//div[@class='text-vertical-center']/h3")
	public WebElement homePage;
	
	@FindBy(id ="menu-toggle")
	public WebElement hamburgerMenu;
	
	@FindBy(linkText="Logout")
	public WebElement logoutLink;

	
}
