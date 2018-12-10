package com.curahealthecareTestNG.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.curahealthecareTestNG.Utilities.Driver;

public class LoginPage {
	protected WebDriver driver;
	
	public LoginPage() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id ="menu-toggle")
	public WebElement hamburgerMenu;
	
	@FindBy(xpath="//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a") 
	public WebElement loginButtonOnMenu;
	
	@FindBy(id="txt-username")
	public WebElement userName;

	@FindBy(id = "txt-password")
	public WebElement passWord;

	@FindBy(id="btn-login")
	public WebElement loginButtonToAccount;
	
	@FindBy(xpath= "//div[@class='col-sm-12 text-center']/p[2]")   
	public WebElement invalidUserNamePwdErrMsg;
	
	public void login(String userId, String password) {
		hamburgerMenu.click();
		loginButtonOnMenu.click();
		userName.sendKeys(userId);
		passWord.sendKeys(password);
		loginButtonToAccount.click();
		
	}

}
