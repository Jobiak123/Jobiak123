package com.jbk.mh.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

//import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.Page;

public class CCJobsPage extends Page {
	
	@FindBy(xpath = "//*[@class='logo-main']")
	private WebElement JobsPageLogo;
	
	@FindBy(xpath = "//*[@id='titlefilter']")
	private WebElement JobsTitleField;

	@FindBy(xpath = ".//*[@id='city']")
	private WebElement CityField;

	@FindBy(xpath = "//*[@id='miles']")
	private WebElement MilesField;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement SearchIcon;

	@FindBy(xpath = "(//*[@class='job_title'])[1]")
	private WebElement JobTitle;

	@FindBy(xpath = "(//*[@class='address_title'])[1]")
	private WebElement JobEmployer;

	@FindBy(xpath = "(//*[@class='address_title'])[2]")
	private WebElement JobLocation;

	@FindBy(xpath = "(//*[@class='address_title'])[4]")
	private WebElement JobPostedDate;
	
	@FindBy(xpath = "(//*[@class='pr-btn'])[1]")
	private WebElement ApplyNowButton;
		
	
	public WebElement getJobsPageLogo() {
		return JobsPageLogo;
	}
	public WebElement getJobsTitleField() {
		return JobsTitleField;
	}
	public WebElement getCityField() {
		return CityField;
	}
	public WebElement getMilesField() {
		return MilesField;
	}
	public WebElement getJobTitle () {
		return JobTitle;
	}
	public WebElement getJobEmployer() {
		return JobEmployer;
	}
	public WebElement getJobLocation() {
		return JobLocation;
	}
	public WebElement getJobPostedDate() {
		return JobPostedDate;
	}
	public WebElement getSearchIcon() {
		return SearchIcon;
	}
	public WebElement getApplyNowButton() {
		return ApplyNowButton;
	}
	
	
	
	public void waitForCCJobsPageToLoad() {
		waitForPageLoad();
		int count=0;
		while(!driver.getCurrentUrl().contains("carecrew.ai/")){
			explicitWait(1);
			count++;
			if(count==50){
				driver.navigate().refresh();
				//waitForPageLoad();
				explicitWait(10);
			}
			if(count==100){
				System.out.println("break");
				break;
			}
		}
		waitForPageElement(getJobsPageLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Jobs Page Logo");
	}

	
	public void searchByJobsTitleField(String FieldValue) {
		sendKeys(getJobsTitleField(), FieldValue, "JobsTitleField");
		explicitWait(1);
		click(SearchIcon, "SearchIcon");
		explicitWait(3);
	}

	public void searchByCityField(String FieldValue) { 
 	sendKeys(getCityField(), FieldValue, "CityField");
	explicitWait(1);
	click(SearchIcon, "SearchIcon");
	explicitWait(3);
	}

	public void searchByMilesTitleField(String FieldValue,String value) {
	selectListBox(getMilesField(), FieldValue,"value" , "MilesField");
	explicitWait(1);
	click(SearchIcon, "SearchIcon");
	explicitWait(3);
		
	}
	
	
	public void getJobDetails() {
		waitForTextToLoad(getJobTitle(),2);
		getText(getJobTitle());
		waitForTextToLoad(getJobEmployer(), 2);
		getText(getJobEmployer());
		waitForTextToLoad(getJobLocation(), 2);
		getText(getJobLocation());
		waitForTextToLoad(getJobPostedDate(),2);
		getText(getJobPostedDate());
		click(getJobTitle(), "Job Title");
	}
	
	
	
	
}
