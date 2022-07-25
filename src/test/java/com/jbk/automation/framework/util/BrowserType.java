package com.jbk.automation.framework.util;

/**
 * 
 */

public enum BrowserType {
    FIREFOX("firefox"),
    CHROME("chrome"),
    IE("ie"),
    SAFARI("safari"),
	MicrosoftEdge("MicrosoftEdge");
	 
    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
