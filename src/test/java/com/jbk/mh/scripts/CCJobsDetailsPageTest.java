package com.jbk.mh.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.webdriver.Page;
import com.jbk.automation.framework.webdriver.WebDriverBase;
import com.jbk.mh.pages.CCJobDetailsPage;


public class CCJobsDetailsPageTest extends WebDriverBase 
  {
	
	@Test(dataProvider ="CCPostedGFJJobs")
	public void validatePostedGFJJobs(String data) throws Exception
	{
		
		  WebDriver driver=WebDriverBase.getDriver();
		  AtuReports.setAuthorInfoForReports("SYalavarthi", "1.0"); 
		  CCJobDetailsPage ccJobDetailsPage=getPageFactory().getCCJobDetailsPage();
		  System.out.println(" URL ::" + data);
		  Thread.sleep(1000);
		  driver.get(data);
		  Thread.sleep(3000);
		  ccJobDetailsPage.validateSocialIconLinks();
		  ccJobDetailsPage.validateJobDetailsInfo();
		  ccJobDetailsPage.validateJobDetailedInfo();
		  ccJobDetailsPage.verifyJobBuckets(); 
		  
		// ccJobDetailsPage.verifySimilarJobs();
		  
		  ccJobDetailsPage.verifyFacebookBottomIconNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		//  ccJobDetailsPage.verifyInstagramNavigation();
		//  driver.navigate().back();
		//  Thread.sleep(2000);
		  ccJobDetailsPage.verifyPrivacyPolicyNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyTermsOfServiceNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyCookiePolicyNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyCopyRightFooter();
		  Thread.sleep(1000);
	      driver.close();
					
	   }
	
	
	
	@Test(dataProvider ="CCNonPostedGFJJobs")
	public void validateNonPostedGFJJobs(String data) throws Exception
	{
		
		  WebDriver driver=WebDriverBase.getDriver();
		  AtuReports.setAuthorInfoForReports("SYalavarthi", "1.0"); 
		  CCJobDetailsPage ccJobDetailsPage=getPageFactory().getCCJobDetailsPage();
		  System.out.println(" unique id ::" + data);
		  Thread.sleep(1000);
		  driver.get(Page.ccJobURL+data);
		  Thread.sleep(3000);
		  ccJobDetailsPage.validateSocialIconLinks();
		  ccJobDetailsPage.validateJobDetailsInfo();
		  ccJobDetailsPage.validateJobDetailedInfo();
		  ccJobDetailsPage.verifyJobBuckets(); 
		  
		// ccJobDetailsPage.verifySimilarJobs();
		  
		  ccJobDetailsPage.verifyFacebookBottomIconNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyInstagramNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyPrivacyPolicyNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyTermsOfServiceNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyCookiePolicyNavigation();
		  driver.navigate().back();
		  Thread.sleep(2000);
		  ccJobDetailsPage.verifyCopyRightFooter();
		  Thread.sleep(1000);
		  driver.close();
					
	   }
  
  
   
  
  }
			   
		    
		   
	      
	     
		   
	
	
  
	

	    


	


	
	
	

	
	


