package com.xpresso.qa.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xpresso.qa.base.TestBase;
public class AddComplaintPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Add Complaint')]")
	WebElement AddComplaintTab;

	@FindBy(xpath = "//div[@class='borderbox']/app-dynamic-form/div/form/div[1]/div[1]/div/ng-select")
	WebElement Complaint_Mode;

	@FindBy(xpath = "//div[@class='borderbox']/app-dynamic-form/div/form/div[1]/div[2]/div/ng-select")
	WebElement LogFor;

	@FindBy(xpath = "//input[@id='selectValue']")
	WebElement Usercode;

	@FindBy(xpath = "//input[@id='userName']")
	WebElement Name;

	@FindBy(xpath = "//input[@id='userMobileNo']")
	WebElement MobileNo;

	@FindBy(xpath = "//input[@id='userEmailId']")
	WebElement Email;

	@FindBy(xpath = "//*[text()='Application Type']/following-sibling::ng-select/div")
	WebElement ApplicationType;

	@FindBy(xpath = "//*[text()='Application Type']/following-sibling::ng-select/ng-dropdown-panel/div/div/div/span")
	List<WebElement> ApplicationTypeAllValues;

	@FindBy(xpath = "//*[text()='Category Type']/following-sibling::ng-select/div")
	WebElement CategoryType;

	@FindBy(xpath = "//*[text()='Category Type']/following-sibling::ng-select/ng-dropdown-panel/div/div/div")
	List<WebElement> CategoryTypeAllvalues;

	@FindBy(xpath = "//*[text()='Sub Category']/following-sibling::ng-select/div")
	WebElement Sub_CategoryType;

	@FindBy(xpath = "//*[text()='Sub Category']/following-sibling::ng-select/ng-dropdown-panel/div/div/div/span")
	List<WebElement> SubCategorytypeAllValues;

	@FindBy(xpath = "//*[text()='Transaction Id']/following-sibling::input")
	WebElement TransactionID;

	@FindBy(xpath = "//textarea[@id='complaintDescription']")
	WebElement Description;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlAssignUserType']")
	WebElement Assign_User_Type;

	@FindBy(xpath = "//select[@id='ContentPlaceHolder1_ddlAssignUserId']")
	WebElement Assign_User;

	@FindBy(xpath = "//input[@id='ContentPlaceHolder1_txtEstimatedTAT']")
	WebElement EstimatedDate;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-chevron-left']")
	WebElement LeftArrwoInCalendr;

	@FindBy(xpath = "//div[@class='borderbox']/app-dynamic-form/div/form/div/div[10]/div")
	WebElement UploadDocument;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement Savebttn;

	@FindBy(xpath = "//*[contains(text(),'Application Type is required')]")
	WebElement ErrorMessageBalnkAppType;

	@FindBy(xpath = "//*[contains(text(),'Category Type is required')]")
	WebElement ErrorMessageCategryType;

	@FindBy(xpath = "//*[contains(text(),'Sub Category is required')]")
	WebElement ErrorMessageSUBCategryType;

	@FindBy(xpath = "//*[contains(text(),'Please Enter Valid Transaction Id ')]")
	WebElement ErrorMessageforTXID;

	@FindBy(xpath = "//*[contains(text(),'Description is required')]")
	WebElement ErrorMessageComplaintDesc;
	
	@FindBy(xpath="//*[text()='{*} Invalid Transaction Id']")
	WebElement InvalidTxMessageWinodw;
	
	@FindBy(xpath="//*[contains(text(),'Our customer care will revert on your complaint soon.')]")
	WebElement SucessMssge;

	public AddComplaintPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickOnAddCmplaintTab() {

		AddComplaintTab.click();

	}

	public void SelectComplaintMode() {

		Complaint_Mode.click();
	}

	public void SelectLogFor() {

		LogFor.click();
	}

	public boolean SelectUsercode() {

		Usercode.isEnabled();

		return false;
	}

	public boolean SelectUserName() {

		Name.isEnabled();
		return false;
	}

	public boolean SelectMobileNo() {

		MobileNo.isEnabled();
		return false;
	}

	public boolean SelectEmail() {

		Email.isEnabled();
		return false;
	}

	

	public void SelectAppType(String apptype) {
		ApplicationType.click();
		try {
			int appsize = ApplicationTypeAllValues.size();
			System.out.println("Size of the Appliaction type"+appsize);
			for (int i = 0; i < appsize; i++) {
				String apptext = ApplicationTypeAllValues.get(i).getText();
				System.out.println("Value from the drop down is "+apptext);
				if (apptext.equalsIgnoreCase(apptype))
				{
					ApplicationTypeAllValues.get(i).click();
				    break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index of bound of exception");
		}
	}

	

	public void SelectCtgryType(String ctgrytype) {
		CategoryType.click();
		
		try {
			int ctgryize = CategoryTypeAllvalues.size();
			System.out.println("Size of the drop down list is "+ctgryize);
			for (int i = 0; i<ctgryize; i++) {
				String ctgrytext = CategoryTypeAllvalues.get(i).getText();
				System.out.println("Value from that index is "+ctgrytext);

				if (ctgrytext.equalsIgnoreCase(ctgrytype)) {

					CategoryTypeAllvalues.get(i).click();
				    break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index of bound of exception");
		}
	}

	

	public void SelectSubCtgryType(String subctgrytype) {
		Sub_CategoryType.click();
		try {
			int subctgryize = SubCategorytypeAllValues.size();
			for (int i = 0; i < subctgryize; i++) {
				String subCtg = SubCategorytypeAllValues.get(i).getText();
				if (subCtg.equalsIgnoreCase(subctgrytype))
				{
					SubCategorytypeAllValues.get(i).click();
				    break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index of bound of exception");
		}
	}

	public void Enter_TransactionID(String transction) {
		TransactionID.sendKeys(transction);
	}

	public void EnterDescription(String Desc) {
		Description.sendKeys(Desc);
	}

	public void ClickonSaveBttn() {
		Savebttn.click();
	}

	public String GetErrorMssge_BlankApplType() {
		String text = ErrorMessageBalnkAppType.getText();
		return text;

	}

	public String GetErrorMssge_BlankCatgryType() {
		String text = ErrorMessageCategryType.getText();
		return text;

	}

	public String GetErrorMssge_BlankSubCatgryType() {
		String text = ErrorMessageSUBCategryType.getText();
		return text;

	}

	public String GetErrorMssge_BlankTxId() {
		String text = ErrorMessageforTXID.getText();
		return text;

	}

	public String GetErrorMssge_BlankComplaintDesc() {
		String text = ErrorMessageComplaintDesc.getText();
		return text;

	}
	
	public String GetErrorMssge_InvalidTxID() {
		String text = InvalidTxMessageWinodw.getText();
		return text;

	}
	
	public String GetSucessMssge_AddComplaint() {
		String text = SucessMssge.getText();
		return text;

	}
	
	
	
	
	
	
	
	

	

}
