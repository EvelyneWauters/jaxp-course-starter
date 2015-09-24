package com.realdolmen.jxp010.dom.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by EWTAX45 on 24/09/2015.
 */
public class DomMain {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse("./pom.xml");

            //nu mijzelf positioneren in de boom waar de dependencies zitten
            Element dependencies = (Element) document.getElementsByTagName("dependency").item(0);
            String attributeId = dependencies
                    .getElementsByTagName("artifactId").item(0)
                    .getTextContent();

            System.out.println(attributeId);


        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
