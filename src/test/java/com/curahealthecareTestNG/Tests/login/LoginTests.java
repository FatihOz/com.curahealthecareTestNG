package com.curahealthecareTestNG.Tests.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.curahealthecareTestNG.Pages.LoginPage;
import com.curahealthecareTestNG.Pages.MakeAppointment;
import com.curahealthecareTestNG.Tests.TestBase;
import com.curahealthecareTestNG.Utilities.ConfigurationReader;


public class LoginTests extends TestBase {


	
	@Test(priority = 0)
	public  void positiveloginTest() {

		extentLogger = report.createTest("Positive login test");

		extentLogger.info("User Entered Valid Credentials!");
		LoginPage lp = new LoginPage();
		lp.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		MakeAppointment mp = new MakeAppointment();
		String actual = mp.makeAppoitmentPage.getText();
		 Assert.assertEquals(actual,"Make Appointment");
		 extentLogger.pass("Verified User is on Dashbourd message:\"Make Appointment\"");
	}

	@Test(priority = 1)
	public void invalidUsernameTest() {
		extentLogger = report.createTest("Negative login test");
		LoginPage lp = new LoginPage();
		lp.login("Joe","osp");
		String errorText = lp.invalidUserNamePwdErrMsg.getText();
		Assert.assertEquals(errorText, "Login failed! Please ensure the username and password are valid.");
		extentLogger.pass("Verified error message: \"Login failed! Please ensure the username and password are valid.\"");

	}


}