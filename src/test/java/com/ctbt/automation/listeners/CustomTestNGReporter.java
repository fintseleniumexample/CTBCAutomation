package com.ctbt.automation.listeners;

import com.ctbt.automation.report.ExtentReportManager;
import com.ctbt.automation.util.TestProperties;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

import static com.ctbt.automation.util.Gpt3ApiRequestXMLReader.getOpenAIOpnion;

public class CustomTestNGReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
       try {
           Thread.sleep(10000);
       }catch (Exception e){

       }
        ExtentReportManager.endCurrentTest();
        ExtentReportManager.getExtentReports().addSystemInfo(" ", getOpenAIOpnion(TestProperties.getProperty("prompt")));
        ExtentReportManager.getExtentReports().flush();
    }
}

