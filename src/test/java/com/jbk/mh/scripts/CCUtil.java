package com.jbk.mh.scripts;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.PageFactory;

import com.jbk.automation.framework.webdriver.WebDriverBase;
import com.jbk.mh.pages.CCHomePage;
import com.jbk.mh.pages.CCJobDetailsPage;
import com.jbk.mh.pages.CCJobsPage;
import com.jbk.automation.framework.factory.BasePageFactory;
import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.DBUtil;


public class CCUtil extends WebDriverBase {
	
	public static CCHomePage getCCHomePage(Map<String, String> data,
			BasePageFactory pageFactory) {
		
		AtuReports.setAuthorInfoForReports("Syalavarthi", "1.0");
		CCHomePage ccHomePage=pageFactory.getCCHomePage();
		ccHomePage.openCCUrl();
		ccHomePage.waitForCCHomePageToLoad();
		return ccHomePage;
	}
	
	public static Iterator<Map<String, Object>> getCCJobDetailsPage(BasePageFactory pageFactory) throws Exception {
		AtuReports.setAuthorInfoForReports("Syalavarthi", "1.0");
		CCJobDetailsPage ccJobDetailsPage=pageFactory.getCCJobDetailsPage();
		
		DBUtil dbutil = ((DBUtil)getContext().getBean("dbUtil"));
		List<Map<String, Object>> dbList = 
				dbutil.getRows(getCCJdbcTemplate(),DBUtil.getNamedQuery("getCCGfjJobs"));
		
		for(Map<String, Object> rowData :dbList)
		                                         
		{
			String URL = (String)rowData .get("submittedUrl");
			System.out.println("Submitted URL::" +URL);
			Thread.sleep(3000);
			getDriver().navigate().to(URL);
			Thread.sleep(3000);
					
			ccJobDetailsPage.validateSocialIconLinks();
			ccJobDetailsPage.validateJobDetailsInfo();
			ccJobDetailsPage.validateJobDetailedInfo();
			ccJobDetailsPage.verifyJobBuckets(); 
			  
			}
		getDriver().close(); 
		Thread.sleep(3000);
		return dbList.iterator();
			
		
	}
}
