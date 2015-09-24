package com.realdolmen.jxp010.dom.exercise;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by EWTAX45 on 24/09/2015.
 */
public class AddDependencyMain {

    public static void main(String[] args) throws  Exception{

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = factory.newDocumentBuilder().parse("./pom.xml");


        Element dependencies = (Element) document.getElementsByTagName("dependencies").item(0);

        Element dependency = document.createElement("dependency");
        Element groupId = document.createElement("groupId");
        Text textNode = document.createTextNode("org.mockito");
        Element artifactId = document.createElement("artifactId");
        Text artifactText = document.createTextNode("mockito-all");
        Element version = document.createElement("version");
        Text versionText = document.createTextNode("1.10.19");


        dependencies.appendChild(dependency);
        dependency.appendChild(groupId);
        groupId.appendChild(textNode);
        dependency.appendChild(artifactId);
        artifactId.appendChild(artifactText);
        dependency.appendChild(version);
        version.appendChild(versionText);


        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer optimusPrimus = transformerFactory.newTransformer();
        optimusPrimus.transform(new DOMSource(document), new StreamResult(System.out));


        }


    //aparte methodes om het mooier te maken :-) (nog niet gebruikt)
    private static Node createExtraDependency(Document document)    {
        Element dependency = document.createElement("dependency");
        dependency.appendChild(createSimpleElemen(document, "artifactId", "org.mockito"));
        dependency.appendChild(createSimpleElemen(document, "groupId", "mockito-all"));
        dependency.appendChild(createSimpleElemen(document, "version", "1.10.19"));
        return dependency;
    }


    private static Element createSimpleElemen(Document document, String artifactId, String value)   {
        Element element = document.createElement(artifactId);
        element.setTextContent(value);
        return element;
    }

    }
