package com.ctbt.automation.util;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringWriter;

public class XMLToStringConverter {

    public static String getXMLString() {
        String xmlString = null;
        try {
            // Specify the path to your XML file
            String filePath = "./reports/testng-results.xml";

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
