package com.jbk.mh.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.Reporter;
import com.jbk.automation.framework.util.Reporter.TestStatus;
//import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.Page;
//import com.jbk.mh.pages.CCHomePage.LinkName;
//import com.thoughtworks.selenium.webdriven.commands.GetAttribute;

public class CCJobDetailsPage extends Page {
	
	
	public enum LinkName {
		FacebookLink, TwitterLink, LinkedInLink
	}

	@FindBy(xpath = "//*[@class='logo-heading']/figure/img")
	private WebElement CCJobDetailsLogo;

	@FindBy(xpath = "(//*[@class='title'])[1]")
	private WebElement JobTitle;

	@FindBy(xpath = "(//*[@class='sub-title'])[1]")
	private WebElement JobEmployer;

	@FindBy(xpath = "(//*[@class='sub-title'])[2]")
	private WebElement JobLocation;

	@FindBy(xpath = "(//*[@class='sub-title'])[3]")
	private WebElement JobPostedDate;

	@FindBy(xpath = "(//span[@class='icon-facebook'])[1]")
	private WebElement FacebookTopIcon;

	@FindBy(xpath = "//span[@class='icon-twitter']")
	private WebElement TwitterIcon;

	@FindBy(xpath = "//*[@class='css-1dbjc4n r-1wtj0ep']")
	private WebElement TwitterPopUp;

	
	@FindBy(xpath = "//span[@class='icon-linkedin2']")
	private WebElement LinkedInIcon;

	@FindBy(xpath = "(//span[@class='icon-facebook'])[2]")
	private WebElement FacebookBottomIcon;

	@FindBy(xpath = "//span[@class='icon-instagram']")
	private WebElement InstagramIcon;

	
	@FindBy(xpath = "//*[@class='pr-btn'][@type='button']")
	private WebElement ApplyNowButton;

	@FindBy(xpath = "//*[@class='desc border-bottom pb-3']")
	private WebElement JobDescription;

	@FindBy(xpath = "//*[@id='slidecont']/p[4]")
	private WebElement JobRequirements;

	@FindBy(xpath = "//*[@id='slidecont']/p[5]")
	private WebElement JobBenefits;

	@FindBy(xpath = "//*[@id='slidecont']/p[6]")
	private WebElement JobResponsibilities;

	@FindBy(xpath = "//*[@id='slidecont']/p[8]")
	private WebElement AboutEmployer;


	@FindBy(xpath = "//*[@id='slidecont']/p[3]")
	private WebElement JobTypeInfo;

	@FindBy(xpath = "//*[@id='slidecont']/p[5]")
	private WebElement IndustryInfo;

	@FindBy(xpath = "//*[@id='slidecont']/p[6]")
	private WebElement EstimatedSalaryInfo;

	
	@FindBy(xpath = "(//*[@class='fw-bold'])[1]")
	private WebElement JobType;

	@FindBy(xpath = "(//*[@class='fw-bold'])[2]")
	private WebElement Industry;

	@FindBy(xpath = "(//*[@class='text-bold'])[3]")
	private WebElement EstimatedSalary;

	@FindBy(xpath = "(//*[@class='fw-bold'])[3]")
	private WebElement PostalCode;
	
	
	@FindBy(xpath = "(//*[@class='widget-crd']/h5)[1]")
	private WebElement JobsInDemand;

	@FindBy(xpath = "(//*[@class='col-lg-12']/div/h5)[1]")
	private WebElement OtherJobsLocation;

	@FindBy(xpath = "(//*[@class='widget-crd']/h5)[2]")
	private WebElement OtherJobsForEmployer;

	@FindBy(xpath = "//*[@class='widget-title']")
	private WebElement SimilarJobs;
	
	@FindBy(xpath = "(//*[@class='widget-tag-list']/a)")
	private WebElement SimilarJobsList;

	@FindBy(xpath = "(//*[@class='copyright']/a)[1]")
	private WebElement PrivacyPolicyLink;
	
	@FindBy(xpath = "(//*[@class='copyright']/a)[2]")
	private WebElement TermsOfServiceLink;
	
	@FindBy(xpath = "(//*[@class='copyright']/a)[3]")
	private WebElement CookiePolicyLink;
	
	@FindBy(xpath = "(//p[@class='copyright'])[2]")
	private WebElement CopyRightFooter;
	
	
	
	
	public WebElement getCCJobDetailsLogo() {
		return CCJobDetailsLogo;
	}
	
	public WebElement getJobTitle() {
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
	
	public WebElement getFacebookTopIcon() {
		return FacebookTopIcon;
	}
	
	public WebElement getTwitterIcon() {
		return TwitterIcon;
	}
	
	public WebElement getTwitterPopUp() {
		return TwitterPopUp;
	}


	
	public WebElement getFacebookBottomIcon() {
		return FacebookBottomIcon;
	}
	
	public WebElement getInstagramIcon() {
		return InstagramIcon;
	}
	
	public WebElement getLinkedInIcon() {
		return LinkedInIcon;
	}
	
	public WebElement getApplyNowButton() {
		return ApplyNowButton;
	}
	
	public WebElement getJobDescription() {
		return JobDescription;
	}
	
	public WebElement getJobRequirements() {
		return JobRequirements;
	}
	
	public WebElement getJobBenefits() {
		return JobBenefits;
	}
	
	public WebElement getJobResponsibilities() {
		return JobResponsibilities;
	}
	
	public WebElement getAboutEmployer() {
		return AboutEmployer;
	}
	
	public WebElement getJobType() {
		return JobType;
	}
	
	public WebElement getIndustry() {
		return Industry;
	}
	
	public WebElement getEstimatedSalary() {
		return EstimatedSalary;
	}
	
	public WebElement getPostalCode() {
		return PostalCode;
	}
		
	public WebElement getJobTypeInfo() {
		return JobTypeInfo;
	}
	
	public WebElement getIndustryInfo() {
		return IndustryInfo;
	}
	
	public WebElement getEstimatedSalaryInfo() {
		return EstimatedSalaryInfo;
	}
	
	public WebElement getSimilarJobs() {
		return SimilarJobs;
	}
	
	public WebElement getSimilarJobsList() {
		return SimilarJobsList;
	}
	
	public WebElement getJobsInDemand() {
		return JobsInDemand;
	}
	
	public WebElement getOtherJobsLocation() {
		return OtherJobsLocation;
	}
	
	public WebElement getOtherJobsForEmployer() {
		return OtherJobsForEmployer;
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
	
		
	
	
	public void waitForCCJobDetailsPageToLoad() {
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
		waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	}

	public void validateSocialIconLinks() {
		isElementDisplayed(getFacebookTopIcon(), "Facebook Top Icon");
		isElementDisplayed(getTwitterIcon(), "Twitter Icon");
		isElementDisplayed(getLinkedInIcon(), "LinkedIn Icon");
		isElementDisplayed(getApplyNowButton(), "Apply Now Button");
		isElementDisplayed(getFacebookBottomIcon(), "Facebook Bottom Icon");
		isElementDisplayed(getInstagramIcon(), "Instagram Icon");
	}
	
	public void verifyFacebookTopIconNavigation() {
		jsClick(getFacebookTopIcon(), "Facebook Top Icon");
		waitForPageLoad();
	//	String parent=driver.getWindowHandle();		
	    ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
	    driver.switchTo().window(tab.get(1));      
		String Pagetitle=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle);
		
	    if(Pagetitle.contains("Facebook")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  }
	    else  {
	    	 AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
			 Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
			 driver.close();
	    }
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	    System.out.println("Value::"+driver.getTitle());
	}
	

	public void verifyTwitterNavigation() {
		waitForPageElement(getTwitterIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Twitter Icon");
		jsClick(getTwitterIcon(), "Twitter Icon");
		waitForPageLoad();
		//String parent=driver.getWindowHandle();	
		 ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
		driver.switchTo().window(tab.get(1));
		
		String Pagetitle=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle);
	    if(Pagetitle.contains("Want to Log")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		}
	    else {
	    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        driver.close();
	    }
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	    
	}

	

	public void verifyLinkedInNavigation() {
		waitForPageElement(getLinkedInIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "LinkedIn Icon");
		jsClick(getLinkedInIcon(), "LinkedIn Icon");
		waitForPageLoad();
	//	String parent=driver.getWindowHandle();	
		 
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
		driver.switchTo().window(tab.get(1));
		String Pagetitle=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle);
	    if(Pagetitle.contains("LinkedIn")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  }
	    else {
	    	AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
	        driver.close();
	    }
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	    
	}

	
	
	
	public void verifyFacebookBottomIconNavigation() {
		waitForPageElement(getFacebookBottomIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Facebook Bottom Icon");
		jsClick(getFacebookBottomIcon(), "Facebook Bottom Icon");
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
	        Assert.assertTrue(false);
	        driver.close();
	    }

		}
	
	
	
	
	public void verifyInstagramNavigation() {
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
		    Assert.assertTrue(false);
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
	       Assert.assertTrue(false);
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
		        Assert.assertTrue(false);
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
		       Assert.assertTrue(false);
		    }

	}

	
	public void verifyCopyRightFooter() {
		isTextPresent(getCopyRightFooter(), "Copyright");	
	}
		
	public void verifySocialIcoNavigations() {
		
		jsClick(getFacebookTopIcon(), "Facebook Top Icon");
		waitForPageLoad();
	//	String parent=driver.getWindowHandle();		
	    ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
	    driver.switchTo().window(tab.get(1));      
		String Pagetitle=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle);
		
	    if(Pagetitle.contains("Facebook")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and navigated to" +Pagetitle);
		  }
	    else  {
	    	 AtuReports.failResults("Verify navigation to"  +Pagetitle, Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
			 Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle, "Should be clicked and navigated to " +Pagetitle ,"Is clicked and not navigated to" +Pagetitle);
			 driver.close();
	    }
	    driver.close();
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	    System.out.println("Value::"+driver.getTitle());
	
	
		waitForPageElement(getTwitterIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "Twitter Icon");
		jsClick(getTwitterIcon(), "Twitter Icon");
		waitForPageLoad();
		//String parent=driver.getWindowHandle();	
	//	 ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 

		driver.switchTo().window(tab.get(1));
		
		String Pagetitle1=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle1);
	    if(Pagetitle1.contains("Want to Log")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle1, Pagetitle1, "Should be clicked and navigated to " +Pagetitle1 ,"Is clicked and navigated to" +Pagetitle1);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle1, "Should be clicked and navigated to " +Pagetitle1 ,"Is clicked and navigated to" +Pagetitle1);
		}
	    else {
	    	AtuReports.failResults("Verify navigation to"  +Pagetitle1, Pagetitle1, "Should be clicked and navigated to " +Pagetitle1 ,"Is clicked and not navigated to" +Pagetitle1);
	        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle1, "Should be clicked and navigated to " +Pagetitle1 ,"Is clicked and not navigated to" +Pagetitle1);
	        driver.close();
	    }
	    driver.close();
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");
	    
		waitForPageElement(getLinkedInIcon(),
				"WAIT_FOR_ELEMENT_TO_BE_CLICKABLE", "LinkedIn Icon");
		jsClick(getLinkedInIcon(), "LinkedIn Icon");
		waitForPageLoad();
	//	String parent=driver.getWindowHandle();	
		 
	//	ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
		driver.switchTo().window(tab.get(1));
		String Pagetitle2=Page.getPageTitle(); 
		System.out.println("Value::"+Pagetitle2);
	    if(Pagetitle2.contains("LinkedIn")) {
			  AtuReports.passResults1("Verify navigation to"  +Pagetitle2, Pagetitle2, "Should be clicked and navigated to " +Pagetitle2 ,"Is clicked and navigated to" +Pagetitle2);
			  Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle2, "Should be clicked and navigated to " +Pagetitle2 ,"Is clicked and navigated to" +Pagetitle2);
		  }
	    else {
	    	AtuReports.failResults("Verify navigation to"  +Pagetitle2, Pagetitle2, "Should be clicked and navigated to " +Pagetitle2 ,"Is clicked and not navigated to" +Pagetitle2);
	        Reporter.LogEvent(TestStatus.PASS, "Verify navigation to"  +Pagetitle2, "Should be clicked and navigated to " +Pagetitle2 ,"Is clicked and not navigated to" +Pagetitle2);
	        driver.close();
	    }
	    driver.close();
	    driver.switchTo().window(tab.get(0));
	    waitForPageElement(getCCJobDetailsLogo(),
				"WAIT_FOR_ELEMENT_TO_BE_DISPLAYED", "Job Details Page Logo");

		
		
		
	}

	
	
	
	public void validateJobDetailsInfo() {
		waitForTextToLoad(getJobTitle(),10);
		getText(getJobTitle());
		waitForTextToLoad(getJobEmployer(),10);
		getText(getJobEmployer());
		waitForTextToLoad(getJobLocation(),10);
		getText(getJobLocation());
		waitForTextToLoad(getJobPostedDate(),10);
		getText(getJobPostedDate());
	}
	
	
	public void validateJobDetailedInfo() {
	   
	   waitForTextToLoad(getJobDescription(),2);
		/*
		 * String desc= getText(getJobDescription()); if (desc.contains("?")){
		 * AtuReports.failResults("Verify Description contains special characters"
		 * +desc, desc,"Description should not contain special characters " +desc
		 * ,"Description contains" +desc); Reporter.LogEvent(TestStatus.PASS,
		 * "Verify Description contains special characters" +desc,
		 * "Description should not contain special characters " +desc
		 * ,"Description contains" +desc); driver.close(); } else {
		 * AtuReports.passResults1("Verify Description contains special characters"
		 * +desc, desc,"Description should not contain special characters " +desc
		 * ,"Description contains" +desc); Reporter.LogEvent(TestStatus.PASS,
		 * "Verify Description contains special characters" +desc,
		 * "Description should not contain special characters " +desc
		 * ,"Description contains" +desc); }
		 */
		
		waitForTextToLoad(getJobType(), 2);
		getText(getJobType());
		waitForTextToLoad(getIndustry(),2);
		getText(getIndustry());
		waitForTextToLoad(getPostalCode(),2);
		getText(getPostalCode());
	
	}
	
	
	public void verifyJobBuckets() {
		waitForTextToLoad(getJobsInDemand(),2);
		getText(getJobsInDemand());
		waitForTextToLoad(getOtherJobsLocation(), 2);
		getText(getOtherJobsLocation());
		waitForTextToLoad(getOtherJobsForEmployer(),2 );
	//	getText(getOtherJobsForEmployer());
	}
	
	public void verifySimilarJobs() {
		waitForTextToLoad(getSimilarJobs(),1);
		getText(getSimilarJobs());
		waitForTextToLoad(getSimilarJobsList(), 1);
		getText(getSimilarJobsList());
		
	}
	
	
	
	
}
