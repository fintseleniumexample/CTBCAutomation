package com.ctbt.automation.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.StringWriter;

public class XMLToStringConverter {

    public static String getXMLString() {
        String xmlString = null;
        try {
            // Specify the path to your XML file

            String filePath = "./reports/testng-results.xml";
            waitForResultsFile(filePath);
            // Read XML file into a Document object
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);

            // Convert Document to String
             xmlString = convertDocumentToString(document);

            // Print the resulting XML string
         //   System.out.println(xmlString);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlString;
    }
    private static void waitForResultsFile(String filePath) {
        final String RESULTS_FILE_PATH = filePath; // Adjust the path as per your configuration
        final int MAX_RETRIES = 10;
        final long RETRY_INTERVAL_MS = 5000; // Retry interval in milliseconds

        File resultsFile = new File(RESULTS_FILE_PATH);
        int retryCount = 0;

        while (!resultsFile.exists() && retryCount < MAX_RETRIES) {
            try {
                Thread.sleep(RETRY_INTERVAL_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            retryCount++;
        }

        if (!resultsFile.exists()) {
            System.err.println("Results XML file not generated after maximum retries.");
        }
    }
    private static String convertDocumentToString(Document document) {
        try {
            // Use StringWriter to convert Document to String
            StringWriter stringWriter = new StringWriter();
            javax.xml.transform.TransformerFactory transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(new javax.xml.transform.dom.DOMSource(document), new javax.xml.transform.stream.StreamResult(stringWriter));

            return stringWriter.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
