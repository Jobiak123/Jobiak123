package com.jbk.automation.framework.util;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Mark a class or a method as part of the test.
 *
 * @author SYalavarthi
 */

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD, TYPE, CONSTRUCTOR})
public @interface TestdataReader {
	/**
	   * Test data Workbook path 
	   */
	 public  String workBookName()  default "";

 
  
  /**
   * Test data WoorkSheet name 
   */
	 public  String SheetName()  default "";

}
