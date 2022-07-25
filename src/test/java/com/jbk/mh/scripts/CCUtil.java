package com.jbk.mh.scripts;

import java.util.Map;

import com.jbk.automation.framework.webdriver.WebDriverBase;
import com.jbk.mh.pages.CCHomePage;
import com.jbk.automation.framework.factory.BasePageFactory;
import com.jbk.automation.framework.reports.AtuReports;


public class CCUtil extends WebDriverBase {
	
	public static CCHomePage getCCHomePage(Map<String, String> data,
			BasePageFactory pageFactory) {
		
		AtuReports.setAuthorInfoForReports("Syalavarthi", "1.0");
		CCHomePage ccHomePage=pageFactory.getCCHomePage();
		ccHomePage.openCCUrl();
		ccHomePage.waitForCCHomePageToLoad();
		return ccHomePage;
	
		
	}

}
