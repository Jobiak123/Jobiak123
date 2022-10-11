package com.jbk.automation.framework.factory;

import com.jbk.mh.pages.CCAboutPage;
import com.jbk.mh.pages.CCBlogPage;
import com.jbk.mh.pages.CCContactPage;
import com.jbk.mh.pages.CCHomePage;
import com.jbk.mh.pages.CCJobDetailsPage;
import com.jbk.mh.pages.CCJobsPage;

public interface BasePageFactory {

	CCHomePage getCCHomePage();
	
	CCJobsPage getCCJobsPage();
	
	CCJobDetailsPage getCCJobDetailsPage();
	
	CCAboutPage getCCAboutPage();
	
	CCBlogPage getCCBlogPage();
	
	CCContactPage getCCContactPage();
	
	}
