package com.jbk.automation.framework.reports;

import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class })
//@Listeners({ ATURLE.class, ConfigurationListener.class,MethodListener.class })
//@Listeners({ ATUReportsListenerExtended.class, ConfigurationListenerExtended.class,MethodListenerExtended.class })



public class AtuReports {

	// Set Property for ATU Reporter Configuration
	{
		
		//  System.setProperty("atu.reporter.config", System.getProperty("user.dir") +System.getProperty("File.separator")+
		 // "src"+System.getProperty("File.separator")+"test"+System.getProperty("File.separator")+"resources"+System.getProperty("File.separator")+"atu.properties");
		 
		
		System.setProperty("atu.reporter.config",
				System.getProperty("user.dir")
						+ "\\src\\test\\resources\\atu.properties");
		setIndexPageDescription(); 	 	
		
		//  System.setProperty("atu.reporter.config","C:\\Users\\ADMIN\\eclipse-workspace\\MHAutomationFrameWork\\src\\test\\resources\\atu.properties");
			 
		//System.setProperty(“atu.reporter.config”, “D:\\Hisan Backup\\HisanS\\D\\ATUReporter_Selenium_testNG_2.1 jar javadoc prop file demo proj atu recorder\\ATUReporter_Selenium_testNG_2.1 jar+javadoc+prop file+demo proj+atu recorder\\atu.properties”);


		
	}

	public static void setAuthorInfoForReports(String author, String version) {
		ATUReports.setAuthorInfo(author, Utils.getCurrentTime(), version);

	}

	
	public static void setIndexPageDescription() {
		ATUReports.indexPageDescription = "Selenium Project Description <br/> <b>Selenium Application of HTML Tags</b>";
	}

	public static void passResults(String Desc, String InputValue,
			String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue,
				LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false);
	}

	public static void failResults(String Desc, String InputValue,
			String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue,
				LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false)
	}

	 @SuppressWarnings("deprecation")
	public static void passResults1(String Desc, String InputValue, String
	  ExpectedValue, String ActualValue) 
	  { 
	//ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue,
			// LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
	ATUReports.add(Desc, InputValue,ExpectedValue, ActualValue, false);
	}
	 

	
	  @SuppressWarnings("deprecation")
	public static void failResults1(String Desc, String InputValue, String
	  ExpectedValue, String ActualValue) 
	  { 
    // ATUReports.add(Desc, InputValue,ExpectedValue,ActualValue, // LogAs.PASSED, newCaptureScreen(ScreenshotOf.DESKTOP)); 
	  ATUReports.add(Desc, InputValue,ExpectedValue, ActualValue, true);
	  }
	 
	public static void info(String Desc, String InputValue,
			String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue,
				LogAs.INFO, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false)
	}

	public static void warning(String Desc, String InputValue,
			String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue,
				LogAs.WARNING, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		// ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false)
	}

	public static void notice(String Desc, String InputValue,
			String ExpectedValue, String ActualValue) {
		ATUReports.add(Desc, InputValue, ExpectedValue, ActualValue, LogAs.WARNING, null);
	}

	
	  @SuppressWarnings("deprecation")
	public static void failResults2(String Desc, String InputValue, String
	  ExpectedValue, String ActualValue) { ATUReports.add(Desc, ExpectedValue, ActualValue, false); 
	  ATUReports.add(Desc,InputValue,ExpectedValue,ActualValue, false);
	  }
	 

}
