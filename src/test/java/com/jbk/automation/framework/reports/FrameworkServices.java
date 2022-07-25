package com.jbk.automation.framework.reports;

import org.testng.Reporter;


/**
 * @author Created by SYalavarthi
 */

public class FrameworkServices {
    public static void logMessage(String message) {
        Reporter.log(message);
    }
}