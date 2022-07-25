package com.jbk.mh.scripts;

import org.testng.annotations.Test;

import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.Page;
//import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.WebDriverBase;
import com.jbk.mh.pages.CCHomePage;
import com.jbk.mh.pages.CCJobDetailsPage;
import com.jbk.mh.pages.CCJobsPage;

public class CCJobsDetailsPageTest extends WebDriverBase{
	
	
	@Test //(priority = 1, dataProvider = "CCLoginCredentials")
	public void validateJobDetailsPageTest() throws InterruptedException, Exception {
		
		//CCUtil.getCCHomePage(data, pageFactory);
		AtuReports.setAuthorInfoForReports("SYalavarthi", "1.0");
		CCHomePage ccHomePage=getPageFactory().getCCHomePage();
		CCJobsPage ccJobsPage=getPageFactory().getCCJobsPage();
		CCJobDetailsPage ccJobDetailsPage=getPageFactory().getCCJobDetailsPage();
		ccHomePage.openCCUrl();
		String link ="HomeLink";
		ccHomePage.clickOnLink(link);
		ccHomePage.searchByJobsTitleField("Nurse");
		ccJobsPage.getJobDetails();
		Thread.sleep(3000);
		Page.switchToNewTab();	          
        ccJobDetailsPage.validateSocialIconLinks();
		ccJobDetailsPage.validateJobDetailsInfo();
		ccJobDetailsPage.validateJobDetailedInfo();
		ccJobDetailsPage.verifyJobBuckets();
		//ccJobDetailsPage.verifySimilarJobs();
		Page.switchToParentWindow();
		Thread.sleep(3000);
		Page.driver.close();		
		
	}

}
