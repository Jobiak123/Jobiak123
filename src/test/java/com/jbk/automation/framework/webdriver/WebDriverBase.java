package com.jbk.automation.framework.webdriver;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
//import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import com.jbk.automation.framework.factory.BasePageFactory;
import com.jbk.automation.framework.factory.WebPageFactory;
import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.BrowserType;
import com.jbk.automation.framework.util.DBUtil;
import com.jbk.automation.framework.util.ExcelService;
import com.jbk.automation.framework.util.Reporter;
import com.jbk.automation.framework.util.Reporter.TestStatus;
import com.jbk.automation.framework.webdriver.WebDriverBase;
import com.jbk.automation.framework.util.SendMail;
import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Platform;


public class WebDriverBase {

	
	private static final String BROWSER_NAME = "browsername";
	private static BrowserType browserType;
	public static ResourceBundle _prop = ResourceBundle.getBundle("atu");
	public BasePageFactory pageFactory;
	WebDriver driver;

	private static JdbcTemplate ccJdbcTemplate = null;
	private static JdbcTemplate hcjJdbcTemplate = null;

	public static ApplicationContext context = null;

	public static ApplicationContext getContext() {
		return context;
	}

	public static JdbcTemplate getCCJdbcTemplate() {
		return ccJdbcTemplate;
	}
	
	public static JdbcTemplate getHCJJdbcTemplate() {
		return hcjJdbcTemplate;
	}
	
	public static ThreadLocal<WebDriver> driverForThread = new ThreadLocal<WebDriver>();

	
	
   public BasePageFactory getPageFactory() {
	  
			/*
			 * if (null == pageFactory) { pageFactory =
			 * "web".equalsIgnoreCase(WebDriverBase._prop1 .getString("platform")) ? new
			 * WebPageFactory() : new MobilePageFactory(); }
			 * 
			 */
	  pageFactory = new WebPageFactory(); 
	  return pageFactory; 
	  
	  }
	 

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Exception {
		context = new ClassPathXmlApplicationContext("/spring-beans.xml");
		ccJdbcTemplate = (JdbcTemplate) context.getBean("ccJdbcTemplate");
		hcjJdbcTemplate = (JdbcTemplate) context.getBean("hcjJdbcTemplate");
		

	}

	public static boolean deleteDir(File dir) throws Exception {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
				// System.gc();
				// Thread.sleep(2000);
			}
			// The directory is now empty so delete it

		}

		return dir.delete();

	}

	@BeforeClass(alwaysRun = true)
	public static void indexDescription() {
		// com.cc.automation.framework.atuReports.setAuthorInfoForReports();
		AtuReports.setIndexPageDescription();

	}

	
	/*
	 * @BeforeTest(alwaysRun = true)
	 * 
	 * @Parameters({ BROWSER_NAME, "browserversion", "platform" }) public static
	 * void setUpTest(String browserName, String browserVersion, String platform) {
	 * 
	 * for (BrowserType browser : BrowserType.values()) {
	 * if(browser.toString().toLowerCase().equals(browserName.toLowerCase())) {
	 * browserType = browser; break; } }
	 * 
	 * }
	 * 
	 * 
	 */	
	
		
		  @BeforeMethod(alwaysRun = true) 
		  public void setUp(ITestContext ic, Method method) throws IOException { //
		 //  Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe"); // driver =
		 // loadRemoteWebDriver();
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		  ChromeOptions options =new ChromeOptions(); 
		 ChromeDriver driver = new ChromeDriver(options); 
		  driver.manage().window().maximize();
		 
		  driverForThread.set(driver);
		  Page.driver = driverForThread.get();
		  ATUReports.setWebDriver(driverForThread.get());
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  System.out.println("method.getName() - " + method.getName());
		  System.out.println("ic.getClass().getName() - " + this.getClass().getName());
		 // driverForThread.set(loadWebDriver()); 
		  new Reporter(method.getName(),
		  Reporter.getDateFormat(Reporter.vDatetype8)); 
		  Reporter.stepCount = 1;
		  
		  }
		 
	
	  public static WebDriver getDriver() {
		// driverForThread.get().manage().window().maximize();
		
		return driverForThread.get();
		
	}
	
	
		
	private static DesiredCapabilities generateDesiredCapabilities(BrowserType capabilityType) {
		
		DesiredCapabilities capabilities;

		switch (capabilityType) {
		case IE:
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			// capabilities.setCapability("requireWindowFocus", true);
			/*
			 * capabilities.getBrowserName(); capabilities.getVersion();
			 */
			Platform.BROWSER_NAME = capabilities.getBrowserName();
			Platform.BROWSER_VERSION = capabilities.getVersion();

			break;
		case SAFARI:
			capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("safari.cleanSession", true);
			break;

		case CHROME:
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
			HashMap<String, String> chromePreferences = new HashMap<String, String>();
			// chromePreferences.put("download.prompt_for_download", "false");
			chromePreferences.put("profile.password_manager_enabled", "false");
			capabilities.setCapability("chrome.prefs", chromePreferences);
			break;
		case FIREFOX:
			capabilities = DesiredCapabilities.firefox();
			// capabilities.setCapability("browser.helperApps.neverAsk.saveToDisk",
			// "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
			break;

		default:
			capabilities = DesiredCapabilities.htmlUnit();
			capabilities.setCapability("javascriptEnabled", "true");
		}

		return capabilities;
	}
	
	

	
	
	
	  private static WebDriver loadRemoteWebDriver() {
	  System.out.println("Current Browser Selection: " + browserType); 
	  try {
		  return
	  new RemoteWebDriver(new URL((String)
	  WebDriverBase.context.getBean("grid_url")),
	  generateDesiredCapabilities(browserType)); 
		  } catch (MalformedURLException e)
	  { e.printStackTrace(); } 
	  throw new
	  RuntimeException("Unable to create driver"); }
	 
	 
		
	static int counter;
	public long vScriptStartTime = Calendar.getInstance().getTimeInMillis();
	
	
	@DataProvider(name = "CCLoginCredentials")
	public Iterator<Object[]> ccDataProvider(Method method) {

		System.out.println("counter===" + counter++);
		return new ExcelService().readTestDataFromExcel(
				(String)WebDriverBase.context.getBean("CCTestDataWorkBookName"),
				"TestData",method.getName());

	}


	@DataProvider(name = "CCPostedGFJJobs")
	public Iterator<Object[]> ccPostedGFJDataProvider() {

		 List<Object[]> ccData = new ArrayList<Object[]>();
		
		 DBUtil dbutil = ((DBUtil)getContext().getBean("dbUtil"));
		 List<Map<String,Object>> dbList = dbutil.getRows(getCCJdbcTemplate(),DBUtil.getNamedQuery("getCCPostedGfjJobs"));
		 
		 for(Map<String, Object> map :dbList)
		 {
			  Object value= map.get("submittedUrl"); 
			  System.out.println( "Submitted URL ::" + value); 
			  Object[] obj = new Object[1]; 
			  obj[0] = value;
			 
		      ccData.add(obj);
	        //  System.out.println("After For Loop");
	           
		 }
			//   System.out.println("In After  Main For Loop");
	        //   System.out.println("Before return "+ccData.size());
			return ccData.iterator();
			
	}	

	
	@DataProvider(name = "CCNonPostedGFJJobs")
	public Iterator<Object[]> ccNonPostedGFJDataProvider() {

		 List<Object[]> ccData = new ArrayList<Object[]>();
		
		 DBUtil dbutil = ((DBUtil)getContext().getBean("dbUtil"));
		 List<Map<String,Object>> dbList = dbutil.getRows(getCCJdbcTemplate(),DBUtil.getNamedQuery("getCCNonPostedGfjJobs"));
		 
		 for(Map<String, Object> map :dbList)
		 {
			 Object value= map.get("uniqueid"); 
			  System.out.println( "Unique Id ::" + value); 
			  Object[] obj = new Object[1]; 
			  obj[0] = value;
			 
		      ccData.add(obj);
	        //  System.out.println("After For Loop");
	           
		 }
			//   System.out.println("In After  Main For Loop");
	        //   System.out.println("Before return "+ccData.size());
			return ccData.iterator();
			
	}	

	
	@DataProvider(name = "HCJPostedGFJJobs")
	public Iterator<Object[]> hcjPostedGFJDataProvider() {

		 List<Object[]> ccData = new ArrayList<Object[]>();
		
		 DBUtil dbutil = ((DBUtil)getContext().getBean("dbUtil"));
		 List<Map<String,Object>> dbList = dbutil.getRows(getHCJJdbcTemplate(),DBUtil.getNamedQuery("getHCJPostedGfjJobs"));
		 
		 for(Map<String, Object> map :dbList)
		 {
			 Object value= map.get("submittedUrl"); 
			  System.out.println( "Submitted URL ::" + value); 
			  Object[] obj = new Object[1]; 
			  obj[0] = value;
			 
		      ccData.add(obj);
	        //  System.out.println("After For Loop");
	           
		 }
			//   System.out.println("In After  Main For Loop");
	        //   System.out.println("Before return "+ccData.size());
			return ccData.iterator();
			
	}	

	
	@DataProvider(name = "HCJNonPostedGFJJobs")
	public Iterator<Object[]> hcjNonPostedGFJDataProvider() {

		 List<Object[]> ccData = new ArrayList<Object[]>();
		
		 DBUtil dbutil = ((DBUtil)getContext().getBean("dbUtil"));
		 List<Map<String,Object>> dbList = dbutil.getRows(getHCJJdbcTemplate(),DBUtil.getNamedQuery("getHCJNonPostedGfjJobs"));
		 
		 for(Map<String, Object> map :dbList)
		 {
			 Object value= map.get("uniqueid"); 
			  System.out.println( "Unique Id ::" + value); 
			  Object[] obj = new Object[1]; 
			  obj[0] = value;
			 
		      ccData.add(obj);
	        //  System.out.println("After For Loop");
	           
		 }
			//   System.out.println("In After  Main For Loop");
	        //   System.out.println("Before return "+ccData.size());
			return ccData.iterator();
			
	}	

	
	
	
	
	
	
	

	public Iterator<Object[]> testDataprovider(String dashboardName, String module) {

		return new ExcelService().readTestDataFromExcel(
				(String) WebDriverBase.context.getBean(module + "TestDataWorkBookName"), dashboardName);
		
	}

		
	
	//  @AfterMethod(alwaysRun = true) 
	  public void tearDown(ITestResult paramITestResult) throws IOException { 
		  System.out.println("@AfterMethod"); 
	  //AtuReports.setAuthorInfoForReports();
	  String browserName =
	  paramITestResult.getAttribute(Platform.BROWSER_NAME_PROP).toString();
	  
	  System.out.println("steps count >>> "+Reporter.stepCount);
	  System.out.println("total steps count >>> "+Reporter.updateValue.totalSteps.
	  ordinal());
	  
	  if(Reporter.stepCount >0){ if (browserName != null &&
	  browserName.equalsIgnoreCase("Unknown")) {
	  paramITestResult.setAttribute("BrowserName", "Chrome");
	  paramITestResult.setAttribute("BrowserVersion", "v103.0"); }
	  
	  String finalScriptStatus; String sTemp =
	  paramITestResult.getTestContext().getFailedTests() .toString();
	  
	  Reporter.updateReports(Reporter.updateValue.tEndTime, "", "");
	  Reporter.updateReports(Reporter.updateValue.execTime,formatIntoHHMMSS(
	  Calendar.getInstance().getTimeInMillis()- vScriptStartTime).toString(), "");
	  Reporter.updateReports(Reporter.updateValue.totalSteps, "", "");
	  
	  if (!sTemp.contains("FAILURE")) { finalScriptStatus = "PASS";
	  Reporter.updateReports(Reporter.updateValue.execStatus, "",
	  finalScriptStatus); Reporter.updateReports(Reporter.updateValue.failedStepNo,
	  "", finalScriptStatus); // REPORTER.takeScreenShot(finalScriptStatus); 
	  //Click Logout // COMMON_METHODS.clickElement(getTestObject("OL_9"));
	  Reporter.LogEvent(TestStatus.INFO, "", "",
	  "-------->[ End Of Script Execution ]<--------");
	  
	  } else { finalScriptStatus = "FAIL";
	  Reporter.updateReports(Reporter.updateValue.execStatus, "",
	  finalScriptStatus); Reporter.updateReports(Reporter.updateValue.failedStepNo,
	  "", finalScriptStatus); }
	  
	  // Rename the result log Reporter.RenameResultLog(finalScriptStatus);
	  
	   if (driverForThread.get() != null) {
	  
		 driverForThread.remove(); 
	    }
	  
	    }
	  }	  
	 	 

	public void closeSetup() {
		// com.rp.automation.framework.atuReports.setAuthorInfoForReports();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		// get current date time with Date()
		Date date = new Date();
		// System.out.println(dateFormat.format(date));
		String[] to = WebDriverBase._prop.getString("to").split(",");
		String[] cc = WebDriverBase._prop.getString("cc").split(",");
		String[] bcc = WebDriverBase._prop.getString("bcc").split(",");
		String userName = WebDriverBase._prop.getString("userName");
		String passWord = WebDriverBase._prop.getString("passWord");
		String host = WebDriverBase._prop.getString("host");
		String port = WebDriverBase._prop.getString("port");
		String starttls = WebDriverBase._prop.getString("starttls");
		String auth = WebDriverBase._prop.getString("auth");
		boolean debug = false;
		String socketFactoryClass = WebDriverBase._prop
				.getString("socketFactoryClass");
		String fallback = WebDriverBase._prop.getString("fallback");
		String subject = "Automation Execution Results of the Script" + "-"
				+ dateFormat.format(date);
		String text = "Hi All,\n     \nPlease find the Automation Execution Results in attachement.\n      \nRegard's,\n LDS Automation Team";
		String attachmentPath = System.getProperty("user.dir")
				+ "//test-output//";
		String attachmentName = "index.html";
		boolean value = SendMail.sendMail(userName, passWord, host, port,
				starttls, auth, debug, socketFactoryClass, fallback, to, cc,
				bcc, subject, text, attachmentPath, attachmentName);
		if (value == true) {
			System.out
					.println("Report Email Successfully sent to the Users Group");

		}

		/*
		 * System.out.println("driverForThread.get():"+driverForThread.get());
		 * if (driverForThread.get() != null) { getDriver().quit();
		 * driverForThread.remove(); }
		 */

	}



	
	/**
	 * PURPOSE: To Convert Milliseconds to HHMMSS format RETURN VALUE: HHMMSS
	 * format INPUT(s): Milli Seconds 
	 * 
	 * @param diffSeconds
	 * @return
	 * @see
	 * @since
	 * @author
	 **/
	protected static String formatIntoHHMMSS(long diffSeconds) {
		// Convert Milli Seconds into Seconds
		diffSeconds = diffSeconds / 1000;

		long hours = diffSeconds / 3600;
		long remainder = diffSeconds % 3600;
		long minutes = remainder / 60;
		long seconds = remainder % 60;

		return ((hours < 10 ? "0" : "") + hours + ":"
				+ (minutes < 10 ? "0" : "") + minutes + ":"
				+ (seconds < 10 ? "0" : "") + seconds);

	}

	
}
