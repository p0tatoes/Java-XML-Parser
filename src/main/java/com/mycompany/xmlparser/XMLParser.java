/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.xmlparser;

/**
 *
 * @author mpdeloja
 */
public class XMLParser {

    public static void main(String[] args) {
        MyXMLParser cd_parser = new MyXMLParser();
        cd_parser.parseXML("cd_catalog.xml");

        MyXMLParser plant_parser = new MyXMLParser();
        plant_parser.parseXML("plant_catalog.xml");

        MyXMLParser menu_parser = new MyXMLParser();
        menu_parser.parseXML("food_menu.xml");
    }
}
