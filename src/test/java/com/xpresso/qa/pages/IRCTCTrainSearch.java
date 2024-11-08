package com.xpresso.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.xpresso.qa.base.TestBase;

public class IRCTCTrainSearch extends TestBase {

	@FindBy(xpath="//button[text()='Book Ticket']")
	WebElement BookTicket;
	
	@FindBy(xpath="//button[text()='PNR Status']")
	WebElement PNRStatus;
	
	@FindBy(xpath="//button[text()='Boarding Point Change']")
	WebElement BoardingPointChnage;
	
	@FindBy(xpath="//button[text()='Booking Details']")
	WebElement BookingDetails;
	
	@FindBy(xpath="//button[text()='Cancellation Details']")
	WebElement CancellationDetails;
	
	//Xpath of field on Book Ticket page
	
	
}
