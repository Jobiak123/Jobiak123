package atu.testng.reports.listeners;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.testng.ISuite;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.jbk.automation.framework.util.Reporter;
import atu.testng.reports.enums.Colors;
import atu.testng.reports.enums.ReportLabels;
import atu.testng.reports.excel.ExcelReports;
import atu.testng.reports.utils.Attributes;
import atu.testng.reports.utils.Directory;
import atu.testng.reports.utils.SettingsFile;
import atu.testng.reports.writers.ConsolidatedReportsPageWriter;
import atu.testng.reports.writers.HTMLDesignFilesJSWriter;
import atu.testrecorder.ATUTestRecorder;

public class ATUReportsListenerExt extends ATUReportsListener {
	
	public ATUReportsListenerExt() {
		super.runCount = 1;
	}

	
	private ATUTestRecorder recorder;

	@Override
	public void generateReport(List<XmlSuite> paramList,
			List<ISuite> paramList1, String paramString) {
		Iterator<ISuite> localIterator = paramList1.iterator();
		while (localIterator.hasNext()) {
			ISuite localISuite = (ISuite) localIterator.next();
			Attributes.setSuiteNameMapper(localISuite.getName());
			startCreatingDirs(localISuite);
			onFinish();
		}

		
	}
	
	public static void pieChartJS(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
		try {
			PrintWriter localPrintWriter = new PrintWriter(Directory.RESULTSDir + Directory.SEP + Directory.RUNName
					+ paramInt4 + Directory.SEP + "pieChart.js");
			localPrintWriter.println("$(document).ready(function() {\n    var data = [['" + ReportLabels.PASS.getLabel()
					+ "', " + paramInt1 + "], ['" + ReportLabels.FAIL.getLabel() + "', " + paramInt2 + "], ['"
					+ ReportLabels.SKIP.getLabel() + "', " + paramInt3 + "]];\n"
					+ "    jQuery.jqplot('chart', [data],\n" + "            {seriesColors: [\"" + Colors.PASS.getColor()
					+ "\", \"" + Colors.FAIL.getColor() + "\", \"" + Colors.SKIP.getColor() + "\"],\n"
					+ "                seriesDefaults: {\n" + "                    // Make this a pie chart.\n"
					+ "                    renderer: jQuery.jqplot.PieRenderer,\n"
					+ "                    rendererOptions: {\n" + "                        padding: 15,\n"
					+ "                        sliceMargin: 1,\n"
					+ "                        // Put data labels on the pie slices.\n"
					+ "                        // By default, labels show the percentage of the slice.\n"
					+ "                        showDataLabels: true\n" + "                    }\n"
					+ "                },\n" + "                grid: {borderColor: '#cccccc', background: '#ffffff',\n"
					+ "                    borderWidth: 0, // pixel width of border around grid.\n"
					+ "                    shadow: false // draw a shadow for grid.\n" + "                },\n"
					+ "                legend: {show: true, location: 'e'}\n" + "            }\n" + "    );\n" + "});");
			localPrintWriter.close();
		} catch (FileNotFoundException localFileNotFoundException) {
			localFileNotFoundException.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult paramITestResult) {
		this.failedTests.add(paramITestResult);
	}

	@Override
	public void onFinish() {
		try {

			List<ITestResult> passedTests1 = new CopyOnWriteArrayList<ITestResult>(this.passedTests);
			List<ITestResult> failedTests1 = new CopyOnWriteArrayList<ITestResult>(this.failedTests);

			for(ITestResult it: passedTests1){
				Set<String> att1 = it.getAttributeNames();
				if(att1.size()<=7)
				{
				passedTests1.remove(it);
				}
			}
			for(ITestResult it: failedTests1){
				Set<String> att2 = it.getAttributeNames();
				if(att2.size()<=6)
				{
					failedTests1.remove(it);
				}
			}
			String str1 = SettingsFile.get("passedList")
					+ passedTests1.size() + ';';
			String str2 = SettingsFile.get("failedList")
					+ failedTests1.size() + ';';
			String str3 = SettingsFile.get("skippedList")
					+ this.skippedTests.size() + ';';
			SettingsFile.set("passedList", str1);
			SettingsFile.set("failedList", str2);
			SettingsFile.set("skippedList", str3);
			setTickInterval(passedTests1, failedTests1,
					this.skippedTests);
			// HTMLDesignFilesJSWriter.lineChartJS(str1, str2, str3, 1);
			HTMLDesignFilesJSWriter.barChartJS(str1, str2, str3, 1);
			pieChartJS(passedTests1.size(),failedTests1.size(), this.skippedTests.size(), 1);
			generateIndexPage();
			long l = ((Long) Attributes.getAttribute("startExecution"))
					.longValue();
			generateConsolidatedPage();
			generateCurrentRunPage(passedTests1, failedTests1,
					this.skippedTests, l, System.currentTimeMillis());
			startReportingForPassed(passedTests1);
			startReportingForFailed(failedTests1);
			startReportingForSkipped(this.skippedTests);
			if (Directory.generateExcelReports) {
				ExcelReports.generateExcelReport(Directory.RUNDir
						+ Directory.SEP + "(" + Directory.REPORTSDIRName + ") "
						+ Directory.RUNName + 1 + ".xlsx", passedTests1,
						failedTests1, this.skippedTests);
			}
			if (Directory.generateConfigReports) {
				ConfigurationListener.startConfigurationMethodsReporting(1);
			}
		}

		catch (NullPointerException localException) {
			// System.exit(0);
		}

		catch (Exception localException) {
			throw new IllegalStateException(localException);
			// localException.printStackTrace();
		}
	}

	
	public void onExecutionStart() {
		try {
			// File reportsFolder = new File("E:\\Reports");
			File reportsFolder = new File(System.getProperty("user.dir")
					+ "\\Reports\\"
					+ Reporter.getDateFormat(Reporter.vDatetype1));
			System.out.println("@@@@@@=" + reportsFolder);
			System.out.println("@@@@@@11111=" + reportsFolder.exists());
			reportsFolder.mkdir();
			createAtuConfigPropFile(reportsFolder.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initChecking();
	}

	private void createAtuConfigPropFile(String filePath) {
		try {
			Properties properties = new Properties();
			properties.setProperty("atu.reports.dir", filePath.toString());
			properties.setProperty("atu.proj.header.text",
					"MH Automation Project Reports");
			properties.setProperty("atu.proj.header.logo",
					System.getProperty("user.dir")
							+ "\\ProjectLogos\\JbkLogo.png");
			properties.setProperty("atu.proj.description",
					"Project Testing Reports");
			properties.setProperty("atu.reports.takescreenshot", "true");
			properties.setProperty("atu.reports.configurationreports", "false");
			properties.setProperty("atu.reports.excel", "false");
			properties.setProperty(
					"atu.reports.continueExecutionAfterStepFailed", "false");
			properties.setProperty("atu.reports.recordExecution", "none");
			properties.setProperty("atu.reports.setMaxRuns", "100");
			properties.setProperty("atu.reports.pdf", "false");

			File file = new File(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\atu.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, "config properties ");
			fileOut.close();

			System.setProperty("atu.reporter.config", file.getAbsolutePath());

			Attributes.setAttribute("startExecution",
					Long.valueOf(System.currentTimeMillis()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	private void initChecking() {
		try {

			Directory.verifyRequiredFiles();
			SettingsFile.correctErrors();
			this.runCount = 1; // (Integer.parseInt(SettingsFile.get("run").trim())
								// + 1);
			SettingsFile.set("run", "" + this.runCount);
			Directory.RUNDir += this.runCount;
			Directory.mkDirs(Directory.RUNDir);
			if (Directory.recordSuiteExecution) {
				try {
					recorder = new ATUTestRecorder(Directory.RUNDir,
							"ATU_CompleteSuiteRecording",
							Boolean.valueOf(false));
					recorder.start();
				} catch (Throwable localThrowable) {
					throw new IllegalStateException(localThrowable);
				}
			}
		} catch (Exception localException) {
			throw new IllegalStateException(localException);
		}
	}

	@Override
	public void generateConsolidatedPage() {
		PrintWriter localPrintWriter = null;
		try {
			localPrintWriter = new PrintWriter(Directory.RESULTSDir
					+ Directory.SEP + "ConsolidatedPage.html");
			ConsolidatedReportsPageWriter.header(localPrintWriter);
			ConsolidatedReportsPageWriter.menuLink(localPrintWriter,
					this.runCount);
			content(localPrintWriter);
			ConsolidatedReportsPageWriter.footer(localPrintWriter);
			return;
		} catch (FileNotFoundException localFileNotFoundException) {
			localFileNotFoundException.printStackTrace();
		} finally {
			try {
				localPrintWriter.close();
			} catch (Exception localException3) {
				localPrintWriter = null;
			}
		}
	}

	public static void content(PrintWriter paramPrintWriter) {
		paramPrintWriter
				.println("<td id=\"content\">\n\n                    <div id=\"tabs\">\n                        <ul>\n                            <li><a href=\"#tabs-2\">Bar Chart</a></li>      \n                        </ul>\n                        <div id=\"tabs-2\" style=\"text-align: left;\">\n                            <p class=\"info\" style=\"text-align: center;color: black;font-size: 14px\">\n                                The following Bar chart demonstrates the number of Passed, Failed and Skipped Test Cases\n </p>\n                            <div id=\"bar\" style=\"margin-top:20px; margin-left:20px; width:85%; height:300px;color:black;\"></div>\n                        </div>    \n                    </div> \n                </td>\n            </tr>");
	}

}
