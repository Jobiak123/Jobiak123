package com.jbk.automation.framework.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Predicate;

/**
 * @author SYalavarthi
 */


public class WebDriverHelper {
   // WebDriver Page.driver;

    public WebDriverHelper(WebDriver driver) {
    	
        //this.driver = Page.driver;

    }

    public WebElement waitForElementToBeDisplayed(final WebElement element,
                                                  int timeOutPeriod,final String logMessage) {
    	
    	//try{
        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
         
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    if (element.isDisplayed()){
                    	
                        return element;
                        }
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {

                    return null;
                }
            }

        });
      
				
    }

    public WebElement waitForElementToBeDisplayed(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = Page.driver.findElement(by);
                    if (element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }
    
   
    
      
    public WebElement waitForElementToBeClickable(final By by, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = Page.driver.findElement(by);
                    if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeClickable(final WebElement element,
                                                  int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                	if (element.isEnabled() && element.isDisplayed())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final WebElement element,
                                                int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);

        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {

                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForElementToBeEnabled(final By by, int timeOutPeriod) {
        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    WebElement element = Page.driver.findElement(by);
                    if (element.isEnabled())
                        return element;
                    else
                        return null;
                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public WebElement waitForOptionToBePopulatedInList(
            final WebElement dropdownList, int timeOutPeriod) {

        WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
        webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        return webDriverWait.until(new ExpectedCondition<WebElement>() {

            public WebElement apply(WebDriver driver) {
                try {
                    List<WebElement> options = dropdownList.findElements(By
                            .tagName("option"));
                    if (options.size() > 1) {
                        return dropdownList;
                    } else
                        return null;

                } catch (NoSuchElementException ex) {
                    return null;
                } catch (StaleElementReferenceException ex) {
                    return null;
                } catch (NullPointerException ex) {
                    return null;
                }
            }

        });

    }

    public void waitForElementToDisappear(final By by, int timeOutPeriod) {

        FluentWait<By> fluentWait = new FluentWait<By>(by);
        fluentWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        fluentWait.withTimeout(timeOutPeriod, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return !Page.driver.findElement(by).isDisplayed();

                } catch (NoSuchElementException ex) {
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return true;
                }
            }
        });

    }

    public void waitForElementToDisappear(final WebElement element,
                                          int timeOutPeriod) {

        FluentWait<WebElement> fluentWait = new FluentWait<WebElement>(element);
        fluentWait.pollingEvery(5, TimeUnit.MICROSECONDS);
        fluentWait.withTimeout(timeOutPeriod, TimeUnit.SECONDS);
        fluentWait.until(new Predicate<WebElement>() {
            public boolean apply(WebElement element) {
                try {
                    return !element.isDisplayed();
                } catch (NoSuchElementException ex) {
                    return true;
                } catch (StaleElementReferenceException ex) {
                    return true;
                }
            }
        });
    }

  
    /**
     * @param waitTime
     * @see pass value in seconds
     */
    public void explicitWait(int waitTime) {

        try {
            Thread.sleep(waitTime * 1000);
        } catch (InterruptedException e) {

        }
    }

	public void waitForTextToBePresentInElement(WebElement pageElement,
			String text, int timeOutPeriod) {
		WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
    	webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        webDriverWait.until(ExpectedConditions.textToBePresentInElement(pageElement,text) );
	}
	
	public void waitForTextToBeAbsentInElement(By by,
			String text, int timeOutPeriod) {
		WebDriverWait webDriverWait = new WebDriverWait(Page.driver, timeOutPeriod);
    	webDriverWait.pollingEvery(10, TimeUnit.MICROSECONDS);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(by,text) );
	}

	public void WaitForPageLoad(int timeOutPeriod)
	{
		try{
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(Page.driver);
	        fluentWait.pollingEvery(5, TimeUnit.MICROSECONDS);
	        fluentWait.withTimeout(timeOutPeriod, TimeUnit.SECONDS);
	        fluentWait.until(new Predicate<WebDriver>() {
	        	
	        	 public boolean apply(WebDriver driver) {
	        		System.out.println("State "+((JavascriptExecutor)driver).executeScript(
	                 			"return document.readyState"));
	                   return  ((JavascriptExecutor)driver).executeScript(
	                 			"return document.readyState").equals("complete");	
	             }
	         });
	        }catch(Exception e){
	        	System.out.println(e+" Exception");
	        }
	}
	
}
