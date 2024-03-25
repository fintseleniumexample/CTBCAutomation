package com.ctbt.automation.listeners;

import com.ctbt.automation.report.ExtentReportManager;
import com.ctbt.automation.util.TestProperties;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.util.List;

import static com.ctbt.automation.util.Gpt3ApiRequestXMLReader.getOpenAIOpnion;
import static com.ctbt.automation.util.Gpt3ApiRequestXMLReader.getOpnAIResp;

public class CustomTestNGReporter implements IReporter {
    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        ExtentReportManager.endCurrentTest();
        ExtentReportManager.getExtentReports().addSystemInfo(" ", getOpenAIOpnion(TestProperties.getProperty("prompt")));
        // ExtentReportManager.getExtentReports().addSystemInfo(" ", getOpnAIResp(TestProperties.getProperty("prompt")));


        ExtentReportManager.getExtentReports().flush();
    }


}

