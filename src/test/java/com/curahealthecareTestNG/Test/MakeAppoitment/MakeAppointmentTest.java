package com.curahealthecareTestNG.Test.MakeAppoitment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.curahealthecareTestNG.Pages.LoginPage;
import com.curahealthecareTestNG.Pages.LogoutPage;
import com.curahealthecareTestNG.Pages.MakeAppointment;
import com.curahealthecareTestNG.Tests.TestBase;
import com.curahealthecareTestNG.Utilities.BrowserUtils;
import com.curahealthecareTestNG.Utilities.ConfigurationReader;

public class MakeAppointmentTest extends TestBase {

	@Test()
	public void makeAppointmentTest() throws Exception {

		extentLogger = report.createTest("Make Appointment test 1");

		LoginPage lp = new LoginPage();
		MakeAppointment mp = new MakeAppointment();
		lp.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
		BrowserUtils.waitFor(2);
		String actual = mp.makeAppoitmentPage.getText();
		String expected = "Make Appointment";
		Assert.assertEquals(actual, expected);

		WebElement element = driver.findElement(By.id("combo_facility"));
		Select dropDown = new Select(element);
		dropDown.selectByIndex(1);
		BrowserUtils.waitFor(2);

		mp.selectMedicaid.click();
		BrowserUtils.waitFor(2);

		///////////////////////////////////////////////

		extentLogger = report.createTest("Make Appointment test 2");

		mp.visitDate.click();
		Random rd = new Random();
		LocalDate ld = LocalDate.now().plusDays(rd.nextInt(50));
		String myDate = ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		mp.visitDate.sendKeys(myDate);
		BrowserUtils.waitFor(5);
		BrowserUtils.getScreenshot(myDate);

		//////////////////////////////////////////////////////

		extentLogger = report.createTest("Make Appointment test 3");

		mp.writeComment.sendKeys("I have Doctor Appointment at 11:00am");
		BrowserUtils.waitFor(3);
		mp.bookAppointment.click();
		BrowserUtils.waitFor(3);
		Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

		/////////////////////////////////////////////////

		extentLogger = report.createTest("LogOut test");
		LogoutPage logout = new LogoutPage();
		logout.hamburgerMenu.click();
		BrowserUtils.waitFor(2);
		logout.logoutLink.click();
		BrowserUtils.waitFor(2);
		String actual1 = logout.homePage.getText();
		String expected1 = "We Care About Your Health";
		Assert.assertEquals(actual1, expected1);

		BrowserUtils.getScreenshot("MakeAppointment");
	}
}
