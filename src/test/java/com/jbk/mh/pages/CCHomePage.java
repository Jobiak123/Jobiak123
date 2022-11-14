package com.jbk.mh.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.Reporter;
import com.jbk.automation.framework.util.Reporter.TestStatus;
import com.jbk.automation.framework.webdriver.Page;
import com.thoughtworks.selenium.webdriven.commands.GetAttribute;



public class CCHomePage extends Page {
	
	public enum LinkName {
		HomeTab, JobsTab, AboutTab, BlogTab, ContactTab
	}
	
		
	@FindBy(xpath = "//*[@class='logo-main']")
	private WebElement HomePageLogo;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Home')]")
	private WebElement HomeTab;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Jobs')]")
	private WebElement JobsTab;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'About')]")
	private WebElement AboutTab;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Blog')]")
	private WebElement BlogTab;
	
	@FindBy(xpath = "//*[@class='main-menu nav']//*[contains(text(),'Contact')]")
	private WebElement ContactTab;
	
	@FindBy(xpath = "//*[@class='hr-heading']/h1")
	private WebElement JobsAvailableHeader;
	
	@FindBy(xpath = "//*[@class='hr-heading']/p")
	private WebElement JobsAvailableTagLine;
	
	
	
	@FindBy(xpath = "//*[@id='titlefilter']")
	private WebElement JobsTitleField;

	@FindBy(xpath = "//*[@id='city']")
	private WebElement CityField;
	
	@FindBy(xpath = "//*[@id='locationliid'][1]")
	private WebElement CityLocations;
	

	@FindBy(xpath = "//*[@id='miles']")
	private WebElement MilesField;

	@FindBy(xpath = "//*[@type='submit']")
	private WebElement SearchIcon;

	@FindBy(xpath = "//*[@class='text-primary']")
	private WebElement TrendingSearches;
	
	@FindBy(xpath = "//a[contains(text(),'Registered Nurse')]")
	private WebElement TrendingSearchLink;
	
	@FindBy(xpath = "(//*[@class='view_more'])[1]")
	private WebElement ViewMoreJobsLink;
	
	@FindBy(xpath = "//div[@class='owl-stage']")
	private WebElement CompaniesLogoScroll;
	
	@FindBy(xpath = "(//*[@class='view_more'])[2]")
	private WebElement ViewMoreCompaniesLink;
	
	@FindBy(xpath = "//span[@class='icon-facebook']")
	private WebElement FacebookIcon;
	
	@FindBy(xpath = "//span[@class='icon-instagram']")
	private WebElement InstagramIcon;
	
	@FindBy(xpath = "(//*[@class='copyright']/a)[1]")
	private WebElement PrivacyPolicyLink;
	
	@FindBy(xpath = "(//*[@class='copyright']/a)[2]")
	private WebElement TermsOfServiceLink;
	
	@FindBy(xpath = "(//*[@class='copyright']/a)[3]")
	private WebElement CookiePolicyLink;
	
	@FindBy(xpath = "(//p[@class='copyright'])[2]")
	private WebElement CopyRightFooter;
	
	
	
	
	
	
	
	
	
	
	
	public WebElement getHomePageLogo() {
		return HomePageLogo;
	}
	
	public WebElement getHomeTab() {
		return HomeTab;
	}
	public WebElement getJobsTab() {
		return JobsTab;
	}
	public WebElement getAboutTab() {
		return AboutTab;
	}
	public WebElement getBlogTab() {
		return BlogTab;
	}
	public WebElement getContactTab() {
		return ContactTab;
	}
	public WebElement getJobsAvailableHeader() {
		return JobsAvailableHeader;
	}
	public WebElement getJobsAvailableTagLine() {
		return JobsAvailableTagLine;
	}
	public WebElement getJobsTitleField() {
		return JobsTitleField;
	}
	public WebElement getCityField() {
		return CityField;
	}
	public WebElement getCityLocations() {
		return CityLocations;
	}
	
	public WebElement getMilesField() {
		return MilesField;
	}
	public WebElement getSearchIcon() {
		return SearchIcon;
	}
	
	public WebElement getTrendingSearches() {
		return TrendingSearches;
	}

	public WebElement getTrendingSearchLink() {
		return TrendingSearchLink;
	}
	
	public WebElement getViewMoreJobsLink() {
		return ViewMoreJobsLink;
	}
	
	public WebElement getCompaniesLogoScrolling() {
		return CompaniesLogoScroll;
	}
	
	public WebElement getViewMoreCompaniesLink() {
		return ViewMoreCompaniesLink;
	}
	
	public WebElement getFacebookIcon() {
		return FacebookIcon;
	}

	public WebElement getInstagramIcon() {
		return InstagramIcon;
	}

	public WebElement getPrivacyPolicyLink() {
		return PrivacyPolicyLink;
	}

	public WebElement getTermsOfServiceLink() {
		return TermsOfServiceLink;
	}

	public WebElement getCookiePolicyLink() {
		return CookiePolicyLink;
	}

	public WebElement getCopyRightFooter() {
		return CopyRightFooter;
	}
	
	
	
	public void openCCUrl() {
		try {
			
			driver.navigate().to(Page.ccURL);
			waitForPageLoad();
			//driver.navigate().to(WebDriverBase._prop.getString("ccurl"));
			AtuReports.passResults1("Navigate to "+Page.ccURL+" Application", "--",
					"Home Page should display", "Home Page is displayed");

		} catch (Exception exception) {
			driver.close();
			AtuReports.failResults("Navigate to "+Page.ccURL+" Application", "--",
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
			driver.close();
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
		case HomeTab:
			waitForPageElement(getHomeTab(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"HomePage");
			click(getHomeTab(), "HomePage");
			explicitWait(2);
			break;
        case JobsTab:
			waitForPageElement(getJobsTab(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"JobsPage");
			click(getJobsTab(), "JobsPage");
			explicitWait(2);
			break;
		case AboutTab:
			waitForPageElement(getAboutTab(), "WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"AboutPage");
			click(getAboutTab(), "AboutPage");
			explicitWait(2);
			break;
		case BlogTab:
			waitForPageElement(getBlogTab(), "WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"BlogPage");
			click(getBlogTab(), "BlogPage");
			explicitWait(2);
			break;
		case ContactTab:
			waitForPageElement(getContactTab(),"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE",
					"ContactPage");
			click(getContactTab(), "ContactPage");
			explicitWait(2);
			break;
			
		}
	}	
	
	
	public void verifyPresenceofTabs() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getHomeTab(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Home Tab");
		waitForPageElement(getJobsTab(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Jobs Tab");
		waitForPageElement(getAboutTab(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "About Tab");
		waitForPageElement(getBlogTab(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Blog Tab");
		waitForPageElement(getContactTab (),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Contact Tab");
		
	} 
	
	public void verifyJobsHeader() {
		isTextPresent(getJobsAvailableHeader(), "Jobs Available");
		
	}
	
	public void verifyJobsTagLine() {
		isTextPresent(getJobsAvailableTagLine(), "Find The Healthcare Career");
		
	}
	
	public void verifySearchFields() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getJobsTitleField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Job Title Field");
		waitForPageElement(getCityField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "City Field");
		waitForPageElement(getMilesField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Miles Field");
		waitForPageElement(getSearchIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Submit Button");	
			
	}
	
	
	public void getLocationDropdownValues() throws Exception {
		webDriverHelper.explicitWait(1);
		getCityField().sendKeys("A");
		webDriverHelper.explicitWait(2);
		isTextPresent(getCityLocations(), "Aarons");
		//List<String> values=getOptionsList(getCityLocations());
		
	}
	
	public void getMilesDropdownValues() {
		webDriverHelper.explicitWait(1);
		getMilesField().click();
		webDriverHelper.explicitWait(1);
		getAllValuesFromListBox(getMilesField(), " Drop Down ");
		
	}
	
	public void verifyTrendingSearches() {
		isTextPresent(getTrendingSearches(), "Trending Searches");	
	}
	
	
	public void verifyTrendingSearchLink() {
		 waitForPageElement(getTrendingSearchLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Trending Search Link");
		  String text1= getTrendingSearchLink().getText();
		  System.out.println("Value1::"+text1);
		  Page.jsClick(getTrendingSearchLink(), text1);
		  waitForPageLoad();
		  String text2=getJobsTitleField().getAttribute("value");
		  System.out.println("Value2::"+text2);
		  if(text1.equalsIgnoreCase(text2)) {
				  AtuReports.passResults1("Verify ::" +text1+ " trending search Job Role link navigated to Jobs Page",text1, text1+ " trending search job role link should be clicked and navigated to Jobs page ",text2+ " trending search job role link is clicked and navigated to Jobs page");
				  Reporter.LogEvent(TestStatus.PASS, "Verify ::" +text1+ " trending search Job Role link navigated to Jobs Page", text1+ " trending search job role link should be clicked and navigated to Jobs page ",text2+ " trending search job role link is clicked and navigated to Jobs page");
			  }
		  else {
			  AtuReports.failResults("Verify ::" +text1+ " trending search Job Role link navigated to Jobs Page",text1, text1+ " trending search job role link should be clicked and navigated to Jobs page ",text2+ " trending search job role link is clicked and not navigated to Jobs page");
			  Reporter.LogEvent(TestStatus.PASS, "Verify ::" +text1+ " trending search Job Role link navigated to Jobs Page", text1+ " trending search job role link should be clicked and navigated to Jobs page ",text2+ " trending search job role link is clicked and not navigated to Jobs page");
			  driver.close();
		  }
	}
	
	
	public void verifyViewMoreJobsLink() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getViewMoreJobsLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "View More Jobs Link");
		jsClick(getViewMoreJobsLink(), "View More Jobs Link");
		 webDriverHelper.explicitWait(1);
	}
	
	public void verifyCompaniesLogoScrolling() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getCompaniesLogoScrolling(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Companies Logo Scrolling");
		}
	
	public void verifyViewMoreCompanyJobsLink() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getViewMoreCompaniesLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "View More Jobs For All Companies Link");
		jsClick(getViewMoreCompaniesLink(), "View More Jobs Companies Link");
		 webDriverHelper.explicitWait(1);
	}
	
	public void verifyFacebookIconPresence() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getFacebookIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Facebook Icon");
		}
	
	public void verifyInstagramIconPresence() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getInstagramIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Instagram Icon");
		}
	
		
	public void verifyFacebookIconNavigation() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getFacebookIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Facebook Icon");
		jsClick(getFacebookIcon(), "Facebook Icon");
		waitForPageLoad();
		String Pagetitle=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle);
	    if(Pagetitle.contains("Facebook")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  }
	    else {
	    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        driver.close();
	    }
		}
	
	public void verifyInstagramIconNavigation() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getInstagramIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Instagram Icon");
		jsClick(getInstagramIcon(), "Instagram Icon");
		waitForPageLoad();
		String Pagetitle=Page.getPageTitle(); 
		 System.out.println("Value::"+Pagetitle);
		if(Pagetitle.contains("Instagram")) {
		  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
	  }
		  else {
		    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        driver.close();
		    }
	}

	
	public void verifyPrivacyPolicyNavigation() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getPrivacyPolicyLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Privacy Policy Link");
		jsClick(getPrivacyPolicyLink(), "Privacy Policy Link");
		waitForPageLoad();
		String Pagetitle=Page.getPageTitle(); 
		 System.out.println("Value::"+Pagetitle);
		if(Pagetitle.contains("Privacy Policy")) {
		  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
	  }
		  else {
		    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        driver.close();
		    }
	}

	
	public void verifyTermsOfServiceNavigation() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getTermsOfServiceLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Terms of Service Link");
		jsClick(getTermsOfServiceLink(), "Terms of Service Link");
		waitForPageLoad();
		String Pagetitle=Page.getPageTitle(); 
		 System.out.println("Value::"+Pagetitle);
		if(Pagetitle.contains("TOS")) {
		  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
	  }
		  else {
		    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        driver.close();
		    }
	}

	
	public void verifyCookiePolicyNavigation() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getCookiePolicyLink(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Cookie Policy Link");
		jsClick(getCookiePolicyLink(), "Cookie Policy Link");
		waitForPageLoad();
		String Pagetitle=Page.getPageTitle(); 
		 System.out.println("Value::"+Pagetitle);
		if(Pagetitle.contains("Cookies")) {
		  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
	  }
		  else {
		    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
		        driver.close();
		    }
	}

	
	public void verifyCopyRightFooter() {
		isTextPresent(getCopyRightFooter(), "Copyright");	
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
