package com.jbk.automation.framework.webdriver;


import java.awt.Color;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.jbk.automation.framework.reports.AtuReports;
import com.jbk.automation.framework.util.Reporter;
import com.jbk.automation.framework.util.WaitType;
import com.jbk.automation.framework.util.Reporter.TestStatus;

public class Page {

	public static WebDriver driver = WebDriverBase.getDriver();
	public static WebDriverHelper webDriverHelper = new WebDriverHelper(driver);
	
	public static String baseURL = (String) WebDriverBase.context.getBean("ccEnvURL");
	WebElement webElement = null;

	/* protected FrameworkServices frameworkServices; */
	public static String pageName;

	/**
	 * This method will perform click action on web element  
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */
	public static void click(WebElement pageElement, String logMessage) {
		try {
			pageElement.click();
			System.out.println("clicked");
			// FrameworkServices.logMessage("Clicked on: " + logMessage);
			AtuReports.passResults1("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					logMessage + " is clicked");
			Reporter.LogEvent(TestStatus.PASS, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", logMessage + " is clicked");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", catchException(exception));

			AtuReports.failResults("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					catchException(exception));

		}
	}

	/**
	 * This method will perform Java Script click action on web element
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */
	public static void jsClick(WebElement pageElement, String logMessage) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageElement);
			System.out.println("clicked");
			// FrameworkServices.logMessage("Clicked on: " + logMessage);
			AtuReports.passResults1("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					logMessage + " is clicked");
			Reporter.LogEvent(TestStatus.PASS, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", logMessage + " is clicked");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", catchException(exception));

			AtuReports.failResults("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					catchException(exception));

		}
	}

	/**
	 * This method will enter text in to text field
	 * 
	 * @param WebElement pageElement
	 * @param String     value
	 * @param String     logMessage
	 * @return void
	 */
	public void sendKeys(WebElement pageElement, String value, String logMessage) {
		try {

			pageElement.sendKeys(value);
			// FrameworkServices.logMessage("Enter text "+ value+" in: " +
			// logMessage +" text field");
			if (logMessage != null && logMessage.equalsIgnoreCase("IaPassWord"))
				logMessage = "XXXXXXX";
			AtuReports.passResults1("Verify text is entered to " + logMessage + " textbox", value,
					"Text '" + value + "' should be entered in to " + logMessage + " textbox",
					"Text '" + value + "' is entered in to " + logMessage + " textbox");

			Reporter.LogEvent(TestStatus.PASS, "Verify text is entered to " + logMessage + " textbox",
					"Text '" + value + "' should be entered in to " + logMessage + " textbox",
					"Text '" + value + "' is entered in to " + logMessage + " textbox");

			// System.out.println("Obj Name=="+this.getClass().getSimpleName());
		} catch (Exception exception) {
			// catchException(exception,logMessage);
			Reporter.LogEvent(TestStatus.FAIL, "Verify text is entered to " + logMessage + " textbox",
					"Text '" + value + "' should be entered in to " + logMessage + " textbox",
					catchException(exception));

			AtuReports.failResults("Failed to Enter text in " + logMessage + " text Field", value,
					"Text " + value + " should be entered in to " + logMessage + " text Field",
					catchException(exception));

		}
	}

	/**
	 * This method will perform clear action on web element
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */
	protected void clear(WebElement pageElement, String logMessage) {
		try {

			pageElement.clear();
			// FrameworkServices.logMessage("Clear: " + logMessage);
			AtuReports.passResults1("Clear text in: " + logMessage, "--", logMessage + " text should be cleared",
					logMessage + " text is be cleared");
			Reporter.LogEvent(TestStatus.PASS, "Clear test in: " + logMessage, logMessage + " text should be cleared",
					logMessage + " text is be cleared");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Clear test in: " + logMessage, logMessage + " text should be cleared",
					catchException(exception));
			AtuReports.failResults("Clear text in: " + logMessage, "--", logMessage + " text should be cleared",
					catchException(exception));

		}
	}

	/**
	 * This method will verify WebElement is displayed in the page
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */

	public boolean isElementDisplayed(WebElement pageElement, String logMessage) {

		boolean isElementDisplayed = false;

		try {

			isElementDisplayed = pageElement.isDisplayed() || pageElement.isEnabled();
			// FrameworkServices.logMessage(logMessage + " is Displayed in"
			// + pageName);
			AtuReports.passResults1("Verify element " + logMessage + " is Displayed", "--",
					logMessage + " Should be Displayed ", logMessage + " is Displayed");

			Reporter.LogEvent(TestStatus.PASS, "Verify element " + logMessage + " is Displayed",
					logMessage + " Should be Displayed ", logMessage + " is Displayed");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify element " + logMessage + " is Displayed",
					logMessage + " Should be Displayed ", catchException(exception));

			AtuReports.failResults(logMessage + " is not Displayed in" + this.getClass().getSimpleName(), "--",
					logMessage + " Should be Displayed  ", catchException(exception));

		}
		return isElementDisplayed;

	}

	/**
	 * This method will verify WebElement is not displayed in the page
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */

	public boolean isElementNotDisplayed(WebElement element, String logMessage) {

		boolean isElementNotDisplayed = false;
		int height = element.getSize().getHeight();
		int width = element.getSize().getWidth();

		if (height > 0 || width > 0) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify element" + logMessage + " is not Displayed",
					logMessage + " Should not be Displayed ", logMessage + " is Displayed");

			AtuReports.failResults("Verify element " + logMessage + " is not Displayed", "--",
					logMessage + " Should not be Displayed ", logMessage + " is Displayed");
		} else {
			isElementNotDisplayed = true;
			AtuReports.passResults1("Verify element" + logMessage + " is not Displayed", "--",
					logMessage + " Should not be Displayed ", logMessage + " is not Displayed");

			Reporter.LogEvent(TestStatus.PASS, "Verify element" + logMessage + " is not Displayed",
					logMessage + " Should not be Displayed ", logMessage + " is not Displayed");
		}

		return isElementNotDisplayed;

	}

	/**
	 * This method will verify WebElement is not displayed in the page
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */

	public boolean isElementNotDisplayed(String locator, String objectIdentifier, String logMessage) {

		boolean isElementNotDisplayed = false;
		int size = 0;
		if (objectIdentifier.equalsIgnoreCase("xpath"))
			size = driver.findElements(By.xpath(locator)).size();

		else if (objectIdentifier.equalsIgnoreCase("linkText"))
			size = driver.findElements(By.linkText(locator)).size();

		else if (objectIdentifier.equalsIgnoreCase("Id"))
			size = driver.findElements(By.id(locator)).size();
		System.out.println(size + "size");
		if (size > 0) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify element" + logMessage + " is not Displayed",
					logMessage + " Should not be Displayed ", logMessage + " is Displayed");

			AtuReports.failResults(logMessage + " is not Displayed", "--", logMessage + " Should not be Displayed ",
					logMessage + " is Displayed");
		} else {
			isElementNotDisplayed = true;
			AtuReports.passResults1("Verify element" + logMessage + " is not Displayed", "--",
					logMessage + " Should not be Displayed ", logMessage + " is not Displayed");

			Reporter.LogEvent(TestStatus.PASS, "Verify element" + logMessage + " is not Displayed",
					logMessage + " Should not be Displayed ", logMessage + " is not Displayed");
		}

		return isElementNotDisplayed;

	}

	
	public static String switchToParentWindow() {
		String parent=driver.getWindowHandle();
		String windowname=null;
		try {
				
			windowname= driver.switchTo().window(parent).getTitle();
			 System.out.println("Parent Window Title:" + windowname);
			 
			 AtuReports.passResults1("Switch to :" + windowname, "", "Window Should be Swithced to " + windowname,
						"Window is Swithced to " + windowname);

				Reporter.LogEvent(TestStatus.PASS, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
						"Window is Swithced to " + windowname);

				// Printing the Switching window
				System.out.println("Window Name " + windowname);
				return windowname;

			} catch (Exception exception) {

				Reporter.LogEvent(TestStatus.FAIL, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
						catchException(exception));
				AtuReports.failResults("Failed to  switch to window on " + pageName, "", "Window Should be Swithced ",
						catchException(exception));
			}
			return windowname;

	}
	
	
	
	
	public static void switchToDefault() {
		try {
			
			driver.switchTo().defaultContent();

			AtuReports.passResults1("Verify frame is switched to default content", "",
					"Frame should be switched to default content", "Frame is switched to default content");
			Reporter.LogEvent(TestStatus.PASS, "Verify frame is switched to default content",
					"Frame should be switched to default content", "Frame is switched to default content");

		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify frame is switched to default content",
					"Frame should be switched to default content", catchException(exception));
			AtuReports.failResults("Verify frame is switched to default content", "",
					"Frame should be switched to default content", "frame is not switched to default content");

		}

	}
	
	
	/**
	 * This method will switch to new tab
	 * 
	 * @return void
	 */

	public static String switchToNewTab() {
		String windowname = null;
		//String parent=driver.getWindowHandle();	
		try {

			  	
		       ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles()); 
		  	windowname = driver.switchTo().window(tab.get(1)).getTitle();
				System.out.println("windowname====" + windowname);
			
				AtuReports.passResults1("Switch to :" + windowname, "", "Window Should be Swithced to " + windowname,
					"Window is Swithced to " + windowname);

			Reporter.LogEvent(TestStatus.PASS, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
					"Window is Swithced to " + windowname);

			// Printing the Switching window
			System.out.println("Window Name " + windowname);
			return windowname;

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
					catchException(exception));
			AtuReports.failResults("Failed to  switch to window on " + pageName, "", "Window Should be Swithced ",
					catchException(exception));
		}
		return windowname;
	}
	
	
	
	
	
	
	
	
	/**
	 * This method will switch to window
	 * 
	 * @return void
	 */

	public static String switchToWindow() {
		String windowname = null;
		try {

			Set<String> WindowHandles = driver.getWindowHandles();
			Iterator<String> LoopIterator = WindowHandles.iterator();
			System.out.println("WindowHandles====" + WindowHandles);
			while (LoopIterator.hasNext()) {
				windowname = driver.switchTo().window(LoopIterator.next()).getTitle();
				System.out.println("windowname====" + windowname);
				// System.out.println("pagesource===="+driver.getPageSource());
			}
			// FrameworkServices.logMessage("Switched window title is : " +
			// windowname
			// + " from new window");
			AtuReports.passResults1("Switch to :" + windowname, "", "Window Should be Swithced to " + windowname,
					"Window is Swithced to " + windowname);

			Reporter.LogEvent(TestStatus.PASS, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
					"Window is Swithced to " + windowname);

			// Printing the Switching window
			System.out.println("Window Name " + windowname);
			return windowname;

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Switch to :" + windowname, "Window Should be Swithced to " + windowname,
					catchException(exception));
			AtuReports.failResults("Failed to  switch to window on " + pageName, "", "Window Should be Swithced ",
					catchException(exception));
		}
		return windowname;
	}

	
	/**
	 * This method will perform click action on web element
	 * 
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return void
	 */
	public static void selectListBox(WebElement pageElement, String value, String by, String logMessage) {
		try {

			Select select = new Select(pageElement);

			if (by.equalsIgnoreCase("ByVisibleText"))
				select.selectByVisibleText(value);

			else if (by.equalsIgnoreCase("Index"))
				select.selectByIndex(Integer.parseInt(value));

			else if (by.equalsIgnoreCase("value"))
				select.selectByValue(value);

			else
				select.selectByVisibleText(value);

			AtuReports.passResults1("Select: " + logMessage, value, logMessage + " Should be selected",
					logMessage + " is selected");

			Reporter.LogEvent(TestStatus.PASS, "Select: " + logMessage, logMessage + " Should be selected",
					logMessage + " is selected");

		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Select: " + logMessage, logMessage + " Should be selected",
					catchException(exception));

			AtuReports.failResults("Failed to select : " + logMessage, value, logMessage + " Should be selected",
					catchException(exception));

		}
	}

	public void verifySelectedValue(WebElement pageElement, String expectedValue) {
		String actualValue = getSelectedValueFromListBox(pageElement, expectedValue);
		actualValue = actualValue.replaceAll("\n", "").replaceAll(" +", " ");
		if (actualValue.trim().equals(expectedValue.trim())) {
			AtuReports.passResults1("Verify Selected Report ", "--", expectedValue, actualValue);

			Reporter.LogEvent(TestStatus.PASS, "Verify Selected Report ", expectedValue, actualValue);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify Selected Report ", expectedValue, actualValue);

			AtuReports.failResults("Verify Selected Report ", "--", expectedValue, actualValue);
		}

	}

	public static String getSelectedValueFromListBox(WebElement pageElement, String logMessage) {
		String selectedValue = null;
		try {

			Select select = new Select(pageElement);

			selectedValue = select.getFirstSelectedOption().getText();

		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Get selected option: " + logMessage,
					"Selected option should be returned", catchException(exception));

			AtuReports.failResults("Get selected option: " + logMessage, "--", "Selected option should be returned",
					catchException(exception));

		}
		return selectedValue;
	}

	public static ArrayList<String> getAllValuesFromListBox(WebElement pageElement, String logMessage) {
		ArrayList<String> optionList = new ArrayList<String>();
		try {

			Select select = new Select(pageElement);

			for (WebElement options : select.getOptions()) {

				optionList.add(options.getText().trim());
			}

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Get all values from the: " + logMessage,
					"All values should be retuned form the " + logMessage, catchException(exception));

			AtuReports.failResults("Get all values from the: " + logMessage, "--",
					"All values should be retuned form the " + logMessage, catchException(exception));

		}
		return optionList;
	}

	public static boolean switchToWindow(String windowTitle) {

		boolean isWindowSelected = false;
		try {
			explicitWait(10);
			Set<String> WindowHandles = driver.getWindowHandles();
			for (String windowname : WindowHandles) {
				driver.switchTo().window(windowname);
				waitForPageLoad();
				String wTitle = driver.getTitle();
				System.out.println(driver.getCurrentUrl() + "url");
				System.out.println("wTitle===" + wTitle);
				if (wTitle.contains(windowTitle)) {
					isWindowSelected = true;
					break;
				}
			}
		} catch (Exception exception) {
			AtuReports.failResults("Failed to switch to window : " + windowTitle, windowTitle,
					" window " + windowTitle + " should be selected", catchException(exception));

		}
		if (isWindowSelected)
			AtuReports.passResults1("Switch to window : " + windowTitle, windowTitle,
					" window " + windowTitle + " should be selected", windowTitle + " is selected");
		else
			AtuReports.failResults("Failed to switch to window : " + windowTitle, windowTitle,
					" window " + windowTitle + " should be selected", windowTitle + " is not selected");

		return isWindowSelected;
	}

	
	public static void waitForPageLoad() {
		webDriverHelper.WaitForPageLoad(180);
	}

	public void waitForPageElement(By by, String waitType, String logMessage) {

		WaitType waitTypes = WaitType.valueOf(waitType);

		switch (waitTypes) {
		case WAIT_FOR_TEXT_TO_BE_ABSENT_IN_ELEMENT:

			try {
				System.out.println("text: " + driver.findElement(by).getText());
				webDriverHelper.waitForTextToBeAbsentInElement(by, logMessage, 180);

				AtuReports.passResults1("Verify element text is disappeared " + logMessage, "--",
						logMessage + " should be disappeared ", logMessage + " is disappeared");

				Reporter.LogEvent(TestStatus.PASS, "Verify element text is disappeared " + logMessage,
						logMessage + " should be disappeared ", logMessage + " is disappeared");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element text is disappeared " + logMessage,
						logMessage + " should be disappeared ", catchException(e));

				AtuReports.failResults("Verify element is disappeared " + logMessage, "--",
						logMessage + " should be disappeared ", catchException(e));
			}
			break;

		default:
			break;
		}

	}

	public void waitForPageElement(WebElement pageElement, String waitType, String logMessage) {
		waitForPageElement(pageElement, waitType, logMessage, 180);
	}

	public void waitForPageElement(WebElement pageElement, String waitType, String logMessage, int timeOut) {
  

		WaitType waitTypes = WaitType.valueOf(waitType);

		switch (waitTypes) {
		case WAIT_FOR_ELEMENT_TO_BE_CLICKABLE:
			try {

				webElement = webDriverHelper.waitForElementToBeClickable(pageElement, timeOut);
				AtuReports.passResults1("Verify element is clickable " + logMessage, "--",
						logMessage + " should be clickable ", logMessage + " is displayed and clickable");

				Reporter.LogEvent(TestStatus.PASS, "Verify element is clickable " + logMessage,
						logMessage + " should be clickable ", logMessage + " is displayed and clickable");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element is clickable " + logMessage,
						logMessage + " should be clickable ", catchException(e));

				AtuReports.failResults("Verify element is clickable " + logMessage, "--",
						logMessage + " should be clickable ", catchException(e));

			}
			break;
		case WAIT_FOR_ELEMENT_TO_BE_ENABLED:

			try {

				webElement = webDriverHelper.waitForElementToBeEnabled(pageElement, timeOut);

				AtuReports.passResults1("Verify element is enabled " + logMessage, "--",
						logMessage + " should be enabled ", logMessage + " is displayed and enabled");

				Reporter.LogEvent(TestStatus.PASS, "Verify element is enabled " + logMessage,
						logMessage + " should be enabled ", logMessage + " is displayed and enabled");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element is enabled " + logMessage,
						logMessage + " should be enabled ", catchException(e));

				AtuReports.failResults("Verify element is enabled " + logMessage, "--",
						logMessage + " should be enabled ", catchException(e));

			}
			break;
		case WAIT_FOR_ELEMENT_TO_BE_DISPLAYED:

			try {

				webElement = webDriverHelper.waitForElementToBeDisplayed(pageElement, timeOut, logMessage);
				AtuReports.passResults1("Verify element is displayed " + logMessage, "--",
						logMessage + " should be displayed ", logMessage + " is displayed");

				Reporter.LogEvent(TestStatus.PASS, "Verify element is displayed " + logMessage,
						logMessage + " should be displayed ", logMessage + " is displayed");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element is displayed " + logMessage,
						logMessage + " should be displayed ", catchException(e));

				AtuReports.failResults("Verify element is displayed " + logMessage, "--",
						logMessage + " should be displayed ", catchException(e));
			}
			break;

		case WAIT_FOR_ELEMENT_TO_DISAPPEAR:

			try {

				webDriverHelper.waitForElementToDisappear(pageElement, timeOut);

				AtuReports.passResults1("Verify element is disappeared " + logMessage, "--",
						logMessage + " should be disappeared ", logMessage + " is disappeared");

				Reporter.LogEvent(TestStatus.PASS, "Verify element is disappeared " + logMessage,
						logMessage + " should be disappeared ", logMessage + " is disappeared");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element is disappeared " + logMessage,
						logMessage + " should be disappeared ", catchException(e));

				AtuReports.failResults("Verify element is disappeared " + logMessage, "--",
						logMessage + " should be disappeared ", catchException(e));
			}
			break;

		case WAIT_FOR_TEXT_TO_BE_PRESENT_IN_ELEMENT:

			try {
				System.out.println("text: " + pageElement.getText());
				webDriverHelper.waitForTextToBePresentInElement(pageElement, logMessage, 180);

				AtuReports.passResults1("Verify element text is appeared " + logMessage, "--",
						logMessage + " should be appeared ", logMessage + " is appeared");

				Reporter.LogEvent(TestStatus.PASS, "Verify element text is appeared " + logMessage,
						logMessage + " should be appeared ", logMessage + " is appeared");

			} catch (Exception e) {

				Reporter.LogEvent(TestStatus.FAIL, "Verify element text is appeared " + logMessage,
						logMessage + " should be appeared ", catchException(e));

				AtuReports.failResults("Verify element is appeared " + logMessage, "--",
						logMessage + " should be appeared ", catchException(e));
			}
			break;

		default:
			break;
		}

	}

	/**
	 * This method will verify WebElement is displayed in the page
	 * 
	 * * @param WebElement pageElement
	 * 
	 * @param String logMessage
	 * @return void
	 */

	
	public void isTextPresent(WebElement pageElement, String logMessage) {

		boolean isTextPresent = false;

		try {
			String text = pageElement.getText();

			isTextPresent = text.contains(logMessage);

			System.out.println("pageElement.getText() " + text);
			if (isTextPresent) {
				AtuReports.passResults1("Verify text " + logMessage, "--", logMessage, text);

				Reporter.LogEvent(TestStatus.PASS, "Verify text " + logMessage, logMessage, text);
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, logMessage, text);

				AtuReports.failResults("Verify text " + logMessage, "--", logMessage, text);
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, logMessage, catchException(e));

			AtuReports.failResults("Verify text " + logMessage, "--", logMessage, catchException(e));

		}

	}

	public void visibilityOfText(String searchText) {

		boolean findText = driver.findElement(By.cssSelector("body")).getText().contains(searchText);
		if (findText) {
			AtuReports.passResults1("Verify text " + searchText, "--", searchText, searchText);

			Reporter.LogEvent(TestStatus.PASS, "Verify text " + searchText, searchText, searchText);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify text " + searchText, searchText, searchText);

			AtuReports.failResults("Verify text " + searchText, "--", searchText, searchText);
		}

	}

	public void isTextPresent(WebElement pageElement, String attribute, String logMessage) {

		boolean isTextPresent = false;

		try {
			String text = getText(pageElement, attribute);

			isTextPresent = text.contains(logMessage);

			if (isTextPresent) {
				AtuReports.passResults1("Verify text " + logMessage, "--", logMessage, text);

				Reporter.LogEvent(TestStatus.PASS, "Verify text " + logMessage, logMessage, text);
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, logMessage, text);

				AtuReports.failResults("Verify text " + logMessage, "--", logMessage, text);
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, logMessage, catchException(e));

			AtuReports.failResults("Verify text " + logMessage, "--", logMessage, catchException(e));

		}

	}

	
	
	/**
	 * This method catches the exception and will write the exception to TestNG ATU
	 * reports
	 * 
	 * * @param Exception exception
	 * 
	 * @param String logMessage
	 * @return void
	 */
	public static String catchException1(Exception exception) {

		// WebDriverBackedSelenium selenium = new
		// WebDriverBackedSelenium(driver,
		// "http://www.google.co.in.com");
		// Check if page source contains Http status and display that status
		if (driver.getPageSource().contains("HTTP Status")) {
			// String[] sTemp = selenium.getBodyText().split("type");
			return ""; // sTemp[0];
		}
		// Check if the Page Title Contains Internet Explorer cannot display the
		// webpage / Problem loading page
		else if (driver.getTitle().equalsIgnoreCase("This page can't be displayed")
				| driver.getTitle().equalsIgnoreCase("Problem loading page"))
			return "CHECK THE INTERNET CONNECTION";
		// check for the selenium exceptions and display the exception
		else {
			String sTemp1 = exception.getMessage();
			String[] sTemp2;
			if (sTemp1 != null && sTemp1.contains("WARN")) {
				sTemp2 = sTemp1.split("WARN");
				if (sTemp2.length > 0)
					sTemp2[0] = new String(sTemp2[0].substring(0, (sTemp2[0].length()) - 1));
			}

			else if (sTemp1 != null && sTemp1.contains("Timed out")) {
				sTemp2 = sTemp1.split(":");
				if (sTemp2.length > 0) {
					String replaceStr = sTemp2[1].replace("Build info", "");
					sTemp2[0] = new String(sTemp2[0] + " " + replaceStr);
				}
			}

			else {
				// sTemp2 = sTemp1.split(":");
				String sTemp3 = exception.toString();
				// String[] sTemp4= sTemp3.split(":");
				// sTemp4[0] = new String(sTemp4[0].substring(0,
				// (sTemp4[0].length())));
				// return sTemp4[0];
				return sTemp3;
			}
			sTemp1 = null;
			// sTemp3=null;
			return sTemp2[0];
		}

		// return " ";

	}

	public static String catchException(Exception exception) {

		String sTemp1 = exception.getMessage();
		String[] sTemp2;
		if (sTemp1 != null && sTemp1.contains("WARN")) {
			sTemp2 = sTemp1.split("WARN");
			if (sTemp2.length > 0)
				sTemp2[0] = new String(sTemp2[0].substring(0, (sTemp2[0].length()) - 1));
		}

		else if (sTemp1 != null && sTemp1.contains("Timed out")) {
			sTemp2 = sTemp1.split(":");
			if (sTemp2.length > 0) {
				String replaceStr = sTemp2[1].replace("Build info", "");
				sTemp2[0] = new String(sTemp2[0] + " " + replaceStr);
			}
		}

		else {
			// sTemp2 = sTemp1.split(":");
			String sTemp3 = exception.toString();
			// String[] sTemp4= sTemp3.split(":");
			// sTemp4[0] = new String(sTemp4[0].substring(0,
			// (sTemp4[0].length())));
			// return sTemp4[0];
			return sTemp3;
		}
		sTemp1 = null;
		// sTemp3=null;
		return sTemp2[0];
	}

	// return " ";

	public static WebElement getWebElement(String locator, String objectIdentifier, String logMessage) {
		WebElement element = null;
		try {

			if (objectIdentifier.equalsIgnoreCase("xpath"))
				element = driver.findElement(By.xpath(locator));

			else if (objectIdentifier.equalsIgnoreCase("linkText"))
				element = driver.findElement(By.linkText(locator));

			else if (objectIdentifier.equalsIgnoreCase("Id"))
				element = driver.findElement(By.id(locator));

			AtuReports.passResults1("Verify" + logMessage + "Webelement is displayed", "--",
					logMessage + " Webelement should be Displayed ", logMessage + " Webelement is Displayed");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify webelement " + logMessage + " is present",
					logMessage + " webelement should be present", catchException(exception));

			AtuReports.failResults("Verify webelement " + logMessage + " is present", "--",
					logMessage + " webelement should be present", catchException(exception));
		}

		return element;
	}

	public static List<WebElement> getWebElements(String locator, String objectIdentifier, String logMessage) {
		List<WebElement> element = null;

		try {

			if (objectIdentifier.equalsIgnoreCase("xpath"))
				element = driver.findElements(By.xpath(locator));

			else if (objectIdentifier.equalsIgnoreCase("linkText"))
				element = driver.findElements(By.linkText(locator));

			else if (objectIdentifier.equalsIgnoreCase("Id"))
				element = driver.findElements(By.id(locator));

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify webelement " + logMessage + " is present",
					logMessage + " webelement should be present", catchException(exception));

			AtuReports.failResults("Verify webelement " + logMessage + " is present", "--",
					logMessage + " webelement should be present", catchException(exception));
		}

		return element;
	}

	public static String getText(WebElement pageElement) {
		String test = "";
		try {
			test = pageElement.getText();
		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify text is present", " Text should be present",
					catchException(exception));

			AtuReports.failResults("Verify text is present", "--", " Text should be present",
					catchException(exception));
		}

		return test;
	}

	public static String getText(WebElement pageElement, String attribute) {

		String text = "";
		try {

			text = pageElement.getAttribute(attribute);
		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Get text", " Get text", catchException(exception));

			AtuReports.failResults("Get text", "--", " get text ", catchException(exception));
		}

		return text;
	}

	public static WebElement waitForTextToLoad(final WebElement pageElement, int timeOutPeriod) {

		WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
		webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

		return webDriverWait.until(new ExpectedCondition<WebElement>() {

			public WebElement apply(WebDriver driver) {
				try {
					if (pageElement.getText() != null) {

					 AtuReports.passResults1("Verify "+pageElement.getText()+" is displayed", "--", pageElement.getText()+" should be Displayed ",
								pageElement.getText() + " is Displayed");
						Reporter.LogEvent(TestStatus.PASS, "Verify "+pageElement.getText()+"is displayed",
								pageElement.getText() + " text should be Displayed ",
								pageElement.getText() + " is Displayed");

						return pageElement;
					} else
						return null;
				} catch (Exception ex) {

				}
				return pageElement;
			}

		});

	}

	public void waitForTextToDisappear(final WebElement element, int timeOutPeriod, final String text,
			String attribute) {
		WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
		webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
		try {

			if (attribute.equalsIgnoreCase("value")) {
				webDriverWait.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver driver) {
						// try {

						System.out.println("element.getText()==" + element.getAttribute("value"));
						if (element.isEnabled() && element.isDisplayed()
								&& !element.getAttribute("value").equalsIgnoreCase(text)) {
							AtuReports.passResults1("Verify text should disappear", "--",
									text + " text should disappear ", text + " is disappeared");
							Reporter.LogEvent(TestStatus.PASS, "Verify text should disappear",
									text + " text should disappear ", text + " is disappeared");
							return element;
						} else
							return null;
					}
				});
			} else {
				webDriverWait.until(new ExpectedCondition<WebElement>() {
					public WebElement apply(WebDriver driver) {
						// try {

						System.out.println("element.getText()==" + element.getText());
						if (element.isEnabled() && element.isDisplayed() && !element.getText().equalsIgnoreCase(text)) {
							AtuReports.passResults1("Verify text should disappear", "--",
									text + " text should disappear ", text + " is disappeared");
							Reporter.LogEvent(TestStatus.PASS, "Verify text should disappear",
									text + " text should disappear ", text + " is disappeared");
							return element;
						} else
							return null;
						// } catch (Exception ex) {
						// AtuReports.failResults("Verify webelement is present",
						// "--", " webelement should be present",
						// catchException(ex));
						// return null;
						// }
						// }

						// });
					}
				});
			}
			AtuReports.passResults1("Verify text is disappeared " + text, "--", text + " should disappear ",
					text + " is disappeard");

			Reporter.LogEvent(TestStatus.PASS, "Verify text is disappeared " + text, text + " should disappear ",
					text + " is disappeard");

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify text is disappeared " + text, text + " should disappear ",
					catchException(e));

			AtuReports.failResults("Verify text is disappeared " + text, "--", text + " should disappear ",
					catchException(e));

		}
	}

	public static Long JsExecutor(String attributeIdentifier, String attributeName, String value, String logMessage) {
		Long val = 0L;
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			val = (Long) js.executeScript("document.getElementById('" + attributeIdentifier + "').setAttribute('"
					+ attributeName + "','" + value + "')");

			AtuReports.passResults1("Verify " + logMessage + " is draged", "--", logMessage + " should be draged",
					logMessage + " is draged");

			Reporter.LogEvent(TestStatus.PASS, "Verify " + logMessage + " is draged", logMessage + " should be draged",
					logMessage + " is draged");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify " + logMessage + " is draged", logMessage + " should be draged",
					catchException(exception));

			AtuReports.failResults("Verify " + logMessage + " is draged", logMessage, logMessage + " should be draged",
					catchException(exception));

		}

		return val;
	}

	public static void JsExecutorClick(String attributeIdentifier, String action, String logMessage) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (action != null && action.equalsIgnoreCase("Id"))
				js.executeScript("document.getElementById('" + attributeIdentifier + "').click()");

			else if (action != null && action.equalsIgnoreCase("Name"))
				js.executeScript(
						"var objArr=document.getElementsByName('" + attributeIdentifier + "');objArr[0].click()");

			AtuReports.passResults1("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					logMessage + " is clicked");
			Reporter.LogEvent(TestStatus.PASS, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", logMessage + " is clicked");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify click action on: " + logMessage,
					logMessage + " Should be clicked", catchException(exception));

			AtuReports.failResults("Verify click action on: " + logMessage, "--", logMessage + " Should be clicked",
					catchException(exception));

		}

	}

	public static void JsExecutorSelect(String attributeIdentifier, String selectValue, String logMessage) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('" + attributeIdentifier + "').value='" + selectValue + "'");

			AtuReports.passResults1("Select: " + logMessage, selectValue, logMessage + " Should be selected",
					logMessage + " is selected");

			Reporter.LogEvent(TestStatus.PASS, "Select: " + logMessage, logMessage + " Should be selected",
					logMessage + " is selected");

		} catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Select: " + logMessage, logMessage + " Should be selected",
					catchException(exception));

			AtuReports.failResults("Failed to select : " + logMessage, selectValue, logMessage + " Should be selected",
					catchException(exception));

		}

	}

	public static void closeModalDialog() {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("var o1=top.getActiveDialog(); o1.$modal.children('.CloseModal').click()");

			AtuReports.passResults1("Verify modal dialog is closed", "--", "Modal dialog should be closed",
					"Modal dialog is closed");

			Reporter.LogEvent(TestStatus.PASS, "Verify modal dialog is closed", "Modal dialog should be closed",
					"Modal dialog is closed");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify modal dialog is closed", "Modal dialog should be closed",
					catchException(exception));

			AtuReports.failResults("Verify modal dialog is closed", "--", "should be draged",
					catchException(exception));

		}

	}

	public void mutipleSelect(String[] locators, String logMessage) {
		try {

			Actions ac = new Actions(Page.driver).keyDown(Keys.CONTROL);

			for (int i = 0; i < locators.length; i++) {
				ac.click(getWebElement("//span[text()='" + locators[i] + "']", "xpath", locators[i]));
			}

			ac.keyUp(Keys.CONTROL);
			ac.build().perform();

			AtuReports.passResults1("Select " + logMessage, "--", logMessage + "should be Select",
					logMessage + "is  Selected");

			Reporter.LogEvent(TestStatus.PASS, "Select " + logMessage, logMessage + "should be Select",
					logMessage + "is  Selected");

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Select " + logMessage, logMessage + "should be Select",
					catchException(exception));

			AtuReports.failResults("Select " + logMessage, "--", logMessage + "should be Select",
					catchException(exception));

		}
	}

	public static String getPageSource() {
		String pageSource = null;
		try {

			pageSource = driver.getPageSource();

		} catch (Exception exception) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify PageSource", "Get the page source", catchException(exception));

			AtuReports.failResults("Verify PageSource", "--", "Get the page source", catchException(exception));
		}

		return pageSource;
	}

	/**
	 * @param waitTime
	 * @see pass value in seconds
	 */
	public static void explicitWait(int waitTime) {

		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {

		}
	}

	
	public static void closeChildWindow() {
		try {

			driver.close();
		}

		catch (Exception exception) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify child window is closed", "Child window should be closed",
					catchException(exception));

			AtuReports.failResults("Verify child window is closed", "--", "Child window should be closed",
					catchException(exception));
		}

	}

	public void isDisabled(WebElement pageElement, String logMessage) {

		try {

			if (!pageElement.isEnabled()) {
				AtuReports.passResults1("Verify" + logMessage + " is disabled", "--",
						logMessage + " should be disabled", logMessage + " is disabled");

				Reporter.LogEvent(TestStatus.PASS, "Verify" + logMessage + " is disabled",
						logMessage + " should be disabled", logMessage + " is disabled");
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify" + logMessage + " is disabled",
						logMessage + " should be disabled", logMessage + " is Enabled");

				AtuReports.failResults("Verify" + logMessage + " is disabled", "--", logMessage + " should be disabled",
						logMessage + " is Enabled");
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify" + logMessage + " is disabled",
					logMessage + " should be disabled", catchException(e));

			AtuReports.failResults("Verify" + logMessage + " is disabled", "--", logMessage + " should be disabled",
					catchException(e));

		}

	}

	/**
	 * This method will perform a verification whether the element is enabled or not
	 * 
	 * @author syalavarthi
	 * @param WebElement pageElement
	 * @param String     logMessage
	 * @return boolean
	 * 
	 **/

	public boolean isEnabled(WebElement pageElement, String logMessage) {

		boolean result = false;
		try {

			if (pageElement.isEnabled()) {
				result = true;
				AtuReports.passResults1("Verify" + logMessage + " is enabled", "--", logMessage + " should be enabled",
						logMessage + " is enabled");

				Reporter.LogEvent(TestStatus.PASS, "Verify" + logMessage + " is enabled",
						logMessage + " should be enabled", logMessage + " is enabled");
			} else {
				result = false;
				Reporter.LogEvent(TestStatus.FAIL, "Verify" + logMessage + " is enabled",
						logMessage + " should be enabled", logMessage + " is Disabled");

				AtuReports.failResults("Verify" + logMessage + " is enabled", "--", logMessage + " should be enabled",
						logMessage + " is Disabled");
			}

		} catch (Exception e) {

			result = false;
			Reporter.LogEvent(TestStatus.FAIL, "Verify" + logMessage + " is enabled", logMessage + " should be enabled",
					catchException(e));

			AtuReports.failResults("Verify" + logMessage + " is enabled", "--", logMessage + " should be enabled",
					catchException(e));

		}

		return result;

	}

	/**
	 * This method will perform click action on web element
	 * 
	 * @author syalavarthi
	 * @param WebElement pageElement
	 * @param String     attribute Name
	 * @param String     Value
	 * @return void
	 */
	public void waitWhileElementHasAttributeValue(WebElement pageElement, String attribute, String value) {
		while (!pageElement.getAttribute(attribute).contains(value)) {
			int timeout = 10;
			if (timeout > 0) {
				timeout--;
				try {
					System.out.println(attribute + "\t" + value);
					Thread.sleep(1000);
				} catch (Exception e) {

				}
			}
		}
	}

	public void focus(WebElement pageElement, String logMessage) {
		try {
			Actions builder = new Actions(driver);
			builder.moveToElement(pageElement).perform();
			// builder.moveToElement(pageElement).click(pageElement).perform();
		} catch (Exception e) {
		}
	}

	/**
	 * This method will return current window handle
	 * 
	 * @author syalavarthi
	 * @return String
	 */
	public static String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	/**
	 * This method will switch to window using window handle
	 * 
	 * @author syalavarthi
	 * @param String windowHandle
	 * @return void
	 */
	public static void switchToWindowHandle(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	/**
	 * This method will return Page Title
	 * 
	 * @author syalavarthi
	 * @return String
	 */
	public static String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * This method will return Page Title
	 * 
	 * @author syalavarthi
	 * @param String title
	 * @return String
	 */
	public void verifyPageTitle(String expectedTitle) {

		try {
			String actualTitle = getPageTitle();

			if (actualTitle.contains(expectedTitle)) {
				AtuReports.passResults1("Verify title " + expectedTitle, "--", expectedTitle, actualTitle);

				Reporter.LogEvent(TestStatus.PASS, "Verify title " + expectedTitle, expectedTitle, actualTitle);
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify title " + expectedTitle, expectedTitle, actualTitle);

				AtuReports.failResults("Verify title " + expectedTitle, "--", expectedTitle, actualTitle);
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify title " + expectedTitle, expectedTitle, catchException(e));

			AtuReports.failResults("Verify title " + expectedTitle, "--", expectedTitle, catchException(e));

		}
	}

	
	/**
	 * This method will return element background color
	 * 
	 * @author syalavarthi
	 * @param WebElement element
	 * @return String
	 */
	public static String getBackgroundColor(WebElement element) {
		System.out.println(element.getCssValue("background-color") + " bg color");
		return element.getCssValue("background-color");
	}

	/**
	 * This method will close all the windows except parent window
	 * 
	 * @author syalavarthi
	 * @return void
	 */
	public static void closeAllTabsExceptParent() {
		String originalHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size() + "size");
		if (windowHandles.size() > 1) {
			for (String handle : windowHandles) {
				if (!handle.equals(originalHandle)) {
					System.out.println(originalHandle + "originalHandle");

					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);
		}
	}

	/**
	 * This method will verify if the list is ascending
	 * 
	 * @author syalavarthi
	 * @param List<WebElement> list
	 * @return boolean
	 */
	public boolean isListAscending(List<WebElement> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).getText().compareToIgnoreCase(list.get(i).getText()) > 0) {
				return false;
			}
		}

		return true;
	}

	/**
	 * This method will verify if the list is descending
	 * 
	 * @author syalavarthi
	 * @param List<WebElement> list
	 * @return boolean
	 */
	public boolean isListDescending(List<WebElement> list) {
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i - 1).getText().compareToIgnoreCase(list.get(i).getText()) < 0)
				return false;
		}

		return true;
	}


	/**
	 * This method will mouse hover the element
	 * 
	 * @author syalavarthi
	 * @param WebElement element
	 * @return void
	 */
	public void mouseHover(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
//			AtuReports.passResults1("Verify Mouse hover action",
//					"--", "Should be able to hover", "Mouse hover is success");
//			Reporter.LogEvent(TestStatus.PASS, "Verify Mouse hover action", "Should be able to hover", "Mouse hover is success");
		} catch (Exception e) {
			AtuReports.failResults("Verify Mouse hover action", "--", "Should be able to hover",
					"Mouse hover is not success: " + catchException(e));
			Reporter.LogEvent(TestStatus.FAIL, "Verify Mouse hover action", "Should be able to hover",
					catchException(e));

		}
	}

	/**
	 * This method will return date in required format
	 * 
	 * @author rciddagoni
	 * @param String   formatType
	 * @param Calendar cal
	 * @return String
	 */
	public String getFormatedDate(String formatType, Calendar cal) {
		DateFormat sdf = new SimpleDateFormat(formatType);
		String fromatedDateone = sdf.format(cal.getTime());
		return fromatedDateone;
	}

	/**
	 * This method will return date adding given months
	 * 
	 * @author rciddagoni
	 * @param int monthNumber
	 * @return Calendar
	 */
	public Calendar getMonth(int monthNumber) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, monthNumber);
		return cal;
	}

	/**
	 * This method will return date adding given days
	 * 
	 * @author syalavarthi
	 * @param int monthNumber
	 * @return Calendar
	 */
	public Calendar getDate(int dateRange) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, dateRange);
		return cal;
	}

	/**
	 * This method will return date adding given days
	 * 
	 * @author syalavarthi
	 * @param int monthNumber
	 * @return Calendar
	 */
	public Calendar getDateFromCurrentDate(int yearRange, int monthRange, int dateRange) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, dateRange);
		cal.add(Calendar.MONTH, monthRange);
		cal.add(Calendar.YEAR, yearRange);
		return cal;
	}

	/**
	 * This method will return date adding given days
	 * 
	 * @author syalavarthi
	 * @param int monthNumber
	 * @return Calendar
	 */
	public Calendar getDateFromGivenDate(int yearRange, int monthRange, int dateRange, Calendar cal) {
		// Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, dateRange);
		cal.add(Calendar.MONTH, monthRange);
		cal.add(Calendar.YEAR, yearRange);
		return cal;
	}

	/**
	 * This method will verify the page url
	 * 
	 * @author
	 * @param String url
	 */
	public void verifyPageUrl(String url) {
		String currentURL = driver.getCurrentUrl();
		System.out.println("currentURL " + currentURL);
		if (currentURL.equals(url)) {

			AtuReports.passResults1("Verify Url " + url, "--", url, currentURL);

			Reporter.LogEvent(TestStatus.PASS, "Verify Url " + url, url, currentURL);
		} else if (currentURL.contains(url)) {

			AtuReports.passResults1("Verify Url contains " + url, "--", url, currentURL);

			Reporter.LogEvent(TestStatus.PASS, "Verify Url contains" + url, url, currentURL);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify Url " + url, url, currentURL);
			AtuReports.failResults("Verify Url " + url, "--", url, currentURL);
		}

	}

	/**
	 * This method will refresh the current page
	 * 
	 * @author syalavarthi
	 */
	public void refresh() {
		driver.navigate().refresh();
		waitForPageLoad();
	}

	public void switchToWindowUrl(String url) {
		explicitWait(10);
		Set<String> windowHandles = driver.getWindowHandles();
		boolean flag = false;
		try {
			for (String windowHandle : windowHandles) {
				driver.switchTo().window(windowHandle);
				explicitWait(10);
				waitForPageLoad();
				if (driver.getCurrentUrl().contains(url)) {
					flag = true;
					break;
				}
			}
		} catch (Exception e) {
			Reporter.LogEvent(TestStatus.FAIL, "Verify switch window to Url " + url, url, catchException(e));
			AtuReports.failResults("Verify switch window to Url " + url, "--", url, catchException(e));
		}
		if (flag) {
			AtuReports.passResults1("Verify switch window to Url " + url, "--", url, "Switched to url");
			Reporter.LogEvent(TestStatus.PASS, "Verify switch window to Url " + url, url, "Switched to url");
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify switch window to Url " + url, url, "Unable to Switch to url");
			AtuReports.failResults("Verify switch window to Url " + url, "--", url, "Unable to Switch to url");
		}

	}

	public void invisibleOfText(String searchText) {

		boolean findText = driver.findElement(By.cssSelector("body")).getText().contains(searchText);
		if (findText) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify invisible text " + searchText, searchText, searchText);

			AtuReports.failResults("Verify invisible text " + searchText, "--", searchText, searchText);

		} else {
			AtuReports.passResults1("Verify invisible text " + searchText, "--", searchText, searchText);

			Reporter.LogEvent(TestStatus.PASS, "Verify invisible text " + searchText, searchText, searchText);
		}

	}

	public List<WebElement> getSelectOptions(WebElement selectElement) {
		Select select = new Select(selectElement);
		return select.getOptions();
	}

	public String getQuarter(String month) {
		int value = ((Integer.parseInt(month) - 1) / 3) + 1;
		return "Q" + value;
	}

	public String getQuarterAndYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		String quarter = getQuarter(String.valueOf(month));
		System.out.println(quarter + " " + year + "quarter year;");
		return quarter + " " + year;
	}

	public WebElement getLink(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public List<WebElement> getLinks(String linkText) {
		return driver.findElements(By.linkText(linkText));
	}

	public void compareText(String actual, String expected, String logMessage) {
		if (actual.equals(expected)) {
			AtuReports.passResults1("Verify text " + logMessage, "--", expected, actual);

			Reporter.LogEvent(TestStatus.PASS, "Verify text " + logMessage, expected, actual);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, expected, actual);

			AtuReports.failResults("Verify text " + logMessage, "--", expected, actual);
		}
	}

	public void compareText(String actual, String expected) {
		compareText(actual, expected, expected);
	}

	public List<String> getOptionsList(WebElement selectElement) {
		Select select = new Select(selectElement);
		List<WebElement> options = select.getOptions();
		List<String> optionValues = new ArrayList<String>();
		for (WebElement option : options) {
			optionValues.add(option.getText());
		}
		return optionValues;
	}

	
	/**
	 * This method will get the application current page url
	 * 
	 * @author syalavarthi
	 * @param String url
	 * @return
	 */
	public String getAppCurrentUrl() {
		String currentURL = driver.getCurrentUrl();
		;

		if (!currentURL.isEmpty()) {
			currentURL = driver.getCurrentUrl();
			AtuReports.passResults1("Get Current Application Url ", "--", "shoud get Live Application Url ",
					currentURL);

		} else {
			currentURL = "Url";
			AtuReports.failResults("Get Current Application Url", "--", "Shoud get Live Application Url",
					currentURL + "is Empty");

		}

		return currentURL;
	}

	
	/**
	 * This method will verify WebElement is displayed in the page
	 * 
	 * * @param WebElement pageElement
	 * 
	 * @param String value
	 * @param String logMessage
	 * @return void
	 */

	public void validateText(WebElement pageElement, String value, String logMessage) {

		boolean isTextPresent = false;

		try {
			String text = pageElement.getText();

			isTextPresent = text.contains(value);

			System.out.println("pageElement.getText() " + text);
			if (isTextPresent) {
				AtuReports.passResults1("Verify text " + logMessage, "--", value, text);

				Reporter.LogEvent(TestStatus.PASS, "Verify text " + logMessage, value, text);
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, value, text);

				AtuReports.failResults("Verify text " + logMessage, "--", value, text);
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify text " + logMessage, value, catchException(e));

			AtuReports.failResults("Verify text " + logMessage, "--", value, catchException(e));

		}

	}

	public static boolean isValidDate(String inDate, String format, String logMessage) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		try {
			dateFormat.parse(inDate);
		} catch (Exception e) {
			Reporter.LogEvent(TestStatus.FAIL, logMessage + " Date Format " + inDate,
					logMessage + ": " + inDate + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);

			AtuReports.failResults("Date Format " + inDate, "--",
					logMessage + ": " + inDate + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);
			return false;
		}
		AtuReports.passResults1(logMessage + ": " + "Date Format " + inDate, "--",
				logMessage + ": " + inDate + " Date Format is valid " + format,
				inDate + " Date Format is valid " + format);

		Reporter.LogEvent(TestStatus.PASS, "Date Format " + inDate,
				logMessage + ": " + inDate + " Date Format is valid " + format,
				inDate + " Date Format is valid " + format);
		return true;
	}

	public void validateHelpLink(WebElement link, String title) {
		String parenthandle = getCurrentWindowHandle();
		click(link, "Help Link");
		switchToWindow(title);
		switchToWindowHandle(parenthandle);
		closeAllTabsExceptParent();
	}

	public void isTextAbsent(WebElement pageElement, String logMessage) {

		boolean isTextPresent = false;

		try {
			String text = getText(pageElement);

			isTextPresent = !text.contains(logMessage);

			if (isTextPresent) {
				AtuReports.passResults1("Verify text is not present" + logMessage, "--", logMessage, text);

				Reporter.LogEvent(TestStatus.PASS, "Verify text is not present" + logMessage, logMessage, text);
			} else {
				Reporter.LogEvent(TestStatus.FAIL, "Verify text is not present" + logMessage, logMessage, text);

				AtuReports.failResults("Verify text is not present" + logMessage, "--", logMessage, text);
			}

		} catch (Exception e) {

			Reporter.LogEvent(TestStatus.FAIL, "Verify text is not present " + logMessage, logMessage,
					catchException(e));

			AtuReports.failResults("Verify text is not present " + logMessage, "--", logMessage, catchException(e));

		}

	}

	/**
	 * 
	 * @param colorStr e.g. "#FFFFFF"
	 * @return
	 * @return
	 */
	public String hexToRgbA(String hex) {
		return "rgb (" + Color.decode(hex).getRed() + ", " + Color.decode(hex).getGreen() + ", "
				+ Color.decode(hex).getRed() + ")";
	}

	/**
	 * 
	 * @param colorStr e.g. "#FFFFFF"
	 * @return
	 * @return
	 */
	public String rgbToHex(String font_color) {
		System.out.println(font_color + "font_color");
		String color1[];
		if (font_color.contains("rgba(")) {
			color1 = font_color.replace("rgba(", "").split(",");
		} else {
			color1 = font_color.replace("rgb(", "").replace(")", "").split(",");
		}
		String hex = String.format("#%02x%02x%02x", Integer.parseInt(color1[0].trim()),
				Integer.parseInt(color1[1].trim()), Integer.parseInt(color1[2].trim()));
		// Convert hex to rgb and Print rgb code
		return hex;

	}

	public static Date convertStringToDate(String inDate, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = dateFormat.parse(inDate);
		} catch (Exception e) {
			Reporter.LogEvent(TestStatus.FAIL, " Date Format " + inDate,
					inDate + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);

			AtuReports.failResults("Date Format " + inDate, "--", inDate + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);
		}
		return date;
	}

	public static Calendar convertStringToCalender(String date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date));
		} catch (Exception e) {
			Reporter.LogEvent(TestStatus.FAIL, " Date Format " + date, date + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);

			AtuReports.failResults("Date Format " + date, "--", date + " Date Format should be valid " + format,
					catchException(e) + " Date Format is not valid " + format);
		}
		return cal;
	}

	public String convertCalenderToString(Calendar cal, String format) {
		DateFormat sdf = new SimpleDateFormat(format);
		String fromatedDateone = sdf.format(cal.getTime());
		return fromatedDateone;
	}

	public static long daysBetween(Date date1, Date date2) {
		long difference = (date1.getTime() - date2.getTime()) / 86400000;
		return Math.abs(difference);
	}

	public void validateBackgroundColor(WebElement element, String color, String logMessage) {
		String actualColor = element.getCssValue("background-color");
		if (actualColor.equals(color)) {
			AtuReports.passResults1("Verify Background color " + logMessage, "--",
					"Background Color Should be " + color, "Background Color is " + actualColor);

			Reporter.LogEvent(TestStatus.PASS, "Verify Background color " + logMessage,
					"Background Color Should be " + color, "Background Color is " + actualColor);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify Background color " + logMessage,
					"Background Color Should be " + color, "Color is " + actualColor);

			AtuReports.failResults("Verify Background color " + logMessage, "--", "Background Color Should be " + color,
					"Background Color is " + actualColor);
		}

	}

	public void validateColor(WebElement element, String color, String logMessage) {
		String actualColor = element.getCssValue("color");
		if (actualColor.equals(color)) {
			AtuReports.passResults1("Verify color " + logMessage, "--", " Color Should be " + color,
					" Color is " + actualColor);

			Reporter.LogEvent(TestStatus.PASS, "Verify  color " + logMessage, " Color Should be " + color,
					" Color is " + actualColor);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify  color " + logMessage, " Color Should be " + color,
					"Color is " + actualColor);

			AtuReports.failResults("Verify  color " + logMessage, "--", " Color Should be " + color,
					" Color is " + actualColor);
		}

	}

	public void validateFont(WebElement element, String format, String logMessage) {
		String actualFont = element.getCssValue("font-family").toLowerCase();

		if (actualFont.contains(format.toLowerCase())) {
			AtuReports.passResults1("Verify font " + logMessage, "--", " Font Should be " + format,
					" Font is " + actualFont);

			Reporter.LogEvent(TestStatus.PASS, "Verify  Font " + logMessage, " Font Should be " + format,
					" Font is " + actualFont);
		} else {
			Reporter.LogEvent(TestStatus.FAIL, "Verify  Font " + logMessage, " Font Should be " + format,
					"Font is " + actualFont);

			AtuReports.failResults("Verify  Font " + logMessage, "--", " Font Should be " + format,
					" Font is " + actualFont);
		}
	}

	public String convertDatetoString(String date, String initialFormat, String finalFormat) {
		return convertCalenderToString(convertStringToCalender(date, initialFormat), finalFormat);
	}

		public static Timestamp getcurrentTime() {
		return new Timestamp(new java.util.Date().getTime());
	}

	public static long duration(Timestamp end_time, Timestamp start_time) {
		return end_time.getTime() - start_time.getTime();
	}

	/**
	 * This method will return no value after switching to a frame
	 * 
	 * @author syalavarthi
	 * @param String selectBtnValue
	 */

	
	public void bringElementInView(WebElement element) {
		((JavascriptExecutor) Page.driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void scrollUp() {
		((JavascriptExecutor) Page.driver).executeScript("scroll(0, -250);");
	}

	public void scrollDown() {
		((JavascriptExecutor) Page.driver).executeScript("scroll(0, 250);");
	}
}