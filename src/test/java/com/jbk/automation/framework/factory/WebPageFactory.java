/**
 * 
 */
package com.jbk.automation.framework.factory;

import org.openqa.selenium.support.PageFactory;

import com.jbk.mh.pages.CCHomePage;
import com.jbk.mh.pages.CCJobDetailsPage;
import com.jbk.mh.pages.CCJobsPage;
import com.jbk.automation.framework.webdriver.Page;



public class WebPageFactory implements BasePageFactory {

	
	  public CCHomePage getCCHomePage() {
	  
	      return PageFactory.initElements(Page.driver, CCHomePage.class); }
	 
	  public CCJobsPage getCCJobsPage() {
		  
		  return PageFactory.initElements(Page.driver, CCJobsPage.class); }
	  
	  public CCJobDetailsPage getCCJobDetailsPage() {
		  
		  return PageFactory.initElements(Page.driver, CCJobDetailsPage.class); }

	  
	  
	  
	  
	  
	  
	  
}
