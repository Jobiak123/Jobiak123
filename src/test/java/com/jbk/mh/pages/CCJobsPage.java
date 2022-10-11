package com.jbk.mh.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.Reporter;
import com.jbk.automation.framework.util.Reporter.TestStatus;
import com.jbk.automation.framework.webdriver.Page;

public class CCJobsPage extends Page {
	
	@FindBy(xpath = "//*[@class='logo-main']")
	private WebElement JobsPageLogo;
	
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
	
	@FindBy(xpath = "//h1[@class='jobs_title']")
	private WebElement JobsAvailableHeader;

	@FindBy(xpath = "(//*[@class='job_title '])[1]")
	private WebElement JobTitle;

	@FindBy(xpath = "(//*[@class='address_title'])[1]")
	private WebElement JobEmployer;

	@FindBy(xpath = "(//*[@class='address_title'])[2]")
	private WebElement JobLocation;

	@FindBy(xpath = "(//*[@class='address_title'])[3]")
	private WebElement JobType;

	
	@FindBy(xpath = "(//*[@class='address_title'])[4]")
	private WebElement JobPostedDate;
	
	@FindBy(xpath = "(//*[@class='pr-btn'])[1]")
	private WebElement ApplyNowButton;
	
	@FindBy(xpath = "(//*[@class='page-item'])[4]")
	private WebElement Page5Link;
	
	@FindBy(xpath = "//*[@class='recaptcha-checkbox-border']")
	private WebElement CaptchaCheckbox;
	
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


	
	
	
	
	
	
	public WebElement getJobsPageLogo() {
		return JobsPageLogo;
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
	public WebElement getJobsAvailableHeader() {
		return JobsAvailableHeader;
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
	public WebElement getJobType() {
		return JobType;
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
	public WebElement getPage5Link() {
		return Page5Link;
	}
	
	public WebElement getCaptchaCheckbox() {
		return CaptchaCheckbox;
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
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Jobs Page");
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
	
	
	public void verifySearchFields() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getJobsTitleField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Job Title Field");
		waitForPageElement(getCityField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "City Field");
		waitForPageElement(getMilesField(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Miles Field");
		
		waitForPageElement(getSearchIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Search Icon");
			
	}
	
	public void getLocationDropdownValues() {
		webDriverHelper.explicitWait(1);
		getCityField().sendKeys("A");
		webDriverHelper.explicitWait(2);
		isTextPresent(getCityLocations(), "Aarons");
		
	}
	
	
	public void getMilesDropdownValues() {
		webDriverHelper.explicitWait(1);
		getMilesField().click();
		webDriverHelper.explicitWait(1);
		getAllValuesFromListBox(getMilesField(), " Drop Down ");
		
	}
	
	public void verifyJobsHeader() {
		isTextPresent(getJobsAvailableHeader(), "Jobs Available");
		
	}
	
	public void verifyApplyNowButtonDisplayed() {
		webDriverHelper.explicitWait(1);
		waitForPageElement(getApplyNowButton(),
				"WAIT_FOR_ELEMENT_TO_BE_ENABLED", "Apply Now Button");
		
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void verifyJobsPostedDate() {
	    //isTextPresent(getJobPostedDate(), "Jobs Posted Date");
	   String Pdate=getText(getJobPostedDate());
	   System.out.println(Pdate);
	   
	   LocalDate date=LocalDate.now();
	   DateTimeFormatter dformatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");
       System.out.println(dformatter.format(date));
       String tdate= dformatter.format(date).toString();
       System.out.println(tdate);
       
       LocalDate yesterday = date.minusDays(1);  
	   DateTimeFormatter yformatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");
       System.out.println(yformatter.format(yesterday));
       String ydate= yformatter.format(yesterday).toString();
       System.out.println(ydate);
       
	   LocalDate daybefore=date.minusDays(2); 
	   DateTimeFormatter dbformatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");
       System.out.println(dbformatter.format(daybefore));
       
       if (((Pdate.equals(tdate)||(Pdate.equals(ydate))))){
    	   
    	   AtuReports.passResults1("Verify " + Pdate + " is Displayed", "--",
					Pdate + " Should be Displayed ", Pdate + " is Displayed");

			Reporter.LogEvent(TestStatus.PASS, "Verify  " + Pdate + " is Displayed",
					Pdate + " Should be Displayed ", Pdate + " is Displayed");
       }
	}
	
	public void getJobDetails() {
		waitForTextToLoad(getJobTitle(),2);
		getText(getJobTitle());
		waitForTextToLoad(getJobEmployer(), 2);
		getText(getJobEmployer());
		waitForTextToLoad(getJobLocation(), 2);
		getText(getJobLocation());
		waitForTextToLoad(getJobType(), 2);
		getText(getJobType());
		waitForTextToLoad(getJobPostedDate(),2);
		getText(getJobPostedDate());
		//click(getJobTitle(), "Job Title");
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
	public void verifyFacebookNavigation() {
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
	
	public void verifyInstagramNavigation() {
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
