package com.curahealthecareTestNG.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.curahealthecareTestNG.Utilities.Driver;

public class MakeAppointment {
	
	
	public  MakeAppointment() {
		
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath="//div/h2")
	public WebElement makeAppoitmentPage;
	
	@FindBy(id="combo_facility")
	public WebElement selectFacility;
	
	@FindBy(xpath="//select/option[2]")
	public WebElement optionHongKong;
	
	@FindBy(id="radio_program_medicaid")
	public WebElement selectMedicaid;
	
	@FindBy(css="#txt_visit_date")
	public WebElement visitDate;
	
	@FindBy(xpath="//tbody/tr[2]")
	public WebElement calender;
	
	@FindBy(xpath="//div[@class='datepicker-days']//table[@class='table-condensed']//th[contains(@class,'next')]")
	public WebElement nextLink;
	
	@FindBy(xpath="//div[@class='datepicker-days']//table[@class='table-condensed']//th[contains(@class,'prev')]")
	public WebElement prevLink;
	
	@FindBy(xpath="//div[@class='datepicker-days']//table[@class='table-condensed']//th[contains(@class,'datepicker-switch')]")
	public WebElement currentDate;
	
	@FindBy(xpath="//div[@class='datepicker-days']//td[@class='day']")
	public WebElement dayLink;
	
	@FindBy(id="txt_comment")
	public WebElement writeComment;
	
	@FindBy(id="btn-book-appointment")
	public WebElement bookAppointment;
	
	@FindBy(xpath="//section[@id=\"summary\"]/div/div/div[1]/p")
	public WebElement appointmentCofirm;
	
	

}
