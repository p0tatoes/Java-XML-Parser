/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xmlparser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author mpdeloja
 */
public class MyXMLParser {

    /**
     *
     * @param fileName - String. name of the XML file to be parsed.
     *
     * For the sake of convenience, XML files should be placed on the project's
     * root directory
     *
     * Prints out the values inside the XML file in a tabular form
     */
    public void parseXML(String fileName) {
        try {
            File readFile = new File(fileName);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document readDoc = docBuilder.parse(readFile);

            /**
             * Retrieves and prints out the name of the first child node of the
             * document element, serves as the description for the read file
             */
            String description = readDoc.getDocumentElement().getChildNodes().item(1).getNodeName();
            System.out.printf("\n\nDescription: %s\n\n", description);

            /**
             * Retrieves and prints out the node names for the elements
             * containing information, serves as the column headers
             */
            NodeList colHeaders = readDoc.getElementsByTagName(description).item(1).getChildNodes();
            for (int i = 0; i < colHeaders.getLength(); i++) {
                Node colHeader = colHeaders.item(i);

                if (colHeader.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.printf("%-90s", colHeader.getNodeName());
                }
            }
            System.out.println(); // Prints out at empty lines; server as carriage return or line break

            /**
             * Prints out the relevant information inside the node elements
             */
            NodeList information = readDoc.getElementsByTagName(description);
            for (int i = 0; i < information.getLength(); i++) { // Iterates through all information entries (nodes)
                Node information_entry = information.item(i);
                NodeList information_fields = information_entry.getChildNodes();

                for (int j = 0; j < information_fields.getLength(); j++) { // Iterates through each information fields (elements)
                    Node field_value = information_fields.item(j);
                    if (field_value.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.printf("%-90s", field_value.getTextContent());
                    }
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
