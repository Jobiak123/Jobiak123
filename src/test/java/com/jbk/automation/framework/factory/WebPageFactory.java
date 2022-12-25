
package com.jbk.automation.framework.factory;

import org.openqa.selenium.support.PageFactory;
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
import com.jbk.automation.framework.webdriver.Page;



public class WebPageFactory implements BasePageFactory {

	
	  public CCHomePage getCCHomePage() {
	  
	      return PageFactory.initElements(Page.driver, CCHomePage.class); }
	 
	  public CCJobsPage getCCJobsPage() {
		  
		  return PageFactory.initElements(Page.driver, CCJobsPage.class); }
	  
	  public CCJobDetailsPage getCCJobDetailsPage() {
		  
		  return PageFactory.initElements(Page.driver, CCJobDetailsPage.class); }

     public CCAboutPage getCCAboutPage() {
		  
		  return PageFactory.initElements(Page.driver, CCAboutPage.class); }
     
     public CCBlogPage getCCBlogPage() {
		  
		  return PageFactory.initElements(Page.driver, CCBlogPage.class); }
     
     public CCContactPage getCCContactPage() {
		  
		  return PageFactory.initElements(Page.driver, CCContactPage.class); }
	  
     
     public HCJHomePage getHCJHomePage() {
   	  
	      return PageFactory.initElements(Page.driver, HCJHomePage.class); }
	 
	 public HCJJobDetailsPage getHCJJobDetailsPage() {
		  
		  return PageFactory.initElements(Page.driver, HCJJobDetailsPage.class); }

    public HCJAboutPage getHCJAboutPage() {
		  
		  return PageFactory.initElements(Page.driver, HCJAboutPage.class); }
    
    public HCJBlogPage getHCJBlogPage() {
		  
		  return PageFactory.initElements(Page.driver, HCJBlogPage.class); }
    
    public HCJContactPage getHCJContactPage() {
		  
		  return PageFactory.initElements(Page.driver, HCJContactPage.class); }

	  
	  
	  
	  
	  
}
