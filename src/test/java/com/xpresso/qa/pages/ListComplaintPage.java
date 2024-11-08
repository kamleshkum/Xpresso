package com.xpresso.qa.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xpresso.qa.base.TestBase;
import com.xpresso.qa.utilites.Testutil;

public class ListComplaintPage extends TestBase {

	Testutil util = new Testutil();

	@FindBy(xpath = ("//a[text()='List Complaint']"))
	WebElement ListComplaint;

	@FindBy(xpath = ("//select[@id='ContentPlaceHolder1_ddlMerchant']"))
	WebElement MerchantDropdown;

	@FindBy(id = "userCode")
	WebElement UserCode;

	@FindBy(xpath = "//*[text()='Region']/following-sibling::ng-select/div")
	WebElement Region;

	@FindBy(xpath = "//*[text()='Region']/following-sibling::ng-select/div/following-sibling::ng-dropdown-panel/div/div/div/span")
	List<WebElement> RegionValues;

	@FindBy(xpath = "//*[text()='State']/following-sibling::ng-select/div")
	WebElement State;

	@FindBy(xpath = "//*[text()='State']/following-sibling::ng-select/ng-dropdown-panel/div/div/div/span")
	List<WebElement> AllStateName;

	@FindBy(id = "complaintId")
	WebElement CmplaintID;

	@FindBy(id = "transactionId")
	WebElement TransactionID;

	@FindBy(xpath = "//*[text()='Complaint Type']//following-sibling::ng-select/div")
	WebElement CompalintType;

	@FindBy(xpath = "//*[text()='Complaint Type']//following-sibling::ng-select/div/following-sibling::ng-dropdown-panel/div/div/div/span")
	List<WebElement> ValuesOfComplaintType;

	@FindBy(xpath = "//*[text()='Complaint Mode']/following-sibling::ng-select/div")
	WebElement ComplaintMode;

	@FindBy(xpath = "//*[text()='Complaint Mode']/following-sibling::ng-select/ng-dropdown-panel/div/div/div")
	List<WebElement> ValuesOfComplaintMode;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/input")
	WebElement Lodge_From_Date;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/div[1]")
	WebElement PrvsArrwFrmDte;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/div[2]")
	WebElement NxtsArrwFrmDte;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]")
	WebElement MonthinFromDate;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]")
	WebElement YearinFromDate;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div")
	List<WebElement> CalendarRow;

	@FindBy(xpath = "//*[text()='Lodge From Date']/following-sibling::div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div")
	List<WebElement> CalendarCol;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/input")
	WebElement Lodge_TO_Date;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/div[1]")
	WebElement PreviousArrwInToDate;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/div[2]")
	WebElement NextArrwInToDate;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[1]")
	WebElement MonthinToDate;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/ngb-datepicker/div/ngb-datepicker-navigation/ngb-datepicker-navigation-select/select[2]")
	WebElement YearinToDate;

	@FindBy(xpath = "//*[text()='Lodge To Date']/following-sibling::div/ngb-datepicker/div[2]/div/ngb-datepicker-month/div/div")
	List<WebElement> Lodge_TO_DateColumns;

	@FindBy(xpath = "//*[text()='Category Type']/following-sibling::ng-select/div")
	WebElement CategoryType;

	@FindBy(xpath = "//*[text()='Category Type']/following-sibling::ng-select/ng-dropdown-panel/div/div/div/span")
	List<WebElement> ValueOfCategrytype;

	@FindBy(xpath = "//*[text()='Status']/following-sibling::ng-multiselect-dropdown/div")
	WebElement Status;

	@FindBy(xpath = "//*[text()='Status']/following-sibling::ng-multiselect-dropdown/div/div[2]/ul[1]/li")
	WebElement StatusAsALL;

	@FindBy(xpath = "//*[text()='Status']/following-sibling::ng-multiselect-dropdown/div/div[2]/ul[2]/li")
	List<WebElement> ValuesOfStatus;

	@FindBy(xpath = "//button[contains(text(),'View')]")
	WebElement ViewButn;

	@FindBy(xpath = "//table[@class='table table-striped table-bordered table-resizable']/tbody/tr/td[16]/span")
	List<WebElement> StatusColumnOfGRID;
	
	@FindBy(xpath="//*[text()='Show ']/parent::div/parent::div/following-sibling::div[1]/div/table/tbody/tr/td")
	List<WebElement> GridData;

	public ListComplaintPage() {
		PageFactory.initElements(driver, this);
	}

	public void ClickonListComplaint() {

		ListComplaint.click();

	}

	public WebElement Merchant() {

		return MerchantDropdown;
	}

	public boolean CheckUsercodeDisabled() {
		return UserCode.isEnabled();
	}

	public String CheckIDinUSercode() {
		return UserCode.getAttribute("value");
	}

	public void ClickonRegion() {
		Region.click();
	}

	public void SelectRegion(String region) {

		int lenth = RegionValues.size();
		for (int i = 0; i < lenth - 1; i++) {
			String gdg = RegionValues.get(i).getText();
			if (gdg.contains(region)) {
				RegionValues.get(i).click();
				break;
			}
		}
	}

	public void ClickonState() {
		State.click();
	}

	public void SelectState(String state) {
		int lenth = AllStateName.size();
		for (int i = 0; i < lenth; i++) {
			String gdg = AllStateName.get(i).getText();
			System.out.println(gdg);
			if (gdg.contains(state)) {
				AllStateName.get(i).click();
				break;
			}
		}
	}

	public void EnterCmplaintID(String cmplaintID) {
		CmplaintID.sendKeys(cmplaintID);
	}

	public void EnterTransactionID(String Txid) {
		TransactionID.sendKeys(Txid);
	}

	public void ClickonComplaintType() {
		CompalintType.click();
	}

	public void SelectComplaintType(String value) {
		int lenth = ValuesOfComplaintType.size();
		System.out.println(lenth);
		for (int i = 0; i < lenth - 1; i++) {
			String gdg = ValuesOfComplaintType.get(i).getText();
			System.out.println(gdg);
			if (gdg.contains(value)) {
				ValuesOfComplaintType.get(i).click();
				break;
			}
		}
	}

	public void ClickonComplaintMode() {
		ComplaintMode.click();
	}

	public void SelectComplaintMode(String value) {
		int lenth = ValuesOfComplaintMode.size();
		System.out.println(lenth);
		for (int i = 0; i < lenth - 1; i++) {
			String gdg = ValuesOfComplaintMode.get(i).getText();
			System.out.println(gdg);
			if (gdg.contains(value)) {
				ValuesOfComplaintMode.get(i).click();
				break;
			}
		}
	}

	public void ClickonLodgeFromDate() {
		Lodge_From_Date.click();
	}

	public void ClickonPreviousArrwoOfFromDate() {
		PrvsArrwFrmDte.click();
	}

	public void ClickonNextArrwOfFromDate() {
		NxtsArrwFrmDte.click();
	}

	public void SelectDateInFromCalend(String Year, String month, String Date) {

		Lodge_From_Date.click();

		util.SelectfromDropDownbyVisibleTEXT(YearinFromDate, Year);
		util.SelectfromDropDownbyVisibleTEXT(MonthinFromDate, month);

		try {

			for (int i = 0; i < CalendarCol.size(); i++) {
				String eaccolumData = CalendarCol.get(i).getText();

				if (eaccolumData.equalsIgnoreCase(Date)) {
					CalendarCol.get(i).click();
					break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index of bound exception");
		}

	}

	public void SelectDateInToCalend(String Year, String month, String Date) {
		Lodge_TO_Date.click();
		
		util.SelectfromDropDownbyVisibleTEXT(YearinToDate, Year);
		util.SelectfromDropDownbyVisibleTEXT(MonthinToDate, month);

		try {
			
			for (int i = 0; i < Lodge_TO_DateColumns.size(); i++) {
				String eaccolumData = Lodge_TO_DateColumns.get(i).getText();
				if (eaccolumData.equals(Date)) {
					Lodge_TO_DateColumns.get(i).click();
					break;
				}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Index of bound exception");
		}

	}

	public void ClickonPreviousArrwoOfToDate() {
		PreviousArrwInToDate.click();
	}

	public void ClickonNextArrwOfToDate() {
		NextArrwInToDate.click();
	}

	public void ClickonCategory() {

		CategoryType.click();
	}

	public void SelectCategoryType(String value) {
		int lenth = ValueOfCategrytype.size();
		System.out.println(lenth);
		for (int i = 0; i < lenth - 1; i++) {
			String gdg = ValueOfCategrytype.get(i).getText();
			System.out.println(gdg);
			if (gdg.contains(value)) {
				ValueOfCategrytype.get(i).click();
				break;
			}
		}
	}

	public void ClickonStatus() {

		Status.click();
	}

	public void SelectStatusasALL() {

		StatusAsALL.click();
	}

	public void UNSelectStatusALL() {

		StatusAsALL.click();
	}

	public void SelectStatusAs(String status) {
		int lenth = ValuesOfStatus.size();
		System.out.println(lenth);
		for (int i = 0; i < lenth - 1; i++) {
			String gdg = ValuesOfStatus.get(i).getText();
			System.out.println(gdg);
			if (gdg.contains(status)) {
				ValuesOfStatus.get(i).click();
				break;
			}
		}
	}

	public void ClickonViewButton() {
		ViewButn.click();
	}

	boolean status = false;

	public boolean VerifyStatusFromGrid(String stus) {
		int colcize = StatusColumnOfGRID.size();
		for (int i = 0; i < colcize; i++) {
			String Statustext = StatusColumnOfGRID.get(i).getText();

			System.out.println(Statustext);
			if (Statustext.contains(stus)) {
				status = true;
			}

		}
		return status;
	}

	
	public void GridDataVerify() {
		for(int i=0;i<GridData.size();i++) {
			System.out.println(GridData.get(i).getText());
		}
	}
}
