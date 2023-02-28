package com.jbk.automation.framework.factory;

import com.jbk.mh.pages.CCAboutPage;
import com.jbk.mh.pages.CCBlogPage;
import com.jbk.mh.pages.CCContactPage;
import com.jbk.mh.pages.CCHomePage;
import com.jbk.mh.pages.CCJobDetailsPage;
import com.jbk.mh.pages.CCJobsPage;
import com.jbk.mh.pages.HCJAboutPage;
import com.jbk.mh.pages.HCJBlogPage;
import com.jbk.mh.pages.HCJContactPage;
import com.jbk.mh.pages.HCJHomePage;
import com.jbk.mh.pages.HCJJobDetailsPage;
import com.jbk.mh.pages.MHDashboardPage;
import com.jbk.mh.pages.MHEmployersPage;
import com.jbk.mh.pages.MHHomePage;
import com.jbk.mh.pages.MHJobDetailsPage;
import com.jbk.mh.pages.MHJobSeekersPage;
import com.jbk.mh.pages.MHLoginPage;
import com.jbk.mh.pages.MHRegisterPage;
import com.jbk.mh.pages.MHWebStories;

public interface BasePageFactory {

	CCHomePage getCCHomePage();
	
	CCJobsPage getCCJobsPage();
	
	CCJobDetailsPage getCCJobDetailsPage();
	
	CCAboutPage getCCAboutPage();
	
	CCBlogPage getCCBlogPage();
	
	CCContactPage getCCContactPage();
	
    HCJHomePage getHCJHomePage();
	
	HCJJobDetailsPage getHCJJobDetailsPage();
	
	HCJAboutPage getHCJAboutPage();
	
	HCJBlogPage getHCJBlogPage();
	
	HCJContactPage getHCJContactPage();
	
	MHHomePage getMHHomePage();
		
	MHJobDetailsPage getMHJobDetailsPage();
	
	MHDashboardPage getMHDashboardPage();
	
	MHEmployersPage getMHEmployersPage();
	
	MHJobSeekersPage getMHJobSeekersPage();
	
	MHLoginPage getMHLoginPage();
	
	MHRegisterPage getMHRegisterPage();
	
	MHWebStories getMHWebStories();
	
	
	
	
	}
