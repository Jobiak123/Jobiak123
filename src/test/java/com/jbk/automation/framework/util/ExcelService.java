package com.jbk.automation.framework.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import com.jbk.automation.framework.webdriver.WebDriverBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Created by SYalavarthi
 */

public class ExcelService {

    public Iterator<Object[]> readTestDataFromExcel(String sWorkBookName,String sWorkbookSheetName) {
    	String testDataFolderPath = "C:\\Users\\ADMIN\\eclipse-workspace\\MHAutomationFramework\\TestData";
    			//System.getProperty("user.dir")+"\\"+(String)WebDriverBase.context.getBean("root_folder");
        
        System.out.println(new File(testDataFolderPath).listFiles().length);
        List<HashMap<String, String>> testData = null;
        for (File testDataFile : new File(testDataFolderPath).listFiles()) {
        	System.out.println("testDataFile.getAbsolutePath():::"+testDataFile.getAbsolutePath());
            if (!testDataFile.getAbsolutePath().contains("$")) {
                FileInputStream file = null;
                if(testDataFile.getPath().contains(sWorkBookName)){
                	try {
                    file = new FileInputStream(testDataFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Workbook workBook = null;
                try {
                    workBook = WorkbookFactory.create(file);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
                Sheet testDataSheet = workBook.getSheet(sWorkbookSheetName);
                testData = getTestDataBySheet(testDataSheet);
              
            }
        }
         
        }
        return getIterator(testData);
    }

    
    public Iterator<Object[]> readTestDataFromExcel(String sWorkBookName,String sWorkbookSheetName,String tableName) {
    	String testDataFolderPath = System.getProperty("user.dir")+"\\"+(String)WebDriverBase.context.getBean("root_folder");
        
        System.out.println(new File(testDataFolderPath).listFiles().length);
        List<HashMap<String, String>> testData = null;
        for (File testDataFile : new File(testDataFolderPath).listFiles()) {
        	System.out.println("testDataFile.getAbsolutePath():::"+testDataFile.getAbsolutePath());
            if (!testDataFile.getAbsolutePath().contains("$")) {
                FileInputStream file = null;
                if(testDataFile.getPath().contains(sWorkBookName)){
                	try {
                    file = new FileInputStream(testDataFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Workbook workBook = null;
                try {
                    workBook = WorkbookFactory.create(file);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidFormatException e) {
                    e.printStackTrace();
                }
                Sheet testDataSheet = workBook.getSheet(sWorkbookSheetName);
               testData = getTestDataBySheet(testDataSheet,tableName);
               //testData = getTestData(testDataSheet,tableName,workBook);
            }
        }
         
        }
        return getIterator(testData);
    }
   
    
    
    public List<HashMap<String, String>> getTestDataBySheet(Sheet testDataSheet) {
        List<String> headers = getHeaders(testDataSheet);
        List<HashMap<String, String>> testData = new ArrayList<HashMap<String, String>>();
        for (int i = 1; i < testDataSheet.getPhysicalNumberOfRows(); i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            Row dataRow = testDataSheet.getRow(i);
            Cell dataCell;
            for (int j = 0; j < headers.size(); j++) {
                try {
                    dataCell = dataRow.getCell(j);
                    dataCell.setCellType(Cell.CELL_TYPE_STRING);
                    map.put(headers.get(j), dataCell.getStringCellValue());

                } catch (Exception e) {

                }
            }
            testData.add(map);

        }
        return testData;
    }

    
    public List<HashMap<String, String>> getTestDataBySheet(Sheet testDataSheet,String tableName) {
        List<HashMap<String, String>> testData = new ArrayList<HashMap<String, String>>();
        int startRow,endRow;
        System.out.println("testDataSheet"+testDataSheet);
        startRow= getStartRow(testDataSheet,tableName);
        List<String> headers = getHeaders(testDataSheet,startRow+1);
        endRow=getEndRow(testDataSheet,tableName,startRow);
        for (int i = startRow+2; i < endRow; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            Row dataRow = testDataSheet.getRow(i);
            Cell dataCell;
            for (int j=1;j<headers.size();j++) {
                if(!headers.get(j).equals("CELL NOT FOUND") && !headers.get(j).equals("MISSING CONTENT")){
                try {
                	dataCell = dataRow.getCell(j,Row.RETURN_NULL_AND_BLANK);
                	dataCell.setCellType(Cell.CELL_TYPE_STRING);
                    if(dataCell != null && !("".equals(dataCell.getStringCellValue().trim()))){
                    map.put(headers.get(j), dataCell.getStringCellValue());
                    }
                } catch (Exception e) {
                	e.printStackTrace();
                }
                }
            }
            testData.add(map);

        }
        return testData;
    }

    
    public Iterator<Object[]> getIterator(List<HashMap<String, String>> testDataList) {
        List<Object[]> iteratorList = new ArrayList<Object[]>();
        for (Map<String, String > map : testDataList) {
            iteratorList.add(new Object[]{map});
        }

        return iteratorList.iterator();

    }


    public List<String> getHeaders(Sheet sheet) {

        List<String> headers = new ArrayList<String>();
        Row headerRow = sheet.getRow(0);
        for (int i = 0; i < headerRow.getPhysicalNumberOfCells(); i++) {
            Cell dataCell = headerRow.getCell(i);
            dataCell.setCellType(Cell.CELL_TYPE_STRING);
            headers.add(dataCell.getStringCellValue());
        }
        return headers;

    }

    
    public List<String> getHeaders(Sheet sheet,int row) {

        List<String> headers = new ArrayList<String>();
        Row headerRow = sheet.getRow(row);
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell dataCell = headerRow.getCell(i,Row.RETURN_NULL_AND_BLANK);
            if(dataCell == null)
            	headers.add("CELL NOT FOUND");
            else if("".equals(dataCell.getStringCellValue().trim()))
            	headers.add("MISSING CONTENT");
            else{ 
            dataCell.setCellType(Cell.CELL_TYPE_STRING);
            headers.add(dataCell.getStringCellValue());
            }
        }
        return headers;

    }

    
    private int getEndRow(Sheet testDataSheet, String tableName, int startRow) {
		for (int i=startRow+1 ; i<testDataSheet.getLastRowNum()+1; i++){
			try{
			if(testDataSheet.getRow(i).getCell(0).getStringCellValue().toString().equalsIgnoreCase(tableName))
			return i;
			}catch(Exception e){
				
			}
		}
		return startRow;
	}
    
    
    public int getStartRow(Sheet testDataSheet, String tableName) {
		for (int i=0 ; i<testDataSheet.getLastRowNum()+1; i++){
			try{
				if(testDataSheet.getRow(i).getCell(0).getStringCellValue().toString().equalsIgnoreCase(tableName))
			return i;
			}catch(Exception e){
			}
		}
		return 0;
	}
	
   
}
