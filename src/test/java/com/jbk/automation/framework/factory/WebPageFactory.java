
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
import com.jbk.mh.pages.MHDashboardPage;
import com.jbk.mh.pages.MHEmployersPage;
import com.jbk.mh.pages.MHHomePage;
import com.jbk.mh.pages.MHJobDetailsPage;
import com.jbk.mh.pages.MHJobSeekersPage;
import com.jbk.mh.pages.MHLoginPage;
import com.jbk.mh.pages.MHRegisterPage;
import com.jbk.mh.pages.MHWebStories;
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
    
    public MHHomePage getMHHomePage() {
     	  
	      return PageFactory.initElements(Page.driver, MHHomePage.class); }
	 
	 public MHJobDetailsPage getMHJobDetailsPage() {
		  
		  return PageFactory.initElements(Page.driver, MHJobDetailsPage.class); }
	  
	 public MHEmployersPage getMHEmployersPage() {
		  
		  return PageFactory.initElements(Page.driver, MHEmployersPage.class); }
	 
	 public MHDashboardPage getMHDashboardPage() {
		  
		  return PageFactory.initElements(Page.driver, MHDashboardPage.class); }
	 
	 public MHJobSeekersPage getMHJobSeekersPage() {
		  
		  return PageFactory.initElements(Page.driver, MHJobSeekersPage.class); }
	 
	 public MHLoginPage getMHLoginPage() {
		  
		  return PageFactory.initElements(Page.driver, MHLoginPage.class); }
	 
	 public MHRegisterPage getMHRegisterPage() {
		  
		  return PageFactory.initElements(Page.driver, MHRegisterPage.class); }
	 
	 public MHWebStories getMHWebStories() {
		  
		  return PageFactory.initElements(Page.driver, MHWebStories.class); }
	 
	  
	  
}
