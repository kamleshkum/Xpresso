package com.xpresso.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xpresso.qa.base.TestBase;

public class CovidWidowPage extends TestBase {

	@FindBy(xpath = "//div[@id='wrapper']/div[2]/div[1]")
	WebElement Heading;

	@FindBy(xpath = "//input[@value='CSP000002']")
	WebElement CSPCodeField;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSeatchMobile']")
	WebElement ApplicantMobile;

	@FindBy(xpath = "//input[@class='form-control']")
	WebElement Status;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFromdate']")
	WebElement FromDate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtTodate']")
	WebElement ToDate;

	@FindBy(xpath = "//input[@value='View']")
	WebElement View;

	@FindBy(xpath = "//input[@value='Add']")
	WebElement Add;

	// Add/Edit Covid Widow Customer Information page.

	@FindBy(xpath = "//div[contains(text(),'Add/Edit Covid Widow Customer Information')]")
	WebElement AddEditPageHeading;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtFirstName']")
	WebElement FirstName;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvFname']")
	WebElement FirstNameMandtryStr;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMiddleName']")
	WebElement MiddleName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtLastName']")
	WebElement LastName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtDOB']")
	WebElement DOB;

	@FindBy(xpath = "//div[@role='navigator']/div[3]")
	WebElement DOBNextbuttn;

	@FindBy(xpath = "//div[@role='navigator']/div[1]")
	WebElement DOBPrevsbuttn;

	@FindBy(xpath = "//div[@role='navigator']/div[2]")
	WebElement DOBYear;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvDOB']")
	WebElement DOBstarkMrk;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtMobileNo']")
	WebElement MobileNo;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvMobileNo']")
	WebElement MobileStartMrk;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtAltMobileNo']")
	WebElement AlternateMobileNo;

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtPermanentAddress']")
	WebElement PermanentAddress;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvPermanentAddress']")
	WebElement PermanentAddressStartMrk;

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtCurrentAddress']")
	WebElement CurrentAddress;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvCurrentAddress']")
	WebElement CurrentAddressStarMrk;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblHusbandDeathDueCovid_0']")
	WebElement DuetoCovidRadio;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblHusbandDeathDueCovid_1']")
	WebElement DuetoSomeotherIllness;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_0']")
	WebElement ZeroChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_1']")
	WebElement oneChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_2']")
	WebElement TwoChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_3']")
	WebElement ThreeChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_4']")
	WebElement FourChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildren_5']")
	WebElement FiveChild;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnChildredDtl']")
	WebElement ChildreButton;

	@FindBy(xpath = "//input [@name='ctl00$ContentPlaceHolder1$fuAadhaar']")
	WebElement UploadAadhar;

	@FindBy(xpath = "//span[@id='ContentPlaceHolder1_rfvAadhaar']")
	WebElement UploadAadharStarmrk;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuPancard']")
	WebElement UploadPancard;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuHusbandAadhaar']")
	WebElement UploadHushBandAadhar;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuHusbandDeathCertificate']")
	WebElement UpldDeathCertficate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuOtherGovernmentDocument']")
	WebElement OtherGovtDoc;

	// Radio button for the this question 'Was the Applicant's husband the primary
	// breadwinner, i.e. main earning member in the family? *'.
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblHusbandMainEarning_0']")
	WebElement YesRadio;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblHusbandMainEarning_1']")
	WebElement NoRadio;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlHusbandService']")
	WebElement HushbndService;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtHusbandDeathDate']")
	WebElement HusbandDeathDate;

	// Check box under this question 'Does the Applicant have any other sources of
	// income? *'.
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkDeceasedPension']")
	WebElement DeceasedPension;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkAssistanceMonetary']")
	WebElement chkAssistanceMonetary;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkPersonalIncome']")
	WebElement PersonalIncome;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_chkNoIncome']")
	WebElement NoIncome;

	@FindBy(xpath = "//div[@class='radioBtn']/span/input")
	WebElement Other;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOtherSourceOfIncome']")
	WebElement OtherSourceIncme;

	// Is the Applicant receiving any kind of grant or assistance/ sustenance fund
	// from any of the mentioned below? *

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_0']")
	WebElement Goverment;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_1']")
	WebElement Corporate;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_2']")
	WebElement NGO;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_3']")
	WebElement PSU;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_4']")
	WebElement ExEmployeroftheApplicantHusband;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_5']")
	WebElement NoIamnotavailinganysortofgrants;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblOtherSourceOfFund_6']")
	WebElement OtherassistanceSustenace;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtOtherSourceOfFund']")
	WebElement OtherSrceIncmoeassistanceSustenace;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_fuApplicantPhoto']")
	WebElement ApplicantPhoto;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlStatus']")
	WebElement StatusatAddPage;

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtRemakrs']")
	WebElement Remarks;

	@FindBy(xpath = "//textarea[@id='ContentPlaceHolder1_txtOpsRemarks']")
	WebElement OpsRemarks;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSubmit']")
	WebElement Save;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCancel']")
	WebElement Cancel;

	// Add Children Information Pagee
	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtChildName']")
	WebElement ChildName;

	@FindBy(xpath = "//input[@id='txtChildAge']")
	WebElement ChildAge;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildGender_0']")
	WebElement ChildMale;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_rblChildGender_1']")
	WebElement ChildFemale;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSchoolName']")
	WebElement ChildSchoolName;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtSchoolFee']")
	WebElement ChildSchoolfee;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnSave']")
	WebElement ChildSave;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_btnCloseChildDtl']")
	WebElement ChildClose;

	public CovidWidowPage() {
		PageFactory.initElements(driver, this);
	}

	// Click on Add button to Apply
	public void ClickAdd() {
		Add.click();
	}

	public void EnterFstName(String FrstName) {
		FirstName.sendKeys(FrstName);
	}

	public void EnterMiddleName(String MidleName) {
		MiddleName.sendKeys(MidleName);
	}

	public void EnterLastName(String MidleName) {
		LastName.sendKeys(MidleName);
	}

	public void ClickOnDOB() {
		DOB.click();
	}

	public void ClickNext_DobCalendar() {

		DOBNextbuttn.click();
	}

	public void ClickPrevs_DobCalendar() {

		DOBPrevsbuttn.click();
	}

	public void SelectDOBYear() {
		DOBYear.click();

	}

	public void EnterMobileNum(String Mobile) {
		MobileNo.sendKeys(Mobile);
	}

	public void EnterAlternateMobileNum(String Mobile) {
		AlternateMobileNo.sendKeys(Mobile);
	}

	public void EnterPermanentAddress(String address) {
		PermanentAddress.sendKeys(address);
	}

	public void EnterCurrentAddress(String address) {
		CurrentAddress.sendKeys(address);
	}

	public void SelectDueToCovid() {
		DuetoCovidRadio.click();
	}

	public void SelectDuetoSomeotherIllness() {
		DuetoSomeotherIllness.click();
	}

	public void SelectZeroChild() {
		ZeroChild.click();
	}

	public void SelectOneChild() {
		oneChild.click();
	}

	public void SelectTwoChild() {
		TwoChild.click();
	}

	public void SelectThreeChild() {
		ThreeChild.click();
	}

	public void SelectFourChild() {
		FourChild.click();
	}

	public void SelectFiveChild() {
		FiveChild.click();
	}

	public void ClickonChildDetails() {
		ChildreButton.click();
	}

	public void ClickonUploadAadhar() {
		UploadAadhar.click();
	}

	public void ClickonUploadPanCard() {
		UploadPancard.click();
	}

	public void ClickonUploadAadharforHushBand() {
		UploadHushBandAadhar.click();
	}

	public void ClickonUploadUpldDeathCertficate() {
		UpldDeathCertficate.click();
	}

	public void ClickonUploadOtherGoctDoc() {
		OtherGovtDoc.click();
	}

	public void ClickOnYes_HusbndPrimaryBreadwinner() {
		YesRadio.click();
	}

	public void ClickOnNo_HusbndPrimaryBreadwinner() {
		NoRadio.click();
	}

	public void ClickOnNo_HusbndServices() {
		HushbndService.click();
	}

	public void ClickOnNo_HusbndDeathDate() {
		HusbandDeathDate.click();
	}

	public void ClickOnDeceasedPension() {
		DeceasedPension.click();
	}

	public void ClickOnDchkAssistanceMonetary() {
		chkAssistanceMonetary.click();
	}

	public void ClickOnPersonalIncome() {
		PersonalIncome.click();
	}

	public void ClickOnNoIncome() {
		NoIncome.click();
	}

	public void ClickOnOther() {
		Other.click();
	}

	public void EnterOtherSourceIncome(String Income) {
		OtherSourceIncme.sendKeys(Income);
	}

	public void SelectGovt() {
		Goverment.click();
	}

	public void SelectCorporate() {
		Corporate.click();
	}

	public void SelectNGO() {
		NGO.click();
	}

	public void SelectPSU() {
		PSU.click();
	}

	public void SelectExEmployeroftheApplicantHusband() {
		ExEmployeroftheApplicantHusband.click();
	}

	public void SelectNoIamnotavailinganysortofgrants() {
		NoIamnotavailinganysortofgrants.click();
	}

	public void SelectOtherGrantassistance() {
		OtherassistanceSustenace.click();
	}

	public void SelectOtherGrantassistanceSourceIncome(String Income) {
		OtherSrceIncmoeassistanceSustenace.sendKeys(Income);
		;
	}

	public void ClickOnApplicantPhoto() {
		ApplicantPhoto.click();
	}

	public void clickonStatus() {
		StatusatAddPage.click();
	}

	public void EnterRemarks(String remarks) {
		Remarks.sendKeys(remarks);

	}

	public void EnterOpsRemarks(String remarks) {
		OpsRemarks.sendKeys(remarks);

	}

	public void ClickonSave() {
		Save.click();
	}

	public void ClickonCancel() {
		Cancel.click();
	}

	public void SelectfromHusbndService(String value) {
		Select sel = new Select(HushbndService);
		sel.selectByVisibleText(value);
	}

	public void SelectYear() {
		SelectDOBYear();
		SelectDOBYear();
		for (int i = 0; i < 6; i++) {
			ClickPrevs_DobCalendar();
		}

		List<WebElement> year = driver.findElements(By.xpath("//div[@role='calendar']/div/table/tbody/tr/td"));
		System.out.println(year.size());
		for (int i = 0; i < year.size(); i++) {
			String echyr = year.get(i).getText();
			if (echyr.equals("1967")) {
				System.out.println(echyr);
				year.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//div[@year='1967']/div/table/tbody/tr[2]/td[3]/div")).click();
		driver.findElement(By.xpath("//div[@year='1967']/div/table/tbody/tr[2]/td[3]")).click();
	}

	public void UploadAadhar() throws AWTException {
		// Click on Upload Aadhar
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//input [@name='ctl00$ContentPlaceHolder1$fuAadhaar']")))
				.click().build().perform();
		// Upload Aadhar
		Robot rb = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadPANcard() throws AWTException, InterruptedException {

		// Cick on Upload Pan
		Actions builderPan = new Actions(driver);
		builderPan.moveToElement(driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuPancard']"))).click()
				.build().perform();
        Thread.sleep(3000);
		// Upload Pan
		Robot rbPan = new Robot();
		StringSelection strPan = new StringSelection("C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strPan, null);

		rbPan.keyPress(KeyEvent.VK_CONTROL);
		rbPan.keyPress(KeyEvent.VK_V);

		rbPan.keyRelease(KeyEvent.VK_CONTROL);
		rbPan.keyRelease(KeyEvent.VK_V);

		rbPan.keyPress(KeyEvent.VK_ENTER);
		rbPan.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadHushBandAadhar() throws AWTException, InterruptedException {

		// Cick on Upload HushBandAadhar
		Actions builderHushAadhr = new Actions(driver);
		builderHushAadhr
				.moveToElement(driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuHusbandAadhaar']")))
				.click().build().perform();
		Thread.sleep(3000);
		// Upload HushBand Aadhar
		Robot rbHushAadhr = new Robot();
		StringSelection strHushAadhr = new StringSelection(
				"C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strHushAadhr, null);

		rbHushAadhr.keyPress(KeyEvent.VK_CONTROL);
		rbHushAadhr.keyPress(KeyEvent.VK_V);

		rbHushAadhr.keyRelease(KeyEvent.VK_CONTROL);
		rbHushAadhr.keyRelease(KeyEvent.VK_V);

		rbHushAadhr.keyPress(KeyEvent.VK_ENTER);
		rbHushAadhr.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadHushBandDeathCertifiacte() throws AWTException, InterruptedException {

		// Click on Upload HushBandDeathCertifiacte
		Actions builderHushdeath = new Actions(driver);
		builderHushdeath
				.moveToElement(
						driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuHusbandDeathCertificate']")))
				.click().build().perform();
		Thread.sleep(3000);
		// Upload HushBand Aadhar
		Robot rbHushDeath = new Robot();
		
		StringSelection strHushDeath = new StringSelection(
				"C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strHushDeath, null);

		rbHushDeath.keyPress(KeyEvent.VK_CONTROL);
		rbHushDeath.keyPress(KeyEvent.VK_V);

		rbHushDeath.keyRelease(KeyEvent.VK_CONTROL);
		rbHushDeath.keyRelease(KeyEvent.VK_V);

		rbHushDeath.keyPress(KeyEvent.VK_ENTER);
		rbHushDeath.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadGovtDoc() throws AWTException, InterruptedException {

		// Click on Upload GovtDoc
		Actions builderGovtDoc = new Actions(driver);
		builderGovtDoc
				.moveToElement(
						driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuOtherGovernmentDocument']")))
				.click().build().perform();
		Thread.sleep(3000);
		// Upload Govt Doc
		Robot rbHushgvtDoc = new Robot();
		
		StringSelection strGvtdoc = new StringSelection("C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strGvtdoc, null);

		rbHushgvtDoc.keyPress(KeyEvent.VK_CONTROL);
		rbHushgvtDoc.keyPress(KeyEvent.VK_V);

		rbHushgvtDoc.keyRelease(KeyEvent.VK_CONTROL);
		rbHushgvtDoc.keyRelease(KeyEvent.VK_V);

		rbHushgvtDoc.keyPress(KeyEvent.VK_ENTER);
		rbHushgvtDoc.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadPhoto() throws AWTException, InterruptedException {
		// Upload Photo of the applicant

		Actions builderApplicntphoto = new Actions(driver);
		builderApplicntphoto
				.moveToElement(driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuApplicantPhoto']")))
				.click().build().perform();
		
		
		Thread.sleep(4000);
		Robot rbApplcntPhoto = new Robot();
		
		StringSelection strAlicntphoto = new StringSelection("C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strAlicntphoto, null);
		
		rbApplcntPhoto.keyPress(KeyEvent.VK_CONTROL);
		rbApplcntPhoto.keyPress(KeyEvent.VK_V);

		rbApplcntPhoto.keyRelease(KeyEvent.VK_CONTROL);
		rbApplcntPhoto.keyRelease(KeyEvent.VK_V);

		rbApplcntPhoto.keyPress(KeyEvent.VK_ENTER);
		rbApplcntPhoto.keyRelease(KeyEvent.VK_ENTER);
	}

	public void UploadSchoolcertificate() throws AWTException, InterruptedException {
		// Upload Photo of the applicant

		Actions builderSchoolcertificate = new Actions(driver);
		builderSchoolcertificate
				.moveToElement(driver.findElement(By.xpath("//input[@id='ContentPlaceHolder1_fuChildrenSchoolDoc']")))
				.click().build().perform();
		Thread.sleep(4000);
		Robot rbSchoolcertificate = new Robot();
		
		StringSelection strSchoolcertificate = new StringSelection(
				"C:\\Users\\kamlesh.kumar\\Downloads\\7090913878AADHAAR.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSchoolcertificate, null);

		rbSchoolcertificate.keyPress(KeyEvent.VK_CONTROL);
		rbSchoolcertificate.keyPress(KeyEvent.VK_V);

		rbSchoolcertificate.keyRelease(KeyEvent.VK_CONTROL);
		rbSchoolcertificate.keyRelease(KeyEvent.VK_V);

		rbSchoolcertificate.keyPress(KeyEvent.VK_ENTER);
		rbSchoolcertificate.keyRelease(KeyEvent.VK_ENTER);
	}

	public void AddoneChild(String name, String age, String Scholame, String scholFee) {
		ChildName.sendKeys(name);
		ChildAge.sendKeys(age);
		ChildSchoolName.sendKeys(Scholame);
		ChildSchoolfee.sendKeys(scholFee);
		ChildSave.click();
		
	}
	
	public void CloseChildPage() {
		ChildClose.click();
		
	}
}
