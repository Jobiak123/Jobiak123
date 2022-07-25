package com.jbk.mh.pages;

import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;

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

	@FindBy(xpath = "(//*[@class='social-icons'])[1]/a[1]")
	private WebElement FacebookLogo;

	@FindBy(xpath = "(//*[@class='social-icons'])[1]/a[2]")
	private WebElement TwitterLogo;

	@FindBy(xpath = "(//*[@class='social-icons'])[1]/a[3]")
	private WebElement LinkedInLogo;

	@FindBy(xpath = "//*[@class=' pr-btn'][@type='button']")
	private WebElement ApplyNowButton;

	@FindBy(xpath = "(//*[@class='title'])[2]/b")
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

	
	@FindBy(xpath = "(//*[@class='text-bold'])[1]")
	private WebElement JobType;

	@FindBy(xpath = "(//*[@class='text-bold'])[2]")
	private WebElement Industry;

	@FindBy(xpath = "(//*[@class='text-bold'])[3]")
	private WebElement EstimatedSalary;

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
	
	public WebElement getFacebookLogo() {
		return FacebookLogo;
	}
	
	public WebElement getTwitterLogo() {
		return TwitterLogo;
	}
	
	public WebElement getLinkedInLogo() {
		return LinkedInLogo;
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
		isElementDisplayed(getFacebookLogo(), "Facebook Icon");
		isElementDisplayed(getTwitterLogo(), "Twitter Icon");
		isElementDisplayed(getLinkedInLogo(), "LinkedIn Icon");
		isElementDisplayed(getApplyNowButton(), "Apply Now Button");
	}
	
	
	public void validateJobDetailsInfo() {
		waitForTextToLoad(getJobTitle(),2);
		getText(getJobTitle());
		waitForTextToLoad(getJobEmployer(),1);
		getText(getJobEmployer());
		waitForTextToLoad(getJobLocation(),1);
		getText(getJobLocation());
		waitForTextToLoad(getJobPostedDate(),1);
		getText(getJobPostedDate());
	}
	
	
	public void validateJobDetailedInfo() {
		waitForTextToLoad(getJobDescription(),2);
		getText(getJobDescription());
		waitForTextToLoad(getJobTypeInfo(), 2);
		getText(getJobTypeInfo());
		waitForTextToLoad(getIndustryInfo(),2);
		getText(getIndustryInfo());
		waitForTextToLoad(getEstimatedSalaryInfo(),2);
		getText(getEstimatedSalaryInfo());
	
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
