package com.jbk.mh.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.Page;



public class CCHomePage extends Page {
	
	public enum LinkName {
		HomeLink, JobsLink, AboutLink, BlogLink, ContactLink
	}
	
		
	@FindBy(xpath = "//*[@class='logo-main']")
	private WebElement HomePageLogo;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Home')]")
	private WebElement HomeLink;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Jobs')]")
	private WebElement JobsLink;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'About')]")
	private WebElement AboutLink;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Blog')]")
	private WebElement BlogLink;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Contact')]")
	private WebElement ContactLink;
	
	@FindBy(xpath = "//*[@class='hr-heading']/h1")
	private WebElement JobsAvailableHeader;
	
	@FindBy(xpath = "//*[@id='titlefilter']")
	private WebElement JobsTitleField;

	@FindBy(xpath = ".//*[@id='city']")
	private WebElement CityField;

	@FindBy(xpath = "//*[@id='miles']")
	private WebElement MilesField;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement SearchIcon;

	
	
	
	public WebElement getHomePageLogo() {
		return HomePageLogo;
	}
	
	public WebElement getHomeLink() {
		return HomeLink;
	}
	public WebElement getJobsLink() {
		return JobsLink;
	}
	public WebElement getAboutLink() {
		return AboutLink;
	}
	public WebElement getBlogLink() {
		return BlogLink;
	}
	public WebElement getContactLink() {
		return ContactLink;
	}
	public WebElement getJobsAvailableHeader() {
		return JobsAvailableHeader;
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
	public WebElement getSearchIcon() {
		return SearchIcon;
	}
	
	
	
	
	
	public void openCCUrl() {
		try {
			driver.navigate().to(Page.baseURL);
			waitForPageLoad();
			//driver.navigate().to(WebDriverBase._prop.getString("ccurl"));
			AtuReports.passResults1("Navigate to "+Page.baseURL+" Application", "--",
					"Home Page should display", "Home Page is displayed");

		} catch (Exception exception) {
			AtuReports.failResults("Navigate to "+Page.baseURL+" Application", "--",
					"Home Page should display", catchException(exception));
		}
	}

	public void openCCUrl(Map<String, String> data) {
		String url = data.get("Url");
		try {
			driver.navigate().to(url);
			AtuReports.passResults1("Navigate to "+url+" Application", "--",
					"Home Page should display", "Home Page is displayed");

		} catch (Exception exception) {
			AtuReports.failResults("Navigate to "+url+" Application", "--",
					"Home Page should display", catchException(exception));
		}
	}

	
	public void waitForCCHomePageToLoad() {
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
		waitForPageElement(getHomePageLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Home Page Logo");
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
	
	
	
	
	public void clickOnLink(String link) {

		LinkName linkName = LinkName.valueOf(link);

		switch (linkName) {
		case HomeLink:
			waitForPageElement(getHomeLink(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"HomeLink");
			click(getHomeLink(), "getHomeLink");
			explicitWait(2);
			break;
        case JobsLink:
			waitForPageElement(getJobsLink(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"JobsLink");
			click(getJobsLink(), "getJobsLink");
			explicitWait(2);
			break;
		case AboutLink:
			waitForPageElement(getAboutLink(), "WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"AboutLink");
			click(getAboutLink(), "getAboutLink");
			explicitWait(2);
			break;
		case BlogLink:
			waitForPageElement(getBlogLink(), "WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"BlogLink");
			click(getBlogLink(), "getBlogLink");
			explicitWait(2);
			break;
		case ContactLink:
			waitForPageElement(getContactLink(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"ContactLink");
			click(getContactLink(), "getContactLink");
			explicitWait(2);
			break;
			
		}
	}	
	
	
	
	
	
	
	
	
	
	
	
}
